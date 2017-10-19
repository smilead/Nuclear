package com.jokerdemo.bbs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jokerdemo.bbs.dao.CommentDao;
import com.jokerdemo.bbs.dao.UserDAO;
import com.jokerdemo.bbs.entity.Comment;
import com.jokerdemo.bbs.entity.Recomment;
import com.jokerdemo.bbs.po.CommentPage;
import com.jokerdemo.bbs.service.UserService;
import com.jokerdemo.bbs.service.impl.RecServiceImpl;
import com.jokerdemo.bbs.service.impl.UserServiceImpl;
import com.jokerdemo.bbs.util.DBUtil;

public class CommentDaoImpl implements CommentDao{

	@Override
	public int addComment(String content, int uid, int pid, int floor) {
		// TODO Auto-generated method stub
		DBUtil db=new DBUtil();
		String sql="insert into comment(cid,content,uid,ctime,pid,floor) values(null,?,?,now(),?,?)";
		Object[] params=new Object[] {content,uid,pid,floor};
		int rows = db.executOther(sql, params);
		return rows;
	}

	@Override
	public boolean deletComment(int cid) {
		// TODO Auto-generated method stub
		DBUtil db=new DBUtil();
		String sql="delete from comment where cid=?";
		if(db.executOther(sql, new Object[] {cid})==1) {
			return true;
		}
		return false;
	}

	@Override
	public Comment updateComment(Comment comment) {
		// TODO Auto-generated method stub
		DBUtil db=new DBUtil();
		String sql="update comment set content= ?,contentpic=?,floor=? where cid=?";
		int rs=db.executOther(sql, new Object[]{comment.getContent(),comment.getContentpic(),comment.getFloor(),comment.getCid()});
		if(rs>0) {
			db.closeConn();
			return comment;
		}
		return null;
	}

	@Override
	public ArrayList<Comment> findCommentBy(String sel, Object obj) {
		// TODO Auto-generated method stub
		DBUtil db=new DBUtil();
		
		String sql="select * from comment where "+sel+" =? order by floor desc";
		ResultSet rs=db.execQuery(sql, new Object[] {obj});
		ArrayList<Comment> comments=new ArrayList<Comment>();
		try {
			while(rs.next()){
				Comment comment = new Comment();
				comment.setCid(rs.getInt("cid"));
				comment.setContent(rs.getString("content"));
				comment.setContentpic(rs.getString("contentpic"));
				comment.setUid(rs.getInt("uid"));
				comment.setCtime(rs.getDate("ctime"));
				comment.setPid(rs.getInt("pid"));
				comment.setFloor(rs.getInt("floor"));
				
				comments.add(comment);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeConn();
		}
		return comments;
	}
	public CommentPage selectCommentPage(String sel, Object obj, int currentPage, int pageSize) {
	
		String sql="select * from comment where "+sel+"= ? order by floor ";
		DBUtil db=new DBUtil();
		ArrayList<Comment> comments=new ArrayList<Comment>();
		int totalCount=0;
		try {
			ResultSet rs=db.execQuery(sql,new Object[]{obj});
			if(!rs.wasNull()) {
				rs.last();
				totalCount=rs.getRow();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql=add(sql, currentPage, pageSize);
		ResultSet rs=db.execQuery(sql, new Object[]{obj});
		RecServiceImpl recServiceImpl=new RecServiceImpl();
		Comment comment=null;
		UserDAO userDAO=new UserDAOImpl();
		try {
			while(rs.next()) {
				comment=new Comment();
				comment.setCid(rs.getInt("cid"));
				comment.setContent(rs.getString("content"));
				comment.setContentpic(rs.getString("contentpic"));
				comment.setUid(rs.getInt("uid"));
				comment.setCtime(rs.getDate("ctime"));
				comment.setPid(rs.getInt("pid"));
				comment.setFloor(rs.getInt("floor"));
				if(recServiceImpl.findByParam("cid",rs.getInt("cid")).size()>0) {
					for(Recomment recomment:recServiceImpl.findByParam("cid",rs.getInt("cid"))) {
						System.out.println(recomment.getRecontent());
					}
				}
				comment.setRecomments(recServiceImpl.findByParam("cid",rs.getInt("cid")));
				comment.setPixname(userDAO.quicklyFind(comment.getUid()).getPixname());
				comment.setLevel(userDAO.quicklyFind(comment.getUid()).getLevel());
				comment.setUserPic(userDAO.quicklyFind(comment.getUid()).getUserpic());
				comments.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeConn();
		if(comments.size()==0) 
		return null;
		return construction(comments, totalCount, currentPage, pageSize);
	}
	
	public String add(String sql,int currentPage,int pageSize) {
		return sql+" limit "+currentPage*pageSize+","+pageSize;
	}

	public CommentPage construction(ArrayList<Comment> comments,int totalCount,int currentPage,int pageSize) {
		if(comments!=null) {
			UserService userService=new UserServiceImpl();
			ArrayList<Integer> uids=new ArrayList<Integer>();
			CommentPage commentPage=new CommentPage();
			int totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
			for(Comment comment:comments) {
				uids.add(comment.getUid());
			}
			userService.findUsersByUids(uids);
			commentPage.setUsers(userService.findUsersByUids(uids));			
			commentPage.setTotalPage(totalPage);
			commentPage.setCurrentPage(currentPage+1);
			commentPage.setPageSize(pageSize);
			commentPage.setTotalCount(totalCount);
			commentPage.setComments(comments);
			
			return commentPage;
		}
		return null;
	}
}
