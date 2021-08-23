package mainApp.services;


import mainApp.entities.User;
import mainApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public User read(Long id){
        return userRepository.findById(id).get();
    }

    public Iterable<User> readAll() {
        return userRepository.findAll();
    }
public User update(Long id,User newData){
        User user =read(id);
        user.setFirstName(newData.getFirstName());
        user.setLastName(newData.getLastName());
        userRepository.save(newData);
        return newData;
    }
    public User delete(User user) {
        userRepository.delete(user);
        return user;
    }

    public User delete(Long id){

       return delete(read(id));
    }
}
