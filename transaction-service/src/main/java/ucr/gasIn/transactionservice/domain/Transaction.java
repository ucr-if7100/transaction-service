package ucr.gasIn.transactionservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;


@Entity
public class Transaction {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(name = "id_user", columnDefinition = "BINARY(16)")
    private UUID idUser;
    @Column(name = "num_ref_bank")
    private String numRefBank; //numero de referencia bancaria
    @Column(name = "id_account")
    private int idAccount;
    private String description;
    @Enumerated(EnumType.STRING)
    private TransactionType type; //gasto o ingreso
    private float amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name = "date")
    private Date date;
    @Column(name = "id_category")
    private int idCategory;

    public Transaction(UUID id, UUID idUser, String numRefBank, int idAccount, String description, TransactionType type, float amount, Date date, int idCategory) {
        this.setId(id);
        this.setIdUser(idUser);
        this.setNumRefBank(numRefBank);
        this.setIdAccount(idAccount);
        this.setDescription(description);
        this.setType(type);
        this.setAmount(amount);
        this.setDate(date);
        this.setIdCategory(idCategory);
    }

    public Transaction(){    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public String getNumRefBank() {
        return numRefBank;
    }

    public void setNumRefBank(String numRefBank) {
        this.numRefBank = numRefBank;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return idUser == that.idUser && idAccount == that.idAccount && Float.compare(that.amount, amount) == 0 && idCategory == that.idCategory && id.equals(that.id) && Objects.equals(numRefBank, that.numRefBank) && Objects.equals(description, that.description) && type == that.type && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUser, numRefBank, idAccount, description, type, amount, date, idCategory);
    }
}
