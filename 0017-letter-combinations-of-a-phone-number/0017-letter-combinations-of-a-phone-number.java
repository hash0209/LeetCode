class Solution {
    public List<String> letterCombinations(String digits) {

        Map<Character, List<String>> map = new HashMap<>();
        map.put('2',Arrays.asList("a","b","c"));
        map.put('3',Arrays.asList("d","e","f"));
        map.put('4',Arrays.asList("g","h","i"));
        map.put('5',Arrays.asList("j","k","l"));
        map.put('6',Arrays.asList("m","n","o"));
        map.put('7',Arrays.asList("p","q","r" ,"s"));
        map.put('8',Arrays.asList("t","u","v"));
        map.put('9',Arrays.asList("w","x","y","z"));

        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }

        res =map.get(digits.charAt(0));

        for(int i =1 ; i < digits.length(); i++){
              res = merge(res,map.get(digits.charAt(i)));
        }

        return res;
        
    }

    public  List<String> merge(List<String> l1 , List<String> l2){

        List<String> res = new ArrayList<>();

        StringBuilder sb ;

        for(int i =0; i < l1.size() ;i ++){
            
           
            for(int j =0; j < l2.size() ; j++){
               
                res.add(l1.get(i).concat(l2.get(j)));


            }
        }

        return res ;
    }
}