import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
    final String ENCODING = "UTF-8";
    final String PORT ="465";
    final String SMTPHOST = "smtp.naver.com";
    final String TO = "dm0608@naver.com";

    public Session setting(Properties props, String user_name, String password) {
        Session session = null;
        try{
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", SMTPHOST);
            props.put("mail.smtp.port", PORT);
            props.put("mail.smtp.auth", true);
            props.put("mail.smtp.ssl.enable", true);
            props.put("mail.smtp.ssl.trust", SMTPHOST);
            props.put("mail.smtp.starttls.required", true);
            props.put("mail.smtp.starttls.enable", true);
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");

            props.put("mail.smtp.quit-wait", "false");
            props.put("mail.smtp.socketFactory.port", PORT);
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");

            session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user_name, password);
                }
            });
        }catch (Exception e){
            System.out.println("Session Setting 실패");
        }
        return  session;

    }

    public void goMail(Session session, String title, String content){
        Message msg = new MimeMessage(session);

        try{
            msg.setFrom(new InternetAddress("psy19953126@naver.com", "관리자", ENCODING));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));
            msg.setSubject(title);
            msg.setContent(content, "text/html; charset=utf-8");

            Transport.send(msg);
            System.out.println("메일보내기 성공");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("메일 보내기 실패");
        }
    }
}
