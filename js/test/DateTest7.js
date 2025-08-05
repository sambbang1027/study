// 몇 초나 남았을까요?
// 중요도: 5
// 오늘 하루가 끝날 때까지 남은 초를 반환해주는 함수 getSecondsToTomorrow()를 만들어보세요.

// 현재 시각이 23:00이라면 아래와 같은 결과가 나와야 합니다.

// getSecondsToTomorrow() == 3600
// 주의: 어떤 날이든 함수를 호출했을 때, 원하는 결과가 반환되어야 합니다. '오늘’을 나타내는 값을 하드 코딩하지 마세요.

getSecondsToTomorrow();

function getSecondsToTomorrow(){
    let now = new Date();
    console.log('오늘 ',now.toString());
    
    let tmr = new Date(now.getFullYear(), now.getMonth(), now.getDate()+1);
    console.log('내일 ',tmr.toString());
    
    let restSec = tmr - now;
    console.log('남은 초 ',Math.round(restSec.toString()/1000));
    
    return Math.round(restSec.toString()/1000);
}