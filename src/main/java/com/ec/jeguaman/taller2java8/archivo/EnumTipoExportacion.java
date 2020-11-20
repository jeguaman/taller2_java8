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
public enum EnumTipoExportacion {

    EXPORTACION("Exportación"),
    IMPORTACION("Importación");

    private final String value;

    private EnumTipoExportacion(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
