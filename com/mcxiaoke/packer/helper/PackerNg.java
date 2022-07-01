package com.mcxiaoke.packer.helper;

import android.content.Context;
import java.io.IOException;

public final class PackerNg {
  public static String a(Context paramContext) {
    try {
      return b(paramContext);
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public static String b(Context paramContext) throws IOException {
    // Byte code:
    //   0: ldc com/mcxiaoke/packer/helper/PackerNg
    //   2: monitorenter
    //   3: new java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   11: getfield sourceDir : Ljava/lang/String;
    //   14: invokespecial <init> : (Ljava/lang/String;)V
    //   17: invokestatic a : (Ljava/io/File;)Ljava/lang/String;
    //   20: astore_0
    //   21: ldc com/mcxiaoke/packer/helper/PackerNg
    //   23: monitorexit
    //   24: aload_0
    //   25: areturn
    //   26: astore_0
    //   27: ldc com/mcxiaoke/packer/helper/PackerNg
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	26	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\mcxiaoke\packer\helper\PackerNg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */