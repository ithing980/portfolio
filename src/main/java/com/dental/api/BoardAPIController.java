package com.dental.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dental.service.ConsultService;
import com.dental.service.NoticeService;
import com.dental.vo.CategoryVO;
import com.dental.vo.CommentReqVO;
import com.dental.vo.CommentVO;
import com.dental.vo.ConsultVO;
import com.dental.vo.NoticeVO;
import com.dental.vo.PostRegistVO;

@RestController
public class BoardAPIController {
	@Autowired
	NoticeService service;
	@Autowired
	ConsultService cService;

	@GetMapping("/api/category")
	public List<CategoryVO> getCategory() {
		return service.getCategoryList();
	}

	@PostMapping("/api/write")
	public Map<String, String> postWrite(@RequestBody PostRegistVO vo) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		service.insertPost(vo);
		map.put("result", "success");
		return map;
	}

	@PostMapping("/api/consult")
	public Map<String, String> postWriteConsult(@RequestBody PostRegistVO vo) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		cService.insertPost(vo);
		map.put("result", "success");
		return map;
	}

	@PatchMapping("/api/updatePost")
	public Map<String, String> postUpdate(@RequestBody NoticeVO vo) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		service.updatePost(vo);
		map.put("result", "success");
		return map;
	}

	@PatchMapping("/api/updatePostConsult")
	public Map<String, String> postUpdateConsult(@RequestBody ConsultVO vo) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		cService.updatePost(vo);
		map.put("result", "success");
		return map;
	}

	@DeleteMapping("/api/deletePost")
	public Map<String, String> postDelete(@RequestParam Integer seq) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		service.deletePost(seq);
		return map;
	}

	@DeleteMapping("/api/deletePostConsult")
	public Map<String, String> postDeleteConsult(@RequestParam Integer seq) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		cService.deletePost(seq);
		return map;
	}

	@PatchMapping("/api/patchPostCnt")
	public Map<String, String> patchPostCnt(@RequestParam Integer post_seq) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		service.updatePostCount(post_seq);
		map.put("result", "success"); 
		return map;
	}
	
	
	 @PatchMapping("/api/patchPostCntConsult") 
	 public Map<String, String> patchPostCntConsult(@RequestParam Integer post_seq) {
		 Map<String, String> map = new LinkedHashMap<String, String>(); 
		 cService.updatePostCount(post_seq);
		 map.put("result", "success"); 
		 return map;
	 }
	 

	@GetMapping("/api/postCount")
	public Map<String, Integer> getPostCount(
			@RequestParam Integer board_seq

			) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		Integer count = service.getBoardPostCount(board_seq);
		map.put("count", count);
		return map;
	}

	/*
	 * @GetMapping("/api/postCountConsult") public Map<String, Integer>
	 * getPostCountConsult(@RequestParam Integer board_seq) { Map<String, Integer>
	 * map = new LinkedHashMap<String, Integer>(); Integer count =
	 * cService.getBoardPostCountConsult(board_seq); map.put("count",count); return
	 * map; }
	 */
	 

	@PostMapping("/api/insert_comment")
	public Map<String, String> PostInsertComment(@RequestBody CommentVO vo) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		cService.insertComment(vo);
		return map;
	}

	@PostMapping("/api/comments")
	public Map<String, Object> postComments(@RequestBody CommentReqVO vo) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("count", cService.selectCommentCount(vo));

		List<CommentVO> commentList = cService.selectComment(vo);
		commentList.forEach(comment -> {
			Integer seq = comment.getDhci_seq();
		});
		map.put("data", commentList);
		return map;
	}

	@DeleteMapping("/api/delete_comment")
    public Map<String, String> deleteComment(@RequestParam Integer seq) {
        Map<String, String> map = new LinkedHashMap<String, String>();

        cService.deleteComment(seq);

        map.put("message", "삭제되었습니다.");
        return map;
    }
}
