// 유럽 기준 달력
// 중요도: 5
// 유럽국가의 달력은 월요일부터 시작합니다(월요일-1, 화요일-2, … 일요일-7). ‘유럽’ 기준 숫자를 반환해주는 함수 getLocalDay(date)를 만들어보세요.

let date = new Date(2019, 11, 5);  // 2019년 11월 5일
console.log(getLocalDay(date));

function getLocalDay(date){
    let day = date.getDay();
    console.log(day);

    if(day == 0){
        day = 7;
    }
    return day;
    
}