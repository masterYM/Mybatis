package com.jiagouedu.objectfactory;

import com.jiagouedu.pojo.ShoppingCart;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;

public class CartObjectFactory extends DefaultObjectFactory {
    @Override
    public <T> T create(Class<T> type) {
        return super.create(type);
    }

    @Override
    //DefaultObjectFactory 的create(Class<T> type)  方法也会调用此方法，所以只需要在此方法中添加逻辑即可
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {

        T ret =  super.create(type, constructorArgTypes, constructorArgs);
        if(ShoppingCart.class.isAssignableFrom(type)){
            ShoppingCart entity = (ShoppingCart) ret;
            entity.init();
        }
        return ret;
    }
}
