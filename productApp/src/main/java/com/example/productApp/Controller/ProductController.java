package com.example.productApp.Controller;

import com.example.productApp.Model.Product;
import com.example.productApp.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/products")
@SessionAttributes("product")
public class ProductController {

    private final ProductService service;
    public ProductController(ProductService service) {
        this.service = service;
    }
    @ModelAttribute("product")
    public Product getProduct(){
        return new Product();
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
    @GetMapping("/list")
    public String viewProducts(Model model){
        model.addAttribute("products",service.getAllProducts());
        return "product-list";
    }

    @GetMapping("/add")
    public String showAddForm(){
        return "product-form";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product,
                              BindingResult result, SessionStatus status){
        if (result.hasErrors()) {
            return "product-form"; // redisplay form if validation fails
        }
        service.saveProduct(product);
        status.setComplete(); // clears session attribute
        return "redirect:/products/list"; // redirect to product list

    }

    @GetMapping("/edit/{id}")
    public String editProducts(@PathVariable long id,Model model){
        Product product = service.getProductById(id)
        .orElseThrow(() -> new RuntimeException("Product not Found"));
        model.addAttribute("product",product);
        return "product-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        if(service.getProductById(id).isEmpty()){
            throw new RuntimeException("Cannot Delete. Product not Found");
        }
        service.deleteProduct(id);
        return "redirect:/product/list";
    }

    @GetMapping("/count")
    @ResponseBody
    public String getProductCount(){
        return "total Products: "+ service.getAllProducts().size();
    }
//Controller level exception handling
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException ex,Model model){
        model.addAttribute("errorMessage",ex.getMessage());
        return "error-page";
    }



}
