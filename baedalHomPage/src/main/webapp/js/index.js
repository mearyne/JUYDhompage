function checkJoinVal(form) {
	const req = $(".req");
	for (let i = 0; i < req.length; i++) {
		if (req.get(i).value === "")
			warning.show();
		else {
			form.submit();
		}
	}
}

/* 메인 페이지에 대한 javascript입니다 */

// map을 불러오는 스크립트
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};
var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴


// 지도 관련 옵션

// 1. 마우스를 올리면 해당 정보 출력함
// https://apis.map.kakao.com/web/sample/addMarkerMouseEvent/

// 2. 클릭한 위치에 마커 표시하기
// https://apis.map.kakao.com/web/sample/addMapClickEventWithMarker/

// 3. 마커 생성하기
// https://apis.map.kakao.com/web/sample/basicMarker/

// 4. 좌표로 주소 알아내기
// https://apis.map.kakao.com/web/sample/coord2addr/

// 코드값을 입력받아서 지도에 마커를 생성하기!
function makeMarker(shopInfo) {
	const position = new kakao.maps.LatLng(shopInfo.getShopX(), shopInfo.getShopY());

	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
		position: position,
		clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
	});

	marker.setMap(map);

	kakao.maps.event.addListener(marker, 'click', function() {
		// 마커 위에 인포윈도우를 표시합니다
		addShopInfoInSection(shopInfo);
		infowindow.open(map, marker);
	});


}

// 마커를 표시할 위치입니다 
var position = new kakao.maps.LatLng(33.450701, 126.570667);

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
	position: position,
	clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
});

// 아래 코드는 위의 마커를 생성하는 코드에서 clickable: true 와 같이
// 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
// marker.setClickable(true);

// 마커를 지도에 표시합니다.
marker.setMap(map);

// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
var iwContent = '<div style="padding:5px;">Hello World!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
	iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
	content: iwContent,
	removable: iwRemoveable
});

// 마커에 클릭이벤트를 등록합니다
kakao.maps.event.addListener(marker, 'click', function() {
	// 마커 위에 인포윈도우를 표시합니다
	addShopInfoInSection();
	infowindow.open(map, marker);
});

function addShopInfoInSection(shopInfo) {
	const contents = String.format(`
				<article onclick='location.href="shop?shopCode=%d"'>
					<div class="articleBlock" id="subArticle1">
						<div id="menuPicture1"><img src="%s"></div>
					</div>
					<div class="articleBlock" id="subArticle2">
						<div id="shopName"><h1>[%s]</h1></div>
						<div id="shopCategory"><h3>%s</h3></div>
						<div id="shopStar"><h1>별점 : %d</h1></div>
					</div>
				</article>`, shopInfo.getShopCode(), shopInfo.getShopPic(), shopInfo.getShopName(), shopInfo.getShopCategory(), shopInfo.getShopStar());
	const sectionSelector = document.getElementById('articleList');
	sectionSelector.innerHTML = contents + sectionSelector.innerHTML;

}


function goToMyPage(logCode) {
	let code = String(logCode);
	if (code.charAt(0) === '-') {
		// 로그인이 안된 상태
		alert("로그인을 해주세요");
	} else if (code.charAt(0) === 'u') {
		// user로 로그인 된 상태라면 마이페이지로 이동시킨다
		location.href = "./myPage";
	} else if (code.charAt(0) === 'm') {
		// master로 로그인 된 상태라면 master마이페이지로 이동시킨다
		location.href = "./mypage_master";
	}


}