
![ezgif com-gif-maker (2)](https://user-images.githubusercontent.com/79190824/175613582-0bffa564-09f8-40a9-9f39-55facbc9eef1.gif)





## 📃 Summary

---

비슷한 기능인 다른 라이브러리들의 차이를 경험해보고 적용해보기 위해서 StarBucks 앱을 구현해보는 프로젝트를 진행해보았습니다.

## 💻 Part

---

- 안드로이드 전체 구현
    - `REST API`와 `Retrofit2` 이용한 서버 통신 구현
    - `sharedpreferences`를 이용한 24시간동안 Dialog 안보이게 하기 구현
    - `Koin`을 통한 의존성 주입 구현
    - `Room`을 이용한 데이터 저자/삭제 구현
    - `tabLayout`을 통한 화면 이동 구현

## ✏️ Learn

---

- `Retrofit2`를 이용해서 받아온 `Json` 형태의 데이터를 `Serialization`을 이용해서 객체로 변환하여 이용하는 법을 학습하였습니다.
    - `Retrofit2`에 `converter`를 추가하는 방법이 `Gson`과 달라서 검색을 통해서 `외부라이브러리`를 사용해야한다는 것을 인지해서 문제를 해결하였습니다.

- `sealed class`로 이루어진 `List`를 이용해서 첫 화면의 스크롤 화면을 `Recycler view`로 구현하며 `scoll view` 대신 `Recycler view`를 이용한 구현을 하는 방법을 학습하였습니다.

- `sharedpreferences`를 이용해서 처음 이벤트 화면에서 다시 보지 않기를 눌렀을때 시간을 저장해 놓고 현재시간을 확인해서 24시간이 지나지 않으면 이벤트 화면을 표시하지 않도록 구현하였습니다.
    - `sharedpreferences`를 이용하여 간단한 데이터를 저장하는 방법을 학습하였습니다.

- `jeckpack navigation`을 이용해서 `Bottom navigtion`을 구현하고 order 화면 안에서 `tab layout`을 이용해서 `fragment` 안에서의 화면 이동을 구현하였습니다.

- `image load`를 `Glide` 대신 `Coil`을 이용해서 구현해보고 둘의 차이를 학습하였습니다.

- `LiveData`를 이용해서 `viewModel`에서 저장하던 데이터를 `StateFlow`로 대체하는 작업을 진행해보았습니다.
    - `Activity`에서 `observer`를 `lifecycleScope`와 `repeatonlifecycle`을 통해서 `StatFlow`를 `collect` 하도록 변환하는 과정에서 공식문서를 통해서 그 이유를 학습하고, 적용을 진행하였습니다.

- `DI`를 `Hilt`를 대신해서 `Koin`을 사용하여 구현을 하였습니다.
    - `Hilt`와 `Koin`의 차이점을 경험할 수 있었고 둘의 장단점을 비교해볼 수 있었습니다.
    
- `Room`을 이용한 나만의 메뉴 기능 구현을 통해서 `Room`을 사용해서 내부저장소에 데이터를 저장하고 불러오는 것을 학습할 수 있었고 `SQLite`와의 차이점도 학습할 수 있었습니다.

## 🕶Team

---

안드로이드 : 1명

백엔드 : 2명
