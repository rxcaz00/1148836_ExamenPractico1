package mx.appswbd.examen.practico1.Controller;

import mx.appswbd.examen.practico1.Model.Cita;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Controlador {
    private List<Cita> valores = new ArrayList<>();

    @RequestMapping(path = "/calendario")
    public String lista(Model model) {
        model.addAttribute("citas",valores);
        return "calen";
    }

    @RequestMapping(path = "/citas")
    public String estados() {
        return "citas";
    }

    @PostMapping("/add")
    public String add(String asunto, String fecha, String hora, String doctores) {
        int v = Integer.parseInt(doctores);
        if(v == 1)
            doctores = "Dr. Gutiérrez";
        if(v == 2)
            doctores = "Dr. Mendoza";
        if(v == 3)
            doctores = "Dra. Juárez";
        if(v == 4)
            doctores = "Dra. Hilares";

        Cita cita = new Cita();
        cita.setAsunto(asunto);
        cita.setDoctor(doctores);
        cita.setFecha(fecha);
        cita.setHora(hora);

        valores.add(cita);

        return "redirect:/calendario";
    }
}
