package menu.dao;

import java.util.List;

import menu.entity.Menu;

public interface MenuDao {
	//
	void create(Menu menu);
	Menu retrieve(String id);
	List<Menu> retrieveAllMenus();
}
