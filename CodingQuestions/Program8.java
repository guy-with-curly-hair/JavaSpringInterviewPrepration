package CodingQuestions;

import java.util.*;

// Do not edit the class below except for the insertKeyValuePair,
// getValueFromKey, and getMostRecentKey methods. Feel free
// to add new properties and methods to the class.
class Program8 {
  static class LRUCache {
    int maxSize;
    HashMap<String,Integer> lru;

    public LRUCache(int maxSize) {
      this.maxSize = maxSize > 1 ? maxSize : 1;
       lru = new LinkedHashMap<>(maxSize);
    }

    public void insertKeyValuePair(String key, int value) {

      Iterator<Map.Entry<String, Integer>> it = lru.entrySet().iterator();
      Map.Entry<String, Integer> lastEntry = null;
      while(it.hasNext())
      {
        lastEntry = it.next();
      }
      if ( maxSize == lru.size())
      {
        String lastKey = lastEntry.getKey();
        lru.remove(lastKey);
      }
      lru.put(key,value);
      // Write your code here.
    }

    public LRUResult getValueFromKey(String key) {
      if( lru.containsKey(key))
      {
        int value = lru.get(key);
        lru.remove(key);
        lru.put(key,value);
        return new LRUResult(true, value);

        }
      return null;
    }

    public String getMostRecentKey() {

      Set<Map.Entry<String, Integer>> it = lru.entrySet();
      int[] a = new int[5];
return null;
    }
  }

  static class LRUResult {
    boolean found;
    int value;

    public LRUResult(boolean found, int value) {
      this.found = found;
      this.value = value;
    }
  }
}
