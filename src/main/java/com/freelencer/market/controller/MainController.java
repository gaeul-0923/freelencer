package com.freelencer.market.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController {

  @GetMapping("/test")
  public String test() {
    return "main";
  }

}
