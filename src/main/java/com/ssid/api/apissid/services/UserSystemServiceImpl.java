package com.ssid.api.apissid.services;
/**
 * @author Borisytu
 */
import com.ssid.api.apissid.domain.UserSystem;
import com.ssid.api.apissid.repositories.UserSystemRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
public class UserSystemServiceImpl implements UserSystemService, UserDetailsService {

    private UserSystemRepository userSystemRepository;


    public UserSystemServiceImpl(UserSystemRepository userSystemRepository) {
        this.userSystemRepository = userSystemRepository;
    }

    @Override
    public List<UserSystem> getAllUsers() {
        return  userSystemRepository.findAll();
    }

    @Override
    public void saveUser(UserSystem user) {
        userSystemRepository.save(user);
    }

    @Override
    public UserSystem findByUserName(String userName) {
        return userSystemRepository.findByUsername(userName);
    }

    @Override
    public Optional<UserSystem> findUserById(Long idUser) {
	return userSystemRepository.findById(idUser);
    }	

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSystem usuario = userSystemRepository.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(usuario.getUsername(), usuario.getPassword(), emptyList());
    }
}
