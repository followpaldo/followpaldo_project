package jjon.gangsan.tour.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jjon.gangsan.model.Tour;
import jjon.gangsan.tour.service.TourService;

@Controller
@RequestMapping("/tour")
public class TourController {
	
	@Autowired
	private TourService service;
	
	@GetMapping("/main")
	public String main() {
		return "tour_main";
	}
	//데이터 받아오기
	@RequestMapping("/data")
	public String getTourData() {
	try {
		String result = "";
		URL url = new URL("https://apis.data.go.kr/B551011/KorService1/areaBasedList1?numOfRows=13052&MobileOS=ETC&MobileApp=test&_type=json&contentTypeId=12&serviceKey=Mw0yWnqdtivA2wZZKzokuFO74a9MrdXQqDB5Z3ql1UciOQIBqC5wdo380OfmoHfC6sihqb0E9kgUs3IYfj9unQ%253D%253D");
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		
		result = bf.readLine();
		
		 // JSON 데이터 파싱
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
        JSONObject response = (JSONObject) jsonObject.get("response");
        JSONObject body = (JSONObject) response.get("body");
        JSONObject items = (JSONObject) body.get("items");
        JSONArray itemList = (JSONArray) items.get("item");
		
		  // 관광지 데이터를 저장할 리스트 생성
//        List<Tour> tourList = new ArrayList<>();
        
        for (Object itemObj : itemList) {
            JSONObject item = (JSONObject) itemObj;
			
			System.out.println("등록시작");
			
			Tour tour = new Tour();
			tour.setTitle((String) item.get("title"));
			tour.setImage((String) item.get("firstimage"));
			tour.setAddr1((String) item.get("addr1"));
			tour.setTel((String) item.get("tel"));
			tour.setArea((String) item.get("areacode"));
			
//			tourList.add(tour);
			
			System.out.println(tour);
			System.out.println("\n\n");
			
			service.saveTourData(tour);
		}
		
		
		
	} catch(Exception e) {
		e.printStackTrace();
	}
		return "result";
	}
	
	//투어리스트 boardbean=Tour
		@RequestMapping("/tourlist/{region}")
		public String tourlist(@RequestParam(value="page", defaultValue="1") int page, @PathVariable("region") String region, Model model) {
			
			
			String areaNum = service.getLocation(region);
			
			List<Tour> tourlist = new ArrayList<Tour>();
			
			Tour tour = new Tour();
			tour.setArea(areaNum);
			
			//화면에 출력할 최대 개수
			int limit = 10;
			
			//컬럼 자르기
			int start = (page -1) * limit;
			tour.setStart(start);
			
			//데이터 개수
			int listcount = service.getCount(areaNum);
			
			System.out.println("listcount:"+listcount);
			
			//페이지번호(page)를 DAO 클래스에게 전달한다.
			tourlist = service.getTourList(tour);
			
			//총 페이지 수
			int maxPage = listcount / limit + ((listcount % limit ==0)? 0:1);
			
			int startPage = ((page-1) /10) * limit + 1;
			int endPage = startPage + 10 -1 ;
			
			if (endPage > maxPage)
				endPage = maxPage;
			
			model.addAttribute("page", page);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("maxPage", maxPage);
			model.addAttribute("listcount", listcount);
			model.addAttribute("tourlist", tourlist);
			
			return "tourlist";
		}
}

		
	

