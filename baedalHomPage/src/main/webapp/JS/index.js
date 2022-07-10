function chkLogin() {
    event.preventDefault(); // 이걸 안해주면 아래 명령들이 실행이 안된다. e.preventDefault()로 하면 안됨!
    
    let chkIDPW = false;
    if (chkIDPW) {
        location.href = "../main.html";
    } else {
        alert("비밀번호 혹은 아이디가 틀렸습니다");
    }
}