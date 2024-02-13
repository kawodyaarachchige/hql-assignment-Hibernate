package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String title;

    private int publicationYear;

    private double price;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id") private Author author;
}
