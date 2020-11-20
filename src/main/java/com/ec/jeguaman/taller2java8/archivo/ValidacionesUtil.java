/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.jeguaman.taller2java8.archivo;

/**
 *
 * @author J Guaman
 */
public class ValidacionesUtil {

    public static boolean validarMonto(String[] linea) {
        return Double.valueOf(linea[6]) > 5000;
    }

    public static boolean validarDestino(String[] linea) {
        return linea[1].compareTo("China") == 0;
    }

    public static boolean validarAnio(String[] linea, Integer anio) {
        return Integer.valueOf(linea[2]).compareTo(anio) == 0;
    }

//    public static String validarAnio(String[] linea) {
//        return linea[2];
//    }

    public static boolean validarTipoTema(String linea, EnumTipoExportacion tipoExportacion) {
        return linea.compareTo(tipoExportacion.getValue()) == 0;
    }

}
