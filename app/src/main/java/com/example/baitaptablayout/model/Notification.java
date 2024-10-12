package com.example.baitaptablayout.model;

public class Notification {
    private int notificationId;
    private String title;
    private String message;
    private String createdDate;
    private boolean isRead;

    public Notification(int notificationId, String title, String message, String createdDate, boolean isRead) {
        this.notificationId = notificationId;
        this.title = title;
        this.message = message;
        this.createdDate = createdDate;
        this.isRead = isRead;
    }

    public Notification(String title, String createdDate, boolean isRead) {
        this.title = title;
        this.createdDate = createdDate;
        this.isRead = isRead;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}

