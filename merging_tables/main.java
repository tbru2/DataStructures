import java.util.*;

// input:  number of tables, number of merges,
      //      number of rows per table, 
      //Integer destination table, Integer source table 
//output the max 
class main{
    public static void main(String[] args){
        DisjointSets tables;
        int numOfTables, numOfMerges;
        int[] rowsPerTable; 
        int destination;
        int source;
        Scanner in = new Scanner(System.in);
        
        numOfTables = in.nextInt();
        numOfMerges = in.nextInt();
        rowsPerTable = new int[numOfTables];

        for(int i = 0; i < numOfTables; i++){
            rowsPerTable[i] = in.nextInt();
        }

        tables = new DisjointSets(rowsPerTable);

        for(int j = 0; j < numOfMerges; j++){
            destination = in.nextInt()-1;
            source = in.nextInt()-1;
            tables.Union(source, destination);
        }

        in.close();
    }
}