package com.com.tests;

import com.Storage.OutputToExcel;

public class RunTests
{
    public static void main(String[] args)
    {
        OutputToExcel outputToExcel = new OutputToExcel();
        clickGoButton goButton = new clickGoButton();
        goButton.clickGoButton();
        goButton.waitForTestToLoad();
        goButton.readPingValue();
        goButton.readDLSpeed();
        goButton.readUpLSpeed();
        outputToExcel.writeToExcel();
    }
}
