package vol13.solutionA;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sender_id", nullable = false)
    private Integer senderId;

    @Column(name = "receiver_id", nullable = false)
    private Integer receiverId;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "sent_date", nullable = false)
    private Date sentDate;

    public Letter(int id, int senderId, int receiverId, String subject, String body, Date sentDate) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.subject = subject;
        this.body = body;
        this.sentDate = sentDate;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public int getSenderId() {
        return senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public Date getSentDate() {
        return sentDate;
    }

    @Override
    public String toString() {
        return "Letter {" +
                "id=" + id +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", sentDate=" + sentDate +
                '}';
    }
}
