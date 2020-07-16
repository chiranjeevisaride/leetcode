class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> resultLogs = Arrays.asList(logs)
                                        .stream()
                                        .filter(log -> log.split("\\s")[1].matches("[a-z]+"))
                                        .collect(Collectors.toList());
        
        Collections.sort(resultLogs, (log1, log2) -> {
            String log1Text = log1.substring(log1.indexOf(" ") + 1);
            String log2Text = log2.substring(log2.indexOf(" ") + 1);
            return log1Text.equalsIgnoreCase(log2Text) ? log1.compareTo(log2) : log1Text.compareTo(log2Text);
        });
        
       resultLogs.addAll(Arrays.asList(logs).stream()
                  .filter(log -> log.split("\\s")[1].matches("[0-9]+"))
                  .collect(Collectors.toList()));
            
        return resultLogs.toArray(new String[0]);
    }
}