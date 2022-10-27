package fr.lernejo.umlgrapher;

import java.lang.reflect.Modifier;
import java.util.Set;

public class MermaidFormatter {
    private final Set<UmlType> types;

    public MermaidFormatter(Set<UmlType> types) { this.types = types; }

    public String words(){
        String start = "classDiagram\n";
        for(UmlType atype: types){
            start +="class " + atype.getNameClass();
            if(Modifier.isInterface(atype.getTheClass().getModifiers())){
                start += " {\n    <<interface>>\n}";
            }
            start += "\n";
        }
        return start;
    }
}
