package menu.service;

import java.util.List;

import menu.entity.Menu;

public interface MenuService {
	//
	void create(Menu menu);
	Menu findMenu(String id);
	List<Menu> findAllMenus();
}
