package jjon.gangsan.camplist;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jjon.gangsan.model.CampListVO;
import jjon.gangsan.model.CampListZzimVO;


@Mapper
public interface CampListMapper {
	
	// 캠핑장 정보 저장 최초 1회 실행
	public void saveCampList(CampListVO campList);

	// 캠핑장 정보 불러오기
	public List<CampListVO> callCampList(CampListVO camp);
	
	//검색된 캠핑장 갯수 가져오기
	public int getListCount(CampListVO camp);
	
	//찜 상태
	public List<String> getZzimList(String userId);

	// 캠핑장 찜하기
	public void letZzim(CampListZzimVO zzimVO);
	
	// 찜 취소
	public void deleteZzim(CampListZzimVO zzimVO);

	public String getDoNm(String region);
	
}

