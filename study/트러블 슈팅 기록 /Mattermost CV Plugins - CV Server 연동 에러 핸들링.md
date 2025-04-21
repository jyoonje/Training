### 기대하는 클라이언트 입장의 동작 
1. Mattermost 시스템 콘솔 - Plugins - CV Plugin 활성화
2. 게시물 작성 시 파일 첨부
3. 첨부된 파일 클릭 시 CV 호출 및 뷰어 이용

---
### 서버 측 동작
1. 사용자가 게시물 작성 시 파일 첨부
2. 해당 파일을 변환(* -> .esob) 및 CV optimal한 위치에  copy
3. 첨부된 파일 클릭 시 RHS 열기
4. CV 서버 호출 및 RHS 내부에 Iframe 으로 렌더링

---
### 발생한 문제
1. `cv_post`, `cv_call`의 `redirect: finalURL` 방식이 iframe에서 동작하지 않음
   - 기존 `cv_post`, `cv_call` 동작 방식:
     1) 요청을 받으면 세션에 데이터 저장
     2) 클라이언트에게 `302 redirect` 보내서 `finalURL로` 리디렉션
   -  하지만 iframe에서는 이 리디렉션이 무시됨
     1) SOP, CORS 제한
	     - iframe 내부에서 리디렉션이 일어날 경우, 브라우저가 제한함
	     - Set-Cookie나 세션 관련 정보가 전달되지 않으면 iframe 내부에서는 리디렉션 후 세션을 잃음
     2) Credential 관련 CORS 설정 부족
		 - iframe 요청은 기본적으로 `credentials: omit`상태
		 - 즉 세션/쿠키를 서버에 전달하지 않음 -> 서버는 누가 요청했는지 모름
	 3) 302 Redirect 응답은 fetch로는 따라가지 않음
		 - iframe이 아닌 fetch에서 302를 받으면 Location 헤더를 자동으로 따라가지만, iframe은 Location 헤더를 따라가지 않거나 보안상 막힘.
1. CV iframe에 띄웠는데 일부 기능이 정상 동작하지 않음 (어노테이션)
  - 원인
	

---
### 해결 방법
1. `cv_post`, `cv_call`의 `redirect: finalURL` 방식이 iframe에서 동작하지 않는 문제
- 기존 흐름:
	`POST /cv_post` -> CV 서버에서 세션 저장 후 `res.redirect(finalURL)`
- 수정된 흐름 (Mattermost 서버에서 요청한 경우):
	`POST /cv_post` -> CV 서버에서 세션 저장 후 `res.json({ finalURL: ...})`
	이때, 세션 기반 인증을 위해 `credentials: "include"` 옵션을 사용
	브라우저는 **쿠키를 전송하기 때문에 세션이 유지됨**
	서버는 CORS를 허용하도록 설정: 요청을 허용할 도메인(`localhost: 8065`)를 명시, `credentials: true`를 설정하여 클라이언트에서 보낸 쿠키를 서버가 수신

   
