package demo5;


import demo2.User;

public abstract class AbstractChainHandler<T> implements ChainHandler<T> {

    @Override
    public void handle(User user, ChainPipline5 chain) {
        // 具体某个handler处理
        process(user);
        // 链上下一个handler处理
        chain.doHandler(user);
    }

    /**
     * 执行具体handler
     *
     * @param user user
     */
    protected abstract void process(User user);
}
