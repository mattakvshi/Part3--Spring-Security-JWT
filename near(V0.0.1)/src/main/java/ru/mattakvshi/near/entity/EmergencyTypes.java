package ru.mattakvshi.near.entity;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Emergency_type")
public class EmergencyTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "color")
    private String  color;

    @Column(name = "bg_color")
    private String bgColor;

}
