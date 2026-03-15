package com.sparta.msa.lesson.domain.order.service;

import com.sparta.msa.lesson.domain.order.entity.Order;
import com.sparta.msa.lesson.domain.order.repository.OrderRepository;
import com.sparta.msa.lesson.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j // => log4j
@Service
@RequiredArgsConstructor
public class OrderService {

  private final UserRepository userRepository;
  private final OrderRepository orderRepository;

  public void getById(Long id) {
    // 주문 리스트 검색
    // TODO : 특정 주문 검색
    Order order = orderRepository.findById(1d).get();
    // SELECT * FROM orders o WHERE o.id = 'id' ;
    // JPA 객체와 테이블 orders --> 객체 order
    // user에 LAZY 설정이 있으면 user는 프록시 객체로 구현된다.

  }

  public void getByUserId() {
    // 주문 리스트 검색
    // TODO : 특정 주문 검색

  }

}
