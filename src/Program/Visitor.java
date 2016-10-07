/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Carol
 */
public class Visitor{
    String type;
    String location = "No location";
    List<String> likeList = new ArrayList<>();
    public static String[] typeList = {"Student", "Professor","Business Person", "Blogger"};
    public static String[] locationList = {"Squirrel Hill", "Downtown", "The Point", "The Cathedral of Learning", null};    

    
    //set the type accroding by passing in Generator 
    //return the string of the type
    //!!!!!
//    public String getType(Generator generator, int bound){
//        this.type = typeList[generator.randomTypeNum(bound)];
//        return type;
//    }
    public String getType(Random random, int bound){
        this.type = typeList[random.nextInt(bound)];
        return type;
    }
    
    
    //assign location accroding by passing in generated random number
    //return the string of the location
//    public String getNextLocation(Generator generator, int bound){
//        this.location = locationList[generator.randomTypeNum(bound)];
//        return location;
//    }
    
    //!!!!!!
    public String getNextLocation(Random random, int bound){
        this.location = locationList[random.nextInt(bound)];
        return location;
    }
    
    
   //get location
    public String getCurLocation(){
        return location;
    }
    
    //set visitor's preference according to their types
    public List<String> getPreferenceList(String type){
        switch (type) {
            case "Student":
                likeList = Arrays.asList("Squirrel Hill", "Downtown", "The Point");
                return likeList;
            case "Professor":
                likeList = Arrays.asList("Squirrel Hill", "Downtown", "The Point", "The Cathedral of Learning");
                return likeList;
            case "Business Person":
                likeList = Arrays.asList("Squirrel Hill", "Downtown");
                return likeList;
            default:
                return likeList;
        }
    }

    //whether the visitor like the location or not
    public boolean likeOrNot(String location){
        
       return likeList.contains(location);
    }
}
