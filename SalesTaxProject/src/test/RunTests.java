package test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


//This class is used to run all test classes
@RunWith(Suite.class)
@SuiteClasses({TestClass1.class,TestClass2.class,TestClass3.class})
public class RunTests {

}
