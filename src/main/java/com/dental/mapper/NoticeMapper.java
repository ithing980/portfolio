package com.dental.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dental.vo.CategoryVO;
import com.dental.vo.NoticeVO;
import com.dental.vo.PostRegistVO;

@Mapper
public interface NoticeMapper {
	public List<CategoryVO> getCategoryList();

	public List<NoticeVO> getPostList(Integer offset, Integer board ,String keyword, String type );
	public NoticeVO getPostBySeq(Integer no);
	public Integer getBoardPostCount(Integer board_seq);
	public List<NoticeVO> selectPostByUserId(Integer user_seq);
	
	public void insertPost(PostRegistVO vo);
	public void updatePost(NoticeVO vo);
	public void deletePost(Integer seq);
	public void updatePostCount(Integer seq);
	
	










}
