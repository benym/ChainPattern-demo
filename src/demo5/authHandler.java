package demo5;


import demo2.User;

public class authHandler extends AbstractChainHandler<User> {

    @Override
    protected void process(User user) {
        if (!"admin".equals(user.getRole())) {
            throw new RuntimeException("权限不足，非法操作");
        }
        System.out.println("允许操作");
    }
}
