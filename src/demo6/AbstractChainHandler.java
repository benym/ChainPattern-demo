package demo6;


import java.util.List;

public abstract class AbstractChainHandler<T> implements ChainHandler<T> {

    @Override
    public void handle(List<T> handlerData, ChainPipline chain) {
        // 具体某个handler处理
        process(handlerData);
        // 链上下一个handler处理
        chain.doHandler(handlerData);
    }

    /**
     * 执行具体handler
     *
     * @param handlerData handlerData
     */
    protected abstract void process(List<T> handlerData);
}
