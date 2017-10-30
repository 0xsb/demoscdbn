package com.cmcc.ms.entity.resource;

import com.cmcc.ms.common.utils.DateUtils;
import com.cmcc.ms.common.utils.StringUtil;
import com.cmcc.ms.common.utils.TimeUtils;


/**
 * The Class ResourceDevices.
 */
public class ResourceDevices extends ResourceBean {
    
    /** The page num. */
    private String pageNum;
    
    /** The page size. */
    private String pageSize;
    
    /** The begin time. */
    private String beginTime;
    
    /** The end time. */
    private String endTime;
    
    /** The total page. */
    private String totalPage;

    /**
     * Gets the total page.
     *
     * @return the total page
     */
    public String getTotalPage() {
        return totalPage;
    }

    /**
     * Sets the total page.
     *
     * @param totalPage the new total page
     */
    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * Gets the page num.
     *
     * @return the page num
     */
    public String getPageNum() {
        return pageNum;
    }

    /**
     * Sets the page num.
     *
     * @param pageNum the new page num
     */
    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * Gets the page size.
     *
     * @return the page size
     */
    public String getPageSize() {
        return pageSize;
    }

    /**
     * Sets the page size.
     *
     * @param pageSize the new page size
     */
    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Gets the begin time.
     *
     * @return the begin time
     */
    public String getBeginTime() {
        return beginTime;
    }

    /**
     * Sets the begin time.
     *
     * @param beginTime the new begin time
     */
    public void setBeginTime(String beginTime) {
        if (StringUtil.isNotNUll(beginTime)) {
            this.beginTime = DateUtils.getSpecifiedDayBefore(TimeUtils.FORMAT_DATE, beginTime);
        } else {
            this.beginTime = null;
        }
    }

    /**
     * Gets the end time.
     *
     * @return the end time
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time.
     *
     * @param endTime the new end time
     */
    public void setEndTime(String endTime) {
        if (StringUtil.isNotNUll(endTime)) {
            this.endTime = DateUtils.getSpecifiedDayAfter(TimeUtils.FORMAT_DATE, endTime);
        } else {
            this.endTime = null;
        }
    }

    /** The snmp version view. */
    private String snmpVersionView;

    /**
     * Gets the snmp version view.
     *
     * @return the snmp version view
     */
    public String getSnmpVersionView() {
        return snmpVersionView;
    }

    /**
     * Sets the snmp version view.
     *
     * @param snmpVersionView the new snmp version view
     */
    public void setSnmpVersionView(String snmpVersionView) {
        if ("全部".equals(snmpVersionView)) {
            this.snmpVersion = null;
        } else {
            this.snmpVersion = Byte.valueOf(snmpVersionView);
        }
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.province
     *
     * @mbggenerated
     */
    private String province;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.room
     *
     * @mbggenerated
     */
    private String room;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.type
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.ip_addr
     *
     * @mbggenerated
     */
    private String ipAddr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.snmp_version
     *
     * @mbggenerated
     */
    private Byte snmpVersion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.snmp_port
     *
     * @mbggenerated
     */
    private String snmpPort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.snmp_community
     *
     * @mbggenerated
     */
    private String snmpCommunity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.snmpv3_securityname
     *
     * @mbggenerated
     */
    private String snmpv3Securityname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.snmpv3_securitylevel
     *
     * @mbggenerated
     */
    private String snmpv3Securitylevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.snmpv3_authpassphrase
     *
     * @mbggenerated
     */
    private String snmpv3Authpassphrase;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.snmpv3_privpassphrase
     *
     * @mbggenerated
     */
    private String snmpv3Privpassphrase;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.snmpv3_authprotocol
     *
     * @mbggenerated
     */
    private String snmpv3Authprotocol;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.snmpv3_privprotocol
     *
     * @mbggenerated
     */
    private String snmpv3Privprotocol;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.zb_hostid
     *
     * @mbggenerated
     */
    private Long zbHostid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.status
     *
     * @mbggenerated
     */
    private Byte status;

    /** The status view. */
    private String statusView;

    /**
     * Gets the status view.
     *
     * @return the status view
     */
    public String getStatusView() {
        return statusView;
    }

    /**
     * Sets the status view.
     *
     * @param statusView the new status view
     */
    public void setStatusView(String statusView) {
        this.statusView = statusView;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.create_time
     *
     * @mbggenerated
     */
    private Integer createTime;

    /** The create time view. */
    private String createTimeView;

    /**
     * Gets the creates the time view.
     *
     * @return the creates the time view
     */
    public String getCreateTimeView() {
        if (createTime != null) {
            createTimeView = DateUtils.dateToStr(createTime, DateUtils.YMD_DASH);
        }
        return createTimeView;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resource_devices.lastmodified_time
     *
     * @mbggenerated
     */
    private Integer lastmodifiedTime;

    /** The lastmodified time view. */
    private String lastmodifiedTimeView;

    /**
     * Gets the lastmodified time view.
     *
     * @return the lastmodified time view
     */
    public String getLastmodifiedTimeView() {
        if (lastmodifiedTime != null) {
            lastmodifiedTimeView = DateUtils.dateToStr(lastmodifiedTime, DateUtils.YMD_DASH);
        }
        return lastmodifiedTimeView;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.id
     *
     * @return the value of resource_devices.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.id
     *
     * @param id the value for resource_devices.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.name
     *
     * @return the value of resource_devices.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.name
     *
     * @param name the value for resource_devices.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.province
     *
     * @return the value of resource_devices.province
     *
     * @mbggenerated
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.province
     *
     * @param province the value for resource_devices.province
     *
     * @mbggenerated
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.room
     *
     * @return the value of resource_devices.room
     *
     * @mbggenerated
     */
    public String getRoom() {
        return room;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.room
     *
     * @param room the value for resource_devices.room
     *
     * @mbggenerated
     */
    public void setRoom(String room) {
        this.room = room == null ? null : room.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.type
     *
     * @return the value of resource_devices.type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.type
     *
     * @param type the value for resource_devices.type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        if ("全部".equals(type)) {
            this.type = null;
        } else {
            this.type = type == null ? null : type.trim();
        }
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.ip_addr
     *
     * @return the value of resource_devices.ip_addr
     *
     * @mbggenerated
     */
    public String getIpAddr() {
        return ipAddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.ip_addr
     *
     * @param ipAddr the value for resource_devices.ip_addr
     *
     * @mbggenerated
     */
    public void setIpAddr(String ipAddr) {
        if (StringUtil.isNotNUll(ipAddr)) {
            this.ipAddr = ipAddr == null ? null : ipAddr.trim();
        } else {
            this.ipAddr = null;
        }
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.snmp_version
     *
     * @return the value of resource_devices.snmp_version
     *
     * @mbggenerated
     */
    public Byte getSnmpVersion() {
        return snmpVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.snmp_version
     *
     * @param snmpVersion the value for resource_devices.snmp_version
     *
     * @mbggenerated
     */
    public void setSnmpVersion(Byte snmpVersion) {
        this.snmpVersion = snmpVersion;
        this.snmpVersionView = snmpVersion + "";
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.snmp_port
     *
     * @return the value of resource_devices.snmp_port
     *
     * @mbggenerated
     */
    public String getSnmpPort() {
        return snmpPort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.snmp_port
     *
     * @param snmpPort the value for resource_devices.snmp_port
     *
     * @mbggenerated
     */
    public void setSnmpPort(String snmpPort) {
        if ("全部".equals(snmpPort)) {
            this.snmpPort = null;
        } else {
            this.snmpPort = snmpPort;
        }
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.snmp_community
     *
     * @return the value of resource_devices.snmp_community
     *
     * @mbggenerated
     */
    public String getSnmpCommunity() {
        return snmpCommunity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.snmp_community
     *
     * @param snmpCommunity the value for resource_devices.snmp_community
     *
     * @mbggenerated
     */
    public void setSnmpCommunity(String snmpCommunity) {
        this.snmpCommunity = snmpCommunity == null ? null : snmpCommunity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.snmpv3_securityname
     *
     * @return the value of resource_devices.snmpv3_securityname
     *
     * @mbggenerated
     */
    public String getSnmpv3Securityname() {
        return snmpv3Securityname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.snmpv3_securityname
     *
     * @param snmpv3Securityname the value for resource_devices.snmpv3_securityname
     *
     * @mbggenerated
     */
    public void setSnmpv3Securityname(String snmpv3Securityname) {
        this.snmpv3Securityname = snmpv3Securityname == null ? null : snmpv3Securityname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.snmpv3_securitylevel
     *
     * @return the value of resource_devices.snmpv3_securitylevel
     *
     * @mbggenerated
     */
    public String getSnmpv3Securitylevel() {
        return snmpv3Securitylevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.snmpv3_securitylevel
     *
     * @param snmpv3Securitylevel the value for resource_devices.snmpv3_securitylevel
     *
     * @mbggenerated
     */
    public void setSnmpv3Securitylevel(String snmpv3Securitylevel) {
        this.snmpv3Securitylevel = snmpv3Securitylevel == null ? null : snmpv3Securitylevel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.snmpv3_authpassphrase
     *
     * @return the value of resource_devices.snmpv3_authpassphrase
     *
     * @mbggenerated
     */
    public String getSnmpv3Authpassphrase() {
        return snmpv3Authpassphrase;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.snmpv3_authpassphrase
     *
     * @param snmpv3Authpassphrase the value for resource_devices.snmpv3_authpassphrase
     *
     * @mbggenerated
     */
    public void setSnmpv3Authpassphrase(String snmpv3Authpassphrase) {
        this.snmpv3Authpassphrase = snmpv3Authpassphrase == null ? null : snmpv3Authpassphrase
                .trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.snmpv3_privpassphrase
     *
     * @return the value of resource_devices.snmpv3_privpassphrase
     *
     * @mbggenerated
     */
    public String getSnmpv3Privpassphrase() {
        return snmpv3Privpassphrase;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.snmpv3_privpassphrase
     *
     * @param snmpv3Privpassphrase the value for resource_devices.snmpv3_privpassphrase
     *
     * @mbggenerated
     */
    public void setSnmpv3Privpassphrase(String snmpv3Privpassphrase) {
        this.snmpv3Privpassphrase = snmpv3Privpassphrase == null ? null : snmpv3Privpassphrase
                .trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.snmpv3_authprotocol
     *
     * @return the value of resource_devices.snmpv3_authprotocol
     *
     * @mbggenerated
     */
    public String getSnmpv3Authprotocol() {
        return snmpv3Authprotocol;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.snmpv3_authprotocol
     *
     * @param snmpv3Authprotocol the value for resource_devices.snmpv3_authprotocol
     *
     * @mbggenerated
     */
    public void setSnmpv3Authprotocol(String snmpv3Authprotocol) {
        this.snmpv3Authprotocol = snmpv3Authprotocol == null ? null : snmpv3Authprotocol.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.snmpv3_privprotocol
     *
     * @return the value of resource_devices.snmpv3_privprotocol
     *
     * @mbggenerated
     */
    public String getSnmpv3Privprotocol() {
        return snmpv3Privprotocol;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.snmpv3_privprotocol
     *
     * @param snmpv3Privprotocol the value for resource_devices.snmpv3_privprotocol
     *
     * @mbggenerated
     */
    public void setSnmpv3Privprotocol(String snmpv3Privprotocol) {
        this.snmpv3Privprotocol = snmpv3Privprotocol == null ? null : snmpv3Privprotocol.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.zb_hostid
     *
     * @return the value of resource_devices.zb_hostid
     *
     * @mbggenerated
     */
    public Long getZbHostid() {
        return zbHostid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.zb_hostid
     *
     * @param zbHostid the value for resource_devices.zb_hostid
     *
     * @mbggenerated
     */
    public void setZbHostid(Long zbHostid) {
        this.zbHostid = zbHostid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.status
     *
     * @return the value of resource_devices.status
     *
     * @mbggenerated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.status
     *
     * @param status the value for resource_devices.status
     *
     * @mbggenerated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.create_time
     *
     * @return the value of resource_devices.create_time
     *
     * @mbggenerated
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.create_time
     *
     * @param createTime the value for resource_devices.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resource_devices.lastmodified_time
     *
     * @return the value of resource_devices.lastmodified_time
     *
     * @mbggenerated
     */
    public Integer getLastmodifiedTime() {
        return lastmodifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resource_devices.lastmodified_time
     *
     * @param lastmodifiedTime the value for resource_devices.lastmodified_time
     *
     * @mbggenerated
     */
    public void setLastmodifiedTime(Integer lastmodifiedTime) {
        this.lastmodifiedTime = lastmodifiedTime;
    }
}
