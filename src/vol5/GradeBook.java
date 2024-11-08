package vol5;

import java.util.ArrayList;
import java.util.List;

public class GradeBook {
    private String studentName;
    private String studentSurname;
    private String studentGroup;
    private int studentID;
    private List<Session> sessions;

    public GradeBook(String studentName, String studentSurname, String studentGroup, int studentID) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentGroup = studentGroup;
        this.studentID = studentID;
        this.sessions = new ArrayList<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void printGradeBook() {
        System.out.println("ЗАЧЕТНАЯ КНИЖКА СТУДЕНТА: " + studentName + " " + studentSurname +
                "\nГРУППА: " + studentGroup + "\nНОМЕР ЗАЧЕТНОЙ КНИЖКИ: " + studentID);
        for (Session session : sessions) {
            System.out.println("СЕССИЯ: " + session.getSessionName());
            for (Session.Subject subject : session.getSubjects()) {
                System.out.println("\tПРЕДМЕТ: " + subject.getSubjectName() + "\n\t\t\tФорма аттестации: " +
                        (subject.isExam() ? "Экзамен" : "Зачет").toUpperCase() + "\n\t\t\tОценка: " + subject.getGrade().toUpperCase());
            }
        }
    }

    //    Внутренний класс о сессии
    public class Session {
        private String sessionName;
        private List<Subject> subjects;

        public Session(String sessionName) {
            this.sessionName = sessionName;
            this.subjects = new ArrayList<>();
        }

        public void addSubject(String subjectName, boolean isExam, String grade) {
            subjects.add(new Subject(subjectName, isExam, grade));
        }

        public List<Subject> getSubjects() {
            return subjects;
        }

        public String getSessionName() {
            return sessionName;
        }


        //    Внутренний класс о предметах сессии
        private class Subject {
            private String subjectName;
            private boolean isExam;
            private String grade;

            public Subject(String subjectName, boolean isExam, String grade) {
                this.subjectName = subjectName;
                this.isExam = isExam;
                this.grade = grade;
            }

            public String getSubjectName() {
                return subjectName;
            }

            public boolean isExam() {
                return isExam;
            }

            public String getGrade() {
                return grade;
            }
        }
    }
}
