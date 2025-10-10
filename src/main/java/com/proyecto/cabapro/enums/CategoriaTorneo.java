// MODIFICADO 

// com.proyecto.cabapro.enums.CategoriaTorneo
package com.proyecto.cabapro.enums;

public enum CategoriaTorneo {
    UNIVERSITARIO, AMATEUR, PROFESIONAL;

    public String getMessageKey() {
        return "categoria." + this.name().toLowerCase();
    }
}
