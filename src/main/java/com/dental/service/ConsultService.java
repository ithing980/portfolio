package com.dental.service;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dental.mapper.ConsultMapper;
import com.dental.vo.CommentReqVO;
import com.dental.vo.CommentVO;
import com.dental.vo.ConsultVO;
import com.dental.vo.PostRegistVO;

@Service
public class ConsultService {
	@Autowired
	ConsultMapper mapper;

	public List<ConsultVO> getPostList(Integer offset, Integer board){
		List<ConsultVO> postList=mapper.getPostList(offset,board);
		postList.forEach(post -> {
			Integer seq = post.getDhc_seq();
            CommentReqVO vo = new CommentReqVO();
            vo.setBoard_seq(seq);
            Integer commentCnt = mapper.selectCommentCount(vo);
            if(commentCnt > 0) {
                post.setDhc_title(post.getDhc_title()+" ("+commentCnt+")");
            }
		});		
		
		Integer total = this.getBoardPostCount(board,"%%",null);
        for(int i=0; i<postList.size(); i++) {
        	postList.get(i).setNo(total-i-offset);
        }
		
		return postList; 
	}
	
	public ConsultVO getPostBySeq(Integer no) {
		return mapper.getPostBySeq(no);
	}
	
	public List<ConsultVO> selectPostByUserId(Integer user_seq){
		return mapper.selectPostByUserId(user_seq);
	}
	
	public void insertPost(PostRegistVO vo) {
		mapper.insertPost(vo);
	}
	
	public void deletePost(Integer seq) {
		mapper.deletePost(seq);
	}
	
	public void updatePost(ConsultVO vo) {
		mapper.updatePost(vo);
	}
	
	public void updatePostCount(Integer seq) {
        mapper.updatePostCount(seq);
    }
	
	public void insertComment(CommentVO vo) {
		mapper.insertComment(vo);
	}
	
	public List<CommentVO> selectComment(CommentReqVO vo) {
		return mapper.selectComment(vo);
	}
	
	public Integer selectCommentCount(CommentReqVO vo) {
		return mapper.selectCommentCount(vo);
	}
	
	public void deleteComment(Integer seq) {
		mapper.deleteComment(seq);
	}
	
	 public Integer getBoardPostCount(Integer board_seq,String keyword,String type) {
	     return mapper.getBoardPostCount(board_seq,keyword,type);
	    } 
}
