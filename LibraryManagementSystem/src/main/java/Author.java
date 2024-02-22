import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "author_id",columnDefinition = "serial")
    private int id;
    @Column(name = "author_name", length = 100,nullable = false)
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "author_country")
    private String country;

    @OneToMany(mappedBy = "author")
    private List<Book> authorBookList;

    public Author() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getAuthorBookList() {
        return authorBookList;
    }

    public void setAuthorBookList(List<Book> authorBookList) {
        this.authorBookList = authorBookList;
    }
}
