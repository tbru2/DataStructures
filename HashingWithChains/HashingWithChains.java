import java.util.*;
import java.lang.Math;

class HashingWithChains{
        private ArrayList<ArrayList<String>> chains;
        private final long m, p, x;

        public HashingWithChains(int n){
            m = n;
            chains = new ArrayList<>();
            for(int i = 0; i < m; i++){
                chains.add(new ArrayList<String>());
            }  

            p = 1000000007;
            x = 263;
        }

        public int polyHash(String s){
                long hash = 0;
                char[] sArray = s.trim().toCharArray();

                for(int i = sArray.length-1; i >= 0; i--){
                    hash = (((long)(int)sArray[i] + hash * x) % p) ;
                } 
                return (int)(hash % m);
        }

        public void add(String s){
            ArrayList<String> chain = chains.get(polyHash(s));
            
            for(int i = 0; i < chain.size(); i ++){
                if(chain.get(i).equals(s)){
                    return;
                }
            }

            chain.add(0,s);
        }

        public Boolean find(String s){
            ArrayList<String> chain = chains.get(polyHash(s));
          
            for(int i = 0; i < chain.size(); i++){
                if(chain.get(i).equals(s)){
                    return true;
                }
            }

            return false;
        }

        public void remove(String s){
            if(!this.find(s)){
                return;
            }

            ArrayList<String> chain = chains.get(polyHash(s));
            chain.remove(s);
        }

        public void check(int index){
            ArrayList<String> chain = chains.get(index);
            for(int i = 0; i < chain.size(); i++)
            {
                System.out.print(chain.get(i) + " ");
            }
            System.out.println();
        }
} 