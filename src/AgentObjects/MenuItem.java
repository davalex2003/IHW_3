package AgentObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MenuItem implements Serializable {

    @JsonProperty("menu_dish_id")
    private int id;

    @JsonProperty("menu_dish_card")
    private int recipeId;

    @JsonProperty("menu_dish_price")
    private int price;

    @JsonProperty("menu_dish_active")
    private boolean isAvailable;

    public MenuItem() {
    }


    public int getId() {
        return id;
    }

    public int getRecipeId() {
        return recipeId;
    }


    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", recipe_id=" + recipeId +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuItem menuItem = (MenuItem) o;

        if (id != menuItem.id) return false;
        if (recipeId != menuItem.recipeId) return false;
        if (price != menuItem.price) return false;
        return isAvailable == menuItem.isAvailable;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + recipeId;
        result = 31 * result + price;
        result = 31 * result + (isAvailable ? 1 : 0);
        return result;
    }
}
