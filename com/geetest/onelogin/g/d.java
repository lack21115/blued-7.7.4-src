package com.geetest.onelogin.g;

public class d {
  public static c[] a;
  
  public static c b = new c("中国移动提供认证服务", "中国移动认证服务条款", "http://wap.cmpassport.com/resources/html/contract.html");
  
  public static c c = new c("认证服务由联通统一认证提供", "联通统一认证服务条款", "https://opencloud.wostore.cn/authz/resource/html/disclaimer.html?fromsdk=true");
  
  public static c d = new c("天翼账号提供认证服务", "天翼账号服务与隐私协议", "https://e.189.cn/sdk/agreement/detail.do?hidetop=true");
  
  static {
    a = new c[] { b, c, d };
  }
  
  public static c a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual hashCode : ()I
    //   4: istore_1
    //   5: iload_1
    //   6: sipush #2154
    //   9: if_icmpeq -> 57
    //   12: iload_1
    //   13: sipush #2161
    //   16: if_icmpeq -> 43
    //   19: iload_1
    //   20: sipush #2162
    //   23: if_icmpeq -> 29
    //   26: goto -> 71
    //   29: aload_0
    //   30: ldc 'CU'
    //   32: invokevirtual equals : (Ljava/lang/Object;)Z
    //   35: ifeq -> 71
    //   38: iconst_1
    //   39: istore_1
    //   40: goto -> 73
    //   43: aload_0
    //   44: ldc 'CT'
    //   46: invokevirtual equals : (Ljava/lang/Object;)Z
    //   49: ifeq -> 71
    //   52: iconst_2
    //   53: istore_1
    //   54: goto -> 73
    //   57: aload_0
    //   58: ldc 'CM'
    //   60: invokevirtual equals : (Ljava/lang/Object;)Z
    //   63: ifeq -> 71
    //   66: iconst_0
    //   67: istore_1
    //   68: goto -> 73
    //   71: iconst_m1
    //   72: istore_1
    //   73: iload_1
    //   74: ifeq -> 97
    //   77: iload_1
    //   78: iconst_1
    //   79: if_icmpeq -> 93
    //   82: iload_1
    //   83: iconst_2
    //   84: if_icmpeq -> 89
    //   87: aconst_null
    //   88: areturn
    //   89: getstatic com/geetest/onelogin/g/d.d : Lcom/geetest/onelogin/g/c;
    //   92: areturn
    //   93: getstatic com/geetest/onelogin/g/d.c : Lcom/geetest/onelogin/g/c;
    //   96: areturn
    //   97: getstatic com/geetest/onelogin/g/d.b : Lcom/geetest/onelogin/g/c;
    //   100: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */