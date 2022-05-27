package demo6;


import java.util.List;

public interface ChainPipline<T> {

    void doHandler(List<T> handlerData);

    void addHandler(ChainHandler handler);
}
