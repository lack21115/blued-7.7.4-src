package com.google.android.gms.internal.common;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzp<T> implements zzo<T> {
  private volatile zzo<T> zza;
  
  private volatile boolean zzb;
  
  @NullableDecl
  private T zzc;
  
  zzp(zzo<T> paramzzo) {
    this.zza = zzl.<zzo<T>>zza(paramzzo);
  }
  
  public final String toString() {
    zzo<T> zzo2 = this.zza;
    zzo<T> zzo1 = zzo2;
    if (zzo2 == null) {
      str = String.valueOf(this.zzc);
      StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(str).length() + 25);
      stringBuilder1.append("<supplier that returned ");
      stringBuilder1.append(str);
      stringBuilder1.append(">");
      str = stringBuilder1.toString();
    } 
    String str = String.valueOf(str);
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
    //   4: ifne -> 55
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield zzb : Z
    //   13: ifne -> 45
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
    //   37: aconst_null
    //   38: putfield zza : Lcom/google/android/gms/internal/common/zzo;
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: areturn
    //   45: aload_0
    //   46: monitorexit
    //   47: goto -> 55
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    //   55: aload_0
    //   56: getfield zzc : Ljava/lang/Object;
    //   59: areturn
    // Exception table:
    //   from	to	target	type
    //   9	43	50	finally
    //   45	47	50	finally
    //   51	53	50	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\common\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */