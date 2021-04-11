

public class CalculateorTest {
    @Mybefore
    public void setUp() throws Exception {
        System.out.println("before");
        cal=new Calculator();
    }
    @MyBeforeClass
    public void bc(){
        System.out.println("beforeclass");
    }
    @MyAfter
    public void tearDown() throws Exception {
    }
    @MyAfterClass
    public void ac(){
        System.out.println("afterclass");
    }
    @MyTest
    public void add() {
        System.out.println("add");
    }

    @MyTest
    public void sub() {
        System.out.println("sub");
    }
}