package com.sparta.msa.lesson.global.config;

import com.sparta.msa.lesson.domain.user.repository.UserRepository;
import com.sparta.msa.lesson.domain.user.repository.UserRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {


  @Bean // 인스턴스를 스프링 컨테이너가 관리함 -> 서버를 부팅할 때 인스턴스화가 완료됨
  public UserRepository userRepository() {
    return new UserRepositoryImpl(); // 싱글톤 패턴

  }

  // 싱글톤 -> 프로그램 전체에서 특정 클래스의 인스턴스가 단 하나만 존재해야함.
  // 풀링 -> 임의의 인스턴스를 미리 생성해서 (100~~) 교체로 사용하는 패턴
  // JVM이 메모리를 많이 먹어서 Bean은 티가 나지 않는다.
}
