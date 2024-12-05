package vol11;

import vol11.solutionA.PoemSorter;
import vol11.solutionB.Graph;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> poem = new ArrayList<>();
        poem.add("Однажды в студеную зимнюю пору");
        poem.add("Я из лесу вышел; был сильный мороз");
        poem.add("Гляжу, поднимается медленно в гору");
        poem.add("Лошадка, везущая хворосту воз");

        System.out.println("Оригинальный стих:");
        poem.forEach(System.out::println);

        List<String> sortedPoem = PoemSorter.sortPoemLinesByLength(poem);

        System.out.println("\nСтих, отсортированный по длине строк:");
        sortedPoem.forEach(System.out::println);

        System.out.println("\n\n");
        // vol11.solutionB

        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);

        System.out.println("Смежные вершины 0: " + graph.getAdjacentVertices(0));
        System.out.println("Смежные вершины 1: " + graph.getAdjacentVertices(1));
        System.out.println("Есть ли ребро между 0 и 1: " + graph.hasEdge(0, 1));
        System.out.println("Есть ли ребро между 2 и 3: " + graph.hasEdge(2, 3));

        graph.removeEdge(0, 1);
        System.out.println("Смежные вершины 0 после удаления ребра (0, 1): " + graph.getAdjacentVertices(0));
    }
}
