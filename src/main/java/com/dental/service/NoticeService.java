package com.dental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.dental.mapper.NoticeMapper;
import com.dental.vo.CategoryVO;
import com.dental.vo.NoticeVO;
import com.dental.vo.PostRegistVO;

@Service
@Configurable
public class NoticeService {
	@Autowired
	NoticeMapper mapper;
	
	public List<CategoryVO> getCategoryList() {
		return mapper.getCategoryList();
	}
	
	public List<NoticeVO> getPostList(Integer offset, Integer board , String keyword, String type ){
		List<NoticeVO> postList=mapper.getPostList(offset,board,keyword,type);
		postList.forEach(post -> {
			Integer seq=post.getDhn_seq();
		});
		
		
		 Integer total = this.getBoardPostCount(board); 
		 for(int i=0; i<postList.size(); i++) { 
			 postList.get(i).setNo(total-i-offset); 
		 }
		 
        
		return postList; 
	}
	
	public NoticeVO getPostBySeq(Integer no) {
		return mapper.getPostBySeq(no);
	}
	
	public Integer getBoardPostCount(Integer board_seq) {
		return mapper.getBoardPostCount(board_seq);
	}
	
	public List<NoticeVO> selectPostByUserId(Integer user_seq){
		return mapper.selectPostByUserId(user_seq);
	}
	
	public void insertPost(PostRegistVO vo) {
		mapper.insertPost(vo);
	}
	
	public void updatePost(NoticeVO vo) {
		mapper.updatePost(vo);
	}
	
	public void deletePost(Integer seq) {
		mapper.deletePost(seq);
	}
	
    public void updatePostCount(Integer seq) {
        mapper.updatePostCount(seq);
    }
}
