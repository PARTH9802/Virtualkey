package virtualkey ;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class VirtualKeyTest{
    public static void main(String[] args)  {
        File folder = new File("Users\\Kannan\\eclipse-workspace\\Phase 1 Project\\src\\VirtualKey");
        folder.mkdirs();
        Scanner scan = new Scanner(System.in);

        while(true){

            System.out.println("Prototype of the Application Page>\n");
            System.out.println("These are the functions: \n");
            System.out.println("1. To display the files in ascending order\n");
            System.out.println("2. Here are some User Enabled Operations  \n");
            System.out.println("3. Terminate Program");
            System.out.println("Which function you want to proceed : \n");

            int choice = scan.nextInt();
            switch(choice)
            {
                case 1:

                    File arr[] = folder.listFiles();
                    Arrays.sort(arr);

                    for(int i=0;i<arr.length;i++)
                        System.out.println(arr[i]);
                    break;


                case 2:
                    Boolean temp = true;
                    while(temp) {
                        System.out.println("Option 1 :- To Add a file in the existing directory");
                        System.out.println("Option 2 :- To Add content to file in the existing directory");
                        System.out.println("Option 3 :- To Delete a file from the existing directory. ");
                        System.out.println("Option 4 :- To Search a user specified file from the directory");
                        System.out.println("Option 5 :- Back to the previous menu");
                        System.out.println("Option 6 :- Terminate Program");


                        int choice2 = scan.nextInt();

                        switch (choice2) {
                            case 1:
                                System.out.println("Enter a file name");
                                String name = scan.next();
                                if(new File(folder,name).exists()){
                                    System.out.println("file already exist");
                                }else {
                                    File folder1 = new File(folder, name);
                                    folder1.mkdir();
                                    if (new File(folder, name).exists()) {
                                        System.out.println("file added successfully");
                                    }
                                }

                                break;
                            case 2:

                                System.out.println("Enter the content u want to add in the file");
                                try {
                                    String data = " Ok";
                                    File f1 = new File("Users\\Kannan\\eclipse-workspace\\Phase 1 Project\\src\\VirtualKey");
                                    if(!f1.exists()) {
                                        f1.createNewFile();
                                    }

                                    FileWriter fileWritter = new FileWriter(f1.getName(),true);
                                    BufferedWriter bw = new BufferedWriter(fileWritter);
                                    bw.write(data);
                                    bw.close();

                                } catch(IOException e){
                                    e.printStackTrace();
                                }

                                break;





                            case 3:
                                System.out.println("Enter a file name");
                                String name1 = scan.next();
                                boolean folder2 = new File(folder, name1).exists();
                                System.out.println(folder2);
                                if (folder2 == true) {
                                    File folder3 = new File(folder, name1);
                                    folder3.delete();
                                    System.out.println("File successfully deleted");
                                } else {
                                    System.out.println("file does not exist");
                                }

                                break;


                            case 4:
                                System.out.println("Enter a keyword to search");
                                String search = scan.next();

                                File arr1[] = folder.listFiles();
                                for(int a=0;a<arr1.length;a++){
                                    if(arr1[a].getName().startsWith(search)){
                                        System.out.println(arr1[a]);
                                    }else{
                                        System.out.println("No file found");
                                    }
                                }
                                break;

                            case 5:

                                temp = false;
                                break;

                            case 6:

                                System.out.println("Program Terminated Succesfully");
                                System.exit(0);
                            default:
                                System.out.println("Input correct value and retry");

                        }

                    }
                    break;

                case 3:
                    System.out.println("Program Terminated Succesfully");
                    System.exit(0);

                default:
                    System.out.println("Input correct value and retry");
                    break;

            }
        }
    }
}
