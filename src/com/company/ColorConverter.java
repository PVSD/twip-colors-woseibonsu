package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ColorConverter  {

    public ColorConverter(int R, int G, int B)
    {
        RGBTriplet.add(R);
        RGBTriplet.add(G);
        RGBTriplet.add(B);
    }
    public ColorConverter(String name) throws IOException
    {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine())
        {
            String temp = scanner.next();
            if (temp.equalsIgnoreCase(name))
            {
                colorName = temp;
            }
        }
        if (colorName == null)
        {
            hexNumber = name;
        }

    }
    public void convertToRGB(String hexNumber)
    {
        int tempNumb = 0;
        for (int i = 0; i < 6; i++)
        {
            if(i % 2 == 0)
            {
                tempNumb = 0;
                //CONVERTS HEX DIGIT 1 to DECIMAL
                char tempChar = hexNumber.charAt(i);
                if ((int) tempChar >= 65)
                {
                    tempNumb += ((int) tempChar - 55) * 16;
                }
                else
                {
                    tempNumb += (Integer.parseInt(tempChar + "")) * 16;
                }
            }
            else
            {
                //CONVERTS HEX DIGIT 1 to DECIMAL
                char tempChar = hexNumber.charAt(i);
                if ((int) tempChar >= 65) {
                    tempNumb += ((int) tempChar - 55);
                } else
                {
                    tempNumb += (Integer.parseInt(tempChar + ""));
                }
                RGBTriplet.add(tempNumb);
            }

        }

    }
    public void convertToHex(int R, int G, int B)
    {
        //I WAS GOING TO USE RECURSION, BUT I DON'T REALLY WANT TO CHANGE MY METHOD SIG SO...
        int[] params = {R, G, B};

        for (int i = 0; i < 3; i++)
        {
            //SETS RAW NUMBERS
            int valOne = (params[i] / 16);
            int valZero = params[i] - (valOne * 16);

            //DETERMINES HEX DIGIT ONE
            if (valOne < 10)
                hexNumber += valOne;
            else
                hexNumber += (char) (valOne + 55);

            //DETERMINES HEX DIGIT TWO
            if (valZero < 10)
                hexNumber += valZero;
            else
                hexNumber += (char)(valOne + 55);
        }
    }
    public void convertToColorName(String hexNumber) throws IOException
    {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext())
        {
            String temp = scanner.next();
            if (temp.equalsIgnoreCase("#"+hexNumber))
            {
                colorName = scanner.next();
            }
        }


    }
    public String getColorName() {return colorName;}
    public String getHexNumber() {return hexNumber;}
    public ArrayList<Integer> getRGBTriplet() {return RGBTriplet;}

    private String colorName;
    private String hexNumber = "";
    private ArrayList<Integer> RGBTriplet = new ArrayList<>();
    private File file = new File("HTMLColorNames");

}
