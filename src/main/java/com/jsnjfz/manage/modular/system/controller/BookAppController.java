package com.jsnjfz.manage.modular.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookapp")
public class BookAppController {

    private static String PREFIX = "/system/bookapp/";

    /**
     * 跳转到图书APP管理
     */
    @RequestMapping("")
    public String index(){return PREFIX + "bookapp.html";}
}

