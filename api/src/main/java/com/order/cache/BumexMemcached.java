package com.order.cache;

/**
 * Created by evacalla on 8/12/2019
 **/


public class BumexMemcached {

    public static final BumexMemcached bumexMemcached = new BumexMemcached();

    public static BumexMemcached getInstance(){
        return bumexMemcached;
    }

    private BumexMemcached() { }

    public void set(String key, Object value){ }

    public Object get(String key){ return null; }

    public void delete(String key){ }


}
