package com.freelencer.market.service;

import com.freelencer.market.dto.UserDTO;
import com.freelencer.market.entity.User;
import com.freelencer.market.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public List<User> findAll() {
    return userRepository.findAll();

  }
  public List<UserDTO> findAllFreeLencerUser(String sortField, int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return userRepository.findAllFreeLencerUser(sortField, pageable);

  }

  public UserDTO findDetailFreeLencerUser(Long userId, Long profileId) {
    UserDTO result = userRepository.findDetailFreeLencerUser(userId, profileId);
    Long updateResult = userRepository.updateViewCount(userId, profileId);
    return result;
  }
}
