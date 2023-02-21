package com.fed.fed.arreglos2d.hospital.adrianjimenez;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;


public class GridComponent extends JComponent {

    private int[][] stretcher;
    private int width;
    private int height;
    private List<Patient> patients = new ArrayList();

    public GridComponent(int[][] stretcher, int width, int height) {
        this.stretcher = stretcher;
        this.width = width;
        this.height = height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja el fondo del panel
        g.setColor(new Color(47, 52, 63));
        g.fillRect(0, 0, getWidth(), getHeight());

        // Dibuja la cuadrícula
        for (int i = 0; i < stretcher.length; i++) {
            for (int j = 0; j < stretcher[i].length; j++) {
               
                if (stretcher[i][j] == 0) {
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRoundRect(10 + width * i, 10 + height * j, width, height, 8, 8);
                    g.setColor(new Color(47, 52, 63));
                    g.drawRoundRect(10 + width * i, 10 + height * j, width, height, 8, 8);
                    FontMetrics metrics = g.getFontMetrics();
                    int x = 10 + width * i + (width - metrics.stringWidth("D")) / 2;
                    int y = 10 + height * j + ((height - metrics.getHeight()) / 2) + metrics.getAscent();
                    g.drawString("DIS", x, y);
                } else {
                    g.setColor(Color.RED);
                    g.fillRoundRect(10 + width * i, 10 + height * j, width, height, 8, 8);
                    g.setColor(new Color(47, 52, 63));
                    g.drawRoundRect(10 + width * i, 10 + height * j, width, height, 8, 8);
                    FontMetrics metrics = g.getFontMetrics();
                    int x = 10 + width * i + (width - metrics.stringWidth("O")) / 2;
                    int y = 10 + height * j + ((height - metrics.getHeight()) / 2) + metrics.getAscent();
                    g.drawString("OCU", x, y);
                }
            }
        }
    }

    protected void paintElement(Graphics g, int cols, int rows, String name) {
        super.paintComponent(g);
        stretcher[rows][cols] = 1;
        patients.add(new Patient(cols, rows, name));
        paintComponent(g);
    }
    
    protected void removeElement(Graphics g, int cols, int rows) {
        super.paintComponent(g);
        stretcher[rows][cols] = 0;
        patients.removeIf(it -> it.getStretcher() == rows && it.getFloor() == cols);
        paintComponent(g);
    }
    
    protected Optional<Patient> findByStretcher(int cols, int rows) {
        return patients.stream().filter(d -> d.getFloor() == rows && d.getStretcher() == rows).findFirst();
    }

    public List<Patient> getPatients() {
        return patients;
    }
}
