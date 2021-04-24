package fr.alternalis.banks.entities;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "USERID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "USERNAME", length = 60, unique = true)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "BALANCE", scale = 2)
    private Double balance;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
