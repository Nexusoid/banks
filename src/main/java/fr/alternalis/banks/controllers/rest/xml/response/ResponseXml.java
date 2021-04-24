package fr.alternalis.banks.controllers.rest.xml.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class ResponseXml {

    @JacksonXmlProperty
    private Integer value;

    @JacksonXmlProperty
    private String information;

    public ResponseXml(Integer value, String information) {
        this.value = value;
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
