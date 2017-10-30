/**
 * @author ldy
 */
package com.cmcc.ms.entity.system;

import java.util.LinkedList;
import java.util.List;


/**
 * 树节点对象.
 *
 * @author bing.peng
 */
public class TreeNode {

    /** The id. */
    private Long id;

    /** The name. */
    private String name;

    /** The resouce. */
    private String resouce;

    /** The checked. */
    private boolean checked;

    /** The depth. */
    // Composed by menuId of each category, like: 0_1_11_111_1111_...
    private String depth;

    /** The parent id. */
    private String parentId;

    /**
     * Gets the depth.
     *
     * @return the depth
     */
    public String getDepth() {
        return depth;
    }

    /**
     * Composed by menuId of each category, like: 0_1_11_111_1111_...
     *
     * @param depth the new depth
     */
    public void setDepth(String depth) {
        this.depth = depth;
    }

    /** The children. */
    private List<TreeNode> children = new LinkedList<TreeNode>();

    /** The tree string. */
    private StringBuffer treeString = new StringBuffer();

    /**
     * Adds the children.
     *
     * @param treeNode the tree node
     */
    public void addChildren(TreeNode treeNode) {
        children.add(treeNode);
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the resouce.
     *
     * @return the resouce
     */
    public String getResouce() {
        return resouce;
    }

    /**
     * Sets the resouce.
     *
     * @param resouce the new resouce
     */
    public void setResouce(String resouce) {
        this.resouce = resouce;
    }

    /**
     * Gets the children.
     *
     * @return the children
     */
    public List<TreeNode> getChildren() {
        return children;
    }

    /**
     * Sets the children.
     *
     * @param children the new children
     */
    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    /**
     * Gets the parent id.
     *
     * @return the parent id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * Sets the parent id.
     *
     * @param parentId the new parent id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * Checks if is parent.
     *
     * @return true, if is parent
     */
    public boolean isParent() {
        return "0".equals(this.parentId);
    }

    /**
     * To string.
     *
     * @return the string
     * @see java.lang.Object#toString()
     */
    public String toString() {
        treeString.append(this.getName() + "\r\n");
        if (this.getChildren().size() > 0) {
            for (int i = 0; i < this.getChildren().size(); i++) {
                treeString.append(this.getChildren().get(i) + "\r\n");
            }
        }
        return treeString.toString();
    }

    /**
     * Checks if is checked.
     *
     * @return true, if is checked
     */
    public boolean isChecked() {
        return checked;
    }

    /**
     * Sets the checked.
     *
     * @param checked the new checked
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
