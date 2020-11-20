/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.jeguaman.taller2java8;

import com.ec.jeguaman.taller2java8.archivo.EnumTipoExportacion;
import com.ec.jeguaman.taller2java8.archivo.ValidacionesUtil;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author J Guaman
 */
public class RunValidaciones {

    public static void main(String[] args) {
        String fileName = "D:/jeguaman/archivoPruebaTaller.txt";
        System.out.println("Implementación de validaciones y generación de collections");
        readFileValidacionMonto(fileName);
        readFileValidacionDestino(fileName);
        readFileValidacionTipoTema(fileName);
    }

    private static void readFileValidacionTipoTema(String filename) {
        System.out.println("\nFiltro3: Realizar flatMap y filtrado por tipo de tema los 4 primeros.");
        try (Stream<String> streamFile = Files.lines(Paths.get(filename))) {
            streamFile.map(linea -> linea.split(",")).flatMap(linea -> Arrays.stream(linea)).
                    filter(linea -> ValidacionesUtil.validarTipoTema(linea, EnumTipoExportacion.IMPORTACION)).
                    limit(4).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error validacion por tipo de tema " + e);
        }
    }

    private static void readFileValidacionDestino(String filename) {
        System.out.println("\nFiltro 2: Filtrar el destino por el país de China y trae los 3 primeros que encuentra");
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.parallel().map(linea -> linea.split(",")).filter(ValidacionesUtil::validarDestino).limit(3).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error al leer y escribir el archivo " + e);
        }
    }

    private static void readFileValidacionMonto(String filename) {
        System.out.println("Filtro 1: Agrupar los valores mayores a 5000 y los que son menores  a 5000 excepto la primera fila de título ");
        try (Stream<String> streamFile = Files.lines(Paths.get(filename))) {
            Map<Boolean, List<String[]>> mapaProcesamiento = streamFile.parallel().map(linea -> linea.split(",")).skip(1)
                    .collect(Collectors.partitioningBy(ValidacionesUtil::validarMonto));
            System.out.println(mapaProcesamiento.get(true));
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
}
