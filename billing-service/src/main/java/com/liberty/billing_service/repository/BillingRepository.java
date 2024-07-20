package com.liberty.billing_service.repository;

import com.liberty.billing_service.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class BillingRepository {
    private static final List<BillCategory> categories = new ArrayList<>();
    private static final List<Bank> bankList = new ArrayList<>();
    private static final List<Biller> billers = new ArrayList<>();
    private static final List<Product> products = new ArrayList<>();
    private static final List<Payment> payments = new ArrayList<>();

    static {

       // Bank list
        bankList.add(new Bank(309, "First Bank Plc"));
        bankList.add(new Bank(490, "Inter Switch"));
        bankList.add(new Bank(301, "Access Bank Plc"));
        bankList.add(new Bank(308, "United Bank Of Africa"));



        // Initialize categories
        categories.add(new BillCategory(1L, "Electricity"));
        categories.add(new BillCategory(2L, "Data Services"));
        categories.add(new BillCategory(3L, "Subscription Services"));

        // Initialize billers
        billers.add(new Biller(1L, "Electric Co.", 1L));
        billers.add(new Biller(2L, "Power Ltd.", 1L));
        billers.add(new Biller(3L, "Aritime Data", 2L));
        billers.add(new Biller(4L, "Broadband Inc.", 2L));
        billers.add(new Biller(5L, "Subscription Hub", 3L));

        // Initialize products
        products.add(new Product(1L, "Monthly Electricity", 1L));
        products.add(new Product(2L, "Quarterly Electricity", 1L));
        products.add(new Product(3L, "Aritime Data Plan", 2L));
        products.add(new Product(4L, "Monthly Data Plan", 2L));
        products.add(new Product(5L, "Annual Subscription", 3L));
    }

    public List<BillCategory> getCategories() {
        return new ArrayList<>(categories);
    }

    public List<Biller> getBillers(Long categoryId) {
        return billers.stream()
                .filter(biller -> biller.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
    }

    public List<Product> getProducts(Long categoryId) {
        return products.stream()
                .filter(product -> product.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
    }

    public Payment submitPayment(Payment payment) {
        payment.setId((long) (payments.size() + 1));
        payments.add(payment);
        return payment;
    }



    public List<Bank> getBanks() {
          return new ArrayList<>(bankList);
    }
}
