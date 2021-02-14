//$Id$
package entity;

import valueobjects.Role;

import java.util.Objects;

public class User {
	 private String name;
	 
	    private Role role;

	    public User(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }

	    public Role getRole() {
	        return role;
	    }

	    public void setRole(Role role) {
	        this.role = role;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof User)) return false;
	        User user = (User) o;
	        return Objects.equals(name, user.name);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(name);
	    }
}
