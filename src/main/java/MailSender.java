//для отправки письма
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailSender {
	private String username;
	private String password;
	private Properties properties;
	
	public MailSender (String username, String password) {
		this.username = username;
		this.password = password;
		
		properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
	}
	
	public void Send(String subject, String text, String fromEmail, String toEmail) {
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try{
			Message message = new MimeMessage(session);
			//от кого
			message.setFrom(new InternetAddress(username));
			//кому
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			//заголовок письма
			message.setSubject(subject);
			//содержимое
			message.setText(text);
			//отправляем сообщение
			Transport.send(message);
		}catch (MessagingException e){
			throw new RuntimeException(e);
		}
	}
}