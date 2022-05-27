package demo4;


import demo2.User;

public interface ChainHandler {

    void handle(User user,ChainPipline4 chain);
}
