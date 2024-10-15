package com.freelencer.market.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity(name = "freelancer_profile_tbl")
@NoArgsConstructor
public class freelencerUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long profileId;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "view_cnt")
  private Integer viewCnt;

  @Column(name = "regis_date")
  private LocalDateTime regisDate;

  @Builder
  public freelencerUser(String userId, Integer viewCnt, LocalDateTime regisDate) {
    this.userId = userId;
    this.viewCnt = viewCnt;
    this.regisDate = regisDate;

  }
}
