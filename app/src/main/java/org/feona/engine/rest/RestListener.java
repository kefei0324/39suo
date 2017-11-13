package org.feona.engine.rest;

/**
 * @AUTHER feona
 * @CREATE 2017/11/10  17:10
 **/
public interface RestListener<T> {

    public void prepare();
    public void onResult(T t);
    public void onError(T t);

}
