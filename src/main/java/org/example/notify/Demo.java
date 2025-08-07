package org.example.notify;

public class Demo {
    public static void main(String[] args) {
        Notification[] notifications = {
                new SmsNotification("+79991234567", "1234"),
                new EmailNotification("admin@company.com", "Отчёт готов"),
                new Notification("Сообщение", Priority.NORMAL) {
                    @Override
                    public void send() {

                    }
                }
        };

        for (Notification notification : notifications) {
            notification.send();
        }
        System.out.println("Кол-во сообщений: " + notifications.length);
    }
}
