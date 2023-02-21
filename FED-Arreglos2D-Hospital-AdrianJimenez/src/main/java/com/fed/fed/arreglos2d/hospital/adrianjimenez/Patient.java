package com.fed.fed.arreglos2d.hospital.adrianjimenez;

/**
 *
 * @author adrianjimenez
 */
public class Patient {
    private int floor;
    private int stretcher;
    private String name;

    public Patient(int floor, int stretcher, String name) {
        this.floor = floor;
        this.stretcher = stretcher;
        this.name = name;
    }

    public Patient() {
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getStretcher() {
        return stretcher;
    }

    public void setStretcher(int stretcher) {
        this.stretcher = stretcher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
