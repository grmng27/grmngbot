import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;
import java.util.ArrayList;

public class StoragePic {
    private ArrayList<InputFile> pictureList;
    StoragePic() {
        pictureList = new ArrayList<>();
        pictureList.add(new InputFile("https://placepic.ru/wp-content/uploads/2018/11/c24f98eba82666ae547b138be9933bd1.jpg"));
        pictureList.add(new InputFile("https://www.ejin.ru/wp-content/uploads/2017/09/9-1022.jpg"));
        pictureList.add(new InputFile("https://proprikol.ru/wp-content/uploads/2020/08/krasivye-kartinki-kotikov-48.jpg"));
        pictureList.add(new InputFile("https://trikky.ru/wp-content/blogs.dir/1/files/2020/07/22/407444-svetik1.jpg"));
        pictureList.add(new InputFile("https://i.pinimg.com/originals/65/ea/d7/65ead7629cbc9cf978e9b9c5b04c8b2a.jpg"));
    }

    InputFile getRandPicture()
    {
        //получаем случайное значение в интервале от 0 до самого большого индекса
        int randValue = (int)(Math.random() * pictureList.size());
        //Из коллекции получаем цитату со случайным индексом и возвращаем ее
        return pictureList.get(randValue);
    }
}
