package RA.service;

import RA.Model.Catalog;
import RA.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IService<Product, String> {
    private List<Product> productList;

    public ProductService() {
        productList = new ArrayList<>();
        productList.add(new Product("P0001", "T-shirt", 1000.00, "Note", 10, new Catalog(1,"Shirt"), true));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public int getSize() {
        return productList.size();
    }

    public Product findById(String id) {
        for (Product product : productList) {
            if (product.getProductId().equals(id)) {
                System.out.println(product);
                return product;
            }
        }
        System.out.println("Sản phẩm không tồn tại");
        return null;
    }

    @Override
    public void delete(String productId) {
        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                productList.remove(product);
                System.out.println("Sản phẩm đã được xóa thành công rồi nhé");
                return;
            }
        }
        System.out.println("Sản phẩm không tồn tại");
    }

    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }


}
