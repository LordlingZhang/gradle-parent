package com.zhangyu.designmode.factory.abstr;

import com.zhangyu.designmode.factory.Audi;
import com.zhangyu.designmode.factory.Benz;
import com.zhangyu.designmode.factory.Bmw;
import com.zhangyu.designmode.factory.Car;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author : zhangyu
 * @description : 抽象工厂
 * @date : 2021/4/7
 */
@Slf4j
public abstract class AbstractCarFactory {

    /**
     * 获取
     * @return
     */
    protected abstract Car getCar();

    public Car getCar(String name) {
        if (StringUtils.equalsIgnoreCase(name, "Bmw")) {
            return new Bmw();
        } else if (StringUtils.equalsIgnoreCase(name, "Benz")) {
            return new Benz();
        } else if (StringUtils.equalsIgnoreCase(name, "Audi")) {
            return new Audi();
        } else {
            log.error("无对应汽车类型");
            return null;
        }
    }

}
