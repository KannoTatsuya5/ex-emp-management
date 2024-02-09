package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Administrator;
import com.example.form.InsertAdministratorForm;
import com.example.form.LoginForm;
import com.example.service.AdministratorService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/administrator")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private HttpSession session;

    /**
     * 管理者登録機能.
     * 
     * @param form
     * @return 管理者登録画面
     */
    @GetMapping({ "/toInsert", "/toInsert/" })
    public String toInsert(InsertAdministratorForm form) {
        return "administrator/insert";
    }

    /**
     * ログイン画面に遷移する.
     * 
     * @return ログイン画面
     */
    @GetMapping({ "/login", "/login/" })
    public String toLogin(LoginForm form) {
        return "administrator/login";
    }

    /**
     * 管理者情報を登録する.
     * 
     * @param form
     * @return ログイン画面
     */
    @PostMapping({ "/insert", "/insert/" })
    public String insert(InsertAdministratorForm form) {
        Administrator administrator = new Administrator();
        BeanUtils.copyProperties(form, administrator);
        administratorService.insert(administrator);
        return "redirect:/administrator/toLogin";
    }

    /**
     * ログインする処理.
     * 
     * @param form
     * @param model
     * @return 従業員一覧へ遷移
     */
    @PostMapping({ "/login", "/login/" })
    public String login(LoginForm form, Model model) {
        
        Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());
        if (administrator == null) {
            model.addAttribute("message", "メールアドレスまたはパスワードが不正です");
            return "administrator/login";
        }

        session.setAttribute("administratorName", administrator.getName());

        return "redirect:/employee/showList";
    }
}
