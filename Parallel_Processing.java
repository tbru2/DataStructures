import java.util.*;
//Thread Processing Simulation
//input: Integer total_threads, Integer processCount
//input: Integer list of length processCount
//output: Thread,  Time of Arrival 

class Parallel_Processing{
    public static void main(String[] args){
        ArrayList<Long> running_threads = new ArrayList<Long>();
        ArrayList<Long> thread_timers = new ArrayList<Long>();
        Queue<Long> process_queue = new LinkedList<Long>();
        Long min_time = Long.MAX_VALUE;
        int total_threads;
        int processCount;
        long running_time = 0;

        Scanner in = new Scanner(System.in);
        total_threads = in.nextInt();
        processCount = in.nextInt();

        for(int i = 0; i < processCount; i++){
            if(running_threads.size() < total_threads){
                running_threads.add(in.nextLong());
                thread_timers.add(Long.MIN_VALUE);
                System.out.println(i + " " + 0);
            }
            else
                process_queue.add(in.nextLong());
        }
        while(!process_queue.isEmpty()){
            for(int j = 0; j < total_threads; j++){
                if(running_time == running_threads.get(j)){
                    System.out.println(j + " " + running_time);
                    running_threads.set(j, process_queue.poll() + running_time);
                    thread_timers.set(j, running_time);
                }
            }
            running_time++;
        }
        in.close();
    }
}