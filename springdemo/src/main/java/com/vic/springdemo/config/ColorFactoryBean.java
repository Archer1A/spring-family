package com.vic.springdemo.config;

import com.vic.springdemo.model.Color;
import org.springframework.beans.factory.FactoryBean;

/**
 * ColorFactoryBean
 *
 * @author Vic
 * @date 2019/8/1
 */
public class ColorFactoryBean implements FactoryBean<Color> {


    @Override
    public Color getObject() throws Exception {
        Color color = new Color();
        color.setColor("Red");
        return color;
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

}
