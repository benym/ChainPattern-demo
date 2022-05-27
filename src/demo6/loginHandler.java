package demo6;


import demo2.User;
import java.util.List;

public class loginHandler extends AbstractChainHandler<User> {

    @Override
    protected void process(List<User> handlerData) {
        handlerData.forEach(user -> {
            if ("test".equals(user.getName()) && "123".equals(user.getPwd())) {
                user.setRole("admin");
            } else {
                throw new RuntimeException(user.getName() + "用户不存在");
            }
            System.out.println("用户校验通过");
        });
    }
}
