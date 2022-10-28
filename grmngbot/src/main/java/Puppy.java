public class Puppy extends Animal implements Action {
    @Override
    public String say() {
        System.out.println("Привет! Я собачка и я  помогу тебе справиться в трудные периоды твоей жизни!");
        return "Привет! Я собачка и я  помогу тебе справиться в трудные периоды твоей жизни!";
    }
}
