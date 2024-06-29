package ru.mattakvshi.near.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name ="Notification_templates")
public class NotificationTemplate {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(
            name = "template_id",
            updatable = false,
            nullable = false
    )
    @JsonSerialize(using = ToStringSerializer.class)
    private UUID id;


    @Column(name = "template_name")
    private String templateName;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    // Другие поля и методы, если необходимо
}
