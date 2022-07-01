package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.ConnectionResult;

public final class zzn extends zze {
  private IBinder zzgfo;
  
  public zzn(zzd paramzzd, int paramInt, IBinder paramIBinder, Bundle paramBundle) {
    super(paramzzd, paramInt, paramBundle);
    this.zzgfo = paramIBinder;
  }
  
  protected final boolean zzama() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield zzgfo : Landroid/os/IBinder;
    //   6: invokeinterface getInterfaceDescriptor : ()Ljava/lang/String;
    //   11: astore_3
    //   12: aload_0
    //   13: getfield zzgfk : Lcom/google/android/gms/common/internal/zzd;
    //   16: invokevirtual zzhn : ()Ljava/lang/String;
    //   19: aload_3
    //   20: invokevirtual equals : (Ljava/lang/Object;)Z
    //   23: ifne -> 107
    //   26: aload_0
    //   27: getfield zzgfk : Lcom/google/android/gms/common/internal/zzd;
    //   30: invokevirtual zzhn : ()Ljava/lang/String;
    //   33: astore #4
    //   35: new java/lang/StringBuilder
    //   38: dup
    //   39: aload #4
    //   41: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   44: invokevirtual length : ()I
    //   47: bipush #34
    //   49: iadd
    //   50: aload_3
    //   51: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   54: invokevirtual length : ()I
    //   57: iadd
    //   58: invokespecial <init> : (I)V
    //   61: astore #5
    //   63: aload #5
    //   65: ldc 'service descriptor mismatch: '
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload #5
    //   73: aload #4
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload #5
    //   81: ldc ' vs. '
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload #5
    //   89: aload_3
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: ldc 'GmsClient'
    //   96: aload #5
    //   98: invokevirtual toString : ()Ljava/lang/String;
    //   101: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   104: pop
    //   105: iconst_0
    //   106: ireturn
    //   107: aload_0
    //   108: getfield zzgfk : Lcom/google/android/gms/common/internal/zzd;
    //   111: aload_0
    //   112: getfield zzgfo : Landroid/os/IBinder;
    //   115: invokevirtual zzd : (Landroid/os/IBinder;)Landroid/os/IInterface;
    //   118: astore_3
    //   119: iload_2
    //   120: istore_1
    //   121: aload_3
    //   122: ifnull -> 187
    //   125: aload_0
    //   126: getfield zzgfk : Lcom/google/android/gms/common/internal/zzd;
    //   129: iconst_2
    //   130: iconst_4
    //   131: aload_3
    //   132: invokestatic zza : (Lcom/google/android/gms/common/internal/zzd;IILandroid/os/IInterface;)Z
    //   135: ifne -> 153
    //   138: iload_2
    //   139: istore_1
    //   140: aload_0
    //   141: getfield zzgfk : Lcom/google/android/gms/common/internal/zzd;
    //   144: iconst_3
    //   145: iconst_4
    //   146: aload_3
    //   147: invokestatic zza : (Lcom/google/android/gms/common/internal/zzd;IILandroid/os/IInterface;)Z
    //   150: ifeq -> 187
    //   153: aload_0
    //   154: getfield zzgfk : Lcom/google/android/gms/common/internal/zzd;
    //   157: aconst_null
    //   158: invokestatic zza : (Lcom/google/android/gms/common/internal/zzd;Lcom/google/android/gms/common/ConnectionResult;)Lcom/google/android/gms/common/ConnectionResult;
    //   161: pop
    //   162: aload_0
    //   163: getfield zzgfk : Lcom/google/android/gms/common/internal/zzd;
    //   166: invokestatic zze : (Lcom/google/android/gms/common/internal/zzd;)Lcom/google/android/gms/common/internal/zzf;
    //   169: ifnull -> 185
    //   172: aload_0
    //   173: getfield zzgfk : Lcom/google/android/gms/common/internal/zzd;
    //   176: invokestatic zze : (Lcom/google/android/gms/common/internal/zzd;)Lcom/google/android/gms/common/internal/zzf;
    //   179: aconst_null
    //   180: invokeinterface onConnected : (Landroid/os/Bundle;)V
    //   185: iconst_1
    //   186: istore_1
    //   187: iload_1
    //   188: ireturn
    //   189: astore_3
    //   190: ldc 'GmsClient'
    //   192: ldc 'service probably died'
    //   194: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   197: pop
    //   198: iconst_0
    //   199: ireturn
    // Exception table:
    //   from	to	target	type
    //   2	12	189	android/os/RemoteException
  }
  
  protected final void zzj(ConnectionResult paramConnectionResult) {
    if (zzd.zzg(this.zzgfk) != null)
      zzd.zzg(this.zzgfk).onConnectionFailed(paramConnectionResult); 
    this.zzgfk.onConnectionFailed(paramConnectionResult);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */