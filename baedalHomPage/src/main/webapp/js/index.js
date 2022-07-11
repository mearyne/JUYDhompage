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
