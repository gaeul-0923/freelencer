package com.freelencer.market.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
  ERROR("ERROR"),
  SUCCESS("SUCCESS"),
  ;

  private final String code;
}
