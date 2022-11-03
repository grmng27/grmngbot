import org.telegram.telegrambots.meta.api.objects.InputFile;

public abstract class Animal implements Action{
    private String breed; /*порода*/
    private InputFile picture;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public InputFile getPicture() {
        return picture;
    }

    public void setPicture(InputFile picture) {
        this.picture = picture;
    }
}
