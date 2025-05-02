package kr.co.apink;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("movie_DTO")
public class movie_DTO {
	/*
	
	 midx : auto_increment
	 movicecode : 영화관 고유코드
	 usercode : 고객의 고유코드
	 mperson : 예매 인원 수
	 seatno : 예매 좌석 번호
	 */
	
	
	//movie_res
	int midx,moviecode,mperson,usercode;
	String mname,movienm,mdate,mtime,mtoday;
	
	//moive_seat
	int sidx,seatno;
}
