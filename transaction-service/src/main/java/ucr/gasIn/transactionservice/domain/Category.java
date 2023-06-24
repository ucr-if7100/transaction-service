package ucr.gasIn.transactionservice.domain;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int id_user;

    public Category(int id, String name, String description, int idUser) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.id_user = idUser;
    }
    public Category(){}

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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
