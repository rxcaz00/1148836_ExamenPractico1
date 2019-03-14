package mx.appswbd.examen.practico1.Model;

import lombok.Data;

import java.util.Date;

@Data
public class Cita {
    private String asunto;
    private String fecha;
    private String hora;
    private String doctor;
}
