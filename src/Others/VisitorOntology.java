package Others;

import AgentObjects.Customer;
import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.schema.ConceptSchema;

public class VisitorOntology extends Ontology {
    public static final String ONTOLOGY_NAME = "VisitorOntology";

    private static final VisitorOntology instance = new VisitorOntology();

    public static VisitorOntology getInstance() {
        return instance;
    }

    private VisitorOntology() {
        super(ONTOLOGY_NAME, BasicOntology.getInstance());
        try {
            add(new ConceptSchema(ONTOLOGY_NAME), Customer.class);
        } catch (OntologyException ignored) {
        }
    }
}
