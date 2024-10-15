package com.freelencer.market.controller;


import com.freelencer.market.dto.UserDTO;
import com.freelencer.market.entity.User;
import com.freelencer.market.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping("/getUser")
  public List<User> getUser() {
    return userService.findAll();
  }

  @RequestMapping("/getFreeLencerUser")
  public List<UserDTO> getFreeLencerUser(@RequestParam String sortField
          , @RequestParam(defaultValue = "0") int page
          , @RequestParam(defaultValue = "10") int size) {
    return userService.findAllFreeLencerUser(sortField, page, size);
  }

  @RequestMapping("/findDetailFreeLencerUser")
  public UserDTO findDetailFreeLencerUser(@RequestParam String userId, @RequestParam Long profileId) {
    return userService.findDetailFreeLencerUser(userId, profileId);
  }
}
