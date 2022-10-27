package fr.lernejo.umlgrapher;

public class UmlType {
    private final Class theClass;
    private final String className;
    private final String packageName;

    public UmlType(Class theClass) {
        this.theClass = theClass;
        this.className = theClass.getSimpleName();
        this.packageName = theClass.getPackageName();
    }

    public Class getTheClass() { return this.theClass; }

    public String getNameClass(){return this.className;}

    public String getPackageName(){return this.packageName;}
}
