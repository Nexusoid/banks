package fr.alternalis.banks.controllers.rest.xml.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * XML representation of a transaction request.
 */
@JacksonXmlRootElement
public class TransactionRequestXml {

    /**
     * @param username is the name linked to the user account.
     */
    @JacksonXmlProperty
    private String username;

    /**
     * @param value is the value that need to be added/subtracted to the account.
     */
    @JacksonXmlProperty
    private String value;

    public TransactionRequestXml(String username, String value) {
        this.username = username;
        this.value = value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
