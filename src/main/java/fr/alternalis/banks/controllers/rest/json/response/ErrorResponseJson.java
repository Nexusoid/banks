package fr.alternalis.banks.controllers.rest.json.response;

/**
 * Representation of the JSON response for an error.
 */
public class ErrorResponseJson {

    /**
     * @param error is the explanation of the error.
     */
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
