package com.cmcc.ms.entity.datashow;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class CpLogo.
 */
public class CpLogo {
    
    /** The id. */
    private Integer id;

    /** The cp chinese. */
    private String cpChinese;

    /** The namestr. */
    private String namestr;

    /** The page. */
    private String page;

    /** The logo url. */
    private String logoUrl;

    /** The updatetime. */
    private Date updatetime;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the cp chinese.
     *
     * @return the cp chinese
     */
    public String getCpChinese() {
        return cpChinese;
    }

    /**
     * Sets the cp chinese.
     *
     * @param cpChinese the new cp chinese
     */
    public void setCpChinese(String cpChinese) {
        this.cpChinese = cpChinese == null ? null : cpChinese.trim();
    }

    /**
     * Gets the namestr.
     *
     * @return the namestr
     */
    public String getNamestr() {
        return namestr;
    }

    /**
     * Sets the namestr.
     *
     * @param namestr the new namestr
     */
    public void setNamestr(String namestr) {
        this.namestr = namestr == null ? null : namestr.trim();
    }

    /**
     * Gets the page.
     *
     * @return the page
     */
    public String getPage() {
        return page;
    }

    /**
     * Sets the page.
     *
     * @param page the new page
     */
    public void setPage(String page) {
        this.page = page == null ? null : page.trim();
    }

    /**
     * Gets the logo url.
     *
     * @return the logo url
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * Sets the logo url.
     *
     * @param logoUrl the new logo url
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    /**
     * Gets the updatetime.
     *
     * @return the updatetime
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * Sets the updatetime.
     *
     * @param updatetime the new updatetime
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}