import java.util.*;

class RabinKarpImp{

    public static ArrayList<Integer> rabinKarp(String t, String P){
        int pHash;
        int[] H = new int[t.length() - P.length() + 1];
        ArrayList<Integer> positions = new ArrayList<Integer>();
        
        int x = 998;
        pHash = P.hashCode();
        System.out.println(pHash);
        H = precomputeHashes(t, P.length());

        for(int i = 0; i < H.length; i++){
        
            if(pHash != H[i]){
                continue;
            }
             positions.add(i);
        }
        return positions;
    }

    public static int[] precomputeHashes(String t, int P){
        int[] h = new int[t.length() - P + 1];
        Arrays.fill(h, 0);
        h[t.length() - P] = t.substring(t.length()-P, t.length()).hashCode();
       
        for(int i = 0; i < t.length() - P + 1; i++){
            h[i] = t.substring(i, i + P).hashCode();
        }

        return h;
    }

    public static void main(String[] args){
        String pattern;
        String t;
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> result;
        pattern = in.next();
        t = in.next();
        result = rabinKarp(t, pattern);
        System.out.println(result);

        in.close();
    }
}