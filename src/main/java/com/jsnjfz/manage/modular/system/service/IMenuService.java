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
package com.jsnjfz.manage.modular.system.service;

import com.jsnjfz.manage.modular.system.model.Menu;
import com.jsnjfz.manage.core.common.node.MenuNode;
import com.jsnjfz.manage.core.common.node.ZTreeNode;
import com.jsnjfz.manage.modular.system.model.Menu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 菜单服务
 *
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 删除菜单
     *
     */
    void delMenu(Long menuId);

    /**
     * 删除菜单包含所有子菜单
     *
     */
    void delMenuContainSubMenus(Long menuId);

    /**
     * 根据条件查询菜单
     *
     */
    List<Map<String, Object>> selectMenus(String condition, String level);

    /**
     * 根据条件查询菜单
     *
     */
    List<Long> getMenuIdsByRoleId(Integer roleId);

    /**
     * 获取菜单列表树
     *
     * @return
     */
    List<ZTreeNode> menuTreeList();

    /**
     * 获取菜单列表树
     *
     * @return
     */
    List<ZTreeNode> menuTreeListByMenuIds(List<Long> menuIds);

    /**
     * 删除menu关联的relation
     *
     * @param menuId
     * @return
     */
    int deleteRelationByMenu(Long menuId);

    /**
     * 获取资源url通过角色id
     *
     * @param roleId
     * @return
     */
    List<String> getResUrlsByRoleId(Integer roleId);

    /**
     * 根据角色获取菜单
     *
     * @param roleIds
     * @return
     */
    List<MenuNode> getMenusByRoleIds(List<Integer> roleIds);
}
