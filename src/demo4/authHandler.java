package demo4;


import demo2.User;

public class authHandler implements ChainHandler {

    @Override
    public void handle(User user,ChainPipline4 chain) {
        if (!"admin".equals(user.getRole())) {
            throw new RuntimeException("权限不足，非法操作");
        }
        System.out.println("允许操作");
    }
}
