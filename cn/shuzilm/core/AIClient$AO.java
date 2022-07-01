package cn.shuzilm.core;

import android.content.Context;
import android.net.Uri;

class AIClient$AO {
  private int[] b = new int[] { 
      246, 251, 243, 253, 157, 214, 251, 192, 215, 219, 
      212, 219, 198, 220, 215, 214, 251, 157, 192, 215, 
      214, 219, 196, 221, 192, 226, 214, 251, 156, 193, 
      223, 196, 156, 221, 196, 219, 196, 156, 223, 221, 
      209, 157, 157, 136, 198, 220, 215, 198, 220, 221, 
      209, 0 };
  
  private int[] c = new int[] { 231, 234, 226, 236, 0 };
  
  private Context d;
  
  private int[] e = new int[] { 194, 207, 199, 201, 242, 227, 225, 0 };
  
  private AIClient$AO(AIClient paramAIClient, Context paramContext) {
    this.d = paramContext;
  }
  
  private String a() {
    Exception exception;
    String str = null;
    try {
      Uri uri = Uri.parse(AIClient.a(this.a, AIClient.b()));
    } finally {
      exception = null;
    } 
    if (exception == null)
      return null; 
    if (exception.getInt("code", -1) == 0)
      str = exception.getString("id"); 
    return str;
  }
  
  private String a(int paramInt) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #7
    //   3: aconst_null
    //   4: astore #5
    //   6: aconst_null
    //   7: astore #6
    //   9: iload_1
    //   10: iconst_4
    //   11: if_icmpne -> 68
    //   14: aload #5
    //   16: astore #4
    //   18: getstatic android/os/Build$VERSION.SDK_INT : I
    //   21: bipush #27
    //   23: if_icmple -> 204
    //   26: aload #5
    //   28: astore #4
    //   30: aload_0
    //   31: getfield a : Lcn/shuzilm/core/AIClient;
    //   34: aload_0
    //   35: getfield b : [I
    //   38: invokestatic a : (Lcn/shuzilm/core/AIClient;[I)Ljava/lang/String;
    //   41: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   44: astore_2
    //   45: aload #5
    //   47: astore #4
    //   49: aload_0
    //   50: getfield d : Landroid/content/Context;
    //   53: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   56: aload_2
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore_3
    //   65: goto -> 131
    //   68: iload_1
    //   69: iconst_5
    //   70: if_icmpne -> 204
    //   73: aload #5
    //   75: astore #4
    //   77: aload_0
    //   78: getfield a : Lcn/shuzilm/core/AIClient;
    //   81: invokestatic a : ()[I
    //   84: invokestatic a : (Lcn/shuzilm/core/AIClient;[I)Ljava/lang/String;
    //   87: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   90: astore_2
    //   91: aload #5
    //   93: astore #4
    //   95: aload_0
    //   96: getfield d : Landroid/content/Context;
    //   99: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   102: aload_2
    //   103: aconst_null
    //   104: aconst_null
    //   105: iconst_1
    //   106: anewarray java/lang/String
    //   109: dup
    //   110: iconst_0
    //   111: aload_0
    //   112: getfield a : Lcn/shuzilm/core/AIClient;
    //   115: aload_0
    //   116: getfield c : [I
    //   119: invokestatic a : (Lcn/shuzilm/core/AIClient;[I)Ljava/lang/String;
    //   122: aastore
    //   123: aconst_null
    //   124: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   127: astore_3
    //   128: goto -> 131
    //   131: aload #7
    //   133: astore_2
    //   134: aload_3
    //   135: ifnull -> 198
    //   138: aload #7
    //   140: astore_2
    //   141: aload #5
    //   143: astore #4
    //   145: aload_3
    //   146: invokeinterface isClosed : ()Z
    //   151: ifne -> 198
    //   154: aload #6
    //   156: astore_2
    //   157: aload #5
    //   159: astore #4
    //   161: aload_3
    //   162: invokeinterface moveToNext : ()Z
    //   167: ifeq -> 189
    //   170: aload #5
    //   172: astore #4
    //   174: aload_3
    //   175: aload_3
    //   176: ldc 'value'
    //   178: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   183: invokeinterface getString : (I)Ljava/lang/String;
    //   188: astore_2
    //   189: aload_2
    //   190: astore #4
    //   192: aload_3
    //   193: invokeinterface close : ()V
    //   198: aload_2
    //   199: areturn
    //   200: astore_2
    //   201: aload #4
    //   203: areturn
    //   204: aconst_null
    //   205: astore_3
    //   206: goto -> 131
    // Exception table:
    //   from	to	target	type
    //   18	26	200	finally
    //   30	45	200	finally
    //   49	65	200	finally
    //   77	91	200	finally
    //   95	128	200	finally
    //   145	154	200	finally
    //   161	170	200	finally
    //   174	189	200	finally
    //   192	198	200	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\AIClient$AO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */