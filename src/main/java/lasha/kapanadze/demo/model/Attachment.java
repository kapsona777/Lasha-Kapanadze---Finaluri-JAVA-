package lasha.kapanadze.demo.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pdfurl;


    @ToString.Exclude
    @OneToOne( mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //
    private List<Book> books = new ArrayList<>();
}
