package fr.lernejo.umlgrapher;

public class LinkForMermaid {
    private final String ChildClass;
    private final String ParentClass;
    private final String liason;

    public LinkForMermaid(Class ParentClass, Class ChildClass, String my_liason){
        this.ChildClass = ChildClass.getSimpleName();
        this.ParentClass = ParentClass.getSimpleName();
        this.liason = my_liason;
    }

    public String getChildClass(){
        return this.ChildClass;
    }

    public String getClassParent(){
        return this.ParentClass;
    }
    public String getLink(){
        return this.liason;
    }
}
