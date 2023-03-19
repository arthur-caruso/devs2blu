all = [];
for (i = 0; i < 3; i++) {
    arr = [];
    for (j = 0; j < 10; j++)
        arr.push(Math.floor(10 * Math.random() + 1));
    all = all.concat(arr);
}

console.log(all);
