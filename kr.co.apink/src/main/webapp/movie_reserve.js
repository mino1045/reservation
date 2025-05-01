frm.mdate.value = new Date().toISOString().substring(0,10);

var reserve = () =>{

    if(frm.mname.value == ""){
            alert("고객명을 입력하세요");
            return false;
        }else if(frm.mtime.value == ""){
            alert("예매시간을 선택해주세요 입력하세요");
            return false;

        } else {
            frm.submit();
        }
    }