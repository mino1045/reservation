// addEventListener => querySelector 기준임 querySelectorAll이면 반목문을 사용해야됨

let btn = document.querySelectorAll(".seat");
let seat_arr = new Array();

//querySelector => 바로 addEventListener사용가능
//querySelectorAll => foreach(반복문) 사용필수 => addEventListener

btn.forEach( (a) => {

    a.addEventListener("click",(e) => {
		
		if(seat_arr.length >=  person &&  e.target.className == "seat"){ //그냥 >=이거면 다시 선택 안 됨
			alert("더 이상 좌석 선택을 할 수 없습니다.");
		}else {
			// console.log(e); //console.log 보면 target > className: "seat selected"
			// e.target.className += " selected"; // 혹은  e.target.className = "seat selected"; 기존 클래스 이름 변경
			 //기존에 사요오디고 있는 html 클래스 이름을 변경 혹은 추가하여 적용하는 코드
			 //seat이라는 클래스를 다른 요소에 쓰면 오류가 남
			 var no = e.target.attributes.data.value;

			 //이제 클릭하면 해제가 되어야됨
			 if(e.target.className == "seat"){ //좌석 선택
			         e.target.className = "seat selected";
			         seat_arr.push(no); //좌석 선택 시 배열에 값 추가
					

			 }else { //좌석 해제
			     e.target.className = "seat";
			     //js에서는 배열 삭제위해 반복문으로 indexof로 핸들링해야됨 단 ecma6에서는 쉽게 뺄 수 있다 아래는 ecma6

				
				/*
				var rdata = seat_arr.filter(function(a){
					
					return a=! =no ; 이렇게 써야됨 function이면 return 필요함
				});

				
				*/
			     var rdata = seat_arr.filter((a) => a != no); //???????????
			     //filter : 해당 배열에서 해당 값을 제외한 배열 값만 출력하는 형태
				//화살표함수가 아닌 function 형태로 사용하면? 조건문이 아니면? push 초기화 버그가 날 수 있음 

			     seat_arr = rdata;

			 }
			console.log(seat_arr);
		}
		
		
		


    
        //var no = e.target.attributes.data.value;
  //  console.log(seat_arr);

    });
}

);


function movie_ok(){
	if(seat_arr.length == 0 ){
		
	}else {
		frm.seat_data.value = seat_arr;
		frm.submit();
	}
}