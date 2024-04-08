package jjon.gangsan.tour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jjon.gangsan.model.Tour;

@Mapper
public interface TourDao {

	public void insertTourData(Tour tour);

	public int getCount(String areaNum);

	public List<Tour> getTourList(Tour tour);

	public String getLocation(String region);

}