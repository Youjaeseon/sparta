package com.sparta.msa.lesson.domain.order.entity;

import com.sparta.msa.lesson.domain.user.entity.User;
import com.sparta.msa.lesson.global.constants.enums.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity // 이 클래스는 JPA가 관리하는 엔티티입니다.
@Getter // Lombok: Getter 메서드를 자동 생성합니다.
@DynamicInsert // 값이 null이 아닌 필드만으로 INSERT 쿼리를 생성합니다.
@DynamicUpdate // 변경된 필드만으로 UPDATE 쿼리를 생성합니다.
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "orders") // orders와 매핑
public class Order {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  User user;

  @OneToMany(mappedBy = "order")
  List<OrderProduct> orderProducts = new ArrayList<>();

  //돈 계산이나 수치에 예민할 때
  @Column(nullable = false)
  BigDecimal totalPrice;

  @Column(nullable = false, updatable = false)
  @CreationTimestamp
  OrderStatus status;

  @CreationTimestamp // 엔티티가 생성될 때의 시간이 자동으로 기록됩니다.
  @Column(nullable = false, updatable = false)
  LocalDateTime createdAt;

  @Column
  @UpdateTimestamp // 엔티티가 수정될 때의 시간이 자동으로 기록됩니다.
  LocalDateTime updatedAt;

  @Builder
  public Order(BigDecimal totalPrice, OrderStatus status) {
    this.totalPrice = totalPrice;
    this.status = status;
  }


}