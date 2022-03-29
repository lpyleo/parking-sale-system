package com.event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * 申请通过后发送Email监听器
 */
@Component
public class DeveloperRegisterAfterSendEmailListener implements ApplicationListener<DeveloperRegisterAfterEvent>{

    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void onApplicationEvent(DeveloperRegisterAfterEvent developerRegisterAfterEvent) {
        System.out.println("发送Email给用户");
        String id=developerRegisterAfterEvent.getSource().toString();
        System.out.println(id+"已发送成功");
        System.out.println(id);
        SimpleMailMessage message = new SimpleMailMessage();
        //发件人的邮箱地址
        message.setFrom("764327916@qq.com");
        //收件人的邮箱地址
        message.setTo(id);
        //邮件主题
        message.setSubject("申请结果");
        //邮件内容
        message.setText("恭喜您，申请通过，您的初始密码为：123。请上线后尽快修改密码。");
        //发送邮件
        javaMailSender.send(message);
    }
}
