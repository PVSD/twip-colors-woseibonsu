package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException
    {
        System.out.println("Enter A color. Use HEXADECIMAL, RBG TRIPLETS, or HTML COLOR NAMES");
        Scanner kbinput = new Scanner(System.in);
        ColorConverter color;

        String input = kbinput.nextLine();
        if (input.contains(","))
        {
            color = new ColorConverter(Integer.parseInt(input.substring(0, input.indexOf(","))),
                    Integer.parseInt(input.substring(input.indexOf(" ") + 1, input.lastIndexOf(","))),
                    Integer.parseInt(input.substring(input.lastIndexOf(",") + 2, input.length())));
            color.convertToHex(Integer.parseInt(input.substring(0, input.indexOf(","))),
                    Integer.parseInt(input.substring(input.indexOf(" ") + 1, input.lastIndexOf(","))),
                    Integer.parseInt(input.substring(input.lastIndexOf(",") + 2, input.length())));
            color.convertToColorName(color.getHexNumber());
        }
        else
        {
            color = new ColorConverter(input);
            if(color.getColorName() != null)
            {
            }
            else
            {
                color.convertToRGB(color.getHexNumber());
                color.getColorName();
            }
        }

    }
}
