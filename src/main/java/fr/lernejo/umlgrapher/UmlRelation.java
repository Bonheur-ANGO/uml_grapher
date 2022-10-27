package fr.lernejo.umlgrapher;

import java.util.Set;

public class UmlRelation {
    private final Set<UmlType> Tree;

    public UmlRelation(Set<UmlType> theTree) {
        this.Tree = theTree;
    }

    public Set<LinkForMermaid> theRelation(Set<LinkForMermaid> linkers){
        String relation ="";
        for(UmlType i : Tree){
            Class[] j = i.getTheClass().getInterfaces();
            for(Class k : j){
                if(i.getTheClass().getSuperclass()==null){
                    relation = k.getSimpleName()+" <|-- " + i.getTheClass().getSimpleName() + " : extends";
                }
                else{
                    relation = k.getSimpleName()+" <|.. " + i.getTheClass().getSimpleName() + " : implements";
                }
                relation +="\n";
                linkers.add(new LinkForMermaid(k,i.getTheClass(),relation));
            }
        }
        return linkers;
    }

    public String allRelation(Set<LinkForMermaid> linkers, Set<UmlType> types){
        String relation="";
        linkers = new UmlRelation(types).theRelation(linkers);
        for (LinkForMermaid i : linkers) {
            relation += i.getLink();
        }
        return relation;
    }
}
