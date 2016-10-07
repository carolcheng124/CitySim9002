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
    
    //all validation method has to return true
    public boolean validateArguments(String[] args) {
        return validateNumberOfArguments(args) && validateArgumentType(args);
    } 
    
    //validate argument array length
    //can only be 1 argument not 0 or more than 1
    public boolean validateNumberOfArguments(String[] args) {
        return args.length == 1;
    }
    
    //validate whether argument[0] is valid
    //can only be an integer
    public boolean validateArgumentType(String[] args) {
        try {
            Integer.parseInt(args[0]);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
