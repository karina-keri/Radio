package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void shouldUseDefaultStationCount() {
        Radio radio = new Radio();
        assertEquals(10, radio.getStationCount());
    }

    @Test
    void shouldUseCustomStationCount() {
        Radio radio = new Radio(20);
        assertEquals(20, radio.getStationCount());
    }

    @Test
    void shouldFallbackToDefaultWhenInvalidCountProvided() {
        Radio radio = new Radio(0);
        assertEquals(10, radio.getStationCount());

        Radio negative = new Radio(-5);
        assertEquals(10, negative.getStationCount());
    }

    @Test
    void shouldSetValidStation() {
        Radio radio = new Radio(15);
        radio.setCurrentStation(7);
        assertEquals(7, radio.getCurrentStation());
    }

    @Test
    void shouldIgnoreInvalidStationAbove() {
        Radio radio = new Radio(15);
        radio.setCurrentStation(16); // too high
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldIgnoreInvalidStationBelow() {
        Radio radio = new Radio(15);
        radio.setCurrentStation(-1); // negative
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldGoToNextStationInRange() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(2);
        radio.next();
        assertEquals(3, radio.getCurrentStation());
    }

    @Test
    void shouldWrapNextFromMaxStation() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(4);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldGoToPrevStationInRange() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(3);
        radio.prev();
        assertEquals(2, radio.getCurrentStation());
    }

    @Test
    void shouldWrapPrevFromMinStation() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        for (int i = 0; i < 55; i++) {
            radio.increaseVolume();
        }
        assertEquals(55, radio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseVolumeAbove100() {
        Radio radio = new Radio();
        for (int i = 0; i < 150; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        for (int i = 0; i < 50; i++) {
            radio.increaseVolume();
        }
        for (int i = 0; i < 20; i++) {
            radio.decreaseVolume();
        }
        assertEquals(30, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseVolumeBelowZero() {
        Radio radio = new Radio();
        for (int i = 0; i < 5; i++) {
            radio.decreaseVolume();
        }
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldSetCurrentStationOnlyWhenValid() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(8);
        assertEquals(8, radio.getCurrentStation());
        radio.setCurrentStation(12); // invalid
        assertEquals(8, radio.getCurrentStation()); // still 8
    }
}