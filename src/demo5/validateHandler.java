package demo5;


import demo2.User;

public class validateHandler extends AbstractChainHandler<User> {

    @Override
    protected void process(User user) {
        if (user.getName() == null || user.getPwd() == null) {
            throw new RuntimeException("账号或密码为空，校验失败");
        }
        System.out.println("账号密码校验通过");
    }
}
