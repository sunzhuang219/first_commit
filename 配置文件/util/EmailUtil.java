package zhuang.sun.travel.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import java.util.ResourceBundle;

/**
 * @version V1.0
 * @package com.heima.travel.utils
 * @description: 提供邮件发送通用方法
 * @author: bugun
 * @date: 2019/5/5 16:09
 */
public class EmailUtil {

    private static String hostname;
    private static String username;
    private static String password;
    private static String charset;


    //1、提前读取配置信息
    static {
        //1、类加载器   2、ResourceBundle

        ResourceBundle bundle = ResourceBundle.getBundle("163email");
        hostname = bundle.getString("hostname");
        username = bundle.getString("username");
        password = bundle.getString("password");
        charset = bundle.getString("charset");
    }

    //2、发送邮件
    /**
     * 发送邮件
     * @param emailTo
     * @param msg
     */
    public static void sendEmail(String emailTo, String msg) throws EmailException {

        //1、创建HtmlEmail对象：HtmlEmail
        HtmlEmail htmlEmail = new HtmlEmail();

        //2、设置邮箱服务器参数：硬编码
        //主机地址：发件服务器
        htmlEmail.setHostName(hostname);
        //设置编码
        htmlEmail.setCharset(charset);
        htmlEmail.setAuthentication(username,password);


        //3、设置收件人和发件人
        htmlEmail.setFrom(username, "163邮箱用户");
        htmlEmail.addTo(emailTo);


        //4、设置邮件的主题和正文
        htmlEmail.setSubject("这里是主题");
        htmlEmail.setHtmlMsg(msg);

        //5、发送邮件
        htmlEmail.send();
    }


    public static void main(String[] args) throws EmailException {
        sendEmail("369703638@qq.com","测试一下");

        System.out.println("发送成功");
    }

}
