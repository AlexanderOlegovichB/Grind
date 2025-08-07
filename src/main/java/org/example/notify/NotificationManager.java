package org.example.notify;

import java.util.*;

public class NotificationManager <T extends Notification> {
    private final List<T> list = new ArrayList<>();
    private final Map<Priority, List<T>> map = new HashMap<>();

    public void addNotify(T notification) throws DuplicateExсeption {
        for (T n : list) {
            if (n.getId() == notification.getId()) {
                throw new DuplicateExсeption("Уведомление с идентификатором " + notification.getId() + " уже существует.");
            }
        }
        list.add(notification);
        Priority priority = notification.getPriority();
        map.computeIfAbsent(priority, k -> new ArrayList<>()).add(notification);
    }

    public Optional<T>find(int id) {
        for (T n : list) {
            if (n.getId() == id) {
                return Optional.of(n);
            }
        }
        return Optional.empty();
    }
    public List<T> get(Priority priority) {
        List<T> list = map.get(priority);
        if(list == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(list);
    }
   public void sendAll() {
        Sendable.sendAll(list);
   }
}
