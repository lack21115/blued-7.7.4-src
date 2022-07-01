package org.chromium.ui.resources;

import java.util.List;
import org.chromium.base.AsyncTask;
import org.chromium.base.TraceEvent;

public final class ResourceExtractor$ExtractTask extends AsyncTask {
  private final List mCompletionCallbacks;
  
  private Void doInBackground$10299ca() {
    // Byte code:
    //   0: ldc 'ResourceExtractor.ExtractTask.doInBackground'
    //   2: invokestatic begin : (Ljava/lang/String;)V
    //   5: invokestatic access$000$69f777c0 : ()Ljava/io/File;
    //   8: astore #7
    //   10: invokestatic access$100 : ()[Ljava/lang/String;
    //   13: astore #8
    //   15: invokestatic getInstance : ()Lorg/chromium/base/BuildInfo;
    //   18: getfield extractedFileSuffix : Ljava/lang/String;
    //   21: astore #9
    //   23: aload #7
    //   25: invokevirtual list : ()[Ljava/lang/String;
    //   28: astore #5
    //   30: iconst_0
    //   31: istore_3
    //   32: aload #5
    //   34: ifnull -> 384
    //   37: iconst_1
    //   38: istore_1
    //   39: goto -> 42
    //   42: iload_1
    //   43: istore_2
    //   44: iload_1
    //   45: ifeq -> 121
    //   48: aload #5
    //   50: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   53: astore #6
    //   55: aload #8
    //   57: arraylength
    //   58: istore #4
    //   60: iconst_0
    //   61: istore_2
    //   62: iload_2
    //   63: iload #4
    //   65: if_icmpge -> 389
    //   68: aload #8
    //   70: iload_2
    //   71: aaload
    //   72: astore #10
    //   74: new java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial <init> : ()V
    //   81: astore #11
    //   83: aload #11
    //   85: aload #10
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload #11
    //   93: aload #9
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: iload_1
    //   100: aload #6
    //   102: aload #11
    //   104: invokevirtual toString : ()Ljava/lang/String;
    //   107: invokeinterface contains : (Ljava/lang/Object;)Z
    //   112: iand
    //   113: istore_1
    //   114: iload_2
    //   115: iconst_1
    //   116: iadd
    //   117: istore_2
    //   118: goto -> 62
    //   121: aconst_null
    //   122: astore #6
    //   124: iload_2
    //   125: ifne -> 367
    //   128: aload #5
    //   130: invokestatic access$200$6ac69ee : ([Ljava/lang/String;)V
    //   133: aload #7
    //   135: invokevirtual mkdirs : ()Z
    //   138: pop
    //   139: aload #7
    //   141: invokevirtual exists : ()Z
    //   144: ifeq -> 359
    //   147: invokestatic getApplicationAssets : ()Landroid/content/res/AssetManager;
    //   150: astore #10
    //   152: sipush #16384
    //   155: newarray byte
    //   157: astore #11
    //   159: aload #8
    //   161: arraylength
    //   162: istore_2
    //   163: iload_3
    //   164: istore_1
    //   165: iload_1
    //   166: iload_2
    //   167: if_icmpge -> 367
    //   170: aload #8
    //   172: iload_1
    //   173: aaload
    //   174: astore #5
    //   176: aload #5
    //   178: aload #5
    //   180: bipush #47
    //   182: invokevirtual lastIndexOf : (I)I
    //   185: iconst_1
    //   186: iadd
    //   187: invokevirtual substring : (I)Ljava/lang/String;
    //   190: astore #12
    //   192: new java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial <init> : ()V
    //   199: astore #13
    //   201: aload #13
    //   203: aload #12
    //   205: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload #13
    //   211: aload #9
    //   213: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: new java/io/File
    //   220: dup
    //   221: aload #7
    //   223: aload #13
    //   225: invokevirtual toString : ()Ljava/lang/String;
    //   228: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   231: astore #13
    //   233: ldc 'ExtractResource'
    //   235: invokestatic begin : (Ljava/lang/String;)V
    //   238: aload #10
    //   240: aload #5
    //   242: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   245: astore #12
    //   247: aload #6
    //   249: astore #5
    //   251: aload #12
    //   253: aload #13
    //   255: aload #11
    //   257: invokestatic copyFileStreamAtomicWithBuffer : (Ljava/io/InputStream;Ljava/io/File;[B)V
    //   260: aload #12
    //   262: ifnull -> 270
    //   265: aload #12
    //   267: invokevirtual close : ()V
    //   270: ldc 'ExtractResource'
    //   272: invokestatic end : (Ljava/lang/String;)V
    //   275: iload_1
    //   276: iconst_1
    //   277: iadd
    //   278: istore_1
    //   279: goto -> 165
    //   282: astore #6
    //   284: goto -> 296
    //   287: astore #6
    //   289: aload #6
    //   291: astore #5
    //   293: aload #6
    //   295: athrow
    //   296: aload #12
    //   298: ifnull -> 331
    //   301: aload #5
    //   303: ifnull -> 326
    //   306: aload #12
    //   308: invokevirtual close : ()V
    //   311: goto -> 331
    //   314: astore #7
    //   316: aload #5
    //   318: aload #7
    //   320: invokestatic addSuppressed : (Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   323: goto -> 331
    //   326: aload #12
    //   328: invokevirtual close : ()V
    //   331: aload #6
    //   333: athrow
    //   334: astore #5
    //   336: goto -> 351
    //   339: astore #5
    //   341: new java/lang/RuntimeException
    //   344: dup
    //   345: aload #5
    //   347: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   350: athrow
    //   351: ldc 'ExtractResource'
    //   353: invokestatic end : (Ljava/lang/String;)V
    //   356: aload #5
    //   358: athrow
    //   359: new java/lang/RuntimeException
    //   362: dup
    //   363: invokespecial <init> : ()V
    //   366: athrow
    //   367: ldc 'ResourceExtractor.ExtractTask.doInBackground'
    //   369: invokestatic end : (Ljava/lang/String;)V
    //   372: aconst_null
    //   373: areturn
    //   374: astore #5
    //   376: ldc 'ResourceExtractor.ExtractTask.doInBackground'
    //   378: invokestatic end : (Ljava/lang/String;)V
    //   381: aload #5
    //   383: athrow
    //   384: iconst_0
    //   385: istore_1
    //   386: goto -> 42
    //   389: iload_1
    //   390: istore_2
    //   391: goto -> 121
    // Exception table:
    //   from	to	target	type
    //   5	30	374	finally
    //   48	60	374	finally
    //   74	114	374	finally
    //   128	163	374	finally
    //   176	238	374	finally
    //   238	247	339	java/io/IOException
    //   238	247	334	finally
    //   251	260	287	java/lang/Throwable
    //   251	260	282	finally
    //   265	270	339	java/io/IOException
    //   265	270	334	finally
    //   270	275	374	finally
    //   293	296	282	finally
    //   306	311	314	java/lang/Throwable
    //   306	311	339	java/io/IOException
    //   306	311	334	finally
    //   316	323	339	java/io/IOException
    //   316	323	334	finally
    //   326	331	339	java/io/IOException
    //   326	331	334	finally
    //   331	334	339	java/io/IOException
    //   331	334	334	finally
    //   341	351	334	finally
    //   351	359	374	finally
    //   359	367	374	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\resources\ResourceExtractor$ExtractTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */