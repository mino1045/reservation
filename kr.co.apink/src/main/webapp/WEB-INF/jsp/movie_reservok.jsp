<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>영화예매 [좌석배치 선택]</title>
</head>
<body>
    <div class="seat-selection">
        <h1>좌석 배치도</h1>
        <div class="screen">스크린</div>
        <div class="seats">
            <div class="row">
                <button type="button"  class="seat" data="1">A1</button>
                <button type="button"  class="seat" data="2">A2</button>
                <button type="button"  class="seat" data="3">A3</button>
                <button type="button"  class="seat" data="4">A4</button>
            </div>
            <div class="row">
                <button type="button" class="seat" data="5">B1</button>
                <button type="button"  class="seat" data="6">B2</button>
                <button type="button"  class="seat" data="7">B3</button>
                <button type="button"  class="seat" data="8">B4</button>
            </div>
            <div class="row">
                <button type="button"  class="seat" data="9">C1</button>
                <button type="button"  class="seat" data="10">C2</button>
                <button type="button"  class="seat" data="11">C3</button>
                <button type="button"  class="seat" data="12">C4</button>
            </div>
        </div>
        <div class="legend">
            <span class="available">사용 가능</span>
            <span class="selected">선택됨</span>
            <span class="occupied">사용 중</span>
        </div>

        <button type="button">예매취소</button>
        <button type="button" onclick="movie_ok()">예매확정</button>
        <form action="./movie_reserveok2.do" id="frm" method="post">
        <input type="hidden" name="seat_data" value="">
        </form>
		<!--db를 어느 순간에 저장해야하는가? 예매확정 후? 그 전? -->
        
    </div>
    <style>
        .seat-comp {
            background-color: #494949 !important;
        }

        .seat-selection {
            text-align: center;
            font-family: Arial, sans-serif;
        }
        .screen {
            margin: 20px auto;
            padding: 10px;
            background-color: #ccc;
            width: 50%;
            text-align: center;
            font-weight: bold;
        }
        .seats {
            display: inline-block;
            margin-top: 20px;
        }
        .row {
            margin-bottom: 10px;
        }
        .seat {
            width: 40px;
            height: 40px;
            margin: 5px;
            background-color: #4CAF50;
            border: none;
            border-radius: 5px;
            color: white;
            cursor: pointer;
        }
        .seat.occupied {
            background-color: #d9534f;
            cursor: not-allowed;
        }
        .seat.selected {
            background-color: #f0ad4e;
        }
        .legend {
            margin-top: 20px;
        }
        .legend span {
            display: inline-block;
            margin: 0 10px;
            padding: 5px 10px;
            border-radius: 5px;
        }
        .legend .available {
            background-color: #4CAF50;
            color: white;
        }
        .legend .selected {
            background-color: #f0ad4e;
            color: white;
        }
        .legend .occupied {
            background-color: #d9534f;
            color: white;
        }
    </style>
    <script>
    var person = "${person}";
    </script>
    <script src="./seat.js"></script>
</body>
</html>
