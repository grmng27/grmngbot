import org.telegram.telegrambots.meta.api.objects.InputFile;
//@Builder
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor

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

    //    public static class AnimalBuilder {
//        private String breed; /*порода*/
//        private InputFile picture;
//
//        public void animalBuilder(String breed, InputFile picture) {
//            this.breed = breed;
//            this.picture = picture;
//        }
//
//        public AnimalBuilder setBreed(String breed) {
//            this.breed = breed;
//            return this;
//        }
//
//        public AnimalBuilder setPicture(InputFile picture) {
//            this.picture = picture;
//            return this;
//        }
//    }
}
