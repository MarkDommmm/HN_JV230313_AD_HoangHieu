package RA.Model;

import RA.Config.InputMethods;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private double productPrice;
    private String description;
    private int stock;
    private Catalog catalog;
    private boolean status = true;

    public Product() {
    }

    public Product(String productId, String productName, double productPrice, String description, int stock, Catalog catalog, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.description = description;
        this.stock = stock;
        this.catalog = catalog;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Xin mời nhập ID sản phẩm bắt đầu bằng chữ P và thêm 4 ký tự số");
        this.productId = InputMethods.getString();
        validateProductId(productId);
        System.out.println(" nhập tên sản phẩm");
        this.productName = InputMethods.getString();
        System.out.println("nhập giá: ");
        this.productPrice = InputMethods.getDouble();
        System.out.println("Nhập mô tả: ");
        this.description = InputMethods.getString();
        System.out.println("Nhập số lượng sản phẩm trong kho: ");
        this.stock = InputMethods.getInteger();

    }

    private String validateProductId(String productId) {
        if (productId == null || !productId.matches("P\\d{4}")) {
            throw new IllegalArgumentException("Mã sản phẩm không hợp lệ. Mã sản phẩm phải bắt đầu bằng chữ P và theo sau là 4 chữ số.");
        }
        return productId;
    }

    public void displayData() {
        System.out.println("---------------------------------------------------");
        System.out.println("ID sản phẩm: " + productId
                + " ||Tên sản phẩm: " + productName
                + " ||Giá sản phẩm " + productPrice
                + " ||Mô tả: " + description
                + " ||Kho: " + stock
                + " ||Danh mục: " + catalog.getCatalogName()
                + " ||Trạng thái: " + (status ? " Bán" : "Không bán"));
    }

}
