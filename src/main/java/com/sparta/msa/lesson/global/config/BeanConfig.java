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
}
