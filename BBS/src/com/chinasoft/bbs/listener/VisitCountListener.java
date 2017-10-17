package com.chinasoft.bbs.listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * Application Lifecycle Listener implementation class VisitCountListener
 *
 */
public class VisitCountListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public VisitCountListener() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	ServletContext sc = arg0.getServletContext();
    	String path = sc.getRealPath("/WEB-INF/classes");
    	File file = new File(path+"/com/chinasoft/bbs/listener/visitcounts.txt");
    	try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			Integer count = (Integer) sc.getAttribute("count");
			bw.write(count.toString());
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	ServletContext sc = arg0.getServletContext();
    	String path = sc.getRealPath("/WEB-INF/classes");
    	File file = new File(path+"/com/chinasoft/bbs/listener/visitcounts.txt");
    	try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String countStr = br.readLine();
			sc.setAttribute("count",Integer.parseInt(countStr) );
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
