package Model;

import java.time.LocalDate;

public class UserCardModel {
    public String CardholderName;
    public String CardNumber;
    public LocalDate ValidDate;
    public int Cvc;
    public String CardNickname;


    public String NameOfBank = "";


    public UserCardModel(String cardholderName, String cardNumber, LocalDate validDate, int cvc, String cardNickname, String nameOfBank) {
        CardholderName = cardholderName;
        CardNumber = cardNumber;
        ValidDate = validDate;
        Cvc = cvc;
        CardNickname = cardNickname;
        NameOfBank = nameOfBank;
    }

    public String getCardNickname() {
        return CardNickname;
    }

    public void setCardNickname(String cardNickname) {
        CardNickname = cardNickname;
    }

    public String getCardholderName() {
        return CardholderName;
    }

    public void setCardholderName(String cardholderName) {
        CardholderName = cardholderName;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public LocalDate getValidDate() {
        return ValidDate;
    }

    public void setValidDate(LocalDate validDate) {
        ValidDate = validDate;
    }

    public int getCvc() {
        return Cvc;
    }

    public void setCvc(int cvc) {
        Cvc = cvc;
    }

    public String getNameOfBank() {
        return NameOfBank;
    }

    public void setNameOfBank(String nameOfBank) {
        NameOfBank = nameOfBank;
    }
}
