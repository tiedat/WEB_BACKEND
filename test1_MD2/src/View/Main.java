package View;

import Controller.ProductController;
import Model.Product;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        List<Product> productList = productController.findAll();
        int choice;
        do {
            menu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: { //hien thi
                    for (Product product : productList) {
                        System.out.println(product.toString());
                    }
                    break;
                }
                case 2: { // them moi
                    Product product = productFormAdd();
                    if (productController.checkId(product.getId()) == -1) {
                        productController.add(product);
                    } else {
                        System.out.println("Da co ID nay");
                    }
                    break;
                }
                case 3: { // sua
                    System.out.println("Nhap ID sp can sua: ");
                    int id = scanner.nextInt();
                    int index = productController.checkId(id);
                    if (index != -1) {
                        Product product = productFromUpdate(productList.get(index));
                        productController.update(id, product);
                    } else {
                        System.out.println("Khong tim thay san pham !");
                    }
                    break;
                }
                case 4: { // xoa
                    System.out.println("Nhap ID sp muon xoa: ");
                    int id = scanner.nextInt();
                    if (productController.checkId(id) != -1) {
                        productController.delete(id);
                    } else {
                        System.out.println("Khong tim thay san pham !");
                    }
                    break;
                }
                case 5: { // tim theo ten
                    System.out.println("Sp ban muon tim: ");
                    String nameSP = scanner.nextLine();
                    Product product = productController.findByName(nameSP);
                    if (product != null) {
                        System.out.println(product.toString());
                    } else {
                        System.out.println("Khong co sp can tim !");
                    }
                    break;
                }
                case 6: { // sap xep tang dan
                    productController.sortPriceIncresing();
                    for (Product product : productList) {
                        System.out.println(product.toString());
                    }
                    break;
                }
                case 7: { // sap xep giam dan
                    productController.sortPriceDecresing();
                    for (Product product : productList) {
                        System.out.println(product.toString());
                    }
                    break;
                }
                case 0:
                    System.exit(0);
            }
        } while (true);
    }

    static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("-------------------------------------------");
        System.out.println("Quan ly san pham");
        System.out.println("1. Hien thi danh sach san pham");
        System.out.println("2. Them moi san pham");
        System.out.println("3. Sua thong tin san pham");
        System.out.println("4. Xoa san pham");
        System.out.println("5. Tim san pham theo ten");
        System.out.println("6. Sap xep san pham theo gia tang dan");
        System.out.println("7. Sap xep san pham theo gia giam dan");
        System.out.println("0. Thoat");
        System.out.println("Nhap vao lua chon:");
    }

    public static Product productFormAdd() {
        System.out.println("Nhap id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhap name: ");
        String name = scanner.nextLine();

        System.out.println("Nhap gia: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Nhap trang thai: ");
        boolean status = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("Nhap dac diem: ");
        String description = scanner.nextLine();

        return new Product(id, name, price, status, description);
    }

    public static Product productFromUpdate(Product product) {
        scanner.nextLine();
        System.out.println("Nhap NAME moi: ");
        String newName = scanner.nextLine();
        product.setName(newName);

        System.out.println("Nhap PRICE moi: ");
        double newPrice = scanner.nextDouble();
        product.setPrice(newPrice);
        scanner.nextLine();

        System.out.println("Nhap STATUS moi: ");
        boolean newStatus = scanner.nextBoolean();
        product.setStatus(newStatus);
        scanner.nextLine();

        System.out.println("Nhap DESCRIPTION moi: ");
        String newDescription = scanner.nextLine();
        product.setDescription(newDescription);

        return product;
    }
}

