package org.example.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.Repository.UserRepository;
import org.example.entity.Userinfo;
import org.example.model.UserInfoDto;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

@Component
@AllArgsConstructor
@Data
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername (String username) throws  UsernameNotFoundException{
        Userinfo user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Cannot find user" + username);
        }

        return new CustomUserDetails(user);
    }

    public Userinfo checkIfUserAlreadyExists(UserInfoDto userInfoDto) {
        return userRepository.findByUsername(userInfoDto.getUsername());
    }

    public Boolean signupUser (UserInfoDto userInfoDto) {
        userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));
        if (Objects.nonNull(checkIfUserAlreadyExists(userInfoDto))) {
            return false;
        }
        String userId = UUID.randomUUID().toString();
        userRepository.save(new Userinfo(userId , userInfoDto.getUsername() , userInfoDto.getPassword() , new HashSet<>()));
        return true;
    }
}
