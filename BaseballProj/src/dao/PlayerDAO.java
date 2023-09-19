package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.Player;

public class PlayerDAO {

	public Connection getConnection() {
		Connection conn = null;
		try {
			Properties db = new Properties();
			db.load(new FileInputStream("db.properties"));
			Class.forName(db.getProperty("driver"));
			conn = DriverManager.getConnection(db.getProperty("url"), db.getProperty("user"),
					db.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertPlayer(Player player) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into player(name, backnum, teamnum) values(?,?,?)";
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, player.getName());
			pstmt.setInt(2, player.getBacknum());
			pstmt.setInt(3, player.getTeamnum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		close(conn);
		return cnt;
	}

	public List<Player> selectPlayerByName(String name) {
		Connection conn = getConnection();
		List<Player> playerList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select p.num, p.name, p.backnum, p.teamnum, t.name"
				+ " from player p join team t on p.teamnum = t.teamnum" + " where p.name = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					playerList.add(
							new Player(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		close(conn);
		return playerList;
	}

	public List<Player> selectPlayerByBackNum(Integer backnum) {
		Connection conn = getConnection();
		List<Player> playerList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select p.num, p.name, p.backnum, p.teamnum, t.name"
				+ " from player p join team t on p.teamnum = t.num" + " where p.backnum = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, backnum);
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					playerList.add(
							new Player(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getInt(4), rs.getString(5)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		close(conn);
		return playerList;
	}

	public Player selectPlayerByNum(Integer num) {
		Connection conn = getConnection();
		Player player = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select p.num, p.name, p.backnum, p.teamnum, t.name"
				+ " from player p join team t on p.teamnum = t.num" + " where p.num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				player = new Player(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		close(conn);
		return player;
	}

	public List<Player> selectPlayerByTeam(String teamName) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select p.num, p.name, p.backnum, p.teamnum, t.name "
				+ "from player p join team t on p.teamnum = t.num" + " where p.name = ?";
		List<Player> playerList = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teamName);
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					playerList.add(
							new Player(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		close(conn);
		return playerList;
	}
}