package com.cmcc.ms.entity.datashow;

import java.util.Date;


/**
 * The Class ProvinceOttDay.
 */
public class ProvinceOttDay {
    
    /** The id. */
    private Integer id;

    /** The province. */
    private String province;

    /** The trafficin. */
    private Double trafficin;

    /** The trafficout. */
    private Double trafficout;

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
     * Gets the trafficout.
     *
     * @return the trafficout
     */
    public Double getTrafficout() {
        return trafficout;
    }

    /**
     * Sets the trafficout.
     *
     * @param trafficout the new trafficout
     */
    public void setTrafficout(Double trafficout) {
        this.trafficout = trafficout;
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
