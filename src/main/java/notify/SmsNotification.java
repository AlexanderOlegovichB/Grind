package notify;

public class SmsNotification extends Notification {
    private String phone;

    public SmsNotification(String phone, String message) {
        super(message, Priority.LOW);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public void send() {
        System.out.println("Sending SMS to: " + phone);
        super.send();
    }
}
