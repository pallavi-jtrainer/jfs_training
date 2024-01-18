package com.springpeople.jdbcdemo.connectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.springpeople.jdbcdemo.entity.Products;

public class ProductsDb {

	private static int getLastRow() {
		String sql = "SELECT * FROM PRODUCTS ORDER BY PRODUCTID DESC LIMIT 1";
		
		int res = 0;
		
		Connection con = DbConnection.createConnection();
		
		if(con != null) {
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					res = rs.getInt("PRODUCTID");
				}
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		return res;
		
	}
	
	public static int createProduct(Products p) {
		String sql = "INSERT INTO PRODUCTS (PRODUCTID, PRODUCTNAME, UNITPRICE) VALUES (?, ?, ?)";
		int res = 0;
		
		Connection con = DbConnection.createConnection();
		
		if(con != null) {
			try {
				int id = getLastRow();
				if(id == 0) {
					id = 1;
				} else {
					++id;
				}
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ps.setString(2, p.getProductName());
				ps.setDouble(3, p.getUnitPrice());
				
				res = ps.executeUpdate();   //dml statements only
				//con.commit(); //in case auto-commit is off
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return res;
	}
	
	public static List<Products> retrieveAll() {
		String sql = "SELECT * FROM PRODUCTS";
		
		List<Products> products = new ArrayList<Products>();
		
		Connection con = DbConnection.createConnection();
		
		if(con != null) {
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					Products p = new Products();
					p.setProductId(rs.getInt("ProductId"));
					String name = rs.getString("PRODUCTNAME");
					p.setProductName(name);
					p.setUnitPrice(rs.getDouble("UNITPRICE"));
					
					products.add(p);
				}
				
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return products;
	}
	
	public static Products getProductById(int id) {
		Products p = new Products();
		
		String sql = "SELECT * FROM PRODUCTS WHERE PRODUCTID = ?";
		
		Connection con = DbConnection.createConnection();
		
		if(con != null) {
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					p.setProductId(rs.getInt("ProductId"));
					String name = rs.getString("PRODUCTNAME");
					p.setProductName(name);
					p.setUnitPrice(rs.getDouble("UNITPRICE"));
				}
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}		
		}
		
		return p;		
	}
	
}
