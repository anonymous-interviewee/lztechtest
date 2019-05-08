package com.lz.demo.models;

import net.jcip.annotations.Immutable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

import static java.lang.String.format;

@Immutable
public final class CardDetails implements Comparable<CardDetails>{

    private static final SimpleDateFormat DATE_PARSER = new SimpleDateFormat("MMM-yyyy");


    private final String bankName, cardNumber, expirationDate;

    public CardDetails(String bankName, String cardNumber, String expirationDate) {
        this.bankName = bankName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    public String getBankName() {
        return bankName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getFilteredCardNumber() {
        return format("%s-xxxx-xxxx-xxxx", cardNumber.substring(0,4));
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return String.format(
                "Card details: %s, %s, %s",
                getBankName(), getFilteredCardNumber(), getExpirationDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        CardDetails other = (CardDetails) o;

        return getExpirationDate().equals(other.getExpirationDate()) &&
                getBankName().equals(other.getBankName()) &&
                getCardNumber().equals(other.getCardNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, cardNumber, expirationDate);
    }

    @Override
    public int compareTo(CardDetails o) {
        try {
            return DATE_PARSER.parse(getExpirationDate()).compareTo(DATE_PARSER.parse(o.getExpirationDate()));
        } catch (ParseException e) {
            //if we got here we didnt validate ages ago (which we didnt for this test so assume equal)
            return 0;
        }
    }
}
