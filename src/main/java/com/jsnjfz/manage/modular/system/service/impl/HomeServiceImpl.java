package com.jsnjfz.manage.modular.system.service.impl;

import com.jsnjfz.manage.core.util.Pager;
import com.jsnjfz.manage.modular.system.dao.SiteMapper;
import com.jsnjfz.manage.modular.system.model.Site;
import com.jsnjfz.manage.modular.system.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HomeServiceImpl extends BaseService<Site> {

    @Autowired
    private SiteMapper siteMapper;

    public static Pager<Site> pager = null;

    /**
     * 分页处理
     */
    public Pager<Site> getPage(Map<String, Object> map, Integer pageNo, Integer size) {
        if (map == null) {
            if (pager != null) {
                return pager;
            }
            map = new HashMap<>();
        }
        int total = siteMapper.getTotalCount(map);
        Pager<Site> page = new Pager<>(total, pageNo, size);
        map.put("offset", pageNo);
        map.put("size", size);
        page.setList(siteMapper.getList(map));
        if (pager == null) {
            pager = page;
        }
        return page;
    }

}
