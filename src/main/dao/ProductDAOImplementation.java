package main.dao;

import main.model.Product;
import main.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImplementation implements ProductDAO {
    private Connection conn;

    public ProductDAOImplementation() {
        conn = DBUtil.getConnection();
    }

    public void addProduct(Product product ) {
        try {
            String query = "insert into products (name, description, image, price) values (?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString( 1, product.getProductName() );
            preparedStatement.setString( 2, product.getProductDescription() );
            preparedStatement.setString( 3, product.getProductImage() );
            preparedStatement.setInt( 4, product.getProductPrice() );
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteProduct( int productId ) {
        try {
            String query = "delete from products where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateProduct( Product product ) {
        try {
            String query = "update products set name=?, description=?, image=?, price=? where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, product.getProductName() );
            preparedStatement.setString( 2, product.getProductDescription() );
            preparedStatement.setString( 3, product.getProductImage() );
            preparedStatement.setInt( 4, product.getProductPrice() );
            preparedStatement.setInt(5, product.getProductId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from products" );
            while( resultSet.next() ) {
                Product product = new Product();
                product.setProductId( resultSet.getInt( "id" ) );
                product.setProductName( resultSet.getString( "name" ) );
                product.setProductDescription( resultSet.getString( "description" ) );
                product.setProductImage( resultSet.getString( "image" ) );
                product.setProductPrice( resultSet.getInt( "price" ) );
                products.add(product);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    @Override
    public Product getProductById(int productId) {
        Product product = new Product();
        try {
            String query = "select * from products where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                product.setProductId( resultSet.getInt( "id" ) );
                product.setProductName( resultSet.getString( "name" ) );
                product.setProductDescription( resultSet.getString( "description" ) );
                product.setProductImage( resultSet.getString( "image" ) );
                product.setProductPrice( resultSet.getInt( "price" ) );
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }


}
