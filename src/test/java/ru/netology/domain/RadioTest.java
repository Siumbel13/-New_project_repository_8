package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1,2",
            "8,9",
            "9,0"
    })
    void nextRadioStation(int newCurrentRadioStation, int expected) {
        Radio rad = new Radio();

        rad.setCurrentRadioStation(newCurrentRadioStation);
        rad.setNext();

        int actual = rad.getCurrentRadioStation();
        //int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,9",
            "1,0",
            "9,8"
    })
    void prevRadioStation(int newCurrentRadioStation, int expected) {
        Radio rad = new Radio();

        rad.setCurrentRadioStation(newCurrentRadioStation);
        rad.setPrev();

        int actual = rad.getCurrentRadioStation();
        //int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,1",
            "1,2",
            "10,10"
    })
    void increaseCurrentVolume(int newCurrentVolume, int expected) {
        Radio rad = new Radio();

        rad.setCurrentVolume(newCurrentVolume);
        rad.increaseVolume();

        int actual = rad.getCurrentVolume();
        //int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "1,0",
            "10,9"
    })
    void decreaseCurrentVolume(int newCurrentVolume, int expected) {
        Radio rad = new Radio();

        rad.setCurrentVolume(newCurrentVolume);
        rad.decreaseVolume();

        int actual = rad.getCurrentVolume();
        //int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

}