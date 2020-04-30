package com.hql.tool.model;

import com.hql.tool.config.annotation.MyAnnotation;
import lombok.Data;

import java.lang.reflect.Field;

/**
 * @program: tool
 * @description:  测试用户类
 * @author: Zj
 * @create: 2020-06-10 14:57
 **/
@Data
public class User {

    @MyAnnotation("张晨")
    private String name = "张晨";

    @MyAnnotation("18")
    private String age;

    @MyAnnotation("男")
    private String sex;
}
class test{
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User();
        Class<User> userClass = User.class;
        Field[] declaredFields = userClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            MyAnnotation annotation = declaredField.getAnnotation(MyAnnotation.class);
            if(annotation != null){
                String value = annotation.value();
                declaredField.setAccessible(true);
                declaredField.set(user,value);
            }
        }
        System.out.println(user);
    }
}
