package vol1.a;

public class A2 {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Аргументы командной строки в обратном порядке:");
            for (int i = args.length - 1; i >= 0; i--) {
                System.out.println(args[i]);
            }
        } else {
            System.out.println("Аргументы командной строки не переданы.");
        }
    }
}

