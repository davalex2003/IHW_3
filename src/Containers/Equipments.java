package Containers;

import AgentObjects.Equipment;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;

public class Equipments {
    @JsonProperty("equipment")
    private HashSet<Equipment> equipment;

    public HashSet<Equipment> getEquipment() {
        return equipment;
    }

    public Equipments() {}

    public Equipments(HashSet<Equipment> equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "EquipmentList{" +
                "equipment=" + equipment +
                '}';
    }
}
