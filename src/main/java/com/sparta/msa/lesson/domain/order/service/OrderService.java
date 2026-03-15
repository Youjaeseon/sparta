package com.sparta.msa.lesson.domain.order.service;

import com.sparta.msa.lesson.domain.order.entity.Order;
import com.sparta.msa.lesson.domain.order.repository.OrderRepository;
import com.sparta.msa.lesson.domain.user.entity.User;
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
    Order order = orderRepository.findById(1L).get();
    // SELECT * FROM orders o WHERE o.id = 'id' ;
    // JPA 객체와 테이블 orders --> 객체 order
    // user에 LAZY 설정이 있으면 user는 프록시 객체로 구현된다.
    // user는 null 은 아니다! => 프록시 객체가 들어간 상태

    //TODO : 주문자 명을 알고 싶다..!
    User user = order.getUser();
    // SELECT * FROM users u WHERE u.id = 1L;
    // 결과 : 개발자가 연관관계 테이블이 필요한 시점에 호응함
    // N+1의 근본적인 문제는 해결할 수 없지만 불필요한 쿼리는 막을 수 있다.

  }

  public void getByUserId() {
    // 주문 리스트 검색
    // TODO : 특정 주문 검색

  }

}
