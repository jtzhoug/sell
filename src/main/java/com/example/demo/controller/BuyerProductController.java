package com.example.demo.controller;

import com.example.demo.VO.ProductInfoVO;
import com.example.demo.VO.ProductVO;
import com.example.demo.VO.ResultVO;
import com.example.demo.dataObject.CproductInfo;
import com.example.demo.dataObject.ProductCategory;
import com.example.demo.dataObject.ProductInfo;
import com.example.demo.service.CategoryService;
import com.example.demo.service.CproductService;
import com.example.demo.service.Productservice;
import com.example.demo.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private Productservice productservice;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CproductService cproductService;

    @GetMapping("/list")
    public ResultVO list() {
        //        1。查询所有上架商品

        List<ProductInfo> productInfoList = productservice.findUpAll();

        List<CproductInfo> cproductInfoList = cproductService.findUpAll();
        //        2.查询类目
        List<Integer> categoryTypeList = new ArrayList<>();

        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }

        for (CproductInfo cproductInfo : cproductInfoList){
            categoryTypeList.add(cproductInfo.getCategoryType());
        }
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
//        3.数据拼接
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            for (CproductInfo cproductInfo : cproductInfoList){
                if (cproductInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(cproductInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        ResultVO resultVO = new ResultVO();
        resultVO.setData(productVOList);
        resultVO.setCode(ResultVOUtil.success().getCode());
        resultVO.setMsg(ResultVOUtil.success().getMsg());
        return resultVO;

    }

    @GetMapping("/clist")
    public ResultVO clist() {
        //        1。查询所有上架商品

        List<CproductInfo> cproductInfoList = cproductService.findUpAll();
        //        2.查询类目
        List<Integer> categoryTypeList = new ArrayList<>();

        for (CproductInfo productInfo : cproductInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
//        3.数据拼接
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (CproductInfo productInfo : cproductInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        ResultVO resultVO = new ResultVO();
        resultVO.setData(productVOList);
        resultVO.setCode(ResultVOUtil.success().getCode());
        resultVO.setMsg(ResultVOUtil.success().getMsg());
        return resultVO;

    }


}
