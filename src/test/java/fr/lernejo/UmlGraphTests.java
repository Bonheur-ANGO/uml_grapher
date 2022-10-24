package fr.lernejo;

import fr.lernejo.umlgrapher.GraphType;
import fr.lernejo.umlgrapher.UmlGraph;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UmlGraphTests {
    @Test
    void empty_interface_with_no_relation() {
        UmlGraph graph = new UmlGraph(Machin.class);

        String output = graph.as(GraphType.Mermaid);

        Assertions.assertThat(output).isEqualTo("""
            classDiagram
            class Machin {
                <<interface>>
            }
            """);
    }

    @Test
    void empty_class_with_no_relation() {
        UmlGraph graph = new UmlGraph(MaClasse.class);

        String output = graph.as(GraphType.Mermaid);

        Assertions.assertThat(output).isEqualTo("""
            classDiagram
            class MaClasse
            """);
    }

    @Test
    void string_with_no_relation() {
        UmlGraph graph = new UmlGraph(MaClasse.class);

        String output = graph.as(GraphType.Basic);

        Assertions.assertThat(output).isEqualTo("");
    }

    interface Machin {
    }

    public class MaClasse {
    }
}
