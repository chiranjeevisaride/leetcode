class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Set<String> sortedProducts = new TreeSet<String>();
        for(String product: products)
            sortedProducts.add(product);
        
        return IntStream.rangeClosed(1, searchWord.length())
                    .mapToObj(index -> searchWord.substring(0, index))
                    .map(subWord -> suggestionList(sortedProducts, subWord))
                    .collect(Collectors.toList());
    }
    
    public List<String> suggestionList(Set<String> sortedProducts, String subWord){
        return sortedProducts
            .stream()
            .filter(product -> product.startsWith(subWord))
            .limit(3)
            .collect(Collectors.toList());
    }
}