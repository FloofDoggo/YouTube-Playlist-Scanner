package io.floofdoggo.youtubeplaylistscanner.sevice;

import io.floofdoggo.youtubeplaylistscanner.DAO.UserRepository;
import io.floofdoggo.youtubeplaylistscanner.DAO.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void saveUser(UserEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public UserEntity findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
