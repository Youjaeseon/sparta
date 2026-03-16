package com.sparta.msa.lesson.domain.user.service;

import com.sparta.msa.lesson.domain.order.entity.Order;
import com.sparta.msa.lesson.domain.order.repository.OrderRepository;
import com.sparta.msa.lesson.domain.user.entity.User;
import com.sparta.msa.lesson.domain.user.repository.UserRepository;
import com.sparta.msa.lesson.domain.user.repository.UserRepositoryImpl;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

  // 개선점 1. 인스턴스의 생성과 해제를 최소화 해야한다.
  // 개선점 2. 수정 작업한 코드만 고치는 것이 아닌 참조를 하고 있는 모든 클래스를 수정하는 상황
  private final UserRepository userRepository = new UserRepositoryImpl() {
    @Override
    public Optional<User> findByEmail(String email) {
      return Optional.empty();
    }

    public void save() {
      User user = userRepository.findById(1L).get();
    }

    @Override
    public Optional<User> finduserWithOrders() {
      return Optional.empty();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends User> S saveAndFlush(S entity) {
      return null;
    }

    @Override
    public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
      return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<User> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public User getOne(Long aLong) {
      return null;
    }

    @Override
    public User getById(Long aLong) {
      return null;
    }

    @Override
    public User getReferenceById(Long aLong) {
      return null;
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example) {
      return List.of();
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
      return List.of();
    }

    @Override
    public <S extends User> List<S> saveAll(Iterable<S> entities) {
      return List.of();
    }

    @Override
    public List<User> findAll() {
      return List.of();
    }

    @Override
    public List<User> findAllById(Iterable<Long> longs) {
      return List.of();
    }

    @Override
    public <S extends User> S save(S entity) {
      return null;
    }

    @Override
    public Optional<User> findById(Long aLong) {
      return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
      return false;
    }

    @Override
    public long count() {
      return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<User> findAll(Sort sort) {
      return List.of();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
      return null;
    }

    @Override
    public <S extends User> Optional<S> findOne(Example<S> example) {
      return Optional.empty();
    }

    @Override
    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
      return null;
    }

    @Override
    public <S extends User> long count(Example<S> example) {
      return 0;
    }

    @Override
    public <S extends User> boolean exists(Example<S> example) {
      return false;
    }

    @Override
    public <S extends User, R> R findBy(Example<S> example,
        Function<FetchableFluentQuery<S>, R> queryFunction) {
      return null;
    }
  };
  private final OrderRepository orderRepository;

  public void getUser() {
    User user = userRepository.findById(1L).get();
    // 처리중 ...

    // TODO : 해당 유저에 주문 내역도 같이 Response 해줘!
    List<Order> orders = orderRepository.findByUser(user);
    for (Order order : orders) {
      log.info("주문 상태 : {}", order.getStatus());
    }

    // TODO : 특정 유저에 주문 내역을 같이 검색하고 싶다!
    // SELECT * FROM users.u JOIN orders o ON o.user_id = u.id WHERE u.id = 1;
    // row의 개수는 order의 개수랑 동일함.

  }

}
