
import java.security.PublicKey;class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length == 0 || asteroids.length == 1) {
            return asteroids;
        }

        Stack<Integer> stk = new Stack<Integer>();
        stk.push(asteroids[0]);

        for(int i=1; i<=asteroids.length-1; i++) {
            int currentAsteroid = asteroids[i];

            if (stk.size() == 0) {
                stk.push(currentAsteroid);
                continue;
            }
            
            if ((stk.peek() > 0) && (currentAsteroid > 0)) {
                stk.push(currentAsteroid);
                continue;
            }

            if ((stk.peek() < 0) && (currentAsteroid < 0)) {
                stk.push(currentAsteroid);
                continue;
            }

            if ((stk.peek() < 0) && (currentAsteroid > 0)) {
                stk.push(currentAsteroid);
                continue;
            }

            // colliding direct with equal value :
            if ((stk.peek() > 0) && (currentAsteroid < 0) && 
                (Math.abs(stk.peek()) == Math.abs(currentAsteroid))) {
                stk.pop();
                continue;
            }

            // keep colliding until not done :
            while(!stk.isEmpty()) {
                if ((stk.peek() > 0 && currentAsteroid < 0)) {
                    if (Math.abs(stk.peek()) == Math.abs(currentAsteroid)) {
                        stk.pop();
                        break;
                    }
                    if (stk.peek() > Math.abs(currentAsteroid)) {
                        break;
                    }
                    stk.pop();
                    if (stk.size() < 1) {
                        stk.push(currentAsteroid);
                        break;
                    }
                    continue;
                }
                stk.push(currentAsteroid);
                break;
            }
            
        }

        int[] result = new int[stk.size()];
        int writeIndex = stk.size()-1;
        while(!stk.isEmpty()) {
            result[writeIndex] = stk.pop();
            writeIndex--;
        }
        return result;
        
    }
}