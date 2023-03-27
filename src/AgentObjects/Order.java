package AgentObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Order implements Serializable {
    @JsonProperty("ord_dish_id")
    private int id;

    @JsonProperty("menu_dish")
    private int dishId;

    public int getId() {
        return id;
    }

    public int getDishId() {
        return dishId;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dish_id=" + dishId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        return dishId == order.dishId;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + dishId;
        return result;
    }
}
