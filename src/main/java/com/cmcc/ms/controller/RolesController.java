package com.cmcc.ms.controller;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmcc.ms.common.utils.JSONUtils;
import com.cmcc.ms.common.utils.PinyinUtils;
import com.cmcc.ms.common.utils.SessionUtils;
import com.cmcc.ms.common.utils.StringUtil;
import com.cmcc.ms.entity.system.CheckedNode;
import com.cmcc.ms.entity.system.Node;
import com.cmcc.ms.entity.system.OperateLog;
import com.cmcc.ms.entity.system.SysMenus;
import com.cmcc.ms.entity.system.SysMenusExample;
import com.cmcc.ms.entity.system.SysRoles;
import com.cmcc.ms.entity.system.SysRolesExample;
import com.cmcc.ms.entity.system.SysRolesManual;
import com.cmcc.ms.entity.system.SysUsers;
import com.cmcc.ms.entity.system.SysUsersExample;
import com.cmcc.ms.entity.system.SysUsersExample.Criteria;
import com.cmcc.ms.entity.system.TreeNode;
import com.cmcc.ms.entity.system.TreeSupport;
import com.cmcc.ms.mapper.SysMenusMapper;
import com.cmcc.ms.mapper.SysRolesMapper;
import com.cmcc.ms.mapper.SysUsersMapper;
import com.cmcc.ms.service.system.SysMenusService;
import com.cmcc.ms.service.system.SysRolesService;
import com.cmcc.ms.service.system.SysUsersService;
import com.cmcc.ms.service.system.impl.OperateLogServiceImpl;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 权限模块controller.
 *
 * @author ldy
 */
@Controller
@RequestMapping("/role")
public class RolesController extends BaseController {

    /** The sys roles service. */
    /*
     * 注入
     */
    @Autowired
    private SysRolesService sysRolesService;

    /** The sys menus service. */
    @Autowired
    private SysMenusService sysMenusService;

    /** The sys roles dao. */
    @Autowired
    private SysRolesMapper sysRolesDao;

    /** The sys uses dao. */
    @Autowired
    private SysUsersMapper sysUsesDao;

    /** The sys menus dao. */
    @Autowired
    private SysMenusMapper sysMenusDao;

    /** The operate log service impl. */
    @Autowired
    private OperateLogServiceImpl operateLogServiceImpl;

    /** The sys users service. */
    @Autowired
    private SysUsersService sysUsersService;

    /**
     * 跳转权限添加.
     *
     * @param model the model
     * @return the JSON object
     */
    @RequestMapping(value = "/roles/add", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject add(Model model) {
        JSONObject res = new JSONObject();
        return res;
    }

    /**
     * 跳转权限编辑.
     *
     * @param model the model
     * @param roleId the role id
     * @return the JSON object
     */
    @RequestMapping(value = "/roles/edit", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject edit(Model model,
                           @RequestParam(value = "roleId", required = true) String roleId) {
        JSONObject res = new JSONObject();
        backRoleInfo(res, roleId);
        return res;
    }

    /**
     * 跳转权限详情.
     *
     * @param model the model
     * @param roleId the role id
     * @return the JSON object
     */
    @RequestMapping(value = "/roles/tail", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject tail(Model model,
                           @RequestParam(value = "roleId", required = true) String roleId) {
        JSONObject res = new JSONObject();
        backRoleInfo(res, roleId);
        if (StringUtil.isNotNUll(roleId)) {
            SysUsersExample usersExample = new SysUsersExample();
            Criteria criteria = usersExample.createCriteria();
            criteria.andRoleIdEqualTo(new Integer(roleId.trim()));
            List<SysUsers> list = sysUsesDao.selectByExample(usersExample);
            res.put("userByRoleId", list);
            res.put("userCount", list.size());
        }
        return res;
    }

    /**
     * 权限列表.
     *
     * @param model the model
     * @param req the req
     * @param pageSize the page size
     * @param pageNum the page num
     * @param sortName the sort name
     * @param sortOrder the sort order
     * @return the JSON object
     */
    @RequestMapping(value = "/rolesShow", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject query(Model model, HttpServletRequest req,
                            @RequestParam(value = "pageSize", required = false) String pageSize,
                            @RequestParam(value = "pageNum", required = false) String pageNum,
                            @RequestParam(value = "sortName", required = false) String sortName,
                            @RequestParam(value = "sortOrder", required = false) String sortOrder) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageSize", pageSize);
        map.put("pageNum", pageNum);
        map.put("sortName", sortName);
        map.put("sortOrder", sortOrder);
        if (!StringUtil.isNotNUll(pageNum) || !StringUtil.isNotNUll(pageSize)) {
            pageNum = "1";
            pageSize = "50";
        }
        PageBounds pb = new PageBounds(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        List<SysRolesManual> rolesList = sysRolesService.getSysRolesList(map, pb);
        for (int i = 0; i < rolesList.size(); i++) {
            SysUsersExample usesExample = new SysUsersExample();
            usesExample.createCriteria().andRoleIdEqualTo(rolesList.get(i).getRoleId());
            rolesList.get(i).setUsersCount(sysUsesDao.selectByExample(usesExample).size());
        }
        SysRolesExample sysRolesExample = new SysRolesExample();
        com.cmcc.ms.entity.system.SysRolesExample.Criteria createCriteria = sysRolesExample
                .createCriteria();
        createCriteria.andRoleIdNotEqualTo(1);
        List<SysRoles> totalsList = sysRolesDao.selectByExample(sysRolesExample);
        int totalPages = (totalsList.size() + new Integer(pageSize) - 1) / new Integer(pageSize);
        JSONObject res = new JSONObject();
        res.put("totalSize", totalsList.size());
        res.put("totalPages", totalPages);
        res.put("pageNum", pageNum);
        res.put("rolesList", JSONUtils.toJSONString(rolesList));
        return res;
    }

    /**
     * 回显数据.
     *
     * @param res the res
     * @param roleId the role id
     * @return the JSON object
     */
    private JSONObject backRoleInfo(JSONObject res, String roleId) {
        if (StringUtil.isNotNUll(roleId)) {
            SysRoles sysRoles = sysRolesDao.selectByPrimaryKey(new Integer(roleId));
            String roleName = sysRoles.getRoleName();
            res.put("roleName", roleName);
            res.put("roleId", roleId);
            res.put("role", JSONObject.fromObject(sysRoles));
            return res;
        }
        return null;
    }

    /**
     * 权限菜单树生成.
     *
     * @param roleId the role id
     * @return the JSON array
     */
    @RequestMapping(value = "/roles/menus", method = RequestMethod.GET)
    @ResponseBody
    public JSONArray menus(@RequestParam(value = "roleId", required = false) String roleId) {
        LinkedHashMap<String, Object> menus = new LinkedHashMap<String, Object>();
        if (roleId != null && !"".equals(roleId.trim())) {
            SysRoles sysRoles = sysRolesDao.selectByPrimaryKey(new Integer(roleId));
            String roleName = sysRoles.getRoleName();
            menus.put("roleName", roleName);
        }
        JSONArray menuDeviceList = doJson(roleId, -2, "list");
        JSONArray menuDeviceAdd = doJson(roleId, -3, "list");
        JSONArray menuPostList = doJson(roleId, -4, "list");
        JSONArray menuPostAdd = doJson(roleId, -5, "list");
        JSONArray menuDataManage = doJson(roleId, -6, "list");
        menus.put("menuDeviceList", menuDeviceList);
        menus.put("menuDeviceAdd", menuDeviceAdd);
        menus.put("menuPortList", menuPostList);
        menus.put("menuPortAdd", menuPostAdd);
        menus.put("menuDataManage", menuDataManage);
        JSONArray menusJson = JSONArray.fromObject(menus);
        return menusJson;
    }

    /**
     * 权限菜单下拉选.
     *
     * @param roleId the role id
     * @param menuType the menu type
     * @return the JSON array
     */
    @RequestMapping(value = "/roles/menu", method = RequestMethod.GET)
    @ResponseBody
    public JSONArray menu(@RequestParam(value = "roleId", required = true) String roleId,
                          @RequestParam(value = "menuType", required = true) String menuType) {
        JSONArray menuList = new JSONArray();
        if ("menuDeviceList".equals(menuType)) {
            menuList = doJson(roleId, -2, "select");
        } else if ("menuDeviceAdd".equals(menuType)) {
            menuList = doJson(roleId, -3, "select");
        } else if ("menuPortList".equals(menuType)) {
            menuList = doJson(roleId, -4, "select");
        } else if ("menuPortAdd".equals(menuType)) {
            menuList = doJson(roleId, -5, "select");
        } else if ("menuDataManage".equals(menuType)) {
            menuList = doJson(roleId, -6, "select");
        }
        return menuList;
    }

    /**
     * 获取最终json数据.
     *
     * @param roleId the role id
     * @param type the type
     * @param sign the sign
     * @return the JSON array
     */
    private JSONArray doJson(String roleId, int type, String sign) {
        JSONArray array = null;
        List<SysMenus> menusByType = sysMenusService.getMenusByType(type);
        List<SysMenus> menu = sysMenusService.getMenusByType(type * 100);
        menusByType.addAll(menu);
        SysMenus remove = new SysMenus();
        Collections.sort(menusByType, new Comparator<SysMenus>() {
            public int compare(SysMenus o1, SysMenus o2) {
                String os1 = PinyinUtils.chineseToPinYinS(o1.getMenuName());
                String os2 = PinyinUtils.chineseToPinYinS(o2.getMenuName());
                Collator collator = Collator.getInstance();
                return collator.getCollationKey(os1).compareTo(collator.getCollationKey(os2));
            }
        });
        if ("list".equals(sign)) {
            if (StringUtil.isNotNUll(roleId)) {
                menusByType = getChecked(roleId, menusByType, sign);
            }
            for (int i = 0; i < menusByType.size(); i++) {
                if ("全国".equals(menusByType.get(i).getImg())) {
                    remove = menusByType.remove(i);
                    break;
                }
            }
            remove.setChildren(doTreeNodes(menusByType));
            array = JSONArray.fromObject(remove);
        } else {
            menusByType = getChecked(roleId, menusByType, sign);
            array = doTreeNodes(menusByType);
        }
        return array;
    }

    /**
     * 获取树种被勾选数据.
     *
     * @param roleId the role id
     * @param menus the menus
     * @param sign the sign
     * @return the checked
     */
    private List<SysMenus> getChecked(String roleId, List<SysMenus> menus, String sign) {
        List<SysMenus> menusNew = new LinkedList<SysMenus>();
        if (StringUtil.isNotNUll(roleId)) {
            List<SysMenus> menusByRoleId = sysMenusService.getMenusByRoleId(new Integer(roleId
                    .trim()));
            for (int i = 0; i < menusByRoleId.size(); i++) {
                for (int j = 0; j < menus.size(); j++) {
                    if (menus.get(j).getMenuId().equals(menusByRoleId.get(i).getMenuId())) {
                        menus.get(j).setChecked(true);
                        menusNew.add(menus.get(j));
                    }
                }
            }
        }
        if ("list".equals(sign)) {
            return menus;
        } else {
            return menusNew;
        }
    }

    /**
     * 重组树节点.
     *
     * @param dataNodes the data nodes
     * @return the JSON array
     */
    private JSONArray doTreeNodes(List<SysMenus> dataNodes) {
        JSONArray arrayDataNodes = new JSONArray();
        for (int i = 0; i < dataNodes.size(); i++) {
            SysMenus menus = dataNodes.get(i);
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("id", menus.getMenuId());
            jsonObject.accumulate("pId", menus.getParentId());
            jsonObject.accumulate("title", menus.getMenuName());
            jsonObject.accumulate("checked", menus.getChecked());
            jsonObject.accumulate("img", menus.getImg());
            arrayDataNodes.add(jsonObject);
        }
        return arrayDataNodes;
    }

    /**
     * 权限添加或修改操作.
     *
     * @param request the request
     * @param model the model
     * @param roleId the role id
     * @param roleName the role name
     * @param menuIds the menu ids
     * @return the string
     */
    @RequestMapping(value = "/roles/addOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public String add(HttpServletRequest request, Model model,
                      @RequestParam(value = "roleId", required = false) Integer roleId,
                      @RequestParam(value = "roleName", required = true) String roleName,
                      @RequestParam(value = "menuIds[]", required = true) String[] menuIds) {
        String res = "noMenuId";
        if (menuIds.length == 0) {
            return res;
        }
        if (StringUtil.isNotNUll(roleName)) {
            SysRoles sysRoles = new SysRoles();
            Integer intRes = 0;
            SysRoles rolesById = sysRolesDao.selectByPrimaryKey(roleId);
            SysRolesExample sysRolesExample = new SysRolesExample();
            com.cmcc.ms.entity.system.SysRolesExample.Criteria createCriteria = sysRolesExample
                    .createCriteria();
            createCriteria.andRoleNameEqualTo(roleName.trim());
            if (rolesById != null) {
                createCriteria.andRoleIdNotEqualTo(rolesById.getRoleId());
            }
            List<SysRoles> selectByExample = sysRolesDao.selectByExample(sysRolesExample);
            if (selectByExample.size() > 0) {
                res = "same";
                return res;
            }
            String des = getDes(menuIds);
            if (rolesById != null) {
                sysRoles = rolesById;
                sysRoles.setRoleName(roleName);
                sysRoles.setRoleDesc(des);
                sysRoles.setLastwrotime(new Date());
                intRes = sysRolesDao.updateByPrimaryKey(sysRoles);
                OperateLog operateLog = new OperateLog();
                operateLog.setOperateContent(SessionUtils.getAttribute(request, "userName")
                        + ": 修改权限 " + roleName);
                operateLog.setUserName(SessionUtils.getAttribute(request, "userName") + "");
                operateLogServiceImpl.saveUserOperation(operateLog, request);
            } else {
                sysRoles.setRoleDesc(des);
                sysRoles.setRoleName(roleName);
                sysRoles.setCreateDate(new Date());
                sysRoles.setLastwrotime(new Date());
                intRes = sysRolesService.insert(sysRoles);
                OperateLog operateLog = new OperateLog();
                operateLog.setOperateContent(SessionUtils.getAttribute(request, "userName")
                        + ": 添加权限 " + roleName);
                operateLog.setUserName(SessionUtils.getAttribute(request, "userName") + "");
                operateLogServiceImpl.saveUserOperation(operateLog, request);
            }
            if (intRes == 1) {
                SysMenusExample sysMenusExample = new SysMenusExample();
                com.cmcc.ms.entity.system.SysMenusExample.Criteria createCriteria2 = sysMenusExample
                        .createCriteria();
                createCriteria2.andTypeGreaterThan(0);
                List<SysMenus> menusForNum = sysMenusDao.selectByExample(sysMenusExample);
                if (menusForNum.size() > 0) {
                    String[] menusAll = new String[menusForNum.size()];
                    for (int i = 0; i < menusForNum.size(); i++) {
                        menusAll[i] = menusForNum.get(i).getMenuId() + "_" + sysRoles.getRoleId();
                        ;
                    }
                    if (menuIds.length > 0) {
                        for (int i = 0; i < menuIds.length; i++) {
                            menuIds[i] = menuIds[i] + "_" + sysRoles.getRoleId();
                        }
                    }
                    String[] concat = StringUtil.concat(menuIds, menusAll);
                    sysRolesService.updatePrivilege(sysRoles.getRoleId(), concat);
                }
                res = "success";
            } else {
                res = "error";
            }
        } else {
            res = "noRoleName";
        }
        return res;
    }

    /**
     * Gets the des.
     *
     * @param menuIds the menu ids
     * @return the des
     */
    private String getDes(String[] menuIds) {
        String devList = "设备列表:";
        String devAdd = "设备导入:";
        String porList = "端口列表:";
        String porAdd = "端口导入:";
        String dataManage = "数据管理:";
        for (int i = 0; i < menuIds.length; i++) {
            SysMenus sysMenus = sysMenusDao.selectByPrimaryKey(new Integer(menuIds[i]));
            if (sysMenus.getType() == -2 || sysMenus.getType() == -200) {
                devList = devList + sysMenus.getMenuName() + ",";
            } else if (sysMenus.getType() == -3 || sysMenus.getType() == -300) {
                devAdd = devAdd + sysMenus.getMenuName() + ",";
            } else if (sysMenus.getType() == -4 || sysMenus.getType() == -400) {
                porList = porList + sysMenus.getMenuName() + ",";
            } else if (sysMenus.getType() == -5 || sysMenus.getType() == -500) {
                porAdd = porAdd + sysMenus.getMenuName() + ",";
            } else if (sysMenus.getType() == -6 || sysMenus.getType() == -600) {
                dataManage = dataManage + sysMenus.getMenuName() + ",";
            }
        }
        String des = "";
        if (!"设备列表:".equals(devList)) {
            des += devList.substring(0, devList.length() - 1) + ";";
        }
        if (!"设备导入:".equals(devAdd)) {
            des += devAdd.substring(0, devAdd.length() - 1) + ";";
        }
        if (!"端口列表:".equals(porList)) {
            des += porList.substring(0, porList.length() - 1) + ";";
        }
        if (!"端口导入:".equals(porAdd)) {
            des += porAdd.substring(0, porAdd.length() - 1) + ";";
        }
        if (!"数据管理:".equals(dataManage)) {
            des += dataManage.substring(0, dataManage.length() - 1) + ";";
        }
        if (des.length() > 1) {
            des = des.substring(0, des.length() - 1) + "。";
        }
        return des;
    }

    /**
     * 删除指定权限.
     *
     * @param model the model
     * @param roleIds the role ids
     * @return the string
     */
    @RequestMapping(value = "/roles/del", method = RequestMethod.POST)
    @ResponseBody
    public String del(Model model,
                      @RequestParam(value = "roleIds[]", required = false) String[] roleIds) {
        String res = "";
        // 判断对应权限是否存在用户
        Object[] validate = sysUsersService.hasUserByRoleId(roleIds);
        if ((Boolean) validate[0]) {
            res = "hasuser:" + validate[1];
            return res;
        }
        Integer result = sysRolesService.deleteByRoleIds(roleIds);
        if (result.intValue() >= 1) {
            res = "success";
        } else {
            res = "error";
        }
        return res;
    }

    /**
     * 根据角色信息和菜单生成带复选框的树.
     *
     * @param menus the menus
     * @param resultList the result list
     * @param model the model
     */
    public void createTree(List<SysMenus> menus, List<SysMenus> resultList, Model model) {
        TreeNode rolesTreeNode;
        Iterator<SysMenus> resultIt = null;
        Iterator<SysMenus> menusIt = null;
        // 生成树节点
        List<Node> nodeItems = new ArrayList<Node>();
        TreeSupport treeSupport = null;
        CheckedNode checkNode = null;
        SysMenus menuRoot = null;
        SysMenus menuSub = null;
        if (menus.size() > 0) {
            resultIt = resultList.iterator();
            while (resultIt.hasNext()) {
                Boolean checked = false;
                menuRoot = resultIt.next();
                menusIt = menus.iterator();
                while (menusIt.hasNext()) {
                    menuSub = menusIt.next();
                    if (menuSub.getMenuId().equals(menuRoot.getMenuId())) {
                        checked = true;
                    }
                }
                checkNode = new CheckedNode();
                if (checked) {
                    // 该元素为checked
                    checkNode.setId((menuRoot.getMenuId().longValue()));
                    checkNode.setName(menuRoot.getMenuName());
                    checkNode.setParentId(menuRoot.getParentId());
                    checkNode.setResource("/" + menuRoot.getUrl());
                    checkNode.setChecked(true);
                    nodeItems.add(checkNode);
                } else {
                    // 该元素为非checked
                    checkNode.setId((menuRoot.getMenuId().longValue()));
                    checkNode.setName(menuRoot.getMenuName());
                    checkNode.setParentId(menuRoot.getParentId());
                    checkNode.setResource("/" + menuRoot.getUrl());
                    checkNode.setChecked(false);
                    nodeItems.add(checkNode);
                }
            }
            // 生成树
            treeSupport = new TreeSupport();
            rolesTreeNode = treeSupport.createCheckBoxTreeNode(nodeItems);
        } else {
            resultIt = resultList.iterator();
            while (resultIt.hasNext()) {
                menuRoot = resultIt.next();
                checkNode = new CheckedNode();
                checkNode.setId((menuRoot.getMenuId().longValue()));
                checkNode.setName(menuRoot.getMenuName());
                checkNode.setParentId(menuRoot.getParentId());
                checkNode.setResource("/" + menuRoot.getUrl());
                checkNode.setChecked(false);
                nodeItems.add(checkNode);
            }
            // 生成树
            treeSupport = new TreeSupport();
            rolesTreeNode = treeSupport.createCheckBoxTreeNode(nodeItems);
            model.addAttribute("rolesTreeNode", rolesTreeNode);
        }
        model.addAttribute("rolesTreeNode", rolesTreeNode);
    }

}
