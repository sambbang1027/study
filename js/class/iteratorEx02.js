let str = 'Hello';

let iterator = str[Symbol.iterator]();

console.log(iterator.next()); //{ value: 'H', done: false }
console.log(iterator.next()); //{ value: 'e', done: false } 
console.log(iterator.next()); //{ value: 'l', done: false }

while(true){
    let result = iterator.next();
    if(result.done) break;
    console.log(result);

}


for(let letter of str){
    console.log(letter);
    
}
