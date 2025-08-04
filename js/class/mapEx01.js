let john = {name : 'John'};
let jane = {name : 'jane'};

//let visitCount = {};


// visitCount[john] = 123; // visitCount["[object Object]"] = 123;
// visitCount[jane] = 12; //  visitCount["[object Object]"] = 12;


let visitCount = new Map();

visitCount.set(john, 123)
          .set(jane, 12);
// 자기자신을 Return하기 때문에 체이닝 가능 




console.log(`${john.name}은 우리 가게를 ${visitCount.get(john)}번 방문했습니다.`);
console.log(`${jane.name}은 우리 가게를 ${visitCount.get(jane)}번 방문했습니다.`);

console.log(visitCount); // 비어있는 객체든 비어있지 않은 객체든 문자열로 출력하면 [object Object]를 출력한다 


