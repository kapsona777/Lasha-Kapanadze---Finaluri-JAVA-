package lasha.kapanadze.demo.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;

    @ToString.Exclude
    @OneToOne( mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //
    private List<Attachment> attachments = new ArrayList<>();

    @ToString.Exclude
    @ManyToMany( mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //
    private List<Author> authors = new ArrayList<>();

    @ToString.Exclude
    @OneToMany( mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //
    private List<Tag> tags = new ArrayList<>();
}

