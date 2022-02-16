package br.com.senai.semana10.salesapi.api;

import br.com.senai.semana10.salesapi.model.User.User;
import br.com.senai.semana10.salesapi.parameter.UserPostParameter;
import br.com.senai.semana10.salesapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CrudUserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> get(@RequestParam(required = false) String nome) {

        return repository.findByNameLike(nome);
    }

    @GetMapping("/{userId}")
    public User getById(@PathVariable Integer userId) {
        return repository.findById(userId);
    }

    @PutMapping("/{userId}")
    public Integer put(@PathVariable Integer userId,
                       @RequestBody UserPostParameter userPostParameter) {
        return repository.update(userId, userPostParameter);
    }

    @PatchMapping("/{userId}")
    public Integer patch(@PathVariable Integer userId,
                         @RequestBody UserPostParameter userPostParameter) {
        return repository.updateDoPatch(userId, userPostParameter);
    }

    @PatchMapping("/{userId}/password")
    public Integer patchPassword(@PathVariable Integer userId,
                                 @RequestBody String password) {
        return repository.updatePassword(userId, password);
    }

    @PostMapping
    public Integer post(@RequestBody UserPostParameter userPostParameter) {
        return repository.insert(userPostParameter);
    }

}
