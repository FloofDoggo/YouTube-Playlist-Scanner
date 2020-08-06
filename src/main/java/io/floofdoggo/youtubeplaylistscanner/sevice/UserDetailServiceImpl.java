package io.floofdoggo.youtubeplaylistscanner.sevice;

import io.floofdoggo.youtubeplaylistscanner.DAO.UserDetailsImpl;
import io.floofdoggo.youtubeplaylistscanner.DAO.UserRepository;
import io.floofdoggo.youtubeplaylistscanner.DAO.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(s);
        if (userEntity == null) throw new UsernameNotFoundException("Bad credentials");
        return new UserDetailsImpl(userEntity.getUsername(), userEntity.getPassword());
    }

    public UserEntity saveUser(UserEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(1);
        return userRepository.save(user);
    }

    public UserEntity findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
