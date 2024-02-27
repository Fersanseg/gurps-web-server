package wm.gurpswm.Rest;

public class ClientResponse {
    private Boolean isError;
    private String errorMessage;
    private Object data;

    public ClientResponse(Boolean isError, String errorMessage) throws Exception {
        if (!isError) { throw new Exception("If there's no error then don't specify it, use the other constructor"); }

        this.isError = true;
        this.errorMessage = errorMessage;
        this.data = null;
    }

    public ClientResponse(Object data) {
        this.isError = false;
        this.errorMessage = null;
        this.data = data;
    }

    public Boolean getIsError() { return isError; }
    public String getErrorMessage() { return errorMessage; }
    public Object getData() { return data; }
}
