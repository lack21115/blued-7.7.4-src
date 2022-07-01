package com.ishumei.l111l11111Il;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Base64;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import com.ishumei.l111l11111lIl.l111l11111lIl;
import com.ishumei.l111l1111llIl.l111l1111lI1l;
import com.ishumei.l111l1111llIl.l111l1111lIl;
import com.ishumei.l111l1111llIl.l11l1111lIIl;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class l1111l111111Il {
  private static final String l1111l111111Il = "eJy1Wt9P5DYQ/l9WPPQktBHcG1SVDriiVYFbEdpKoHtwkiHrrmOnsbPAnfq/d5xNgpM4u9k4vOyheH5883k8Htv39HO2hrfZ2QwYJMDV7HgWMvLjB36JCNvQtSffpILEu4LXJVGrGyrV0ddaNgG1EhEKK+GrjPIYv0ka44dfPt38QzbEY4TH3nbsHAdTkpFkdvb0/Xim3lKYnZ38d1xBoFwu17GBgPAoEzTySJp6X9KU0ZAoKviShGsSwy3h+JuZKGJQCy4VYQyiUkq+I1qUkHJFmacDMQGhdzWzoZIpWj2xoBLS8wtulplIIVO08GVieXfd5WI3PTM9ONeD85LXGtppC9rp5NDcwR4PxA/hFkobf5qJDY0g83xQCrXlkQ9hnkEriHbK3VT6oeAKE9S73P57D1KwDWSHR1YanJcG5y2DQwONYGPLIIWLLl0J/uY9VH/Zk/oKNjSEReSyuhCDLVUcMCz2kNe3ojiu4g0YWN6tZPDMIFTerYjoM21ioPKuUqxIeLTF3OA9yG0FBdfHVTlkmC8+YeA4yRxBQHSAp5iJgLCh2XxdSHcql3JL5cUHZG6Wc4TfV5NDnA+qehLmPucczWLhxioUgpRmLd5Vim05gzgUkWsXIA+o77wbIA4JmV4JLlD8rQlnNOiQ8ufe6Rm4ZRpyi6213q0BYbYTM028loF9e0NfNOk6niCacnBcJIby2Ciwi0G4U3UxhoJztsArhNaqi1mpaNLYXUvZQe1LubwH9i/mhKdRsanQyIAVisSrKMNIIOOEGbvUEn8BPb6+fcAeGcvkcESo5F37twWwD8CUyjwYSZOfB+UymBoUZgt16mgWaMAVgFM70wQwtpUJVEJCC4yA5aCEUCvvovrrS0RS1a29UZTh2nGhIgTGmLChGEzGJZq4EdsyY0LpGjIlhwALVxiIba9sp6oiCnQlA95EJ7jp8rIwZ6TuPoif/rI1RbXwvBG5LQgUdUr0G8rh5C5PgmJk9CSjP6d0t8IYm/U0DGnkxIpPE+yBKGHuzBRgnLjpBTP6gIMrPnXi5w7Ui8jW3/DwTpRw4qcA48RPLxgnfjhJYEqO7kgCzjxpUFNy1QQ1li9JE8d8whSfIpcKIK5rbbo8KuA455EByTWHakBTcTRN/tBEunVr2EjKMKNYHF3bRunWtdmBjOUlXYUi57Yrm8GAiublsrRS8bLYQ8OLvWnECuS90Gfq/Y0/lsb9loQTtItSNs4RQ537/uLKxW2Gfke4vd+qDWUWzY2Krizbjeze5ysYyeSFK5XooPhmd12F0nX8sFU6gEs8eo7y5Nd6w51RfVxw23ppvAqEZlB39c0LoEPvGwkeXRzxfGHMHYcMCc/6JqDOsp5iibr3IHOmHC5etQ+pD2fjMOgRv1QfXB711T8nARvjk0o98LVQ33uBb179gGLEthWw8nToGQfkxskKP6o8MgO8GuCrsHOwL8HjQ50xItWaixduvyPouOw5P6KVP7SV7jWB7XKw1/qIS8Ly9USOB780TJSgH3feoAZCMCD2C4EApNKYxsO5QAsVJMtNRm3lMqNKn0vPH/f0N9W1RqU5rzRnu155zGoXRYyOJRiVr1OpF3kujRuc3rBq4aNK+ryxOrvhdDWsUcSp1JVq/MTUfgbBt6X5++CwgPpmgydAxk/HHWoPmYlvXEveYkOJRoZOhlXpA+LI4N8cF0ol8Wca4S6yc2Yq0fut5nm/RB1rLSIkDur/K/H+Sb/XLIFHuGgWxQNRz2VizUzLP8r2ihizU8kIOd8iML4hhHkDgv2K8rVZ2vXTAAqH+k0rISlJqVe+We4r8sL2CjiwmtuQPVPWOJsXVYwK73fKGk8lv1JO1W87t5QG9f1F7XPT+ekkzg+Gs6vsfm5sbUFOWdShyHxWu9ASzalqI36ahK8KTYezA9G0N1YLFD0414MmkO//A9zgF+k=";
  
  private static int l1111l111111Il(boolean paramBoolean) {
    return paramBoolean ? 1 : 0;
  }
  
  public static Map<String, Object> l1111l111111Il() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    try {
      ArrayList<l111l11111lIl.l1111l111111Il> arrayList = new ArrayList();
      JSONArray jSONArray = new JSONArray(l11l11IlIIll());
      int i = 0;
      while (true) {
        int j = jSONArray.length();
        if (i < j) {
          try {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String str1 = jSONObject.getString(l111l1111lI1l.l111l11111Il("949a86"));
            String str2 = jSONObject.getString(l111l1111lI1l.l111l11111Il("9c939e8585"));
            String str3 = jSONObject.getString(l111l1111lI1l.l111l11111Il("929a8b97909b"));
            JSONArray jSONArray1 = jSONObject.getJSONArray(l111l1111lI1l.l111l11111Il("8f9e8d9e92"));
            j = jSONObject.getInt(l111l1111lI1l.l111l11111Il("8b868f9a"));
            l111l11111lIl.l1111l111111Il l1111l111111Il1 = new l111l11111lIl.l1111l111111Il();
            l1111l111111Il1.l1111l111111Il(str1);
            l1111l111111Il1.l111l11111lIl(str2);
            l1111l111111Il1.l111l11111I1l(str3);
            l1111l111111Il1.l1111l111111Il(j);
            ArrayList<String> arrayList1 = new ArrayList();
            for (j = 0; j < jSONArray1.length(); j++)
              arrayList1.add(jSONArray1.getString(j)); 
            l1111l111111Il1.l1111l111111Il(arrayList1);
            arrayList.add(l1111l111111Il1);
          } catch (Exception exception) {}
          i++;
          continue;
        } 
        Iterator<l111l11111lIl.l1111l111111Il> iterator = arrayList.iterator();
        while (true) {
          if (iterator.hasNext()) {
            l111l11111lIl.l1111l111111Il l1111l111111Il1 = iterator.next();
            try {
              String str;
              Class<?> clazz = Class.forName(l1111l111111Il1.l1111l111111Il().replace("/", "."));
              i = l1111l111111Il1.l111l11111Il();
              List<String> list = l1111l111111Il1.l111l11111I1l();
              if (i == 3) {
                Constructor<?> constructor;
                if (list == null || list.size() == 0) {
                  constructor = clazz.getConstructor(new Class[0]);
                } else {
                  constructor = constructor.getConstructor(l1111l111111Il(list));
                } 
                if (Modifier.isNative(constructor.getModifiers())) {
                  str = l1111l111111Il1.l1111l111111Il();
                } else {
                  continue;
                } 
              } else {
                Method method;
                if (list == null || list.size() == 0) {
                  method = str.getDeclaredMethod(l1111l111111Il1.l111l11111lIl(), new Class[0]);
                } else {
                  Class[] arrayOfClass = l1111l111111Il(list);
                  method = method.getDeclaredMethod(l1111l111111Il1.l111l11111lIl(), arrayOfClass);
                } 
                if (Modifier.isNative(method.getModifiers())) {
                  str = l1111l111111Il1.l1111l111111Il();
                } else {
                  continue;
                } 
              } 
              hashMap.put(str, Integer.valueOf(1));
            } catch (Exception exception) {
              hashMap.put(l1111l111111Il1.l1111l111111Il(), Integer.valueOf(2));
            } 
            continue;
          } 
          return (Map)hashMap;
        } 
        break;
      } 
    } catch (Exception exception) {
      return (Map)hashMap;
    } 
  }
  
  private static void l1111l111111Il(Class<?> paramClass, String paramString, Set<Object> paramSet) {
    try {
      Field field = paramClass.getDeclaredField(paramString);
      field.setAccessible(true);
      return;
    } finally {
      paramClass = null;
    } 
  }
  
  private static boolean l1111l111111Il(ClassLoader paramClassLoader, String paramString) {
    if (paramClassLoader == null)
      return false; 
    if (!(paramClassLoader instanceof BaseDexClassLoader))
      return false; 
    try {
      int i;
      Class<?> clazz = Class.forName(l111l1111lI1l.l111l11111Il("9b9e93899694d18c868c8b9a92d1bb9a87af9e8b97b3968c8b"));
      Method method = Class.forName(l111l1111lI1l.l111l11111Il("9b9e93899694d18c868c8b9a92d1bb9a87af9e8b97b3968c8bdbba939a929a918b")).getMethod(l111l1111lI1l.l111l11111Il("8b90ac8b8d969198"), null);
      Field field1 = clazz.getDeclaredField(l111l1111lI1l.l111l11111Il("9b9a87ba939a929a918b8c"));
      field1.setAccessible(true);
      Field field2 = BaseDexClassLoader.class.getDeclaredField(l111l1111lI1l.l111l11111Il("8f9e8b97b3968c8b"));
      field2.setAccessible(true);
      Object[] arrayOfObject = (Object[])field1.get(field2.get(paramClassLoader));
      int j = arrayOfObject.length;
      return false;
    } finally {
      paramClassLoader = null;
    } 
  }
  
  private static boolean l1111l111111Il(String paramString) {
    try {
      ClassLoader classLoader = ClassLoader.getSystemClassLoader();
      if (l1111l111111Il(classLoader, paramString))
        return true; 
      if (l1111l111111Il(classLoader.getParent(), paramString))
        return true; 
      classLoader = l1111l111111Il.class.getClassLoader();
      if (l1111l111111Il(classLoader, paramString))
        return true; 
      boolean bool = l1111l111111Il(classLoader.getParent(), paramString);
      if (bool)
        return true; 
    } catch (Exception exception) {}
    return false;
  }
  
  private static Class[] l1111l111111Il(List<String> paramList) {
    if (paramList == null || paramList.size() == 0)
      return null; 
    ArrayList<Class<?>> arrayList = new ArrayList();
    Iterator<String> iterator = paramList.iterator();
    while (true) {
      Class<?> clazz;
      if (iterator.hasNext()) {
        String str;
        switch ((String)iterator.next()) {
          default:
            clazz = Class.forName(str);
            arrayList.add(clazz);
            continue;
          case "short":
            clazz = short.class;
            arrayList.add(clazz);
            continue;
          case "char":
            clazz = char.class;
            arrayList.add(clazz);
            continue;
          case "byte":
            clazz = byte.class;
            arrayList.add(clazz);
            continue;
          case "float":
            clazz = float.class;
            arrayList.add(clazz);
            continue;
          case "double":
            clazz = double.class;
            arrayList.add(clazz);
            continue;
          case "boolean":
            clazz = boolean.class;
            arrayList.add(clazz);
            continue;
          case "long":
            clazz = long.class;
            arrayList.add(clazz);
            continue;
          case "int":
            break;
        } 
        clazz = int.class;
      } else {
        break;
      } 
      arrayList.add(clazz);
    } 
    Class[] arrayOfClass = new Class[arrayList.size()];
    arrayList.toArray((Class<?>[][])arrayOfClass);
    return arrayOfClass;
  }
  
  public static boolean l111l11111I1l() {
    try {
      return l1111l111111Il(l111l1111lI1l.l111l11111Il("a78f908c9a9bbd8d969b989ad1959e8d"));
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public static Set<Object> l111l11111Il() {
    HashSet<Object> hashSet = new HashSet();
    try {
      Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(l111l1111lI1l.l111l11111Il("9b9ad18d909d89d19e919b8d90969bd1878f908c9a9bd1a78f908c9a9bb79a938f9a8d8c"));
      l1111l111111Il(clazz, l111l1111lI1l.l111l11111Il("99969a939bbc9e9c979a"), hashSet);
      l1111l111111Il(clazz, l111l1111lI1l.l111l11111Il("929a8b97909bbc9e9c979a"), hashSet);
      return hashSet;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static List<String> l111l11111lIl() {
    ArrayList<String> arrayList = new ArrayList();
    try {
      Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
      if (context == null)
        return arrayList; 
      InputMethodManager inputMethodManager = (InputMethodManager)context.getSystemService("input_method");
      if (inputMethodManager == null)
        return arrayList; 
      List list = inputMethodManager.getInputMethodList();
      if (list == null)
        return arrayList; 
      Iterator<InputMethodInfo> iterator = list.iterator();
      while (iterator.hasNext())
        arrayList.add(((InputMethodInfo)iterator.next()).toString()); 
      return arrayList;
    } catch (Exception exception) {
      return arrayList;
    } 
  }
  
  public static Map<String, Object> l111l1111l1Il() {
    // Byte code:
    //   0: new java/util/HashMap
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #6
    //   9: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   12: ldc_w '9b9ad18d909d89d19e919b8d90969bd1878f908c9a9bd1a78f908c9a9bbd8d969b989a'
    //   15: invokestatic l111l11111Il : (Ljava/lang/String;)Ljava/lang/String;
    //   18: invokevirtual loadClass : (Ljava/lang/String;)Ljava/lang/Class;
    //   21: invokevirtual getDeclaredFields : ()[Ljava/lang/reflect/Field;
    //   24: astore_3
    //   25: aload_3
    //   26: arraylength
    //   27: istore_1
    //   28: iconst_0
    //   29: istore_0
    //   30: iload_0
    //   31: iload_1
    //   32: if_icmpge -> 336
    //   35: aload_3
    //   36: iload_0
    //   37: aaload
    //   38: astore_2
    //   39: ldc_w '8cb79090949a9bb29a8b97909bbc9e93939d9e9c948c'
    //   42: invokestatic l111l11111Il : (Ljava/lang/String;)Ljava/lang/String;
    //   45: aload_2
    //   46: invokevirtual getName : ()Ljava/lang/String;
    //   49: invokevirtual equals : (Ljava/lang/Object;)Z
    //   52: ifeq -> 58
    //   55: goto -> 338
    //   58: ldc_w '979090949a9bb29a8b97909bbc9e93939d9e9c948c'
    //   61: invokestatic l111l11111Il : (Ljava/lang/String;)Ljava/lang/String;
    //   64: aload_2
    //   65: invokevirtual getName : ()Ljava/lang/String;
    //   68: invokevirtual equals : (Ljava/lang/Object;)Z
    //   71: ifeq -> 329
    //   74: iconst_1
    //   75: istore_0
    //   76: goto -> 340
    //   79: aload_2
    //   80: iconst_1
    //   81: invokevirtual setAccessible : (Z)V
    //   84: aload_2
    //   85: aconst_null
    //   86: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   89: checkcast java/util/Map
    //   92: astore_2
    //   93: iload_0
    //   94: ifne -> 347
    //   97: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   100: ldc_w '9b9ad18d909d89d19e919b8d90969bd1878f908c9a9bd1a78f908c9a9bbd8d969b989adbbc908f86b091a88d968b9aac908d8b9a9bac9a8b'
    //   103: invokestatic l111l11111Il : (Ljava/lang/String;)Ljava/lang/String;
    //   106: invokevirtual loadClass : (Ljava/lang/String;)Ljava/lang/Class;
    //   109: astore_3
    //   110: aload_3
    //   111: ldc_w '989a8bac919e8f8c97908b'
    //   114: invokestatic l111l11111Il : (Ljava/lang/String;)Ljava/lang/String;
    //   117: iconst_0
    //   118: anewarray java/lang/Class
    //   121: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   124: astore #4
    //   126: aload #4
    //   128: iconst_1
    //   129: invokevirtual setAccessible : (Z)V
    //   132: goto -> 135
    //   135: aload_2
    //   136: invokeinterface entrySet : ()Ljava/util/Set;
    //   141: invokeinterface iterator : ()Ljava/util/Iterator;
    //   146: astore #7
    //   148: aload #7
    //   150: invokeinterface hasNext : ()Z
    //   155: ifeq -> 322
    //   158: aload #7
    //   160: invokeinterface next : ()Ljava/lang/Object;
    //   165: astore #8
    //   167: aload #8
    //   169: checkcast java/util/Map$Entry
    //   172: invokeinterface getKey : ()Ljava/lang/Object;
    //   177: invokevirtual toString : ()Ljava/lang/String;
    //   180: astore #9
    //   182: aload #6
    //   184: aload #9
    //   186: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   191: checkcast java/util/Set
    //   194: astore_2
    //   195: aload_2
    //   196: astore #5
    //   198: aload_2
    //   199: ifnonnull -> 223
    //   202: new java/util/HashSet
    //   205: dup
    //   206: invokespecial <init> : ()V
    //   209: astore #5
    //   211: aload #6
    //   213: aload #9
    //   215: aload #5
    //   217: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   222: pop
    //   223: aload #8
    //   225: checkcast java/util/Map$Entry
    //   228: invokeinterface getValue : ()Ljava/lang/Object;
    //   233: astore_2
    //   234: aload_3
    //   235: ifnull -> 263
    //   238: aload_3
    //   239: aload_2
    //   240: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   243: ifeq -> 263
    //   246: aload #4
    //   248: aload_2
    //   249: iconst_0
    //   250: anewarray java/lang/Object
    //   253: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   256: checkcast [Ljava/lang/Object;
    //   259: astore_2
    //   260: goto -> 284
    //   263: ldc_w java/util/TreeSet
    //   266: aload_2
    //   267: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   270: ifeq -> 355
    //   273: aload_2
    //   274: checkcast java/util/TreeSet
    //   277: invokevirtual toArray : ()[Ljava/lang/Object;
    //   280: astore_2
    //   281: goto -> 284
    //   284: aload_2
    //   285: ifnull -> 148
    //   288: aload_2
    //   289: arraylength
    //   290: istore_1
    //   291: iconst_0
    //   292: istore_0
    //   293: iload_0
    //   294: iload_1
    //   295: if_icmpge -> 148
    //   298: aload #5
    //   300: aload_2
    //   301: iload_0
    //   302: aaload
    //   303: invokevirtual getClass : ()Ljava/lang/Class;
    //   306: invokevirtual getName : ()Ljava/lang/String;
    //   309: invokeinterface add : (Ljava/lang/Object;)Z
    //   314: pop
    //   315: iload_0
    //   316: iconst_1
    //   317: iadd
    //   318: istore_0
    //   319: goto -> 293
    //   322: aload #6
    //   324: areturn
    //   325: astore_2
    //   326: aload #6
    //   328: areturn
    //   329: iload_0
    //   330: iconst_1
    //   331: iadd
    //   332: istore_0
    //   333: goto -> 30
    //   336: aconst_null
    //   337: astore_2
    //   338: iconst_0
    //   339: istore_0
    //   340: aload_2
    //   341: ifnonnull -> 79
    //   344: aload #6
    //   346: areturn
    //   347: aconst_null
    //   348: astore_3
    //   349: aload_3
    //   350: astore #4
    //   352: goto -> 135
    //   355: aconst_null
    //   356: astore_2
    //   357: goto -> 284
    // Exception table:
    //   from	to	target	type
    //   9	28	325	java/lang/Exception
    //   39	55	325	java/lang/Exception
    //   58	74	325	java/lang/Exception
    //   79	93	325	java/lang/Exception
    //   97	132	325	java/lang/Exception
    //   135	148	325	java/lang/Exception
    //   148	195	325	java/lang/Exception
    //   202	223	325	java/lang/Exception
    //   223	234	325	java/lang/Exception
    //   238	260	325	java/lang/Exception
    //   263	281	325	java/lang/Exception
    //   288	291	325	java/lang/Exception
    //   298	315	325	java/lang/Exception
  }
  
  public static String l111l1111lI1l() {
    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
    if (context == null)
      return ""; 
    if (Build.VERSION.SDK_INT >= 23) {
      boolean bool1;
      Locale locale = Locale.CHINA;
      int i = context.checkSelfPermission("android.permission.READ_PHONE_STATE");
      boolean bool2 = true;
      if (i == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      i = l1111l111111Il(bool1);
      if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      int j = l1111l111111Il(bool1);
      if (context.checkSelfPermission("android.permission.WRITE_SETTINGS") == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      int k = l1111l111111Il(bool1);
      if (context.checkSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      int m = l1111l111111Il(bool1);
      if (context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      int n = l1111l111111Il(bool1);
      if (context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      int i1 = l1111l111111Il(bool1);
      if (context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      return String.format(locale, "%d%d%d%d%d%d%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(l1111l111111Il(bool1)) });
    } 
    return "1111111";
  }
  
  public static String l111l1111lIl() {
    if (Build.VERSION.SDK_INT < 23 || Build.VERSION.SDK_INT > 29)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    try {
      Class<?> clazz2 = Class.forName(l111l1111lI1l.l111l11111Il("959e899ed18a8b9693d1aaaab6bb"));
      Class<?> clazz1 = Class.forName(l111l1111lI1l.l111l11111Il("9e919b8d90969bd1929a9b969ed1b29a9b969ebb8d92"));
      Constructor<?> constructor1 = clazz2.getConstructor(new Class[] { long.class, long.class });
      Constructor<?> constructor2 = clazz1.getConstructor(new Class[] { clazz2 });
      Method method = clazz1.getMethod(l111l1111lI1l.l111l11111Il("989a8baf8d908f9a8d8b86bd868b9abe8d8d9e86"), new Class[] { String.class });
      constructor1 = (Constructor<?>)constructor2.newInstance(new Object[] { constructor1.newInstance(new Object[] { Long.valueOf(-1301668207276963122L), Long.valueOf(-6645017420763422227L) }) });
      stringBuilder.append(Base64.encodeToString((byte[])method.invoke(constructor1, new Object[] { l111l1111lI1l.l111l11111Il("9b9a89969c9aaa91968e8a9ab69b") }), 2));
      stringBuilder.append("__");
      stringBuilder.append("_");
      clazz1.getMethod(l111l1111lI1l.l111l11111Il("9c93908c9a"), new Class[0]).invoke(constructor1, new Object[0]);
    } finally {
      Exception exception;
    } 
    return stringBuilder.toString();
  }
  
  public static Map<String, Object> l111l1111llIl() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    try {
      Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
      object1 = Class.forName(l111l1111lI1l.l111l11111Il("9e919b8d90969bd19c90918b9a918bd1bc90918b9a878b")).getDeclaredMethod(l111l1111lI1l.l111l11111Il("989a8bac868c8b9a92ac9a8d89969c9a"), new Class[] { String.class }).invoke(context, new Object[] { l111l1111lI1l.l111l11111Il("9e9c9c9a8c8c969d9693968b86") });
      Method method2 = object1.getClass().getDeclaredMethod(l111l1111lI1l.l111l11111Il("968cba919e9d939a9b"), new Class[0]);
      Method method1 = object1.getClass().getDeclaredMethod(l111l1111lI1l.l111l11111Il("989a8bba919e9d939a9bbe9c9c9a8c8c969d9693968b86ac9a8d89969c9ab3968c8b"), new Class[] { int.class });
      Object object2 = method2.invoke(object1, new Object[0]);
      object1 = method1.invoke(object1, new Object[] { Integer.valueOf(-1) });
      ArrayList<Object> arrayList = new ArrayList();
      for (Object object1 : object1) {
        Object object = object1.getClass().getDeclaredMethod(l111l1111lI1l.l111l11111Il("989a8bb69b"), new Class[0]).invoke(object1, new Object[0]);
        if (object == null) {
          object = object1.getClass().getDeclaredMethod(l111l1111lI1l.l111l11111Il("989a8bad9a8c9093899ab6919990"), new Class[0]).invoke(object1, new Object[0]);
          if (object == null) {
            object1 = object1.toString();
          } else {
            object1 = object.toString();
          } 
          arrayList.add(object1);
          continue;
        } 
        arrayList.add(object);
      } 
      return (Map)hashMap;
    } finally {
      Exception exception = null;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(exception.getMessage());
      hashMap.put("e", stringBuilder.toString());
      hashMap.put("suc", "-1");
    } 
  }
  
  public static String l11l1111I11l() {
    ArrayList arrayList = new ArrayList();
    try {
      Field field = Class.forName(l111l1111lI1l.l111l11111Il("9b9ad18d909d89d19e919b8d90969bd1878f908c9a9bd1a78f908c9a9bb691968b")).getDeclaredField(l111l1111lI1l.l111l11111Il("93909e9b9a9baf9e9c949e989a8cb691af8d909c9a8c8c"));
      field.setAccessible(true);
      arrayList.addAll((Set)field.get((Object)null));
    } finally {
      Exception exception;
    } 
    return TextUtils.join("|", arrayList);
  }
  
  public static String l11l1111I1l() {
    if (Build.VERSION.SDK_INT < 23)
      return ""; 
    ArrayList<String> arrayList = new ArrayList();
    try {
      Field field = Class.forName(l111l1111lI1l.l111l11111Il("9b9ad18d909d89d19e919b8d90969bd1878f908c9a9bd1a78f908c9a9bb691968b")).getDeclaredField(l111l1111lI1l.l111l11111Il("93909e9b9a9bb2909b8a939a8c"));
      field.setAccessible(true);
      Iterator<E> iterator = ((ArraySet)field.get((Object)null)).iterator();
      while (iterator.hasNext())
        arrayList.add(iterator.next().toString()); 
    } finally {
      Exception exception;
    } 
    return TextUtils.join("|", arrayList);
  }
  
  public static String l11l1111I1ll() {
    if (Build.VERSION.SDK_INT >= 28)
      return ""; 
    String str = l111l1111lI1l.l111l11111Il("9c9092d19a939b9a8d9b8d96899a8d8cd18d968d8ad19a9b878fd19c9091999698d1ba9ba78fbc9091999698b893909d9e93");
    ArrayList<Object> arrayList = new ArrayList();
    try {
      Class<?> clazz = Class.forName(l111l1111lI1l.l111l11111Il("9e919b8d90969bd19e8f8fd1be8f8f93969c9e8b969091b3909e9b9a8d8c"));
      Field field2 = clazz.getDeclaredField(l111l1111lI1l.l111l11111Il("98be8f8f93969c9e8b969091b3909e9b9a8d8c"));
      field2.setAccessible(true);
      Object object = field2.get((Object)null);
      Field field1 = clazz.getDeclaredField(l111l1111lI1l.l111l11111Il("92b3909e9b9a8d8c"));
      field1.setAccessible(true);
      Iterator<Map.Entry> iterator = ((Map)field1.get(object)).entrySet().iterator();
      while (true) {
        if (iterator.hasNext()) {
          Map.Entry entry = iterator.next();
          object = entry.getKey();
          ClassLoader classLoader = (ClassLoader)entry.getValue();
          try {
            Class.forName(str, false, classLoader);
            arrayList.add(object);
          } catch (ClassNotFoundException classNotFoundException) {}
          continue;
        } 
        return TextUtils.join("|", arrayList);
      } 
    } finally {}
    return TextUtils.join("|", arrayList);
  }
  
  public static List<String> l11l1111Il() {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #5
    //   9: new java/util/HashSet
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: astore #8
    //   18: getstatic com/ishumei/l1111l111111Il/l111l1111llIl$l1111l111111Il.l111l11111Il : Landroid/content/Context;
    //   21: astore #9
    //   23: aload #9
    //   25: ifnonnull -> 31
    //   28: aload #5
    //   30: areturn
    //   31: aconst_null
    //   32: astore #4
    //   34: new java/io/BufferedReader
    //   37: dup
    //   38: new java/io/FileReader
    //   41: dup
    //   42: ldc_w 'd08f8d909cd08c9a9399d0929e8f8c'
    //   45: invokestatic l111l11111Il : (Ljava/lang/String;)Ljava/lang/String;
    //   48: invokespecial <init> : (Ljava/lang/String;)V
    //   51: invokespecial <init> : (Ljava/io/Reader;)V
    //   54: astore_3
    //   55: aload_3
    //   56: invokevirtual readLine : ()Ljava/lang/String;
    //   59: astore #4
    //   61: aload #4
    //   63: ifnull -> 153
    //   66: aload #4
    //   68: ldc_w '/data/app/'
    //   71: invokevirtual indexOf : (Ljava/lang/String;)I
    //   74: istore_2
    //   75: iload_2
    //   76: iconst_m1
    //   77: if_icmpne -> 83
    //   80: goto -> 55
    //   83: aload #4
    //   85: ldc_w '-'
    //   88: iload_2
    //   89: invokevirtual indexOf : (Ljava/lang/String;I)I
    //   92: istore_1
    //   93: iload_1
    //   94: istore_0
    //   95: iload_1
    //   96: iconst_m1
    //   97: if_icmpne -> 112
    //   100: aload #4
    //   102: ldc '/'
    //   104: iload_2
    //   105: bipush #10
    //   107: iadd
    //   108: invokevirtual indexOf : (Ljava/lang/String;I)I
    //   111: istore_0
    //   112: aload #4
    //   114: iload_2
    //   115: bipush #10
    //   117: iadd
    //   118: iload_0
    //   119: invokevirtual substring : (II)Ljava/lang/String;
    //   122: astore #4
    //   124: aload #4
    //   126: aload #9
    //   128: invokevirtual getPackageName : ()Ljava/lang/String;
    //   131: invokevirtual equals : (Ljava/lang/Object;)Z
    //   134: ifeq -> 140
    //   137: goto -> 55
    //   140: aload #8
    //   142: aload #4
    //   144: invokeinterface add : (Ljava/lang/Object;)Z
    //   149: pop
    //   150: goto -> 55
    //   153: aload_3
    //   154: invokevirtual close : ()V
    //   157: goto -> 191
    //   160: astore #4
    //   162: goto -> 172
    //   165: goto -> 183
    //   168: astore #4
    //   170: aconst_null
    //   171: astore_3
    //   172: aload_3
    //   173: ifnull -> 180
    //   176: aload_3
    //   177: invokevirtual close : ()V
    //   180: aload #4
    //   182: athrow
    //   183: aload_3
    //   184: ifnull -> 191
    //   187: aload_3
    //   188: invokevirtual close : ()V
    //   191: ldc_w '878f908c9a9b92909b8a939a'
    //   194: invokestatic l111l11111Il : (Ljava/lang/String;)Ljava/lang/String;
    //   197: astore #4
    //   199: ldc_w '878f908c9a9b929691899a8d8c969091'
    //   202: invokestatic l111l11111Il : (Ljava/lang/String;)Ljava/lang/String;
    //   205: astore #6
    //   207: ldc_w '878f908c9a9b9b9a8c9c8d968f8b969091'
    //   210: invokestatic l111l11111Il : (Ljava/lang/String;)Ljava/lang/String;
    //   213: astore #7
    //   215: aload #9
    //   217: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   220: astore #9
    //   222: aload #8
    //   224: invokeinterface iterator : ()Ljava/util/Iterator;
    //   229: astore #8
    //   231: aload #8
    //   233: invokeinterface hasNext : ()Z
    //   238: ifeq -> 382
    //   241: aload #8
    //   243: invokeinterface next : ()Ljava/lang/Object;
    //   248: checkcast java/lang/String
    //   251: astore #10
    //   253: aload #9
    //   255: aload #10
    //   257: sipush #128
    //   260: invokevirtual getApplicationInfo : (Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   263: astore_3
    //   264: aload_3
    //   265: getfield metaData : Landroid/os/Bundle;
    //   268: astore #13
    //   270: aload #13
    //   272: ifnonnull -> 278
    //   275: goto -> 231
    //   278: aload #13
    //   280: aload #4
    //   282: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   285: astore #11
    //   287: aload #13
    //   289: aload #6
    //   291: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   294: astore #12
    //   296: aload #13
    //   298: aload #7
    //   300: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   303: astore #13
    //   305: aload #11
    //   307: ifnull -> 231
    //   310: getstatic android/os/Build$VERSION.SDK_INT : I
    //   313: bipush #29
    //   315: if_icmplt -> 325
    //   318: ldc_w ''
    //   321: astore_3
    //   322: goto -> 337
    //   325: aload_3
    //   326: aload #9
    //   328: invokevirtual loadLabel : (Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   331: invokeinterface toString : ()Ljava/lang/String;
    //   336: astore_3
    //   337: aload #5
    //   339: ldc_w ','
    //   342: iconst_5
    //   343: anewarray java/lang/Object
    //   346: dup
    //   347: iconst_0
    //   348: aload #10
    //   350: aastore
    //   351: dup
    //   352: iconst_1
    //   353: aload_3
    //   354: aastore
    //   355: dup
    //   356: iconst_2
    //   357: aload #11
    //   359: aastore
    //   360: dup
    //   361: iconst_3
    //   362: aload #12
    //   364: aastore
    //   365: dup
    //   366: iconst_4
    //   367: aload #13
    //   369: aastore
    //   370: invokestatic join : (Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;
    //   373: invokeinterface add : (Ljava/lang/Object;)Z
    //   378: pop
    //   379: goto -> 231
    //   382: aload #5
    //   384: areturn
    //   385: astore_3
    //   386: aload #4
    //   388: astore_3
    //   389: goto -> 183
    //   392: astore #4
    //   394: goto -> 165
    //   397: astore #4
    //   399: goto -> 55
    //   402: astore_3
    //   403: goto -> 191
    //   406: astore_3
    //   407: goto -> 180
    //   410: astore_3
    //   411: aload #5
    //   413: areturn
    //   414: astore_3
    //   415: goto -> 231
    // Exception table:
    //   from	to	target	type
    //   34	55	385	java/lang/Exception
    //   34	55	168	finally
    //   55	61	392	java/lang/Exception
    //   55	61	160	finally
    //   66	75	397	java/lang/Exception
    //   66	75	160	finally
    //   83	93	397	java/lang/Exception
    //   83	93	160	finally
    //   100	112	397	java/lang/Exception
    //   100	112	160	finally
    //   112	137	397	java/lang/Exception
    //   112	137	160	finally
    //   140	150	397	java/lang/Exception
    //   140	150	160	finally
    //   153	157	402	java/io/IOException
    //   176	180	406	java/io/IOException
    //   187	191	402	java/io/IOException
    //   191	231	410	java/lang/Exception
    //   231	253	410	java/lang/Exception
    //   253	270	414	java/lang/Exception
    //   278	305	414	java/lang/Exception
    //   310	318	414	java/lang/Exception
    //   325	337	414	java/lang/Exception
    //   337	379	414	java/lang/Exception
  }
  
  public static Map<String, Object> l11l1111Il1l() {
    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
    if (context == null)
      return null; 
    ActivityManager activityManager = (ActivityManager)context.getSystemService("activity");
    if (activityManager == null)
      return null; 
    HashSet<String> hashSet = new HashSet();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(3);
    hashSet.add(l111l1111lI1l.l111l11111Il("8a8c9a8dd1858f908c9a9bd19e8f8f"));
    hashSet.add(l111l1111lI1l.l111l11111Il("8a8c9a8dd1858f908c9a9bd18c868c8b9a92"));
    for (ActivityManager.RunningServiceInfo runningServiceInfo : activityManager.getRunningServices(2147483647)) {
      if (hashSet.contains(runningServiceInfo.process))
        hashMap.put(runningServiceInfo.process, Integer.valueOf(1)); 
    } 
    return (Map)hashMap;
  }
  
  public static int l11l1111Ill() {
    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
    if (context == null)
      return 0; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(context.getFilesDir());
    stringBuilder.append(File.separator);
    stringBuilder.append(l111l1111lI1l.l111l11111Il("9a878fa09d9e8c9ad19e8f94"));
    return (new File(stringBuilder.toString())).exists() ? 1 : 0;
  }
  
  public static String l11l1111lIIl() {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      Method method = Class.forName(l111l1111lI1l.l111l11111Il("9e919b8d90969bd1908cd1ac9a8d89969c9ab29e919e989a8d")).getMethod(l111l1111lI1l.l111l11111Il("989a8bac9a8d89969c9a"), new Class[] { String.class });
      method.setAccessible(true);
      Object object1 = method.invoke((Object)null, new Object[] { "location" });
      Object object2 = method.invoke((Object)null, new Object[] { "phone" });
      stringBuilder.append("locateServiceName:");
      stringBuilder.append(object1.getClass().getName());
      stringBuilder.append("|");
      stringBuilder.append("phoneServiceName:");
      stringBuilder.append(object2.getClass().getName());
    } finally {
      Exception exception;
    } 
    return stringBuilder.toString();
  }
  
  private static String l11l111l11Il() {
    try {
      BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      Field field = Class.forName(l111l1111lI1l.l111l11111Il("9e919b8d90969bd19d938a9a8b90908b97d1bd938a9a8b90908b97be9b9e8f8b9a8d")).getDeclaredField(l111l1111lI1l.l111l11111Il("92ac9a8d89969c9a"));
      field.setAccessible(true);
      Object object = field.get(bluetoothAdapter);
      if (object != null) {
        object = Class.forName(l111l1111lI1l.l111l11111Il("9e919b8d90969bd19d938a9a8b90908b97d1b6bd938a9a8b90908b97dbac8b8a9ddbaf8d908786")).getMethod(l111l1111lI1l.l111l11111Il("989a8bbe9b9b8d9a8c8c"), null).invoke(object, (Object[])null);
        if (object != null && object instanceof String)
          return (String)object; 
        throw new Exception();
      } 
      throw new Exception();
    } catch (Exception exception) {
      try {
        Class<?> clazz = Class.forName(l111l1111lI1l.l111l11111Il("9e919b8d90969bd1908cd1ac9a8d89969c9ab29e919e989a8d"));
        Class.forName(l111l1111lI1l.l111l11111Il("9e919b8d90969bd19d938a9a8b90908b97d1b6bd938a9a8b90908b97b29e919e989a8ddbac8b8a9d")).getField(l111l1111lI1l.l111l11111Il("b9b6adacaba0bcbeb3b3a0abadbeb1acbebcabb6b0b1"));
        null = (IBinder)clazz.getMethod(l111l1111lI1l.l111l11111Il("989a8bac9a8d89969c9a"), new Class[] { String.class }).invoke((Object)null, new Object[] { l111l1111lI1l.l111l11111Il("9d938a9a8b90908b97a0929e919e989a8d") });
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(l111l1111lI1l.l111l11111Il("9e919b8d90969bd19d938a9a8b90908b97d1b6bd938a9a8b90908b97b29e919e989a8d"));
          if (Build.VERSION.SDK_INT >= 21) {
            null.transact(5, parcel1, parcel2, 0);
          } else {
            null.transact(10, parcel1, parcel2, 0);
          } 
          parcel2.readException();
          String str = parcel2.readString();
          parcel2.recycle();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      } catch (Exception exception1) {
        return "";
      } 
      return (String)SYNTHETIC_LOCAL_VARIABLE_2;
    } 
  }
  
  private static String l11l111l1lll() {
    try {
      String str1 = l111l1111lI1l.l111l11111Il("8c8a9d8c8b8d9e8b9a");
      String str2 = l111l1111lI1l.l111l11111Il("a78f908c9a9b");
      for (String str : l111l1111lIl.l111l11111I1l(l111l1111lI1l.l111l11111Il("d08f8d909cd08c9a9399d0929e8f8c"))) {
        if (!TextUtils.isEmpty(str)) {
          if (str.contains(str1))
            return str1; 
          boolean bool = str.contains(str2);
          if (bool)
            return str2; 
        } 
      } 
    } catch (Exception exception) {}
    return "";
  }
  
  private static String l11l11IlIIll() {
    byte[] arrayOfByte = Base64.decode("eJy1Wt9P5DYQ/l9WPPQktBHcG1SVDriiVYFbEdpKoHtwkiHrrmOnsbPAnfq/d5xNgpM4u9k4vOyheH5883k8Htv39HO2hrfZ2QwYJMDV7HgWMvLjB36JCNvQtSffpILEu4LXJVGrGyrV0ddaNgG1EhEKK+GrjPIYv0ka44dfPt38QzbEY4TH3nbsHAdTkpFkdvb0/Xim3lKYnZ38d1xBoFwu17GBgPAoEzTySJp6X9KU0ZAoKviShGsSwy3h+JuZKGJQCy4VYQyiUkq+I1qUkHJFmacDMQGhdzWzoZIpWj2xoBLS8wtulplIIVO08GVieXfd5WI3PTM9ONeD85LXGtppC9rp5NDcwR4PxA/hFkobf5qJDY0g83xQCrXlkQ9hnkEriHbK3VT6oeAKE9S73P57D1KwDWSHR1YanJcG5y2DQwONYGPLIIWLLl0J/uY9VH/Zk/oKNjSEReSyuhCDLVUcMCz2kNe3ojiu4g0YWN6tZPDMIFTerYjoM21ioPKuUqxIeLTF3OA9yG0FBdfHVTlkmC8+YeA4yRxBQHSAp5iJgLCh2XxdSHcql3JL5cUHZG6Wc4TfV5NDnA+qehLmPucczWLhxioUgpRmLd5Vim05gzgUkWsXIA+o77wbIA4JmV4JLlD8rQlnNOiQ8ufe6Rm4ZRpyi6213q0BYbYTM028loF9e0NfNOk6niCacnBcJIby2Ciwi0G4U3UxhoJztsArhNaqi1mpaNLYXUvZQe1LubwH9i/mhKdRsanQyIAVisSrKMNIIOOEGbvUEn8BPb6+fcAeGcvkcESo5F37twWwD8CUyjwYSZOfB+UymBoUZgt16mgWaMAVgFM70wQwtpUJVEJCC4yA5aCEUCvvovrrS0RS1a29UZTh2nGhIgTGmLChGEzGJZq4EdsyY0LpGjIlhwALVxiIba9sp6oiCnQlA95EJ7jp8rIwZ6TuPoif/rI1RbXwvBG5LQgUdUr0G8rh5C5PgmJk9CSjP6d0t8IYm/U0DGnkxIpPE+yBKGHuzBRgnLjpBTP6gIMrPnXi5w7Ui8jW3/DwTpRw4qcA48RPLxgnfjhJYEqO7kgCzjxpUFNy1QQ1li9JE8d8whSfIpcKIK5rbbo8KuA455EByTWHakBTcTRN/tBEunVr2EjKMKNYHF3bRunWtdmBjOUlXYUi57Yrm8GAiublsrRS8bLYQ8OLvWnECuS90Gfq/Y0/lsb9loQTtItSNs4RQ537/uLKxW2Gfke4vd+qDWUWzY2Krizbjeze5ysYyeSFK5XooPhmd12F0nX8sFU6gEs8eo7y5Nd6w51RfVxw23ppvAqEZlB39c0LoEPvGwkeXRzxfGHMHYcMCc/6JqDOsp5iibr3IHOmHC5etQ+pD2fjMOgRv1QfXB711T8nARvjk0o98LVQ33uBb179gGLEthWw8nToGQfkxskKP6o8MgO8GuCrsHOwL8HjQ50xItWaixduvyPouOw5P6KVP7SV7jWB7XKw1/qIS8Ly9USOB780TJSgH3feoAZCMCD2C4EApNKYxsO5QAsVJMtNRm3lMqNKn0vPH/f0N9W1RqU5rzRnu155zGoXRYyOJRiVr1OpF3kujRuc3rBq4aNK+ryxOrvhdDWsUcSp1JVq/MTUfgbBt6X5++CwgPpmgydAxk/HHWoPmYlvXEveYkOJRoZOhlXpA+LI4N8cF0ol8Wca4S6yc2Yq0fut5nm/RB1rLSIkDur/K/H+Sb/XLIFHuGgWxQNRz2VizUzLP8r2ihizU8kIOd8iML4hhHkDgv2K8rVZ2vXTAAqH+k0rISlJqVe+We4r8sL2CjiwmtuQPVPWOJsXVYwK73fKGk8lv1JO1W87t5QG9f1F7XPT+ekkzg+Gs6vsfm5sbUFOWdShyHxWu9ASzalqI36ahK8KTYezA9G0N1YLFD0414MmkO//A9zgF+k=", 0);
    try {
      return new String(l11l1111lIIl.l1111l111111Il(arrayOfByte));
    } catch (Exception exception) {
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l1111l111111Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */