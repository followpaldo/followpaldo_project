package jjon.gangsan.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("tour")
public class Tour {
	private String addr1;
	private String area;
	private String image;
	private String tel;
	private String title;
	
	
	private int start;
}
