
if __name__ == "__main__":
    import template
    import success
    import sys

    for n in range(0, 20):
        userValue = template.fibo(n)
        expectedValue = success.fibo(n)
        if userValue != expectedValue:
            print("Wrong value for fibo(" + str(n) + ")")
            print("> expected: " + str(expectedValue))
            print("> received: " + str(userValue))
            sys.exit(1)
    print("Good job ! Fibonacci works well!")
