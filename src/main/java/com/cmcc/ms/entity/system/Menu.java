/**
 * @author ldy
 */
package com.cmcc.ms.entity.system;


/**
 * The Class Menu.
 */
public class Menu implements Node {

    /** The id. */
    private Long id;

    /** The parent id. */
    private Integer parentId;

    /** The name. */
    private String name;

    /** The resource. */
    private String resource;

    /* (non-Javadoc)
     * @see com.cmcc.hy.opp.cmcciw.webapp.ui.tree.Node#getId()
     */
    public Long getId() {
        return this.id;
    }

    /* (non-Javadoc)
     * @see com.cmcc.hy.opp.cmcciw.webapp.ui.tree.Node#getName()
     */
    public String getName() {
        return this.name;
    }

    /* (non-Javadoc)
     * @see com.cmcc.hy.opp.cmcciw.webapp.ui.tree.Node#getParentId()
     */
    public Integer getParentId() {
        return this.parentId;
    }

    /* (non-Javadoc)
     * @see com.cmcc.hy.opp.cmcciw.webapp.ui.tree.Node#getResouce()
     */
    public String getResouce() {
        return this.resource;
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
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Sets the parent id.
     *
     * @param parentId the new parent id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

}
