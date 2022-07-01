package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zzf;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzd {
  public final Context mContext;
  
  final Handler mHandler;
  
  private final Object mLock = new Object();
  
  int zzgen;
  
  long zzgeo;
  
  private long zzgep;
  
  private int zzgeq;
  
  private long zzger;
  
  private zzam zzges;
  
  private final zzag zzget;
  
  private final Object zzgeu = new Object();
  
  private zzay zzgev;
  
  protected zzj zzgew;
  
  private IInterface zzgex;
  
  private final ArrayList zzgey = new ArrayList();
  
  private zzl zzgez;
  
  private int zzgfa = 1;
  
  private final zzf zzgfb;
  
  private final zzg zzgfc;
  
  private final int zzgfd;
  
  private final String zzgfe;
  
  private ConnectionResult zzgff = null;
  
  private boolean zzgfg = false;
  
  protected AtomicInteger zzgfh = new AtomicInteger(0);
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  protected zzd(Context paramContext, Looper paramLooper, zzag paramzzag, zzf paramzzf, int paramInt, zzf paramzzf1, zzg paramzzg, String paramString) {
    this.mContext = (Context)zzbq.checkNotNull(paramContext, "Context must not be null");
    zzbq.checkNotNull(paramLooper, "Looper must not be null");
    this.zzget = (zzag)zzbq.checkNotNull(paramzzag, "Supervisor must not be null");
    zzbq.checkNotNull(paramzzf, "API availability must not be null");
    this.mHandler = new zzh(this, paramLooper);
    this.zzgfd = paramInt;
    this.zzgfb = paramzzf1;
    this.zzgfc = paramzzg;
    this.zzgfe = paramString;
  }
  
  private final void zza(int paramInt, IInterface paramIInterface) {
    boolean bool1;
    boolean bool2;
    boolean bool3 = false;
    if (paramInt == 4) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (paramIInterface != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (bool1 == bool2)
      bool3 = true; 
    zzbq.checkArgument(bool3);
    synchronized (this.mLock) {
      zzag zzag1;
      String str1;
      String str2;
      zzl zzl1;
      this.zzgfa = paramInt;
      this.zzgex = paramIInterface;
      zzb$59481928();
      switch (paramInt) {
        case 4:
          this.zzgep = System.currentTimeMillis();
          break;
        case 2:
        case 3:
          if (this.zzgez != null && this.zzges != null) {
            String str3 = this.zzges.zzghk;
            String str4 = this.zzges.mPackageName;
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str3).length() + 70 + String.valueOf(str4).length());
            stringBuilder.append("Calling connect() while still connected, missing disconnect() for ");
            stringBuilder.append(str3);
            stringBuilder.append(" on ");
            stringBuilder.append(str4);
            Log.e("GmsClient", stringBuilder.toString());
            zzag zzag2 = this.zzget;
            str4 = this.zzges.zzghk;
            String str5 = this.zzges.mPackageName;
            paramInt = this.zzges.zzggv;
            zzl zzl2 = this.zzgez;
            zzalr();
            zzag2.zza$5bbd53b4(str4, str5, paramInt, zzl2);
            this.zzgfh.incrementAndGet();
          } 
          this.zzgez = new zzl(this, this.zzgfh.get());
          this.zzges = new zzam("com.google.android.gms", zzhm());
          zzag1 = this.zzget;
          str1 = this.zzges.zzghk;
          str2 = this.zzges.mPackageName;
          paramInt = this.zzges.zzggv;
          zzl1 = this.zzgez;
          zzalr();
          if (!zzag1.zza$2a82e825(new zzah(str1, str2, paramInt), zzl1)) {
            String str = this.zzges.zzghk;
            str1 = this.zzges.mPackageName;
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str1).length());
            stringBuilder.append("unable to connect to service: ");
            stringBuilder.append(str);
            stringBuilder.append(" on ");
            stringBuilder.append(str1);
            Log.e("GmsClient", stringBuilder.toString());
            zza$4c85f423(16, this.zzgfh.get());
          } 
          break;
        case 1:
          if (this.zzgez != null) {
            zzag1 = this.zzget;
            str1 = zzhm();
            zzl zzl2 = this.zzgez;
            zzalr();
            zzag1.zza$5bbd53b4(str1, "com.google.android.gms", 129, zzl2);
            this.zzgez = null;
          } 
          break;
      } 
      return;
    } 
  }
  
  private final boolean zza(int paramInt1, int paramInt2, IInterface paramIInterface) {
    synchronized (this.mLock) {
      if (this.zzgfa != paramInt1)
        return false; 
      zza(paramInt2, paramIInterface);
      return true;
    } 
  }
  
  private final String zzalr() {
    return (this.zzgfe == null) ? this.mContext.getClass().getName() : this.zzgfe;
  }
  
  private final boolean zzalt() {
    synchronized (this.mLock) {
      if (this.zzgfa == 3)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  private final boolean zzalz() {
    if (this.zzgfg)
      return false; 
    if (TextUtils.isEmpty(zzhn()))
      return false; 
    if (TextUtils.isEmpty(null))
      return false; 
    try {
      Class.forName(zzhn());
      return true;
    } catch (ClassNotFoundException classNotFoundException) {
      return false;
    } 
  }
  
  public void disconnect() {
    this.zzgfh.incrementAndGet();
    synchronized (this.zzgey) {
      int j = this.zzgey.size();
      for (int i = 0; i < j; i++)
        ((zzi)this.zzgey.get(i)).removeListener(); 
      this.zzgey.clear();
      synchronized (this.zzgeu) {
        this.zzgev = null;
        zza(1, (IInterface)null);
        return;
      } 
    } 
  }
  
  public final void dump$ec96877(String paramString, PrintWriter paramPrintWriter) {
    synchronized (this.mLock) {
      int i = this.zzgfa;
      IInterface iInterface = this.zzgex;
      synchronized (this.zzgeu) {
        zzay zzay1 = this.zzgev;
        paramPrintWriter.append(paramString).append("mConnectState=");
        switch (i) {
          default:
            null = "UNKNOWN";
            paramPrintWriter.print((String)null);
            break;
          case 5:
            null = "DISCONNECTING";
            paramPrintWriter.print((String)null);
            break;
          case 4:
            null = "CONNECTED";
            paramPrintWriter.print((String)null);
            break;
          case 3:
            null = "LOCAL_CONNECTING";
            paramPrintWriter.print((String)null);
            break;
          case 2:
            null = "REMOTE_CONNECTING";
            paramPrintWriter.print((String)null);
            break;
          case 1:
            null = "DISCONNECTED";
            paramPrintWriter.print((String)null);
            break;
        } 
        paramPrintWriter.append(" mService=");
        if (iInterface == null) {
          paramPrintWriter.append("null");
        } else {
          paramPrintWriter.append(zzhn()).append("@").append(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        } 
        paramPrintWriter.append(" mServiceBroker=");
        if (zzay1 == null) {
          paramPrintWriter.println("null");
        } else {
          paramPrintWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(zzay1.asBinder())));
        } 
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzgep > 0L) {
          null = paramPrintWriter.append(paramString).append("lastConnectedTime=");
          long l = this.zzgep;
          String str = simpleDateFormat.format(new Date(this.zzgep));
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 21);
          stringBuilder.append(l);
          stringBuilder.append(" ");
          stringBuilder.append(str);
          null.println(stringBuilder.toString());
        } 
        if (this.zzgeo > 0L) {
          paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          switch (this.zzgen) {
            default:
              null = String.valueOf(this.zzgen);
              paramPrintWriter.append((CharSequence)null);
              break;
            case 2:
              null = "CAUSE_NETWORK_LOST";
              paramPrintWriter.append((CharSequence)null);
              break;
            case 1:
              null = "CAUSE_SERVICE_DISCONNECTED";
              paramPrintWriter.append((CharSequence)null);
              break;
          } 
          null = paramPrintWriter.append(" lastSuspendedTime=");
          long l = this.zzgeo;
          String str = simpleDateFormat.format(new Date(this.zzgeo));
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 21);
          stringBuilder.append(l);
          stringBuilder.append(" ");
          stringBuilder.append(str);
          null.println(stringBuilder.toString());
        } 
        if (this.zzger > 0L) {
          paramPrintWriter.append(paramString).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzgeq));
          PrintWriter printWriter = paramPrintWriter.append(" lastFailedTime=");
          long l = this.zzger;
          String str = simpleDateFormat.format(new Date(this.zzger));
          null = new StringBuilder(String.valueOf(str).length() + 21);
          null.append(l);
          null.append(" ");
          null.append(str);
          printWriter.println(null.toString());
        } 
        return;
      } 
    } 
  }
  
  public Account getAccount() {
    return null;
  }
  
  public final Intent getSignInIntent() {
    throw new UnsupportedOperationException("Not a sign in API");
  }
  
  public final boolean isConnected() {
    synchronized (this.mLock) {
      if (this.zzgfa == 4)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public final boolean isConnecting() {
    synchronized (this.mLock) {
      if (this.zzgfa == 2 || this.zzgfa == 3)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  protected final void onConnectionFailed(ConnectionResult paramConnectionResult) {
    this.zzgeq = paramConnectionResult.zzcc;
    this.zzger = System.currentTimeMillis();
  }
  
  protected final void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2) {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramInt2, -1, new zzn(this, paramInt1, paramIBinder, paramBundle)));
  }
  
  public final void zza(zzan paramzzan, Set paramSet) {
    Bundle bundle = zzabt();
    zzz zzz = new zzz(this.zzgfd);
    zzz.zzggd = this.mContext.getPackageName();
    zzz.zzggg = bundle;
    if (paramSet != null)
      zzz.zzggf = (Scope[])paramSet.toArray((Object[])new Scope[paramSet.size()]); 
    if (zzacc()) {
      Account account;
      if (getAccount() != null) {
        account = getAccount();
      } else {
        account = new Account("<<default account>>", "com.google");
      } 
      zzz.zzggh = account;
      if (paramzzan != null)
        zzz.zzgge = paramzzan.asBinder(); 
    } 
    zzz.zzggi = zzalu();
    try {
      synchronized (this.zzgeu) {
        if (this.zzgev != null) {
          this.zzgev.zza(new zzk(this, this.zzgfh.get()), zzz);
        } else {
          Log.w("GmsClient", "mServiceBroker is null, client disconnected");
        } 
        return;
      } 
    } catch (DeadObjectException deadObjectException) {
      Log.w("GmsClient", "IGmsServiceBroker.getService failed", (Throwable)deadObjectException);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(6, this.zzgfh.get(), 1));
      return;
    } catch (SecurityException securityException) {
      throw securityException;
    } catch (RemoteException|RuntimeException remoteException) {
      Log.w("GmsClient", "IGmsServiceBroker.getService failed", (Throwable)remoteException);
      zza(8, (IBinder)null, (Bundle)null, this.zzgfh.get());
      return;
    } 
  }
  
  public final void zza(zzj paramzzj) {
    this.zzgew = (zzj)zzbq.checkNotNull(paramzzj, "Connection progress callbacks cannot be null.");
    zza(2, (IInterface)null);
  }
  
  public final void zza(zzp paramzzp) {
    paramzzp.zzako();
  }
  
  protected final void zza$4c85f423(int paramInt1, int paramInt2) {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(7, paramInt2, -1, new zzo(this, paramInt1)));
  }
  
  public Bundle zzabt() {
    return new Bundle();
  }
  
  public boolean zzacc() {
    return false;
  }
  
  public final boolean zzacn() {
    return false;
  }
  
  public final Bundle zzagp() {
    return null;
  }
  
  public final boolean zzahn() {
    return true;
  }
  
  public final IBinder zzaho() {
    synchronized (this.zzgeu) {
      if (this.zzgev == null)
        return null; 
      return this.zzgev.asBinder();
    } 
  }
  
  public final String zzahp() {
    if (isConnected() && this.zzges != null)
      return this.zzges.mPackageName; 
    throw new RuntimeException("Failed to connect when checking package");
  }
  
  public zzc[] zzalu() {
    return new zzc[0];
  }
  
  public final void zzalv() {
    if (isConnected())
      return; 
    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }
  
  public final IInterface zzalw() {
    synchronized (this.mLock) {
      if (this.zzgfa != 5) {
        zzalv();
        if (this.zzgex != null) {
          boolean bool1 = true;
          zzbq.zza(bool1, "Client is connected but service is null");
          return this.zzgex;
        } 
      } else {
        throw new DeadObjectException();
      } 
    } 
    boolean bool = false;
    zzbq.zza(bool, "Client is connected but service is null");
    IInterface iInterface = this.zzgex;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return iInterface;
  }
  
  protected Set zzaly() {
    return Collections.EMPTY_SET;
  }
  
  void zzb$59481928() {}
  
  public abstract IInterface zzd(IBinder paramIBinder);
  
  public abstract String zzhm();
  
  public abstract String zzhn();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */