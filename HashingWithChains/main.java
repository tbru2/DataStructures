import java.util.*;

class main{
    public static void main(String[] args){
        
        HashingWithChains listChain;
        int numOfBuckets, index, numOfQueries;
        String query;
        String currentQuery;
        Boolean isFound;
        Scanner in = new Scanner(System.in);

        numOfBuckets = in.nextInt();
        numOfQueries = in.nextInt();
        
        listChain = new HashingWithChains(numOfBuckets);

        for(int i = 0; i < numOfQueries; i++){
            currentQuery = in.next();
            switch(currentQuery){
                case "add":
                    query = in.next();
                    listChain.add(query);
                    break;
                case "del":
                    query = in.next();
                    listChain.remove(query);
                    break;
                case "find":
                    query = in.next();
                    isFound = listChain.find(query);
                    if(isFound)
                        System.out.println("yes");
                    else
                        System.out.println("no");
                    break;
                case "check":
                    index = in.nextInt();
                    listChain.check(index);
                default:
                    break;
            }
        }
    }
}