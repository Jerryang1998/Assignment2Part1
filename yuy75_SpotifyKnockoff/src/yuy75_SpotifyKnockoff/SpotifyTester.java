package yuy75_SpotifyKnockoff;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

public class SpotifyTester {

	public static void main(String[] args) {
		/*Song s1 = new Song("Stairway to Heaven", 8.02, "1971-10-08", "1971-05-07", "57ed733c-0099-11e8-a67a-005056881e07");
		Song s2 = new Song("Easy", 3.32, "1971-10-08", "1971-05-07", "57ed733c-0099-11e8-a67a-005056881e07");
		Song s3 = new Song("I want you back", 4.56, "1979-09-08", "1978-05-23", "57ed733c-0099-11e8-a67a-005056881e07");
		
		Album a1 = new Album("1", "1998-11-13", "INFSCI11017", 11, "R", 5000);
		
		Artist r1 = new Artist("Michael", "Jackson", "Jackson5");*/
		
		Hashtable<String, Song> songList = new Hashtable<String, Song>();
		
		try {
			DbUtilities db = new DbUtilities();
			String sql = "SELECT * FROM song;";
			ResultSet rs = db.getResultSet(sql);
			while(rs.next()) {
				Song s = new Song(rs.getString("song_id"));
				songList.put(s.getSongID(), s);
			}
			db.closeDbConnection();
			db = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		Song foundSong = songList.get("8a815a8a-6051-42e3-87de-bb3c692bdec8");
		System.out.println(foundSong.getTitle());
	}
	
}
