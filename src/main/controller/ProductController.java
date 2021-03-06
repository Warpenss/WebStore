package main.controller;

import main.dao.ProductDAO;
import main.dao.ProductDAOImplementation;
import main.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductController")
public class ProductController extends HttpServlet {
    private ProductDAO dao;
    private static final long serialVersionUID = 1L;
    public static final String lIST_PRODUCT = "/listProduct.jsp";
    public static final String INSERT_OR_EDIT = "/product.jsp";
    public static final String CATALOG = "/catalog.jsp";
    public static final String BUY = "/buy.jsp";

    public ProductController() {
        dao = new ProductDAOImplementation();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = null;
        String productName = "No name";
        String productDescription = "No description";
        String productImage = "No image";
        int productPrice = 0;

        if (!request.getParameter("productId").equals("")) {
            productId = request.getParameter("productId");
        }
        if (!request.getParameter("productName").equals("")) {
            productName = request.getParameter("productName");
        }

        if (!request.getParameter("productDescription").equals("")) {
            productDescription = request.getParameter("productDescription");
        }

        if (!request.getParameter("productImage").equals("")) {
            productImage = request.getParameter("productImage");
        }

        if (!request.getParameter("productPrice").equals("")) {
            productPrice = Integer.parseInt(request.getParameter("productPrice"));
        }

        Product product = new Product();

        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setProductImage(productImage);
        product.setProductPrice(productPrice);

        if(productId == null)
            dao.addProduct(product);
        else {
            product.setProductId(Integer.parseInt(productId));
            dao.updateProduct(product);
        }

        RequestDispatcher view = request.getRequestDispatcher( lIST_PRODUCT );
        request.setAttribute("products", dao.getAllProducts());
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter( "action" );

        if( action.equalsIgnoreCase( "delete" ) ) {
            forward = lIST_PRODUCT;
            int productId = Integer.parseInt( request.getParameter("productId") );
            dao.deleteProduct(productId);
            request.setAttribute("products", dao.getAllProducts() );
        }
        else if( action.equalsIgnoreCase( "edit" ) ) {
            forward = INSERT_OR_EDIT;
            int productId = Integer.parseInt(request.getParameter("productId"));
            Product product = dao.getProductById(productId);
            request.setAttribute("product", product);
        }
        else if( action.equalsIgnoreCase( "insert" ) ) {
            forward = INSERT_OR_EDIT;
        }
        else if (action.equalsIgnoreCase("listProduct")){
            forward = lIST_PRODUCT;
            request.setAttribute("products", dao.getAllProducts() );
        }
        else if( action.equalsIgnoreCase( "buy" ) ) {
            forward = BUY;
            int productId = Integer.parseInt(request.getParameter("productId"));
            Product product = dao.getProductById(productId);
            request.setAttribute("product", product);
        }
        else {
            forward = CATALOG;
            request.setAttribute("products", dao.getAllProducts());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}
