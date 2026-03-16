package com.sparta.msa.lesson.domain.product.controller;

import com.sparta.msa.lesson.domain.product.entity.Product;
import com.sparta.msa.lesson.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController// API 요청을 가장 먼저 받는 클래스로 인식 -> API 스펙이 정의된 곳.
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/api/products/{id}")
  public Product findById(@PathVariable Long id) { // API [GET] /api/products/{id}
    return Product.builder().build();

  }

}
