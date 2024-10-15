package com.freelencer.market.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Error {

  NOT_FOUND(404,"PAGE NOT FOUND"),
  INTER_SERVER_ERROR(500,"INTER SERVER ERROR"),
  NOT_FOUND_API(404,"API NOT FOUND")
  ;
  private final int status;
  private final String message;
}
