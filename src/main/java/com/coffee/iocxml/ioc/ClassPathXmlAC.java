package com.coffee.iocxml.ioc;


import com.coffee.iocxml.utils.DateUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * 基于类路径加载
 */
public class ClassPathXmlAC implements ApplicationContext {

    //解析的文件
    private File file;

    //存放bean实例
     private Map map = new HashMap();
     //解析实例化存放对象
    public ClassPathXmlAC(String config) {
        URL resource = this.getClass().getClassLoader().getResource(config);
        try {
            file = new File(resource.toURI());
            xmlParse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析xml文件
     * @param file
     * @return
     */
    private void xmlParse(File file) throws JDOMException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(file);
        // 创建XPath对象,反射获取XPath对象
        XPathFactory factory = XPathFactory.instance();
        // 获取所有的Bean节点
        XPathExpression expression=factory.compile("//bean");
        List beans=expression.evaluate(document);
        Iterator iterator=beans.iterator();
        while (iterator.hasNext()) {

           Element bean = (Element) iterator.next();
            // 获取配置文件的id属性值
            String id = bean.getAttributeValue("id");
            String cla = bean.getAttributeValue("class");
            // 反射拿到类的相应信息,首先是拿到类的实例对象
            Class<?> aClass = Class.forName(cla);
            Object o = aClass.getDeclaredConstructor().newInstance();
            Method[] methods = aClass.getDeclaredMethods();
            // 遍历Bean节点下的所有属性和方法,一一匹配,反射设置对象的属性值
            List<Element> properties = bean.getChildren("property");
            for (Element element : properties) {
                for (int i = 0; i < methods.length; i++) {
                    //获取方法名
                    String methodName = methods[i].getName();
                    // 属性名
                    String temp="";
                    // 获取set方法
                    if(methodName.startsWith("set")) {
                        //小写转换
                        temp = methodName.substring(3).toLowerCase();
                        // 属性注入
                        if (element.getAttribute("name") != null){
                            if (temp.equals(element.getAttributeValue("name"))) {
                                //反射设值
                                Field field = aClass.getDeclaredField(temp);
                                String value = element.getAttributeValue("value");

                                if ("String".equals(field.getType().getSimpleName())) {
                                    methods[i].invoke(o,value);
                                }else if ("int".equals(field.getType().getSimpleName())) {
                                    int inhale = Integer.parseInt(value);
                                    methods[i].invoke(o,inhale);
                                }else if ("Date".equals(field.getType().getSimpleName())) {
                                    Date date = DateUtils.String2Date(value);
                                    methods[i].invoke(o,date);
                                }else if ("double".equals(field.getType().getSimpleName())) {
                                    double v = Double.parseDouble(value);
                                    methods[i].invoke(o,v);
                                }else if ("float".equals(field.getType().getSimpleName())) {
                                    float v = Float.parseFloat(value);
                                    methods[i].invoke(o,v);
                                }


                            }
                        }else {
                            methods[i].invoke(o,map.get(element.getAttributeValue("ref")));
                        }
                    }
                }
            }
            //对象添加到容器
            map.put(id,o);
        }


    }


    @Override
    public Object getBean(String name) {
        return map.get(name);
    }
}
