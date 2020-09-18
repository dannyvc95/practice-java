/**
 * Optimized algorithm to define if a given number
 * is a primer number or not
 * 
 * @author Daniel Valle
 */

package src;

import java.lang.Math;
import java.util.Random;

class IsPrimeNumber {

  public static boolean isPrime(int n) {
    if (n <= 1 || (n > 2 && n%2 == 0)) {
      // A number less than one or greater than two and 
      // also divisible by two is not a prime number
      return false;
    }

    int max = (int) Math.floor(Math.sqrt(n));
    for (int i=3; i<max+1; i+=2) {
      if (n%i == 0) {
        return false;
      }
    }

    return true;
  }
  public static void main(String[] args) {
    Random random = new Random();
    
    final int BOUND = 1_000_000;
    int rnumber = random.nextInt(BOUND);

    System.out.println(
      rnumber + ((isPrime(rnumber)) ? " is prime" : " is not prime")
    );

  }
}