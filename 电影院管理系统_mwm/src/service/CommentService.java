package service;

import java.util.List;

import entry.Comment;

public interface CommentService {
	public int addComment(Comment comment) throws Exception;// 添加评论

	public int deleteComment(int coId) throws Exception;// 删除评论

	public List<Comment> getAllComments() throws Exception;// 查看所有评论

	public List<Comment> findCommentByUId(int uId) throws Exception;// 通过用户id查找评论
	
	public List<Comment> findCommentByMId(int mId) throws Exception;// 通过电影id查找评论
}
