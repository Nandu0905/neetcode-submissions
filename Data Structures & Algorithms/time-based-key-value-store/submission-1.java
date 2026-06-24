class TimeMap {

    Map<String,List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k-> new ArrayList<>()).add(new Entry(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Entry> list= map.get(key);
         if (list == null) {
            return "";
        }
        String s="";
         for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).timestamp <= timestamp) {
                return list.get(i).value;
            }
        } 
        return s;  
        }
    }

class Entry {
    String value;
    int timestamp;

    Entry(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
