package hu.flowacademy.FunnyMail.services;

import hu.flowacademy.FunnyMail.exceptions.EntityNotFoundAdvice;
import hu.flowacademy.FunnyMail.exceptions.EntityNotFoundException;
import hu.flowacademy.FunnyMail.models.UserModel;
import hu.flowacademy.FunnyMail.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll(){ return userRepository.findAll().stream().filter(u -> u.getDeletedAt() == null).collect(Collectors.toList()); }

    public UserModel findOne(UUID id) {
        if (id == null) {
            throw new EntityNotFoundException("Nincs megadva ID!");
        }
        return userRepository.findOne(id).getDeletedAt() == null ? userRepository.findOne(id) : null;
    }

    public UserModel save(UserModel userModel) {
        if(userModel.getId() != null || userModel.getName() == null || userModel.getName().equals("") || userModel.getUsername() == null || userModel.getUsername().equals("")
        || userModel.getPassword() == null || userModel.getPassword().equals("") || userModel.getBirthDate() == null) {
            throw new EntityNotFoundException("Nem lehet null/üres érték az username, name, password, birthday, és az ID-nek nem lehet értéke.");

        }
        userRepository.save(userModel);
        return userModel;
    }

    public UserModel update(UserModel userModel) {
        if (userModel.getName() == null || userModel.getName().equals("") || userModel.getUsername() == null || userModel.getUsername().equals("")
                || userModel.getPassword() == null || userModel.getPassword().equals("") || userModel.getBirthDate() == null || userModel.getDeletedAt() != null) {
            throw new EntityNotFoundException("Nem lehet null érték az username, name, password, birthday és nem lehet törölt usert lekérni.");
        }
        if (userModel.getId() == null) {
            return save(userModel);
        }
        return userRepository.save(userModel);
    }

    public UserModel delete(UUID id){
        if(id == null){
            throw new EntityNotFoundException("Hibás id");
        }
        userRepository.delete(id);
        return userRepository.findOne(id);
    }


}
