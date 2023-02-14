package com.jsnjfz.manage.modular.system.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import com.baomidou.mybatisplus.plugins.Page;
import com.jsnjfz.manage.core.common.constant.factory.PageFactory;
import com.jsnjfz.manage.core.common.exception.BizExceptionEnum;

import com.jsnjfz.manage.core.common.page.PageInfoBT;
import com.jsnjfz.manage.core.util.Pager;
import com.jsnjfz.manage.modular.system.model.Comment;
import com.jsnjfz.manage.modular.system.service.impl.CategoryServiceImpl;
import com.jsnjfz.manage.modular.system.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.Map;

/**
 * 我的小窝
 *
 *
 */

@Controller
@RequestMapping("home")
public class HomeController extends BaseController{

    private static String PREFIX = "/system/home/";

    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private CategoryServiceImpl categoryService;

    /**
     * 跳转到我的小窝页面
     */
    @RequestMapping("")
    public String index(){return PREFIX + "home.html";}


    /**
     * 获取评论列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String comment) {
        Map map = new HashMap();
        map.put("comment",comment);
        Page<Comment> page = new PageFactory<Comment>().defaultPage();
        Pager<Comment> pages = commentService.getPage(map, page.getOffset(), page.getLimit());
        page.setTotal(pages.getTotal());
        page.setRecords(pages.getList());
        return new PageInfoBT<>(page);
    }

    /**
     *  跳转到添加评论
     */
    @RequestMapping("/comment_add")
    public String homeAdd(){ return PREFIX + "comment_add.html"; }


    /**
     *  新增评论接口
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object add(Comment comment){
        commentService.saveOrUpdate(comment,"");
        return SUCCESS_TIP;
    }

    /**
     * 跳转到修改评论
     */
    @RequestMapping("/comment_update/{id}")
    public String commentUpdate(@PathVariable Integer id, Model model){
        Comment comment = commentService.get(id);
        model.addAttribute(comment);
        return PREFIX + "comment_edit.html";
    }

    /**
     *  修改评论接口
     */
    @RequestMapping("/update")
    @ResponseBody
    public Object update(Comment comment){
        if (ToolUtil.isEmpty(comment) || comment.getId() == null){
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        commentService.saveOrUpdate(comment, comment.getId());
        return SUCCESS_TIP;
    }

    /**
     *  删除评论
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer id){
        commentService.delete(id);
        return SUCCESS_TIP;
    }

}
