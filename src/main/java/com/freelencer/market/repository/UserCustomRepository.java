package com.freelencer.market.repository;

import com.freelencer.market.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserCustomRepository {
  List<UserDTO> findAllFreeLencerUser(String sortField, Pageable pageable);

  UserDTO findDetailFreeLencerUser(String userId, Long profileId);

}
