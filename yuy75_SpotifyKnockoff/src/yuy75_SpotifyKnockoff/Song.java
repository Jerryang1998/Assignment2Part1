package yuy75_SpotifyKnockoff;

import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Song {
	private String songID;
	private String title;
	private double length;
	private String filePath;
	private String releaseDate;
	private String recordDate;
	private String albumID;
	Map<String,Artist> songArtist;
	
	public Song(String title, double length, String releaseDate, String recordDate, String albumID) {
		this.title = title;
		this.length = length;
		this.releaseDate = releaseDate;
		this.recordDate = recordDate;
		this.albumID = albumID;
		this.songID = UUID.randomUUID().toString();
		//System.out.println(this.songID);
		String sql = "INSERT INTO song(song_id, title, length, file_path, release_date, record_date, fk_album_id) ";
		sql += "VALUES ('" + this.songID + "', '" + this.title + "', '" + this.length + "', '', '" + this.releaseDate + "', '" + this.recordDate + "', '" + this.albumID + "');";
		/*String sql = "INSERT INTO song(song_id, title, length, file_path, release_date, record_date, fk_album_id)";
		sql += "VALUES (?,?,?,?,?,?,?);";*/
		//System.out.println(sql);
		DbUtilities db = new DbUtilities();
		Connection conn = db.getConn();
		/*try {
			DbUtilities db = new DbUtilities();
			Connection conn = db.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, this.songID);
			ps.setString(2, this.title);
			ps.setDouble(3, this.length);
			ps.setString(4, "");
			ps.setString(5, this.releaseDate);
			ps.setString(6, this.recordDate);
			ps.setString(7, this.albumID);
			ps.executeUpdate();
			db.closeDbConnection();
			db = null;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}*/
		db.executeQuery(sql);
		db.closeDbConnection();
		db = null;
	}
	public Song(String songID) {
		String sql = "SELECT * FROM song WHERE song_id = '" + songID + "';";
		//System.out.println(sql);
		DbUtilities db = new DbUtilities();
		try {
			ResultSet rs = db.getResultSet(sql);
			while(rs.next()) {
				this.songID = rs.getString("song_id");
				//System.out.println("Song ID from database: " + this.songID);
				this.title = rs.getString("title");
				this.releaseDate = rs.getDate("release_date").toString();
				this.recordDate = rs.getDate("record_date").toString();
				this.length = rs.getDouble("length");
				this.albumID = rs.getString("fk_album_id");
				//System.out.println("Song title from database: " + this.title);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String getSongID() {
		return songID;
	}
	public String getTitle() {
		return title;
	}
	public double getLength() {
		return length;
	}
	public String getFilePath() {
		return filePath;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public String getAlbumID() {
		return albumID;
	}
	public Map<String, Artist> getSongArtist() {
		return songArtist;
	}
	public void deleteSong(String songID) {
		
	}
	public void addArtist(Artist artist) {
		
	}
	public void deleteArtist(String artistID) {
		
	}
	public void deleteArtist(Artist artist) {
		
	}
}

