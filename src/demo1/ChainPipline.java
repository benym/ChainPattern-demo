package demo1;

public abstract class ChainPipline {

    protected ChainPipline nextChain;

    public void setNextChain(ChainPipline nextChain) {
        this.nextChain = nextChain;
    }

    public abstract void doProcess(String request);

    public void processNext(String request) {
        if (this.nextChain != null) {
            this.nextChain.doProcess(request);
        }
    }
}

class InterceptorA extends ChainPipline {

    @Override
    public void doProcess(String request) {
        System.out.println("InterceptorA:" + request);
        processNext(request);
    }
}

class InterceptorB extends ChainPipline {

    @Override
    public void doProcess(String request) {
        System.out.println("InterceptorB:" + request);
        processNext(request);
    }
}
