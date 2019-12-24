package com.springboot.mybatis.utility;

import java.io.IOException;
import java.util.Properties;

import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtility {

	public static void sendBirthdayWishEmail(String username, String recipient_email) {

		Properties props = new Properties();
		// props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp-mail.outlook.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");

		try {
			Authenticator auth = new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("mahendra.maske@nextenture.com", "jesus@2728");
				}
			};

			Session session = Session.getInstance(props, auth);
			MimeBodyPart mbpBody = new MimeBodyPart();

			MimeMessage msg = new MimeMessage(session);   
			StringBuffer body = new StringBuffer("<html><p style=\"color:TEAL;\"><b>Happy Birthday " + username + ",</b></p>");
			body.append("<p style=\"color:red;\"><i> I wish you A Very Happie Birthday !! </i></p>");
			body.append("<p style=\"color:green;\">I hope you have a wonderful day and that the year ahead is full of fun and adventure </p></br>");
			body.append("<img src=\"cid:image1\" width=\"30%\" height=\"30%\" /><br><br>");
			body.append("<p>Thanks & Regards </p>");
			body.append("Mahendra M");
			body.append("</html>");

			// creates message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(body.toString(), "text/html; charset=UTF-8");

			// creates multi-part
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			mbpBody.setContent(body, "text/html; charset=UTF-8");

			MimeBodyPart imagePart = new MimeBodyPart();
			imagePart.setHeader("Content-ID", "<image1>");
			imagePart.setDisposition(MimeBodyPart.INLINE);

			String imageFilePath = "C:/test/Happy-Birthday.jpg";
			try {
				imagePart.attachFile(imageFilePath);
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			multipart.addBodyPart(imagePart);
			msg.setContent(multipart);

			msg.setSubject("Happie Birthday !!!");
			msg.setFrom(new InternetAddress("mahendra.maske@nextenture.com"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient_email));

			Transport.send(msg);
			System.out.println("Email send to " + username + " successfully");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
