package Containers;

import AgentObjects.IngredientType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;

public class ProductTypes {

    @JsonProperty("product_types")
    private HashSet<IngredientType> ingredientTypes;

    public HashSet<IngredientType> getIngredientTypes() {
        return ingredientTypes;
    }

    public ProductTypes() {}

    public ProductTypes(HashSet<IngredientType> ingredientTypes) {
        this.ingredientTypes = ingredientTypes;
    }

    @Override
    public String toString() {
        return "IngredientTypeList{" +
                "ingredientTypes=" + ingredientTypes +
                '}';
    }
}
