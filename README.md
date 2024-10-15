

## 📝 소개
JPA를 공부하기 위한 프로젝트 입니다 :)

<br />




## ⚙ 기술 스택 및 개발 환경
- OS : macOS
- 개발 언어 : Java17
- Framework/Library : spring boot 3.3.4,jpa,querydsl
- DBMS : mariaDB



<br />

## 📋 ERD
https://www.erdcloud.com/d/6LCget4oqQtffSJHT

<br />

![image](https://github.com/user-attachments/assets/d97b62e5-b4fc-43b9-8690-eb13da4124ee)



<br />

## 🛠️ 기능
- getFreeLencerUser api를 통해 회원의 role이 '프리랜서'이며 회원의 상태가 활성화되어있는 회원의 프로필을 조회합니다.
    - 이때 sortField로 정렬조건을 추가해줄 수 있습니다.
    - 페이징처리도 가능합니다.(기본 : 0페이지 10페이지씩 보기)

- findDetailFreeLencerUser api를 통해 프리랜서 회원의 상세 프로필을 조회합니다.
    - 프로필 상세 조회 후 updateViewCount api를 통해 조회수를 업데이트 합니다.
- Enum Class 를 통해 rest api 형태로 제공합니다

### 프리랜서 프로필 조회
```
/getFreeLencerUser?sortField=regisDate&page=0&size=10
```
**Response**
```
{
    "result": "SUCCESS",
    "data": [
        {
            "userId": 2,
            "profileId": 2,
            "userName": "임꺽정",
            "regisDate": "2024-10-15T00:01:38",
            "viewCnt": 0
        },
        {
            "userId": 1,
            "profileId": 1,
            "userName": "홍길동",
            "regisDate": "2024-10-10T22:54:03",
            "viewCnt": 2
        }
    ],
    "error": null
}
```

### 프리랜서 프로필 상세조회
```
/findDetailFreeLencerUser?userId=1&profileId=1
```
**Response**
```
{
    "result": "SUCCESS",
    "data": {
        "userId": 1,
        "profileId": 1,
        "userName": "홍길동",
        "regisDate": "2024-10-10T22:54:03",
        "viewCnt": 1
    },
    "error": null
}
```