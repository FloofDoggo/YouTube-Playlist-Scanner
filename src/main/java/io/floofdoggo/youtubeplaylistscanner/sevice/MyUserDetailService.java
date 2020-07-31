package io.floofdoggo.youtubeplaylistscanner.sevice;

import io.floofdoggo.youtubeplaylistscanner.DAO.MyUserDetails;
import io.floofdoggo.youtubeplaylistscanner.DAO.UserRepository;
import io.floofdoggo.youtubeplaylistscanner.DAO.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = accountService.findUserByUsername(s);
        return new MyUserDetails(userEntity.getUsername(), userEntity.getPassword());
    }
}
