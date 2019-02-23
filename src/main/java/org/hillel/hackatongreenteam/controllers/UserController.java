package garbage.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @GetMapping("{id}")
    public User getOne(@PathVariable("id") User user) {
        return user;
    }


    @PostMapping
    public User create(@RequestBody User user) {
        //article.setCreationDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    @PutMapping("{id}")
    public User update(@PathVariable ("id") User userFromDB,
                          @RequestBody User user) {
        BeanUtils.copyProperties(user, userFromDB, "id");
        return userRepository.save(userFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable ("id") User user) {
        userRepository.delete(user);
    }
}
