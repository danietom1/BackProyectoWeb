
package co.edu.poli.proyectoweb.service;


import co.edu.poli.proyectoweb.model.User;
import co.edu.poli.proyectoweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(Email);

		if (user == null)
			throw new UsernameNotFoundException(Email);

		return new UserDetailsImpl(user);
	}

}
