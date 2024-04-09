package jjon.gangsan.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("CampListVO")
public class CampListVO {
	private String contentId; //캠핑장 코드
	private String firstImageUrl; //사진
	private String facltNm; //캠핑장 이름
	private String doNm; //도
	private String addr1; //상세주소
	private String tel; //전화번호
	private String homepage; //캠핑장 홈페이지
	private String induty; //캠핑장 유형
	private String ictCl; //캠핑장 주변환경
	private String intro; //캠핑장 소개
	private int start; //mySQL 쿼리문에서 limit를 사용하기 위해 정의한 값
}
