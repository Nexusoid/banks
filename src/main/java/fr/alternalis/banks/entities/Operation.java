package fr.alternalis.banks.entities;

import fr.alternalis.banks.enums.OperationType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "OPERATION")
public class Operation {

    @Id
    @Column(name = "OPERATIONID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER", referencedColumnName = "USERID")
    private User user;

    @Column(name = "TYPE")
    private OperationType type;

    @Column(name = "VALUE", scale = 2)
    private Double value;

    @Column(name = "DATE")
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
