package mk.ukim.finki.emt.lab2.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mk.ukim.finki.emt.lab2.model.enumerations.CategoryBook;

import javax.persistence.*;


@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryBook category;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

    public Book(){

    }

    public Book(String name, CategoryBook category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
