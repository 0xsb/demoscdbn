package com.cmcc.ms.entity.datashow;

import java.util.Date;


/**
 * The Class MapData.
 */
public class MapData {
    
    /** The id. */
    private Integer id;

    /** The province. */
    private String province;

    /** The u cdn. */
    private Double uCdn;

    /** The idc. */
    private Double idc;

    /** The u cache. */
    private Double uCache;

    /** The p cache. */
    private Double pCache;

    /** The p ott. */
    private Double pOtt;

    /** The createtime. */
    private Date createtime;

    /** The timestr. */
    private String timestr;

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
     * Gets the province.
     *
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the province.
     *
     * @param province the new province
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * Gets the u cdn.
     *
     * @return the u cdn
     */
    public Double getuCdn() {
        return uCdn;
    }

    /**
     * Sets the u cdn.
     *
     * @param uCdn the new u cdn
     */
    public void setuCdn(Double uCdn) {
        this.uCdn = uCdn;
    }

    /**
     * Gets the idc.
     *
     * @return the idc
     */
    public Double getIdc() {
        return idc;
    }

    /**
     * Sets the idc.
     *
     * @param idc the new idc
     */
    public void setIdc(Double idc) {
        this.idc = idc;
    }

    /**
     * Gets the u cache.
     *
     * @return the u cache
     */
    public Double getuCache() {
        return uCache;
    }

    /**
     * Sets the u cache.
     *
     * @param uCache the new u cache
     */
    public void setuCache(Double uCache) {
        this.uCache = uCache;
    }

    /**
     * Gets the p cache.
     *
     * @return the p cache
     */
    public Double getpCache() {
        return pCache;
    }

    /**
     * Sets the p cache.
     *
     * @param pCache the new p cache
     */
    public void setpCache(Double pCache) {
        this.pCache = pCache;
    }

    /**
     * Gets the p ott.
     *
     * @return the p ott
     */
    public Double getpOtt() {
        return pOtt;
    }

    /**
     * Sets the p ott.
     *
     * @param pOtt the new p ott
     */
    public void setpOtt(Double pOtt) {
        this.pOtt = pOtt;
    }

    /**
     * Gets the createtime.
     *
     * @return the createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * Sets the createtime.
     *
     * @param createtime the new createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * Gets the timestr.
     *
     * @return the timestr
     */
    public String getTimestr() {
        return timestr;
    }

    /**
     * Sets the timestr.
     *
     * @param timestr the new timestr
     */
    public void setTimestr(String timestr) {
        this.timestr = timestr == null ? null : timestr.trim();
    }
}
