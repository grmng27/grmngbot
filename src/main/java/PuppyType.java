import org.telegram.telegrambots.meta.api.objects.InputFile;

public enum PuppyType {
    TAKSA("/taksa", "Такса", new InputFile("https://i.mycdn.me/i?r=AzEPZsRbOZEKgBhR0XGMT1RkzEphFLNps42C1TJy0Bi8-aaKTM5SRkZCeTgDn6uOyic")),
    KORGI("/korgi", "Корги", new InputFile("https://twizz.ru/wp-content/uploads/2021/10/1634814596_83b98cf4840b3899b13d1498dd3e091b.jpg"));

    private String button;
    private String text;
    private InputFile pic;

    PuppyType(String button, String text, InputFile pic) {
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

    public static PuppyType textOf(String text) {
        if (KORGI.getText().equalsIgnoreCase(text)) {
            return KORGI;
        } else if (TAKSA.getText().equalsIgnoreCase(text)) {
            return TAKSA;
        } else return KORGI;
    }
}
