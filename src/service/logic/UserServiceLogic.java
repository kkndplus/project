package service.logic;

import domain.User;
import service.UserService;
import store.UserStore;
import store.logic.UserStoreLogic;

public class UserServiceLogic implements UserService {

	private UserStore store;
	
	public UserServiceLogic(){
		store = new UserStoreLogic();
	}

	public User login(User user) {
		//
		User readedUser = null;
		if (validate(user)) {
			readedUser = store.read(user.getLoginId());
		}
		return readedUser;
	}

	@Override
	public boolean register(User user) {
		//
		if (!validate(user)) {
			return false;
		} else if (store.read(user.getLoginId()) != null) {
			return false;
		}
		return store.create(user);
	}

	@Override
	public User find(String loginId) {
		//
		return store.read(loginId);
	}

	private boolean validate(User user) {
		//
		if (user == null) {
			throw new RuntimeException("사용자 정보가 없습니다.");
		} else if (user.getLoginId() == null || user.getLoginId().isEmpty()) {
			throw new RuntimeException("ID가 없습니다.");
		} else if (user.getPassword() == null || user.getPassword().isEmpty()) {
			throw new RuntimeException("비밀번호가 없습니다.");
		}
		return true;
	}

}
