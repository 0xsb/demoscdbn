package com.cmcc.ms.entity.datashow;

import java.util.Date;


/**
 * The Class BusinessTraffic.
 */
public class BusinessTraffic {
    
    /** The id. */
    private Integer id;

    /** The name. */
    private String name;

    /** The business. */
    private String business;

    /** The trafficin. */
    private Double trafficin;

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
        this.name = name == null ? null : name.trim();
    }

    /**
     * Gets the business.
     *
     * @return the business
     */
    public String getBusiness() {
        return business;
    }

    /**
     * Sets the business.
     *
     * @param business the new business
     */
    public void setBusiness(String business) {
        this.business = business == null ? null : business.trim();
    }

    /**
     * Gets the trafficin.
     *
     * @return the trafficin
     */
    public Double getTrafficin() {
        return trafficin;
    }

    /**
     * Sets the trafficin.
     *
     * @param trafficin the new trafficin
     */
    public void setTrafficin(Double trafficin) {
        this.trafficin = trafficin;
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
