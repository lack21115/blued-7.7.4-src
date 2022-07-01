package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class GeneralRange<T> implements Serializable {
  private final Comparator<? super T> a;
  
  private final boolean b;
  
  @NullableDecl
  private final T c;
  
  private final BoundType d;
  
  private final boolean e;
  
  @NullableDecl
  private final T f;
  
  private final BoundType g;
  
  private GeneralRange(Comparator<? super T> paramComparator, boolean paramBoolean1, @NullableDecl T paramT1, BoundType paramBoundType1, boolean paramBoolean2, @NullableDecl T paramT2, BoundType paramBoundType2) {
    this.a = (Comparator<? super T>)Preconditions.a(paramComparator);
    this.b = paramBoolean1;
    this.e = paramBoolean2;
    this.c = paramT1;
    this.d = (BoundType)Preconditions.a(paramBoundType1);
    this.f = paramT2;
    this.g = (BoundType)Preconditions.a(paramBoundType2);
    if (paramBoolean1)
      paramComparator.compare(paramT1, paramT1); 
    if (paramBoolean2)
      paramComparator.compare(paramT2, paramT2); 
    if (paramBoolean1 && paramBoolean2) {
      int i = paramComparator.compare(paramT1, paramT2);
      byte b = 1;
      if (i <= 0) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      } 
      Preconditions.a(paramBoolean1, "lowerEndpoint (%s) > upperEndpoint (%s)", paramT1, paramT2);
      if (i == 0) {
        if (paramBoundType1 != BoundType.a) {
          i = 1;
        } else {
          i = 0;
        } 
        if (paramBoundType2 == BoundType.a)
          b = 0; 
        Preconditions.a(i | b);
      } 
    } 
  }
  
  static <T> GeneralRange<T> a(Comparator<? super T> paramComparator, @NullableDecl T paramT, BoundType paramBoundType) {
    return new GeneralRange<T>(paramComparator, true, paramT, paramBoundType, false, null, BoundType.a);
  }
  
  static <T> GeneralRange<T> b(Comparator<? super T> paramComparator, @NullableDecl T paramT, BoundType paramBoundType) {
    return new GeneralRange<T>(paramComparator, false, null, BoundType.a, true, paramT, paramBoundType);
  }
  
  GeneralRange<T> a(GeneralRange<T> paramGeneralRange) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic a : (Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: getfield a : Ljava/util/Comparator;
    //   9: aload_1
    //   10: getfield a : Ljava/util/Comparator;
    //   13: invokeinterface equals : (Ljava/lang/Object;)Z
    //   18: invokestatic a : (Z)V
    //   21: aload_0
    //   22: getfield b : Z
    //   25: istore #4
    //   27: aload_0
    //   28: invokevirtual d : ()Ljava/lang/Object;
    //   31: astore #6
    //   33: aload_0
    //   34: invokevirtual e : ()Lcom/google/common/collect/BoundType;
    //   37: astore #9
    //   39: aload_0
    //   40: invokevirtual b : ()Z
    //   43: ifne -> 66
    //   46: aload_1
    //   47: getfield b : Z
    //   50: istore_3
    //   51: aload_1
    //   52: invokevirtual d : ()Ljava/lang/Object;
    //   55: astore #7
    //   57: aload_1
    //   58: invokevirtual e : ()Lcom/google/common/collect/BoundType;
    //   61: astore #8
    //   63: goto -> 157
    //   66: iload #4
    //   68: istore_3
    //   69: aload #6
    //   71: astore #7
    //   73: aload #9
    //   75: astore #8
    //   77: aload_1
    //   78: invokevirtual b : ()Z
    //   81: ifeq -> 157
    //   84: aload_0
    //   85: getfield a : Ljava/util/Comparator;
    //   88: aload_0
    //   89: invokevirtual d : ()Ljava/lang/Object;
    //   92: aload_1
    //   93: invokevirtual d : ()Ljava/lang/Object;
    //   96: invokeinterface compare : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   101: istore_2
    //   102: iload_2
    //   103: iflt -> 142
    //   106: iload #4
    //   108: istore_3
    //   109: aload #6
    //   111: astore #7
    //   113: aload #9
    //   115: astore #8
    //   117: iload_2
    //   118: ifne -> 157
    //   121: iload #4
    //   123: istore_3
    //   124: aload #6
    //   126: astore #7
    //   128: aload #9
    //   130: astore #8
    //   132: aload_1
    //   133: invokevirtual e : ()Lcom/google/common/collect/BoundType;
    //   136: getstatic com/google/common/collect/BoundType.a : Lcom/google/common/collect/BoundType;
    //   139: if_acmpne -> 157
    //   142: aload_1
    //   143: invokevirtual d : ()Ljava/lang/Object;
    //   146: astore #7
    //   148: aload_1
    //   149: invokevirtual e : ()Lcom/google/common/collect/BoundType;
    //   152: astore #8
    //   154: iload #4
    //   156: istore_3
    //   157: aload_0
    //   158: getfield e : Z
    //   161: istore #5
    //   163: aload_0
    //   164: invokevirtual f : ()Ljava/lang/Object;
    //   167: astore #10
    //   169: aload_0
    //   170: invokevirtual g : ()Lcom/google/common/collect/BoundType;
    //   173: astore #11
    //   175: aload_0
    //   176: invokevirtual c : ()Z
    //   179: ifne -> 203
    //   182: aload_1
    //   183: getfield e : Z
    //   186: istore #4
    //   188: aload_1
    //   189: invokevirtual f : ()Ljava/lang/Object;
    //   192: astore #6
    //   194: aload_1
    //   195: invokevirtual g : ()Lcom/google/common/collect/BoundType;
    //   198: astore #9
    //   200: goto -> 298
    //   203: iload #5
    //   205: istore #4
    //   207: aload #10
    //   209: astore #6
    //   211: aload #11
    //   213: astore #9
    //   215: aload_1
    //   216: invokevirtual c : ()Z
    //   219: ifeq -> 298
    //   222: aload_0
    //   223: getfield a : Ljava/util/Comparator;
    //   226: aload_0
    //   227: invokevirtual f : ()Ljava/lang/Object;
    //   230: aload_1
    //   231: invokevirtual f : ()Ljava/lang/Object;
    //   234: invokeinterface compare : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   239: istore_2
    //   240: iload_2
    //   241: ifgt -> 282
    //   244: iload #5
    //   246: istore #4
    //   248: aload #10
    //   250: astore #6
    //   252: aload #11
    //   254: astore #9
    //   256: iload_2
    //   257: ifne -> 298
    //   260: iload #5
    //   262: istore #4
    //   264: aload #10
    //   266: astore #6
    //   268: aload #11
    //   270: astore #9
    //   272: aload_1
    //   273: invokevirtual g : ()Lcom/google/common/collect/BoundType;
    //   276: getstatic com/google/common/collect/BoundType.a : Lcom/google/common/collect/BoundType;
    //   279: if_acmpne -> 298
    //   282: aload_1
    //   283: invokevirtual f : ()Ljava/lang/Object;
    //   286: astore #6
    //   288: aload_1
    //   289: invokevirtual g : ()Lcom/google/common/collect/BoundType;
    //   292: astore #9
    //   294: iload #5
    //   296: istore #4
    //   298: iload_3
    //   299: ifeq -> 365
    //   302: iload #4
    //   304: ifeq -> 365
    //   307: aload_0
    //   308: getfield a : Ljava/util/Comparator;
    //   311: aload #7
    //   313: aload #6
    //   315: invokeinterface compare : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   320: istore_2
    //   321: iload_2
    //   322: ifgt -> 345
    //   325: iload_2
    //   326: ifne -> 365
    //   329: aload #8
    //   331: getstatic com/google/common/collect/BoundType.a : Lcom/google/common/collect/BoundType;
    //   334: if_acmpne -> 365
    //   337: aload #9
    //   339: getstatic com/google/common/collect/BoundType.a : Lcom/google/common/collect/BoundType;
    //   342: if_acmpne -> 365
    //   345: getstatic com/google/common/collect/BoundType.a : Lcom/google/common/collect/BoundType;
    //   348: astore_1
    //   349: getstatic com/google/common/collect/BoundType.b : Lcom/google/common/collect/BoundType;
    //   352: astore #7
    //   354: aload #6
    //   356: astore #8
    //   358: aload #7
    //   360: astore #9
    //   362: goto -> 372
    //   365: aload #8
    //   367: astore_1
    //   368: aload #7
    //   370: astore #8
    //   372: new com/google/common/collect/GeneralRange
    //   375: dup
    //   376: aload_0
    //   377: getfield a : Ljava/util/Comparator;
    //   380: iload_3
    //   381: aload #8
    //   383: aload_1
    //   384: iload #4
    //   386: aload #6
    //   388: aload #9
    //   390: invokespecial <init> : (Ljava/util/Comparator;ZLjava/lang/Object;Lcom/google/common/collect/BoundType;ZLjava/lang/Object;Lcom/google/common/collect/BoundType;)V
    //   393: areturn
  }
  
  Comparator<? super T> a() {
    return this.a;
  }
  
  boolean a(@NullableDecl T paramT) {
    boolean bool;
    if (!b())
      return false; 
    T t = d();
    int i = this.a.compare(paramT, t);
    byte b = 1;
    if (i < 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    } 
    if (e() != BoundType.a)
      b = 0; 
    return i & b | bool;
  }
  
  boolean b() {
    return this.b;
  }
  
  boolean b(@NullableDecl T paramT) {
    boolean bool;
    if (!c())
      return false; 
    T t = f();
    int i = this.a.compare(paramT, t);
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    } 
    if (g() != BoundType.a)
      b = 0; 
    return i & b | bool;
  }
  
  boolean c() {
    return this.e;
  }
  
  boolean c(@NullableDecl T paramT) {
    return (!a(paramT) && !b(paramT));
  }
  
  T d() {
    return this.c;
  }
  
  BoundType e() {
    return this.d;
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    boolean bool = paramObject instanceof GeneralRange;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.a.equals(((GeneralRange)paramObject).a)) {
        bool1 = bool2;
        if (this.b == ((GeneralRange)paramObject).b) {
          bool1 = bool2;
          if (this.e == ((GeneralRange)paramObject).e) {
            bool1 = bool2;
            if (e().equals(paramObject.e())) {
              bool1 = bool2;
              if (g().equals(paramObject.g())) {
                bool1 = bool2;
                if (Objects.a(d(), paramObject.d())) {
                  bool1 = bool2;
                  if (Objects.a(f(), paramObject.f()))
                    bool1 = true; 
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  T f() {
    return this.f;
  }
  
  BoundType g() {
    return this.g;
  }
  
  public int hashCode() {
    return Objects.a(new Object[] { this.a, d(), e(), f(), g() });
  }
  
  public String toString() {
    byte b;
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a);
    stringBuilder.append(":");
    if (this.d == BoundType.b) {
      b = 91;
    } else {
      b = 40;
    } 
    stringBuilder.append(b);
    if (this.b) {
      T t = this.c;
    } else {
      str = "-∞";
    } 
    stringBuilder.append(str);
    stringBuilder.append(',');
    if (this.e) {
      T t = this.f;
    } else {
      str = "∞";
    } 
    stringBuilder.append(str);
    if (this.g == BoundType.b) {
      b = 93;
    } else {
      b = 41;
    } 
    stringBuilder.append(b);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\GeneralRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */