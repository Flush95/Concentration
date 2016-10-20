package org.flush.concentration.input;

import org.flush.concentration.service.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Admin on 18.10.2016.
 */
public class InputH {

    private int n;
    private double k = 0;
    private double h1;
    private double h2;
    private double hX;

    private Service service = new Service();

    private List<Integer> hList = new ArrayList<>();

    public InputH(int n) {
        this.n = n;
    }

    public InputH() {

    }

    public List<Integer> getHList() {

        BufferedReader readH = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;

        System.out.println("Input h values: ");
        try {
            while (i < n) {
                hList.add(Integer.parseInt(readH.readLine()));
                i++;
            }
        } catch(Exception e) {
            System.out.println("Written h isn't a Integer number");
            e.printStackTrace();
        }

        return hList;
    }

    public List<Double> getHiAvgList(double hx, int quantity) {

        List <Integer> hiList = new ArrayList<>();
        hiList.addAll(getHList());
        List <Double> approxList = new ArrayList<>();
        List<Integer> fourList = new ArrayList<>();

        int i = 1;

        while (i <= hiList.size()) {
            fourList.add(hiList.get(i-1));
            if (i % quantity == 0) {
                approxList.add(service.getApproximateNumber(fourList));
                fourList.clear();
            }
            i++;
        }
        return approxList;
    }
}
