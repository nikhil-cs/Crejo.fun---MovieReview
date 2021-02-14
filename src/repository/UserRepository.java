//$Id$
package repository;

import entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

	private Map<String, User> userMap;

    public UserRepository() {
        this.userMap = new HashMap<>();
    }

    public void addUser(User user) {
        userMap.put(user.getName(), user);
    }

    public User getUser(String name) {
        return userMap.get(name);
    }

    public void updateUser(User user) {
        userMap.put(user.getName(), user);
    }
}
