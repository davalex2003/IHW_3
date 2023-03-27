package AgentObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;

public class Operation {
    @JsonProperty("oper_type_id")
    private int operationTypeId;

    @JsonProperty("equip_type")
    private int equipType;

    @JsonProperty("oper_time")
    private double time;

    @JsonProperty("oper_async_point")
    private int async;

    @JsonProperty("oper_products")
    private HashSet<Ingredient> ingredients;


    public int getEquipType() {
        return equipType;
    }

    public double getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operationType_id=" + operationTypeId +
                ", equip_type=" + equipType +
                ", time=" + time +
                ", async=" + async +
                ", ingredients=" + ingredients +
                '}';
    }

}
