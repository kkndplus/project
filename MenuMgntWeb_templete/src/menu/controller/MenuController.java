package menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import menu.entity.Menu;
import menu.service.MenuService;

@Controller
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/menu/create.do")
	public String create(Menu menu){
		menuService.create(menu);
		return "redirect:/menu/list.do";
	}
	
	@RequestMapping("/menu/list.do")
	public String list(Model model){
		List<Menu> list = menuService.findAllMenus();
		model.addAttribute("allMenus", list);
		return "/views/menuList.jsp";
	}
}
