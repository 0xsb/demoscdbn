package com.cmcc.ms.entity.datamanager;

// TODO: Auto-generated Javadoc
/**
 * The Class LocalProvRateExtendDay.
 */
public class LocalProvRateExtendDay {
    
    /** The id. */
    private Integer id;

    /** The province. */
    private String province;

    /** The local prov R. */
    private Float localProvR;

    /** The month on month. */
    private Float monthOnMonth;

    /** The day on day. */
    private Float dayOnDay;

    /** The datestr. */
    private String datestr;

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
     * Gets the month on month.
     *
     * @return the month on month
     */
    public Float getMonthOnMonth() {
        return monthOnMonth;
    }

    /**
     * Sets the month on month.
     *
     * @param monthOnMonth the new month on month
     */
    public void setMonthOnMonth(Float monthOnMonth) {
        this.monthOnMonth = monthOnMonth;
    }

    /**
     * Gets the day on day.
     *
     * @return the day on day
     */
    public Float getDayOnDay() {
        return dayOnDay;
    }

    /**
     * Sets the day on day.
     *
     * @param dayOnDay the new day on day
     */
    public void setDayOnDay(Float dayOnDay) {
        this.dayOnDay = dayOnDay;
    }

    /**
     * Gets the datestr.
     *
     * @return the datestr
     */
    public String getDatestr() {
        return datestr;
    }

    /**
     * Sets the datestr.
     *
     * @param datestr the new datestr
     */
    public void setDatestr(String datestr) {
        this.datestr = datestr == null ? null : datestr.trim();
    }
}