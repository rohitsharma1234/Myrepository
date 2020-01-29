package com.cts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

//import com.springsource.tcserver.serviceability.request.DataSource;

import java.sql.ResultSet;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

@Repository
public class ProductDao {
	@Autowired
private JdbcTemplate jdbc;
private DataSource ds;
  

public void setjdbc(JdbcTemplate jdbc) {
	this.jdbc=jdbc;
}
public int AddProduct(Product product) {
	jdbc=new JdbcTemplate(ds);
	int Storedstatus=jdbc.update("INSERT INTO PRODUCT VALUES(?,?,?,? )", new Object[] {product.getId(),product.getName(),product.getQuantity(),product.getPrice()});
   System.out.println(Storedstatus);
   return product.getId();
}
public Product getByID(int Id) {
	jdbc=new JdbcTemplate(ds);
	String sql="SELECT * From product where  Id=? ";
	Product product=(Product)jdbc.queryForObject(sql,new Object[] {Id},
	new RowMapper<Product>() {
		@Override
		
		public Product MapRow(ResultSet rs,int rownuM) throws SQLException{
			Product product=new Product();
			product.setId(rs.getId(1));
			product.setName(rs.getName(2));
			product.setQuantity(rs.getQuantity(3));
			product.setPrice(rs.getPrice(4));
			
			return product;
		}
		
		
		
		
		
	
});
	
return product;
}}

