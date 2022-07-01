package com.alibaba.fastjson.util;

import java.io.Closeable;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ServiceLoader {
  private static final String PREFIX = "META-INF/services/";
  
  private static final Set<String> loadedUrls = new HashSet<String>();
  
  public static <T> Set<T> load(Class<T> paramClass, ClassLoader paramClassLoader) {
    if (paramClassLoader == null)
      return Collections.emptySet(); 
    HashSet<T> hashSet1 = new HashSet();
    String str1 = paramClass.getName();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("META-INF/services/");
    stringBuilder.append(str1);
    String str2 = stringBuilder.toString();
    HashSet<String> hashSet = new HashSet();
    try {
      Enumeration<URL> enumeration = paramClassLoader.getResources(str2);
      while (enumeration.hasMoreElements()) {
        URL uRL = enumeration.nextElement();
        if (loadedUrls.contains(uRL.toString()))
          continue; 
        load(uRL, hashSet);
        loadedUrls.add(uRL.toString());
      } 
    } catch (IOException iOException) {}
    Iterator<String> iterator = hashSet.iterator();
    while (true) {
      if (iterator.hasNext()) {
        str2 = iterator.next();
        try {
          hashSet1.add(paramClassLoader.loadClass(str2).newInstance());
        } catch (Exception exception) {}
        continue;
      } 
      return hashSet1;
    } 
  }
  
  public static void load(URL paramURL, Set<String> paramSet) throws IOException {
    String str1;
    Closeable closeable;
    String str2 = null;
    try {
    
    } finally {
      paramURL = null;
      closeable = null;
    } 
    IOUtils.close((Closeable)str1);
    IOUtils.close(closeable);
    throw paramURL;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjso\\util\ServiceLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */