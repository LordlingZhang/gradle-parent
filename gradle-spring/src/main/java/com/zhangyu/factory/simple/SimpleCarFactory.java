package com.zhangyu.factory.simple;

import com.zhangyu.factory.Audi;
import com.zhangyu.factory.Benz;
import com.zhangyu.factory.Bmw;
import com.zhangyu.factory.Car;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author : zhangyu
 * @description : 简单工厂模式
 * @date : 2021/4/6
 */
@Slf4j
public class SimpleCarFactory {
    /**
     * 实现统一生产
     * @param name
     * @return
     */
    public Car getCar (String name) {
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
