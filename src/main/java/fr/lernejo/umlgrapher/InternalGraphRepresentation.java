package fr.lernejo.umlgrapher;

import java.util.ArrayList;
import java.util.List;

public class InternalGraphRepresentation {
    private final Class theClass;

    public InternalGraphRepresentation(Class aClass) {this.theClass = aClass;}

    public List<Class> relationBetweenClass(List<Class> listRecursive, Class... tabClasses){
        for(Class aClass : tabClasses){
            if(!listRecursive.contains(aClass)){
                listRecursive.add(aClass);
                listRecursive = relationBetweenClass(listRecursive, aClass.getInterfaces());
            }
        }
        return listRecursive;
    }

    public List<Class> findRelation(){
        List<Class> theList = new ArrayList<>();
        theList = relationBetweenClass(theList, this.theClass);
        return theList;
    }
}
