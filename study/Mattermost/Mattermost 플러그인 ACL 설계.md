
### - Mattermost 플러그인에서 DB 접근 방식

- Mattermost는 내부 DB 스키마가 변경될 수 있는 구조로, 쿼리를 실행하여 DB에 직접 접근하는 방식은 향후 호환성 문제가 발생할 수 있음
  
- `plugin.API`는 Mattermost의 공식 API로, 내부 구조 변경에도 호환성이 유지됨
  
- Mattermost는 플러그인에서 DB 직접 접근을 권장하지 않음 [Link](https://forum.mattermost.com/t/limiting-database-access/3902?utm_source=chatgpt.com)
  
- plugin.API에서 제공하는 `GetUser`, `GetChannel`, `GetTeamMembersForUser`, `GetPost` 등의 **기존 리소스를 조회**하는 방식과, 관리자 설정 데이터를 서버에서 저장 시에는 `KVStore`를 사용

>[!note] KVStore
>Mattermost의 `KVStore`는 플러그인 전용 키-값 저장소로, Mattermost 내부 DB의 `PluginKeyValueStore` 테이블에 저장됨
>
>Mattermost 공식 문서에서 플러그인 상태 저장, 캐시, 설정 등을 위해 운영 환경에서도 사용을 권장


---

### - `plugin.API`의 주요 함수들
| 함수                                                  | 설명                         |
| --------------------------------------------------- | -------------------------- |
| `GetUser(userID string)`                            | 사용자 정보 조회                  |
| `GetChannel(channelID string)`                      | 채널 정보 조회                   |
| `GetChannelMember(channelID, userID string)`        | 사용자의 채널 내 권한 조회            |
| `GetTeam(teamID string)`                            | 팀 정보 조회                    |
| `KVSet(key string, value []byte)`                   | KV 저장소에 값 저장 (ACL 등 저장 가능) |
| `KVGet(key string)`                                 | KV 저장소에서 값 조회              |
| `KVDelete(key string)`                              | ACL 삭제용                    |
| `LogInfo(msg string, keyValuePairs ...interface{})` | 로깅 (디버깅 필수)                |
|                                                     |                            |
|                                                     |                            |


---

### - Mattermost 관리자 페이지 화면 설계

![Mattermost|1000x600](https://github.com/user-attachments/assets/bce651da-5fff-4f8c-9b7a-8fadd8270295)


- 비고: 
  "Open Plugin Management" 버튼 클릭 시 커스텀 플러그인 설정 페이지로 이동


### - 플러그인 설정 페이지 화면 설계
#### [플러그인 설정 페이지로 이동](https://readdy.link/share/8675a39ad29d82613c8a4353d61daa36)

![Mattermost|1000x600](https://github.com/user-attachments/assets/2ec5a006-bc75-475e-b454-e5af1bc581e9)


---

### - 관리자 설정 구조: `admin_settings`

- 관리자는 설정 UI 를 통해 `"admin_settings"`라는 KVStore 키 (`PluginKeyValueStore` 테이블의 `admin_settings` 컬럼)에 다음 구조로 저장
```
{
  "webapp": {
    "file_download_roles": ["team_leader", "system_admin"]
  },
  "server": {
    "team_settings": {
      "teamA": {
        "channel_settings": {
          "channelA": {
            "searchablePDF": true,
            "use_annotation": ["markup_annotation", "speechbubble_annotation"]
          },
          "channelB": {
            "searchablePDF": true
          }
        }
      },
      "teamB": {
        "channel_settings": {
          "channelA": {
            "searchablePDF": true,
            "use_annotation": ["markup_annotation"]
          },
          "channelB": {
            "searchablePDF": false
          }
        }
      }
    }
  }
}

```


---

### - 플러그인 설정 시 저장 및 설정 항목 기반 ACL 적용 방안 설계

#### `webapp` 관련 설정 (예: 파일 다운로드 버튼 표시 여부)

- 관리자가 설정 UI에서 설정을 저장하면, **KVStore의 key `"admin_settings"`에 `"webapp"` 값을 포함하여 저장**

##### 방법 1:
- 사용자는 두 데이터를 localStorage에 캐시함:
    
    1. 자신의 권한 정보 -> `p.API.GetUser()`를 통해 조회 후 해시 처리
        
    2. 허용된 다운로드 권한 목록 -> `KVStore("admin_settings")`의 `"webapp.file_download_roles"` 값 조회 후 해시 처리
        
- 채널 렌더링 시점마다 localStorage를 기반으로 버튼 노출 여부를 클라이언트에서 판단
		
- 파일 다운로드 요청 시 서버에서 권한 확인
    
- localStorage는 서버에 요청하여 데이터를 갱신
        
    - 일정 주기 (ex: 5분)
        
    - localStorage 값이 없을 경우  

##### 방법 2: 
- 사용자는 한 가지 데이터를 localStorage에 캐시함:
    
    1. 자신의 권한 정보 -> `p.API.GetUser()`를 통해 조회 후 해시 처리
		
- 서버는 최초 설정 로딩 시 `KVStore("admin_settings").webapp`을 KVGet하여 메모리에 캐싱 (`atomic.Value`, `go-cache` 등 활용)
        
    1. 허용된 다운로드 권한 목록 -> `KVStore("admin_settings")`의 `"webapp.file_download_roles"` 값
        
- 채널 렌더링 시점마다 서버는 해시 처리된 `"webapp.file_download_roles"`를 전달하고, 
  응답받은 클라이언트는 localStorage의 자신의 권한 데이터와 비교하여 버튼 노출 여부를 결정
		
- 파일 다운로드 요청 시 서버에서 권한 확인
    
- localStorage는 서버에 요청하여 데이터를 갱신
        
    - 일정 주기 (ex: 5분)
        
    - localStorage 값이 없을 경우  
		
	- 새로고침 시
		
- 서버는 캐시된 값을 갱신
        
    - 일정 주기 (ex: 5분)
        
    - localStorage 값이 없을 경우  


>[!note] 캐시 저장/조회 방식에 localStorage를 선택한 이유
>
>`localStorage`: **브라우저에 key-value 형태의 데이터를 영구 저장**하는 Web API
>1. 민감한 정보가 아님
>   
>2. 사용자마다 다름
>   
>3. 페이지  전환/새로고침 시에도 유지
>   
>4. 서버 전송이 필요 없음

---

####  `server` 관련 설정 (예: 특정 채널에서 searchablePDF 기능 활성화 여부)

- 관리자가 설정을 저장하면, **KVStore의 key `"admin_settings"`에 `"server"` 값을 포함하여 저장됨**
    
- 서버는 최초 설정 로딩 시 `KVStore("admin_settings").server`를 KVGet하여 메모리에 캐싱 (`atomic.Value`, `go-cache` 등 활용)
    
- 이후 주요 서버 기능 수행 시 해당 캐시된 값을 기반으로 설정 적용 여부를 판단
	    
    - 예1: 이미지 또는 PDF 업로드 → `channel_settings.searchablePDF` 여부 판단
        
    - 예2: 파일을 클릭하여 어노테이션 정보를 서버가 수집하는 경우 → 해당 채널의 `use_annotation` 여부 확인
		
- 서버는 캐시된 값을 갱신
        
    - `KVStore("admin_settings").server` 에 KVSet 이벤트 발생 시점


---

### - 추가적으로 고려해야 할 사항

**문제점 및 개선 방안**
		
- KVStore 부분 수정이 불가능함
		  
	- 하나의 JSON 구조로 저장하면 일부 필드만 수정할 수 없음
		
- 플러그인 설정 데이터가 커지면 JSON 직렬화/역직렬화 시점 리소스 낭비

