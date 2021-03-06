package libraries;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class SendingEmails {

    public static void main(String[] args) throws MalformedURLException, EmailException {
        
      EmailAttachment attachment = new EmailAttachment();
      attachment.setURL(new URL("http://d3dsacqprgcsqh.cloudfront.net/photo/azbW3zq_460sa_v1.gif"));
      attachment.setDisposition(EmailAttachment.ATTACHMENT);
      attachment.setDescription("some gif");
      attachment.setName("gif");

      MultiPartEmail email = new MultiPartEmail();
      
      email.setHostName("smtp.gmail.com");
      email.addTo("email@example.bg", "some stuff");
      
      email.setAuthenticator(new DefaultAuthenticator("your_email@example.com", "password"));
      email.setSSLOnConnect(true);
      
      email.setFrom("your_email@example.com", "Me");
      email.setSubject("The logo");
      email.setMsg("Here is something i wanted to send you.");
      
      email.attach(attachment);

      email.send();
    }
}
