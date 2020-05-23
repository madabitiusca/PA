package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;
import sun.plugin2.message.Message;

import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LocaleExplore {
    private static final String baseName = "Messages";
    private static Locale locale;
    private static ResourceBundle resourceBundle;
    Properties commands = new Properties();

    public void run() {
        setLocale("en-US");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(message("prompt"));
            String command = scanner.nextLine();
            if (command.equals("exit")) break;
            String[] params = command.trim().split("\\s+");
            switch (params[0]) {
                case "locales" : displayLocales(); break;
                case "set" : setLocale(params[1]); break;
                case "info" : localeInfo(); break;
                default: System.out.println(message("invalid"));
            }
        }
    }


    private static String message(String key, String... arguments){
        String pattern = resourceBundle.getString(key);
        String message = new MessageFormat(pattern).format(arguments);
        return message;
    }

    public static void setLocale(String languageTag) {
        LocaleExplore.locale = Locale.forLanguageTag(languageTag);
        LocaleExplore.resourceBundle = ResourceBundle.getBundle(baseName, locale);
        message("locale.set", languageTag);
    }

    public static void displayLocales() {
        System.out.println(LocaleExplore.message("locales"));
        for (Locale locale : Locale.getAvailableLocales())
        {
            System.out.println(locale.toString());
        }
    }

    public static void localeInfo() {
        System.out.println(LocaleExplore.message("locale.set",LocaleExplore.getLocale().getDisplayName()));
        Currency currency  = Currency.getInstance(LocaleExplore.getLocale());
        DateFormatSymbols fo = DateFormatSymbols.getInstance(LocaleExplore.getLocale());
        System.out.println(LocaleExplore.getLocale().getCountry());
        System.out.println(LocaleExplore.getLocale().getLanguage());
        System.out.println(currency.getCurrencyCode());
        for (String s : fo.getWeekdays()) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : fo.getMonths()) {
            System.out.print(s + " ");
        }
        System.out.println();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy", LocaleExplore.getLocale());
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
    public static Locale getLocale()
    {
        return LocaleExplore.locale;
    }

    public static void main(String[] args) {
	    new LocaleExplore().run();
    }
}
