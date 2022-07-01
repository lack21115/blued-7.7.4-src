package com.alibaba.mtl.log.sign;

import com.alibaba.mtl.log.e.i;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class SecurityRequestAuth implements IRequestAuth {
  private boolean D;
  
  private String Z;
  
  private Class a;
  
  private Field a;
  
  private Method a;
  
  private Object b;
  
  private String b;
  
  private Field b = null;
  
  private Object c;
  
  private Field c;
  
  private int z;
  
  public SecurityRequestAuth(String paramString1, String paramString2) {
    this.b = null;
    this.c = null;
    this.a = null;
    this.a = null;
    this.b = null;
    this.c = null;
    this.a = null;
    this.z = 1;
    this.D = false;
    this.b = (Field)paramString1;
    this.Z = paramString2;
  }
  
  private void F() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield D : Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aconst_null
    //   15: astore #5
    //   17: ldc 'com.alibaba.wireless.security.open.SecurityGuardManager'
    //   19: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   22: astore_3
    //   23: aload_0
    //   24: aload_3
    //   25: ldc 'getInstance'
    //   27: iconst_1
    //   28: anewarray java/lang/Class
    //   31: dup
    //   32: iconst_0
    //   33: ldc android/content/Context
    //   35: aastore
    //   36: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   39: aconst_null
    //   40: iconst_1
    //   41: anewarray java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: invokestatic getContext : ()Landroid/content/Context;
    //   49: aastore
    //   50: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   53: putfield b : Ljava/lang/Object;
    //   56: aload_0
    //   57: aload_3
    //   58: ldc 'getSecureSignatureComp'
    //   60: iconst_0
    //   61: anewarray java/lang/Class
    //   64: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   67: aload_0
    //   68: getfield b : Ljava/lang/Object;
    //   71: iconst_0
    //   72: anewarray java/lang/Object
    //   75: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   78: putfield c : Ljava/lang/Object;
    //   81: goto -> 102
    //   84: astore #4
    //   86: goto -> 93
    //   89: astore #4
    //   91: aconst_null
    //   92: astore_3
    //   93: ldc 'SecurityRequestAuth'
    //   95: ldc 'initSecurityCheck'
    //   97: aload #4
    //   99: invokestatic a : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   102: aload_3
    //   103: ifnull -> 276
    //   106: aload_0
    //   107: ldc 'com.alibaba.wireless.security.open.SecurityGuardParamContext'
    //   109: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   112: putfield a : Ljava/lang/Class;
    //   115: aload_0
    //   116: aload_0
    //   117: getfield a : Ljava/lang/Class;
    //   120: ldc 'appKey'
    //   122: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   125: putfield a : Ljava/lang/reflect/Field;
    //   128: aload_0
    //   129: aload_0
    //   130: getfield a : Ljava/lang/Class;
    //   133: ldc 'paramMap'
    //   135: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   138: putfield b : Ljava/lang/reflect/Field;
    //   141: aload_0
    //   142: aload_0
    //   143: getfield a : Ljava/lang/Class;
    //   146: ldc 'requestType'
    //   148: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   151: putfield c : Ljava/lang/reflect/Field;
    //   154: aload_3
    //   155: ldc 'isOpen'
    //   157: iconst_0
    //   158: anewarray java/lang/Class
    //   161: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   164: astore_3
    //   165: goto -> 179
    //   168: astore_3
    //   169: ldc 'SecurityRequestAuth'
    //   171: ldc 'initSecurityCheck'
    //   173: aload_3
    //   174: invokestatic a : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   177: aconst_null
    //   178: astore_3
    //   179: aload_3
    //   180: ifnull -> 205
    //   183: aload_3
    //   184: aload_0
    //   185: getfield b : Ljava/lang/Object;
    //   188: iconst_0
    //   189: anewarray java/lang/Object
    //   192: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   195: checkcast java/lang/Boolean
    //   198: invokevirtual booleanValue : ()Z
    //   201: istore_2
    //   202: goto -> 300
    //   205: ldc 'com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent'
    //   207: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   210: astore_3
    //   211: goto -> 289
    //   214: astore_3
    //   215: ldc 'SecurityRequestAuth'
    //   217: ldc 'initSecurityCheck'
    //   219: aload_3
    //   220: invokestatic a : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   223: aload #5
    //   225: astore_3
    //   226: goto -> 289
    //   229: aload_0
    //   230: iload_1
    //   231: putfield z : I
    //   234: aload_0
    //   235: ldc 'com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent'
    //   237: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   240: ldc 'signRequest'
    //   242: iconst_2
    //   243: anewarray java/lang/Class
    //   246: dup
    //   247: iconst_0
    //   248: aload_0
    //   249: getfield a : Ljava/lang/Class;
    //   252: aastore
    //   253: dup
    //   254: iconst_1
    //   255: ldc java/lang/String
    //   257: aastore
    //   258: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   261: putfield a : Ljava/lang/reflect/Method;
    //   264: goto -> 276
    //   267: astore_3
    //   268: ldc 'SecurityRequestAuth'
    //   270: ldc 'initSecurityCheck'
    //   272: aload_3
    //   273: invokestatic a : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   276: aload_0
    //   277: iconst_1
    //   278: putfield D : Z
    //   281: aload_0
    //   282: monitorexit
    //   283: return
    //   284: astore_3
    //   285: aload_0
    //   286: monitorexit
    //   287: aload_3
    //   288: athrow
    //   289: aload_3
    //   290: ifnonnull -> 298
    //   293: iconst_1
    //   294: istore_2
    //   295: goto -> 300
    //   298: iconst_0
    //   299: istore_2
    //   300: iload_2
    //   301: ifeq -> 309
    //   304: iconst_1
    //   305: istore_1
    //   306: goto -> 229
    //   309: bipush #12
    //   311: istore_1
    //   312: goto -> 229
    // Exception table:
    //   from	to	target	type
    //   2	7	284	finally
    //   17	23	89	finally
    //   23	81	84	finally
    //   93	102	284	finally
    //   106	154	267	finally
    //   154	165	168	finally
    //   169	177	267	finally
    //   183	202	267	finally
    //   205	211	214	finally
    //   215	223	267	finally
    //   229	264	267	finally
    //   268	276	284	finally
    //   276	281	284	finally
  }
  
  public String getAppkey() {
    return (String)this.b;
  }
  
  public String getSign(String paramString) {
    if (!this.D)
      F(); 
    if (this.b == null) {
      i.a("SecurityRequestAuth", new Object[] { "There is no appkey,please check it!" });
      return null;
    } 
    if (paramString == null)
      return null; 
    if (this.b != null) {
      Method method = this.a;
      if (method != null && this.a != null && this.b != null && this.c != null && this.a != null && this.c != null)
        try {
          method = method.newInstance();
          this.a.set(method, this.b);
          ((Map<String, String>)this.b.get(method)).put("INPUT", paramString);
          this.c.set(method, Integer.valueOf(this.z));
          return (String)this.a.invoke(this.c, new Object[] { method, this.Z });
        } catch (Exception exception) {
          exception.printStackTrace();
        }  
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\sign\SecurityRequestAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */