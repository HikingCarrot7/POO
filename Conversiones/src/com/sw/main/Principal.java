package com.sw.main;

import com.sw.model.ConversionBin;
import com.sw.model.ConversionDec;
import com.sw.model.ConversionOct;

/**
 *
 * @author Mohammed
 */
public class Principal
{

    public static void main(String[] args)
    {
        String temp = new ConversionBin().deOctalABinario("150");

        String temp2 = new ConversionOct(new ConversionBin(), new ConversionDec()).deBinAOctal("100011101");

        int temp3 = new ConversionDec().deOctalADecimal("5643");

        System.out.println(temp2);
    }

}
