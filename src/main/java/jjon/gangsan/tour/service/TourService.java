package jjon.gangsan.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jjon.gangsan.model.Tour;
import jjon.gangsan.tour.mapper.TourDao;

@Service
public class TourService {

	@Autowired
	private TourDao dao;
	
	public void saveTourData(Tour tour) {
		dao.insertTourData(tour);
	}

	public int getCount(String areaNum) {
		return dao.getCount(areaNum);
	}

	public List<Tour> getTourList(Tour tour) {
		return dao.getTourList(tour);
	}

	public String getLocation(String region) {
		return dao.getLocation(region);
		
	}
}
