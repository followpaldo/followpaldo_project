package jjon.gangsan.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.Getter;


@Data
@Alias("CampListZzimVO")
public class CampListZzimVO {
    private String userId; // 사용자 아이디
    private String contentId; // 캠핑장 코드
    
    public String getUser_id() {
        return userId;
    }

    public void setUser_id(String userId) {
        this.userId = userId;
    }
    public String getContent_id() {
    	return contentId;
    }
    
    public void setContent_id(String contentId) {
    	this.contentId = contentId;
    }
}