import java.util.Scanner;

public class main {
    public static void main(String[] args)  {

        sendMail();
    }

    private static void test1 () {
        Mail mail = new Mail();
        mail.setRecipient("yuriy@solovyoy.de");
        mail.setSubject("Test Email");
        mail.setMessage("Hallo wie geht es dir?");

        try {
            Sender sender = new Sender();
            sender.send(mail);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void sendMail() {

        Scanner eingabe = new Scanner(System.in);
        System.out.println("Bitte Empfänger eingeben: ");
        String Recipient = eingabe.nextLine();
        System.out.println("Bitte Betreff eingeben: ");
        String Subject = eingabe.nextLine();
        System.out.println("Bitte Mailinhalt eingeben: ");
        String Message = eingabe.nextLine();

        Mail newmail = new Mail();

        newmail.setRecipient(Recipient);
        newmail.setSubject(Subject);
        newmail.setMessage(Message);

        try {
            Sender sender = new Sender();
            sender.send(newmail);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}
