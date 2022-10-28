public class Kitten extends Animal implements Action{

    @Override
    public String say() {
        System.out.println("Привет! Я кошечка и я  помогу тебе справиться в трудные периоды твоей жизни!");
        return "Привет! Я кошечка и я  помогу тебе справиться в трудные периоды твоей жизни!";
    }
}
