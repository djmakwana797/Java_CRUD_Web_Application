/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Member;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Makwana Divya
 */
public class MemberDAO {
    
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/java?user=root";
            con = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public static int insert(Member md) throws SQLException{
        int row = 0;
        try {
            Connection con = MemberDAO.getConnection();
            String query = "INSERT INTO member(firstname,lastname,email,password,phone,age,gender,city)VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, md.getFirstname());
            ps.setString(2, md.getLastname());
            ps.setString(3, md.getEmail());
            ps.setString(4, md.getPassword());
            ps.setString(5, md.getPhone());
            ps.setInt(6 ,md.getAge());
            ps.setString(7, md.getGender());
            ps.setString(8, md.getCity());
            
            row = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException sqle) {
            System.err.println("Error with connection:" + sqle);
        }
        return row;
    }
    
    public static List<Member> getMembers(){
        List<Member> list = new ArrayList<Member>();
        
        try{  
            Connection con=MemberDAO.getConnection();  
            PreparedStatement ps = con.prepareStatement("select * from member");  
            ResultSet rs = ps.executeQuery();  
            while(rs.next()){  
                Member m = new Member();  
                m.setId(rs.getInt(1));
                m.setFirstname(rs.getString(2));
                m.setLastname(rs.getString(3));
                m.setEmail(rs.getString(4));
                m.setPassword(rs.getString(5));
                m.setPhone(rs.getString(6));
                m.setAge(rs.getInt(7));
                m.setGender(rs.getString(8));
                m.setCity(rs.getString(9));
                list.add(m);  
            }  
            ps.close();
            con.close();  
        } catch (SQLException ex) {  
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return list;  
    }

    public static Member getMemberById(int id) {
        Member m = new Member();
        
        try {  
            Connection con = MemberDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from member where id=?");
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                m.setId(rs.getInt(1));
                m.setFirstname(rs.getString(2));
                m.setLastname(rs.getString(3));
                m.setEmail(rs.getString(4));
                m.setPassword(rs.getString(5));
                m.setPhone(rs.getString(6));
                m.setAge(rs.getInt(7));
                m.setGender(rs.getString(8));
                m.setCity(rs.getString(9));
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }

    public static int update(Member md) {
        int row = 0;
        try {
            Connection con = MemberDAO.getConnection();
            String query = "UPDATE member SET firstname=?,lastname=?,email=?,password=?,phone=?,age=?,gender=?,city=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, md.getFirstname());
            ps.setString(2, md.getLastname());
            ps.setString(3, md.getEmail());
            ps.setString(4, md.getPassword());
            ps.setString(5, md.getPhone());
            ps.setInt(6 ,md.getAge());
            ps.setString(7, md.getGender());
            ps.setString(8, md.getCity());
            ps.setInt(9, md.getId());
            
            row = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException sqle) {
            System.err.println("Error with connection:" + sqle);
        }
        return row;
    }

    public static int delete(int id) {
        int row= 0 ;
        try {  
            Connection con = MemberDAO.getConnection();  
            PreparedStatement ps = con.prepareStatement("DELETE from member WHERE id=?");
            ps.setInt(1, id);
            
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
}
