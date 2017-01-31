package com.sawa.domain;

import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Long id;

	@NotNull
	@Size(min = 4, max = 30)
	@Setter
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")
	private String username;

	@NotNull
	private String password;

	@NotNull
	@Size(min = 4, max = 30)
	@Getter
	@Setter
	private String name;

	private Collection<? extends GrantedAuthority> roles;

	public User(String username, String password, String... roles) {
	        this.username = username;
	        this.password = password;
	        this.roles = AuthorityUtils.createAuthorityList(roles);
	}
	
	public User(String username, String password, List<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = AuthorityUtils.createAuthorityList(roles.toArray(new String[roles.size()]));
    }


	public User() {
		
	}

	@Override
	@JsonProperty("email")
	public String getUsername() {
		return username;
	}

	@Override
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		return true;
	}
}
