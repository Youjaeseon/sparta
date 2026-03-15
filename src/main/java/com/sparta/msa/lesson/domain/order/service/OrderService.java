package com.sparta.msa.lesson.domain.order.service;

import com.sparta.msa.lesson.domain.order.entity.Order;
import com.sparta.msa.lesson.domain.order.repository.OrderRepository;
import com.sparta.msa.lesson.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j // => log4j
@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;

  public void getByUserId() {
    Order order = orderRepository.findById(1L).get();
    //작업 중..

    // TODO : 해당 주문자에 이름을 필요함!
    User user = order.getUser();
    log.info("주문자의 이름 : {} ", user.toString());

  }

}
