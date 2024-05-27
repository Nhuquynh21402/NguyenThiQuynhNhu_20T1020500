package com.fpt.ojtstem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fpt.ojtstem.config.Config;
import com.fpt.ojtstem.model.TypeMovie;



public class TypeMovieDao {
	static Connection con;
	static PreparedStatement ps;
	private static final String query = "SELECT * FROM TypeMovie";
	public List<TypeMovie> getAll() {
		List<TypeMovie> Typemovie = new ArrayList<>();
		try {
			con = Config.getCon();
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
	               String typeMovieID = rs.getString("typeId");
                   String typeMovieName = rs.getString("typeName");
                   Typemovie.add(new TypeMovie(typeMovieID, typeMovieName));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return Typemovie;
	}
	
	
	public void insertTypeMovie(TypeMovie typeMovie) {
		try {
			String query = "insert into TypeMovie(typeId,typeName) VALUES (?,?)";
			con = Config.getCon();
			ps = con.prepareStatement(query);
			ps.setString(1,typeMovie.getTypeMovieID());
			ps.setString(2,typeMovie.getTypeMovieName());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public void updateTypeMovie(TypeMovie typeMovie) {
		try {
		con = Config.getCon();
		String query= "update TypeMovie set typeName=? where typeId=?";
		ps = con.prepareStatement(query);
		ps.setString(1,typeMovie.getTypeMovieName());
		ps.setString(2,typeMovie.getTypeMovieID());
		ps.executeUpdate();
	} catch (Exception e) {
		System.out.println(e);
	}
	}
	public TypeMovie findType(String key) {
		 TypeMovie type = null;
		try {
		con = Config.getCon();
		String query= "SELECT * from TypeMovie where typeId=?";
		ps = con.prepareStatement(query);
		ps.setString(1, key);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			 String typeMovieID=rs.getString("typeId");
             String typeMovieName=rs.getString("typeName");
             type= new TypeMovie(typeMovieID, typeMovieName);
		}
		rs.close();
	} catch (Exception e) {
		System.out.println(e);
	}
		return type;
	}
	public void deleteTypeMovie(String TypeMovie) throws SQLException {
		con = Config.getCon();
		String query = "delete  from TypeMovie where typeId=?";
		ps = con.prepareStatement(query);
		ps.setString(1, TypeMovie);
		ps.executeUpdate();
        ps.close();
	}
	public List<String> getAllNameType(){
		List<String> listTypeName = new ArrayList<String>();
		try {
			con = Config.getCon();
			String query = "select typeName from TypeMovie";
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				listTypeName.add(rs.getString("typeName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTypeName;
		}
}