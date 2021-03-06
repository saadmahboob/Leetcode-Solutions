import java.util.LinkedList;

public class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for(Character c: s.toCharArray()){
            if(c == '{' || c == '(' || c == '['){
                stack.push(c);
            }
            else{
                if(c == ')'){
                    if(stack.isEmpty() || stack.pop() != '(') return false;
                }else if(c == '}'){
                    if(stack.isEmpty() || stack.pop() != '{') return false;
                }else if(c == ']'){
                    if(stack.isEmpty() || stack.pop() != '[') return false;
                }else return false;
            }
        }
        return stack.isEmpty();
    }
}

public class Solution {
    
    boolean couple(Character l, Character r){
        if(l == null) return false;
        return (l == '[' && r == ']') || (l == '(' && r == ')') || (l == '{' && r == '}');
    }
    
    public boolean isValid(String s) {
        if(s == null) return false;
        
        char[] chars = s.toCharArray();
        
        if(chars.length == 0 || chars.length % 2 == 1) return false;
        
        LinkedList<Character> stack = new LinkedList<Character>();
        
        for(char c: chars){
            Character peek = stack.peek();

            if(couple(peek, c)){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        
        return stack.size() == 0;
    }
}
