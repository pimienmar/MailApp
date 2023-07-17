import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class SMTP {

    private static final String FROM = "java-mail@beck-homes.com";
    private static final String USERNAME = "java-mail@beck-homes.com";
    private static final String PASSWORD = "srh_java_2023";
    private static final String HOST = "mail.beck-homes.com";
    private static final String PORT = "465";
    private Properties prop = null;

    public SMTP(){
        Properties prop = new Properties();
        this.prop = new Properties();
        this.prop.put("mail.smtp.auth", true);
        this.prop.put("mail.smtp.starttls.enable", "true");  //Neustes Protokol (SSL wurde schon gehackt)
        this.prop.put("mail.smtp.host", HOST);
        this.prop.put("mail.smtp.port", PORT);
        this.prop.put("mail.smtp.ssl.trust", HOST);
        this.prop.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
    }
    public Session getSMTPConnection() throws NullPointerException {
        Session session = null;
        if (this.prop != null) {
            session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });
        } else {
            throw new NullPointerException("FATAL: Properties not set!");
        }

        return session;
    }

    public String getFrom() {
        return FROM;
    }
}
