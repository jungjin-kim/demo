package com.mvc.upgrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.upgrade.model.biz.MYBoardBiz;
import com.mvc.upgrade.model.dto.MYBoardDto;

@Controller
public class MYBoardController {

	@Autowired
	private MYBoardBiz biz;
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "myboardlist";
	}
	@RequestMapping("/select.do")
	public String selectOne(Model model, int myno) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		// return 에 들어가는건 .jsp라고 생각하면 된다!
		// 경로는 이미 다 잡혀있어서...
		return "myboardselect";
	}
	@RequestMapping("/insertform.do")
	public String insertForm() {
		return "myboardinsert";
	}
	@RequestMapping("/insertres.do")
	// MYBoardDto dto 이거로 쓰면 이름, 제목, 내용 받아서 넣어줄꺼야 -> command object라고 한다.
	public String insertRes(MYBoardDto dto) {
		
		if (biz.insert(dto) > 0) {
			// 직접 list.do로 보낸다.
			// redirect: 를 안써주면 view에서 찾게 된다.
			return "redirect:list.do";
		}
		return "redirect:insertform.do";
	}
	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int myno) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "myboardupdate";
	}
	@RequestMapping("/updateres.do")
	public String updateRes(MYBoardDto dto) {
		
		if (biz.update(dto) > 0) {
			return "redirect:select.do?myno="+dto.getMyno();
		}
		
		return "redirect:updateform.do?myno="+dto.getMyno();
	}
	@RequestMapping("/delete.do")
	public String delete(int myno) {
		
		if(biz.delete(myno) > 0) {
			return "redirect:list.do";
		}
		return "redirect:select.do?myno=" + myno;
	}
}
