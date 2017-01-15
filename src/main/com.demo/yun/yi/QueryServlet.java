package yun.yi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by dinglei on 2016/11/10.
 */
//@WebServlet("/query.do")
public class QueryServlet extends HttpServlet {

    Connection conn=null;
    public void init(){
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://127.0.0.1:3306/test_ding";
        String username="root";
        String password="123456";
        try{
            Class.forName(driver);
            conn= DriverManager.getConnection(url,username,password);
        }catch(ClassNotFoundException e1){
            System.out.println(e1);
        }catch (SQLException e2){}
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String sql="select * from Stu where id=?";
        try{
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,id);
            ResultSet rst=pst.executeQuery();
            if(rst.next()){
                Student stu=new Student();
                stu.setId(rst.getString("id"));
                stu.setName(rst.getString("name"));
                request.getSession().setAttribute("student",stu);
                System.out.println("查询成功");
                response.sendRedirect("/hellomaven/showonestu.jsp");
            }else{
                System.out.println("查询失败");
                response.sendRedirect("/hellomaven/index.jsp");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> stulist=null;
        stulist=new ArrayList<Student>();
        try{
            String sql="select * from Stu";
            PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet result=pst.executeQuery();
            while(result.next()){
                Student stu=new Student();
                stu.setId(result.getString("id"));
                stu.setName(result.getString("name"));
                stulist.add(stu);
            }
            if(!stulist.isEmpty()){
                System.out.println("全查询成功");
                request.getSession().setAttribute("stulist",stulist);
                response.sendRedirect("/hellomaven/showall.jsp");
            }else{
                response.sendRedirect("/hellomaven/index.jsp");
            }

        }catch (SQLException e){e.printStackTrace();}

    }
    public void destroy(){
        try{
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
