class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int i = s.length()-1;
        int prev=0;
        int value =0;
        while(i>=0){
            int current = map.get(s.charAt(i));
            if(current<prev){
                value-=current;
            }else{
                value+=current;
            }
            prev=current;
            i--;
        }
        return value;
    }
}