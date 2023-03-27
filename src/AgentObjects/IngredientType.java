package AgentObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class IngredientType {
    @JsonProperty("prod_type_id")
    private int id;
    @JsonProperty("prod_type_name")
    private String name;
    @JsonProperty("prod_is_food")
    private boolean isFood;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IngredientType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", is_food=" + isFood +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientType that = (IngredientType) o;

        if (id != that.id) return false;
        if (isFood != that.isFood) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isFood ? 1 : 0);
        return result;
    }
}
