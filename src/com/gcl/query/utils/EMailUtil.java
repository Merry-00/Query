package com.gcl.query.utils;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class EMailUtil {
    //发件人账号
    private static String fromEmail = "3143357252@qq.com";
    //发件人密码
    private static String fromEmailPw = "muwfrorprrdfdeaj";
    //发件邮箱服务器
    private static String myEmailSMTPHost = "smtp.qq.com";
    //用于参数配置
    private static Properties props;
    //用于创建会话对象
    private static Session session;
    private String vCode;
    public static EMailUtil instance = new EMailUtil();

    /**
     * 获取验证码
     *
     * @return 验证码字符串
     */
    public String getVCode() {
        return vCode;
    }

    /**
     * 构造函数，配置属性
     */
    private EMailUtil() {
        props = new Properties();
        //使用的协议（JavaMail规范要求）
        props.setProperty("mail.transport.protocol", "smtp");
        //发件人的邮箱的SMTP
        props.setProperty("mail.smtp.host", myEmailSMTPHost);
        //需要请求认证
        props.setProperty("mail.smtp.auth", "true");
        session = Session.getInstance(props);

    }

    /**
     * 构建邮件内容
     *
     * @param toEmail 收件人
     * @return 发送邮件内容
     * @throws UnsupportedEncodingException
     * @throws MessagingException
     */

    public MimeMessage createMailContent(String toEmail) throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = new MimeMessage(session);
        //发件人
        message.setFrom(new InternetAddress(fromEmail, "验证码发送系统", "UTF-8"));
        //收件人
        message.setRecipient(RecipientType.TO,new InternetAddress(toEmail));
        //邮件主题
        message.setSubject("验证码","UTF-8");
        //邮件正文
        vCode=VCodeUtil.getRandomString(6);
        message.setContent("您好，您的验证码是："+vCode+"。","text/html;charset=UTF-8");
        //设置发件时间
        message.setSentDate(new Date());
        //保存设置
        message.saveChanges();
        return message;
    }

    /**
     * 发送邮件
     * @param toEmail 收件人
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    public void sendEmail(String toEmail) throws MessagingException, UnsupportedEncodingException {
        Transport transport=session.getTransport();
        transport.connect(fromEmail,fromEmailPw);
        MimeMessage message=createMailContent(toEmail);
        transport.sendMessage(message,message.getAllRecipients());
        System.out.println("验证码发送成功");
        //关闭连接
        transport.close();
    }
}