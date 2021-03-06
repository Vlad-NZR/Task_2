import org.junit.*;
public class TestModel{
    private static Model mod;
    @BeforeClass
    public static void runBeforeTests(){
        mod = new Model();
    }
    @Test
    public void testGetMagicNumber()
    {
        Assert.assertTrue(mod.getMagicNumber()>0 && mod.getMagicNumber()<=100);
    }
    @Test
    public void testSetLowerRange(){
        Assert.assertEquals(0,mod.getLowerRange());
    }
    @Test
    public void testSetUpperRange(){
        Assert.assertEquals(100,mod.getUpperRange());
    }




}
