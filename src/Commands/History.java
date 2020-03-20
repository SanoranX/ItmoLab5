package Commands;

import java.util.PriorityQueue;

public class History extends PriorityQueue<String> {

    public void addCommand(String e){
        if(size() == 12){
            poll();
        }
        add(e);
    }

    public String getStory(){
        String temp = "";
        for(String string : this)
            temp = temp + string + "\n";
        return temp;
    }
}
