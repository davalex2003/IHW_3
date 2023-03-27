package AgentObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Cook {

    @JsonProperty("cook_id")
    private int cook_id;

    @JsonProperty("cook_name")
    private String cook_name;

    @JsonProperty("cook_active")
    private boolean active;

    public int getCook_id() {
        return cook_id;
    }

    @Override
    public String toString() {
        return "Cook{" +
                "id=" + cook_id +
                ", name='" + cook_name + '\'' +
                ", available=" + active +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cook cook = (Cook) obj;
        if (cook_id != cook.cook_id) {
            return false;
        }
        if (active != cook.active) {
            return false;
        }
        return Objects.equals(cook_name, cook.cook_name);
    }

    @Override
    public int hashCode() {
        int result = cook_id;
        result = 31 * result + (cook_name != null ? cook_name.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        return result;
    }
}
