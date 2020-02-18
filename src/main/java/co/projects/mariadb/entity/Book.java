package co.projects.mariadb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;
    private String _bookName;
    private String _isbn;
    @OneToOne(targetEntity = Author.class,cascade = CascadeType.ALL)
    private Author _author;
}
