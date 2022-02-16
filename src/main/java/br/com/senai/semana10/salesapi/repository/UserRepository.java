package br.com.senai.semana10.salesapi.repository;

import br.com.senai.semana10.salesapi.model.User.User;
import br.com.senai.semana10.salesapi.parameter.UserPostParameter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private Integer lastId = 0;
    private List<User> repository = new ArrayList<>();

    public Integer insert(UserPostParameter userPostParameter) {
        User user = new User(lastId, userPostParameter);
        repository.add(user);
        lastId++;
        return user.getId();
    }

    public List<User> findAll() {
        return repository;
    }

    public List<User> findByNameLike(String nome) {
        if (nome == null) {
            return repository;
        }
        List<User> retorno = new ArrayList<>();
        for (User user : repository) {
            if (user.getNome().contains(nome))
                retorno.add(user);
        }
        return retorno;
    }

    public User findById(Integer userId) {
        for (User user : repository) {
            if (user.getId() == userId)
                return user;
        }
        return null;
    }

    public Integer update(Integer userId,
                          UserPostParameter userPostParameter) {
        User user = findById(userId);
        if (user == null)
            return null;

        user.setEmail(userPostParameter.getEmail());
        user.setNome(userPostParameter.getNome());
        user.setSenha(userPostParameter.getSenha());
        user.setIdade(userPostParameter.getIdade());
        return userId;
    }

    public Integer updateDoPatch(Integer userId,
                                 UserPostParameter userPostParameter) {
        User user = findById(userId);
        if (user == null)
            return null;

        if (userPostParameter.getEmail() != null)
            user.setEmail(userPostParameter.getEmail());
        if (userPostParameter.getNome() != null)
            user.setNome(userPostParameter.getNome());
        if (userPostParameter.getSenha() != null)
            user.setSenha(userPostParameter.getSenha());
        if (userPostParameter.getIdade() != null)
            user.setIdade(userPostParameter.getIdade());
        return userId;
    }

    public Integer updatePassword(Integer userId, String password) {
        User user = findById(userId);
        if (user == null)
            return null;

        user.setSenha(password);

        return userId;
    }
}
