package fr.alternalis.banks.controllers.rest.json.response;

public class ErrorResponseJson {

    private String error;

    public ErrorResponseJson(String error){
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
