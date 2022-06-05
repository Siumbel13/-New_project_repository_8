package ru.netology.domain;

public class Radio {

    private int amountRadStations;
    private int currentRadioStation;
    private int currentVolume;

    public Radio(int amountRadioStations) {
        this.amountRadStations = amountRadioStations; // количество радиостанций задается пользователем
    }

    public Radio() {
        amountRadStations = 10; // количество радиостанций по умолччанию 10
    }

    public int getAmountRadStations() {
        return amountRadStations;
    }

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int newCurrentRadioStation) {
        if (newCurrentRadioStation > amountRadStations - 1) {
            return;
        }
        if (newCurrentRadioStation < 0) {
            return;
        }
        this.currentRadioStation = newCurrentRadioStation;
    }

    public void setNext() {
        if (currentRadioStation == amountRadStations - 1) {
            currentRadioStation = 0;
        } else {
            currentRadioStation = currentRadioStation + 1;
        }
    }

    public void setPrev() {
        if (currentRadioStation == 0) {
            currentRadioStation = amountRadStations - 1;
        } else {
            currentRadioStation = currentRadioStation - 1;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) {
        this.currentVolume = newCurrentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
    }
}


