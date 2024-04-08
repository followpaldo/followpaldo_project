package jjon.gangsan.camplist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jjon.gangsan.model.CampListVO;
import jjon.gangsan.model.CampListZzimVO;


@Controller
public class CampListController {	
	
	@Autowired
	private CampListService campListService;
	
	//DB에 캠핑장 정보 저장 최초1회만 실행하고 실행하지 않음
	@RequestMapping("/save")
	public void saveCampList() {
        String result = "";
        
        try {
        	int totalPage = 380; //전체 페이지 수 (전체 컨텐츠 수 :3796)
        	int pageSize = 10;
        	
        	for(int pageNo=1; pageNo<=totalPage;pageNo++) {
	            URL url = new URL("https://apis.data.go.kr/B551011/GoCamping/basedList?"
	            		+ "serviceKey=Hhr14Q8W875seJ9A2UefmG2ndV3%2Ba%2Bi%2BQ%2B86zt1t0xxT%2BqXqArlTSIA0BBkEZwKSNeGaGfKtv%2Bk8UBxdORBLtg%3D%3D"
	            		+ "&numOfRows="+pageSize+"&pageNo="+pageNo+"&MobileOS=ETC&MobileApp=AppTest&_type=JSON");
	    
	            BufferedReader bf; //효율적으로 입출력하기 위한 입력도구
	    
	            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
	            //url 객체의 하위 메소드로 url 정보를 읽어들인다
	    
	            result = bf.readLine();
	    
	            JSONParser jsonParser = new JSONParser();
	            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
	            JSONObject response = (JSONObject) jsonObject.get("response");
	            JSONObject body = (JSONObject) response.get("body");
	            JSONObject items = (JSONObject) body.get("items");
	            JSONArray itemList = (JSONArray) items.get("item");
	        
	            for (Object item : itemList) {
	                JSONObject camping = (JSONObject) item;
	                
	                CampListVO camp = new CampListVO();
	                
	                camp.setContentId((String) camping.get("contentId"));
	                camp.setFirstImageUrl((String) camping.get("firstImageUrl"));
	                camp.setFacltNm((String) camping.get("facltNm"));
	                camp.setDoNm((String) camping.get("doNm"));
	                camp.setAddr1((String) camping.get("addr1"));
	                camp.setTel((String) camping.get("tel"));
	                camp.setHomepage((String) camping.get("homepage"));
	                camp.setInduty((String) camping.get("induty"));
	                camp.setIctCl((String) camping.get("ictCl"));
	                camp.setIntro((String) camping.get("intro"));
	    
	                System.out.println(camp);
	                
	                // 새로운 캠핑장 정보를 데이터베이스에 저장
	                campListService.saveCampList(camp);  
	            }  
        	}
	
	      } catch (Exception e) {
	           e.printStackTrace();
	    }
     }
	
	//캠핑장 정보 리스트 불러오기
    @RequestMapping("/CampList/{regin}")
    public String callCampList(@RequestParam(value="page",defaultValue="1") int page,
    		@PathVariable("regin") String region, Model model) {
    	
    	//메인페이지의 지역값을 가져와서 doNm으로 변경
    	String doNm = campListService.getDoNm(region);
    	
    	
    	//한 페이지의 데이터 출력 갯수
    	int limit = 10;
    	
    	//mySQL 에서 limit 를 사용하여 쿼리를 구하기 위해 작성
    	int start = (page - 1) * limit;
    	
    	//CampListVO DTO 를 생성하여 검색하고자 하는 doNm과 
    	//mySQL의 limit를 사용하기 위한 변수 전달
    	//★ 굳이 DTO를 생성해서 변수를 전달하는 이유 : mapper.xml 파일의 파라미터값과 result 값은 하나이기 때문에 
    	//									 쿼리문을 작성하기 위한 변수가 두개 이상일때는 DTO객체로 싸잡아서 보내야한다
    	
    	//doNm과 start 정보를 담은 DTO camp 생성
    	CampListVO camp = new CampListVO();
    	camp.setDoNm(doNm);
    	camp.setStart(start);
    	
    	//조건에 맞는 doNm을 가진 캠핑장 수 
    	int listCount = campListService.getListCount(camp);
    	System.out.println("listCount:"+ listCount);
    	
    	//페이징 처리로 출력될 총 페이지 수 
    	int maxpage = listCount / limit + ((listCount % limit ==0)? 0 : 1);
    	
    	//블럭이 10개 단위일 때 페이징의 첫단추 넘버
    	int startpage = ((page-1)/10)*limit+1;
    	
    	//블럭이 10개 단위일 때 페이징의 마지막 단추
    	int endpage = startpage+10-1;
    	
    	//마지막 단추가 총페이징 수 보다 크다면 마지막 단추를 총 페이징 수로 바꾼다
    	if(endpage > maxpage)
    		endpage = maxpage;
    	
    	//리스트 생성
    	List<CampListVO> campList = new ArrayList<CampListVO>();
    	
    	//생성한 리스트에 callList를 통해 값 검색한 지역의 값 받아오기
    	campList = campListService.callCampList(camp);
    	
    	//jsp 단에 값 넘겨주기
    	model.addAttribute("page",page);
    	model.addAttribute("doNm",doNm);
    	model.addAttribute("startpage",startpage);
    	model.addAttribute("endpage",endpage);
    	model.addAttribute("maxpage",maxpage);
    	model.addAttribute("listCount",listCount);
    	model.addAttribute("campList",campList);
    	
        return "CampList";
    }
	
    
	//찜하기
	@PostMapping("/zzim")
	@ResponseBody
	public ResponseEntity<Integer> zzimClick(@RequestBody CampListZzimVO zzimVO,
			HttpServletRequest request, Model model) {   

		//세션값에 저장된 user_id 사용자의 찜한 content_id list 형식으로 가져오기
		//sid 값을 가진 (contentid 리스트로 받기)
		String userId = zzimVO.getUserId();
		List<String> zzimList = new ArrayList<String>();
		zzimList = campListService.getZzimList(userId);
		
		System.out.println(zzimList);
		
		int zzimstate = 0;
		
		boolean isDuplicate = false;
		
		if(zzimList != null && !zzimList.isEmpty()) {
			for(String zzimContentId : zzimList) {
				if(zzimContentId.equals(zzimVO.getContentId())) {
					campListService.deleteZzim(zzimVO);
					zzimstate = 0;
					isDuplicate = true;
					break;
				}
			}
		}
		if(!isDuplicate) {
			campListService.letZzim(zzimVO);
			zzimstate = 1;
		}
		
		model.addAttribute("zzimstate",zzimstate);
				
		return new ResponseEntity<Integer>(zzimstate, HttpStatus.OK);
	}
}
