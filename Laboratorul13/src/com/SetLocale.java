package com;

import app.LocaleExplore;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale {
    public void SetLocaleCommand(String languageTag) {
        LocaleExplore.setLocale(languageTag);
    }

}
