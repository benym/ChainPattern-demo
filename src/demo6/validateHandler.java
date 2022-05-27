package demo6;


import demo2.User;
import java.util.List;

public class validateHandler extends AbstractChainHandler<User> {

    @Override
    protected void process(List<User> handlerData) {
        handlerData.forEach(user -> {
            if (user.getName() == null || user.getPwd() == null) {
                throw new RuntimeException(user.getName() + "账号或密码为空，校验失败");
            }
            System.out.println("账号密码校验通过");
        });
    }
}
