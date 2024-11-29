package vol6.SolutionA.plant;

//  Комнатное растение
public class IndoorPlant extends AbstractPlant {
    private boolean isPetFriendly;
    // Установка, безопасно ли растение для домашних животных
    public void setPetFriendly(boolean isPetFriendly) {
        this.isPetFriendly = isPetFriendly;
    }

    // Проверка, безопасно ли растение для домашних животных
    public boolean isPetFriendly() {
        return isPetFriendly;
    }

    // Пересадка комнатного растения
    public void repot() {
        System.out.println("Комнатное растение '" + name + "' пересажено");
    }
}
