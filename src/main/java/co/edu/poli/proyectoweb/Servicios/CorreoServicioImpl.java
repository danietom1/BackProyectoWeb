package co.edu.poli.proyectoweb.Servicios;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import co.edu.poli.proyectoweb.model.Correo;

@Service
public class CorreoServicioImpl implements CorreoServicio{

	
	@Autowired
    private JavaMailSender mailSender;
	
	 @Value("${spring.mail.username}")
	    private String emailFrom;
	    
	    public void sendEmail (Correo correo) {
	    	
	        MimeMessage mimeMessage = mailSender.createMimeMessage();
	        
	        try {
	 
	            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	 
	            mimeMessageHelper.setSubject(correo.getCorreoSubject());
	            mimeMessageHelper.setFrom(emailFrom);
	            mimeMessageHelper.setTo(correo.getCorreoPara());
	            mimeMessageHelper.setText(correo.getCorreoContenido());
	            
	            if (correo.getAttachments()!=null)
	                for (Object attachment: correo.getAttachments()) {
	                	File f = new File(attachment.toString());
	                    FileSystemResource file = new FileSystemResource(f);
	                    mimeMessageHelper.addAttachment(f.getName(), file);
	                }
	            	
	            mailSender.send(mimeMessageHelper.getMimeMessage());
	            
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	       
	    }

	
	
}
