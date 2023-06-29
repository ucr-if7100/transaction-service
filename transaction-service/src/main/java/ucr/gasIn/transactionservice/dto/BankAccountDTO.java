package ucr.gasIn.transactionservice.dto;

import ucr.gasIn.transactionservice.domain.BankAccount;
import ucr.gasIn.transactionservice.domain.BankAccountType;

import java.util.UUID;

public class BankAccountDTO {

    private UUID id;
    private String accountName;
    private String bankName;
    private BankAccountType bankAccountType;
    private Float currentBalance;
    private String card;
    private String iban;
    private String phoneNumber;
    private UUID id_user;
    private boolean active;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BankAccountType getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(BankAccountType bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public Float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Float currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UUID getId_user() {
        return id_user;
    }

    public void setId_user(UUID id_user) {
        this.id_user = id_user;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    private BankAccountDTO(){
    }


    public static class builder{
        private UUID id;
        private String accountName;
        private String bankName;
        private BankAccountType bankAccountType;
        private Float currentBalance;
        private String card;
        private String iban;
        private String phoneNumber;
        private UUID id_user;
        private boolean active;
        private BankAccount bankAccount;

        public builder(BankAccount bankAccount){
            this.bankAccount=bankAccount;
        }

        public builder getAccountNumberResponse(){
            this.accountName=bankAccount.getAccountName();
            this.id=bankAccount.getId();
            this.bankName=bankAccount.getBankName();
            this.bankAccountType=bankAccount.getBankAccountType();
            this.currentBalance=bankAccount.getCurrentBalance();
            this.card=bankAccount.getCard();
            this.iban=bankAccount.getIban();
            this.id_user=bankAccount.getId_user();
            this.phoneNumber=bankAccount.getPhoneNumber();
            this.active=bankAccount.getActive();
            return this;
        }
        public builder getUserIdResponse(){
            this.accountName=bankAccount.getAccountName();
            this.id=bankAccount.getId();
            this.bankName=bankAccount.getBankName();
            this.bankAccountType=bankAccount.getBankAccountType();
            this.currentBalance=bankAccount.getCurrentBalance();
            this.card=bankAccount.getCard();
            this.iban=bankAccount.getIban();
            this.phoneNumber=bankAccount.getPhoneNumber();
            this.active=bankAccount.getActive();
            return this;
        }

        public BankAccountDTO build(){
            BankAccountDTO bankAccountDTO = new BankAccountDTO();
            bankAccountDTO.setAccountName(accountName);
            bankAccountDTO.setId(id);
            bankAccountDTO.setBankName(bankName);
            bankAccountDTO.setBankAccountType(bankAccountType);
            bankAccountDTO.setCurrentBalance(currentBalance);
            bankAccountDTO.setCard(card);
            bankAccountDTO.setIban(iban);
            bankAccountDTO.setPhoneNumber(phoneNumber);
            bankAccountDTO.setId_user(id_user);
            bankAccountDTO.setActive(active);
            return bankAccountDTO;
        }

    }

}