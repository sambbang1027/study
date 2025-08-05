// 주어진 숫자까지의 모든 숫자 더하기
// 중요도: 5
// 숫자 1 + 2 + ... + n을 계산하는 함수 sumTo (n)을 만들어보세요.

// 예시:

// sumTo(1) = 1
// sumTo(2) = 2 + 1 = 3
// sumTo(3) = 3 + 2 + 1 = 6
// sumTo(4) = 4 + 3 + 2 + 1 = 10
// ...
// sumTo(100) = 100 + 99 + ... + 2 + 1 = 5050
// 아래 방법을 사용해 세 가지 답안을 만들어보세요.

// for 반복문 사용하기
// 재귀 사용하기(n > 1일 때 sumTo(n) = n + sumTo(n-1))
// 등차수열 공식 사용하기
// 예시:

console.log(sumTo(3));

  //1.  for 문 
// function sumTo(n) {
//     let sum = 0; 
//     for(let i = 1; i <= n; i ++){
//         sum += i;
//     }
//     return sum;
//  }

    //2.  재귀 사용
    // function sumTo(n){
    //     if(n == 1){
    //         return n;
    //     }else{
    //         return n + sumTo(n-1);
    //     }
    // }


    // 3. 등차 수열 
    /* n개의 항이 존재하고 이전 항과 다음 항이 일정하게 증가할 때 
    합집합 : n(첫번째 항 + 마지막 항)/2 
    */
   function sumTo(n){
    return n*(1 + n)/2;
   }
