import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Sender {

    private SMTP smtp = null;
    private Session session = null;
    public Sender(){
        this.smtp = new SMTP();
        this.session = this.smtp.getSMTPConnection();
    }

    public boolean send(Mail mail) throws Exception {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(this.smtp.getFrom()));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(mail.getRecipient()));

        message.setSubject(mail.getSubject());

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(mail.getMessage(), "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);
        //try {
            Transport.send(message);
        //} catch (MessagingException ex) {
        //    throw new Exception("ERROR: Message cannot be sent! ");
        //}


        return true;
    }
}
