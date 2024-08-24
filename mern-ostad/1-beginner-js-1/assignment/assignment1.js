function multiplicationTable(num) {
    if (!isNaN(num)) {
        for (let iteration = 1; iteration <= 10; iteration++) {
            let product = iteration * num;
            console.log(num, 'x', iteration, " = ", product);
        }
    } else {
        console.log('Please enter a number');
    }
}

multiplicationTable(3)

