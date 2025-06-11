class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> l = new ArrayList<String>();

            for (int j = 0; j < n; j++) {
                l.add(".");
            }
            ans.add(l);
        }
       
        return find(0, n, ans);
    }

    public List<List<String>> find(int row, int n, List<List<String>> list) {
        List<List<String>> ans = new ArrayList<>();

        if (row == n - 1) {
            for (int i = 0; i < n; i++) {
                if (!available(list, row)) {
                    return ans;
                }
                if (!list.get(row).get(i).equals( "X")) {

                    
                    list.get(row).set(i, "Q");

                   List<String> ansList = new ArrayList<>();

                 for(List<String> r :  list){
                        String s ="";
                        for(String str : r){
                            System.out.println(str);
                            if(!str.equals("Q")){
                              s=   s.concat(".");
                            }
                            else{
                           s =  s.concat("Q");
                            }
                        }
                     
                        ansList.add(s);
                    }

                    ans.add(ansList);
                    list.get(row).set(i,".");
                }

            }

            return ans;

        }

        for (int i = 0; i < n; i++) {

            if (i != 0) {
                if (!available(list, row)) {
                    return ans;
                }
            }

            List<List<String>> list1 = new ArrayList<>();

            for(List<String> r : list){
                list1.add(new ArrayList<>(r));
            }

            if (!list1.get(row).get(i).equals( "X")) {
                list1.get(row).set(i, "Q");

                mark(row, i, n, list1);
                list1  = find(row + 1, n, list1);
                if (!list1.isEmpty()) {
               //     unmark(row, i, n, list1);
                    ans.addAll(list1);
                //  list1.get(row).set(i, ".");
                }

            }

        }

        return ans;
    }

    public void mark(int row, int col, int n, List<List<String>> list) {
        for (int i = row + 1; i < n; i++) {
            list.get(i).set(col, "X");
        }

        //set right diagonal

        int i = row + 1;
        int j = col + 1;

        while (i < n && j < n) {
            list.get(i).set(j, "X");
            i++;
            j++;
        }

        i = row + 1;
        j = col - 1;

        while (i < n && j >= 0) {
            list.get(i).set(j, "X");
            i++;
            j--;
        }

    }

    public void unmark(int row, int col, int n, List<List<String>> list) {
        for (int i = row + 1; i < n; i++) {
            list.get(i).set(col, ".");
        }

        //set right diagonal

        int i = row + 1;
        int j = col + 1;

        while (i < n && j < n) {
            list.get(i).set(j, ".");
            i++;
            j++;
        }

        i = row + 1;
        j = col - 1;

        while (i < n && j >= 0) {
            list.get(i).set(j, ".");
            i++;
            j--;
        }

    }

    public boolean available(List<List<String>> list, int row) {
        boolean ans = false;
        
        List<String> l = list.get(row);
        for (String s : l) {
            if (!s.equals("X")) {
                return true;
            }
        }

        return ans;
    }
}