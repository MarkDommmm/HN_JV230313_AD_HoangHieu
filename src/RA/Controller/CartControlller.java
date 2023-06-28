package RA.Controller;

import RA.Model.CartItem;
import RA.Model.Product;
import RA.service.CartService;

import java.util.List;

public class CartControlller {
    CartService cartService = new CartService();

    public List<CartItem> getAll() {
        return cartService.getAll();
    }

    public int getSize() {
        return cartService.getSize();
    }

    public void save(Product cartItem, int quantity) {
        cartService.addToCart(cartItem, quantity);
    }


    public void delete(int id) {
        cartService.removeCartItem(id);
    }

    public void deleteAll() {cartService.removeAllCartItems();}

    public void displayCart() {cartService.displayAllProducts();}

    public int newCartId() {
        return cartService.newCartItemId();
    }

    public void updateCart(int cartItemId, int newQuantity) {
        cartService.updateCartItemQuantity(cartItemId, newQuantity);
    }
}
