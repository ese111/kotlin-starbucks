INSERT INTO product
    (korean_title, english_title, description, price, calorie, sugars, na, caffeine, fat, protein, order_count, image_url)
VALUES
    ('카페라떼', 'Caffe Latte', '대표적인 카페 라떼', 5000, 110, 9, 8, 75, 6, 6,9, 'https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[41]_20210415133833879.jpg'),
    ('콜드브루', 'Cold brew', '바리스타의 정성으로 탄생한 콜드브루', 4900, 5, 0, 0, 150, 0, 0,8, 'https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000038]_20210430113202595.jpg'),
    ('바닐라 크림 프라푸치노', 'Vanilla Cream Frappuccino', '신선한 우유와 바닐라 시럽이 어우러진 크림 프라푸치노', 5100, 200, 28, 28, 0, 8, 4,7, 'https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[41]_20210415133833879.jpg'),
    ('쿨라임 피지오', 'Cool Lime Fizzio', '스파클링한 시원하고 청량감 있는 음료', 5900, 105, 28, 25, 110, 0, 0,1, 'https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[107051]_20210419112152119.jpg'),
    ('카페 아메리카노', 'Caffe Americano', '깔끔하게 에스프레소를 느낄 수 있는 커피', 4500, 5, 0, 0, 75, 0, 0,0, 'https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[41]_20210415133833879.jpg'),
--     ('나이트로 바닐라 크림', 'Nitro Vanilla Cream', '부드러운 목넘김',
--      5900, 75, 10, 20, 1, 245, 2, 0,
--      'https://www.shinsegaegroupnewsroom.com/wp-content/uploads/2019/12/20191107-%EC%8A%A4%ED%83%80%EB%B2%85%EC%8A%A4-%EC%82%AC%EC%A7%84%EC%9E%90%EB%A3%8C2_%EC%8A%A4%ED%83%80%EB%B2%85%EC%8A%A4-%EB%82%98%EC%9D%B4%ED%8A%B8%EB%A1%9C-%EC%BD%9C%EB%93%9C-%EB%B8%8C%EB%A3%A8-%EC%9D%8C%EB%A3%8C-3%EC%A2%85.png'),
    ('클래식 스콘', 'Classic Scone', '프랑스산 고급 버터로 만든 담백한 스콘입니다.',
    3300, 468, 17, 435, 0, 32, 4, 0,
    'https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9300000001557]_20210422112532988.jpg'),
    ('미니 클래식 스콘', 'Mini Classic Scone', '미니 사이즈의 담백한 스콘입니다.',
    4000, 456, 12, 383, 0, 25, 7, 0,
    'https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[5110001099]_20210421161145813.jpg'),
    ('트리플 미니 스콘', 'Triple Mini Scone', '헤이즐넛 초콜릿, 치즈, 크랜베리 세 가지 맛의 스콘이 각각 들어있는 미니 사이즈의 스콘입니다.',
    4300, 468, 16, 487, 0, 22, 8, 0,
    'https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9300000003041]_20210427162406865.jpg'),
    ('아이스 카페 아메리카노', 'Iced Caffe Americano', '진한 에스프레소에 시원한 정수물과 얼음을 더하여 스타벅스의 깔끔하고 강렬한 에스프레소를 가장 부드럽고 시원하게 즐길 수 있는 커피',
    5300, 10, 0, 5, 150, 0, 1, 0,
    'https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[110563]_20210426095937947.jpg'),
    ('나이트로 콜드 브루', 'Nitro Cold Brew', '나이트로 커피 정통의 캐스케이딩과 부드러운 콜드 크레마!\r\n부드러운 목 넘김과 완벽한 밸런스에 커피 본연의 단맛을 경험할 수 있습니다.',
    6000, 5, 0, 5, 245, 0, 0, 0,
    'https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000000479]_20210426091844065.jpg'),
    ('라벤더 카페 브레베', 'Lavender Cafe Breve', '진한 리저브 에스프레소 샷과 은은한 라벤더향이 고급스럽게 어우러진 부드럽고 세련된 풍미의 라벤더 카페 브레베',
    7000, 400, 30, 140, 105, 27, 8, 0,
    'https://image.istarbucks.co.kr/upload/store/skuimg/2022/04/[9200000004119]_20220412083026158.png');

INSERT INTO category (korean_name, english_name, type, image_url)
VALUES ('콜드브루','Cold brew', 'DRINK', 'https://image.istarbucks.co.kr/upload/store/skuimg/2022/04/[9200000003988]_20220406113215431.jpg'),
       ('에스프레소','Espresso', 'DRINK', 'https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[20]_20210415144112850.jpg'),
       ('프라푸치노','Frappuccino', 'DRINK', 'https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9200000002760]_20210415133558221.jpg'),
       ('브레드','Bread', 'FOOD', 'https://image.istarbucks.co.kr/upload/store/skuimg/2022/04/[9300000004026]_20220406130314367.jpg'),
       ('케이크','Cake', 'FOOD', 'https://image.istarbucks.co.kr/upload/store/skuimg/2022/04/[9300000004034]_20220406125047338.jpg'),
       ('샌드위치 & 샐러드','Sandwich & Salad', 'FOOD', 'https://image.istarbucks.co.kr/upload/store/skuimg/2022/02/[9300000003523]_20220218132118557.jpg'),
       ('머그','Mug', 'GOODS', 'https://image.istarbucks.co.kr/upload/store/skuimg/2021/11/[9300000003570]_20211102085024757.jpg'),
       ('글라스','Glass', 'GOODS', 'https://image.istarbucks.co.kr/upload/store/skuimg/2020/02/[11108665]_20200225094939210.jpg'),
       ('플라스틱 텀플러','Plastic Tumbler', 'GOODS', 'https://image.istarbucks.co.kr/upload/store/skuimg/2022/04/[9300000003796]_20220406140300832.jpg');
INSERT INTO event
(title, description, start_date_time, end_date_time, main, event_product_name, target, image_url)
VALUES
    ('22 서머 e-프리퀀시 이벤트 안내', '다가올 여행의 모양은 모두 다르지만, 즐거운 여행 속 \'나\'에게 기대감과 즐거움을 주는 스타벅스의 여름 이야기.',
     '2022-05-01', '2023-05-01', true, '아이스 아메리카노', '모든 스타벅스 회원', null),
    ('만원당 별 적립 이벤트', '회원 계정에 등록된 스타벅스 카드로 결제 시, 1만원당 별 1개를 즉시 추가로 드립니다!',
     '2022-01-01', '2023-12-31', false, '모든 상품', '스타벅스 리워드 전 회원', null),
    ('감사의 달 e-Gift 선물하기 이벤트', '스타벅스 e-Gift와 함께 고마운 마음을 전해 보세요!',
     '2022-04-01', '2022-05-01', false, '모든 상품', '모든 스타벅스 회원', null),
    ('스타벅스 현대카드 5월 한정 혜택', '별처럼 쏟아지는 선물같은 혜택 스타벅스 현대카드가 준비했어요!',
     '2023-05-01', '2023-06-01', false, '프라푸치노', '모든 스타벅스 회원', null);

