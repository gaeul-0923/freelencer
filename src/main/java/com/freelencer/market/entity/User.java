package com.freelencer.market.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "user_tbl")
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "user_role")
  private String userRole;

  @Column(name = "user_status")
  private String userStatus;


  @Builder
  public User(String userName,String userRole,String userStatus) {
    this.userName = userName;
    this.userRole = userRole;
    this.userStatus = userStatus;
  }
}
