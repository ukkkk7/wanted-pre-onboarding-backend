#  Wanted-pre-onboarding-backend
<br>

##  요구사항 분석 및 설계  

### 개발환경
- Java 11
- intellij
- spring boot(2.x)
- MySQL
- JPA


<br>

### ERD

<img src="https://github.com/ukkkk7/Spring/assets/117158625/8d765f79-6064-4459-98c1-897f1c7ffed8" width="350" height="350"/><br>

<img src="https://github.com/ukkkk7/Spring/assets/117158625/be80db2f-2818-4c69-96a6-245638b345cd" width="450" height="400"/><br>



#### 엔티티
사용자(member) <br>
지원내역(apply_information) <br>
회사(company) <br>
지원공고(recruitment) <br>

<br><br><br>


#### 프로젝트 구조
```
ApplyInformation, Member, Company, Recruitment

|- controller

|- repository

|- domain

|- service

|- exception


DuplicateApplicationException: 이미 지원한 공고에 재지원 했을 때 예외 발생

```


<br><br><br>

## API 설계



| CRUD | URI | HTTP |
| --- | --- | --- |
| 채용공고 등록 | /recruitment/add | POST |
| 채용공고 수정 | /recruitment/update/{id} | PATCH |
| 채용공고 삭제 | /recruitment/delete/{id} | DELETE |
| 채용공고 전체 조회 | /recruitment/list | GET |
| 채용공고 상세페이지 | /recruitment/detail/{id} | GET |
| 채용공고 검색 | /recruitment/search/{keyword} | GET |
| 채용공고에 지원 | /recruitment/apply | POST |




<br><br><br><br><br>

## 기능구현

### 채용공고 등록
<img src="https://github.com/ukkkk7/Spring/assets/117158625/251d4a58-eedc-4d50-86a7-105fa8b8f5da" width="450" height="400"/><br><br><br>


### 채용공고 수정
<img src="https://github.com/ukkkk7/Spring/assets/117158625/251d4a58-eedc-4d50-86a7-105fa8b8f5da" width="450" height="400"/><br><br><br>

### 채용공고 삭제
<img src="https://github.com/ukkkk7/wanted-pre-onboarding-backend/assets/117158625/97b811c7-569f-4bb0-ba96-bdf051490f9c" width="450" height="400"/><br><br><br>

### 채용공고 전체 조회
<img src="https://github.com/ukkkk7/Spring/assets/117158625/11da3472-8fba-4c4c-a0bc-18ab79805ac7" width="450" height="400"/><br><br><br>

### 채용공고 상세페이지 + 해당 회사가 올린 다른 채용공고
<img src="https://github.com/ukkkk7/Spring/assets/117158625/60c7673a-713d-4657-96d4-527d4f8ccd07" width="450" height="400"/><br><br><br>


### 채용공고 검색
<img src="https://github.com/ukkkk7/Spring/assets/117158625/e4070b0d-2edf-4eba-8bc4-04023e97e2f5" width="450" height="400"/><br><br><br>


### 사용자가 채용공고 지원
<img src="https://github.com/ukkkk7/Spring/assets/117158625/b18df250-bbc7-4951-8b29-ac89ca55a40a" width="450" height="400"/>

### 이미 지원한 채용공고 지원불가
<img src="https://github.com/ukkkk7/Spring/assets/117158625/e121ad64-76ab-4625-b0c7-8403a693f17a" width="450" height="400"/><br><br><br>
