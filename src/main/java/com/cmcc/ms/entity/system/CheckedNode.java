/**
 * @author ldy
 */
package com.cmcc.ms.entity.system;


/**
 * The Class CheckedNode.
 *
 * @author lianchi.gao
 */
public class CheckedNode implements Node {

    /** The id. */
    private Long id;

    /** The parent id. */
    private Integer parentId;

    /** The name. */
    private String name;

    /** The resource. */
    private String resource;

    /** The checked. */
    private Boolean checked;

    /* (non-Javadoc)
     * @see com.cmcc.hy.opp.cmcciw.webapp.ui.tree.Node#getId()
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

    /* (non-Javadoc)
     * @see com.cmcc.hy.opp.cmcciw.webapp.ui.tree.Node#getParentId()
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * Sets the parent id.
     *
     * @param parentId the new parent id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /* (non-Javadoc)
     * @see com.cmcc.hy.opp.cmcciw.webapp.ui.tree.Node#getName()
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
     * Gets the resource.
     *
     * @return the resource
     */
    public String getResource() {
        return resource;
    }

    /**
     * Sets the resource.
     *
     * @param resource the new resource
     */
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * Gets the checked.
     *
     * @return the checked
     */
    public Boolean getChecked() {
        return checked;
    }

    /**
     * Sets the checked.
     *
     * @param checked the new checked
     */
    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    /**
     * Gets the resouce.
     *
     * @return the resouce
     * @see com.cmcc.hy.opp.cmcciw.entity.menutree.Node#getResouce()
     */
    public String getResouce() {
        return resource;
    }

}
