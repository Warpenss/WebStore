package main.model;

public class Product {

    private int productId;
    private String productName;
    private String productDescription;
    private String productImage;
    private int productPrice;

    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public String getProductImage() {
        return productImage;
    }
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
    public int getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
    @Override
    public String toString() {
        return "Student [productId=" + productId + ", productName=" + productName
                + ", productDescription=" + productDescription + ", productImage=" + productImage + ", productPrice="
                + productPrice + "]";
    }
}
