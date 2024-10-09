package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

    @Entity
    @Table(name = "Book")
    @Getter
    @Setter
    @ToString

    public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String title;
        private String author;
        private Integer publicationYear;
        private Boolean available;

        // Default constructor (optional, Lombok can generate one if needed)
        public Book() {
        }
    }

