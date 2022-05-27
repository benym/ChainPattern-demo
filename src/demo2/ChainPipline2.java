package demo2;


public abstract class ChainPipline2 {

    protected ChainPipline2 nextChain;

    public void setNextChain(ChainPipline2 nextChain) {
        this.nextChain = nextChain;
    }

    public ChainPipline2 getNextChain() {
        return nextChain;
    }

    public abstract void doProcess(User user);

}

class validateInterceptor extends ChainPipline2 {

    @Override
    public void doProcess(User user) {
        if (user.getName() == null || user.getPwd() == null) {
            throw new RuntimeException("账号或密码为空，校验失败");
        }
        this.getNextChain().doProcess(user);
    }
}

class loginInterceptor extends ChainPipline2 {

    @Override
    public void doProcess(User user) {
        if ("test".equals(user.getName()) && "123".equals(user.getPwd())) {
            user.setRole("admin");
        } else {
            throw new RuntimeException("用户不存在");
        }
        this.getNextChain().doProcess(user);
    }
}

class authInterceptor extends ChainPipline2 {

    @Override
    public void doProcess(User user) {
        if (!"admin".equals(user.getRole())) {
            throw new RuntimeException("权限不足，非法操作");
        }
        System.out.println("允许操作");
    }
}