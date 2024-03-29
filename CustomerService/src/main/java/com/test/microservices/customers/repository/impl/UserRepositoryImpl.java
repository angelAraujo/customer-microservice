package com.test.microservices.customers.repository.impl;

import com.test.microservices.customers.repository.UserRepository;
import com.test.microservices.customers.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @author Angel
 */
@Repository
public class UserRepositoryImpl implements UserRepository{

    private final MongoOperations mongoOperations;

    @Autowired
    public UserRepositoryImpl(MongoOperations mongoOperations) {
        Assert.notNull(mongoOperations);
        this.mongoOperations = mongoOperations;
    }
    
    //Find all users
    public Optional<List<User>> findAll() {
    	List<User> users = this.mongoOperations.find(new Query(), User.class);
        Optional<List<User>> optionalUsers = Optional.ofNullable(users);
        return optionalUsers;
	}    

    public Optional<User> findOne(String userId) {
        User d = this.mongoOperations.findOne(new Query(Criteria.where("userId").is(userId)), User.class);
        Optional<User> user = Optional.ofNullable(d);
        return user;
    }

    public User saveUser(User user) {
        this.mongoOperations.save(user);
        return findOne(user.getUserId()).get();
    }
    
    public void updateUser(User user) {
        this.mongoOperations.save(user);
    }

    public void deleteUser(String userId) {
        this.mongoOperations.findAndRemove(new Query(Criteria.where("userId").is(userId)), User.class);
    }
}
