package com.vam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.BoardMapper;
import com.vam.model.BoardVO;
import com.vam.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;

	@Override
	public void enroll(BoardVO board) {
		// TODO Auto-generated method stub
		mapper.enroll(board);
	}

	/* 게시판 목록 */
	@Override
    public List<BoardVO> getList() {
        
        return mapper.getList();
    }

	/* 게시판 조회 */
    @Override
    public BoardVO getPage(int bno) {
         
        return mapper.getPage(bno);
    }

	@Override
	public int modify(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.modify(board);
	}

	/* 게시판 삭제 */
	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno);
	} 
	
	/* 게시판 목록(페이징 적용) */
    @Override
    public List<BoardVO> getListPaging(Criteria cri) {
        
        return mapper.getListPaging(cri);
    }  
    
}
