/**
 * This code shows the basic approach of how a compiler validates that open and close brackets
 * are used properly using a stack to keep track of open elements.
 * 
 * @author Daniel Valle
 */

import java.util.*;

public class BracketsParser {
  public static void main(String[] args) {
    // define supported brackets and map each open bracket with his opposite
    HashMap<Character, Character> bracketsMap = new HashMap<>();
    bracketsMap.put('{', '}');
    bracketsMap.put('(', ')');
    bracketsMap.put('[', ']');

    // testing bracket sequence
    String bracketSequence = "(a)";

    // testing results
    System.out.println(bracketSequence);
    System.out.println(isValidBracketSequence(bracketSequence, bracketsMap));
  }

  /**
   * Returns whether the bracket sequence is valid or not
   * @param bracketSequence the bracket sequence to validate
   * @param bracketsMap a map with the valid open brackets as keys and his
   * opposite as values
   * @return true if the bracket sequence is valid otherwise false
   */
  public static boolean isValidBracketSequence(String bracketSequence,
    HashMap<Character, Character> bracketsMap) {
    
    Stack<Character> stack = new Stack<>();

    for (var bracket : bracketSequence.toCharArray()) {
      boolean isOpenBracket = bracketsMap.containsKey(bracket);
      
      if (isOpenBracket) {
        stack.push(bracketsMap.get(bracket));
      } else {
        // verify that close bracket matches with the top of the stack
        if (!stack.isEmpty() && bracket == stack.peek()) {
          stack.pop();
        } else {
          return false;
        }
      }
    }

    // validate edge case when bracket sequence ends with an open bracket
    if (!stack.isEmpty()) {
      return false;
    }

    return true;
  }
}