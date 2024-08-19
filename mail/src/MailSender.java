import java.util.Properties;

public class MailSender {
    public static void main(String[] args) {
        String title="안녕하세요";
        String content="메일 보애기 test 메일 입니다.";
        String user_name="psy19953126@naver.com";
        String password="3FS1EQCW38QG";

        SendMail sendMail = new SendMail();
        sendMail.goMail(sendMail.setting(new Properties(), user_name, password), title, content);
    }
}
