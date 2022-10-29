package com.exam.model.exam;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.boot.web.reactive.context.GenericReactiveWebApplicationContext;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long cid;

    private String title;

    private String description;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Quiz> quizzes = new LinkedHashSet<>();
    public Category() {
    }

    public Category(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getCid() {
        return cid;
    }
}
