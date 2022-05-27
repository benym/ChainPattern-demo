package demo3;

import demo2.User;

public abstract class ChainPipline3 {

    protected ChainPipline3 nextChain;

    public void setNextChain(ChainPipline3 nextChain) {
        this.nextChain = nextChain;
    }

    public ChainPipline3 getNextChain() {
        return nextChain;
    }

    public abstract void doProcess(User user);

    public static class Builder {

        private ChainPipline3 head;
        private ChainPipline3 tail;

        public Builder addInterceptor(ChainPipline3 chainPipline3) {
            // 如果头节点为null，则将头尾设置为当前chain
            if (head == null) {
                this.tail = chainPipline3;
                this.head = this.tail;
                return this;
            }
            // 如果头节点不为null，则将当前尾节点后一个chain设置为入参
            this.tail.setNextChain(chainPipline3);
            // 尾结点后移
            this.tail = chainPipline3;
            return this;
        }

        public ChainPipline3 build() {
            // 返回头节点
            return this.head;
        }
    }
}

class validateInterceptor extends ChainPipline3 {

    @Override
    public void doProcess(User user) {
        if (user.getName() == null || user.getPwd() == null) {
            throw new RuntimeException("账号或密码为空，校验失败");
        }
        this.getNextChain().doProcess(user);
    }
}

class loginInterceptor extends ChainPipline3 {

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

class authInterceptor extends ChainPipline3 {

    @Override
    public void doProcess(User user) {
        if (!"admin".equals(user.getRole())) {
            throw new RuntimeException("权限不足，非法操作");
        }
        System.out.println("允许操作");
    }
}
