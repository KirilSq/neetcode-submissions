class TimeMap {
    
    record ValueAndTimestamp(String value, Integer timestamp) {}
    //HashMap <String, List<String, Integer>>
    Map<String, List<ValueAndTimestamp>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<ValueAndTimestamp> list;
        if(!timeMap.containsKey(key)){
            list = new ArrayList<>();
            timeMap.put(key, list);
        }else {
            list = timeMap.get(key);
        }
        list.add(new ValueAndTimestamp(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
         List<ValueAndTimestamp> list = timeMap.getOrDefault(key, null);
         if(list == null){
            return "";
         }
         int l = 0;
         int r = list.size() - 1;
         String result = "";
         while(l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid).timestamp() < timestamp){
                l = mid + 1;
                result = list.get(mid).value();
            }else if(list.get(mid).timestamp() > timestamp){
                r = mid - 1;
            }else {
                return list.get(mid).value();
            }
         }
         return result;
    }
}
