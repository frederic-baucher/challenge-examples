
export class Fibonacci {

    static main() {

    }

    static process(n) {
        if (n <= 1) return n;
        else return Fibonacci.process(n - 1) + Fibonacci.process(n - 2);
    }
}
