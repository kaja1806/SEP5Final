package Model;

import java.time.LocalDate;

public class UserCardModel {
    public String CardholderName;
    public String CardNumber;
    public LocalDate ValidDate;
    public int Cvc;

    public UserCardModel(String cardholderName, String cardNumber, LocalDate validDate, int cvc) {
        CardholderName = cardholderName;
        CardNumber = cardNumber;
        ValidDate = validDate;
        Cvc = cvc;
    }

    public void setCardholderName(String cardholderName) {
        CardholderName = cardholderName;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public void setValidDate(LocalDate validDate) {
        ValidDate = validDate;
    }

    public void setCvc(int cvc) {
        Cvc = cvc;
    }

    public String getCardholderName() {
        return CardholderName;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public LocalDate getValidDate() {
        return ValidDate;
    }

    public int getCvc() {
        return Cvc;
    }
}
