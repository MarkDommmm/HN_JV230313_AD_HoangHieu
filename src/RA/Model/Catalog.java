package RA.Model;

import RA.Config.InputMethods;

import java.util.Scanner;

public class Catalog {
    private int catalogId;
    private String catalogName;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    @Override
    public String toString() {
        return "Catalog ID: " + catalogId + ", Catalog Name: " + catalogName;
    }

    public void inputData() {
        System.out.println("Nhập tên danh mục cần thêm");
        this.catalogName = InputMethods.getString();
    }

    public void displayData() {
        System.out.println("---------------------------------------");
        System.out.println("ID danh mục " + getCatalogId() + " ||Tên danh mục " + getCatalogName());

    }
}
