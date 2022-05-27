package demo5;


import demo2.User;


public interface ChainHandler<T> {

    void handle(User user, ChainPipline5 chain);
}
