package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.zzf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public final class zzba extends GoogleApiClient implements zzcd {
  private final Context mContext;
  
  private final Looper zzalj;
  
  private final int zzfte;
  
  private final GoogleApiAvailability zzftg;
  
  private Api.zza zzfth;
  
  private boolean zzftk;
  
  private final Lock zzfwa;
  
  private zzr zzfwf;
  
  private Map zzfwi;
  
  private Queue zzfwo = new LinkedList();
  
  private final zzae zzfyc;
  
  private zzcc zzfyd = null;
  
  private volatile boolean zzfye;
  
  private long zzfyf = 120000L;
  
  private long zzfyg = 5000L;
  
  private final zzbf zzfyh;
  
  private zzbx zzfyi;
  
  final Map zzfyj;
  
  Set zzfyk = new HashSet();
  
  private final zzcm zzfyl = new zzcm();
  
  private final ArrayList zzfym;
  
  private Integer zzfyn = null;
  
  Set zzfyo = null;
  
  final zzdk zzfyp;
  
  private final zzaf zzfyq = new zzbb(this);
  
  public zzba(Context paramContext, Lock paramLock, Looper paramLooper, zzr paramzzr, GoogleApiAvailability paramGoogleApiAvailability, Api.zza paramzza, Map paramMap1, List paramList1, List paramList2, Map paramMap2, int paramInt1, int paramInt2, ArrayList paramArrayList) {
    this.mContext = paramContext;
    this.zzfwa = paramLock;
    this.zzftk = false;
    this.zzfyc = new zzae(paramLooper, this.zzfyq);
    this.zzalj = paramLooper;
    this.zzfyh = new zzbf(this, paramLooper);
    this.zzftg = paramGoogleApiAvailability;
    this.zzfte = paramInt1;
    if (this.zzfte >= 0)
      this.zzfyn = Integer.valueOf(paramInt2); 
    this.zzfwi = paramMap1;
    this.zzfyj = paramMap2;
    this.zzfym = paramArrayList;
    this.zzfyp = new zzdk(this.zzfyj);
    for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : paramList1) {
      zzae zzae1 = this.zzfyc;
      zzbq.checkNotNull(connectionCallbacks);
      synchronized (zzae1.mLock) {
        if (zzae1.zzggm.contains(connectionCallbacks)) {
          String str = String.valueOf(connectionCallbacks);
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 62);
          stringBuilder.append("registerConnectionCallbacks(): listener ");
          stringBuilder.append(str);
          stringBuilder.append(" is already registered");
          Log.w("GmsClientEvents", stringBuilder.toString());
        } else {
          zzae1.zzggm.add(connectionCallbacks);
        } 
        if (zzae1.zzggl.isConnected())
          zzae1.mHandler.sendMessage(zzae1.mHandler.obtainMessage(1, connectionCallbacks)); 
      } 
    } 
    for (GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener : paramList2)
      this.zzfyc.registerConnectionFailedListener(onConnectionFailedListener); 
    this.zzfwf = paramzzr;
    this.zzfth = paramzza;
  }
  
  public static int zza(Iterable paramIterable, boolean paramBoolean) {
    Iterator<Api.zze> iterator = paramIterable.iterator();
    boolean bool2 = false;
    boolean bool1 = false;
    while (iterator.hasNext()) {
      Api.zze zze = iterator.next();
      boolean bool = bool2;
      if (zze.zzacc())
        bool = true; 
      bool2 = bool;
      if (zze.zzacn()) {
        bool1 = true;
        bool2 = bool;
      } 
    } 
    return bool2 ? ((bool1 && paramBoolean) ? 2 : 1) : 3;
  }
  
  private final void zzajq() {
    this.zzfyc.zzggp = true;
    this.zzfyd.connect();
  }
  
  private final void zzbu(int paramInt) {
    if (this.zzfyn == null) {
      this.zzfyn = Integer.valueOf(paramInt);
    } else if (this.zzfyn.intValue() != paramInt) {
      String str1 = zzbv(paramInt);
      String str2 = zzbv(this.zzfyn.intValue());
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 51 + String.valueOf(str2).length());
      stringBuilder.append("Cannot use sign-in mode: ");
      stringBuilder.append(str1);
      stringBuilder.append(". Mode was already set to ");
      stringBuilder.append(str2);
      throw new IllegalStateException(stringBuilder.toString());
    } 
    if (this.zzfyd != null)
      return; 
    Iterator<Api.zze> iterator = this.zzfyj.values().iterator();
    boolean bool = false;
    paramInt = 0;
    while (iterator.hasNext()) {
      Api.zze zze = iterator.next();
      boolean bool1 = bool;
      if (zze.zzacc())
        bool1 = true; 
      bool = bool1;
      if (zze.zzacn()) {
        paramInt = 1;
        bool = bool1;
      } 
    } 
    switch (this.zzfyn.intValue()) {
      case 2:
        if (bool) {
          if (this.zzftk) {
            this.zzfyd = new zzaa(this.mContext, this.zzfwa, this.zzalj, (zzf)this.zzftg, this.zzfyj, this.zzfwf, this.zzfwi, this.zzfth, this.zzfym, this, true);
            return;
          } 
          this.zzfyd = zzv.zza(this.mContext, this, this.zzfwa, this.zzalj, (zzf)this.zzftg, this.zzfyj, this.zzfwf, this.zzfwi, this.zzfth, this.zzfym);
          return;
        } 
        break;
      case 1:
        if (bool) {
          if (paramInt == 0)
            break; 
          throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
        } 
        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
    } 
    if (this.zzftk && paramInt == 0) {
      this.zzfyd = new zzaa(this.mContext, this.zzfwa, this.zzalj, (zzf)this.zzftg, this.zzfyj, this.zzfwf, this.zzfwi, this.zzfth, this.zzfym, this, false);
      return;
    } 
    this.zzfyd = new zzbi(this.mContext, this, this.zzfwa, this.zzalj, (zzf)this.zzftg, this.zzfyj, this.zzfwf, this.zzfwi, this.zzfth, this.zzfym, this);
  }
  
  private static String zzbv(int paramInt) {
    switch (paramInt) {
      default:
        return "UNKNOWN";
      case 3:
        return "SIGN_IN_MODE_NONE";
      case 2:
        return "SIGN_IN_MODE_OPTIONAL";
      case 1:
        break;
    } 
    return "SIGN_IN_MODE_REQUIRED";
  }
  
  public final void connect() {
    this.zzfwa.lock();
    try {
      int i = this.zzfte;
      boolean bool = false;
      if (i >= 0) {
        if (this.zzfyn != null)
          bool = true; 
        zzbq.zza(bool, "Sign-in mode should have been set explicitly by auto-manage.");
      } else if (this.zzfyn == null) {
        this.zzfyn = Integer.valueOf(zza(this.zzfyj.values(), false));
      } else if (this.zzfyn.intValue() == 2) {
        throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
      } 
      super.connect(this.zzfyn.intValue());
      return;
    } finally {
      this.zzfwa.unlock();
    } 
  }
  
  public final void connect(int paramInt) {
    this.zzfwa.lock();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 3) {
      bool1 = bool2;
      if (paramInt != 1)
        if (paramInt == 2) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }  
    } 
    try {
      StringBuilder stringBuilder = new StringBuilder(33);
      stringBuilder.append("Illegal sign-in mode: ");
      stringBuilder.append(paramInt);
      zzbq.checkArgument(bool1, stringBuilder.toString());
      zzbu(paramInt);
      zzajq();
      return;
    } finally {
      this.zzfwa.unlock();
    } 
  }
  
  public final void disconnect() {
    this.zzfwa.lock();
    try {
      this.zzfyp.release();
      if (this.zzfyd != null)
        this.zzfyd.disconnect(); 
      zzcm zzcm1 = this.zzfyl;
      Iterator iterator = zzcm1.zzfgd.iterator();
      while (iterator.hasNext())
        ((zzci)iterator.next()).zzgat = null; 
      zzcm1.zzfgd.clear();
      for (zzm zzm : this.zzfwo) {
        zzm.zza((zzdn)null);
        zzm.cancel();
      } 
      this.zzfwo.clear();
      zzcc zzcc1 = this.zzfyd;
      if (zzcc1 != null) {
        zzajs();
        this.zzfyc.zzams();
      } 
      return;
    } finally {
      this.zzfwa.unlock();
    } 
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    paramPrintWriter.append(paramString).append("mContext=").println(this.mContext);
    paramPrintWriter.append(paramString).append("mResuming=").print(this.zzfye);
    paramPrintWriter.append(" mWorkQueue.size()=").print(this.zzfwo.size());
    zzdk zzdk1 = this.zzfyp;
    paramPrintWriter.append(" mUnconsumedApiCalls.size()=").println(zzdk1.zzgbs.size());
    if (this.zzfyd != null)
      this.zzfyd.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString); 
  }
  
  public final Looper getLooper() {
    return this.zzalj;
  }
  
  public final boolean isConnected() {
    return (this.zzfyd != null && this.zzfyd.isConnected());
  }
  
  public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    this.zzfyc.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener) {
    zzae zzae1 = this.zzfyc;
    zzbq.checkNotNull(paramOnConnectionFailedListener);
    synchronized (zzae1.mLock) {
      if (!zzae1.zzggo.remove(paramOnConnectionFailedListener)) {
        String str = String.valueOf(paramOnConnectionFailedListener);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 57);
        stringBuilder.append("unregisterConnectionFailedListener(): listener ");
        stringBuilder.append(str);
        stringBuilder.append(" not found");
        Log.w("GmsClientEvents", stringBuilder.toString());
      } 
      return;
    } 
  }
  
  public final Api.zze zza(Api.zzc paramzzc) {
    Api.zze zze = (Api.zze)this.zzfyj.get(paramzzc);
    zzbq.checkNotNull(zze, "Appropriate Api was not requested.");
    return zze;
  }
  
  public final void zza(zzdh paramzzdh) {
    this.zzfwa.lock();
    try {
      if (this.zzfyo == null)
        this.zzfyo = new HashSet(); 
      this.zzfyo.add(paramzzdh);
      return;
    } finally {
      this.zzfwa.unlock();
    } 
  }
  
  final boolean zzajs() {
    if (!this.zzfye)
      return false; 
    this.zzfye = false;
    this.zzfyh.removeMessages(2);
    this.zzfyh.removeMessages(1);
    if (this.zzfyi != null) {
      this.zzfyi.unregister();
      this.zzfyi = null;
    } 
    return true;
  }
  
  final boolean zzajt() {
    this.zzfwa.lock();
    try {
      Set set = this.zzfyo;
      if (set == null)
        return false; 
      boolean bool = this.zzfyo.isEmpty();
      return bool ^ true;
    } finally {
      this.zzfwa.unlock();
    } 
  }
  
  final String zzaju() {
    StringWriter stringWriter = new StringWriter();
    super.dump("", null, new PrintWriter(stringWriter), null);
    return stringWriter.toString();
  }
  
  public final void zzb(zzdh paramzzdh) {
    this.zzfwa.lock();
    try {
      String str;
      Exception exception;
      if (this.zzfyo == null) {
        str = "Attempted to remove pending transform when no transforms are registered.";
        exception = new Exception();
      } else if (!this.zzfyo.remove(str)) {
        str = "Failed to remove pending transform - this may lead to memory leaks!";
        exception = new Exception();
      } else {
        if (!zzajt())
          this.zzfyd.zzais(); 
        this.zzfwa.unlock();
      } 
      Log.wtf("GoogleApiClientImpl", str, exception);
    } finally {
      this.zzfwa.unlock();
    } 
  }
  
  public final void zzc(ConnectionResult paramConnectionResult) {
    if (!zzf.zzd(this.mContext, paramConnectionResult.zzcc))
      zzajs(); 
    if (!this.zzfye) {
      boolean bool;
      zzae zzae1 = this.zzfyc;
      Looper looper1 = Looper.myLooper();
      Looper looper2 = zzae1.mHandler.getLooper();
      int i = 0;
      if (looper1 == looper2) {
        bool = true;
      } else {
        bool = false;
      } 
      zzbq.zza(bool, "onConnectionFailure must only be called on the Handler thread");
      zzae1.mHandler.removeMessages(1);
      synchronized (zzae1.mLock) {
        ArrayList<Object> arrayList = new ArrayList(zzae1.zzggo);
        int j = zzae1.zzggq.get();
        arrayList = arrayList;
        int k = arrayList.size();
        while (i < k) {
          GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener)arrayList.get(i);
          int m = i + 1;
          onConnectionFailedListener = onConnectionFailedListener;
          if (!zzae1.zzggp || zzae1.zzggq.get() != j)
            break; 
          i = m;
          if (zzae1.zzggo.contains(onConnectionFailedListener)) {
            onConnectionFailedListener.onConnectionFailed(paramConnectionResult);
            i = m;
          } 
        } 
        this.zzfyc.zzams();
        return;
      } 
    } 
  }
  
  public final zzm zze(zzm paramzzm) {
    String str;
    if (paramzzm.zzfus != null) {
      bool = true;
    } else {
      bool = false;
    } 
    zzbq.checkArgument(bool, "This task can not be executed (it's probably a Batch or malformed)");
    boolean bool = this.zzfyj.containsKey(paramzzm.zzfus);
    if (paramzzm.zzfop != null) {
      str = paramzzm.zzfop.mName;
    } else {
      str = "the API";
    } 
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 65);
    stringBuilder.append("GoogleApiClient is not configured to use ");
    stringBuilder.append(str);
    stringBuilder.append(" required for this call.");
    zzbq.checkArgument(bool, stringBuilder.toString());
    this.zzfwa.lock();
    try {
      if (this.zzfyd != null) {
        if (this.zzfye) {
          zzm zzm1;
          this.zzfwo.add(paramzzm);
          while (true) {
            zzm1 = paramzzm;
            if (!this.zzfwo.isEmpty()) {
              zzm1 = this.zzfwo.remove();
              this.zzfyp.zzb(zzm1);
              zzm1.zzu(Status.zzfts);
              continue;
            } 
            break;
          } 
          return zzm1;
        } 
        return this.zzfyd.zze(paramzzm);
      } 
      throw new IllegalStateException("GoogleApiClient is not connected yet.");
    } finally {
      this.zzfwa.unlock();
    } 
  }
  
  public final void zzf(int paramInt, boolean paramBoolean) {
    if (paramInt == 1 && !paramBoolean && !this.zzfye) {
      this.zzfye = true;
      if (this.zzfyi == null)
        this.zzfyi = GoogleApiAvailability.zza(this.mContext.getApplicationContext(), new zzbg(this)); 
      this.zzfyh.sendMessageDelayed(this.zzfyh.obtainMessage(1), this.zzfyf);
      this.zzfyh.sendMessageDelayed(this.zzfyh.obtainMessage(2), this.zzfyg);
    } 
    BasePendingResult[] arrayOfBasePendingResult = (BasePendingResult[])this.zzfyp.zzgbs.toArray((Object[])zzdk.zzgbr);
    int j = arrayOfBasePendingResult.length;
    int i;
    for (i = 0; i < j; i++)
      arrayOfBasePendingResult[i].zzv(zzdk.zzgbq); 
    null = this.zzfyc;
    if (Looper.myLooper() == null.mHandler.getLooper()) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    zzbq.zza(paramBoolean, "onUnintentionalDisconnection must only be called on the Handler thread");
    null.mHandler.removeMessages(1);
    synchronized (null.mLock) {
      null.zzggr = true;
      ArrayList<Object> arrayList = new ArrayList(null.zzggm);
      int k = null.zzggq.get();
      arrayList = arrayList;
      int m = arrayList.size();
      i = 0;
      while (i < m) {
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks)arrayList.get(i);
        j = i + 1;
        connectionCallbacks = connectionCallbacks;
        if (null.zzggp && null.zzggq.get() == k) {
          i = j;
          if (null.zzggm.contains(connectionCallbacks)) {
            connectionCallbacks.onConnectionSuspended(paramInt);
            i = j;
          } 
        } 
      } 
      null.zzggn.clear();
      null.zzggr = false;
      this.zzfyc.zzams();
      if (paramInt == 2)
        zzajq(); 
      return;
    } 
  }
  
  public final void zzk(Bundle paramBundle) {
    boolean bool1;
    while (!this.zzfwo.isEmpty())
      super.zze(this.zzfwo.remove()); 
    zzae zzae1 = this.zzfyc;
    Looper looper1 = Looper.myLooper();
    Looper looper2 = zzae1.mHandler.getLooper();
    boolean bool2 = true;
    if (looper1 == looper2) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    zzbq.zza(bool1, "onConnectionSuccess must only be called on the Handler thread");
    synchronized (zzae1.mLock) {
      zzbq.checkState(zzae1.zzggr ^ true);
      zzae1.mHandler.removeMessages(1);
      zzae1.zzggr = true;
      if (zzae1.zzggn.size() == 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      zzbq.checkState(bool1);
      ArrayList<Object> arrayList = new ArrayList(zzae1.zzggm);
      int j = zzae1.zzggq.get();
      arrayList = arrayList;
      int k = arrayList.size();
      int i = 0;
      while (i < k) {
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks)arrayList.get(i);
        int m = i + 1;
        connectionCallbacks = connectionCallbacks;
        if (zzae1.zzggp && zzae1.zzggl.isConnected() && zzae1.zzggq.get() == j) {
          i = m;
          if (!zzae1.zzggn.contains(connectionCallbacks)) {
            connectionCallbacks.onConnected(paramBundle);
            i = m;
          } 
        } 
      } 
      zzae1.zzggn.clear();
      zzae1.zzggr = false;
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */