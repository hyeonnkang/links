# links
"에브리타임" 애플리케이션을 모티브로 한 커뮤니티 웹 페이지입니다.
로그인 및 로그아웃, 게시글 생성/수정/조회/삭제, 댓글 생성/수정/조회/삭제 가능합니다.

# 구동 모습
![ezgif com-video-to-gif](https://github.com/hyeonnkang/links/assets/62539341/92e932b4-fb3b-41ce-afdf-bd528fd3f52a)


# 담당
- 프론트엔드: 강현
- 백엔드: 강현

# 구동 방법
1. 로컬에서 MongoDB 데이터베이스를 설치한 상태에서 실행할 수 있습니다.
```shell
brew install mongodb-community
```
```shell
brew install mongodb-community-shell
```
2. 프로젝트의 루트 경로에서 애플리케이션을 빌드합니다.
```shell
./gradlew clean build
```
3. 루트 디렉토리 내의 build/libs의 jar 파일을 실행합니다.
```shell
java -jar {jarFileName}.jar
```

# 클라이언트 스펙
- `HTML`
- `CSS`
- `Javascript`

# 백엔드 스펙
- `Spring Boot`
- `MongoDB`
