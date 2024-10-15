package com.freelencer.market.repository;

import com.freelencer.market.dto.QUserDTO;
import com.freelencer.market.dto.UserDTO;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.freelencer.market.entity.QUser.user;
import static com.freelencer.market.entity.QfreelencerUser.freelencerUser;

@Repository
@AllArgsConstructor
@Transactional
public class UserCustomRepositoryImpl implements UserCustomRepository {

  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public List<UserDTO> findAllFreeLencerUser(String sortField, Pageable pageable) {

    return jpaQueryFactory
            .select(new QUserDTO(
                    user.userId,
                    freelencerUser.profileId,
                    user.userName,
                    freelencerUser.regisDate,
                    freelencerUser.viewCnt))
            .from(user)
            .leftJoin(freelencerUser)
            .on(user.userId.eq(freelencerUser.userId))
            .where(
                    user.userRole.eq("F"),
                    user.userStatus.eq("A")
            )
            .orderBy(getOrderSpecifier(sortField))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();
  }

  @Override
  public UserDTO findDetailFreeLencerUser(String userId, Long profileId) {
    return jpaQueryFactory
            .select(new QUserDTO(
                    user.userId,
                    freelencerUser.profileId,
                    user.userName,
                    freelencerUser.regisDate,
                    freelencerUser.viewCnt))
            .from(user)
            .leftJoin(freelencerUser)
            .on(user.userId.eq(freelencerUser.userId))
            .where(
                    user.userId.eq(userId),
                    freelencerUser.profileId.eq(profileId)
            )
            .fetchOne();

  }

  @Override
  public Long updateViewCount(String userId, Long profileId) {
    return jpaQueryFactory
            .update(freelencerUser)
            .where(
                    freelencerUser.profileId.eq(profileId),
                    freelencerUser.userId.eq(userId)
            )
            .set(freelencerUser.viewCnt,freelencerUser.viewCnt.add(1))
            .execute();
  }


  private OrderSpecifier<?> getOrderSpecifier(String sortField) {
    if ("userName".equals(sortField)) {
      return user.userName.asc();
    } else if ("regisDate".equals(sortField)) {
      return freelencerUser.regisDate.desc();
    } else if ("viewCnt".equals(sortField)) {
      return freelencerUser.viewCnt.desc();
    } else {
      return user.userName.asc(); // 기본 정렬 기준
    }
  }
}
