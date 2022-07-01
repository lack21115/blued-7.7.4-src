package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Closer implements Closeable {
  private static final Suppressor b;
  
  final Suppressor a;
  
  private final Deque<Closeable> c = new ArrayDeque<Closeable>(4);
  
  @NullableDecl
  private Throwable d;
  
  static {
    LoggingSuppressor loggingSuppressor;
    if (SuppressingSuppressor.a()) {
      SuppressingSuppressor suppressingSuppressor = SuppressingSuppressor.a;
    } else {
      loggingSuppressor = LoggingSuppressor.a;
    } 
    b = loggingSuppressor;
  }
  
  Closer(Suppressor paramSuppressor) {
    this.a = (Suppressor)Preconditions.a(paramSuppressor);
  }
  
  public static Closer a() {
    return new Closer(b);
  }
  
  public <C extends Closeable> C a(@NullableDecl C paramC) {
    if (paramC != null)
      this.c.addFirst((Closeable)paramC); 
    return paramC;
  }
  
  public RuntimeException a(Throwable paramThrowable) throws IOException {
    Preconditions.a(paramThrowable);
    this.d = paramThrowable;
    Throwables.c(paramThrowable, IOException.class);
    throw new RuntimeException(paramThrowable);
  }
  
  public void close() throws IOException {
    Throwable throwable = this.d;
    while (!this.c.isEmpty()) {
      Closeable closeable = this.c.removeFirst();
      try {
        closeable.close();
      } finally {
        Exception exception = null;
        if (throwable == null)
          throwable = exception; 
      } 
    } 
    if (this.d == null) {
      if (throwable == null)
        return; 
      Throwables.c(throwable, IOException.class);
      throw new AssertionError(throwable);
    } 
  }
  
  static final class LoggingSuppressor implements Suppressor {
    static final LoggingSuppressor a = new LoggingSuppressor();
    
    public void a(Closeable param1Closeable, Throwable param1Throwable1, Throwable param1Throwable2) {
      Logger logger = Closeables.a;
      Level level = Level.WARNING;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Suppressing exception thrown when closing ");
      stringBuilder.append(param1Closeable);
      logger.log(level, stringBuilder.toString(), param1Throwable2);
    }
  }
  
  static final class SuppressingSuppressor implements Suppressor {
    static final SuppressingSuppressor a = new SuppressingSuppressor();
    
    static final Method b = b();
    
    static boolean a() {
      return (b != null);
    }
    
    private static Method b() {
      try {
        return Throwable.class.getMethod("addSuppressed", new Class[] { Throwable.class });
      } finally {
        Exception exception = null;
      } 
    }
    
    public void a(Closeable param1Closeable, Throwable param1Throwable1, Throwable param1Throwable2) {
      if (param1Throwable1 == param1Throwable2)
        return; 
      try {
        return;
      } finally {
        Exception exception = null;
        Closer.LoggingSuppressor.a.a(param1Closeable, param1Throwable1, param1Throwable2);
      } 
    }
  }
  
  static interface Suppressor {
    void a(Closeable param1Closeable, Throwable param1Throwable1, Throwable param1Throwable2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\Closer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */