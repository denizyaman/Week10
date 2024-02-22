import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "category_id",columnDefinition = "serial")
    private int id;
    @Column (name = "category_name",length = 100,nullable = false)
    private String name;
    @Column (name = "description")
    private String description;
    @ManyToMany (mappedBy = "categoryList", fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<Book> CategoryBookList;

    public Category() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getCategoryBookList() {
        return CategoryBookList;
    }

    public void setCategoryBookList(List<Book> categoryBookList) {
        CategoryBookList = categoryBookList;
    }
}
