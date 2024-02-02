// function someFunction() {
//     console.log('someFunction');
// }

// setInterval(someFunction, 5000);

// setInterval(() => console.log('someFunction'),
// 5000);


function filter(value) {
    return value % 2 === 0;
}

function isOdd(value) {
    return value % 2 != 0;
}

function getEvenNumbers(allNumbers, fn) {
    let numbers = [];

    for(number of allNumbers) {
        if(fn(number)) {
            numbers.push(number);
        }
    }

    return numbers;
}

let allNumbers = [1, 2, 4, 6, 7, 10, 9];
//console.log(getEvenNumbers(allNumbers, filter));
console.log(getEvenNumbers(allNumbers, isOdd));
