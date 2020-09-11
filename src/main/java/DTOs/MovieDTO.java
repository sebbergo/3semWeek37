/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

import entities.Movie;

/**
 *
 * @author sebas
 */
public class MovieDTO {
    
    private Long id;
    private int year;
    private String title;
    private String author;
    
    public MovieDTO(Movie movie){
        this.id = movie.getId();
        this.year = movie.getYear();
        this.title = movie.getTitle();
        this.author = movie.getAuthor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "MovieDTO{" + "id=" + id + ", year=" + year + ", title=" + title + ", author=" + author + '}';
    }
    
}
