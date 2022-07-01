package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class GlideException extends Exception {
  private static final StackTraceElement[] a = new StackTraceElement[0];
  
  private final List<Throwable> b;
  
  private Key c;
  
  private DataSource d;
  
  private Class<?> e;
  
  private String f;
  
  private Exception g;
  
  public GlideException(String paramString) {
    this(paramString, Collections.emptyList());
  }
  
  public GlideException(String paramString, Throwable paramThrowable) {
    this(paramString, Collections.singletonList(paramThrowable));
  }
  
  public GlideException(String paramString, List<Throwable> paramList) {
    this.f = paramString;
    setStackTrace(a);
    this.b = paramList;
  }
  
  private void a(Appendable paramAppendable) {
    a(this, paramAppendable);
    a(b(), new IndentedAppendable(paramAppendable));
  }
  
  private static void a(Throwable paramThrowable, Appendable paramAppendable) {
    try {
      paramAppendable.append(paramThrowable.getClass().toString()).append(": ").append(paramThrowable.getMessage()).append('\n');
      return;
    } catch (IOException iOException) {
      throw new RuntimeException(paramThrowable);
    } 
  }
  
  private void a(Throwable paramThrowable, List<Throwable> paramList) {
    Iterator<Throwable> iterator;
    if (paramThrowable instanceof GlideException) {
      iterator = ((GlideException)paramThrowable).b().iterator();
      while (iterator.hasNext())
        a(iterator.next(), paramList); 
    } else {
      paramList.add(iterator);
    } 
  }
  
  private static void a(List<Throwable> paramList, Appendable paramAppendable) {
    try {
      b(paramList, paramAppendable);
      return;
    } catch (IOException iOException) {
      throw new RuntimeException(iOException);
    } 
  }
  
  private static void b(List<Throwable> paramList, Appendable paramAppendable) throws IOException {
    int j = paramList.size();
    for (int i = 0; i < j; i = k) {
      Appendable appendable = paramAppendable.append("Cause (");
      int k = i + 1;
      appendable.append(String.valueOf(k)).append(" of ").append(String.valueOf(j)).append("): ");
      Throwable throwable = paramList.get(i);
      if (throwable instanceof GlideException) {
        ((GlideException)throwable).a(paramAppendable);
      } else {
        a(throwable, paramAppendable);
      } 
    } 
  }
  
  public Exception a() {
    return this.g;
  }
  
  void a(Key paramKey, DataSource paramDataSource) {
    a(paramKey, paramDataSource, (Class<?>)null);
  }
  
  void a(Key paramKey, DataSource paramDataSource, Class<?> paramClass) {
    this.c = paramKey;
    this.d = paramDataSource;
    this.e = paramClass;
  }
  
  public void a(Exception paramException) {
    this.g = paramException;
  }
  
  public void a(String paramString) {
    List<Throwable> list = c();
    int j = list.size();
    for (int i = 0; i < j; i = k) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Root cause (");
      int k = i + 1;
      stringBuilder.append(k);
      stringBuilder.append(" of ");
      stringBuilder.append(j);
      stringBuilder.append(")");
      Log.i(paramString, stringBuilder.toString(), list.get(i));
    } 
  }
  
  public List<Throwable> b() {
    return this.b;
  }
  
  public List<Throwable> c() {
    ArrayList<Throwable> arrayList = new ArrayList();
    a(this, arrayList);
    return arrayList;
  }
  
  public Throwable fillInStackTrace() {
    return this;
  }
  
  public String getMessage() {
    StringBuilder stringBuilder = new StringBuilder(71);
    stringBuilder.append(this.f);
    Class<?> clazz = this.e;
    String str2 = "";
    if (clazz != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(", ");
      stringBuilder1.append(this.e);
      str1 = stringBuilder1.toString();
    } else {
      str1 = "";
    } 
    stringBuilder.append(str1);
    if (this.d != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(", ");
      stringBuilder1.append(this.d);
      String str = stringBuilder1.toString();
    } else {
      str1 = "";
    } 
    stringBuilder.append(str1);
    String str1 = str2;
    if (this.c != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(", ");
      stringBuilder1.append(this.c);
      str1 = stringBuilder1.toString();
    } 
    stringBuilder.append(str1);
    List<Throwable> list = c();
    if (list.isEmpty())
      return stringBuilder.toString(); 
    if (list.size() == 1) {
      stringBuilder.append("\nThere was 1 cause:");
    } else {
      stringBuilder.append("\nThere were ");
      stringBuilder.append(list.size());
      stringBuilder.append(" causes:");
    } 
    for (Throwable throwable : list) {
      stringBuilder.append('\n');
      stringBuilder.append(throwable.getClass().getName());
      stringBuilder.append('(');
      stringBuilder.append(throwable.getMessage());
      stringBuilder.append(')');
    } 
    stringBuilder.append("\n call GlideException#logRootCauses(String) for more detail");
    return stringBuilder.toString();
  }
  
  public void printStackTrace() {
    printStackTrace(System.err);
  }
  
  public void printStackTrace(PrintStream paramPrintStream) {
    a(paramPrintStream);
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter) {
    a(paramPrintWriter);
  }
  
  static final class IndentedAppendable implements Appendable {
    private final Appendable a;
    
    private boolean b = true;
    
    IndentedAppendable(Appendable param1Appendable) {
      this.a = param1Appendable;
    }
    
    private CharSequence a(CharSequence param1CharSequence) {
      CharSequence charSequence = param1CharSequence;
      if (param1CharSequence == null)
        charSequence = ""; 
      return charSequence;
    }
    
    public Appendable append(char param1Char) throws IOException {
      boolean bool1 = this.b;
      boolean bool = false;
      if (bool1) {
        this.b = false;
        this.a.append("  ");
      } 
      if (param1Char == '\n')
        bool = true; 
      this.b = bool;
      this.a.append(param1Char);
      return this;
    }
    
    public Appendable append(CharSequence param1CharSequence) throws IOException {
      param1CharSequence = a(param1CharSequence);
      return append(param1CharSequence, 0, param1CharSequence.length());
    }
    
    public Appendable append(CharSequence param1CharSequence, int param1Int1, int param1Int2) throws IOException {
      param1CharSequence = a(param1CharSequence);
      boolean bool = this.b;
      boolean bool1 = false;
      if (bool) {
        this.b = false;
        this.a.append("  ");
      } 
      bool = bool1;
      if (param1CharSequence.length() > 0) {
        bool = bool1;
        if (param1CharSequence.charAt(param1Int2 - 1) == '\n')
          bool = true; 
      } 
      this.b = bool;
      this.a.append(param1CharSequence, param1Int1, param1Int2);
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\GlideException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */