package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {
    Radio rad = new Radio();

    @Test
    void radioStations() {
        Radio rad1 = new Radio(20);

        Assertions.assertEquals(10, rad.getAmountRadStations());
        Assertions.assertEquals(20, rad1.getAmountRadStations());
    }

    @ParameterizedTest
    @CsvSource({
            "0,1",
            "1,2",
            "8,9",
            "9,0"
    })
    void nextRadioStation(int newCurrentRadioStation, int expected) {
        // переключение на след.станцию (по умлочанию кол-во радиостанций 10)

        rad.setCurrentRadioStation(newCurrentRadioStation);
        rad.setNext();

        int actual = rad.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,1",
            "1,2",
            "18,19",
            "19,0"
    })
    void nextRadioStation1(int newCurrentRadioStation, int expected) {
        Radio rad1 = new Radio(20); // переключение на след.станцию при количестве радио станций 20

        rad1.setCurrentRadioStation(newCurrentRadioStation);
        rad1.setNext();

        int actual = rad1.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,9",
            "1,0",
            "9,8"
    })
    void prevRadioStation(int newCurrentRadioStation, int expected) {
        // переключение на предыд.станцию

        rad.setCurrentRadioStation(newCurrentRadioStation);
        rad.setPrev();

        int actual = rad.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "-2,0",
            "-1,0",
            "0,0",
            "1,1",
            "9,9",
            "10,0",
            "100,0"
    })
    void installRadioStation(int newCurrentRadioStation, int expected) {
        // выставление номера радиостанции через прямое указание её номера

        rad.setCurrentRadioStation(newCurrentRadioStation);

        int actual = rad.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void installRadioStation1() {
        Radio rad1 = new Radio(20);// выставление номера радиостанции через прямое указание её номера (при количестве радиостанций 20)

        rad1.setCurrentRadioStation(15);

        int actual = rad1.getCurrentRadioStation();
        int expected = 15;

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,1",
            "1,2",
            "99,100",
            "100,100"
    })
    void increaseCurrentVolume(int newCurrentVolume, int expected) {
        // увеличение громкости звука на 1

        rad.setCurrentVolume(newCurrentVolume);
        rad.increaseVolume();

        int actual = rad.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "1,0",
            "100,99"
    })
    void decreaseCurrentVolume(int newCurrentVolume, int expected) {
        // уменьшение громкости звука на 1

        rad.setCurrentVolume(newCurrentVolume);
        rad.decreaseVolume();

        int actual = rad.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}