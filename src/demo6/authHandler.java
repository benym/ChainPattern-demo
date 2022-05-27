package demo6;

import demo2.User;
import java.util.List;


public class authHandler extends AbstractChainHandler<User> {

    @Override
    protected void process(List<User> handlerData) {
        handlerData.forEach(user -> {
            if (!"admin".equals(user.getRole())) {
                throw new RuntimeException(user.getName() + "权限不足，非法操作");
            }
            System.out.println("允许操作");
        });
    }
}
