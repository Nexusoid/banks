package fr.alternalis.banks.controllers.rest.xml.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Representation of the XML response for a standard request.
 */
@JacksonXmlRootElement
public class ResponseXml {

    /**
     * @param value is the code of the response.
     */
    @JacksonXmlProperty
    private Integer value;

    /**
     * @param information is the explanation of the response.
     */
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
