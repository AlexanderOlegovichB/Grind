package org.example.notify;

public class EmailNotification extends Notification {
    private String email;

    public EmailNotification(String email, String message) {
        super(message, Priority.HIGH);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void send() {
        System.out.println("Sending email to: " + email);
    }
}
