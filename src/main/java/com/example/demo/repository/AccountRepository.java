package com.example.demo.repository;

import com.example.demo.dataObject.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account,Long>{
        public Optional<Account> findByUsername(String username);
}
