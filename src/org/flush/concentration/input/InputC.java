package org.flush.concentration.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 18.10.2016.
 */
public class InputC {
    private int n;

    private List<Double> cList = new ArrayList<>();

    private double c1;
    private double c2;

    public double getC1() {
        return c1;
    }

    public void setC1(double c1) {
        this.c1 = c1;
    }

    public double getC2() {
        return c2;
    }

    public void setC2(double c2) {
        this.c2 = c2;
    }

    public InputC(int n) {
        this.n = n;
    }


    public List<Double> getCList() {

        BufferedReader readC = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;

        System.out.println("Input C values: ");
        try {
            while (i < n) {
                cList.add(Double.parseDouble(readC.readLine()));
                i++;
            }
        } catch(Exception e) {
            System.out.println("Written C isn't a Double number");
            e.printStackTrace();
        }
        return cList;
    }
}
