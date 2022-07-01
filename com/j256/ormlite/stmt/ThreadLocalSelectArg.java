package com.j256.ormlite.stmt;

import com.j256.ormlite.field.SqlType;

public class ThreadLocalSelectArg extends BaseArgumentHolder implements ArgumentHolder {
  private ThreadLocal<ValueWrapper> threadValue = new ThreadLocal<ValueWrapper>();
  
  public ThreadLocalSelectArg() {}
  
  public ThreadLocalSelectArg(SqlType paramSqlType, Object paramObject) {
    super(paramSqlType);
    setValue(paramObject);
  }
  
  public ThreadLocalSelectArg(Object paramObject) {
    setValue(paramObject);
  }
  
  public ThreadLocalSelectArg(String paramString, Object paramObject) {
    super(paramString);
    setValue(paramObject);
  }
  
  protected Object getValue() {
    ValueWrapper valueWrapper = this.threadValue.get();
    return (valueWrapper == null) ? null : valueWrapper.value;
  }
  
  protected boolean isValueSet() {
    return (this.threadValue.get() != null);
  }
  
  public void setValue(Object paramObject) {
    this.threadValue.set(new ValueWrapper(paramObject));
  }
  
  static class ValueWrapper {
    Object value;
    
    public ValueWrapper(Object param1Object) {
      this.value = param1Object;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\ThreadLocalSelectArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */