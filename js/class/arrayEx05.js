let users = [
    {age : 20},
    {age : 30},
    {age : 23},
    {age : 17}
];

let army = {
    minAge : 18, 
    maxAge : 27,
    canJoin(user){
        return user.age >= this.minAge && user.age < this.maxAge;
        // this 안쓰고 직접 명시해줘도 됨  
        // 직접 명시했을 경우 filter(army.canJoin)만 쓰면 된다. 
    }
};

console.log(army.canJoin(users[0]));
console.log(army.canJoin(users[1]));
 
// army.canJoin 호출 시 참을 반환해주는 user 을 찾는다 
let soldiers = users.filter(army.canJoin, army);
console.log(soldiers);

for (let i = 0; i < users.length; i ++){
    let result = [];
    if (army.canJoin(users[i])) continue;
    result.push(users[i]);
}


