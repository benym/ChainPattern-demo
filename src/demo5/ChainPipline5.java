package demo5;


import demo2.User;
import java.util.ArrayList;
import java.util.List;

public class ChainPipline5 {

    // 记录当前Handler位置
    private int pos = 0;
    // 记录Chain内Handler的个数
    private int n = 0;

    private List<ChainHandler> handlers = new ArrayList<>();

    void addHandler(ChainHandler handler) {
        handlers.add(handler);
        this.n++;
    }

    void doHandler(User user) {
        // 如果当前的handler的位置小于链上所有handler数量，则说明还没执行完，继续向前推进handler
        if (this.pos < this.n) {
            ChainHandler handler = handlers.get(this.pos++);
            handler.handle(user, this);
        }
    }
}
