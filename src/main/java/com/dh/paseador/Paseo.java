package com.dh.paseador;

import java.io.*;
import java.util.ArrayList;

public class Paseo {

    public static void main(String[] args) {

        Perro p1 = new Perro("Rufus", "Ovejero", 3, "Avenida 123");
        Perro p2 = new Perro("Fido", "Bulldog", 12, "Avenida siempre viva");
        Perro p3 = new Perro("Toby", "Coker", 6, "Calle Doce");
        Perro p4 = new Perro("Bobby", "Maltes", 9, "Calle carrusel");

        ArrayList<Perro> lunes = new ArrayList<Perro>();
        ArrayList<Perro> martes = new ArrayList<Perro>();
        ArrayList<Perro> miercoles = new ArrayList<Perro>();
        ArrayList<Perro> jueves = new ArrayList<Perro>();
        ArrayList<Perro> viernes = new ArrayList<Perro>();

        lunes.add(p1);
        miercoles.add(p1);
        viernes.add(p1);

        lunes.add(p2);
        martes.add(p2);
        miercoles.add(p2);
        jueves.add(p2);

        miercoles.add(p3);
        jueves.add(p3);
        viernes.add(p3);

        lunes.add(p4);
        martes.add(p4);
        miercoles.add(p4);
        jueves.add(p4);
        viernes.add(p4);


        try {
            FileOutputStream fo = new FileOutputStream("perros.dat");
            ObjectOutputStream archivo = new ObjectOutputStream(fo);

            archivo.writeObject(lunes);
            archivo.writeObject(martes);
            archivo.writeObject(miercoles);
            archivo.writeObject(jueves);
            archivo.writeObject(viernes);

            archivo.close();

            FileInputStream fi = new FileInputStream("perros.dat");
            ObjectInputStream archivoIn = new ObjectInputStream(fi);

            ArrayList<Perro> dia;

            for (int i=0; i<5; i++){
                System.out.println("Dia: " + (i+1));
                System.out.println("-----------------");
                dia = (ArrayList<Perro>) archivoIn.readObject();
                for (Perro p: dia){
                    System.out.println(p);
                }
            }
            archivoIn.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
