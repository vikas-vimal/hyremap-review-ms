package com.designfox.hyremapreviewms.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String description;
    private double rating;
    private Long companyId;

    public Review() {
    }

    public Review(Long id, String name, String title, String description, double rating, Long companyId) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Long getCompany() {
        return companyId;
    }

    public void setCompany(Long companyId) {
        this.companyId = companyId;
    }
}
