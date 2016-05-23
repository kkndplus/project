package store;

import domain.User;

public interface UserStore {
	//
	void create(User user);
	User read(String id);
}
