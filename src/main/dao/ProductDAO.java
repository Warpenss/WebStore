package main.dao;

import java.util.List;
import main.model.Product;

public interface ProductDAO {
    void addProduct(Product product );
    void deleteProduct( int productId );
    void updateProduct( Product product );
    List<Product> getAllProducts();
    Product getProductById( int productId );
}
