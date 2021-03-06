package com.example.demo.dataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
public class ProductCategory {


//    类目Id
    @Id
    @GeneratedValue
    private Integer categoryId;

//    类目名字
    private String categoryName;

//    类目编号
    private Integer categoryType;

//    创建时间
    private Date createTime;

//    更新时间
    private Date updateTime;

    private Integer category;

    public ProductCategory() {
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public ProductCategory(String categoryName, Integer categoryType,Integer category) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.category = category;
    }
}
