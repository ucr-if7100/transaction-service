package ucr.gasIn.transactionservice.domain;

import jakarta.persistence.*;
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
