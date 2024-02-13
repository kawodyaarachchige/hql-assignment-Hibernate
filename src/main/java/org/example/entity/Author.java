package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Author {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private String name;

   private String country;

   @OneToMany (mappedBy = "author", cascade = CascadeType.ALL,orphanRemoval = true)
   private List<Books> books;


}
