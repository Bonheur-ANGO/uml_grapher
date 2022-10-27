package fr.lernejo.umlgrapher;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UmlGraph {
    private Class<?>[] theclass;
    private final Set<UmlType> types = new TreeSet<>(Comparator
        .<UmlType, String>comparing(t->t.getNameClass())
        .thenComparing(t->t.getPackageName()));

    private final Set<LinkForMermaid> linkers = new TreeSet<>(Comparator
        .<LinkForMermaid, String>comparing(t->t.getChildClass())
        .thenComparing(t->t.getClassParent()));

    public UmlGraph(Class<?>... theClass){
        this.theclass = theClass;
    }

    public String as (GraphType graphType){
        List<Class> tabClass = null;
        for (Class nClass : theclass) {
            switch (graphType) {
                case Mermaid:
                    tabClass = new InternalGraphRepresentation(nClass).findRelation();
                    for (Class i : tabClass) {
                        types.add(new UmlType(i));
                    }
                    break;
            }
        }
        return new MermaidFormatter(types).words() + new UmlRelation(types).allRelation(linkers, types);
    }
}
