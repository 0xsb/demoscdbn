/*
 * Project: cmcciwms
 * 
 * File Created at 2016年11月5日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.cmcc.ms.entity.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.cmcc.ms.common.utils.SessionUtils;

/**
 * The Class Message.
 *
 * @author huamao
 * @version 
 * @Type Message.java
 * @Desc 
 * @date 2016年11月5日 下午6:28:14
 */
public class Message {

    /**
     * Gets the all phone str to show.
     *
     * @param request the request
     * @return the all phone str to show
     */
    public String getAllPhoneStrToShow(HttpServletRequest request) {
        return (String) SessionUtils.getAttribute(request,
                "allPhoneStrToShow" + SessionUtils.getAttribute(request, "userName"));
    }

    /**
     * Gets the top limit.
     *
     * @param request the request
     * @return the top limit
     */
    public int getTopLimit(HttpServletRequest request) {
        return (int) SessionUtils.getAttribute(request,
                "topLimit" + SessionUtils.getAttribute(request, "userName"));
    }

    /**
     * Sets the top limit.
     *
     * @param request the request
     * @param topLimit the top limit
     */
    public void setTopLimit(HttpServletRequest request, int topLimit) {
        SessionUtils.setAttribute(request,
                "topLimit" + SessionUtils.getAttribute(request, "userName"), topLimit);
    }

    /**
     * Sets the all phone str to show.
     *
     * @param request the request
     * @param allPhoneStrToShow the all phone str to show
     */
    public void setAllPhoneStrToShow(HttpServletRequest request, String allPhoneStrToShow) {
        SessionUtils.setAttribute(request,
                "allPhoneStrToShow" + SessionUtils.getAttribute(request, "userName"),
                allPhoneStrToShow);
    }

    /**
     * Gets the all phone name str to DB.
     *
     * @param request the request
     * @return the all phone name str to DB
     */
    public String getAllPhoneNameStrToDB(HttpServletRequest request) {
        return (String) SessionUtils.getAttribute(request,
                "allPhoneNameStrToDB" + SessionUtils.getAttribute(request, "userName"));
    }

    /**
     * Sets the all phone name str to DB.
     *
     * @param request the request
     * @param allPhoneNameStrToDB the all phone name str to DB
     */
    public void setAllPhoneNameStrToDB(HttpServletRequest request, String allPhoneNameStrToDB) {
        SessionUtils.setAttribute(request,
                "allPhoneNameStrToDB" + SessionUtils.getAttribute(request, "userName"),
                allPhoneNameStrToDB);
    }

    /**
     * Gets the to sendphone counts.
     *
     * @param request the request
     * @return the to sendphone counts
     */
    public int getToSendphoneCounts(HttpServletRequest request) {
        return (int) SessionUtils.getAttribute(request,
                "toSendphoneCounts" + SessionUtils.getAttribute(request, "userName"));
    }

    /**
     * Sets the to sendphone counts.
     *
     * @param request the request
     * @param toSendphoneCounts the to sendphone counts
     */
    public void setToSendphoneCounts(HttpServletRequest request, int toSendphoneCounts) {
        SessionUtils.setAttribute(request,
                "toSendphoneCounts" + SessionUtils.getAttribute(request, "userName"),
                toSendphoneCounts);
    }

    /**
     * Gets the free phone counts.
     *
     * @param request the request
     * @return the free phone counts
     */
    public int getFreePhoneCounts(HttpServletRequest request) {
        return (int) SessionUtils.getAttribute(request,
                "freePhoneCounts" + SessionUtils.getAttribute(request, "userName"));
    }

    /**
     * Sets the free phone counts.
     *
     * @param request the request
     * @param freePhoneCounts the free phone counts
     */
    public void setFreePhoneCounts(HttpServletRequest request, int freePhoneCounts) {
        SessionUtils
                .setAttribute(request,
                        "freePhoneCounts" + SessionUtils.getAttribute(request, "userName"),
                        freePhoneCounts);
    }

    /**
     * Gets the upload file.
     *
     * @param request the request
     * @return the upload file
     */
    public MultipartFile getUploadFile(HttpServletRequest request) {
        return (MultipartFile) SessionUtils.getAttribute(request,
                "uploadFile" + SessionUtils.getAttribute(request, "userName"));
    }

    /**
     * Sets the upload file.
     *
     * @param request the request
     * @param uploadFile the upload file
     */
    public void setUploadFile(HttpServletRequest request, MultipartFile uploadFile) {
        SessionUtils.setAttribute(request,
                "uploadFile" + SessionUtils.getAttribute(request, "userName"), uploadFile);
    }

    /**
     * Gets the phone list.
     *
     * @param request the request
     * @return the phone list
     */
    @SuppressWarnings("unchecked")
    public List<String> getPhoneList(HttpServletRequest request) {
        Object attribute = request.getSession().getAttribute(
                "phoneList" + (String) SessionUtils.getAttribute(request, "userName"));
        System.out.println(attribute);
        return (List<String>) request.getSession().getAttribute(
                "phoneList" + (String) SessionUtils.getAttribute(request, "userName"));
    }

    /**
     * Sets the phone list.
     *
     * @param request the request
     * @param phoneList the phone list
     */
    public void setPhoneList(HttpServletRequest request, List<String> phoneList) {
        request.getSession().setAttribute(
                "phoneList" + SessionUtils.getAttribute(request, "userName"), phoneList);
    }

    /**
     * Adds the list.
     *
     * @param request the request
     * @param trim the trim
     */
    @SuppressWarnings("unchecked")
    public void addList(HttpServletRequest request, String trim) {
        Object attribute = request.getSession().getAttribute(
                "phoneList" + SessionUtils.getAttribute(request, "userName"));
        ((List<String>) attribute).add(trim);
        request.getSession().setAttribute(
                "phoneList" + SessionUtils.getAttribute(request, "userName"),
                (List<String>) attribute);
    }

}
