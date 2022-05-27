package demo4;


import demo2.User;

public class Test4 {

    public static void main(String[] args) {
        User user = new User("test","123");
        ChainPipline4 chain = new ChainPipline4();
        chain.addHandler(new validateHandler());
        chain.addHandler(new loginHandler());
        chain.addHandler(new authHandler());
        chain.doHandler(user);
    }
}
