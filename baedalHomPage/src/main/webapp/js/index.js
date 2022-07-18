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

// map을 불러오는 스크립트
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};
var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
console.log("맵이 제대로 불러와지니?");

function makeMarker(shopX, shopY, shopCode, shopPic, shopName, shopCategory, shopStar) {
	console.log(shopX);
	console.log(shopY);

    var markerPosition  = new kakao.maps.LatLng(shopX, shopY); 
    var marker = new kakao.maps.Marker({
       position: markerPosition
    });
	marker.setMap(map);
	
	// 마커에 클릭이벤트를 등록합니다
	kakao.maps.event.addListener(marker, 'click', function() {
		addShopInfoInSection(shopCode, shopPic, shopName, shopCategory, shopStar);
	});
}


function addShopInfoInSection(shopCode, shopPic, shopName, shopCategory, shopStar) {
	const contents = `
				<article onclick='location.href="shop?shopCode=${shopCode}"'> 
					<div class="articleBlock" id="subArticle1">
						<div id="menuPicture1"><img src="${shopPic}"></div>
					</div>
					<div class="articleBlock" id="subArticle2">
						<div id="shopName"><h1>[${shopName}]</h1></div>
						<div id="shopCategory"><h3>${shopCategory}</h3></div>
						<div id="shopStar"><h1>별점 : ${shopStar}</h1></div>
					</div>
				</article>`;
				
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

// 메인페이지에서 찜목록을 눌렀을때 로그인 여부를 판단함
function viewFavoriteList(logCode) {
	let code = String(logCode);
	if (code.charAt(0) === '-') {
		alert("로그인이 필요합니다");
	} else {
		location.href = './indexFavorite';
	}
	
	
}