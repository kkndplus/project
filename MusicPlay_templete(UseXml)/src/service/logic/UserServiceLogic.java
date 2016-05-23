package service.logic;

import domain.User;
import service.UserService;
import store.UserStore;
import store.logic.UserStoreLogic;

public class UserServiceLogic implements UserService {

	private UserStore userStore;

	public UserServiceLogic() {
		userStore = new UserStoreLogic();
	}

	@Override
	public User login(User user) {
		// 유저 로그인
		User user1 = userStore.read(user.getLoginId());
		if (user1 == null) {
			throw new RuntimeException("가입이 되어있지 않습니다.");
		}
		if (user1.getLoginId().equals(user.getLoginId())) {

			if (user1.getPassword().equals(user.getPassword())) {
				return user1;
			}
			throw new RuntimeException("비밀번호가 맞지 않습니다.");
		}
		return null;
	}

	@Override
	public boolean register(User user) {
		// 유저 등록
		User user1 = userStore.read(user.getLoginId());
		if (user1 == null) {
			userStore.create(user);
			return true;
		}
		return false;
	}

	@Override
	public User find(String loginId) {
		// 유저 찾기
		return userStore.read(loginId);
	}

}
