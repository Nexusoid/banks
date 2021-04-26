package fr.alternalis.banks.dtos;

import fr.alternalis.banks.enums.OperationType;

import java.time.LocalDate;

/**
 * DTO of the Operation entity.
 */
public class OperationDTO {

    /**
     * @param id of the operation.
     */
    private Long id;

    /**
     * @param type of the operation.
     */
    private OperationType type;

    /**
     * @param value of the operation.
     */
    private Double value;

    /**
     * @param date of the operation.
     */
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
