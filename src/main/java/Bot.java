import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class But extends TelegramLongPollingBot {
    public static void main (String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            TelegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
        Model model = new Model();
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/hola":
                    sendMsg(message, "hola soy el asistente automatico");
                    break;
                case "/ayuda":
                    sendMsg(message, "En que te puedo ayudar?");
                    break;
                case "/realizar reserva":
                    sendMsg(message, "Escoge un horario para la reserva");
                    break;
                default:
                    try {
                        sendMsg(message, Weather.getWeather(message.getText(), model));
                    } catch (IOException e) {
                        sendMsg(message, " puedes realizar reservas, ver horarios y especialidades");
                    }

            }
        }

    }





    public String getBotUsername() {
        return "";
    }

    public String getBotToken() {
        return "965898434:AAFYisxZkAsAWykdChxs9DNy1ceCADAmogo";
    }
}


