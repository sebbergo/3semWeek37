package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
@NamedQuery(name = "Movie.deleteAllRows", query = "DELETE from Movie"),
@NamedQuery(name = "Movie.getAll", query = "SELECT m FROM Movie m"),
@NamedQuery(name = "Movie.getByTitle", query = "SELECT m FROM Movie m WHERE m.title LIKE CONCAT('%',:title,'%')"),
@NamedQuery(name = "Movie.getById", query = "SELECT m FROM Movie m WHERE m.id = :id")
})
//@NamedQuery(name = "Movie.deleteAllRows", query = "DELETE from Movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int year;
    private String title;
    private String author;

    public Movie(String title, int year, String author) {
        this.year = year;
        this.title = title;
        this.author = author;
    }
    
    public Movie() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setActors(String author) {
        this.author = author;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
