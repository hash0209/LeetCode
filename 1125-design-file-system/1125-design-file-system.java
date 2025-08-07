class FileSystem {

    Trie root;

   
    public FileSystem() {
        
          root  =  new Trie(new HashMap<>(),-1);
    

    }
    
    public boolean createPath(String path, int value) {
        String[] arr = path.split("/");
        
        List<String> list = clean(arr);
      
        Trie node = search(list , 0 , list.size()-2);

        if(node == null){
            return false;
        } 

        Map<String,Trie> m = node.map;
        if(m.containsKey(list.get(list.size()-1))){
            return false;
        }
        Trie t =  new Trie(new HashMap<>(),-1);
        m.put(list.get(list.size()-1) , t);

        t.val = value;
        return true;
        

        

        
    }
    
    public int get(String path) {
        String[] arr = path.split("/");
        List<String> list = clean(arr);

        Trie t = search(list,0,list.size()-1);
        if(t == null){
            return -1;
        }
        else{
            return t.val;
        }
      
    }

    public Trie search( List<String> arr , int start , int end ){
        Trie node = root;

        for(int i = start ; i <= end ; i ++){
            Map<String,Trie> m = node.map;
            if(!m.containsKey(arr.get(i))){
                return null;
            }

            node = m.get(arr.get(i));
        }

        return node;
    }

    public List<String> clean (String[] arr){
        List<String> list = new ArrayList<>();
        for(int i = 0; i< arr.length ; i++){
            if(arr[i].isEmpty()){
                continue;
            }
            list.add(arr[i]);

        }
        return list;
    }


    
}

class Trie {
       Map<String,Trie> map ;
       int val =-1;

       public Trie( Map<String,Trie> map , int val){
                  this.map = map;
                  this.val = val ;
       }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */