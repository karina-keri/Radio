package ru.netology;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private final int stationCount;

    public Radio() {
        this.stationCount = 10;
    }

    public Radio(int stationCount) {
        this.stationCount = stationCount > 0 ? stationCount : 10;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station < stationCount) {
            currentStation = station;
        }
    }

    public void next() {
        currentStation = (currentStation + 1) % stationCount;
    }

    public void prev() {
        currentStation = (currentStation - 1 + stationCount) % stationCount;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    public int getStationCount() {
        return stationCount;
    }
}