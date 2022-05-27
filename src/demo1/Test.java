package demo1;


public class Test {

    public static void main(String[] args) {
        InterceptorA interceptorA = new InterceptorA();
        InterceptorB interceptorB = new InterceptorB();
        interceptorA.setNextChain(interceptorB);
        interceptorA.doProcess("hello chain");
    }
}
