import com.sun.jna.Pointer;

///The state of the board on the server
class ServerBoard
{
    Pointer ptr;
    int ID;
    int iteration;
    public ServerBoard(Pointer p)
    {
            ptr = p;
            ID = Client.INSTANCE.serverBoardGetObjectID(ptr);
            iteration = BaseAI.iteration;
    }

    boolean validify()
    {
        if(iteration == BaseAI.iteration) return true;
        for(int i = 0; i < BaseAI.serverBoards.length; i++)
        {
          if(BaseAI.serverBoards[i].ID == ID)
            {
                ptr = BaseAI.serverBoards[i].ptr;
                iteration = BaseAI.iteration;
                return true;
            }
        }
      throw new ExistentialError();
    }
    
    //commands
    
    boolean move(int fromPoint, int toPoint)
    {
        validify();
        return Client.INSTANCE.serverBoardMove(ptr, fromPoint, toPoint);
    }
    boolean bearOff(int fromPoint)
    {
        validify();
        return Client.INSTANCE.serverBoardBearOff(ptr, fromPoint);
    }
    boolean talk(String message)
    {
        validify();
        return Client.INSTANCE.serverBoardTalk(ptr, message);
    }
    
    //getters
    
    public int getObjectID()
    {
        validify();
        return Client.INSTANCE.serverBoardGetObjectID(ptr);
    }
    public int getDie1()
    {
        validify();
        return Client.INSTANCE.serverBoardGetDie1(ptr);
    }
    public int getDie2()
    {
        validify();
        return Client.INSTANCE.serverBoardGetDie2(ptr);
    }
    public int getDie3()
    {
        validify();
        return Client.INSTANCE.serverBoardGetDie3(ptr);
    }
    public int getDie4()
    {
        validify();
        return Client.INSTANCE.serverBoardGetDie4(ptr);
    }
    public int getBar0()
    {
        validify();
        return Client.INSTANCE.serverBoardGetBar0(ptr);
    }
    public int getPoint1()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint1(ptr);
    }
    public int getPoint2()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint2(ptr);
    }
    public int getPoint3()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint3(ptr);
    }
    public int getPoint4()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint4(ptr);
    }
    public int getPoint5()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint5(ptr);
    }
    public int getPoint6()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint6(ptr);
    }
    public int getPoint7()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint7(ptr);
    }
    public int getPoint8()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint8(ptr);
    }
    public int getPoint9()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint9(ptr);
    }
    public int getPoint10()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint10(ptr);
    }
    public int getPoint11()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint11(ptr);
    }
    public int getPoint12()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint12(ptr);
    }
    public int getPoint13()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint13(ptr);
    }
    public int getPoint14()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint14(ptr);
    }
    public int getPoint15()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint15(ptr);
    }
    public int getPoint16()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint16(ptr);
    }
    public int getPoint17()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint17(ptr);
    }
    public int getPoint18()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint18(ptr);
    }
    public int getPoint19()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint19(ptr);
    }
    public int getPoint20()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint20(ptr);
    }
    public int getPoint21()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint21(ptr);
    }
    public int getPoint22()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint22(ptr);
    }
    public int getPoint23()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint23(ptr);
    }
    public int getPoint24()
    {
        validify();
        return Client.INSTANCE.serverBoardGetPoint24(ptr);
    }
    public int getBar25()
    {
        validify();
        return Client.INSTANCE.serverBoardGetBar25(ptr);
    }
}
