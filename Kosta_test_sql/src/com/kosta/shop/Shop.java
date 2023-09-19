package com.kosta.shop;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kosta.order.Order;
import com.kosta.product.Goods;

public class Shop {
	public static Connection getConnection() {
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
	public int addProduct(Goods goods) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "insert into goods (code, name, price, stock, category) values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getCode());
			pstmt.setString(2, goods.getName());
			pstmt.setInt(3, goods.getPrice());
			pstmt.setInt(4, goods.getStock());
			pstmt.setString(5, goods.getCategory());
			cnt = pstmt.executeUpdate();
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
	public void stockUpdate(String code, int amount) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "update goods set stock=stock-? where code = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, amount);
			pstmt.setString(2, code);
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
	}
	
	public int order(Order order) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		stockUpdate(order.getProductCode(),order.getAmount());
		String sql = "insert into orders (no, customer, productcode, amount, iscanceled) values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getNo());
			pstmt.setString(2, order.getCustomer());
			pstmt.setString(3, order.getProductCode());
			pstmt.setInt(4, order.getAmount());
			pstmt.setBoolean(5, order.isCanceled());
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
		return order.getNo();
	}

	public Goods findProductByCode(String code) {
		Connection conn = getConnection();
		Goods goods = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select code, name, price, stock, category"
				+ " from goods" + " where code = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				goods = new Goods(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
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
		return goods;
	}

	public void printAllProductInfo() {
		Connection conn = getConnection();
		List<Goods> accs = selectAllProductList(conn);
		
		for(Goods acc :accs) {
			System.out.println(acc);
		}
		close(conn);
	}
	
	public static List<Goods> selectAllProductList(Connection conn) {
		List<Goods> accList = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from goods";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs!=null) {
				while(rs.next()) {
					String code = rs.getString(1);
					String name = rs.getString(2);
					Integer price = rs.getInt(3);
					Integer stock = rs.getInt(4);
					String category = rs.getString(5);
					accList.add(new Goods(code, name, price, stock, category));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return accList;
	}

	public void printAllOrderInfo() {
		Connection conn = getConnection();
		List<Order> accs = selectAllOrderList(conn);
		
		for(Order acc :accs) {
			System.out.println(acc);
		}
		close(conn);
	}
	
	public static List<Order> selectAllOrderList(Connection conn) {
		List<Order> accList = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from orders";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs!=null) {
				while(rs.next()) {
					Integer no = rs.getInt(1);
					String customer = rs.getString(2);
					String productcode = rs.getString(3);
					Integer amount = rs.getInt(4);
					Boolean iscanceled = rs.getBoolean(5);
					accList.add(new Order(no, customer, productcode, amount, iscanceled));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return accList;
	}

	public Order findOrderByNo(int orderNo) {
		Connection conn = getConnection();
		Order order = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select no, customer, productCode, amount, iscanceled from orders where no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderNo);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				order = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5));
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
		return order;
	}

	public Order cancelOrder(int orderNo) {
		Connection conn = getConnection();
		Order order = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select no, customer, productCode, amount, iscanceled"
				+ " from order" + " where no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderNo);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				order = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5));
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
		return order;
	}

	public Order printOrderDetailsByCustomerAndIsCanceled(String customer, String state) {
		return null;
	}


	//구현해야 하는 부분: ApplicationMain.java 오류 없이 작동하도록 필요한 모든 메서드를 구현한다.
	
	
	
}
