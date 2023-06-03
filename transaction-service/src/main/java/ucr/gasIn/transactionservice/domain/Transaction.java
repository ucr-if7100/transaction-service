package ucr.gasIn.transactionservice.domain;

import jakarta.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idUser;
    private String numRefBank; //numero de referencia bancaria
    private String description;
    private char type;
    private float amount;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category idCategory;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Account.class)
    @JoinColumn(name = "account_id")
    private Account idAccount;

    public Transaction(int id, int idUser, String numRefBank, String description, char type, float amount, Category idCategory, Account idAccount) {
        this.setId(id);
        this.setIdUser(idUser);
        this.setNumRefBank(numRefBank);
        this.setDescription(description);
        this.setType(type);
        this.setAmount(amount);
        this.setIdCategory(idCategory);
        this.setIdAccount(idAccount);
    }

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNumRefBank() {
        return numRefBank;
    }

    public void setNumRefBank(String numRefBank) {
        this.numRefBank = numRefBank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    public Account getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Account idAccount) {
        this.idAccount = idAccount;
    }
}
