import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.util.Optional;

public interface AnimalType {
    String getText();
    InputFile getPic();

    Optional<AnimalType> textOf(String text);


}
