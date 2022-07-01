package com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class a extends BroadcastReceiver {
  public void onReceive(Context paramContext, Intent paramIntent) {
    // Byte code:
    //   0: iconst_1
    //   1: istore #4
    //   3: aload_1
    //   4: ifnull -> 11
    //   7: aload_2
    //   8: ifnonnull -> 12
    //   11: return
    //   12: aload_2
    //   13: ldc 'openIdNotifyFlag'
    //   15: iconst_0
    //   16: invokevirtual getIntExtra : (Ljava/lang/String;I)I
    //   19: istore_3
    //   20: new java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial <init> : ()V
    //   27: ldc 'shouldUpdateId, notifyFlag : '
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_3
    //   33: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   36: invokevirtual toString : ()Ljava/lang/String;
    //   39: invokestatic b : (Ljava/lang/String;)V
    //   42: iload_3
    //   43: iconst_1
    //   44: if_icmpne -> 92
    //   47: aload_2
    //   48: ldc 'openIdPackage'
    //   50: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   53: aload_1
    //   54: invokevirtual getPackageName : ()Ljava/lang/String;
    //   57: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   60: ifeq -> 128
    //   63: iload #4
    //   65: ifeq -> 11
    //   68: aload_2
    //   69: ldc 'openIdType'
    //   71: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   74: astore_1
    //   75: invokestatic a : ()Lcom/meizu/flyme/openidsdk/b;
    //   78: aload_1
    //   79: invokevirtual a : (Ljava/lang/String;)Lcom/meizu/flyme/openidsdk/OpenId;
    //   82: astore_1
    //   83: aload_1
    //   84: ifnull -> 11
    //   87: aload_1
    //   88: invokevirtual b : ()V
    //   91: return
    //   92: iload_3
    //   93: iconst_2
    //   94: if_icmpne -> 124
    //   97: aload_2
    //   98: ldc 'openIdPackageList'
    //   100: invokevirtual getStringArrayListExtra : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   103: astore #5
    //   105: aload #5
    //   107: ifnull -> 128
    //   110: aload #5
    //   112: aload_1
    //   113: invokevirtual getPackageName : ()Ljava/lang/String;
    //   116: invokevirtual contains : (Ljava/lang/Object;)Z
    //   119: istore #4
    //   121: goto -> 63
    //   124: iload_3
    //   125: ifeq -> 63
    //   128: iconst_0
    //   129: istore #4
    //   131: goto -> 63
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\meizu\flyme\openidsdk\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */