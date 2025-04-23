package NotificationAndRemainder;


import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;


public class EmailNotification implements Notifiable{
    public void sendMail(String messageText, String receiver, String subject) {
        final String username = "notzaidabbas1@gmail.com";      // sender email
        final String password = "0000 1111 2222 3333";         // App password here like" 0000 1111 2222 3333 ";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
       // props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
      //  props.put("mail.debug", "true");  // optional: see more details


        Session session = Session.getInstance(props, new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
            message.setSubject(subject);
            message.setText(messageText);

            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}


