package handler.hander;//package handler.hander;
//
//import java.lang.reflect.Array;
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Enumeration;
//import java.util.List;
//
//import java.lang.reflect.Array;
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Enumeration;
//import java.util.List;
//
//
//
////TODO 通过类加载器进行初始化事件分发的handler
////TODO  andorid 如何实现类加载器
//public class ClassUtils {
//    /**
//     * @return List<Class>    包下所有类
//     * @Description: 根据包名获得该包以及子包下的所有类不查找jar包中的
//     * 获得当前包以及子包下的所有类(android中用)
//     */
//    public static List<Class> getAllClassesByBaseClass(String packageName, Class<?> baseClass) {
//
//        // 不可以优化~
//        return getAllClassesBy(
//                packageName,
//                aClass -> !aClass.equals(baseClass) && baseClass.isAssignableFrom(aClass)
//        );
//    }
//
//    public static List<Class> getAllClassesBy(String packageName, Function func) {
//        try {
//            ArrayList<Class> classes = new ArrayList<>();
//            List<DexFile> dexFiles = new ArrayList<>();
//
//            BaseDexClassLoader classLoader = ((BaseDexClassLoader) App.getAppContext().getClassLoader());
//
//            Field pathListField = classLoader.getClass().getSuperclass().getDeclaredField("pathList");
//            pathListField.setAccessible(true);
//            Object pathList = pathListField.get(classLoader);
//
//            Field dexElementsField = pathList.getClass().getDeclaredField("dexElements");
//            dexElementsField.setAccessible(true);
//            Object dexElements = dexElementsField.get(pathList);
//            int dexLength = Array.getLength(dexElements);
//            Field dexFileField = null;
//
//            for (int i = 0; i < dexLength; i++) {
//                Object dexElement = Array.get(dexElements, i);
//                if (dexFileField == null) {
//                    dexFileField = dexElement.getClass().getDeclaredField("dexFile");
//                    dexFileField.setAccessible(true);
//                }
//                DexFile dexFile = (DexFile) dexFileField.get(dexElement);
//                if (dexFile != null) {
//                    dexFiles.add(dexFile);
//                }
//            }
//
//            for (DexFile file : dexFiles) {
//                for (Enumeration<String> entries = file.entries(); entries.hasMoreElements(); ) {
//                    final String className = entries.nextElement();
//                    if (className.startsWith(packageName)) {
//                        Class clazz = Class.forName(className);
//                        if (func.apply(clazz)) {
//                            classes.add(clazz);
//                        }
//                    }
//                }
//            }
//            return classes;
//        } catch (Throwable e) {
//            e.printStackTrace();
//            return Collections.emptyList();
//        }
//    }
//
//    public static List<Class> getAllClassByAnnotation(String packageName, Class annotationClass) {
//        //判断是不是注解
//        if (annotationClass.isAnnotation()) {
//            return getAllClassesBy(packageName, aClass -> aClass.isAnnotationPresent(annotationClass));
//        } else {
//            return Collections.emptyList();
//        }
//    }
//
//    public interface Function {
//        boolean apply(Class clazz);
//    }
//}
