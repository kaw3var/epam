package vol5;

public class Main {
    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook("Олег", "Тиньков", "Б762-1", 12);

        GradeBook.Session session1 = gradeBook.new Session("Сессия 1 2024");

        session1.addSubject("ООП", true, "Хорошо");
        session1.addSubject("База данных", true, "Отлично");
        session1.addSubject("Веб-разработка", false, "Зачет");
        session1.addSubject("Операционные системы", true, "Хорошо");

        gradeBook.addSession(session1);
        gradeBook.printGradeBook();
    }
}
