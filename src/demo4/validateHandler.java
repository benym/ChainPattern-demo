package demo4;


import demo2.User;

public class validateHandler implements ChainHandler {

    @Override
    public void handle(User user, ChainPipline4 chain) {
        if (user.getName() == null || user.getPwd() == null) {
            throw new RuntimeException("账号或密码为空，校验失败");
        }
        System.out.println("账号密码校验通过");
        chain.doHandler(user);
    }
}
