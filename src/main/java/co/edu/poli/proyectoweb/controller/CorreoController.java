package co.edu.poli.proyectoweb.controller;

import co.edu.poli.proyectoweb.Servicios.CorreoServicio;
import co.edu.poli.proyectoweb.model.Correo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorreoController {

    @Autowired
    private CorreoServicio notificationService;

    /* JSON email...
    {
        "mailTo": "wsoto@poligran.edu.co",
        "mailSubject": "hola mundo",
        "mailContent": "bienvenidos",
        "attachments" : ["/Users/wilsonsoto/Downloads/TransaccionPNCBANK.pdf"]
    }
    */
    @RequestMapping(value = "/api/v1/msg", method= RequestMethod.GET)
    public String sendEmail(@RequestBody Correo correo){
        notificationService.sendEmail(correo);
        return "Email sent successfully";
    }
}
