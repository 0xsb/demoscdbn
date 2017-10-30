package com.cmcc.ms.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmcc.ms.common.utils.SessionUtils;
import com.cmcc.ms.common.utils.VerifyCodeUtil;

/**
 * 生成验证码.
 *
 * @author ldy
 */
public class CheckImgServlet extends HttpServlet {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7359368207253069482L;

    /** The log. */
    private transient Logger log = LoggerFactory.getLogger(this.getClass());

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        doPost(req, resp);
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置页面不缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_LOWER, 4, null);
        // 将验证码放到HttpSession里面
        SessionUtils.setAttribute(request, "verifyCode", verifyCode);
        log.info("可爱的验证码：" + verifyCode + " ");
        // 设置输出的内容的类型为JPEG图像
        response.setContentType("image/jpeg");
        BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 95, 48, 0,
                false, new Color(234, 242, 253), new Color(60, 149, 239), null);
        // 写给浏览器
        ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
    }

}
