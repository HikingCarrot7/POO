package com.sw.controller;

import com.sw.model.Maestro;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Mohammed
 */
public final class DataPersistenceManager
{

    private final String rutaMaestros = "res/Maestros.txt";
    private final File file;
    private ArrayList<Maestro> maestros;

    public DataPersistenceManager()
    {

        file = new File(rutaMaestros);

        if (file.exists())
            loadMaestros();

        else
            try
            {
                file.createNewFile();

            } catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }

    }

    public void loadMaestros()
    {
        try
        {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file)))
            {
                maestros = (ArrayList<Maestro>) in.readObject();

            }

        } catch (IOException | ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());

        }

    }

    public void writeMaestros(ArrayList<Maestro> maestros)
    {
        try
        {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file)))
            {
                out.writeObject(maestros);

            }

        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    public ArrayList<Maestro> getMaestros()
    {

        return maestros != null ? maestros : new ArrayList<>();

    }

}
