package com.test.microservices.customers.service.impl;

import com.test.microservices.customers.exception.UserNotFoundException;

import com.test.microservices.customers.model.User;
import com.test.microservices.customers.repository.UserRepository;
import com.test.microservices.customers.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * Implement UserService
 * @author Angel
 * @since 1.0.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private static final Log log = LogFactory.getLog(UserServiceImpl.class);
	
	private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public User findByUserId(String userId) {
        Optional<User> user = userRepository.findOne(userId);
        if (user.isPresent()) {
            log.debug(String.format("Read userId '{}'", userId));
            return user.get();
        }else
            throw new UserNotFoundException(userId);
    }

   
    public List<User> findAll() {
        Optional<List<User>> user = userRepository.findAll();
        return user.get();      
    }
    
   
    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

 
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    
    public void deleteUser(String userId) {
        userRepository.deleteUser(userId);
    }

}
