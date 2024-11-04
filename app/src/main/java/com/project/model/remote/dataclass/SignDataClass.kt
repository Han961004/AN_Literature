package com.project.model.remote.dataclass

/* 개요
* 로컬 로그인 요청
* 로컬 로그인 반환
* 로컬 회원 가입 요청
*
*
* 카카오 로그인 요청
* 카카오 로그인 반환
 */

/* 로컬 로그인 요청
* <객체화> 시켜서 이름, 비밀 번호 전송
 */
data class LocalSignInRequest(
    val username: String,
    val password: String
)

/* 로컬 로그인 반환
* <객체화> 된 네임, 이메일 등등 반환 -> 계속 추가
 */
data class LocalSignInResponse(
    val username: String,
    val email: String,
)

/* 로컬 회원 가입 요청
* <객체화> 된 네임, 패스워드, 이메일 등등 서버로 전송 -> 계속 추가
* SignUpResponse 는 response.code 로 반환 -> 단순 message 로 여부 확인
 */
data class LocalSignUpRequest(
    val username: String,
    val password: String,
    val email: String,
)

/* 카카오 로그인 반환
* AccessToken 주고, jwt 와 유저 정보 받아냄
 */
data class KakaoSignInResponse(
    val jwt: String,
//    val userInfo: 
)