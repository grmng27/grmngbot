import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import java.util.ArrayList;
import java.util.Arrays;
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

    private final String BOT_TOKEN = "5691199233:AAHMHiGNmAEfNz2TsMBh4FTb8WOhLuKaKdk";
    private final String BOT_NAME = "Grmng";
    Storage storage;
    StoragePic storagePic;

    Bot() {
        storage = new Storage();
        storagePic = new StoragePic();
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
                InputFile response = parseMsgSwitch(KittenType.textOf(messText));
                String responseKitten = parseMsgKitten(KittenType.textOf(messText));
                String responsePuppy = parseMsgPuppy(PuppyType.textOf(messText));

                sendMessageKitten(chatId, responseKitten);
                sendMessagePuppy(chatId, responsePuppy);
                sendPhotoAnimal(chatId, response);
//                sendMessageQuote(chatId, responseQuote);
//                sendPhoto(update.getMessage().getChatId().toString(), response1);
        }

    //TODO: нигде не используется, зачем он остался?
//    потому что он отправляет рандом цитату >:(
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

    //TODO: нигде не используется, зачем он остался?
//        потому что он отправляет рандом фотку >:(
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

        //TODO: прочитай тудушку над методом createInlineButton и сделай))
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
//        inlineKeyboardButton.setText("Абиссинская");
//        inlineKeyboardButton.setCallbackData("Абиссинская");
        createInlineButton("Абиссинская", "Абиссинская");

        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
//        inlineKeyboardButton2.setText("Сиамская");
//        inlineKeyboardButton2.setCallbackData("Сиамская");
        createInlineButton("Сиамская", "Сиамская");


        //TODO: можно не создавать лист отдельно, а потом в него что-то пихать, можно при создании сразу запихать
        // TODO: Arrays.asList - прогугли про это и сделай для keyboardButtonsRow1 и keyboardButtonsRow2
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton);

        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow2.add(inlineKeyboardButton2);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);

        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    //TODO: реализуй метод для создания inlineKeyboardButton и inlineKeyboardButton2
    private InlineKeyboardButton createInlineButton(String text, String data) {
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText(text);
        inlineKeyboardButton.setCallbackData(data);
        return inlineKeyboardButton;
    }

    //TODO: нигде не используется, зачем он остался?
//    потому что это то что отправляет цитату
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

    //TODO: нигде не используется, зачем он остался?
//    потому что это то что отправляет рандом фото
    public InputFile parseMessage1(String textMsg) {
        InputFile response1;
        if (textMsg.equals("/picture") || textMsg.equals("Картиночка!"))
            response1 = storagePic.getRandPicture();
        else response1 = new InputFile(" ");
            return response1;
    }

    public InputFile parseMsgSwitch(KittenType kittenType) {
           Animal animal = createKitten(kittenType.getText(), kittenType.getPic());
           animal.say();
           return kittenType.getPic();
    }

    public String parseMsgKitten(KittenType kittenType) {
         return createKitten(kittenType.getText(), kittenType.getPic()).say();
    }

    public String parseMsgPuppy(PuppyType puppyType) {
        return createPuppy(puppyType.getText(), puppyType.getPic()).say();
    }

    //TODO: создать то ты создала, но объект пустой получился, используя билдер задай ему breed и picture и у собачки так же
//не понимаю. порода и пикча прописана в абстрактном классе, билдер не работает с абстрактными классами, вот и получается, что мы не можем задать породу и пикчу через билдер
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

