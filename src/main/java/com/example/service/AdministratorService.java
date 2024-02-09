package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Administrator;
import com.example.repository.AdministratorRepository;

@Service
@Transactional
public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;

    /**
     * administratorRepositoryクラスのinsertメソッドを呼び出す.
     * 
     * @param administrator
     */
    public void insert(Administrator administrator) {
        administratorRepository.insert(administrator);
    }

    /**
     * administratorRepositoryクラスのfindByMailAddressAndPasswordメソッドを呼び出す.
     * @param mailAddress
     * @param password
     * @return 管理者情報
     */
    public Administrator login(String mailAddress, String password) {
        Administrator administrator = administratorRepository.findByMailAddressAndPassword(mailAddress, password);
        return administrator;
    }
}
