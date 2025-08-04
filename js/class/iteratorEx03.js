let arrayLike = {
    0: "Hello",
    1 : "World",
    length : 2

};

let arr = Array.from(arrayLike, word => word[0].toLowerCase);

console.log(arr);
