let arr = [15, 2 ,1];

//내부 정렬 
arr.sort();

console.log(arr);
//  1, 15, 2 로 정렬되는데 이는 문자열로 취급되어 재정렬되기 때문이다.


// 함수를 여러번 사용해야할 때 
function compare(a , b){
 
    if (a > b) return 1; // 첫 번째 값이 두 번째 값보다 큰 경우 
    if (a == b) return 0; // 두 값이 같은 경우 
    if (a < b) return -1;  // 첫 번째 값이 두 번째 값보다 작은 경우 
 
    // return a- b;  // 이렇게 간단하게 해도 됨  
}

function negCompare ( a, b){
    return b - a;
    // return compare(b , a);  // 이렇게 함수 호출도 가능 
}

arr.sort(compare);
console.log(arr);


// 화살표 함수로 더 간단하게 가능, 한번 쓰고 말거면 이 방식이 더 좋음 
arr.sort((x, y) => x - y );
console.log(arr); 

console.log(["Bilbo", "Gandalf", "Nazgul"]
    .map(item => item.length) // 길이별로 매핑
    .sort((x,y) => x - y) // 길이 수에 맞게 정렬하고 
    .reverse()); // 내림차순 시키기 