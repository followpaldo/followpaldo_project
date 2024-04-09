package jjon.gangsan.camplist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jjon.gangsan.model.CampListVO;
import jjon.gangsan.model.CampListZzimVO;


@Service
public class CampListService {

    @Autowired
    private CampListMapper campListMapper;
    
    //캠핑장 정보 저장하기 최초 1회 실행
    public void saveCampList(CampListVO camp) {
    	campListMapper.saveCampList(camp);
    }
    
    // 캠핑장 정보 불러오기
    public List<CampListVO> callCampList(CampListVO camp) {
        return campListMapper.callCampList(camp);
    }

    //찜상태 불러오기
    public List<String> getZzimList(String userId) {
    	return campListMapper.getZzimList(userId);
    }
    
    // 캠핑장 찜하기
    public void letZzim(CampListZzimVO zzimVO) {
        campListMapper.letZzim(zzimVO);
    }
    
    // 찜 취소
    public void deleteZzim(CampListZzimVO zzimVO) {
        campListMapper.deleteZzim(zzimVO);
    }

	public int getListCount(CampListVO camp) {
		return campListMapper.getListCount(camp);
	}

	public String getDoNm(String region) {
		return campListMapper.getDoNm(region);
	}



}
