package com.example.demo.repository;

import com.example.demo.dataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findOne(2);
        System.out.println(productCategory.toString());
    }

    @Test
//    @Transactional
    public void saveOneTest(){
        ProductCategory productCategory = new ProductCategory("girl",23,1);

        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void updateOneTest(){
        ProductCategory productCategory = repository.findOne(3);
        productCategory.setCategoryType(4);

        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeIn(){

        List<Integer> list = Arrays.asList(2,3,4);

        List<ProductCategory> result = repository.findByCategoryTypeIn(list);

        Assert.assertNotEquals(0,result.size());
    }
}
