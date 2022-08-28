function nav(){
    let li = `
    <p>
    <a href="/boards">글목록</a>
    <a href="/boards/create">글쓰기</a>
    </p>`;
    document.write(li);
}

function login_and_signup(){
    let li = `
    <p>
    <a href="/members/login">로그인</a>
    <a href="/members/signup">회원가입</a>
    </p>`;
    document.write(li);
}

function logout(){
    let li = `
    <p>
    <a href="/members/logout">로그아웃</a>
    </p>
    `;
    document.write(li);
}

function header(){
    document.write(`<h1><a href="/">링크스</a></h1>
    `);
}