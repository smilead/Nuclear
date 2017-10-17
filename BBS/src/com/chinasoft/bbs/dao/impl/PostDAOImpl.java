package com.chinasoft.bbs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.chinasoft.bbs.dao.CommentDao;
import com.chinasoft.bbs.dao.PostDAO;
import com.chinasoft.bbs.entity.MiniPost;
import com.chinasoft.bbs.entity.Post;
import com.chinasoft.bbs.entity.User;
import com.chinasoft.bbs.po.CommentPage;
import com.chinasoft.bbs.po.PostsPage;
import com.chinasoft.bbs.service.CommentService;
import com.chinasoft.bbs.service.UserService;
import com.chinasoft.bbs.service.impl.CommentServiceImpl;
import com.chinasoft.bbs.service.impl.UserServiceImpl;
import com.chinasoft.bbs.util.DBUtil;


public class PostDAOImpl implements PostDAO{
	private DBUtil db=new DBUtil();
	private ArrayList<MiniPost> miniPosts=new ArrayList<MiniPost>();	
	@Override
 	public Post addPost(Post post) {
		// TODO Auto-generated method stub
		String sql="insert into post(ptitle,article,enclosure,uid,ptime,pageview,level,type,competitive)  values(?,?,?,?,now(),0,0,?,0)";
		Object[] params=new Object[] {post.getPtitle(),post.getArticle(),post.getEnclosure(),post.getUid(),post.getType()};
		if(db.executOther(sql, params)==1) {
			return selectOnePostBy(new String[] {"uid"}, new Object[] { post.getUid()}, new String[] {"ptime"});
		}else {
			return null;		
		}
	}

	@Override
	public boolean deletePost(int pid) {
		// TODO Auto-generated method stub
		String sql="delete from post where pid = ?";
		if(db.executOther(sql, new Object[] {pid})==1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePost(int pid,String[] sels,Object[] objs) {
		// TODO Auto-generated method stub
		String sql="update post set "+sels[0]+"= ? ";
		for(int i=1;i<sels.length;i++) {
			sql=sql+","+sels[i]+"=?";
		}
		sql=sql+" where pid="+pid;
		if(db.executOther(sql, objs)==1) {
			return true;
		}
		return false;
	}

	@Override
	public Post selectOnePost(int pid) {
		// TODO Auto-generated method stub
		DBUtil db=new DBUtil();
		Post post=new Post();
		String sql="select * from post where pid=?";
		ResultSet rs=db.execQuery(sql, new Object[] {pid});
		try {
			if(rs.next()) { 
				post.setPid(rs.getInt("pid"));
				post.setPtitle(rs.getString("ptitle"));
				post.setArticle(rs.getString("article"));
				post.setEnclosure(rs.getString("enclosure"));
				post.setUid(rs.getInt("uid"));
				post.setPtime(rs.getDate("ptime"));
				post.setLevel(rs.getInt("level"));
				post.setPageView(rs.getInt("pageview")+1);
				post.setType(rs.getString("type"));
				post.setCompetitive(rs.getInt("competitive"));
				CommentDao commentDao=new CommentDaoImpl();
				CommentPage commentPage=commentDao.selectCommentPage("pid", rs.getInt("pid"), 1, 10);
				post.setCommentPage(commentPage);
				updatePost(pid,new String[] {"pageview"},new Object[] {rs.getInt("pageview")+1});
				return post;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closeConn();
		}
		return null;
	}
	
	public Post selectOnePostBy(String[] strs,Object[] objs,String[] orders) {
		String sql="select * from post where "+strs[0]+"= ?";
		for(int i=1;i<strs.length;i++) {
			sql=sql+" and "+strs[i]+"= ?";
		}
		sql=sql+" order by "+orders[0]+" desc";
		for(int i=1;i<orders.length;i++) {
			sql=sql+","+orders[i];
		}
		ResultSet rs=db.execQuery(sql, objs);
		try {
			if(rs.next()) {
				Post post=new Post();
				post.setPid(rs.getInt("pid"));
				post.setPtitle(rs.getString("ptitle"));
				post.setArticle(rs.getString("article"));
				post.setEnclosure(rs.getString("enclosure"));
				post.setUid(rs.getInt("uid"));
				post.setPtime(rs.getDate("ptime"));
				post.setPageView(rs.getInt("pageview")+1);
				post.setLevel(rs.getInt("level"));
				post.setType(rs.getString("type"));
				db.closeConn();
				return post;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public PostsPage selectPostsOrderBy(String sel, String type, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String sql;
		Object[] obj=null;
		if("index".equals(type)) {
			obj=new Object[] {};
			sql="select * from post where level=255 or(level>=0 and level<255) order by level desc,"+sel+" desc";
		}else {
			sql="select * from post where level=255 or(level>=0 and level<255 and type= ?) order by level desc,"+sel+" desc";
			obj=new Object[] {type};
		}
		int totalCount=0;
		try {
			ResultSet rs=db.execQuery(sql,obj);
			if(!rs.wasNull()) {
					rs.last();
					totalCount=rs.getRow();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql=add(sql, currentPage, pageSize);
		ResultSet rs=db.execQuery(sql, obj);
		MiniPost miniPost=null;
		try {
			while(rs.next()) {
				miniPost=new MiniPost();
				miniPost.setPid(rs.getInt("pid"));
				miniPost.setPtitle(rs.getString("ptitle"));
				miniPost.setUid(rs.getInt("uid"));
				miniPost.setPtime(rs.getDate("ptime"));
				miniPost.setPageView(rs.getInt("pageview"));
				miniPost.setLevel(rs.getInt("level"));
				miniPost.setType(rs.getString("type"));
				miniPost.setCompetitive(rs.getInt("competitive"));
				miniPosts.add(miniPost);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeConn();
		if(miniPosts.size()==0) 
		
		return null;
		return construction(miniPosts, totalCount, currentPage, pageSize);
	}
	
	@Override
	public PostsPage selectPostsRecently(int date,String type, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String sql="select * from post where level>-1 and TO_DAYS(now())-TO_DAYS(ptime)<"+date;
		if(!"index".equals(type)) {
			sql=sql+" and type='"+type+"'";
		}
		int totalCount=0;
		try {
			ResultSet rs=db.execQuery(sql,new Object[]{});
			rs.last();
			totalCount=rs.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql=add(sql, currentPage, pageSize);
		ResultSet rs=db.execQuery(sql, new Object[] {});
		MiniPost miniPost=null;
		try {
			while(rs.next()) {
				miniPost=new MiniPost();
				miniPost.setPid(rs.getInt("pid"));
				miniPost.setPtitle(rs.getString("ptitle"));
				miniPost.setUid(rs.getInt("uid"));
				miniPost.setPtime(rs.getDate("ptime"));
				miniPost.setPageView(rs.getInt("pageview"));
				miniPost.setLevel(rs.getInt("level"));
				miniPost.setType(rs.getString("type"));
				miniPost.setCompetitive(rs.getInt("competitive"));
				miniPosts.add(miniPost);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(miniPosts.size()==0) 
		return null;
		return construction(miniPosts, totalCount, currentPage, pageSize);
	}

	@Override
	public PostsPage selectPostsByValue(String sel, Object obj,String type, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String sql="select * from post where level>-1 and "+sel+"=?";		
		if(!"index".equals(type)) {
			sql=sql+" and type= '"+type+"'";
		}
		int totalCount=0;
		try {
			ResultSet rs=db.execQuery(sql,new Object[]{obj});
			rs.last();
			totalCount=rs.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql=add(sql, currentPage, pageSize);
		ResultSet rs=db.execQuery(sql, new Object[] {obj});
		MiniPost  miniPost=null;
		try {
			while(rs.next()) {
				 miniPost=new MiniPost();
				 miniPost.setPid(rs.getInt("pid"));
				 miniPost.setPtitle(rs.getString("ptitle"));
				 miniPost.setUid(rs.getInt("uid"));
				 miniPost.setPtime(rs.getDate("ptime"));
				 miniPost.setPageView(rs.getInt("pageview"));
				 miniPost.setLevel(rs.getInt("level"));
				 miniPost.setType(rs.getString("type"));
				 miniPost.setCompetitive(rs.getInt("competitive"));
				 miniPosts.add(miniPost);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeConn();
		if(miniPosts.size()==0) 
		return null;
		return construction(miniPosts, totalCount, currentPage, pageSize);		
	}

	@Override
	public PostsPage selectPostsVague(String sel,String type, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		String[] strs=sel.split(",");
		String sql="select * from post where level > -1 ";
		String sqlEnd1=" and (ptitle like '%"+strs[0];
		String sqlEnd2=" or article like'%"+strs[0];
		for(int i=1;i<strs.length;i++) {
			sqlEnd1=sqlEnd1+"%"+strs[i];
			sqlEnd2=sqlEnd2+"%"+strs[i];
		}
		sql=sql+sqlEnd1+"%'"+sqlEnd2+"%')";
		if(!"index".equals(type)) {
			sql=sql+" and type='"+type+"'";
		}
		int totalCount=0;
		try {
			ResultSet rs=db.execQuery(sql,new Object[]{});
			rs.last();
			totalCount=rs.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql=add(sql, currentPage, pageSize);
		ResultSet rs=db.execQuery(sql,new Object[] {});
		MiniPost miniPost=null;
		try {
			while(rs.next()) {
				miniPost=new MiniPost();
				miniPost.setPid(rs.getInt("pid"));
				miniPost.setPtitle(rs.getString("ptitle"));
				miniPost.setUid(rs.getInt("uid"));
				miniPost.setPtime(rs.getDate("ptime"));
				miniPost.setPageView(rs.getInt("pageview"));
				miniPost.setLevel(rs.getInt("level"));
				miniPost.setType(rs.getString("type"));
				miniPost.setCompetitive(rs.getInt("competitive"));
				String article=rs.getString("article");
				int var=article.indexOf(sel);
				miniPost.setPreview("<font color='red'>"+sel+"</font>"+article.substring(var, var+10));
				miniPosts.add(miniPost);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeConn();
		if(miniPosts.size()==0) 
		return null;
		return construction(miniPosts, totalCount, currentPage, pageSize);

	}

	@Override
	public PostsPage selectPostsBetween(String sel,String type, Object min, Object max, int currentPage, int pageSize) {
		
		String sql="select * from post where level>-1 and "+sel+" between ? and ?";
		if(!"index".equals(type)) {
			sql=sql+" and type ='"+type+"'";
		}
		int totalCount=0;
		try {
			ResultSet rs=db.execQuery(sql,new Object[]{min,max});
			rs.last();
			totalCount=rs.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql=add(sql, currentPage, pageSize);
		ResultSet rs=db.execQuery(sql, new Object[]{min,max});
		
		MiniPost miniPost=null;
		try {
			while(rs.next()) {
				miniPost=new MiniPost();
				miniPost.setPid(rs.getInt("pid"));
				miniPost.setPtitle(rs.getString("ptitle"));
				miniPost.setUid(rs.getInt("uid"));
				miniPost.setPtime(rs.getDate("ptime"));
				miniPost.setPageView(rs.getInt("pageview"));
				miniPost.setLevel(rs.getInt("level"));
				miniPost.setType(rs.getString("type"));
				miniPost.setCompetitive(rs.getInt("competitive"));
				miniPosts.add(miniPost);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(miniPosts.size()==0) 
		return null;
		return construction(miniPosts, totalCount, currentPage, pageSize);
	}
	
	public String add(String sql,int currentPage,int pageSize) {
	
		return sql+" limit "+currentPage*pageSize+","+pageSize;
	
	}

	public PostsPage construction(ArrayList<MiniPost> miniPosts,int totalCount,int currentPage,int pageSize) {
		if(miniPosts!=null) {
			UserService userService=new UserServiceImpl();
			ArrayList<Integer> uids=new ArrayList<Integer>();
			PostsPage postsPage=new PostsPage();
			int totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
			CommentService commentService=new CommentServiceImpl();
			MiniPost miniPost;
			for(MiniPost miniPost1:miniPosts) {
				uids.add(miniPost1.getUid());	
			}
			ArrayList<User> users=userService.findUsersByUids(uids);	
			User user=null;
			for(int i=0;i<users.size();i++) {
				miniPost=miniPosts.get(i);
				user=users.get(i);
				miniPost.setPixname(user.getPixname());
				miniPost.setUserLevel(user.getLevel());
				commentService.findCommentCounts(miniPost.getPid());
				miniPost.setCommentTotal(commentService.findCommentCounts(miniPost.getPid()));
				miniPosts.set(i, miniPost);
			}		
			postsPage.setTotalPage(totalPage);
			postsPage.setCurrentPage(currentPage+1);
			postsPage.setPageSize(pageSize);
			postsPage.setTotalCount(totalCount);	
			postsPage.setMiniPosts(miniPosts);
			return postsPage;
		}
		return null;
	}

}
