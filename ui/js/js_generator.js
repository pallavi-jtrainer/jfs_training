function* fnGenerator() {
    console.log("Generating code...");
    yield 1
    console.log("================================");
    yield 2
}

let gen = fnGenerator();

console.log(gen);

let result = gen.next();
console.log(result);

result = gen.next();
console.log(result);