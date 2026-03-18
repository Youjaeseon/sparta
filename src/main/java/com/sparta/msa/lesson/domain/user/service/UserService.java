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
    // 20개씩 묶어서 쿼리가 실행
    // 처리중 ..!

    // TODO : 해당 유저의 주문 내역도 같이 Response
    List<Order> orders = orderRepoository.findByUser(user);
    for (Order order : orders) {
      log.info("주문 상태 : {}", order.toString());
    }

    //TODO : 특정 유저의 주문 내역을 같이 검색하고 싶을 때
    // SELECT * FROM users u JOIN orders o ON o.user_id = u.id WHERE u_id = 1;
    // row의 개수는 order의 개수랑 동일함
    User user2 = userRepository.finduserWithOrders(1L).get();
  }
}