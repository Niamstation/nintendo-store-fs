package com.yanisdib.nintendostore.aggregates;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Email {

    private final String value;

    private Email(String value) {
        this.value = this.validate(value);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        return Objects.equals(value, email.value);

    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Email{" +
                "value='" + value + '\'' +
                '}';
    }

    private String validate(String value) {

        if (!this.isValid(value)) {
            throw new IllegalArgumentException("Invalid email: " + this.value);
        }

        return value;

    }

    /**
     * Verify that the email is valid
     *
     * @return boolean
     */
    private boolean isValid(String value) {

        String regex = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);

        return matcher.find();

    }

}
