package fr.alternalis.banks.controllers.rest.xml.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class TransactionRequestXml {

    @JacksonXmlProperty
    private String username;

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
