IS2545 - DELIVERABLE 2: Unit Testing
By Hanwei Cheng

Problem Description

1 Develop Application

How to develop an Object-design for this project is my first problem encountered When I first read the requirement. Like which classes should I have, which class is not neccessary to create.

At the beginning, since I never used the seed to generate random number, I was confused about how many random generator should I created and how should I call NextInt() function since I misunderstood that my result had to be the exactly as the output sample that professor offers. I have trouble to play random generator in order to create the same pattern as professor’s. After talked with professor, he explained it was impossible to be the same which solved my confusion.

In further, during my first time running the code, I had difficulty with infinite loop as screen shows visitor 1 was keeping going to different places as forever, and I had to think about how to stop visitor leave the city for the first visit. In stead of passing in hard-code, I added parameter called “bound” for “getNextLocation” function. Therefore, I set a default current location to visitor as "No location" and added an if sentence to figure out whether it was visitor’s first visit. When the program realized it was the user’s first visit, “left the city” will not be an option by changing the bound.

2 Test Case

The most difficulty is when I was trying to develop the program, in the meanwhile, I had to think about how should I make the function easy to be tested, in other words, "TDD". and which one should I use double and stubbing. For example, when I first created getType() method, I just passed in a random number that already generated by random. However, in order to have more complex test case, I changed my code to pass in a random class so I could create a mock of random class in test case, and further stubbing nextInt() method.

An failure test case that I had was “ifBothMethodReturnTrue()”test case for Validator class. I was trying to stub validateArgumentType() and validateNumberOfArguments() in order to test validateArguments() with excluding the effect from these two methods. However, every time it always returned false even though I set both method to return true. Finally I talked with professor, he taught me a cool method thenCallRealMethod(), therefore, when mockValidator calls validateArguments(), it would go through the real validateArguments(). It solved my problem and make this testcase passed at end.

Another failure test that I had was TestLikeOrNot(). My original idea to create a stub for getPreferenceList() didn’t work. The error message was always “Nullpointer”. Then I figured out, I could not assign the likeList to visitor by stubbing. However, likeOrNot() depends on the likeList. Therefore, stubbing proved a failure. I made changes to delete stubbing and it passed finally.
