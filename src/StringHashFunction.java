/**
 * Test a hash function for string based keys
 * 
 * @author Daniel Valle
 */

package src.stringHashFunction;

import java.util.*;

public class StringHashFunction {
  public static void main(String[] args) {
    // Create a list and fill it with some test strings
    LinkedList<String> namesList = new LinkedList<>();
    namesList.add("Daniel");
    namesList.add("lenidA");
    namesList.add("leinaD");
    namesList.add("Dilena");
    namesList.add("Danile");
    namesList.add("Daniela");
    namesList.add("Dani");
    namesList.add("Danielle");
    namesList.add("Dany");
    namesList.add("ynaD");

    // Test the hash code function
    int countCollisions = 0;
    Set<Integer> hashCodesSet = new HashSet<>();

    for (String name : namesList) {
      if (!hashCodesSet.add(hashCode(name))) {
        System.out.println("Ups... Collision for " + name);
        countCollisions++;
      }
    }

    // Show the results
    if (countCollisions > 0) {
      System.out.println("You have " + countCollisions + " collisions, try to improve your hash function...");
    } else {
      System.out.println("Excellent! 0 collisions...");
    }
  }

  /**
   * Returns an int hash value in range of 0 to size-1
   * generated from the given string and his characters
   * positions
   */
  public static int hashCode(String s) {
    int hashCode = 0;
    final int ARBITRARY_CONSTANT = 31;
    final int HASH_TABLE_SIZE = 50; 
    
    for (int i=0; i<s.length(); i++) {
      hashCode = ARBITRARY_CONSTANT * hashCode + s.charAt(i);
    }

    hashCode &= 0x7fffffff; // Delete negative sign and make a huge number
    hashCode %= HASH_TABLE_SIZE; // Normalize the number in range of 0 to size-1
    
    return hashCode;
  }
}
