package fr.alternalis.banks.dtos;

import fr.alternalis.banks.enums.OperationType;

import java.time.LocalDate;

public class OperationDTO {

    private Long id;

    private OperationType type;

    private Double value;

    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
