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
        for (Entry e : list) {
            if (e.timestamp == timestamp) {
                 s=e.value;
            }else if(e.timestamp < timestamp){
                s=e.value;
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
