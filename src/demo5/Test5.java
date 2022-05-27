package demo5;


import demo2.User;

public class Test5 {

    public static void main(String[] args) {
        User user = new User("test","123");
        ChainPipline5 chain = new ChainPipline5();
        chain.addHandler(new validateHandler());
        chain.addHandler(new loginHandler());
        chain.addHandler(new authHandler());
        chain.doHandler(user);
    }
}
