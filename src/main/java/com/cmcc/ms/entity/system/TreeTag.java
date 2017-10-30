/**
 * @author ldy
 */
package com.cmcc.ms.entity.system;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


/**
 * 树结构生成标签，本标签主要用于生成符合jquery.treeview生成树状菜单的html代码
 * 
 * @author bing.peng
 */
public class TreeTag extends TagSupport {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5724232625734636526L;

    /** The Constant CHECK_THEME. */
    private static final String CHECK_THEME = "check";

    /** The value. */
    private transient TreeNode value;

    /** The out. */
    private transient JspWriter out;

    /** The context path. */
    private String contextPath;

    /** The theme. */
    private String theme;

    /** The map. */
    Map<String, Integer> map = new HashMap<String, Integer>();

    /**
     * Str equals.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @return true, if successful
     */
    public boolean strEquals(String str1, String str2) {
        if (null == str1 || null == str2) {
            return false;
        } else {
            return str1.equals(str2);
        }
    }

    /**
     * Do start tag.
     *
     * @return the int
     * @throws JspException the jsp exception
     * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
     */
    public int doStartTag() throws JspException {
        ServletContext sc = pageContext.getServletContext();
        contextPath = sc.getContextPath();
        out = pageContext.getOut();

        try {
            /* out.print("<ul id='menu-items' class='filetree'>"); */

            if (equals(theme, CHECK_THEME)) {
                out.print("<ul id='menu-items' class='filetree'>");
                printCheckTree(value);
                out.print("</ul>");
            } else {
                /*
                 * map.put("px", 0); //
                 * map.put("gs",(int)(80*4/value.getChildren().size())); double
                 * i = 135 * value.getChildren().size() + 295 + 90; double j =
                 * 135 * 10000; double k = j / i; map.put("gs", (int)k);
                 */
                printTree(value, false, false);
            }

            /* out.print("</ul>"); */

            out.flush();
        } catch (IOException e) {
            return SKIP_BODY;
        }
        return SKIP_BODY;
    }

    /** The flag. */
    private boolean flag = false;

    /**
     * Prints the tree.
     *
     * @param tm the tm
     * @param flag the flag
     * @param hasSun the has sun
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void printTree(TreeNode tm, boolean flag, boolean hasSun) throws IOException {
        if (tm != null && tm.getId() != null) {
            if (tm.getId().intValue() != 0) {

                if ("0".equals(tm.getParentId())) {
                    if ("/".equals(tm.getResouce())) {
                        out.print("<li class=\"level-1\">" + "<div class=\"link\" id=\"m"
                                + tm.getId() + "\" >" + tm.getName()
                                + "<i class=\"fa fa-plus\"></i></div>");
                    } else {
                        out.print("<li class=\"level-2\"><a data-identity=\"" + tm.getId()
                                + "\" href=\"" + contextPath + tm.getResouce() + "\">"
                                + tm.getName() + "</a>");
                    }
                } else {
                    if (hasSun) {
                        out.print("<ul class=\"submenu clearfix\">"
                                + "<li class=\"level-2\"><a data-identity=\"" + tm.getId()
                                + "\" href=\"" + contextPath + tm.getResouce() + "\">"
                                + tm.getName() + "</a></li>");
                        this.flag = true;
                    } else {
                        out.print("<li class=\"level-2\"><a data-identity=\"" + tm.getId()
                                + "\" href=\"" + contextPath + tm.getResouce() + "\">"
                                + tm.getName() + "</a></li>");
                    }
                }

                if (flag) {
                    if (this.flag) {
                        out.print("</ul></li>");
                        this.flag = false;
                    } else {
                        out.print("</li>");
                    }
                }
            }
            List<TreeNode> cItems = tm.getChildren();
            for (int i = 0; i < cItems.size(); i++) {
                boolean b = false;
                if (i == cItems.size() - 1) {
                    b = true;// 最后menu标记
                }
                TreeNode node = cItems.get(i);
                printTree(node, b && !node.isParent(), i == 0);
            }
        }
    }

    /**
     * Prints the check tree.
     *
     * @param tm            -- tree object
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void printCheckTree(TreeNode tm) throws IOException {
        /***********************************************************************
         * 加一个方法从最低层开始交验，轮训到夫层选择checked
         */

        if (tm.getChildren().isEmpty()) {
            if (tm.isChecked()) {
                out.print("<li>" + "<input id='Re_" + tm.getId() + "' name='" + "menuId"
                        + "' value='" + tm.getId() + "_" + tm.getParentId()
                        + "' type='checkbox' onclick=checkDips('" + tm.getDepth() + "') checked />"
                        + tm.getName() + "</li>");
            } else {
                out.print("<li>" + "<input id='Re_" + tm.getId() + "' name='" + "menuId"
                        + "' value='" + tm.getId() + "_" + tm.getParentId()
                        + "' type='checkbox' onclick=checkDips('" + tm.getDepth() + "') />"
                        + tm.getName() + "</li>");
            }
        } else {
            // 根节点不打印
            if (0 != tm.getId().intValue()) {
                if (tm.isChecked()) {
                    out.print("<li id='li_" + tm.getId() + "'><span>" + "<input id='Re_"
                            + tm.getId() + "' name='" + "menuId" + "' value='" + tm.getId() + "_"
                            + tm.getParentId() + "' type='checkbox' onclick=checkDips('"
                            + tm.getDepth() + "') checked />" + tm.getName() + "</span><ul>");
                } else {
                    out.print("<li id='li_" + tm.getId() + "'><span>" + "<input id='Re_"
                            + tm.getId() + "' name='" + "menuId" + "' value='" + tm.getId() + "_"
                            + tm.getParentId() + "' type='checkbox' onclick=checkDips('"
                            + tm.getDepth() + "') />" + tm.getName() + "</span><ul>");
                }
            }
            List<TreeNode> cItems = tm.getChildren();
            for (TreeNode ctm : cItems) {
                printCheckTree(ctm);
            }
            if (tm.getId().intValue() != 0) {
                out.print("</ul></li>");
            }
        }
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public TreeNode getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value the new value
     */
    public void setValue(TreeNode value) {
        this.value = value;
    }

    /**
     * Gets the theme.
     *
     * @return the theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Sets the theme.
     *
     * @param theme the new theme
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * Equals.
     *
     * @param str1 the str 1
     * @param str2 the str 2
     * @return true, if successful
     */
    public static boolean equals(String str1, String str2) {
        if (null == str1 || null == str2) {
            return false;
        } else {
            return str1.equals(str2);
        }
    }

}
