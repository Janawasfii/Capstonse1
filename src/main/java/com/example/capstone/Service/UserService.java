package com.example.capstone.Service;


import com.example.capstone.Model.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Service
//@RequiredArgsConstructor
public class UserService {




    ArrayList<User> users = new ArrayList<User>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUsers(User user) {
        users.add(user);
    }

    public boolean updateUser(String userID, User user) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(userID)){
                users.set(i, user);
                return true;}}
                return false;}

    public boolean deleteUser(String userID) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(userID)){
                users.remove(i);
                return true;}}
            return false;}

























}





