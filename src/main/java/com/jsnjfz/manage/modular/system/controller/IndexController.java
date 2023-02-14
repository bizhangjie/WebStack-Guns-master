/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jsnjfz.manage.modular.system.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import com.jsnjfz.manage.core.common.exception.BizExceptionEnum;
import com.jsnjfz.manage.core.common.node.MenuNode;
import com.jsnjfz.manage.modular.system.dao.CommentMapper;
import com.jsnjfz.manage.modular.system.model.Category;
import com.jsnjfz.manage.modular.system.model.Comment;
import com.jsnjfz.manage.modular.system.model.Site;
import com.jsnjfz.manage.modular.system.service.impl.CategoryServiceImpl;
import com.jsnjfz.manage.modular.system.service.impl.CommentServiceImpl;
import com.jsnjfz.manage.modular.system.service.impl.NoticeServiceImpl;
import com.jsnjfz.manage.modular.system.service.impl.SiteServiceImpl;
import com.jsnjfz.manage.modular.system.warpper.NoticeWrapper;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author bizhangjie
 * 首页控制器
 */
@Controller
public class IndexController extends BaseController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private SiteServiceImpl siteService;

    @Autowired
    private NoticeServiceImpl noticeService;

    @Autowired
    private CommentServiceImpl commentService;

    private String ip = "http://127.0.0.1:8000/";

    /**
     * 跳转到首页
     */
    @RequestMapping("/")
    public String index(Model model) {
        List<MenuNode> menus = categoryService.getCatogryNode(new HashMap<>());
        List<MenuNode> titles = MenuNode.buildTitle(menus);
        List<Category> categorySiteList = categoryService.getCatogrySite(null);
        model.addAttribute("categorySiteList", categorySiteList);
        model.addAttribute("titles", titles);
        model.addAttribute("ip", "");

        System.out.println(titles);
        return "/new_index.html";
    }

    @RequestMapping("/categorylist")
    @ResponseBody
    public Object categorylist(){
        List<Category> categorylist = categoryService.getCatogrySite(null);
        return categorylist;
    }

    @RequestMapping("/commentList")
    @ResponseBody
    public Object commentList(){
        Map map = new HashMap();
        map.put("httpReferer","/sites/10");
        List<Comment> commentList = commentService.getCommentList(map);
        return commentList;
    }

    /**
     * 跳转到关于页面
     */
    @RequestMapping("/about")
    public String about(Model model) {
        return "/about.html";
    }

    /**
     * 跳转到详情页
     */
    @RequestMapping("/sites/{id}")
    public String sites(Model model, @PathVariable Integer id) {
        List<MenuNode> menus = categoryService.getCatogryNode(new HashMap<>());
        List<MenuNode> titles = MenuNode.buildTitle(menus);
        List<Site> sites = siteService.getListByid(id);
        model.addAttribute("titles", titles);
        model.addAttribute("sites", sites);
        model.addAttribute("ip", ip);

        Site site = siteService.get(id);

        if (ToolUtil.isEmpty(site) || site.getId() == null) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        System.out.println("=======================================> num1 = " + site.getNum());
        Integer num = site.getNum() + 1;
        site.setNum(num);
        siteService.saveOrUpdate(site,site.getId());
        System.out.println("=======================================> num2 = " + site.getNum());
        model.addAttribute("views",num);
        model.addAttribute("site",site);
        Integer PostId = commentService.getPost(null);
        model.addAttribute("PostId",PostId);

//        评论
        Map map = new HashMap();
        map.put("httpReferer","/sites/" + id);
        List<Comment> commentList = commentService.getCommentList(map);
        model.addAttribute("commentList",commentList);
        Integer count = commentService.getTotalCount(map);
        model.addAttribute("count",count);

        return "/sites.html";
    }

    /**
     * favorites 跳转分类页
     */
    @RequestMapping("/favorites/{name}")
    public String favorites(Model model, @PathVariable String name) {
        List<MenuNode> menus = categoryService.getCatogryNode(new HashMap<>());
        List<MenuNode> titles = MenuNode.buildTitle(menus);
        List<Site> site = siteService.getTile(name);
        model.addAttribute("ip", ip);

        model.addAttribute("titles", titles);
        model.addAttribute("sites", site);
        model.addAttribute("title", name);
        System.out.println(site);
        return "/favorites.html";
    }

    @RequestMapping(value = "/ceshi", method = RequestMethod.POST)
    @ResponseBody
    public List<MenuNode> love(String id) {

        List<MenuNode> menus = categoryService.getCatogryNode((new HashMap<>()));
        List<MenuNode> titles = MenuNode.buildTitle(menus);
        System.err.println(id);

        return titles;
    }

    @RequestMapping(value = "/reqPost", method = RequestMethod.POST)
    public void fun5(int a) {
        System.out.println("requestMappingPost..." + a);

    }

    @RequestMapping("/liuyan")
    public String liuyan(Model model,String condition){
        List<MenuNode> menus = categoryService.getCatogryNode(new HashMap<>());
        List<MenuNode> titles = MenuNode.buildTitle(menus);

        // 留言列表
        Map map = new HashMap();
        List<Comment> commentList = commentService.getCommentList(null);
        model.addAttribute("commentList",commentList);

        Integer PostId = commentService.getPost(null);
        model.addAttribute("PostId",PostId);
        Integer count = commentService.getTotalCount(null);
        model.addAttribute("count",count);

        // 留言通知
        List<Map<String, Object>> list = noticeService.list(condition);
        model.addAttribute("notices",super.warpObject(new NoticeWrapper(list)));

        model.addAttribute("ip", ip);
        model.addAttribute("titles", titles);

        return "/liuyan.html";
    }




    /**
     * 获取通知列表
     */
    @RequestMapping(value = "/liuyanNotice")
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>> list = noticeService.list(condition);
        return super.warpObject(new NoticeWrapper(list));
    }

}
