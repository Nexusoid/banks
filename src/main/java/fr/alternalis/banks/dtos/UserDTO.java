package fr.alternalis.banks.dtos;

/**
 * DTO of the User entity.
 */
public class UserDTO {

    /**
     * @param idUser of the user.
     */
    private Long idUser;

    /**
     * @param username of the user.
     */
    private String username;

    /**
     * @param password of the user.
     */
    private String password;

    /**
     * @param balance of the user.
     */
    private Double balance;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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
