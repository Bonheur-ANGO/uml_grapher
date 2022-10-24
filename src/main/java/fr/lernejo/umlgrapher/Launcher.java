package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command
class Launcher implements Runnable {

    @Option(names = {"-c", "--classes"}, required = true ,description = "permet de renseigner les classes d'où faire partir l'analyse")
    private final Class<?>[] theClass = null;

    @Option(names = {"-g", "--graph-type"} ,description = "permet de sélectionner le type de graph que l'on souhaite en sortie")
    private final GraphType graphType = GraphType.Mermaid;

    @Override
    public void run() {
        UmlGraph graph = new UmlGraph(theClass);
        String output = graph.as(graphType);
        System.out.println(output);
    }


    public static void main(String... args) {
        int exitCode = new CommandLine(new Launcher()).execute(args);
        System.exit(exitCode);
    }
}
