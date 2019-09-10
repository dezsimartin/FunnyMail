package hu.flowacademy.FunnyMail.repositories;

import hu.flowacademy.FunnyMail.models.UserModel;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {

    List<UserModel> users = new ArrayList<>();

    public List<UserModel> findAll(){
        return users;
    }

    public UserModel findOne(UUID id){
        return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    public UserModel save(UserModel user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
            users.add(user);
        } else{
            for (int i = 0; i < users.size(); i++) {
                if(users.get(i).getId() == user.getId()){
                    users.get(i).setName(user.getName());
                    users.get(i).setPassword(user.getPassword());
                    users.get(i).setUsername(user.getUsername());
                    users.get(i).setBirthDate(user.getBirthDate());
                }
            }
        }
        return user;
    }

    public void delete(UUID id){
        users.stream().filter(u -> u.getId().equals(id)).findFirst().get().setDeletedAt(LocalDate.now());
    }


}
