package demo6;


import java.util.List;


public interface ChainHandler<T> {

    void handle(List<T> handlerData, ChainPipline chain);
}
