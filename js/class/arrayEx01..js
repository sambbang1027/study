let users =[
    {id : 1, name : "Johnny"},
    {id : 2, name : "Mark"},
    {id : 3, name : "Yuta"},
];

// find 는 함수로 넘겨준 조건이 true/ false가 되는 식을 넣어줘야함 
let user = users.find(item => item.id % 2 == 1);
let userIndex = users.findIndex(item => item.id % 2 == 1);

console.log(user.name);

console.log(users[userIndex]);

console.log(users.filter(user => user.id % 2 == 1));