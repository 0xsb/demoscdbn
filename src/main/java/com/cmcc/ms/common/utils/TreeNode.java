/*
 * 
 */
package com.cmcc.ms.common.utils;

import java.util.List;


/**
 * The Class TreeNode.
 *
 * @author ldy
 */
public class TreeNode {

    /** The id. */
    String id;

    /** The text. */
    String text;

    /** The parent id. */
    String parentId;

    /** The children. */
    List<TreeNode> children;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text.
     *
     * @param text the new text
     */
    public void setText(String text) {
        this.text = text;
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

}
