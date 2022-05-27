package demo6;


import demo2.User;
import java.util.ArrayList;
import java.util.List;

public class Test6 {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user = new User("test","123");
        list.add(user);
        UserChainPipline chain = new UserChainPipline();
        chain.addHandler(new validateHandler());
        chain.addHandler(new loginHandler());
        chain.addHandler(new authHandler());
        chain.doHandler(list);
    }
}
