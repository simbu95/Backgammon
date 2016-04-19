import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.Native;

public interface Client extends Library {
    Client INSTANCE = (Client)Native.loadLibrary("client", Client.class);
    int open_server_connection(String host, String port);

    boolean serverLogin(int socket, String username, String password);
    int createGame();
    int joinGame(int id);

    void endTurn();
    void getStatus();

    int networkLoop(int socket);


    //commands
    boolean serverBoardMove(Pointer object, int fromPoint, int toPoint);
    boolean serverBoardBearOff(Pointer object, int fromPoint);
    boolean serverBoardTalk(Pointer object, String message);

    //accessors
    int getPlayer0Score();
    int getPlayer1Score();
    int getPlayerID();
    int getTurnNumber();
    double getPlayer0Time();
    double getPlayer1Time();

    Pointer getServerBoard(int num);
    int getServerBoardCount();


    //getters
    int serverBoardGetObjectID(Pointer ptr);
    int serverBoardGetDie1(Pointer ptr);
    int serverBoardGetDie2(Pointer ptr);
    int serverBoardGetDie3(Pointer ptr);
    int serverBoardGetDie4(Pointer ptr);
    int serverBoardGetBar0(Pointer ptr);
    int serverBoardGetPoint1(Pointer ptr);
    int serverBoardGetPoint2(Pointer ptr);
    int serverBoardGetPoint3(Pointer ptr);
    int serverBoardGetPoint4(Pointer ptr);
    int serverBoardGetPoint5(Pointer ptr);
    int serverBoardGetPoint6(Pointer ptr);
    int serverBoardGetPoint7(Pointer ptr);
    int serverBoardGetPoint8(Pointer ptr);
    int serverBoardGetPoint9(Pointer ptr);
    int serverBoardGetPoint10(Pointer ptr);
    int serverBoardGetPoint11(Pointer ptr);
    int serverBoardGetPoint12(Pointer ptr);
    int serverBoardGetPoint13(Pointer ptr);
    int serverBoardGetPoint14(Pointer ptr);
    int serverBoardGetPoint15(Pointer ptr);
    int serverBoardGetPoint16(Pointer ptr);
    int serverBoardGetPoint17(Pointer ptr);
    int serverBoardGetPoint18(Pointer ptr);
    int serverBoardGetPoint19(Pointer ptr);
    int serverBoardGetPoint20(Pointer ptr);
    int serverBoardGetPoint21(Pointer ptr);
    int serverBoardGetPoint22(Pointer ptr);
    int serverBoardGetPoint23(Pointer ptr);
    int serverBoardGetPoint24(Pointer ptr);
    int serverBoardGetBar25(Pointer ptr);


}
