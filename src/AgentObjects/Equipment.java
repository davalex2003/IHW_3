package AgentObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Equipment {
    @JsonProperty("equip_id")
    private int id;
    @JsonProperty("equip_type")
    private int equipmentType_id;
    @JsonProperty("equip_name")
    private String name;
    @JsonProperty("equip_active")
    private boolean active;

    public int getEquipmentType_id() {
        return equipmentType_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", equipmentType_id=" + equipmentType_id +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipment equipment = (Equipment) o;

        if (id != equipment.id) return false;
        if (equipmentType_id != equipment.equipmentType_id) return false;
        if (active != equipment.active) return false;
        return Objects.equals(name, equipment.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + equipmentType_id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        return result;
    }
}
