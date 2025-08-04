let lor = ["Bilbo", "Gandalf", "Nazgul"];

function getLength(name){
    return `${name}(${name.length})`;
}

let result = lor.map(getLength);
console.log(result);



// 화살표 함수로 변환 
// 결과물은 배열에 있는 이름을 가져다 ${name}... 의 값들에 매핑하겠다는 것을 의미한다 
let result1 = lor.map(name=> `${name}(${name.length})`);
console.log(result1);


