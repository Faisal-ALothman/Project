package com.example.amazon;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UserService {
    private ArrayList<User> usersList=new ArrayList<>();

    public ArrayList<User> getUsers(){
        return usersList;
    }

    public void addUser(User myUser){
        usersList.add(myUser);
    }

    public void updateUser(int index, User myUser) {
        usersList.set(index,myUser);
    }

    public void deleteUser(int index) {
        usersList.remove(index);
    }

    public boolean login(User loginForm) {
        for (int i = 0; i < usersList.size(); i++) {
            User User=usersList.get(i);
            if(User.getUserName().equals(loginForm.getUserName())&&
                    User.getPassword().equals(loginForm.getPassword())){
                return true;
            }
        }
        return false;
    }
}
