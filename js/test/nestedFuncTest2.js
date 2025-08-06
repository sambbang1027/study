// 필드를 기준으로 정렬하기
// 중요도: 5
// 객체가 담긴 배열을 정렬해야 한다고 가정해봅시다.

// let users = [
//   { name: "John", age: 20, surname: "Johnson" },
//   { name: "Pete", age: 18, surname: "Peterson" },
//   { name: "Ann", age: 19, surname: "Hathaway" }
// ];
// 아래와 같은 방법을 사용해 정렬할 수 있을 겁니다.

// // 이름을 기준으로 정렬(Ann, John, Pete)
// users.sort((a, b) => a.name > b.name ? 1 : -1);

// // 나이를 기준으로 정렬(Pete, Ann, John)
// users.sort((a, b) => a.age > b.age ? 1 : -1);
// 그런데, 아래와 같이 함수를 하나 만들어서 정렬하면 더 깔끔해질 것 같네요.

// users.sort(byField('name'));
// users.sort(byField('age'));
// 함수를 직접 만들어 sort에 넘기는 것보다 byField(fieldName)를 넘기는 것처럼 말이죠.

// 필드를 기준으로 정렬을 도와주는 함수 byField를 만들어봅시다.

let users = [
  { name: "John", age: 20, surname: "Johnson" },
  { name: "Pete", age: 18, surname: "Peterson" },
  { name: "Ann", age: 19, surname: "Hathaway" }
];


console.log(users.sort(byField('name')));
console.log(users.sort(byField('age')));

function byField(fieldName){
    return function(a, b){
        return a[fieldName] > b[fieldName] ? 1 : -1;
    };
}