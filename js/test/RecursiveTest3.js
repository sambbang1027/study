// 피보나치 수 계산하기
// 중요도: 5
// 피보나치 수는 첫째와 둘째 항이 1이며 그 뒤의 모든 항은 바로 앞 두 항의 합인 수열로, Fn = Fn-1 + Fn-2라는 공식으로 표현할 수 있습니다.

// 처음 두 항은 1이고, 그다음 항들은 2(1+1),3(1+2),5(2+3)이므로 전체 수열은 1, 1, 2, 3, 5 , 8, 13, 21 ... 형태를 띱니다.

// 피보나치 수는 황금 비율 등 우리 주변을 둘러싼 수많은 자연 현상과 관련이 있습니다.

// n 번째 피보나치 수를 반환하는 함수 fib(n)을 작성해보세요.

// 예시:

// alert(fib(3)); // 2
// alert(fib(7)); // 13
// alert(fib(77)); // 5527939700884757
// 주의: fib (77)를 호출했을 때 연산 시간이 1초 이상 되면 안 됩니다.

//console.log(fib(3));
//console.log(fib(7));
console.log(fib(77)); // 재귀 사용시 너무 느림.. 오늘안에 못할지두 


function fib(n) { 
    // 재귀 사용 
    // if(n == 1 || n == 2 ){
    //     return 1;
    // }else{
    //     return fib(n-1) + fib(n-2);
    // }

    // 반복문 사용 
    let first = 1;
    let last = 1;
    for(let i = 2; i< n; i++){
        
        let sum = first + last;
        first = last;
        last = sum;      
    }
    return last;

}