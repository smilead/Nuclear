package com.jokerdemo.bbs.util;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
public class DBUtil {
	private Connection conn = null;
   	private PreparedStatement  ptsm = null;
   	private ResultSet rs =null;
	private static ComboPooledDataSource dbPool;
  
	static {
		try {
			dbPool=new ComboPooledDataSource();
			dbPool.setDriverClass("com.mysql.jdbc.Driver");
			dbPool.setJdbcUrl("jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=utf-8");
			dbPool.setUser("root");
			dbPool.setPassword("root");
			dbPool.setMaxPoolSize(10);
			dbPool.setMinPoolSize(2);
			dbPool.setInitialPoolSize(3);
			dbPool.setMaxStatements(15);
			
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}   

  
       /**
        * 获取连接
        * @return
        * @throws SQLException
        */
     public  Connection getConnection(){            
    	 closeConn();
    	 try {
    		 System.out.println("try链接池");
			return dbPool.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	 System.out.println("返回值为空");
    	   return null;
       }
	//方法三：增删改的方法
	public int executOther(final String sql,final Object[] params) {
		Connection conn=getConnection();
		try {
			ptsm = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				ptsm.setObject(i+1, params[i]);
			}
			return ptsm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConn();
		}
			
		
		return -1;
	}
	//方法四：专门执行查询的方法
	public ResultSet execQuery(final String sql,final Object[] params){
		conn=getConnection();
		try {
			ptsm = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				ptsm.setObject(i+1, params[i]);
			}
			return ptsm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			closeConn();
		
		return null;
	}

	public void closeConn(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ptsm!=null){
			try {
				ptsm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}

