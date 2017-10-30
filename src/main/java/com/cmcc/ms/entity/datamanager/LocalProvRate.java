package com.cmcc.ms.entity.datamanager;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class LocalProvRate.
 */
public class LocalProvRate {
    
    /** The id. */
    private Integer id;

    /** The province. */
    private String province;

    /** The local prov R. */
    private Float localProvR;

    /** The city user in day avg. */
    private Integer cityUserInDayAvg;

    /** The prov cache day avg. */
    private Integer provCacheDayAvg;

    /** The prov cdn day avg. */
    private Integer provCdnDayAvg;

    /** The unity cdn day avg. */
    private Integer unityCdnDayAvg;

    /** The idc day avg. */
    private Integer idcDayAvg;

    /** The data. */
    private Date data;

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
     * Gets the local prov R.
     *
     * @return the local prov R
     */
    public Float getLocalProvR() {
        return localProvR;
    }

    /**
     * Sets the local prov R.
     *
     * @param localProvR the new local prov R
     */
    public void setLocalProvR(Float localProvR) {
        this.localProvR = localProvR;
    }

    /**
     * Gets the city user in day avg.
     *
     * @return the city user in day avg
     */
    public Integer getCityUserInDayAvg() {
        return cityUserInDayAvg;
    }

    /**
     * Sets the city user in day avg.
     *
     * @param cityUserInDayAvg the new city user in day avg
     */
    public void setCityUserInDayAvg(Integer cityUserInDayAvg) {
        this.cityUserInDayAvg = cityUserInDayAvg;
    }

    /**
     * Gets the prov cache day avg.
     *
     * @return the prov cache day avg
     */
    public Integer getProvCacheDayAvg() {
        return provCacheDayAvg;
    }

    /**
     * Sets the prov cache day avg.
     *
     * @param provCacheDayAvg the new prov cache day avg
     */
    public void setProvCacheDayAvg(Integer provCacheDayAvg) {
        this.provCacheDayAvg = provCacheDayAvg;
    }

    /**
     * Gets the prov cdn day avg.
     *
     * @return the prov cdn day avg
     */
    public Integer getProvCdnDayAvg() {
        return provCdnDayAvg;
    }

    /**
     * Sets the prov cdn day avg.
     *
     * @param provCdnDayAvg the new prov cdn day avg
     */
    public void setProvCdnDayAvg(Integer provCdnDayAvg) {
        this.provCdnDayAvg = provCdnDayAvg;
    }

    /**
     * Gets the unity cdn day avg.
     *
     * @return the unity cdn day avg
     */
    public Integer getUnityCdnDayAvg() {
        return unityCdnDayAvg;
    }

    /**
     * Sets the unity cdn day avg.
     *
     * @param unityCdnDayAvg the new unity cdn day avg
     */
    public void setUnityCdnDayAvg(Integer unityCdnDayAvg) {
        this.unityCdnDayAvg = unityCdnDayAvg;
    }

    /**
     * Gets the idc day avg.
     *
     * @return the idc day avg
     */
    public Integer getIdcDayAvg() {
        return idcDayAvg;
    }

    /**
     * Sets the idc day avg.
     *
     * @param idcDayAvg the new idc day avg
     */
    public void setIdcDayAvg(Integer idcDayAvg) {
        this.idcDayAvg = idcDayAvg;
    }

    /**
     * Gets the data.
     *
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * Sets the data.
     *
     * @param data the new data
     */
    public void setData(Date data) {
        this.data = data;
    }
}