/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.jeguaman.taller2java8;

import com.ec.jeguaman.taller2java8.archivo.ValidacionesUtil;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author J Guaman
 */
public class RunReduce {

    public static void main(String[] args) {
        String fileName = "D:/jeguaman/archivoPruebaTaller.txt";
        System.out.println("Ejemplo Reduce");
        readFile(fileName, 2019);
    }

    private static void readFile(String filename, Integer anio) {
        System.out.println("\nSe obtiene la sumatoria de los valores por año " + anio);
        try (Stream<String> streamFile = Files.lines(Paths.get(filename))) {
            streamFile.map(linea -> linea.split(",")).skip(1).filter(linea
                    -> ValidacionesUtil.validarAnio(linea, anio)).flatMap(linea
                    -> Arrays.stream(linea, 6, 7)).
                    collect(Collectors.toList()).stream().mapToDouble(Double::valueOf).reduce(Double::sum).ifPresent(System.out::println);
        } catch (Exception e) {
            System.out.println("Error validacion por tipo de tema " + e);
        }
    }

}
