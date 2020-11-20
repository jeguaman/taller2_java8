/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.jeguaman.taller2java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *
 * @author J Guaman
 */
public class RunArchivo {

    public static void main(String[] args) {
        String fileName = "D:/jeguaman/archivoPruebaTaller.txt";
        System.out.println("Lectura de datos desde un archivo txt con cabecera");
        readFile(fileName);
    }

    private static void readFile(String filename) {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error al leer y escribir el archivo " + e);
        }
    }

}
