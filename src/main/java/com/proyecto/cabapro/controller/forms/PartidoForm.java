package com.proyecto.cabapro.controller.forms;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.proyecto.cabapro.enums.EstadoPartido;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class PartidoForm {

    private Integer idPartido;

    @NotNull(message = "La fecha es obligatoria")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime fecha;

    @NotBlank(message = "El lugar es obligatorio")
    @Size(min = 3, max = 100, message = "El lugar debe tener entre 3 y 100 caracteres")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9\\s]+$", message = "El lugar solo puede contener letras, números y espacios")
    private String lugar;

   
    private EstadoPartido estadoPartido;

    @NotBlank(message = "El equipo local es obligatorio")
    @Size(min = 3, max = 50, message = "El equipo local debe tener entre 3 y 50 caracteres")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9\\s]+$", message = "El equipo local solo puede contener letras, números y espacios")
    private String equipoLocal;

    @NotBlank(message = "El equipo visitante es obligatorio")
    @Size(min = 3, max = 50, message = "El equipo visitante debe tener entre 3 y 50 caracteres")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9\\s]+$", message = "El equipo visitante solo puede contener letras, números y espacios")
    private String equipoVisitante;

    @NotNull(message = "Debe seleccionar un torneo")
    private Integer torneoId;


    // Getters y setters
    public Integer getIdPartido() { return idPartido; }
    public void setIdPartido(Integer idPartido) { this.idPartido = idPartido; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }

    public EstadoPartido getEstadoPartido() { return estadoPartido; }
    public void setEstadoPartido(EstadoPartido estadoPartido) { this.estadoPartido = estadoPartido; }

    public String getEquipoLocal() { return equipoLocal; }
    public void setEquipoLocal(String equipoLocal) { this.equipoLocal = equipoLocal; }

    public String getEquipoVisitante() { return equipoVisitante; }
    public void setEquipoVisitante(String equipoVisitante) { this.equipoVisitante = equipoVisitante; }

    public Integer getTorneoId() { return torneoId; }
    public void setTorneoId(Integer torneoId) { this.torneoId = torneoId; }

   
}
