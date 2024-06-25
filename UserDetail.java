package com.projeto.ads.service;

import java.util.Collections;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.projeto.ads.model.Usuario;
import com.projeto.ads.repository.UserRepository;
@Service
public class UserDetail implements UserDetailsService {

	@Autowired
UserRepository userRepository; 	
	
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Usuario user= userRepository.findByUsername(username);
	if(user==null) {
		throw new UsernameNotFoundException("Usuário não existe!");
	}
		Set<GrantedAuthority> authorities= Collections.singleton(
				new SimpleGrantedAuthority(user.getRole().getNome()));
	return new org.springframework.security.core.userdetails.User
			(username, user.getPassword(), authorities);
}//fim loadUserByUsername
	
}
