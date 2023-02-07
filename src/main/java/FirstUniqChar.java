import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {
    int firstUniqChar(String s) {
        if (s == null || s.trim().equals("")) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Integer count = map.get(s.charAt(i));
            if (count == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), ++count);
            }
        }

        for(int i = 0;i < s.length();i++){
            Integer count = map.get(s.charAt(i));
            if(count == 1){
                return i;
            }
        }

        return -1;
    }
}
