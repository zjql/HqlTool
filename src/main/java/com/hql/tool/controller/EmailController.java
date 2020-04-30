package com.hql.tool.controller;


import com.hql.tool.config.msg.BaseResponse;
import com.hql.tool.config.msg.ResponseMsgUtil;
import com.hql.tool.service.impl.IMailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
/**
 * @author zhangzhijie
 * 2020/5/21 14:49
 */
@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    private IMailServiceImpl mailService;
    @Autowired
    private TemplateEngine templateEngine;
    private static final String mailBodyTemplate = "<h5>" +"1 " + "：</span>" +
            "<table border=\"1\" cellpadding=\"3\" style=\"border-collapse:collapse; width:80%;\" >\n" +
            "   <thead style=\"font-weight: bold;color: #ffffff;background-color: #ff8c00;\" >" +
            "      <tr>\n" +
            "         <td width=\"20%\" >"+ "1" +"</td>\n" +
            "         <td width=\"10%\" >"+ "1" +"</td>\n" +
            "         <td width=\"20%\" >"+ "1"+"</td>\n" +
            "         <td width=\"10%\" >"+ "1" +"</td>\n" +
            "         <td width=\"40%\" >"+ "1"+"</td>\n" +
            "      </tr>\n" +
            "   </thead>\n" +
            "   <tbody>\n" +
            "      <tr>\n" +
            "         <td>{0}</td>\n" +
            "         <td>{1}</td>\n" +
            "         <td>{2}</td>\n" +
            "         <td>"+ "1"+"</td>\n" +
            "         <td>{3}</td>\n" +
            "      </tr>\n" +
            "   </tbody>\n" +
            "</table>";

    @RequestMapping
    public BaseResponse index(){
        try {
            mailService.sendSimpleMail("1493767528@qq.com","年轻人",mailBodyTemplate);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseMsgUtil.error(-1,"邮件发送失败");
        }
        return ResponseMsgUtil.success(200,"发送成功");
    }

    @RequestMapping("/htmlEmail")
    public BaseResponse htmlEmail(){
        try {
            mailService.sendHtmlMail("123@126.com","IJPay让支付触手可及","<body style=\"text-align: center;margin-left: auto;margin-right: auto;\">\n"
                    + "	<div id=\"welcome\" style=\"text-align: center;position: absolute;\" >\n"
                    +"		<h3>欢迎使用IJPay -By Javen</h3>\n"
                    +"		<span>https://github.com/Javen205/IJPay</span>"
                    + "		<div\n"
                    + "			style=\"text-align: center; padding: 10px\"><a style=\"text-decoration: none;\" href=\"https://github.com/Javen205/IJPay\" target=\"_bank\" ><strong>IJPay 让支付触手可及,欢迎Start支持项目发展:)</strong></a></div>\n"
                    + "		<div\n" + "			style=\"text-align: center; padding: 4px\">如果对你有帮助,请任意打赏</div>\n"
                    + "		<img width=\"180px\" height=\"180px\"\n"
                    + "			src=\"https://javen205.gitbooks.io/ijpay/content/assets/wxpay.png\">\n"
                    + "	</div>\n" + "</body>");
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseMsgUtil.error(-1,"邮件发送失败!!");
        }
        return ResponseMsgUtil.success(200,"发送成功");
    }

    @RequestMapping("/attachmentsMail")
    public BaseResponse attachmentsMail(){
        try {
            String filePath = "/Users/86135/Desktop/xiao.jpeg";
            mailService.sendAttachmentsMail("1493767528@qq.com", "这是一封带附件的邮件", "邮件中有附件，请注意查收！", filePath);
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseMsgUtil.error(-1,"邮件发送失败!!");
        }
        return ResponseMsgUtil.success(200,"发送成功");
    }

    @RequestMapping("/resourceMail")
    public BaseResponse resourceMail(){
        try {
            String rscId = "IJPay";
            String content = "<html><body>这是有图片的邮件<br/><img src=\'cid:" + rscId + "\' ></body></html>";
            String imgPath = "/Users/Javen/Desktop/IJPay.png";
            mailService.sendResourceMail("xxx@126.com", "这邮件中含有图片", content, imgPath, rscId);

        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseMsgUtil.error(-1,"邮件发送失败!!");
        }
        return ResponseMsgUtil.success(200,"发送成功");
    }

    @RequestMapping("/templateMail")
    public BaseResponse templateMail(){
        try {
            Context context = new Context();
            context.setVariable("project", "IJPay");
            context.setVariable("author", "Javen");
            context.setVariable("url", "https://github.com/Javen205/IJPay");
            String emailContent = templateEngine.process("emailTemp", context);

            mailService.sendHtmlMail("xxx@126.com", "这是模板邮件", emailContent);
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseMsgUtil.error(-1,"邮件发送失败!!");
        }
        return ResponseMsgUtil.success(200,"发送成功");
    }

}
