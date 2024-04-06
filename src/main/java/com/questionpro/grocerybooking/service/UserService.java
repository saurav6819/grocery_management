package com.questionpro.grocerybooking.service;

import com.questionpro.grocerybooking.model.db.User;
import com.questionpro.grocerybooking.model.db.UserOrders;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);
    Optional<User> getUserById(long userId);
    List<User> getAllUser();
    void deleteUser(long userId);

//    UserOrders getUsersOrderByUserId();
}
