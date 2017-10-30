package com.cmcc.ms.entity.datashow;

import java.util.Date;


/**
 * The Class OverallAnalysis.
 */
public class OverallAnalysis {
    
    /** The id. */
    private Integer id;

    /** The name. */
    private String name;

    /** The ports. */
    private Integer ports;

    /** The bandwidth. */
    private Double bandwidth;

    /** The trafficins. */
    private Double trafficins;

    /** The trafficouts. */
    private Double trafficouts;

    /** The creattime. */
    private Date creattime;

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
     * Gets the ports.
     *
     * @return the ports
     */
    public Integer getPorts() {
        return ports;
    }

    /**
     * Sets the ports.
     *
     * @param ports the new ports
     */
    public void setPorts(Integer ports) {
        this.ports = ports;
    }

    /**
     * Gets the bandwidth.
     *
     * @return the bandwidth
     */
    public Double getBandwidth() {
        return bandwidth;
    }

    /**
     * Sets the bandwidth.
     *
     * @param bandwidth the new bandwidth
     */
    public void setBandwidth(Double bandwidth) {
        this.bandwidth = bandwidth;
    }

    /**
     * Gets the trafficins.
     *
     * @return the trafficins
     */
    public Double getTrafficins() {
        return trafficins;
    }

    /**
     * Sets the trafficins.
     *
     * @param trafficins the new trafficins
     */
    public void setTrafficins(Double trafficins) {
        this.trafficins = trafficins;
    }

    /**
     * Gets the trafficouts.
     *
     * @return the trafficouts
     */
    public Double getTrafficouts() {
        return trafficouts;
    }

    /**
     * Sets the trafficouts.
     *
     * @param trafficouts the new trafficouts
     */
    public void setTrafficouts(Double trafficouts) {
        this.trafficouts = trafficouts;
    }

    /**
     * Gets the creattime.
     *
     * @return the creattime
     */
    public Date getCreattime() {
        return creattime;
    }

    /**
     * Sets the creattime.
     *
     * @param creattime the new creattime
     */
    public void setCreattime(Date creattime) {
        this.creattime = creattime;
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
