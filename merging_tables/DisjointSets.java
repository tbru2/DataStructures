import java.util.*;

class DisjointSets{

    private int parent[], rank[], symbolic_links[];
    private int max = 0;

    public DisjointSets(int[] rows_per_table){
        parent = new int[rows_per_table.length];
        rank = rows_per_table.clone();
        
        symbolic_links = new int[rows_per_table.length];
        for(int i = 0; i < rows_per_table.length; i++){
            parent[i] = i;
            symbolic_links[i] = i;
            if(rank[i] > max){
                max = rank[i];
            }
        }
    }

    public int find(int i){
        if (i != parent[i])
            parent[i] = find(parent[i]);
        return parent[i];
    }

    public int findMax(){
        for(int i = 0; i < rank.length; i++){
            if(rank[i] > max)
                max = rank[i];
        }
        return max;
    }

    public void Union(int i, int j){
        int i_id = symbolic_links[i];
        int j_id = symbolic_links[j];
 
        if(j_id == i_id){
            System.out.println(findMax());
            return;
        }
        if (rank[i_id] > rank[j_id]){
            parent[j_id] = i_id;
        }else{
            parent[i_id] = j_id;
        }
        symbolic_links[i] = j_id;
        rank[j_id] = rank[j_id] + rank[i_id];
        rank[i_id] = 0;
        System.out.println(findMax());
    }

}