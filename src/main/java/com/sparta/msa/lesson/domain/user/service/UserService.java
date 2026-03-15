package com.sparta.msa.lesson.domain.user.service;

import com.sparta.msa.lesson.domain.order.entity.Order;
import com.sparta.msa.lesson.domain.order.repository.OrderRepository;
import com.sparta.msa.lesson.domain.user.entity.User;
import com.sparta.msa.lesson.domain.user.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final OrderRepository orderRepository;

  public void getUser() {
    User user = userRepository.findById(1L).get();
    // 처리중 ...

    // TODO : 해당 유저에 주문 내역도 같이 Response 해줘!
    List<Order> orders = orderRepository.findByUser(user);
    for (Order order : orders) {
      log.info("주문 상태 : {}", order.getStatus());

    }
  }

}
