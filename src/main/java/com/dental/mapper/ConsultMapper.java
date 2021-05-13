package com.dental.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dental.vo.CommentReqVO;
import com.dental.vo.CommentVO;
import com.dental.vo.ConsultVO;
import com.dental.vo.PostRegistVO;

@Mapper
public interface ConsultMapper {
	public List<ConsultVO> getPostList(Integer offset, Integer board);
	public ConsultVO getPostBySeq(Integer no);
	public List<ConsultVO> selectPostByUserId(Integer user_seq);
	
	public void insertPost(PostRegistVO vo);
	public void deletePost(Integer seq);
	public void updatePost(ConsultVO vo);
	public void updatePostCount(Integer seq);
	
	public void insertComment(CommentVO vo);
	public List<CommentVO> selectComment(CommentReqVO vo);
	public Integer selectCommentCount(CommentReqVO vo);
	public void deleteComment(Integer seq);
	
	public Integer getBoardPostCount(Integer board_seq,String keyword,String type);
}
