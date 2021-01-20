package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping(value="/guestbook")
public class GuestController{

	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model){   
		System.out.println("list");
		
		GuestDao guestDao = new GuestDao();
		List<GuestVo> guestList = guestDao.ListAllGuest(); 
		System.out.println(guestList.toString());
		//model에 담아 보내기
		model.addAttribute("gList", guestList);
		
		/* 포워드 */		
		return "guestList";
	}
	
	// @ModelAttribute
	@RequestMapping(value="/insert", method= {RequestMethod.GET, RequestMethod.POST})
	public String insert(@ModelAttribute GuestVo guestVo){
		System.out.println("insert");

		System.out.println(guestVo.toString());
		GuestDao guestDao = new GuestDao();
		
		/* insert 저장 */
		guestDao.guestInsert(guestVo);
		
		/* 리다이렉트 */		
		return "redirect:/guestbook/list";
	}
	
	// @RequestParam
	@RequestMapping(value="/insert2", method= {RequestMethod.GET, RequestMethod.POST})
	public String insert2(@RequestParam("name")String name, @RequestParam("password")String password, @RequestParam("content")String content){
		System.out.println("insert2");

		System.out.println(name + "," + password + "," + content);
		
		GuestVo guestVo= new GuestVo(name, password, content);
		System.out.println(guestVo.toString());
		GuestDao guestDao = new GuestDao();
		
		/* insert 저장 */
		guestDao.guestInsert(guestVo);
		
		/* 리다이렉트 */		
		return "redirect:/guestbook/list";
	}
		
	@RequestMapping(value="/deleteForm",method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		System.out.println("deleteForm");
	
		/* 포워드 */
		return "deleteForm";
	}
	
	//@PathVariable
	
	// @ModelAttribute
	@RequestMapping(value="/delete",method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestVo guestVo, Model model) {
		System.out.println("delete");
		
		System.out.println(guestVo.toString());
		
		GuestDao guestDao = new GuestDao();
		int count = guestDao.guestDelete(guestVo);
		
		if(count == 1) {
			//성공 /* redirect */
			return"redirect:/guestbook/list";
		} else {
			
			model.addAttribute("result", count);
			//실패 /* 포워드 */
			return "deleteForm";
		}
	}
	
	// @RequestParam
	@RequestMapping(value="/delete2",method= {RequestMethod.GET, RequestMethod.POST})
	public String delete2(@RequestParam("no")int no, @RequestParam("password")String password, Model model) {
		System.out.println("delete2");
		
		GuestVo guestVo = new GuestVo(no,password);
		
		System.out.println(guestVo.toString());
		
		GuestDao guestDao = new GuestDao();
		int count = guestDao.guestDelete(guestVo);
		
		if(count == 1) {
			//성공 /* redirect */
			return"redirect:/guestbook/list";
		} else {
			
			model.addAttribute("result", count);
			//실패 /* 포워드 */
			return "deleteForm";
		}

	}
	
}
