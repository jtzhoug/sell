package com.example.demo.controller;

import com.example.demo.dataObject.CproductInfo;
import com.example.demo.dataObject.ProductCategory;
import com.example.demo.enums.CategoryStatusEnum;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.form.ProductForm;
import com.example.demo.repository.ProductCategoryRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.CproductService;
import com.example.demo.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/cproduct")
public class SellCproductController {


    @Autowired
    private CproductService cproductService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductCategoryRepository repository;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "3") Integer size,
                             Map<String, Object> map) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<CproductInfo> productInfoPage = cproductService.findAll(request);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("/product/clist", map);
    }

    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        try {
            cproductService.onSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/cproduct/list");
            return new ModelAndView("/common/error", map);
        }
        map.put("msg", ResultEnum.PRODUCT_ONSALE_SUCCESS.getMessage());
        map.put("url", "/sell/seller/cproduct/list");
        return new ModelAndView("/common/success", map);
    }

    @RequestMapping("off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                                Map<String, Object> map) {
        try {
            cproductService.offSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/cproduct/list");
            return new ModelAndView("/common/error", map);
        }
        map.put("msg", ResultEnum.PRODUCT_OFFSALE_SUCCESS.getMessage());
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("/common/success", map);
    }

    @RequestMapping("/modify")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                              Map<String, Object> map) {
        if (!StringUtils.isEmpty(productId)) {
            CproductInfo  cproductInfo = cproductService.findOne(productId);
            map.put("productInfo",cproductInfo);
        }

//        查询所有类目
        List<ProductCategory> categoryList = repository.findByCategory(CategoryStatusEnum.CLOTH.getCode());
        map.put("categoryList",categoryList);
        return new ModelAndView("/product/cmodify",map);
    }

    //    保存更新
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm productForm, BindingResult bindingResult,
                             Map<String ,Object> map){
        if (bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/cproduct/cmodify");
            return new ModelAndView("/common/error",map);
        }
        CproductInfo cproductInfo = new CproductInfo();
        try{
            if(!StringUtils.isEmpty(productForm.getProductId())){
                cproductInfo=cproductService.findOne(productForm.getProductId());
            }
            else{
                productForm.setProductId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(productForm,cproductInfo);
            cproductService.save(cproductInfo);
        } catch(SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/cproduct/modify");
            return new ModelAndView("/common/error",map);
        }
        map.put("url","/sell/seller/cproduct/list");
        return new ModelAndView("/common/success",map);
    }



}
