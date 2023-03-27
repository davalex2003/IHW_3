package Containers;

import AgentObjects.OperationType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;

public class OperationTypes {
    @JsonProperty("operation_types")
    private HashSet<OperationType> operationTypes;

    public HashSet<OperationType> getOperationTypes() {
        return operationTypes;
    }

    public OperationTypes() {}

    public OperationTypes(HashSet<OperationType> operationTypes) {
        this.operationTypes = operationTypes;
    }

    @Override
    public String toString() {
        return "OperationTypeList{" +
                "operationTypes=" + operationTypes +
                '}';
    }
}
