class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits.length() == 0){
            return res;
        }
        Map<Character,String> m = new HashMap<>();
        m.put('2',"abc");
        m.put('3',"def");
        m.put('4',"ghi");
        m.put('5',"jkl");
        m.put('6',"mno");
        m.put('7',"pqrs");
        m.put('8',"tuv");
        m.put('9',"wxyz");

        
        find(0,digits,m,new StringBuilder(),res);
        return res;



    }

    public void find(int idx , String digits , Map<Character,String> m , StringBuilder curr , List<String> res){
        if(idx == digits.length()){
            res.add(curr.toString());
            return;
        }

        String letters = m.get(digits.charAt(idx));

        for(char c : letters.toCharArray()){
            curr.append(c);
            find(idx+1,digits , m , curr,res);
            curr.deleteCharAt(curr.length()-1);


        }
    }
}