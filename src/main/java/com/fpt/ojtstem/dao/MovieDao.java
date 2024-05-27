package com.fpt.ojtstem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fpt.ojtstem.config.Config;
import com.fpt.ojtstem.model.Movie;
import com.fpt.ojtstem.model.Room;

public class MovieDao {
	static Connection con;
	static PreparedStatement ps;

	public List<Movie> getAll() {

		List<Movie> movies = new ArrayList<>();

		try {
			con = Config.getCon();
			StringBuilder query = new StringBuilder();
			query.append(
				    "SELECT  m.movie_id, m.movieName, m.director, m.actor, m.producter, m.duration, m.year_of_production, m.img, m.content, ")
				    .append("STRING_AGG(t.typeName, ',') WITHIN GROUP (ORDER BY t.typeName) AS type_names ")
				    .append("FROM movie m ")
				    .append("JOIN (SELECT DISTINCT typeId, typeName FROM TypeMovie) t ON CHARINDEX(',' + t.typeId + ',', ',' + m.typeId + ',') > 0 ")
				    .append("GROUP BY m.movie_id, m.movieName, m.director, m.actor, m.producter, m.duration, m.year_of_production, m.img, m.content ");
				String sql = query.toString();


			ps = con.prepareStatement(sql);

			System.out.println(ps);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String movieId = rs.getString("MOVIE_ID");
				String movieName = rs.getString("MOVIENAME");
				String direction = rs.getString("DIRECTOR");
				String actor = rs.getString("ACTOR");
				int yearOfproduction = rs.getInt("YEAR_OF_PRODUCTION");
				String typeName = rs.getString("TYPE_NAMES");
				String producter = rs.getString("producter");
				String image = rs.getString("img");
				String content = rs.getString("content");
				int duration = rs.getInt("duration");
				movies.add(new Movie(movieId, movieName, direction, actor, yearOfproduction, typeName, producter, image,
						content, duration));

			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return movies;
	}

	public void addMovie(Movie movie) {
		StringBuilder query = new StringBuilder();

		query.append(
				"INSERT INTO movie (moviename, director, actor, year_of_production, duration, producter, img, content, typeId,tus) ")
				.append("SELECT ?, ?, ?, ?, ?, ?, ?, ?, STRING_AGG(TRIM(typeId), ',') WITHIN GROUP (ORDER BY typeId),1 ")
				.append("FROM TypeMovie WHERE typeName IN (");
		String[] types = movie.getTypeName().split(", ");
		for (int i = 0; i < types.length; i++) {
			String cleanTypeName = types[i].trim();
			query.append("?");
			if (i < types.length - 1) {
				query.append(", ");
			}
		}
		query.append(")");
		String sql = query.toString();
		try {
			con = Config.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, movie.getMovieName());
			ps.setString(2, movie.getDirection());
			ps.setString(3, movie.getActor());
			ps.setInt(4, movie.getYearOfProduction());
			ps.setInt(5, movie.getDuration());
			ps.setString(6, movie.getProducter());
			ps.setString(7, movie.getImage());
			ps.setString(8, movie.getContent());

			int i = 9;
			for (String type : types) {
				ps.setString(i++, type.trim());
			}

			ps.executeUpdate();
			System.out.println(ps);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String id) {
		try {
			String query = "delete from movie where movie_id=?";
			con = Config.getCon();
			ps = con.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
			System.out.println(ps);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Movie getOneMovie(String id) {
		Movie movie = new Movie();
		try {
			StringBuilder query = new StringBuilder();
			query.append(
					"SELECT m.movie_id, m.moviename, m.director, m.actor, m.producter, m.duration, m.year_of_production, ")
					.append("STRING_AGG(t.typename, ',') WITHIN GROUP (ORDER BY t.typename) AS type_names, m.img, m.content ")
					.append("FROM movie m ")
					.append("JOIN (SELECT DISTINCT typeId, typeName FROM TypeMovie) t ON CHARINDEX(',' + t.typeId + ',', ',' + m.typeId + ',') > 0 ")
					.append("WHERE m.moviename=? or m.movie_id=? ")
					.append("GROUP BY m.movie_id, m.moviename, m.director, m.actor, m.producter, m.duration, m.year_of_production, m.img, m.content");
			String sql = query.toString();
			con = Config.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String movieId = rs.getString("MOVIE_ID");
				String movieName = rs.getString("MOVIENAME");
				String direction = rs.getString("DIRECTOR");
				String actor = rs.getString("ACTOR");
				int yearOfproduction = rs.getInt("YEAR_OF_PRODUCTION");
				String typeName = rs.getString("type_names");
				String producter = rs.getString("producter");
				String image = rs.getString("img");
				String content = rs.getString("content");
				int duration = rs.getInt("duration");
				movie = new Movie(movieId, movieName, direction, actor, yearOfproduction, typeName, producter, image,
						content, duration);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movie;
	}

	public boolean updateMovie(Movie movie) {
		StringBuilder query = new StringBuilder();
		query.append(
				"UPDATE movie m SET m.movie_name = ?, m.director = ?, m.actor = ?, m.year_of_production = ?, m.duration = ?, m.producter = ?, m.content = ?, m.typeId = ( ")
				.append("SELECT LISTAGG(t.typeId, ',') ").append("WITHIN GROUP (ORDER BY t.typeId)  ")
				.append("FROM TypeMovie t ").append("WHERE t.typeName IN ( ");
		String[] types = movie.getTypeName().split(", ");
		for (int i = 0; i < types.length; i++) {
			query.append("?");
			if (i < types.length - 1) {
				query.append(", ");
			}
		}

		query.append(") ) WHERE m.movieId = ?");
		String sql = query.toString();
		try {
			con = Config.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, movie.getMovieName());
			ps.setString(2, movie.getDirection());
			ps.setString(3, movie.getActor());
			ps.setInt(4, movie.getYearOfProduction());
			ps.setInt(5, movie.getDuration());
			ps.setString(6, movie.getProducter());
			ps.setString(7, movie.getContent());
			int i = 8;
			for (String type : types) {
				ps.setString(i++, type.trim());
			}
			ps.setNString(i, movie.getMovieId());
			int count = ps.executeUpdate();
			return count != 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public List<Movie> getAllHOT() {
	    List<Movie> movies = new ArrayList<>();

	    try {
	        Connection con = Config.getCon();
	        StringBuilder query = new StringBuilder();
	        query.append(
	                "SELECT m.movie_id, m.movieName, m.director, m.actor, m.producter, m.duration, m.year_of_production, m.img, m.content, ")
	             .append("STRING_AGG(t.typeName, ',') WITHIN GROUP (ORDER BY t.typeName) AS type_names ")
	             .append("FROM movie m ")
	             .append("JOIN (SELECT DISTINCT typeId, typeName FROM TypeMovie) t ON CHARINDEX(',' + t.typeId + ',', ',' + m.typeId + ',') > 0 or t.typeId=m.typeId ")
	             .append("JOIN Schedule sc ON m.movie_id = sc.movieId ")
	             .append("WHERE tus = 1 ")
	             .append("AND DATEPART(ISO_WEEK, sc.showdate) = DATEPART(WEEK, GETDATE()) ")
	             .append("AND YEAR(sc.showdate) = YEAR(GETDATE()) ")
	             .append("GROUP BY m.movie_id, m.movieName, m.director, m.actor, m.producter, m.duration, m.year_of_production, m.img, m.content");

	        String sql = query.toString();

	        PreparedStatement ps = con.prepareStatement(sql);
	        System.out.println(ps);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            String movieId = rs.getString("movie_id");
	            String movieName = rs.getString("movieName");
	            String director = rs.getString("director");
	            String actor = rs.getString("actor");
	            int yearOfProduction = rs.getInt("year_of_production");
	            String typeName = rs.getString("type_names");
	            String producter = rs.getString("producter");
	            String image = rs.getString("img");
	            String content = rs.getString("content");
	            int duration = rs.getInt("duration");

	            movies.add(new Movie(movieId, movieName, director, actor, yearOfProduction, typeName, producter, image, content, duration));
	        }
	        rs.close();
	        ps.close();
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return movies;
	}
	

	public Movie getMovieByName(String id) {
		Movie movie = new Movie();
		try {
			StringBuilder query = new StringBuilder();
			query.append(
					"SELECT m.movie_id, m.moviename, m.director, m.actor, m.producter, m.duration, m.year_of_production, ")
					.append("STRING_AGG(t.typename, ',') WITHIN GROUP (ORDER BY t.typename) AS type_names, m.img, m.content ")
					.append("FROM movie m ")
					.append("JOIN (SELECT DISTINCT typeId, typeName FROM TypeMovie) t ON CHARINDEX(',' + t.typeId + ',', ',' + m.typeId + ',') > 0 ")
					.append("WHERE m.moviename=?  ")
					.append("GROUP BY m.movie_id, m.moviename, m.director, m.actor, m.producter, m.duration, m.year_of_production, m.img, m.content");
			String sql = query.toString();
			con = Config.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String movieId = rs.getString("MOVIE_ID");
				String movieName = rs.getString("MOVIENAME");
				String direction = rs.getString("DIRECTOR");
				String actor = rs.getString("ACTOR");
				int yearOfproduction = rs.getInt("YEAR_OF_PRODUCTION");
				String typeName = rs.getString("type_names");
				String producter = rs.getString("producter");
				String image = rs.getString("img");
				String content = rs.getString("content");
				int duration = rs.getInt("duration");
				movie = new Movie(movieId, movieName, direction, actor, yearOfproduction, typeName, producter, image,
						content, duration);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movie;
	}

}
