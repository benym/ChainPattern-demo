package demo4;


import demo2.User;

public class loginHandler implements ChainHandler {

    @Override
    public void handle(User user,ChainPipline4 chain) {
        if ("test".equals(user.getName()) && "123".equals(user.getPwd())) {
            user.setRole("admin");
        } else {
            throw new RuntimeException("用户不存在");
        }
        System.out.println("用户校验通过");
        chain.doHandler(user);
    }
}
