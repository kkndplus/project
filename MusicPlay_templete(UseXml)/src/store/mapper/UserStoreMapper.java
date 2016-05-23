package store.mapper;

import domain.User;

public interface UserStoreMapper {
	
	void create(User user);
	User read(String id);
}
