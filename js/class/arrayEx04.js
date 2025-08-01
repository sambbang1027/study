let names = "Mark, Johnny, Yuta";

let arr = names.split(', ');

for (let name of arr){
    console.log(`${name}에게 보내는 메세지`); // Mark에게 보내는 메세지 
}

arr.forEach(name => console.log(`${name}에게 보내는 메세지`));

names.split(', ').forEach(name => console.log(`${name}에게 보내는 메세지`));

