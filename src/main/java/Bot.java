import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    //создаем две константы, присваиваем им значения токена и имя бота соответсвтенно
    //вместо звездочек подставляйте свои данные
    final private String BOT_TOKEN = "5691199233:AAHMHiGNmAEfNz2TsMBh4FTb8WOhLuKaKdk";
    final private String BOT_NAME = "Grmng";
    Storage storage;

    StoragePic storage2;

    Bot() {
        storage = new Storage();
        storage2 = new StoragePic();
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
                //Извлекаем из объекта сообщение пользователя
                Message inMess = update.getMessage();
                //Достаем из inMess id чата пользователя
                String chatId = inMess.getChatId().toString();
                //Получаем текст сообщения пользователя, отправляем в написанный нами обработчик
                String response = parseMessage(inMess.getText());
                InputFile response1 = parseMessage1(inMess.getText());
                InputFile response2 = parseMessageSwitch(inMess.getText(), AnimalType.SIAM);
                sendMessage(update.getMessage().getChatId().toString(), response);
                sendPhoto(update.getMessage().getChatId().toString(), response1);
                sendPhotoAnimal(update.getMessage().getChatId().toString(), response2);
        }

    private void sendMessage(String chatId, String response) {
        try {
                //Создаем объект класса SendMessage - наш будущий ответ пользователю
                SendMessage outMess = new SendMessage();

                //Добавляем в наше сообщение id чата а также наш ответ
                outMess.setChatId(chatId);
                outMess.setText(response);
                outMess.setReplyMarkup(replyMarkup());
                outMess.setReplyMarkup(inlineKeyboardKitten());

                //Отправка в чат
                execute(outMess);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendPhoto(String chatId, InputFile response1) {
        try {
            SendPhoto outPhoto = new SendPhoto();

            outPhoto.setChatId(chatId);
            outPhoto.setPhoto(response1);

            execute(outPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendPhotoAnimal(String chatId, InputFile response2) {
        try {
            SendPhoto outPhoto = new SendPhoto();

            outPhoto.setChatId(chatId);
            outPhoto.setPhoto(response2);

            execute(outPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private ReplyKeyboardMarkup replyMarkup() {
        //Создаем объект будущей клавиатуры и выставляем нужные настройки
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true); //подгоняем размер
        replyKeyboardMarkup.setOneTimeKeyboard(false); //скрываем после использования

        //Создаем список с рядами кнопок
        ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();
        //Создаем один ряд кнопок и добавляем его в список
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRows.add(keyboardRow);
        //Добавляем одну кнопку с текстом "Просвяти" наш ряд
        keyboardRow.add(new KeyboardButton("Поддержи"));
        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRows.add(keyboardRow2);
        keyboardRow.add(new KeyboardButton("Картиночка!"));
        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRows.add(keyboardRow3);
        keyboardRow.add(new KeyboardButton("Создать котика!"));
        KeyboardRow keyboardRow4 = new KeyboardRow();
        keyboardRows.add(keyboardRow4);
        keyboardRow.add(new KeyboardButton("Создать собачку!"));

        //добавляем лист с одним рядом кнопок в главный объект
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }

    private InlineKeyboardMarkup inlineKeyboardKitten() {
        InlineKeyboardMarkup inlineKeyboardMarkup =new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Абиссинская");
        inlineKeyboardButton.setCallbackData("Абиссинская");
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton2.setText("Сиамская");
        inlineKeyboardButton2.setCallbackData("Сиамская");
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton);
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        List<List<InlineKeyboardButton>> rowList= new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

//    private void iThrowException(boolean value) {
//        if (value) {
//            try {
//                throw new Exception();
//            } catch (NullPointerException e) {
//                System.out.println("Ой, ошибка");
//            } catch (Exception e) {
//                System.out.println("Ой, большая ошибка");
//            } finally {
//                System.out.println("Я обязательно выполнюсь");
//            }
//        }
//    }

    public String parseMessage(String textMsg) {
        Animal animal;
        String response;
//        createAnimal("Nika");
        //iThrowException(true);
        //Сравниваем текст пользователя с нашими командами, на основе этого формируем ответ
        if (textMsg.equals("/start"))
            response = "Привет! Если сейчас тебе тяжело, то просто жми /get и /picture, чтобы получить теплые слова и поддержку от бота.";
        else if (textMsg.equals("/get") || textMsg.equals("Поддержи"))
            response = storage.getRandQuote();
        else if (textMsg.equals("/createcat") || textMsg.equals("Создать котика!"))
            response = "Выбери породу будущего котика";
        else if (textMsg.equals("/createdog") || textMsg.equals("Создать собачку!"))
            response = "Выбери породу будущей собачки";
        else if (textMsg.equals("/siam") || textMsg.equalsIgnoreCase("Сиамская")) {
            animal = createKitten("Сиамская", new InputFile("https://natalyland.ru/wp-content/uploads/4/c/f/4cf1254ec1aaca148747ce17c09d29f4.jpeg"));
            response = animal.say();
        } else if (textMsg.equals("/abiss") || textMsg.equalsIgnoreCase("Абиссинская")) {
            animal = createKitten("Абиссинская", new InputFile("https://skstoit.ru/wp-content/uploads/2022/01/skolko-stoit-abissinskaya-koshka-3.jpg"));
            response = animal.say();
        } else if (textMsg.equals("/korgi") || textMsg.equalsIgnoreCase("Корги")) {
            animal = createPuppy("Корги", new InputFile("https://twizz.ru/wp-content/uploads/2021/10/1634814596_83b98cf4840b3899b13d1498dd3e091b.jpg"));
            response = animal.say();
        } else if (textMsg.equals("/taksa") || textMsg.equalsIgnoreCase("Такса")) {
            animal = createPuppy("Такса", new InputFile("https://i.mycdn.me/i?r=AzEPZsRbOZEKgBhR0XGMT1RkzEphFLNps42C1TJy0Bi8-aaKTM5SRkZCeTgDn6uOyic"));
            response = animal.say();
        } else if (textMsg.equals("/picture") || textMsg.equals("Картиночка!"))
            response = "Держи котенка!";
        else response = "Сообщение не распознано";
        return response;
    }

    public InputFile parseMessage1(String textMsg) {
//        Animal animal;
        InputFile response1;
        //Сравниваем текст пользователя с нашими командами, на основе этого формируем ответ
        if (textMsg.equals("/picture") || textMsg.equals("Картиночка!"))
            response1 = storage2.getRandPicture();
//        else if (textMsg.equals("/siam") || textMsg.equalsIgnoreCase("Сиамская")) {
//            animal = createKitten("Сиамская", new InputFile("https://natalyland.ru/wp-content/uploads/4/c/f/4cf1254ec1aaca148747ce17c09d29f4.jpeg"));
//        response1 = animal.getPicture();
//        animal.say();
//        } else if (textMsg.equals("/abiss") || textMsg.equalsIgnoreCase("Абиссинская")) {
//            animal = createKitten("Абиссинская", new InputFile("https://skstoit.ru/wp-content/uploads/2022/01/skolko-stoit-abissinskaya-koshka-3.jpg"));
//            response1 = animal.getPicture();
//            animal.say();
//        }else if (textMsg.equals("/korgi") || textMsg.equalsIgnoreCase("Корги")) {
//                animal = createPuppy("Корги", new InputFile("https://twizz.ru/wp-content/uploads/2021/10/1634814596_83b98cf4840b3899b13d1498dd3e091b.jpg"));
//                response1 = animal.getPicture();
//                animal.say();
//        }else if (textMsg.equals("/taksa") || textMsg.equalsIgnoreCase("Такса")) {
//            animal = createPuppy("Такса", new InputFile("https://i.mycdn.me/i?r=AzEPZsRbOZEKgBhR0XGMT1RkzEphFLNps42C1TJy0Bi8-aaKTM5SRkZCeTgDn6uOyic"));
//            response1 = animal.getPicture();
//            animal.say();
//        }
        else response1 = new InputFile(" ");
            return response1;
    }

    public InputFile parseMessageSwitch(String textMsg, AnimalType animalType) {
        Animal animal;
        InputFile response2;
        switch (animalType) {
            case SIAM:
                if (textMsg.equals("/siam") || textMsg.equalsIgnoreCase("Сиамская")){
                    animal = createKitten("Сиамская", new InputFile("https://natalyland.ru/wp-content/uploads/4/c/f/4cf1254ec1aaca148747ce17c09d29f4.jpeg"));
                    response2 = animal.getPicture();
                    animal.say();
                    break;
                } case ABISS:
                if (textMsg.equals("/abiss") || textMsg.equalsIgnoreCase("Абиссинская")) {
                    animal = createKitten("Абиссинская", new InputFile("https://skstoit.ru/wp-content/uploads/2022/01/skolko-stoit-abissinskaya-koshka-3.jpg"));
                    response2 = animal.getPicture();
                    animal.say();
                    break;
                } case TAKSA:
                if (textMsg.equals("/taksa") || textMsg.equalsIgnoreCase("Такса")) {
                    animal = createPuppy("Такса", new InputFile("https://i.mycdn.me/i?r=AzEPZsRbOZEKgBhR0XGMT1RkzEphFLNps42C1TJy0Bi8-aaKTM5SRkZCeTgDn6uOyic"));
                    response2 = animal.getPicture();
                    animal.say();
                    break;
                } case KORGI:
                if (textMsg.equals("/korgi") || textMsg.equalsIgnoreCase("Корги")) {
                    animal = createPuppy("Корги", new InputFile("https://twizz.ru/wp-content/uploads/2021/10/1634814596_83b98cf4840b3899b13d1498dd3e091b.jpg"));
                    response2 = animal.getPicture();
                    animal.say();
                    break;
                } default:
                response2 = new InputFile(" ");
        }
        return response2;
    }

    private Kitten createKitten(String breed, InputFile picture) {
        Kitten kitten = new Kitten();
        kitten.setBreed(breed);
        kitten.setPicture(picture);
        return kitten;
    }

    private Puppy createPuppy(String breed, InputFile picture) {
        Puppy puppy = new Puppy();
        puppy.setBreed(breed);
        puppy.setPicture(picture);
        return puppy;
    }
}

