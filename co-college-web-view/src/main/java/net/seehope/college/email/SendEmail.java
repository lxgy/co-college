package net.seehope.college.email;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SendEmail {

	@Resource
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String from;

	@Async
	public void sendMail(String title, String url, String email) {
		SimpleMailMessage message = new SimpleMailMessage();
		// 发件人
		message.setFrom(from);
		// 标题
		message.setSubject(title);
		// 收件人
		message.setTo(email);
		// 内容
		message.setText(url);
		message.setSentDate(new Date());
		// 发送
		javaMailSender.send(message);
	}

}
