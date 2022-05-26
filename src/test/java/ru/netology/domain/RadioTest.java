package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {

    @ParameterizedTest
    @CsvSource({
            "0,1",
            "1,2",
            "8,9",
            "9,0"
    })
    void nextRadioStation(int newCurrentRadioStation, int expected) {
        Radio rad = new Radio(); // переключение на след.станцию

        rad.setCurrentRadioStation(newCurrentRadioStation);
        rad.setNext();

        int actual = rad.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,9",
            "1,0",
            "9,8"
    })
    void prevRadioStation(int newCurrentRadioStation, int expected) {
        Radio rad = new Radio();  // переключение на предыд.станцию

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
        Radio rad = new Radio();  // выставление номера радиостанции через прямое указание её номера

        rad.setCurrentRadioStation(newCurrentRadioStation);

        int actual = rad.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,1",
            "1,2",
            "10,10"
    })
    void increaseCurrentVolume(int newCurrentVolume, int expected) {
        Radio rad = new Radio(); // увеличение громкости звука на 1

        rad.setCurrentVolume(newCurrentVolume);
        rad.increaseVolume();

        int actual = rad.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "1,0",
            "10,9"
    })
    void decreaseCurrentVolume(int newCurrentVolume, int expected) {
        Radio rad = new Radio();  // уменьшение громкости звука на 1

        rad.setCurrentVolume(newCurrentVolume);
        rad.decreaseVolume();

        int actual = rad.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "-2,0",
            "-1,0",
            "11,0",
            "100,0"
    })
    void installVolume(int newCurrentVolume, int expected) {
        Radio rad = new Radio(); // выставление громкости звука через прямое указание

        rad.setCurrentVolume(newCurrentVolume);

        int actual = rad.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}