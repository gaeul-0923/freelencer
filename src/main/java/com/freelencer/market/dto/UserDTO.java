package com.freelencer.market.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDTO {
  private Long userId;
  private Long profileId;
  private String userName;
  private LocalDateTime regisDate;
  private Integer viewCnt;

  @QueryProjection
  public UserDTO(Long userId, Long profileId, String userName, LocalDateTime regisDate, Integer viewCnt) {
    this.userId = userId;
    this.profileId = profileId;
    this.userName = userName;
    this.regisDate = regisDate;
    this.viewCnt = viewCnt;
  }

}
