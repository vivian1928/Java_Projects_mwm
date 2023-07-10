package serviceimpl;

import java.util.List;

import dao.CommentDao;
import daoimpl.CommentDaoImpl;
import entry.Comment;
import service.CommentService;

public class CommentServiceImpl implements CommentService{
	CommentDao commentDao = new CommentDaoImpl();
	@Override
	public int addComment(Comment comment) throws Exception {
		
		return commentDao.insertComment(comment);
	}

	@Override
	public int deleteComment(int coId) throws Exception {
		
		return commentDao.deleteComment(coId);
	}

	@Override
	public List<Comment> getAllComments() throws Exception {
		
		return commentDao.getAllComments();
	}

	@Override
	public List<Comment> findCommentByUId(int uId) throws Exception {
		
		return commentDao.findCommentByUId(uId);
	}

	@Override
	public List<Comment> findCommentByMId(int mId) throws Exception {
		
		return commentDao.findCommentByMId(mId);
	}

}
