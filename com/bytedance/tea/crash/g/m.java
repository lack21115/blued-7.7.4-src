package com.bytedance.tea.crash.g;

import android.os.Build;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m {
  public static String a(Throwable paramThrowable) {
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    try {
      if (c(paramThrowable)) {
        a(paramThrowable, printWriter);
      } else {
        paramThrowable.printStackTrace(printWriter);
      } 
      return stringWriter.toString();
    } catch (Exception exception) {
      return "";
    } finally {
      printWriter.close();
    } 
  }
  
  public static String a(StackTraceElement[] paramArrayOfStackTraceElement) {
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramArrayOfStackTraceElement.length;
    for (int i = 0; i < j; i++)
      a(paramArrayOfStackTraceElement[i], stringBuilder); 
    return stringBuilder.toString();
  }
  
  public static StringBuilder a(StackTraceElement paramStackTraceElement, StringBuilder paramStringBuilder) {
    String str = paramStackTraceElement.getClassName();
    paramStringBuilder.append("  at ");
    paramStringBuilder.append(str);
    paramStringBuilder.append(".");
    paramStringBuilder.append(paramStackTraceElement.getMethodName());
    paramStringBuilder.append("(");
    paramStringBuilder.append(paramStackTraceElement.getFileName());
    paramStringBuilder.append(":");
    paramStringBuilder.append(paramStackTraceElement.getLineNumber());
    paramStringBuilder.append(")\n");
    return paramStringBuilder;
  }
  
  public static JSONObject a(String paramString) {
    try {
      Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
      JSONObject jSONObject = new JSONObject();
      if (map == null)
        return null; 
      jSONObject.put("thread_all_count", map.size());
      JSONArray jSONArray = new JSONArray();
      Iterator<Map.Entry> iterator = map.entrySet().iterator();
      while (true) {
        if (iterator.hasNext()) {
          boolean bool;
          Map.Entry entry = iterator.next();
          JSONObject jSONObject1 = new JSONObject();
          Thread thread = (Thread)entry.getKey();
          String str = thread.getName();
          if (b(str) || (paramString != null && (paramString.equals(str) || str.startsWith(paramString) || str.endsWith(paramString))))
            continue; 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(thread.getName());
          stringBuilder.append("(");
          stringBuilder.append(thread.getId());
          stringBuilder.append(")");
          jSONObject1.put("thread_name", stringBuilder.toString());
          StackTraceElement[] arrayOfStackTraceElement = (StackTraceElement[])entry.getValue();
          if (arrayOfStackTraceElement != null) {
            JSONArray jSONArray1 = new JSONArray();
            int i = arrayOfStackTraceElement.length;
            for (bool = false; bool < i; bool++) {
              StackTraceElement stackTraceElement = arrayOfStackTraceElement[bool];
              String str1 = stackTraceElement.getClassName();
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(str1);
              stringBuilder1.append(".");
              stringBuilder1.append(stackTraceElement.getMethodName());
              stringBuilder1.append("(");
              stringBuilder1.append(stackTraceElement.getLineNumber());
              stringBuilder1.append(")");
              jSONArray1.put(stringBuilder1.toString());
            } 
            jSONObject1.put("thread_stack", jSONArray1);
            if (jSONArray1.length() > 0) {
              bool = true;
            } else {
              bool = false;
            } 
          } else {
            bool = true;
          } 
          if (bool)
            jSONArray.put(jSONObject1); 
          continue;
        } 
        return jSONObject;
      } 
    } finally {
      paramString = null;
    } 
  }
  
  private static void a(Throwable paramThrowable, a parama, StackTraceElement[] paramArrayOfStackTraceElement, String paramString1, String paramString2, Set<Throwable> paramSet) {
    if (paramSet.contains(paramThrowable)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("\t[CIRCULAR REFERENCE:");
      stringBuilder.append(paramThrowable);
      stringBuilder.append("]");
      parama.a(stringBuilder.toString());
      return;
    } 
    paramSet.add(paramThrowable);
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    int n = Math.min(arrayOfStackTraceElement.length, 256);
    int i = Math.min(stringBuilder.length, 256);
    int k = n - 1;
    int j = i - 1;
    i = k;
    while (i >= 0 && j >= 0 && arrayOfStackTraceElement[i].equals(stringBuilder[j])) {
      i--;
      j--;
    } 
    int i1 = k - i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append(paramString1);
    stringBuilder.append(paramThrowable);
    parama.a(stringBuilder.toString());
    k = 0;
    for (j = 0; j <= i; j++) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append("\tat ");
      stringBuilder.append(arrayOfStackTraceElement[j]);
      parama.a(stringBuilder.toString());
    } 
    if (n < arrayOfStackTraceElement.length) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("\t... skip ");
      stringBuilder.append(arrayOfStackTraceElement.length - n);
      stringBuilder.append(" lines");
      parama.a(stringBuilder.toString());
    } 
    if (i1 != 0) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append("\t... ");
      stringBuilder.append(i1);
      stringBuilder.append(" more");
      parama.a(stringBuilder.toString());
    } 
    if (Build.VERSION.SDK_INT >= 19) {
      Throwable[] arrayOfThrowable = paramThrowable.getSuppressed();
      j = arrayOfThrowable.length;
      for (i = k; i < j; i++) {
        Throwable throwable = arrayOfThrowable[i];
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString2);
        stringBuilder1.append("\t");
        a(throwable, parama, arrayOfStackTraceElement, "Suppressed: ", stringBuilder1.toString(), paramSet);
      } 
    } 
    paramThrowable = paramThrowable.getCause();
    if (paramThrowable != null)
      a(paramThrowable, parama, arrayOfStackTraceElement, "Caused by: ", paramString2, paramSet); 
  }
  
  private static void a(Throwable paramThrowable, PrintWriter paramPrintWriter) {
    if (paramThrowable != null) {
      if (paramPrintWriter == null)
        return; 
      a a = new a(paramPrintWriter);
      Set<?> set = Collections.newSetFromMap(new IdentityHashMap<Object, Boolean>());
      set.add(paramThrowable);
      synchronized (a.a()) {
        a.a(paramThrowable);
        StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
        int k = arrayOfStackTraceElement.length;
        int i = 0;
        int j = 0;
        while (i < k) {
          StringBuilder stringBuilder1;
          StackTraceElement stackTraceElement = arrayOfStackTraceElement[i];
          if (j > 256) {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("\t... skip ");
            stringBuilder1.append(arrayOfStackTraceElement.length - j);
            stringBuilder1.append(" lines");
            a.a(stringBuilder1.toString());
            break;
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("\tat ");
          stringBuilder2.append(stringBuilder1);
          a.a(stringBuilder2.toString());
          j++;
          i++;
        } 
        if (Build.VERSION.SDK_INT >= 19) {
          Throwable[] arrayOfThrowable = paramThrowable.getSuppressed();
          j = arrayOfThrowable.length;
          for (i = 0; i < j; i++)
            a(arrayOfThrowable[i], a, arrayOfStackTraceElement, "Suppressed: ", "\t", (Set)set); 
        } 
        paramThrowable = paramThrowable.getCause();
        if (paramThrowable != null)
          a(paramThrowable, a, arrayOfStackTraceElement, "Caused by: ", "", (Set)set); 
        return;
      } 
    } 
  }
  
  private static boolean b(String paramString) {
    Set<String> set = e.a();
    if (set.contains(paramString))
      return true; 
    for (String str : set) {
      if (!TextUtils.isEmpty(paramString) && paramString.startsWith(str))
        return true; 
    } 
    return false;
  }
  
  public static boolean b(Throwable paramThrowable) {
    if (paramThrowable == null)
      return false; 
    int i = 0;
    while (true) {
      if (paramThrowable != null) {
        try {
          if (paramThrowable instanceof OutOfMemoryError)
            return true; 
        } finally {
          paramThrowable = null;
        } 
      } else {
        return false;
      } 
      if (i > 20)
        return false; 
      i++;
      paramThrowable = paramThrowable.getCause();
    } 
  }
  
  private static boolean c(Throwable paramThrowable) {
    for (int i = 0; paramThrowable != null; i++) {
      if (paramThrowable instanceof StackOverflowError)
        return true; 
      if (i > 20)
        return false; 
      paramThrowable = paramThrowable.getCause();
    } 
    return false;
  }
  
  static class a {
    private final PrintWriter a;
    
    a(PrintWriter param1PrintWriter) {
      this.a = param1PrintWriter;
    }
    
    Object a() {
      return this.a;
    }
    
    void a(Object param1Object) {
      this.a.println(param1Object);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\g\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */