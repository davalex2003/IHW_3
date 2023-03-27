package Containers;

import AgentObjects.EquipmentType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;

public class EquipmentTypes {
    @JsonProperty("equipment_type")
    private HashSet<EquipmentType> equipmentTypesTypes;

    public HashSet<EquipmentType> getEquipmentTypes() {
        return equipmentTypesTypes;
    }

    public EquipmentTypes() {}

    public EquipmentTypes(HashSet<EquipmentType> equipmentTypes) {
        this.equipmentTypesTypes = equipmentTypes;
    }

    @Override
    public String toString() {
        return "EquipmentTypeList{" +
                "ingredientTypes=" + equipmentTypesTypes +
                '}';
    }
}
