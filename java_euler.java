import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.Stream;

public class java_euler {

    private int problem_1(int n) {
        /*
        If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
        The sum of these multiples is 23.
        Find the sum of all the multiples of 3 or 5 below 1000.
        default: set n to 1000
         */
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    private int problem_2(int n) {
        /*
        Each new term in the Fibonacci sequence is generated by adding the previous two terms.
        By starting with 1 and 2, the first 10 terms will be:
        1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
        By considering the terms in the Fibonacci sequence whose values do not exceed four million,
        find the sum of the even-valued terms
        default: n = 4000000
         */
        int sum = 0;
        ArrayList<Integer> fiboList = new ArrayList<Integer>();
        fiboList.add(1);
        fiboList.add(2);
        int next = fiboList.get(fiboList.size() - 1) + fiboList.get(fiboList.size() - 2);
        do {
            fiboList.add(next);
            next = fiboList.get(fiboList.size() - 1) + fiboList.get(fiboList.size() - 2);
        } while(next <= n);
        for(int i = 0; i < fiboList.size(); i++) {
            int value = fiboList.get(i);
            if(value % 2 == 0) {
                sum += value;
            }
        }
        return sum;
    }

    private int problem_3(Double n) {
        /*
        The prime factors of 13195 are 5, 7, 13 and 29.
        What is the largest prime factor of the number 600851475143 ?
        default = 600851475143.
         */
        for(int i = 2; i <= Math.sqrt(n); i++) {
            while(n % i == 0) {
                n /= i;
            }
        }
        return n.intValue();
    }

    private int problem_4(int n) {
        /*
        A palindromic number reads the same both ways.
        The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
        Find the largest palindrome made from the product of two 3-digit numbers.
        default n = 999
        */
        int largest = 0;
        for(int a = n; a > 0; a--) {
            for(int b = n; b > 0; b--) {
                int c = a * b;
                String c_string = Integer.toString(c);
                if(c_string.equals(reverseString(c_string))) {
                    if(c > largest) {
                        largest = c;
                    }
                }
            }
        }
        return largest;
    }

    public static String reverseString(String myStr)
    {
        if (myStr.isEmpty()){
            return myStr;
        }
        //Calling Function Recursively
        return reverseString(myStr.substring(1)) + myStr.charAt(0);
    }

    private int problem_5(int n) {
        /*
        2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
        What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
        */
        int i = 1;
        while(!is_divisible_up_to(i, n)) {
            i++;
        }
        return i;
    }

    private boolean is_divisible_up_to(int value, int n) {
        for(int i = 1; i <= n; i++) {
            if(value % i != 0) {
                return false;
            }
        }
        return true;
    }

    private int problem_6(int n) {
        /*
        The sum of the squares of the first ten natural numbers is,
        12 + 22 + ... + 102 = 385
        The square of the sum of the first ten natural numbers is,
        (1 + 2 + ... + 10)2 = 552 = 3025
        Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
        Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
        */
        int sum_of_squares = find_sum_of_squares(n);
        int square_of_sums = find_square_of_sum(n);
        int difference = square_of_sums - sum_of_squares;
        return difference;
    }

    private int find_sum_of_squares(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += Math.pow(i, 2);
        }
        return sum;
    }

    private int find_square_of_sum(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i;
        }
        return (int) Math.pow(sum, 2);
    }

    private int problem_7(int n) {
        /*
        By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
        What is the 10 001st prime number?
        */
        ArrayList<Integer> prime_list = new ArrayList<Integer>();
        int i = 2;
        while(prime_list.size() < n) {
            int counter = 0;
            for(int prime: prime_list ) if(i % prime == 0) counter++;
            if(counter == 0) prime_list.add(i);
            i++;
        }
        System.out.println(prime_list);
        int final_element = prime_list.get(prime_list.size()-1);
        return final_element;
    }

    private int problem_8(int n) {

        /*
        The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
        73167176531330624919225119674426574742355349194934
        96983520312774506326239578318016984801869478851843
        85861560789112949495459501737958331952853208805511
        12540698747158523863050715693290963295227443043557
        66896648950445244523161731856403098711121722383113
        62229893423380308135336276614282806444486645238749
        30358907296290491560440772390713810515859307960866
        70172427121883998797908792274921901699720888093776
        65727333001053367881220235421809751254540594752243
        52584907711670556013604839586446706324415722155397
        53697817977846174064955149290862569321978468622482
        83972241375657056057490261407972968652414535100474
        82166370484403199890008895243450658541227588666881
        16427171479924442928230863465674813919123162824586
        17866458359124566529476545682848912883142607690042
        24219022671055626321111109370544217506941658960408
        07198403850962455444362981230987879927244284909188
        84580156166097919133875499200524063689912560717606
        05886116467109405077541002256983155200055935729725
        71636269561882670428252483600823257530420752963450
        Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
         */
        int largest = 0;
        String grid = "73167176531330624919225119674426574742355349194934" +
                "96983520312774506326239578318016984801869478851843" +
                "85861560789112949495459501737958331952853208805511" +
                "12540698747158523863050715693290963295227443043557" +
                "66896648950445244523161731856403098711121722383113" +
                "62229893423380308135336276614282806444486645238749" +
                "30358907296290491560440772390713810515859307960866" +
                "70172427121883998797908792274921901699720888093776" +
                "65727333001053367881220235421809751254540594752243" +
                "52584907711670556013604839586446706324415722155397" +
                "53697817977846174064955149290862569321978468622482" +
                "83972241375657056057490261407972968652414535100474" +
                "82166370484403199890008895243450658541227588666881" +
                "16427171479924442928230863465674813919123162824586" +
                "17866458359124566529476545682848912883142607690042" +
                "24219022671055626321111109370544217506941658960408" +
                "07198403850962455444362981230987879927244284909188" +
                "84580156166097919133875499200524063689912560717606" +
                "05886116467109405077541002256983155200055935729725" +
                "71636269561882670428252483600823257530420752963450";

        for(int i = 0; i < grid.length() - n; i++) {
            String chunk = grid.substring(i, i + n);
            System.out.println("Chunk: " + chunk);
            int product = 1;
            for(int j = 0; j < n; j++) {
                int digit = Integer.parseInt(chunk.substring(j, j + 1));
                product = product * digit;
                System.out.println(digit);
                System.out.println(product);
            }
            //System.out.println(chunk);
            //System.out.println(product);
            if(product > largest) largest = product;
        }
        return largest;
    }

    public java_euler() {
    }

    public static void main(String[] args) {
        java_euler solutions = new java_euler();
        System.out.println(solutions.problem_8(13));
    }
}
