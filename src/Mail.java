public class Mail {

    //Att
    private String sender;
    private String recipient;
    private String subject;
    private String message;


    public Mail() {

    }
    public String getSender() {
        return this.sender;
    }
    //bei boolean is/has

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
