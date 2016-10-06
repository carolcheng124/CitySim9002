/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author AsphaltPanthers
 */
public class ValidatorTest {
    
    Validator validator;
    
    @Before
    public void setUp() throws Exception{
        validator = new Validator();
    }
    
    @After
    public void tearDown() throws Exception{
    }

    //INTEGER LENGTH TEST-0
    //Return true if the input argument is one integer
    @Test
    public void ifOneArgumentIsProvidedReturnTrue() {
        Assert.assertTrue(validator.validateNumberOfArguments(new String[] { "1" }));
    }
    
    //INTEGER LENGTH TEST-1
    //Return false if the input argument has more than one integer 
    @Test
    public void ifOneArgumentIsNotProvidedReturnFalse() {
        Assert.assertFalse(validator.validateNumberOfArguments(new String[] { "1", "2" }));
    }
    
    //VALID INTEGER TEST-0
    //Return trueassert if the input argument is an integer
    @Test
    public void ifArgumentIsAnIntegerReturnTrue() {
        Assert.assertTrue(validator.validateArgumentType(new String[] { "1" }));
    }
    
    //VALID INTEGER TEST-1
    //Return false if the input argument is a string
    @Test
    public void ifArgumentIsNotAnIntegerReturnFalse0() {
        Assert.assertFalse(validator.validateArgumentType(new String[] { "test" }));
    }
    
    //VALID INTEGER TEST-2
    //Return false if the input argument is a special character
    @Test
    public void ifArgumentIsNotAnIntegerReturnFalse1() {
        Assert.assertFalse(validator.validateArgumentType(new String[] { "&&" }));
    }
    
    //VALID INTEGER TEST-3
    //Return false if the input argument is null  
    @Test
    public void ifArgumentIsNullReturnFalse(){
        Assert.assertFalse(validator.validateArgumentType(new String[] {}));
    }
    
    //DOUBLE + STUBBING
    //Return true if both validateArgumentType() and validateNumberOfArguments() return true
    @Test
    public void ifBothMethodReturnTrue(){
         Validator mockValidator = mock(Validator.class);
         when(mockValidator.validateArgumentType(any(String[].class))).thenReturn(true); 
         when(mockValidator.validateNumberOfArguments(any(String[].class))).thenReturn(true);
         when(mockValidator.validateArguments(any(String[].class))).thenCallRealMethod();

         Assert.assertTrue(mockValidator.validateArguments(new String[0]));
    }
    
    //DOUBLE+STUBBING
    //Return false if one of validateArgumentType() and validateNumberOfArguments() return false
    @Test
    public void ifAnyMethodReturnFalse(){
         Validator mockValidator = mock(Validator.class);
         when(mockValidator.validateArgumentType(any(String[].class))).thenReturn(true); 
         when(mockValidator.validateNumberOfArguments(any(String[].class))).thenReturn(true);
         when(mockValidator.validateArguments(any(String[].class))).thenCallRealMethod();
         
         Assert.assertFalse(mockValidator.validateArguments(any(String[].class)));
    }
    
    
    
    
}
