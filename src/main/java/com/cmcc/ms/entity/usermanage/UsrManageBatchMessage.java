/**
 * @author ldy
 */
package com.cmcc.ms.entity.usermanage;

import java.util.Date;


/**
 * The Class UsrManageBatchMessage.
 */
public class UsrManageBatchMessage {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usr_manage_batch_message.ID
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usr_manage_batch_message.OPERATE_USER_NAME
     *
     * @mbggenerated
     */
    private String operateUserName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usr_manage_batch_message.MSG_STATE_CODE
     *
     * @mbggenerated
     */
    private Integer msgStateCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usr_manage_batch_message.MSG_STATE_NAME
     *
     * @mbggenerated
     */
    private String msgStateName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usr_manage_batch_message.MSG_SEND_TIME
     *
     * @mbggenerated
     */
    private Date msgSendTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usr_manage_batch_message.RECEIVE_NUM
     *
     * @mbggenerated
     */
    private Integer receiveNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usr_manage_batch_message.OPERATE_TIME
     *
     * @mbggenerated
     */
    private Date operateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usr_manage_batch_message.ID
     *
     * @return the value of usr_manage_batch_message.ID
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usr_manage_batch_message.ID
     *
     * @param id the value for usr_manage_batch_message.ID
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usr_manage_batch_message.OPERATE_USER_NAME
     *
     * @return the value of usr_manage_batch_message.OPERATE_USER_NAME
     *
     * @mbggenerated
     */
    public String getOperateUserName() {
        return operateUserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usr_manage_batch_message.OPERATE_USER_NAME
     *
     * @param operateUserName the value for usr_manage_batch_message.OPERATE_USER_NAME
     *
     * @mbggenerated
     */
    public void setOperateUserName(String operateUserName) {
        this.operateUserName = operateUserName == null ? null : operateUserName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usr_manage_batch_message.MSG_STATE_CODE
     *
     * @return the value of usr_manage_batch_message.MSG_STATE_CODE
     *
     * @mbggenerated
     */
    public Integer getMsgStateCode() {
        return msgStateCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usr_manage_batch_message.MSG_STATE_CODE
     *
     * @param msgStateCode the value for usr_manage_batch_message.MSG_STATE_CODE
     *
     * @mbggenerated
     */
    public void setMsgStateCode(Integer msgStateCode) {
        this.msgStateCode = msgStateCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usr_manage_batch_message.MSG_STATE_NAME
     *
     * @return the value of usr_manage_batch_message.MSG_STATE_NAME
     *
     * @mbggenerated
     */
    public String getMsgStateName() {
        return msgStateName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usr_manage_batch_message.MSG_STATE_NAME
     *
     * @param msgStateName the value for usr_manage_batch_message.MSG_STATE_NAME
     *
     * @mbggenerated
     */
    public void setMsgStateName(String msgStateName) {
        this.msgStateName = msgStateName == null ? null : msgStateName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usr_manage_batch_message.MSG_SEND_TIME
     *
     * @return the value of usr_manage_batch_message.MSG_SEND_TIME
     *
     * @mbggenerated
     */
    public Date getMsgSendTime() {
        return msgSendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usr_manage_batch_message.MSG_SEND_TIME
     *
     * @param msgSendTime the value for usr_manage_batch_message.MSG_SEND_TIME
     *
     * @mbggenerated
     */
    public void setMsgSendTime(Date msgSendTime) {
        this.msgSendTime = msgSendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usr_manage_batch_message.RECEIVE_NUM
     *
     * @return the value of usr_manage_batch_message.RECEIVE_NUM
     *
     * @mbggenerated
     */
    public Integer getReceiveNum() {
        return receiveNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usr_manage_batch_message.RECEIVE_NUM
     *
     * @param receiveNum the value for usr_manage_batch_message.RECEIVE_NUM
     *
     * @mbggenerated
     */
    public void setReceiveNum(Integer receiveNum) {
        this.receiveNum = receiveNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usr_manage_batch_message.OPERATE_TIME
     *
     * @return the value of usr_manage_batch_message.OPERATE_TIME
     *
     * @mbggenerated
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usr_manage_batch_message.OPERATE_TIME
     *
     * @param operateTime the value for usr_manage_batch_message.OPERATE_TIME
     *
     * @mbggenerated
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}
