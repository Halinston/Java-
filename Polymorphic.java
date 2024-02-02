/**
 * 
 * @author YOUR NAME 
 *
 */

 public class Polymorphic {
    
    public static boolean isSorted(Relatable[] objArray) {
        int length = objArray.length;
        
        for (int i = 0; i < length - 1; i++) {
            if (!objArray[i].isLess(objArray[i + 1])) {
                return false;
            }
        }
        
        return true;
    }
}
