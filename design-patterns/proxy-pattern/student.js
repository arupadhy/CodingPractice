class Student {

    constructor(name, standard, scores) {
        this.name = name;
        this.standard = standard;
        this.scores = scores;
    }

    get average() {
        const avg = this.scores.reduce((a,b) => a + b);

        return avg/this.scores.length;
    }
}

const john = new Student('Arvind', 'someGrade', [10, 20, 13, 34, 432, 33]);

// create a proxy for john and implement get trap

const johnProxy = new Proxy(john, {
    get: (target, key, context) => {
        console.log('get trap called for key ', key);
        return target[key];
    }
})

console.log(johnProxy.name);
console.log(johnProxy.standard);
console.log(johnProxy.average);