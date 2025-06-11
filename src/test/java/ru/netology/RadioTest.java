package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    @Test
    void shouldSetStationWithinRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationOutOfRangeAbove() {
        Radio radio = new Radio();
        radio.setCurrentStation(10); // больше 9
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationOutOfRangeBelow() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1); // меньше 0
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldGoToNextStationFromMiddle() {
        Radio radio = new Radio();
        radio.setCurrentStation(4);
        radio.next();
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldGoToNextStationFromMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldGoToPrevStationFromMiddle() {
        Radio radio = new Radio();
        radio.setCurrentStation(4);
        radio.prev();
        assertEquals(3, radio.getCurrentStation());
    }

    @Test
    void shouldGoToPrevStationFromMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldIncreaseVolumeFromMiddle() {
        Radio radio = new Radio();
        for (int i = 0; i < 50; i++) {
            radio.increaseVolume();
        }
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    void shouldIncreaseVolumeAtMax() {
        Radio radio = new Radio();
        for (int i = 0; i <= 100; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolumeFromMiddle() {
        Radio radio = new Radio();
        for (int i = 0; i < 70; i++) {
            radio.increaseVolume();
        }
        for (int i = 0; i < 20; i++) {
            radio.decreaseVolume();
        }
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseVolumeAboveMax() {
        Radio radio = new Radio();
        for (int i = 0; i < 150; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseVolumeBelowMin() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseVolumeAtZero() {
        Radio radio = new Radio();
        for (int i = 0; i < 5; i++) {
            radio.decreaseVolume(); // остаётся 0
        }
        assertEquals(0, radio.getCurrentVolume());
    }
}
