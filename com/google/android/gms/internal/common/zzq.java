package com.google.android.gms.internal.common;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzq<T> implements zzo<T>, Serializable {
  private final zzo<T> zza;
  
  private volatile transient boolean zzb;
  
  @NullableDecl
  private transient T zzc;
  
  zzq(zzo<T> paramzzo) {
    this.zza = zzl.<zzo<T>>zza(paramzzo);
  }
  
  public final String toString() {
    zzo<T> zzo1;
    if (this.zzb) {
      String str1 = String.valueOf(this.zzc);
      StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(str1).length() + 25);
      stringBuilder1.append("<supplier that returned ");
      stringBuilder1.append(str1);
      stringBuilder1.append(">");
      str1 = stringBuilder1.toString();
    } else {
      zzo1 = this.zza;
    } 
    String str = String.valueOf(zzo1);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 19);
    stringBuilder.append("Suppliers.memoize(");
    stringBuilder.append(str);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public final T zza() {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzb : Z
    //   4: ifne -> 50
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield zzb : Z
    //   13: ifne -> 40
    //   16: aload_0
    //   17: getfield zza : Lcom/google/android/gms/internal/common/zzo;
    //   20: invokeinterface zza : ()Ljava/lang/Object;
    //   25: astore_1
    //   26: aload_0
    //   27: aload_1
    //   28: putfield zzc : Ljava/lang/Object;
    //   31: aload_0
    //   32: iconst_1
    //   33: putfield zzb : Z
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: areturn
    //   40: aload_0
    //   41: monitorexit
    //   42: goto -> 50
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    //   50: aload_0
    //   51: getfield zzc : Ljava/lang/Object;
    //   54: areturn
    // Exception table:
    //   from	to	target	type
    //   9	38	45	finally
    //   40	42	45	finally
    //   46	48	45	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\common\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */