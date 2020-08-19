package com.dfwcomputech.scrap.persistence.domain;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="USERS")
@Data
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@AllArgsConstructor
public class User  implements UserDetails {

	private static final long serialVersionUID = 8651611965921191627L;
	@Id
	@GeneratedValue(generator = "USERS_ID_GENERATOR")
	@SequenceGenerator(name = "USERS_ID_GENERATOR", sequenceName = "USERS_SEQUENCE",allocationSize=1)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "EMAIL")
	@NotNull
	private String email;
	
	@Column(name = "PASSWORD")
	@NotNull
	private String password;
	
	@Column(name="enabled")
	@NotNull
	private Boolean enabled;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
	
	@Override
	public String getUsername() {
		return this.email;
	}
	
	@Override
	public boolean isEnabled() {
		return enabled;
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
}
