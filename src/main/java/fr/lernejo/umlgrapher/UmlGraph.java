package fr.lernejo;

public class UmlGraph {

    public UmlGraph(){

    }

    public String as(GraphType graphType){
        if (graphType == GraphType.Mermaid){
            return """
            classDiagram
            class Machin {
                <<interface>>
            }
            """;
        }
        return  "";
    }
}
