package ucr.gasIn.transactionservice.dto;

import ucr.gasIn.transactionservice.domain.TransactionType;

import java.util.Date;
import java.util.UUID;

public class TransactionDTO {
    private UUID id;
    private UUID idUser;
    private String numRefBank; //numero de referencia bancaria
    private int idAccount;
    private String description;
    private TransactionType type; //gasto o ingreso
    private float amount;
    private Date date;
    private int idCategory;

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
    public int getIdAccount() {
        return idAccount;
    }
}
