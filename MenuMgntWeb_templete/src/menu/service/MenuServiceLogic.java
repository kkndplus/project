package menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import menu.dao.MenuDao;
import menu.entity.Menu;

@Service
public class MenuServiceLogic implements MenuService{
	
	@Autowired
	private MenuDao menuDao;
	
	@Override
	public void create(Menu menu) {
		menuDao.create(menu);
	}
	@Override
	public Menu findMenu(String id) {
		return menuDao.retrieve(id);
	}
	@Override
	public List<Menu> findAllMenus() {
		return menuDao.retrieveAllMenus();
	}
	
}
