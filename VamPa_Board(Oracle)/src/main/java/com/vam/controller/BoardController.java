package com.vam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vam.model.BoardVO;
import com.vam.model.Criteria;
import com.vam.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Autowired
    private BoardService bservice;
	
	@GetMapping("/list")
	public void boardListGET(Model model, Criteria cri) {
		log.info("게시판 목록 페이지 진입");
		
		model.addAttribute("list", bservice.getListPaging(cri));
		
//		/WEB-INF/views/list.jsp
	}
	
	@GetMapping("/enroll")
	public void boardEnrollGET() {
		log.info("게시판 등록 페이지 진입");
	}
	
	@GetMapping("/custom")
	public void boardCustomGET() {
		log.info("커스텀 진입");
	
	}
	
	/* 게시판 등록 */
    @PostMapping("/enroll")
    public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {
        System.out.println("타겟");
    	System.out.println(rttr);
        log.info("BoardVO : " + board);
        
        bservice.enroll(board);
        
        rttr.addFlashAttribute("result", "enroll success");
        
        return "redirect:/board/list";
        
    }
    
    
    /* 게시글 상세조회 */
    /* GET요청은 페이지 이동이 거듭되는동안 이전 페이지들의 요청정보를 기억하고있어야한다. */
	/* URL에 파라미터가 누적되어 전달되는데 이런 기법을 URL Rewrite처리라고 한다. */
    @GetMapping("/get")
    public void boardGetPageGET(int bno, Model model) {
        
        model.addAttribute("pageInfo", bservice.getPage(bno));
        
    }
    
    /* 수정 페이지 이동 */
    @GetMapping("/modify")
    public void boardModifyGET(int bno, Model model) {
        
        model.addAttribute("pageInfo", bservice.getPage(bno));
        
    }
    
    /* 글 수정 */
    @PostMapping("/modify")
    public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {
        
        bservice.modify(board);
        
        rttr.addFlashAttribute("result", "modify success");
        
        return "redirect:/board/list";
        
    }
    
    /* 글 삭제 */
    @PostMapping("/delete")
    public String boardDeletePOST(int bno, RedirectAttributes rttr) {
        
        bservice.delete(bno);
        
        rttr.addFlashAttribute("result", "delete success");
        
        return "redirect:/board/list";
        
    }
    
}
