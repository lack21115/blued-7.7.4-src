package com.airbnb.lottie.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyPath {
  private final List<String> a;
  
  private KeyPathElement b;
  
  private KeyPath(KeyPath paramKeyPath) {
    this.a = new ArrayList<String>(paramKeyPath.a);
    this.b = paramKeyPath.b;
  }
  
  public KeyPath(String... paramVarArgs) {
    this.a = Arrays.asList(paramVarArgs);
  }
  
  private boolean b() {
    List<String> list = this.a;
    return ((String)list.get(list.size() - 1)).equals("**");
  }
  
  private boolean b(String paramString) {
    return "__container".equals(paramString);
  }
  
  public KeyPath a(KeyPathElement paramKeyPathElement) {
    KeyPath keyPath = new KeyPath(this);
    keyPath.b = paramKeyPathElement;
    return keyPath;
  }
  
  public KeyPath a(String paramString) {
    KeyPath keyPath = new KeyPath(this);
    keyPath.a.add(paramString);
    return keyPath;
  }
  
  public KeyPathElement a() {
    return this.b;
  }
  
  public boolean a(String paramString, int paramInt) {
    return b(paramString) ? true : ((paramInt >= this.a.size()) ? false : ((!((String)this.a.get(paramInt)).equals(paramString) && !((String)this.a.get(paramInt)).equals("**")) ? (((String)this.a.get(paramInt)).equals("*")) : true));
  }
  
  public int b(String paramString, int paramInt) {
    return b(paramString) ? 0 : (!((String)this.a.get(paramInt)).equals("**") ? 1 : ((paramInt == this.a.size() - 1) ? 0 : (((String)this.a.get(paramInt + 1)).equals(paramString) ? 2 : 0)));
  }
  
  public boolean c(String paramString, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Ljava/util/List;
    //   4: invokeinterface size : ()I
    //   9: istore_3
    //   10: iconst_0
    //   11: istore #7
    //   13: iconst_0
    //   14: istore #6
    //   16: iload_2
    //   17: iload_3
    //   18: if_icmplt -> 23
    //   21: iconst_0
    //   22: ireturn
    //   23: iload_2
    //   24: aload_0
    //   25: getfield a : Ljava/util/List;
    //   28: invokeinterface size : ()I
    //   33: iconst_1
    //   34: isub
    //   35: if_icmpne -> 43
    //   38: iconst_1
    //   39: istore_3
    //   40: goto -> 45
    //   43: iconst_0
    //   44: istore_3
    //   45: aload_0
    //   46: getfield a : Ljava/util/List;
    //   49: iload_2
    //   50: invokeinterface get : (I)Ljava/lang/Object;
    //   55: checkcast java/lang/String
    //   58: astore #8
    //   60: aload #8
    //   62: ldc '**'
    //   64: invokevirtual equals : (Ljava/lang/Object;)Z
    //   67: ifne -> 150
    //   70: aload #8
    //   72: aload_1
    //   73: invokevirtual equals : (Ljava/lang/Object;)Z
    //   76: ifne -> 98
    //   79: aload #8
    //   81: ldc '*'
    //   83: invokevirtual equals : (Ljava/lang/Object;)Z
    //   86: ifeq -> 92
    //   89: goto -> 98
    //   92: iconst_0
    //   93: istore #4
    //   95: goto -> 101
    //   98: iconst_1
    //   99: istore #4
    //   101: iload_3
    //   102: ifne -> 135
    //   105: iload #6
    //   107: istore #5
    //   109: iload_2
    //   110: aload_0
    //   111: getfield a : Ljava/util/List;
    //   114: invokeinterface size : ()I
    //   119: iconst_2
    //   120: isub
    //   121: if_icmpne -> 147
    //   124: iload #6
    //   126: istore #5
    //   128: aload_0
    //   129: invokespecial b : ()Z
    //   132: ifeq -> 147
    //   135: iload #6
    //   137: istore #5
    //   139: iload #4
    //   141: ifeq -> 147
    //   144: iconst_1
    //   145: istore #5
    //   147: iload #5
    //   149: ireturn
    //   150: iload_3
    //   151: ifne -> 182
    //   154: aload_0
    //   155: getfield a : Ljava/util/List;
    //   158: iload_2
    //   159: iconst_1
    //   160: iadd
    //   161: invokeinterface get : (I)Ljava/lang/Object;
    //   166: checkcast java/lang/String
    //   169: aload_1
    //   170: invokevirtual equals : (Ljava/lang/Object;)Z
    //   173: ifeq -> 182
    //   176: iconst_1
    //   177: istore #4
    //   179: goto -> 185
    //   182: iconst_0
    //   183: istore #4
    //   185: iload #4
    //   187: ifeq -> 241
    //   190: iload_2
    //   191: aload_0
    //   192: getfield a : Ljava/util/List;
    //   195: invokeinterface size : ()I
    //   200: iconst_2
    //   201: isub
    //   202: if_icmpeq -> 235
    //   205: iload #7
    //   207: istore #5
    //   209: iload_2
    //   210: aload_0
    //   211: getfield a : Ljava/util/List;
    //   214: invokeinterface size : ()I
    //   219: iconst_3
    //   220: isub
    //   221: if_icmpne -> 238
    //   224: iload #7
    //   226: istore #5
    //   228: aload_0
    //   229: invokespecial b : ()Z
    //   232: ifeq -> 238
    //   235: iconst_1
    //   236: istore #5
    //   238: iload #5
    //   240: ireturn
    //   241: iload_3
    //   242: ifeq -> 247
    //   245: iconst_1
    //   246: ireturn
    //   247: iload_2
    //   248: iconst_1
    //   249: iadd
    //   250: istore_2
    //   251: iload_2
    //   252: aload_0
    //   253: getfield a : Ljava/util/List;
    //   256: invokeinterface size : ()I
    //   261: iconst_1
    //   262: isub
    //   263: if_icmpge -> 268
    //   266: iconst_0
    //   267: ireturn
    //   268: aload_0
    //   269: getfield a : Ljava/util/List;
    //   272: iload_2
    //   273: invokeinterface get : (I)Ljava/lang/Object;
    //   278: checkcast java/lang/String
    //   281: aload_1
    //   282: invokevirtual equals : (Ljava/lang/Object;)Z
    //   285: ireturn
  }
  
  public boolean d(String paramString, int paramInt) {
    boolean bool1 = "__container".equals(paramString);
    boolean bool = true;
    if (bool1)
      return true; 
    if (paramInt >= this.a.size() - 1) {
      if (((String)this.a.get(paramInt)).equals("**"))
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  public String toString() {
    boolean bool;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("KeyPath{keys=");
    stringBuilder.append(this.a);
    stringBuilder.append(",resolved=");
    if (this.b != null) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\KeyPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */