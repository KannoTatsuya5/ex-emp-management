package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Administrator;
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

    /**
     * ログイン画面に遷移する.
     * @return ログイン画面
     */
    @GetMapping({"/login","/login/"})
    public String login() {
        return "administrator/login";
    }

    /**
     * 管理者情報を登録する.
     * @param form
     * @return ログイン画面
     */
    @PostMapping({"/insert","/insert/"})
    public String insert(InsertAdministratorForm form) {
        Administrator administrator = new Administrator();
        BeanUtils.copyProperties(form, administrator);
        administratorService.insert(administrator);
        return "redirect:/administrator/login";
    }
}
