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
        int low=0;
        int high = list.size()-1;
        int res=-1;
        while(low<=high){
            int mid = low+(high - low)/2;
            if(list.get(mid).timestamp==timestamp){
                s=list.get(mid).value;
                return s;
            }else if(list.get(mid).timestamp<timestamp){
                res = mid;
                low = mid+1;
            }else{
                high=mid-1;
            }
        }
        if(res==-1){
            return "";
        }
        s=list.get(res).value;
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
