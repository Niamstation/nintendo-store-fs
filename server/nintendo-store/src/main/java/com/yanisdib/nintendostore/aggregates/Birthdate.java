package com.yanisdib.nintendostore.aggregates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;

public final class Birthdate {

    private LocalDate value;

    public Birthdate(LocalDate value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Birthdate birthdate = (Birthdate) o;

        return Objects.equals(value, birthdate.value);

    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Birthdate{" +
                "value=" + value +
                '}';
    }

    private boolean isLegallyMajor(LocalDate value) {

        if(value == null) {
            return false;
        }

        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(value, currentDate);

        return period.getYears() >= 18;

    }

}
