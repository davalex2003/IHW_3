package JSON;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Exception {

    @JsonProperty("type")
    private String type;

    @JsonProperty("description")
    private String description;

    public Exception(String type, String description) {
        this.type = type;
        this.description = description;
    }
}
