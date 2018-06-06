package com.example.demo.repository;

import com.example.demo.dataObject.CproductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CproductInfoRepository extends JpaRepository<CproductInfo,String>{

    List<CproductInfo> findByProductStatus(Integer productStatus);
}
