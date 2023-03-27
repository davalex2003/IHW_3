package Containers;

import AgentObjects.Cook;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;

public class Cookers {
    @JsonProperty("cookers")
    private HashSet<Cook> cooks;

    public HashSet<Cook> getCooks() {
        return cooks;
    }

    public Cookers() {}

    public Cookers(HashSet<Cook> cooks) {
        this.cooks = cooks;
    }

    @Override
    public String toString() {
        return "CookList{" +
                "cooks=" + cooks +
                '}';
    }
}
