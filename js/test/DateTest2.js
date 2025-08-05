//  요일 보여주기
// 중요도: 5
// 날짜를 입력하면 ‘MO’, ‘TU’, ‘WE’, ‘TH’, ‘FR’, ‘SA’, ‘SU’ 형식으로 요일을 보여주는 함수 getWeekDay(date)를 만들어보세요.

// 예시:

// let date = new Date(2012, 0, 3);  // 2012년 1월 3일
// alert( getWeekDay(date) );        // "TU"가 출력되어야 합니다. 


let date = new Date(2012, 0, 3);  // 2012년 1월 3일
console.log(getWeekDay(date));

function getWeekDay(dt){
    let day= dt.getDay();
    console.log('day : ',day);

    switch(day){
        case 0 : return 'MO'; break;
        case 1 : return 'TU'; break;
        case 2 : return 'WE'; break;
        case 3 : return 'TH'; break;
        case 4 : return 'FR'; break;
        case 5 : return 'SA'; break;
        case 6 : return 'SU'; break;
    }
}
function getWeekDay2(date) {
  let days = ['SU', 'MO', 'TU', 'WE', 'TH', 'FR', 'SA'];

  return days[date.getDay()];
}
