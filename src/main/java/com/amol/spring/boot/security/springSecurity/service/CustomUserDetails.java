package com.amol.spring.boot.security.springSecurity.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.amol.spring.boot.security.springSecurity.model.User;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CustomUserDetails extends User implements UserDetails{

	private static final long serialVersionUID = 8025167813775830139L;
	
	public CustomUserDetails(final User users) {
        super(users);
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
                .collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
