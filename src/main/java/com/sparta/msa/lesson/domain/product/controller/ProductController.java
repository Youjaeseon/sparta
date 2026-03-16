package com.sparta.msa.lesson.domain.product.controller;

import com.sparta.msa.lesson.domain.product.entity.Product;
import com.sparta.msa.lesson.domain.product.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController// API 요청을 가장 먼저 받는 클래스로 인식 -> API 스펙이 정의된 곳.
@RequiredArgsConstructor
@RequestMapping("/api/products") // API 매핑 지정
public class ProductController {

  private final ProductService productService;

  // API [GET] /api/products?name="전화기"   // HTTP 상태 코드를 지정하지 않으면 = > 200
  @GetMapping("/api/products/{id}")
  public List<Product> searchProducts(
      @RequestParam(name = "name") String name) { // API [GET] /api/products/{id}
    return List.of();

  }

  @PostMapping("/api/proudcts")
  @ResponseStatus(HttpStatus.CREATED) // <- HTTP 상태코드 지정이 가능하다.
  public void create(@RequestBody Product product) {

    return;
  }

  @PutMapping("/api/products")
  public Product update(@RequestBody Product product) {
    return;
  }

  @DeleteMapping("/api/products/{id}")
  public void delete(@PathVariable Long id) {
    return;
  }


}
