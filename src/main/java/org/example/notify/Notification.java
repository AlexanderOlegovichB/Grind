package org.example.notify;

public abstract class Notification implements Sendable {
    private final int id;
    private String message;
    private Priority priority;
    private static int nextId = 1;

    public Notification() {
        this("empty", Priority.NORMAL);
    }

    public Notification(String message, Priority priority) {
        this.id = nextId++;
        this.message = message;
        this.priority = priority;
    }

    public abstract void send();

    public void send(String extra) {
        System.out.println(toString() + "Extra: " + extra);
    }

    @Override
    public String toString() {
        return "Notification: " + message + " " + " Priority: " + priority;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Priority getPriority() {
        return priority;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}