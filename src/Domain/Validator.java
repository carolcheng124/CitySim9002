/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author AsphaltPanthers
 */
public class Validator {
    
    public boolean validateArguments(String[] args) {
        return validateNumberOfArguments(args) && validateArgumentType(args);
    } 
    
    //validate input length
    //can only be 1 not 0 or more than 1
    public boolean validateNumberOfArguments(String[] args) {
        return args.length == 1;
    }
    
    //input type, 
    //can only be integer
    public boolean validateArgumentType(String[] args) {
        try {
            Integer.parseInt(args[0]);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
