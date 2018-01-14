
//Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.
//(Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)

//Example 1:

//Input: L = 6, R = 10
//Output: 4
//Explanation:
//6 -> 110 (2 set bits, 2 is prime)
//7 -> 111 (3 set bits, 3 is prime)
//9 -> 1001 (2 set bits , 2 is prime)
//10->1010 (2 set bits , 2 is prime)
//Example 2:

//Input: L = 10, R = 15
//Output: 5
//Explanation:
//10 -> 1010 (2 set bits, 2 is prime)
//11 -> 1011 (3 set bits, 3 is prime)
//12 -> 1100 (2 set bits, 2 is prime)
//13 -> 1101 (3 set bits, 3 is prime)
//14 -> 1110 (3 set bits, 3 is prime)
//15 -> 1111 (4 set bits, 4 is not prime)

class Solution {
    fun countPrimeSetBits(L: Int, R: Int): Int {

        var primes = 0
        for (i in L..R) {
            var binaryStr = Integer.toBinaryString(i)
            var setBitCount = 0

            for (c: Char in binaryStr) {
                if (c == '1') {
                    setBitCount++
                }
            }

            println(binaryStr + " ($setBitCount) is prime: " + isPrime(setBitCount))

            if (isPrime(setBitCount)) {
                primes++
            }
        }

        return primes
    }

    fun isPrime(n: Int): Boolean {

        if (n == 1 || (n > 2 && n % 2 == 0)) return false

        val cap: Int = (Math.sqrt(n.toDouble())).toInt()

        for (i in 3..cap step 2) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }
}
