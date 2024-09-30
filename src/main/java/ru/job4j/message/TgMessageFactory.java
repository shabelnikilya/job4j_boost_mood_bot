package ru.job4j.message;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.job4j.model.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Component
public class TgMessageFactory {

    /**
     * Мапа ответов на настроение.
     */
    private static final Map<String, String> MOOD_RESP = new HashMap<>();

    static {
        Stream.of(Button.values()).forEach(
                v -> MOOD_RESP.put(v.getData(), v.getResponseText())
        );
    }

    /**
     * Отправка кнопок в тг чат.
     *
     * @param chatId идентификатор чата.
     * @param titleText заголовок у набора кнопок.
     * @param btnNameToData пары имени кнопки и данных для тг кнопки.
     * @return сообщение для тг.
     */
    public SendMessage sendButtonsByChatId(
            long chatId,
            String titleText,
            Map<String, String> btnNameToData
            ) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(titleText);

        var inlineKeyBoardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboards = new ArrayList<>();
        for (Map.Entry<String, String> pair : btnNameToData.entrySet()) {
            keyboards.add(List.of(createBtn(pair.getKey(), pair.getValue())));
        }

        inlineKeyBoardMarkup.setKeyboard(keyboards);
        message.setReplyMarkup(inlineKeyBoardMarkup);
        return message;
    }

    /**
     * Отправка текстового сообщения в чат.
     *
     * @param chatId диентификатор чата.
     * @param data ответ.
     * @return объект сообщения в тг.
     */
    public SendMessage sendTextByChatIdAndData(long chatId, String data) {
        return new SendMessage(String.valueOf(chatId), MOOD_RESP.get(data));
    }

    /**
     * Создание объекта кнопки.
     *
     * @param name имя кнопки.
     * @param data данные привязанные к кнопки.
     * @return объект кнопки.
     */
    private InlineKeyboardButton createBtn(String name, String data) {
        var inline = new InlineKeyboardButton();
        inline.setText(name);
        inline.setCallbackData(data);
        return inline;
    }
}
