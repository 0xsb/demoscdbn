package com.cmcc.ms.entity.system;

import java.util.Date;

import com.cmcc.ms.common.utils.TimeUtils;


/**
 * The Class SysUsersManual.
 *
 * @author ldy
 */
public class SysUsersManual {
    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column sys_users.USER_ID
     * 
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column sys_users.USER_NAME
     * 
     * @mbggenerated
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column sys_users.USER_PASSWORD
     * 
     * @mbggenerated
     */
    private String userPassword;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column sys_users.USER_RELNAME
     * 
     * @mbggenerated
     */
    private String userRelname;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column sys_users.ROLE_ID
     * 
     * @mbggenerated
     */
    private Integer roleId;

    /** The role name. */
    private String roleName;

    /**
     * Gets the role name.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the role name.
     *
     * @param roleName the new role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * This field was generated by MyBatis Generator. 
     * This field corresponds to
     * the database column sys_users.USER_DESC
     * 
     * @mbggenerated
     */
    private String userDesc;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column sys_users.CREATE_DATE
     * 
     * @mbggenerated
     */
    private Date createDate;

    /** The create time. */
    private String createTime;

    /**
     * Gets the creates the time.
     *
     * @return the creates the time
     */
    public String getCreateTime() {
        if (createDate != null) {
            createTime = TimeUtils
                    .getStringFromTime(createDate, TimeUtils.FORMAT_DATE_TIME_SECONDS);
        }
        return createTime;
    }

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column sys_users.STATE
     * 
     * @mbggenerated
     */
    private String state;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column sys_users.WRONGCOUNT
     * 
     * @mbggenerated
     */
    private Integer wrongcount;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column sys_users.LASTWROTIME
     * 
     * @mbggenerated
     */
    private Date lastwrotime;

    /** The last time. */
    private String lastTime;

    /**
     * Gets the last time.
     *
     * @return the last time
     */
    public String getLastTime() {
        if (lastwrotime != null) {
            lastTime = TimeUtils.getStringFromTime(lastwrotime, TimeUtils.FORMAT_DATE_TIME_SECONDS);
        }
        return lastTime;
    }

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column sys_users.PHONE
     * 
     * @mbggenerated
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column sys_users.EMAIL
     * 
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column sys_users.CONTACTS
     * 
     * @mbggenerated
     */
    private String contacts;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column sys_users.COMPANY
     * 
     * @mbggenerated
     */
    private String company;

    /** The login status. */
    private boolean loginStatus;

    /**
     * Checks if is login status.
     *
     * @return true, if is login status
     */
    public boolean isLoginStatus() {
        return loginStatus;
    }

    /**
     * Sets the login status.
     *
     * @param loginStatus the new login status
     */
    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    /** The token. */
    private String token;

    /**
     * Gets the token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token.
     *
     * @param token the new token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /** The sys roles manual. */
    private SysRolesManual sysRolesManual;

    /**
     * Gets the sys roles manual.
     *
     * @return the sys roles manual
     */
    public SysRolesManual getSysRolesManual() {
        return sysRolesManual;
    }

    /**
     * Sets the sys roles manual.
     *
     * @param sysRolesManual the new sys roles manual
     */
    public void setSysRolesManual(SysRolesManual sysRolesManual) {
        this.sysRolesManual = sysRolesManual;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column sys_users.USER_ID
     * 
     * @return the value of sys_users.USER_ID
     * 
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column sys_users.USER_ID
     * 
     * @param userId
     *            the value for sys_users.USER_ID
     * 
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column sys_users.USER_NAME
     * 
     * @return the value of sys_users.USER_NAME
     * 
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column sys_users.USER_NAME
     * 
     * @param userName
     *            the value for sys_users.USER_NAME
     * 
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column sys_users.USER_PASSWORD
     * 
     * @return the value of sys_users.USER_PASSWORD
     * 
     * @mbggenerated
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column sys_users.USER_PASSWORD
     * 
     * @param userPassword
     *            the value for sys_users.USER_PASSWORD
     * 
     * @mbggenerated
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column sys_users.USER_RELNAME
     * 
     * @return the value of sys_users.USER_RELNAME
     * 
     * @mbggenerated
     */
    public String getUserRelname() {
        return userRelname;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column sys_users.USER_RELNAME
     * 
     * @param userRelname
     *            the value for sys_users.USER_RELNAME
     * 
     * @mbggenerated
     */
    public void setUserRelname(String userRelname) {
        this.userRelname = userRelname == null ? null : userRelname.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column sys_users.ROLE_ID
     * 
     * @return the value of sys_users.ROLE_ID
     * 
     * @mbggenerated
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column sys_users.ROLE_ID
     * 
     * @param roleId
     *            the value for sys_users.ROLE_ID
     * 
     * @mbggenerated
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column sys_users.USER_DESC
     * 
     * @return the value of sys_users.USER_DESC
     * 
     * @mbggenerated
     */
    public String getUserDesc() {
        return userDesc;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column sys_users.USER_DESC
     * 
     * @param userDesc
     *            the value for sys_users.USER_DESC
     * 
     * @mbggenerated
     */
    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc == null ? null : userDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column sys_users.CREATE_DATE
     * 
     * @return the value of sys_users.CREATE_DATE
     * 
     * @mbggenerated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column sys_users.CREATE_DATE
     * 
     * @param createDate
     *            the value for sys_users.CREATE_DATE
     * 
     * @mbggenerated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column sys_users.STATE
     * 
     * @return the value of sys_users.STATE
     * 
     * @mbggenerated
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column sys_users.STATE
     * 
     * @param state
     *            the value for sys_users.STATE
     * 
     * @mbggenerated
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column sys_users.WRONGCOUNT
     * 
     * @return the value of sys_users.WRONGCOUNT
     * 
     * @mbggenerated
     */
    public Integer getWrongcount() {
        return wrongcount;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column sys_users.WRONGCOUNT
     * 
     * @param wrongcount
     *            the value for sys_users.WRONGCOUNT
     * 
     * @mbggenerated
     */
    public void setWrongcount(Integer wrongcount) {
        this.wrongcount = wrongcount;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column sys_users.LASTWROTIME
     * 
     * @return the value of sys_users.LASTWROTIME
     * 
     * @mbggenerated
     */
    public Date getLastwrotime() {
        return lastwrotime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column sys_users.LASTWROTIME
     * 
     * @param lastwrotime
     *            the value for sys_users.LASTWROTIME
     * 
     * @mbggenerated
     */
    public void setLastwrotime(Date lastwrotime) {
        this.lastwrotime = lastwrotime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column sys_users.PHONE
     * 
     * @return the value of sys_users.PHONE
     * 
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column sys_users.PHONE
     * 
     * @param phone
     *            the value for sys_users.PHONE
     * 
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column sys_users.EMAIL
     * 
     * @return the value of sys_users.EMAIL
     * 
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column sys_users.EMAIL
     * 
     * @param email
     *            the value for sys_users.EMAIL
     * 
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column sys_users.CONTACTS
     * 
     * @return the value of sys_users.CONTACTS
     * 
     * @mbggenerated
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column sys_users.CONTACTS
     * 
     * @param contacts
     *            the value for sys_users.CONTACTS
     * 
     * @mbggenerated
     */
    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column sys_users.COMPANY
     * 
     * @return the value of sys_users.COMPANY
     * 
     * @mbggenerated
     */
    public String getCompany() {
        return company;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column sys_users.COMPANY
     * 
     * @param company
     *            the value for sys_users.COMPANY
     * 
     * @mbggenerated
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }
}
