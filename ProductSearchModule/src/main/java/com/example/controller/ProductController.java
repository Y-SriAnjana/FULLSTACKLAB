package com.example.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.model.Product;
import com.example.repository.ProductRepo;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepo repo;

    // a. Category-based search
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    // b. Price filter
    @GetMapping("/filter")
    public List<Product> filterByPrice(
            @RequestParam double min,
            @RequestParam double max)
 {
        return repo.findByPriceBetween(min, max);
    }

    // c. Sorted products
    @GetMapping("/sorted")
    public List<Product> getSortedProducts() 
{
        return repo.sortByPrice();
    }

    // d. Expensive products
    @GetMapping("/expensive/{price}")
    public List<Product> expensiveProducts(@PathVariable double price)
 {
        return repo.findExpensiveProducts(price);
    }
}

