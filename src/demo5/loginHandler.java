package demo5;


import demo2.User;

public class loginHandler extends AbstractChainHandler<User> {

    @Override
    protected void process(User user) {
        if ("test".equals(user.getName()) && "123".equals(user.getPwd())) {
            user.setRole("admin");
        } else {
            throw new RuntimeException("用户不存在");
        }
        System.out.println("用户校验通过");
    }
}
