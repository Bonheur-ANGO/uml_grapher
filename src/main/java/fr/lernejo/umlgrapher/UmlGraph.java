package fr.lernejo.umlgrapher;

public class UmlGraph {

    private Class<?>[] theClass;

    public UmlGraph(Class... theClass){
        this.theClass = theClass;
    }

    public String as(GraphType graphType){
        final String sentence;
        if (graphType == GraphType.Mermaid){
            for(Class myClass : theClass)
            {
                if(myClass.isInterface())
                {
                    sentence = "classDiagram\n"+ "class "+ myClass.getSimpleName() + " {\n" + "    <<interface>>\n" + "}\n";
                    return sentence;
                }else{
                    sentence = "classDiagram\n"+ "class "+ myClass.getSimpleName() +"\n";
                    return sentence;
                }
            }
        }
        return "";

    }

}
