package io.xhub.xquiz.constants;

public class RegexExpressions {

    public static final String ALPHABETIC_MIN_2_CHARS = "^([A-Za-z]){2,}$";
    public static final String PHONE_NUMBER = "(\\+\\d{1,3})(\\d{9})$";
    public static final String EMAIL = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
}