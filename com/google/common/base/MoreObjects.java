package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class MoreObjects {
  public static ToStringHelper a(Class<?> paramClass) {
    return new ToStringHelper(paramClass.getSimpleName());
  }
  
  public static ToStringHelper a(Object paramObject) {
    return new ToStringHelper(paramObject.getClass().getSimpleName());
  }
  
  public static <T> T a(@NullableDecl T paramT1, @NullableDecl T paramT2) {
    if (paramT1 != null)
      return paramT1; 
    if (paramT2 != null)
      return paramT2; 
    throw new NullPointerException("Both parameters are null");
  }
  
  public static final class ToStringHelper {
    private final String a;
    
    private final ValueHolder b = new ValueHolder();
    
    private ValueHolder c = this.b;
    
    private boolean d = false;
    
    private ToStringHelper(String param1String) {
      this.a = Preconditions.<String>a(param1String);
    }
    
    private ValueHolder b() {
      ValueHolder valueHolder = new ValueHolder();
      this.c.c = valueHolder;
      this.c = valueHolder;
      return valueHolder;
    }
    
    private ToStringHelper b(@NullableDecl Object param1Object) {
      (b()).b = param1Object;
      return this;
    }
    
    private ToStringHelper b(String param1String, @NullableDecl Object param1Object) {
      ValueHolder valueHolder = b();
      valueHolder.b = param1Object;
      valueHolder.a = Preconditions.<String>a(param1String);
      return this;
    }
    
    public ToStringHelper a() {
      this.d = true;
      return this;
    }
    
    public ToStringHelper a(@NullableDecl Object param1Object) {
      return b(param1Object);
    }
    
    public ToStringHelper a(String param1String, double param1Double) {
      return b(param1String, String.valueOf(param1Double));
    }
    
    public ToStringHelper a(String param1String, int param1Int) {
      return b(param1String, String.valueOf(param1Int));
    }
    
    public ToStringHelper a(String param1String, long param1Long) {
      return b(param1String, String.valueOf(param1Long));
    }
    
    public ToStringHelper a(String param1String, @NullableDecl Object param1Object) {
      return b(param1String, param1Object);
    }
    
    public ToStringHelper a(String param1String, boolean param1Boolean) {
      return b(param1String, String.valueOf(param1Boolean));
    }
    
    public String toString() {
      // Byte code:
      //   0: aload_0
      //   1: getfield d : Z
      //   4: istore_1
      //   5: new java/lang/StringBuilder
      //   8: dup
      //   9: bipush #32
      //   11: invokespecial <init> : (I)V
      //   14: astore #5
      //   16: aload #5
      //   18: aload_0
      //   19: getfield a : Ljava/lang/String;
      //   22: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   25: pop
      //   26: aload #5
      //   28: bipush #123
      //   30: invokevirtual append : (C)Ljava/lang/StringBuilder;
      //   33: pop
      //   34: aload_0
      //   35: getfield b : Lcom/google/common/base/MoreObjects$ToStringHelper$ValueHolder;
      //   38: getfield c : Lcom/google/common/base/MoreObjects$ToStringHelper$ValueHolder;
      //   41: astore_2
      //   42: ldc ''
      //   44: astore_3
      //   45: aload_2
      //   46: ifnull -> 168
      //   49: aload_2
      //   50: getfield b : Ljava/lang/Object;
      //   53: astore #6
      //   55: iload_1
      //   56: ifeq -> 67
      //   59: aload_3
      //   60: astore #4
      //   62: aload #6
      //   64: ifnull -> 157
      //   67: aload #5
      //   69: aload_3
      //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   73: pop
      //   74: aload_2
      //   75: getfield a : Ljava/lang/String;
      //   78: ifnull -> 99
      //   81: aload #5
      //   83: aload_2
      //   84: getfield a : Ljava/lang/String;
      //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   90: pop
      //   91: aload #5
      //   93: bipush #61
      //   95: invokevirtual append : (C)Ljava/lang/StringBuilder;
      //   98: pop
      //   99: aload #6
      //   101: ifnull -> 145
      //   104: aload #6
      //   106: invokevirtual getClass : ()Ljava/lang/Class;
      //   109: invokevirtual isArray : ()Z
      //   112: ifeq -> 145
      //   115: iconst_1
      //   116: anewarray java/lang/Object
      //   119: dup
      //   120: iconst_0
      //   121: aload #6
      //   123: aastore
      //   124: invokestatic deepToString : ([Ljava/lang/Object;)Ljava/lang/String;
      //   127: astore_3
      //   128: aload #5
      //   130: aload_3
      //   131: iconst_1
      //   132: aload_3
      //   133: invokevirtual length : ()I
      //   136: iconst_1
      //   137: isub
      //   138: invokevirtual append : (Ljava/lang/CharSequence;II)Ljava/lang/StringBuilder;
      //   141: pop
      //   142: goto -> 153
      //   145: aload #5
      //   147: aload #6
      //   149: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   152: pop
      //   153: ldc ', '
      //   155: astore #4
      //   157: aload_2
      //   158: getfield c : Lcom/google/common/base/MoreObjects$ToStringHelper$ValueHolder;
      //   161: astore_2
      //   162: aload #4
      //   164: astore_3
      //   165: goto -> 45
      //   168: aload #5
      //   170: bipush #125
      //   172: invokevirtual append : (C)Ljava/lang/StringBuilder;
      //   175: pop
      //   176: aload #5
      //   178: invokevirtual toString : ()Ljava/lang/String;
      //   181: areturn
    }
    
    static final class ValueHolder {
      @NullableDecl
      String a;
      
      @NullableDecl
      Object b;
      
      @NullableDecl
      ValueHolder c;
      
      private ValueHolder() {}
    }
  }
  
  static final class ValueHolder {
    @NullableDecl
    String a;
    
    @NullableDecl
    Object b;
    
    @NullableDecl
    ValueHolder c;
    
    private ValueHolder() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\MoreObjects.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */