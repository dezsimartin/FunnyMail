package hu.flowacademy.FunnyMail.resources;

import hu.flowacademy.FunnyMail.services.UserService;
import hu.flowacademy.FunnyMail.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<UserModel> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserModel findOne(@PathVariable UUID id) {
        return userService.findOne(id);
    }

    @PostMapping("/")
    public UserModel save(@RequestBody UserModel userModel) {
        return userService.save(userModel);
    }

    @PutMapping("/")
    public UserModel update(@RequestBody UserModel userModel) {
        return userService.update(userModel);
    }

    @DeleteMapping("/{id}")
    public UserModel delete(@PathVariable UUID id) { return userService.delete(id); }
}
