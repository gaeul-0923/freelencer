package com.freelencer.market.board;


import com.freelencer.market.repository.UserRepository;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {
  @Autowired
  UserRepository userRepository;

  @Test
  public void getAllUser() {
    userRepository.findAll();
  }


}
