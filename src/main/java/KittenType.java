import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.util.Optional;

public enum KittenType implements AnimalType {

    ABISS("/abiss", "Абиссинская", new InputFile("https://skstoit.ru/wp-content/uploads/2022/01/skolko-stoit-abissinskaya-koshka-3.jpg")),
    SIAM("/siam", "Сиамская", new InputFile("https://natalyland.ru/wp-content/uploads/4/c/f/4cf1254ec1aaca148747ce17c09d29f4.jpeg"));

    private String button;
    private String text;
    private InputFile pic;

    KittenType(String button, String text, InputFile pic) {
        this.button = button;
        this.text = text;
        this.pic = pic;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public InputFile getPic() {
        return pic;
    }

    public void setPic(InputFile pic) {
        this.pic = pic;
    }

    public static Optional<KittenType> textOf(String text) {
        if (SIAM.getText().equalsIgnoreCase(text)){
            return Optional.of(SIAM);
        } else if (ABISS.getText().equalsIgnoreCase(text)) {
            return Optional.of(ABISS);
        } else return Optional.empty();
    }

}
