package Util;

import java.net.SocketTimeoutException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Input {

    private static int index;

    public void Input(){
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        Commands.commandsHistory += ("\n" + input.split(" ")[0]);
        if(input.equals("help")){
          Commands.help();
            System.out.println("Started help");
        }

        if(input.equals("show")){
            Commands.show();
            System.out.println("Started show");
        }

        if(input.equals("info")){
            Commands.info();
            System.out.println("Started info");
        }

        if(input.split(" ")[0].equals("add")){
            System.out.println("Started add");
        }

        if(input.split(" ")[0].equals("update")){
            Commands.updateId(Integer.parseInt(getArgument(input, 1)));

        }

        if(input.split(" ")[0].equals("remove_by_id")){
            Commands.renoveById(Integer.parseInt(input.split(" ")[1]));
            System.out.println("Remove by id started");
        }

        if(input.equals("clear")){
            Commands.clear();
            System.out.println("Clear started");
        }

        if (input.equals("save")){
            Commands.save();
            System.out.println("Save started");
        }

        if (input.split(" ")[0].equals("execute_script")){
            Commands.executeScript();
            System.out.println("Execute script started");
        }

        if (input.equals(input.split(" ")[0].equals("add_if_max"))){
            System.out.println("Add if max started");
            Commands.addIfMax();
        }

        if (input.split(" ")[0].equals("remove_greater")){
            System.out.println("Remove greater started");
            Commands.removeGreater();
        }

        if (input.equals("history")){
            System.out.println("History started");
            System.out.println(Commands.commandsHistory);
            Commands.history();
        }

        if(input.equals("average_of_distance")){
            Commands.averageOfDistance();
            System.out.println("Average of distance started");
        }

        if(input.equals("group_counting_by_coordinates")){
            Commands.groupCountingByCoordinates();
            System.out.println("Group and something started");
        }

        if (input.equals("count_greater_than_distance")){
            System.out.println("something started");
        }

        if(input.equals("exit")){
            Commands.exit();
            System.out.println("This point is never going to be reached");
        }

        else{
            System.out.println("Error. Command not found");
        }
    }

    private String getArgument(String source, int position){
        try {
            return(source.split(" ")[position]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            return(" ");
        }
    }

    private void saveHistory(String input){

    }
}
