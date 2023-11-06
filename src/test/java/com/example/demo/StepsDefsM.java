package com.example.demo;


import com.example.demo.controller.ProductController;
import com.example.demo.entity.Cart;
import com.example.demo.entity.CartItem;
import com.example.demo.entity.Product;
import com.example.demo.service.CartItemService;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.security.Principal;
import java.util.UUID;

public class StepsDefsM {

    private Product product;
    private Cart cart;
    private CartItem cartItem;

    private CartService cartService;

    private CartItemService cartItemService;

    private ProductService productService;

    protected ProductController productController;


    @Given("the user is on the sign-up page")
    public void givenUserIsOnSignUpPage() {
        // Navigate to the sign-up page
    }

    @When("the user enters valid registration information")
    public void whenUserEntersValidInfo() {
        // Enter valid registration information
    }

    @When("submits the registration form")
    public void whenUserSubmitsForm() {
        // Submit the form
    }

    @Then("the user should see a Successfully signed up! Please login")
    public void thenUserIsRedirected() {
        // Verify user is redirected to the home page
    }


    @When("the user enters invalid registration information")
    public void whenUserEntersInvalidInfo() {
        // Enter invalid registration information
    }

    @Then("the user should see an error message")
    public void thenUserSeesErrorMessage() {
        // Verify error message is displayed
    }

    @Then("the user should remain on the sign-up page")
    public void thenUserRemainsOnSignUpPage() {
        // Verify the user is still on the sign-up page
    }

    //add product to cart
    @Given("the store is ready to service customers")
    public void the_store_is_ready_to_service_customers() {

    }

    @Given("a product id {string}")
    public void product_in_stock(UUID productId) {
//        productController.addToCart(productId, principal);
    }

}
