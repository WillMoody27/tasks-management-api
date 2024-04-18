package com.example.tasksmanagementapi.users;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "descr")
    private String descr;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "priority")
    private String priority;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "status_id", nullable = false)
    private Long statusId;

    @ManyToOne(fetch = FetchType.EAGER) // FetchType.LAZY is the default
    @JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false, insertable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER) // FetchType.LAZY is the default
    @JoinColumn(name = "category_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER) // FetchType.LAZY is the default
    @JoinColumn(name = "status_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Status status;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
