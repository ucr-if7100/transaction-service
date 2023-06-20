package ucr.gasIn.transactionservice.dto;

import ucr.gasIn.transactionservice.domain.BankAccount;
import ucr.gasIn.transactionservice.domain.BankAccountType;

public class BankAccountDTO {

    private int accountNumber;
    private String accountName;
    private String bankName;
    private BankAccountType bankAccountType;
    private Float currentBalance;
    private String card;
    private String iban;
    private String phoneNumber;
    private int id_user;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    private BankAccountDTO(){
    }


    public static class builder{
        private int accountNumber;
        private String accountName;
        private String bankName;
        private BankAccountType bankAccountType;
        private Float currentBalance;
        private String card;
        private String iban;
        private String phoneNumber;
        private int id_user;
        private BankAccount bankAccount;

        public builder(BankAccount bankAccount){
            this.bankAccount=bankAccount;
        }

        public builder getAccountNumberResponse(){
            this.accountName=bankAccount.getAccountName();
            this.accountNumber=bankAccount.getAccountNumber();
            this.bankName=bankAccount.getBankName();
            this.bankAccountType=bankAccount.getBankAccountType();
            this.currentBalance=bankAccount.getCurrentBalance();
            this.card=bankAccount.getCard();
            this.iban=bankAccount.getIban();
            this.id_user=bankAccount.getId_user();
            return this;
        }
        public builder getUserIdResponse(){
            this.accountName=bankAccount.getAccountName();
            this.accountNumber=bankAccount.getAccountNumber();
            this.bankName=bankAccount.getBankName();
            this.bankAccountType=bankAccount.getBankAccountType();
            this.currentBalance=bankAccount.getCurrentBalance();
            this.card=bankAccount.getCard();
            this.iban=bankAccount.getIban();
            return this;
        }

        public BankAccountDTO build(){
            BankAccountDTO bankAccountDTO = new BankAccountDTO();
            bankAccountDTO.setAccountName(accountName);
            bankAccountDTO.setAccountNumber(accountNumber);
            bankAccountDTO.setBankName(bankName);
            bankAccountDTO.setBankAccountType(bankAccountType);
            bankAccountDTO.setCurrentBalance(currentBalance);
            bankAccountDTO.setCard(card);
            bankAccountDTO.setIban(iban);
            bankAccountDTO.setPhoneNumber(phoneNumber);
            bankAccountDTO.setId_user(id_user);
            return bankAccountDTO;
        }

    }

}