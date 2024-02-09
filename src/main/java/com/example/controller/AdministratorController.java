package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.InsertAdministratorForm;
import com.example.service.AdministratorService;

@Controller
@RequestMapping("/administrator")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;
    
    /**
     * 管理者登録機能.
     * @param form
     * @return 管理者登録画面
     */
    @GetMapping({"/toInsert","/toInsert/"})
    public String toInsert(InsertAdministratorForm form) {
        
        return "administrator/insert";
    }
}
