package com.sw.model;

/**
 *
 * @author Mohammed
 */
public class ConversionManager
{

    public String fromDecToAnyBase(int number, int base)
    {
        String converted = "";

        if (number == 0)
            return "0";

        while (number != 0)
        {
            int temp = number % base;
            converted += temp < 10 ? temp : String.valueOf((char) (temp + 55));
            number = (int) Math.floor((double) number / base);

        }

        return reverse(converted);

    }

    public int fromAnyBaseToDec(String anyBase, int base)
    {
        char[] bits = anyBase.toCharArray();
        int valor = 0, aux = 0;

        for (int i = bits.length - 1; i >= 0; i--)
            valor += Math.pow(base, aux++) * (Character.isDigit(bits[i]) ? Integer.parseInt(String.valueOf(bits[i])) : ((int) bits[i]) - 55);

        return valor;

    }

    private String reverse(String text)
    {
        String textReversed = "";

        for (int i = text.length() - 1; i >= 0; i--)
            textReversed += String.valueOf(text.charAt(i));

        return textReversed;

    }

}
