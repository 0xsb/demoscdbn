package com.cmcc.ms.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cmcc.ms.common.utils.MD5;
import com.cmcc.ms.common.utils.StringUtil;
import com.cmcc.ms.entity.system.SysMenus;
import com.cmcc.ms.entity.system.SysMenusExample;
import com.cmcc.ms.entity.system.SysRoles;
import com.cmcc.ms.entity.system.SysRolesExample;
import com.cmcc.ms.entity.system.SysRolesExample.Criteria;
import com.cmcc.ms.entity.system.SysUsers;
import com.cmcc.ms.mapper.SysMenusMapper;
import com.cmcc.ms.mapper.SysRolesMapper;
import com.cmcc.ms.service.BaseTestCase;
import com.cmcc.ms.service.system.SysMenusService;
import com.cmcc.ms.service.system.SysRolesService;
import com.cmcc.ms.service.system.SysUsersService;

/**
 * 
 * @author chenyouchao-yl
 *
 */
public class ImportUser extends BaseTestCase {

    @Autowired
    private SysUsersService sysUsersService;
    @Autowired
    private SysRolesMapper sysRolesMapper;
    @Autowired
    private SysMenusMapper sysMenusMapper;
    @Autowired
    private SysRolesService sysRolesService;
    @Autowired
    private SysMenusService sysMenusService;

    /**
     * 
     */
    @Test
    public void importExcel() {
        //1.创建输入流
        try {
            File file = new File(
                    "D:\\mywork\\cdnms\\src\\test\\resources\\基础网络资源管理责任人-31省汇总-v1.xlsx");
            FileInputStream inputStream = new FileInputStream(file);
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getName());
            boolean is03Excel = file.getName().matches("^.+\\.(?i)(xls)$");
            //1.读取工作簿
            Workbook workbook = is03Excel ? new HSSFWorkbook(inputStream) : new XSSFWorkbook(
                    inputStream);
            //2.读取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //3.读取行
            //判断行数大于一,是因为数据从第二行开始插入
            if (sheet.getPhysicalNumberOfRows() > 1) {
                SysUsers user = null;
                //跳过前一行
                for (int k = 1; k < sheet.getPhysicalNumberOfRows(); k++) {
                    //读取单元格
                    Row row0 = sheet.getRow(k);
                    user = new SysUsers();
                    //用户名
                    Cell cell0 = row0.getCell(0);
                    cell0.setCellType(Cell.CELL_TYPE_STRING);
                    user.setUserRelname(cell0.getStringCellValue().trim());
                    //邮箱
                    Cell cell1 = row0.getCell(1);
                    cell1.setCellType(Cell.CELL_TYPE_STRING);
                    user.setEmail(cell1.getStringCellValue().trim());
                    //手机
                    Cell cell2 = row0.getCell(2);
                    cell2.setCellType(Cell.CELL_TYPE_STRING);
                    user.setPhone(cell2.getStringCellValue().trim());
                    //帐号
                    Cell cell3 = row0.getCell(3);
                    cell3.setCellType(Cell.CELL_TYPE_STRING);
                    user.setUserName(cell3.getStringCellValue().trim());
                    //密码
                    Cell cell4 = row0.getCell(4);
                    cell4.setCellType(Cell.CELL_TYPE_STRING);
                    user.setUserPassword(MD5.calcMD5(MD5.calcMD5(cell4.getStringCellValue().trim())
                            + user.getUserName()));
                    //省份
                    Cell cell5 = row0.getCell(5);
                    cell5.setCellType(Cell.CELL_TYPE_STRING);
                    user.setCompany(cell5.getStringCellValue().trim());
                    user.setCreateDate(new Date());
                    user.setLastwrotime(new Date());
                    user.setState("0");
                    user.setWrongcount(0);
                    //设置权限
                    SysRolesExample sysRolesExample = new SysRolesExample();
                    Criteria createCriteria = sysRolesExample.createCriteria();
                    createCriteria.andRoleNameEqualTo(cell5.getStringCellValue().trim());
                    List<SysRoles> selectByExample = sysRolesMapper
                            .selectByExample(sysRolesExample);
                    //判断是否是已有权限
                    if (selectByExample.size() != 0) {
                        user.setRoleId(selectByExample.get(0).getRoleId());
                    } else {
                        SysMenusExample sysMenusExample = new SysMenusExample();
                        com.cmcc.ms.entity.system.SysMenusExample.Criteria createCriteria2 = sysMenusExample
                                .createCriteria();
                        createCriteria2.andImgEqualTo(cell5.getStringCellValue().trim());
                        List<SysMenus> sysMenusList = sysMenusMapper
                                .selectByExample(sysMenusExample);

                        String[] menuIds = new String[sysMenusList.size()];
                        for (int j = 0; j < sysMenusList.size(); j++) {
                            menuIds[j] = sysMenusList.get(j).getMenuId() + "";
                        }
                        SysRoles roles = new SysRoles();
                        roles.setCreateDate(new Date());
                        roles.setLastwrotime(new Date());
                        roles.setRoleName(cell5.getStringCellValue().trim());
                        roles.setRoleDesc(getDes(menuIds));
                        roles.setCreateDate(new Date());
                        roles.setLastwrotime(new Date());
                        //返回权限ID
                        sysRolesMapper.insert(roles);
                        user.setRoleId(roles.getRoleId());
                        List<SysMenus> menusByType1 = sysMenusService.getMenusByType(1);
                        String[] menuIds1 = new String[menusByType1.size()];
                        for (int i = 0; i < menusByType1.size(); i++) {
                            menuIds1[i] = menusByType1.get(i).getMenuId() + "";
                        }
                        List<SysMenus> menusByType2 = sysMenusService.getMenusByType(2);
                        String[] menuIds2 = new String[menusByType2.size()];
                        for (int i = 0; i < menusByType2.size(); i++) {
                            menuIds2[i] = menusByType2.get(i).getMenuId() + "";
                        }
                        if (menuIds.length > 0) {
                            for (int i = 0; i < menuIds.length; i++) {
                                menuIds[i] = menuIds[i] + "_" + roles.getRoleId();
                            }
                        }
                        String[] concat1 = StringUtil.concat(menuIds, menuIds1);
                        String[] concat2 = StringUtil.concat(concat1, menuIds2);
                        sysRolesService.updatePrivilege(roles.getRoleId(), concat2);
                    }
                    //保存用户
                    sysUsersService.insert(user);
                }
            }
            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param menuIds
     * @return
     */
    private String getDes(String[] menuIds) {
        String devList = "设备列表:";
        String devAdd = "设备导入:";
        String porList = "端口列表:";
        String porAdd = "端口导入:";
        for (int i = 0; i < menuIds.length; i++) {
            SysMenus sysMenus = sysMenusMapper.selectByPrimaryKey(new Integer(menuIds[i]));
            if (sysMenus.getType() == -2 || sysMenus.getType() == -200) {
                devList = devList + sysMenus.getMenuName() + ",";
            } else if (sysMenus.getType() == -3 || sysMenus.getType() == -300) {
                devAdd = devAdd + sysMenus.getMenuName() + ",";
            } else if (sysMenus.getType() == -4 || sysMenus.getType() == -400) {
                porList = porList + sysMenus.getMenuName() + ",";
            } else if (sysMenus.getType() == -5 || sysMenus.getType() == -500) {
                porAdd = porAdd + sysMenus.getMenuName() + ",";
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
        if (des.length() > 1) {
            des = des.substring(0, des.length() - 1) + "。";
        }
        return des;
    }
}
