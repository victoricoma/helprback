package com.api.helprback.services;

import com.api.helprback.domain.Pessoa;
import com.api.helprback.repositories.PessoaRepository;
import com.api.helprback.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PessoaRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Pessoa> user = repository.findByEmail(email);
        if (user.isPresent()) {
            return new UserSS(user.get().getId(),
                    user.get().getEmail(),
                    user.get().getSenha(),
                    user.get().getPerfis()
            );
        }
        throw new UsernameNotFoundException(email);
         }
}
