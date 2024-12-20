//package vol13;
//
//import vol13.solutionA.DatabaseConnection;
//import vol13.solutionA.PutLetter;
//import vol13.solutionA.GetLetter;
//import vol13.solutionA.Person;
//
//import java.sql.Date;
//import java.sql.SQLException;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        try {
//            System.out.println("Подключение к базе данных...");
//            createInitialData();
//
//            // Экземпляры классов для запросов и модификации
//            GetLetter getLetter = new GetLetter();
//            PutLetter putLetter = new PutLetter();
//
//            // Найти пользователя, длина писем которого наименьшая
//            System.out.println("\nПользователи с минимальной длиной писем:");
//            List<Person> usersWithMinLetters = getLetter.getUsersWithMinLetterLength();
//            usersWithMinLetters.forEach(System.out::println);
//
//            // Пользователи, получившие письма с заданной темой
//            String subject = "Java";
//            System.out.println("\nПользователи, получившие письма с темой \"" + subject + "\":");
//            List<Person> usersWithSubject = getLetter.getUsersWithReceivedSubject(subject);
//            usersWithSubject.forEach(System.out::println);
//
//            // Пользователи, не получившие письма с заданной темой
//            System.out.println("\nПользователи, не получившие письма с темой \"" + subject + "\":");
//            List<Person> usersWithoutSubject = getLetter.getUsersWithoutReceivedSubject(subject);
//            usersWithoutSubject.forEach(System.out::println);
//
//            // Отправка письма всем адресатам
//            System.out.println("\nОтправка письма от пользователя ID = 1 всем адресатам...");
//            int senderId = 1;
//            String newSubject = "Important Update";
//            String body = "Уведомляем вас о важных изменениях.";
//            int[] receiverIds = {2, 3, 4}; // ID получателей
//
//            putLetter.putLetter(senderId, newSubject, body, receiverIds);
//            System.out.println("Письмо отправлено!");
//
//        } catch (SQLException e) {
//            System.err.println("Ошибка при работе с базой данных: " + e.getMessage());
//        }
//    }
//
//    /**
//     * Метод для создания начальных данных в базе.
//     */
//    private static void createInitialData() {
//        try (var connection = DatabaseConnection.getConnection()) {
//            // Добавление пользователей
//            String insertPersonQuery = "INSERT INTO persons (full_name, birth_date) VALUES (?, ?)";
//            try (var personStmt = connection.prepareStatement(insertPersonQuery)) {
//                personStmt.setString(1, "Иван Иванов");
//                personStmt.setDate(2, Date.valueOf("1990-01-01"));
//                personStmt.executeUpdate();
//
//                personStmt.setString(1, "Петр Петров");
//                personStmt.setDate(2, Date.valueOf("1985-05-12"));
//                personStmt.executeUpdate();
//
//                personStmt.setString(1, "Анна Смирнова");
//                personStmt.setDate(2, Date.valueOf("1992-07-19"));
//                personStmt.executeUpdate();
//
//                personStmt.setString(1, "Екатерина Сидорова");
//                personStmt.setDate(2, Date.valueOf("1988-03-22"));
//                personStmt.executeUpdate();
//            }
//
//            // Добавление писем
//            String insertLetterQuery = "INSERT INTO letters (sender_id, receiver_id, subject, body, sent_date) VALUES (?, ?, ?, ?, ?)";
//            try (var letterStmt = connection.prepareStatement(insertLetterQuery)) {
//                letterStmt.setInt(1, 1);
//                letterStmt.setInt(2, 2);
//                letterStmt.setString(3, "Java");
//                letterStmt.setString(4, "Что такое ваш интерфейс????");
//                letterStmt.setDate(5, Date.valueOf("2024-12-01"));
//                letterStmt.executeUpdate();
//
//                letterStmt.setInt(1, 2);
//                letterStmt.setInt(2, 3);
//                letterStmt.setString(3, "Java");
//                letterStmt.setString(4, "sout.('Hello')");
//                letterStmt.setDate(5, Date.valueOf("2024-12-02"));
//                letterStmt.executeUpdate();
//
//                letterStmt.setInt(1, 3);
//                letterStmt.setInt(2, 4);
//                letterStmt.setString(3, "Meeting");
//                letterStmt.setString(4, "Давайте встретимся завтра в 3 часа.");
//                letterStmt.setDate(5, Date.valueOf("2024-12-03"));
//                letterStmt.executeUpdate();
//            }
//            System.out.println("Начальные данные успешно добавлены в базу данных.");
//        } catch (SQLException e) {
//            System.err.println("Ошибка при добавлении начальных данных: " + e.getMessage());
//        } finally {
//            // Закрытие подключения БД при завершении работы программы
//            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//                try {
//                    if (DatabaseConnection.getConnection() != null && !DatabaseConnection.getConnection().isClosed()) {
//                        DatabaseConnection.getConnection().close();
//                        System.out.println("Соединение с базой данных закрыто.");
//                    }
//                } catch (SQLException e) {
//                    System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
//                }
//            }));
//        }
//    }
//}
