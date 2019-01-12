package net.seehope.college.email;

import java.util.Date;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SendEmail {

	@Resource
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String from;

	@Async
	public void sendMail(String title, String url, String email) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setFrom(from);
		mimeMessageHelper.setTo(email);
		mimeMessageHelper.setText(url, true);
		mimeMessageHelper.setSentDate(new Date());
		mimeMessageHelper.setSubject(title);	
		// 发送
		javaMailSender.send(mimeMessage);
	}

}
