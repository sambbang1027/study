// 일초 간격으로 숫자 출력하기
// 중요도: 5
// from에 명시한 숫자부터 to에 명시한 숫자까지 출력해주는 함수 printNumbers(from, to)를 만들어보세요. 숫자는 일 초 간격으로 출력되어야 합니다.

// 두 가지 방법을 사용해 함수를 만드셔야 합니다.

// setInterval을 이용한 방법
// 중첩 setTimeout을 이용한 방법


// setInterval 이용 
function printNumbers(from, to){
    let start = from;

    let timerId = setInterval(function(){
        console.log(start);
        if(start == to){
            clearInterval(timerId);
        }
        start++;
    }, 1000);

}
//printNumbers(3,10);

function printNumbers2 ( from , to){
    let start = from;

    setTimeout(function count(){
        console.log(start);
        if(start < to){
            setTimeout(count, 1000);
        }
        start++;
    }, 1000)
}
printNumbers2(3, 6);