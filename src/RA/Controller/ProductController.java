package RA.Controller;

import RA.Model.Product;
import RA.service.ProductService;

import java.util.List;

public class ProductController {
    private ProductService productService = new ProductService();

    public List<Product> getProductAll() {
        return productService.getProductList();
    }
    public  int getSize(){
        return productService.getSize();
    }
    public  void  save(Product product){
        productService.save(product);
    }
    public Product findById(String id){
        return  productService.findById(id);
    }
    public void delete(String id){
        productService.delete(id);
    }
}
