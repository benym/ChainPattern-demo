package demo6;


import java.util.ArrayList;
import java.util.List;

public abstract class AbstractChainPipline<T> implements ChainPipline<T> {

    // 记录当前Handler位置
    protected int pos = 0;
    // 记录Chain内Handler的个数
    protected int n = 0;

    protected List<ChainHandler<T>> handlers = new ArrayList<>();

    @Override
    public void addHandler(ChainHandler handler) {
        handlers.add(handler);
        this.n++;
    }

    @Override
    public void doHandler(List<T> handlerData) {
        // 如果当前的handler的位置小于链上所有handler数量，则说明还没执行完，继续向前推进handler
        if (this.pos < this.n) {
            ChainHandler handler = handlers.get(this.pos++);
            handler.handle(handlerData, this);
        }
    }
}
