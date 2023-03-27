package AgentObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class OperationType {
    @JsonProperty("oper_type_id")
    private int id;

    @JsonProperty("oper_type_name")
    private String name;

    @Override
    public String toString() {
        return "OperationType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperationType that = (OperationType) o;

        if (id != that.id) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
