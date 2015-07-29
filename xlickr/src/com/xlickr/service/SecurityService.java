package com.xlickr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vamsee.user.authentication.soap.UserSecurityEJBBeanService;
import com.vamsee.user.authentication.soap.UserSecurityEJBBeanService_Service;
import com.vamsee.user.authentication.soap.generated.FlickrUser;

@Service
public class SecurityService implements UserDetailsService {

	private static UserSecurityEJBBeanService_Service service = new UserSecurityEJBBeanService_Service();
	private UserSecurityEJBBeanService securityFromSAOP = service.getUserSecurityEJBBeanServiceSoap12HttpPort();
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		
		// call you webservice to get user details and user roles 
		
		FlickrUser soapUser = securityFromSAOP.getFlickrUserFindByUserName(username);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		/*
		 * List<Roles> roles = user.getRoles();
		 * 
		 * for(Role r:roles){
		 * authorities.add(new SimpleGrantedAuthority(r.getName()));
		 * 
		 * }
		 * 
		 */
		
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		//new User(username, password, authorities);
		
		User u = new User(username, soapUser.getUserPassword(),true, true, true, true, authorities);
		
		return u;
	}

}
