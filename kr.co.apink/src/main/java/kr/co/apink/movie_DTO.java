package kr.co.apink;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("movie_DTO")
public class movie_DTO {
	//movie_res
	int midx,moviecode,mperson;
	String mname,movienm,mdate,mtime,mtoday;
	
	//moive_seat
	int sidx,seatno;
}
