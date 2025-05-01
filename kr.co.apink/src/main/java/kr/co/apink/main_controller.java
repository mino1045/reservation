package kr.co.apink;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.xml.catalog.CatalogException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.cj.jdbc.Driver;
import jakarta.annotation.Resource;

@Controller
public class main_controller {
	 Logger log = LoggerFactory.getLogger(this.getClass()); //slf4j가 log4j?보다 상위 기본 탑재되어있음
	 
	
	@Resource(name = "server_db1")
	server_db1 sd;
	
	@Resource(name = "movie_DTO")
	movie_DTO md;
	
	static movie_DTO mmd; //static으로 올림

	
	
	
	/*
	@Autowired
	server_db1 sd;
	*/ //예매정보확인 메서드
	
	@PostMapping("/movie_reserveok2.do")
	public String movie_reservok2(Model m, @RequestParam(name = "seat_data") String seat_data) {
		Connection con = null;
		try {
			con = this.sd.dbinfo2(); //db2 사용하기로 함
			//mybatis 지금 안 깔아서 이렇게 된듯?
			String sql = "insert into movie_res values(0,?,?,?,?,?,?,now())";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, this.md.getMname());
			ps.setInt(2, this.md.getMoviecode());
			ps.setString(3, this.md.getMovienm());
			ps.setString(4, this.md.getMdate());
			ps.setString(5, this.md.getMtime());
			ps.setInt(6, this.md.getMperson());
						
			int result = ps.executeUpdate();
			
			if (result > 0) { //해당 고객의 좌석수에 맞게 반복문 필요함
				
				String seat_no[] = seat_data.split(",");
				int w = 0;
				while (w < seat_no.length) {
					String sql2 = "insert into movie_seat values(0,?,?,now())";
					PreparedStatement ps2 = con.prepareStatement(sql2);
					ps2.setInt(1, this.md.getMoviecode());
					ps2.setInt(2, Integer.parseInt( seat_no[w])) ;
					ps2.executeUpdate();
					w++;
				}
				m.addAttribute("msg","alert('영화 예매가 완료되었습니다'); location.href='./movie_reserve.html';");
			} else {
				m.addAttribute("msg","alert('시스템 장애로 서비스가 원활하지 않습니다.');");
			}

		} catch (Exception e) {
			this.log.info(e.toString());
		}
		return null;
	}

	
	@PostMapping("/movie_reservok.do") //예매확인 
	public String movie_reservok(@ModelAttribute movie_DTO dto,Model m) {
		//this.log.info(dto.getMname());
		//static => 저장 or storage 저장 백앤드가 어떻게 할지 결정
		//String mname = dto.getMname();
		
		//mmd에 있는 값을 dto로 이관할 수 있는가???
		//mmd = dto;
		
		//메모리를 사용하지 않는다면
		
		
		this.md = dto;
		m.addAttribute("person",dto.getMperson() );
		
		//js에 인원수 전달해야됨/js는 백앤드 코드 자체를 못 받는다 그래서
		
		return null;
		//모델을 하나만들어서 볻ㄹ
	}

	
	/*static 메서드의값을 가져올 때 잘 알고 가져오자?메모리를 올려서 저장할건지 등?
	그러니깐 예약된걸 메모리에 올렸다가 취소하면 날려?
	메모리에 안쓰고 dto에 옮겨놓고
	
	*/
	@GetMapping("/test.do")
	public  String test() {
		String aaa = this.aaa();
		return null;
	}
	
	@GetMapping //컨트롤에는 static같은 단어 쓰면 안 됨 사실
	public static String aaa() {
		String aaa = "hong";
		return null;
	}
	
	
	@PostMapping("/pollok.do")
	public String pollok(@RequestParam(name = "poll") String poll,Model m) {
		
		
		String msg = "";
		
		try {
			Connection con = this.sd.dbinfo2();
			System.out.println(con);
			
			switch (poll) {
			case "1":
			msg = "java";
			break;
			
			case "2":
			msg = "spring";
			break;
			
			case "3":
			msg = "spring-boot";
			break;

			default:
				msg = "선택x";
				break;
				
			}
			
			m.addAttribute("msg", msg);
		} catch (Exception e) {
		}
		
	return "pollok";	
	}
	
	
	

}
