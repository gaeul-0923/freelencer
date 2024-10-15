package com.freelencer.market.service;

import com.freelencer.market.dto.UserDTO;
import com.freelencer.market.entity.User;
import com.freelencer.market.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

  public List<User> findAll() {
    return userRepository.findAll();

  }
  public List<UserDTO> findAllFreeLencerUser(String sortField, int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return userRepository.findAllFreeLencerUser(sortField, pageable);

  }

  public UserDTO findDetailFreeLencerUser(String userId, Long profileId) {
    return userRepository.findDetailFreeLencerUser(userId, profileId);
  }
}
