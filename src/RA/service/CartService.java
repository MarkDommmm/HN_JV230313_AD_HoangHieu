package RA.service;

import RA.Model.CartItem;
import RA.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private List<CartItem> cartItems;

    public CartService() {
        cartItems = new ArrayList<>();

    }

    public int getSize() {
        return cartItems.size();
    }

    public List<CartItem> getAll() {
        return cartItems;
    }

    public void displayAllProducts() {
        for (CartItem cartItem : cartItems) {
            System.out.println("Mã sản phẩm: " + cartItem.getCartItemId());
            System.out.println(" Tên sản phẩm : " + cartItem.getProduct().getProductName());
            System.out.println(" Giá : " + cartItem.getPrice());
            System.out.println(" Số lượng : " + cartItem.getQuantity());
            System.out.println("---------------------------------------");
        }
    }

    public void addToCart(Product product, int quantity) {
        boolean found = false;
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getProductId().equals(product.getProductId())) {
                int newQuantity = cartItem.getQuantity() + quantity;
                if (newQuantity <= product.getStock()) {
                    cartItem.setQuantity(newQuantity);
                    System.out.println("Sản phẩm đã có trong giỏ hàng. Số lượng đã được cập nhật.");
                } else {
                    System.out.println("Sản phẩm không đủ số lượng trong kho.");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            if (quantity <= product.getStock()) {
                CartItem cartItem = new CartItem(
                        newCartItemId(),
                        product,
                        product.getProductPrice() * quantity,
                        quantity
                );
                cartItems.add(cartItem);
                System.out.println("Sản phẩm đã được thêm vào giỏ hàng.");
            } else {
                System.out.println("Sản phẩm không đủ số lượng trong kho.");
            }
        }
    }

    public int newCartItemId() {
        return cartItems.size() + 1;
    }

    public void removeCartItem(int cartItemId) {
        for (CartItem cartItem : cartItems) {
            System.out.println(cartItem.getCartItemId());
            if (cartItem.getCartItemId() == cartItemId) {
                cartItems.remove(cartItem);
                System.out.println("Sản phẩm đã được xóa khỏi giỏ hàng.");
                break;
            }
        }
        System.out.println("Sản phẩm không tồn tại");
    }

    public void removeAllCartItems() {
        cartItems.clear();
        System.out.println("Đã xóa toàn bộ sản phẩm trong giỏ hàng.");
    }

    public void updateCartItemQuantity(int cartItemId, int newQuantity) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getCartItemId() == cartItemId) {
                Product product = cartItem.getProduct();
                int stock = product.getStock();
                int currentQuantity = cartItem.getQuantity();

                if (newQuantity <= stock + currentQuantity) {
                    cartItem.setQuantity(newQuantity);
                    cartItem.setPrice(newQuantity * product.getProductPrice());
                    System.out.println("Số lượng sản phẩm trong giỏ hàng đã được cập nhật.");
                } else {
                    System.out.println("Sản phẩm không đủ số lượng trong kho.");
                }
                break;
            }
        }
    }


}
