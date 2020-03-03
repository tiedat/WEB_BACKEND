package com.codegym.view;

import com.codegym.controller.ProductController;
import com.codegym.model.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            ProductView.menu();
            choice = input.nextInt();
            switch (choice) {
                case 1: {
                    List<Product> productList = productController.getProducts();
                    for (Product p : productList) {
                        System.out.println("ID:" + p.getId() + " NAME:" + p.getName());
                    }
                    break;
                }
                case 2: {
                    Product product = ProductView.productForm();
                    productController.addProduct(product);
                    break;
                }
                case 0: {
                    System.out.println("Thoat.");
                    break;
                }
            }
        } while (choice != 0);

    }

    public static void menu() {
        System.out.println("-------------------------------------------");
        System.out.println("Quan ly san pham");
        System.out.println("1. Hien thi danh sach san pham");
        System.out.println("2. Them moi san pham");
        System.out.println("3. Sua thong tin san pham");
        System.out.println("4. Xoa san pham");
        System.out.println("5. Tim san pham theo ten");
        System.out.println("6. Sap xep san pham theo gia");
        System.out.println("Nhap vao lua chon:");
    }

    public static Product productForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap name:");
        String name = scanner.nextLine();

        Product product = new Product(id, name);
        return product;

    }
}
