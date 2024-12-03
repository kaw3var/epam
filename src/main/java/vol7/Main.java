package vol7;

public class Main {
    public static void main(String[] args) {
        NumberChecker isDivideBy13 = number -> number % 13 == 0;

        System.out.println(isDivideBy13.checkDivide(26));
        System.out.println(isDivideBy13.checkDivide(27));
    }
}
