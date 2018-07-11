import java.util.*;


class PhoneBook{

    
    public static void main(String[] args){
        Hashtable<Integer, String> phoneBook = new Hashtable<>();
        int numOfQueries;
        Integer phoneNumber;
        String name;
        String currentQuery;
        Scanner in = new Scanner(System.in);

        numOfQueries = in.nextInt();
        
        for(int i = 0; i < numOfQueries; i ++){
            currentQuery = in.next();
            switch(currentQuery){
                case "add":
                    phoneNumber = in.nextInt();
                    name = in.next();
                    phoneBook.put(phoneNumber, name);
                    break;
                case "del":
                    phoneNumber = in.nextInt();
                    phoneBook.remove(phoneNumber);
                    break;
                case "find":
                    phoneNumber = in.nextInt();
                    name = phoneBook.get(phoneNumber);
                    if(name == null)
                        System.out.println("not found");
                    else
                        System.out.println(name);
                    break;
                default:
                    break;
            }
        }
        in.close();
    }
}


