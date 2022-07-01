package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractExecutionThreadService implements Service {
  private static final Logger a = Logger.getLogger(AbstractExecutionThreadService.class.getName());
  
  private final Service b = new AbstractService(this) {
      protected void a() {
        this.a.d();
      }
      
      public String toString() {
        return this.a.toString();
      }
    };
  
  protected void a() throws Exception {}
  
  protected abstract void b() throws Exception;
  
  protected void c() throws Exception {}
  
  protected void d() {}
  
  public final Service.State e() {
    return this.b.e();
  }
  
  protected String f() {
    return getClass().getSimpleName();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(f());
    stringBuilder.append(" [");
    stringBuilder.append(e());
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\AbstractExecutionThreadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */