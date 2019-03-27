package by.epam.javatraining.rassolko.controller;

import by.epam.javatraining.rassolko.collections.Storage;
import by.epam.javatraining.rassolko.entity.*;

public class Main
{
    public static void main(String[] args) 
    {
        Helicopter helicopter1 = Creator.createHelicopter("MI-8");
        helicopter1.setName("Sweety");
        
        PassengerAirliner plane1 = Creator.createPassengerAirliner("AN-2");
        plane1.setSeats(14);
        
        Helicopter helicopter = Creator.createHelicopter("MI-8");
        System.out.println("");
        
        CargoAirliner plane2 = Creator.createCargoAirliner("Boeng-787");
        plane2.setPayload(10000);
        plane2.setLoadingGateHeightMeters(7);
        plane2.setLoadingGateWidthMeters(9);
