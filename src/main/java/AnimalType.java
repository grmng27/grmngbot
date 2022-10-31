import org.telegram.telegrambots.meta.api.objects.InputFile;

public enum AnimalType {

    ABISS("/abiss", "Абиссинская", new InputFile("https://skstoit.ru/wp-content/uploads/2022/01/skolko-stoit-abissinskaya-koshka-3.jpg")),
    TAKSA("/taksa", "Такса", new InputFile("https://i.mycdn.me/i?r=AzEPZsRbOZEKgBhR0XGMT1RkzEphFLNps42C1TJy0Bi8-aaKTM5SRkZCeTgDn6uOyic")),
    KORGI("/korgi", "Корги", new InputFile("https://twizz.ru/wp-content/uploads/2021/10/1634814596_83b98cf4840b3899b13d1498dd3e091b.jpg")),
    SIAM("/siam", "Сиамская", new InputFile("https://natalyland.ru/wp-content/uploads/4/c/f/4cf1254ec1aaca148747ce17c09d29f4.jpeg"));

    private String button;
    private String text;
    private InputFile pic;

    AnimalType(String button, String text, InputFile pic) {
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

    public static AnimalType textOf(String text) {
        if (SIAM.getText().equalsIgnoreCase(text)){
            return SIAM;
        } else if (ABISS.getText().equalsIgnoreCase(text)) {
            return ABISS;
        } else if (KORGI.getText().equalsIgnoreCase(text)) {
            return KORGI;
        } else if (TAKSA.getText().equalsIgnoreCase(text)) {
            return TAKSA;
        } else return SIAM;
    }

}
