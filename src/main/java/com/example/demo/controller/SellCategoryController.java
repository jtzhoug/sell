package com.example.demo.controller;


import com.example.demo.dataObject.ProductCategory;
import com.example.demo.enums.CategoryStatusEnum;
import com.example.demo.exception.SellException;
import com.example.demo.form.CategoryForm;
import com.example.demo.repository.ProductCategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/category")
public class SellCategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductCategoryRepository repository;

    @RequestMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        // List<ProductCategory> productCategoryList = categoryService.findAll();
        List<ProductCategory> productCategoryList = repository.findByCategory(CategoryStatusEnum.FOOD.getCode());
        map.put("categoryList", productCategoryList);
        return new ModelAndView("category/list", map);
    }

    @RequestMapping("/clist")
    public ModelAndView clist(Map<String,Object> map){
        List<ProductCategory> productCategoryList = repository.findByCategory(CategoryStatusEnum.CLOTH.getCode());
        map.put("categoryList",productCategoryList);
        return new ModelAndView("category/clist",map);
    }

    @RequestMapping("/modify")
    public ModelAndView modify(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                               Map<String, Object> map) {
        if (categoryId != null) {
            ProductCategory category = categoryService.findOne(categoryId);
            map.put("category", category);
        }
        return new ModelAndView("/category/modify", map);
    }

    @RequestMapping("/cmodify")
    public ModelAndView cmodify(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                               Map<String, Object> map) {
        if (categoryId != null) {
            ProductCategory category = categoryService.findOne(categoryId);
            map.put("category", category);
        }
        return new ModelAndView("/category/cmodify", map);
    }

    //保存餐品
    @RequestMapping("/save")
    public ModelAndView save(@Valid CategoryForm categoryForm, BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/list");
            return new ModelAndView("/common/error", map);
        }
        ProductCategory category = new ProductCategory();
        categoryForm.setCategory(CategoryStatusEnum.FOOD.getCode());
        try {
            if (categoryForm.getCategoryId() != null) {
                category = categoryService.findOne(categoryForm.getCategoryId());
            }
            BeanUtils.copyProperties(categoryForm, category);
            categoryService.save(category);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/category/list");
            return new ModelAndView("/common/error",map);
        }
        map.put("url","/sell/seller/category/list");
        return new ModelAndView("/common/success",map);
    }

    //保存衣物
    @RequestMapping("/csave")
    public ModelAndView csave(@Valid CategoryForm categoryForm, BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/clist");
            return new ModelAndView("/common/error", map);
        }
        ProductCategory category = new ProductCategory();
        categoryForm.setCategory(CategoryStatusEnum.CLOTH.getCode());
        try {
            if (categoryForm.getCategoryId() != null) {
                category = categoryService.findOne(categoryForm.getCategoryId());
            }
            BeanUtils.copyProperties(categoryForm, category);
            categoryService.save(category);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/category/clist");
            return new ModelAndView("/common/error",map);
        }
        map.put("url","/sell/seller/category/clist");
        return new ModelAndView("/common/success",map);
    }
}
