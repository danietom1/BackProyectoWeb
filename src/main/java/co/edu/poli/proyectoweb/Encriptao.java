package co.edu.poli.proyectoweb;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String password = "12345";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);

		System.out.println(hashedPassword);

	}

}
