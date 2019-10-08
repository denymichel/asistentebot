import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;


public class MainBot extends TelegramLongPollingBot{

    public static void main (String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
    try { telegramBotsApi.registerBot(new MainBot());
    } catch (TelegramApiRequestException e) {
        e.printStackTrace();
    }
  }


    public void sendMsg(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            sendMessage(sendMessage);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
    //  Model model = new Model();
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/help":
                    sendMsg(message, "hola soy el asistente automatico");
                    break;
                case "/ayuda":
                    sendMsg(message, "En que te puedo ayudar?");
                    break;
                default:
       /*         case "/realizar reserva":
                    sendMsg(message, "Escoge un horario para la reserva");
                    break;
                default:
                    try {
                        sendMsg(message, Weather.getWeather(message.getText(), model));
                    } catch (IOException e) {
                        sendMsg(message, " puedes realizar reservas, ver horarios y especialidades");
                    }
        */
            }
        }

    }

    public String getBotUsername() {
        return "GeoDanAlvBot";
    }

    public String getBotToken() {
        return "845095054:AAHnNtOMHFcanYBH4v7N2bIk8ij3mA9THFc";
    }
}




