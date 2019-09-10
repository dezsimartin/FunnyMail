package hu.flowacademy.FunnyMail.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class MessageModel {
    private UUID id;
    private UserModel from;
    private UserModel to;
    private String content;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public MessageModel(UUID id, UserModel from, UserModel to, String content, LocalDateTime updatedAt) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.content = content;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserModel getFrom() {
        return from;
    }

    public void setFrom(UserModel from) {
        this.from = from;
    }

    public UserModel getTo() {
        return to;
    }

    public void setTo(UserModel to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
