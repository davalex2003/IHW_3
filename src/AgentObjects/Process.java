package AgentObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Process {
    @JsonProperty("operations")
    private List<Operation> makingProcess;

    public List<Operation> getMakingProcess() {
        return makingProcess;
    }

    public Process() {
    }

    @Override
    public String toString() {
        return "Process{" +
                "makingProcess=" + makingProcess +
                '}';
    }
}
