package controller;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import exception.BoardException;
import logic.Board;
import logic.DevService;


@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	DevService service;
	
	@GetMapping("*")
	public ModelAndView getBoard(Integer no,Integer bno,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Board board = null;
		if(bno == null) {
			board = new Board();
		}else {
			boolean readcntable = false;
			if(request.getRequestURI().contains("detail.dev"))
				readcntable = true;
			//board: 파라미터 num에 해당하는 게시물 정보 저장
			board = service.getBoard(no,bno,readcntable );
		}
		mav.addObject("board", board);
		return mav;
	}
	

	
	/*
	 * pageNum: 현재 페이지 번호
	 * maxpage: 최대 페이지
	 * startpage: 보여지는 시작 페이지
	 * endpage: 보여지는 끝 페이지
	 * listcount: 전체 등록된 게시물 건수
	 * boardlist: 화면에 보여질 게시물 객체들
	 * boardno: 화면에 보여지는 게시물 번호
	 */
	@RequestMapping("list")
	public ModelAndView list(Integer pageNum,String searchtype, String searchcontent) {
		ModelAndView mav = new ModelAndView();
		if(pageNum == null || pageNum.toString().equals("")) {
			pageNum =1;
		}
		if(searchtype == null 
			|| searchtype.trim().equals("")
			|| searchcontent == null
			|| searchcontent.trim().equals("")) {//column값이 없음
			searchtype = null;
			searchcontent = null;
		}
		System.out.println(searchtype +" , "+searchcontent);
		int limit = 10;// 한페이지에 출력할 게시물 건수
		int listcount = service.boardCount(searchtype,searchcontent);	//등록 게시물 건수
		List<Board> boardlist = service.boardlist(pageNum, limit, searchtype,searchcontent);
		int maxpage = (int) ((double) listcount / limit + 0.95);
		int startpage = ((int) (pageNum / 10.0 + 0.9) - 1) * 10 + 1;// 시작페이지번호
		int endpage = startpage + 9;// 종료페이지 번호
		if(endpage > maxpage) endpage = maxpage;
		int boardno = listcount - (pageNum -1) * limit;

		mav.addObject("pageNum", pageNum);
		mav.addObject("maxpage", maxpage);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("listcount", listcount);
		mav.addObject("boardlist", boardlist);
		mav.addObject("boardno", boardno);
		mav.addObject("today",	//"20200713"
				new SimpleDateFormat("yyyyMMdd").format(new Date()));
		return mav;
	}
	


	@PostMapping("write")
	public ModelAndView write( Board board, BindingResult bresult,
			HttpServletRequest request) {
		System.out.println(request.getParameter("bno"));
		ModelAndView mav = new ModelAndView();
		if(bresult.hasErrors()) {
			mav.getModel().putAll(bresult.getModel());
			return mav;
		}
		try {
			
			board.setNo(Integer.parseInt(request.getParameter("no")));
			service.boardWrite(board,request);
			mav.setViewName("redirect:list.dev");
		}catch(Exception e){
			e.printStackTrace();
			throw new BoardException
			("게시물 등록에 실패했습니다.", "write.dev");
		}		
		return mav;
	}


	

}























