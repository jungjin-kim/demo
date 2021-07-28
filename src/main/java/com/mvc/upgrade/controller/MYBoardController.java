package com.mvc.upgrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.upgrade.model.biz.MYBoardBiz;
import com.mvc.upgrade.model.dto.MYBoardDto;

@Controller
public class MYBoardController {

	// test!!!!
	
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
		
		// return �뿉 �뱾�뼱媛��뒗嫄� .jsp�씪怨� �깮媛곹븯硫� �맂�떎!
		// 寃쎈줈�뒗 �씠誘� �떎 �옟���엳�뼱�꽌...
		return "myboardselect";
	}
	@RequestMapping("/insertform.do")
	public String insertForm() {
		return "myboardinsert";
	}
	@RequestMapping("/insertres.do")
	// MYBoardDto dto �씠嫄곕줈 �벐硫� �씠由�, �젣紐�, �궡�슜 諛쏆븘�꽌 �꽔�뼱以꾧볼�빞 -> command object�씪怨� �븳�떎.
	public String insertRes(MYBoardDto dto) {
		
		if (biz.insert(dto) > 0) {
			// 吏곸젒 list.do濡� 蹂대궦�떎.
			// redirect: 瑜� �븞�뜥二쇰㈃ view�뿉�꽌 李얘쾶 �맂�떎.
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
