package org.example.notify;

import java.util.List;
import java.util.Optional;

public class Demo2 {
    public static void main(String[] args) {
        NotificationManager<Notification> manager = new NotificationManager<>();
        try {
            EmailNotification email1 = new EmailNotification("pochta1@lol.ru", "Опа");
            EmailNotification email2 = new EmailNotification("pochta2@lol.ru", "Опа2");
            SmsNotification sms1 = new SmsNotification("88005553535", "Это смс типа");


            manager.addNotify(email1);
            manager.addNotify(sms1);
            manager.addNotify(email2);

            try {
                manager.addNotify(email1); // как я добавлю дубликат по id если он автоинкремент?
            } catch (DuplicateExсeption e) {
                System.out.println("Дубликат уведомления: " + e.getMessage());
            }

            System.out.println("Высокий приоритет: ");
            List<Notification> highPriority = manager.get(Priority.HIGH);
            for (Notification n : highPriority) {
                System.out.println("ID сообщения: " + n.getId() + " / Тело сообщения: " + n.getMessage());
            }

            int searchForID = email1.getId();
            Optional<Notification> founded = manager.find(searchForID);
            if (founded.isPresent()) {
                founded.get().send();
            } else {
                System.out.println("Уведомление по ID " + searchForID + " не найдено");
            }
            manager.sendAll();

            email2.sendWithLogging();
        }


        catch (DuplicateExсeption e2) {
            System.out.println("Ошибка добавления " + e2.getMessage());
        }
    }
}