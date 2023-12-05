package com.example.demoshoppingcart.Service;

import com.example.demoshoppingcart.Entity.UserEntity;
import com.example.demoshoppingcart.Responsitory.UserResponsitory;

import com.example.demoshoppingcart.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserResponsitory userResponsitory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userResponsitory.findByUsername(username).orElseThrow(() -> new BadCredentialsException("Khong tim thay user"));

        UserPrincipal principal = new UserPrincipal();
        principal.setId(userEntity.getId());
        principal.setUsername(username);
        principal.setPassword(userEntity.getPassword());
        principal.setAuthorities(List.of(new SimpleGrantedAuthority(userEntity.getRole())));

        return principal;

    }
}
