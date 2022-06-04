package co.edu.poli.proyectoweb.controller;

import co.edu.poli.proyectoweb.Servicios.CorreoServicio;
import co.edu.poli.proyectoweb.model.Correo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")

@Api(tags = {"Class: CorreoController"})
@RestController
@RequestMapping("/proyecto")
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
    @RequestMapping(value = "/msg", method= RequestMethod.PUT)
    @ApiOperation(value = "*** Service Method Get Send Email ***", notes = "*** Send confirmation Email\\\\WebApp ***")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error Sending Email!!! ***")})
    public String sendEmail(@RequestBody Correo correo){
        notificationService.sendEmail(correo);
        return "Email sent successfully";
    }
}
