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

    //TODO: модификатор доступа поменять местами с final, чтобы было правильно
    //TODO: удалить все комментарии и все что закомментированно, по всему проекту, это мусор
    //TODO: удалить все неиспользуемые методы
    private final String BOT_TOKEN = "5691199233:AAHMHiGNmAEfNz2TsMBh4FTb8WOhLuKaKdk";
    private final String BOT_NAME = "Grmng";
    //TODO: удалить, не используется
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
                Message inMess = update.getMessage();
                String chatId = inMess.getChatId().toString();
                String messText = inMess.getText();
//                String responseQuote = parseMessage(inMess.getText());
//                InputFile response1 = parseMessage1(inMess.getText());
                //TODO: три раза происходит AnimalType.textOf(inMess.getText()) - вынести в переменную и ее использовать
                //TODO: почему переменная называется responseAnimal, если это просто InputFile? переименуй
                InputFile response = parseMsgSwitch(KittenType.textOf(messText));
                String responseKitten = parseMsgKitten(KittenType.textOf(messText));
                String responsePuppy = parseMsgPuppy(PuppyType.textOf(messText));
                //TODO: у тебя выше уже есть переменная chatId, зачем ты ее еще 3 раза достаешь?
                sendMessageKitten(chatId, responseKitten);
                sendMessagePuppy(chatId, responsePuppy);
//                sendMessageQuote(chatId, responseQuote);
//                sendPhoto(update.getMessage().getChatId().toString(), response1);
                sendPhotoAnimal(chatId, response);
        }

    private void sendMessageQuote(String chatId, String responseQuote) {
        try {
            SendMessage outMessQuote = new SendMessage();

            outMessQuote.setChatId(chatId);
            outMessQuote.setText(responseQuote);
            outMessQuote.setReplyMarkup(replyMarkup());
            outMessQuote.setReplyMarkup(inlineKeyboardKitten());

            execute(outMessQuote);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendMessageKitten(String chatId, String responseKitten) {
        try {
                SendMessage outMessKitten = new SendMessage();

                outMessKitten.setChatId(chatId);
                outMessKitten.setText(responseKitten);
                outMessKitten.setReplyMarkup(replyMarkup());
                outMessKitten.setReplyMarkup(inlineKeyboardKitten());

                execute(outMessKitten);
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

    private void sendPhotoAnimal(String chatId, InputFile response) {
        try {
            SendPhoto outPhoto = new SendPhoto();

            outPhoto.setChatId(chatId);
            outPhoto.setPhoto(response);

            execute(outPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendMessagePuppy(String chatId, String responsePuppy) {
        try {
            SendMessage outMessPuppy = new SendMessage();

            outMessPuppy.setChatId(chatId);
            outMessPuppy.setText(responsePuppy);

            execute(outMessPuppy);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private ReplyKeyboardMarkup replyMarkup() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRows.add(keyboardRow);
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

    public String parseMessage(String textMsg) {
        String responseQuote;
        if (textMsg.equals("/start"))
            responseQuote = "Привет! Если сейчас тебе тяжело, то просто жми /get и /picture, чтобы получить теплые слова и поддержку от бота.";
        else if (textMsg.equals("/get") || textMsg.equals("Поддержи"))
            responseQuote = storage.getRandQuote();
        else if (textMsg.equals("/createcat") || textMsg.equals("Создать котика!"))
            responseQuote = "Выбери породу будущего котика";
        else if (textMsg.equals("/createdog") || textMsg.equals("Создать собачку!"))
            responseQuote = "Выбери породу будущей собачки";
        else if (textMsg.equals("/picture") || textMsg.equals("Картиночка!"))
            responseQuote = "Держи котенка!";
        else responseQuote = "Сообщение не распознано";
        return responseQuote;
    }

    public InputFile parseMessage1(String textMsg) {
        InputFile response1;
        if (textMsg.equals("/picture") || textMsg.equals("Картиночка!"))
            response1 = storage2.getRandPicture();
        else response1 = new InputFile(" ");
            return response1;
    }

    public InputFile parseMsgSwitch(KittenType kittenType) {
           Animal animal = createKitten(kittenType.getText(), kittenType.getPic());
           animal.say();
           return kittenType.getPic();
    }

    //TODO: здесь сделал красиво, разберись как это так получилось и сделай в методе собачки ниже так же
    public String parseMsgKitten(KittenType kittenType) {
         return createKitten(kittenType.getText(), kittenType.getPic()).say();
    }

    public String parseMsgPuppy(PuppyType puppyType) {
        return createPuppy(puppyType.getText(), puppyType.getPic()).say();
    }

    //TODO: сделать билдер кошечке и собачке, создавать через билдер (можно использовать аннотации ломбок везде)
    private Kitten createKitten(String breed, InputFile picture) {
       return Kitten.builder().build();
    }

    private Puppy createPuppy(String breed, InputFile picture) {
        Puppy puppy = new Puppy();
        puppy.setBreed(breed);
        puppy.setPicture(picture);
        return puppy;
    }
}

