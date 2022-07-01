package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseGmsClient<T extends IInterface> {
  public static final int CONNECT_STATE_CONNECTED = 4;
  
  public static final int CONNECT_STATE_DISCONNECTED = 1;
  
  public static final int CONNECT_STATE_DISCONNECTING = 5;
  
  public static final String DEFAULT_ACCOUNT = "<<default account>>";
  
  public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES;
  
  public static final String KEY_PENDING_INTENT = "pendingIntent";
  
  private static final Feature[] zzd = new Feature[0];
  
  final Handler zza;
  
  private ConnectionResult zzaa = null;
  
  private boolean zzab = false;
  
  private volatile zzc zzac = null;
  
  protected ConnectionProgressReportCallbacks zzb;
  
  protected AtomicInteger zzc = new AtomicInteger(0);
  
  private int zze;
  
  private long zzf;
  
  private long zzg;
  
  private int zzh;
  
  private long zzi;
  
  private volatile String zzj = null;
  
  private zzk zzk;
  
  private final Context zzl;
  
  private final Looper zzm;
  
  private final GmsClientSupervisor zzn;
  
  private final GoogleApiAvailabilityLight zzo;
  
  private final Object zzp = new Object();
  
  private final Object zzq = new Object();
  
  private IGmsServiceBroker zzr;
  
  private T zzs;
  
  private final ArrayList<zzc<?>> zzt = new ArrayList<zzc<?>>();
  
  private zzd zzu;
  
  private int zzv = 1;
  
  private final BaseConnectionCallbacks zzw;
  
  private final BaseOnConnectionFailedListener zzx;
  
  private final int zzy;
  
  private final String zzz;
  
  static {
    GOOGLE_PLUS_REQUIRED_FEATURES = new String[] { "service_esmobile", "service_googleme" };
  }
  
  protected BaseGmsClient(Context paramContext, Handler paramHandler, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener) {
    this.zzl = Preconditions.<Context>checkNotNull(paramContext, "Context must not be null");
    this.zza = Preconditions.<Handler>checkNotNull(paramHandler, "Handler must not be null");
    this.zzm = paramHandler.getLooper();
    this.zzn = Preconditions.<GmsClientSupervisor>checkNotNull(paramGmsClientSupervisor, "Supervisor must not be null");
    this.zzo = Preconditions.<GoogleApiAvailabilityLight>checkNotNull(paramGoogleApiAvailabilityLight, "API availability must not be null");
    this.zzy = paramInt;
    this.zzw = paramBaseConnectionCallbacks;
    this.zzx = paramBaseOnConnectionFailedListener;
    this.zzz = null;
  }
  
  protected BaseGmsClient(Context paramContext, Looper paramLooper, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener, String paramString) {
    this(paramContext, paramLooper, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailabilityLight.getInstance(), paramInt, Preconditions.<BaseConnectionCallbacks>checkNotNull(paramBaseConnectionCallbacks), Preconditions.<BaseOnConnectionFailedListener>checkNotNull(paramBaseOnConnectionFailedListener), paramString);
  }
  
  protected BaseGmsClient(Context paramContext, Looper paramLooper, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener, String paramString) {
    this.zzl = Preconditions.<Context>checkNotNull(paramContext, "Context must not be null");
    this.zzm = Preconditions.<Looper>checkNotNull(paramLooper, "Looper must not be null");
    this.zzn = Preconditions.<GmsClientSupervisor>checkNotNull(paramGmsClientSupervisor, "Supervisor must not be null");
    this.zzo = Preconditions.<GoogleApiAvailabilityLight>checkNotNull(paramGoogleApiAvailabilityLight, "API availability must not be null");
    this.zza = (Handler)new zzb(this, paramLooper);
    this.zzy = paramInt;
    this.zzw = paramBaseConnectionCallbacks;
    this.zzx = paramBaseOnConnectionFailedListener;
    this.zzz = paramString;
  }
  
  private final String zza() {
    String str2 = this.zzz;
    String str1 = str2;
    if (str2 == null)
      str1 = this.zzl.getClass().getName(); 
    return str1;
  }
  
  private final void zza(int paramInt) {
    if (zzb()) {
      paramInt = 5;
      this.zzab = true;
    } else {
      paramInt = 4;
    } 
    Handler handler = this.zza;
    handler.sendMessage(handler.obtainMessage(paramInt, this.zzc.get(), 16));
  }
  
  private final void zza(int paramInt, T paramT) {
    boolean bool1;
    boolean bool2;
    boolean bool3 = false;
    if (paramInt == 4) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (paramT != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (bool1 == bool2)
      bool3 = true; 
    Preconditions.checkArgument(bool3);
    synchronized (this.zzp) {
      this.zzv = paramInt;
      this.zzs = paramT;
      onSetConnectState(paramInt, paramT);
      if (paramInt != 1) {
        if (paramInt != 2 && paramInt != 3) {
          if (paramInt == 4)
            onConnectedLocked(paramT); 
        } else {
          zzk zzk1;
          if (this.zzu != null && this.zzk != null) {
            String str4 = this.zzk.zza();
            String str5 = this.zzk.zzb();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str4).length() + 70 + String.valueOf(str5).length());
            stringBuilder.append("Calling connect() while still connected, missing disconnect() for ");
            stringBuilder.append(str4);
            stringBuilder.append(" on ");
            stringBuilder.append(str5);
            Log.e("GmsClient", stringBuilder.toString());
            this.zzn.zza(this.zzk.zza(), this.zzk.zzb(), this.zzk.zzc(), this.zzu, zza(), this.zzk.zzd());
            this.zzc.incrementAndGet();
          } 
          this.zzu = new zzd(this, this.zzc.get());
          if (this.zzv == 3 && getLocalStartServiceAction() != null) {
            zzk1 = new zzk(getContext().getPackageName(), getLocalStartServiceAction(), true, GmsClientSupervisor.getDefaultBindFlags(), false);
          } else {
            zzk1 = new zzk(getStartServicePackage(), getStartServiceAction(), false, GmsClientSupervisor.getDefaultBindFlags(), getUseDynamicLookup());
          } 
          this.zzk = zzk1;
          if (this.zzk.zzd() && getMinApkVersion() < 17895000) {
            String str = String.valueOf(this.zzk.zza());
            if (str.length() != 0) {
              str = "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(str);
            } else {
              str = new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ");
            } 
            throw new IllegalStateException(str);
          } 
          GmsClientSupervisor gmsClientSupervisor = this.zzn;
          String str1 = this.zzk.zza();
          String str2 = this.zzk.zzb();
          paramInt = this.zzk.zzc();
          zzd zzd1 = this.zzu;
          String str3 = zza();
          if (!gmsClientSupervisor.zza(new GmsClientSupervisor.zza(str1, str2, paramInt, this.zzk.zzd()), zzd1, str3)) {
            String str = this.zzk.zza();
            str1 = this.zzk.zzb();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str1).length());
            stringBuilder.append("unable to connect to service: ");
            stringBuilder.append(str);
            stringBuilder.append(" on ");
            stringBuilder.append(str1);
            Log.e("GmsClient", stringBuilder.toString());
            zza(16, (Bundle)null, this.zzc.get());
          } 
        } 
      } else if (this.zzu != null) {
        this.zzn.zza(this.zzk.zza(), this.zzk.zzb(), this.zzk.zzc(), this.zzu, zza(), this.zzk.zzd());
        this.zzu = null;
      } 
      return;
    } 
  }
  
  private final void zza(zzc paramzzc) {
    this.zzac = paramzzc;
  }
  
  private final boolean zza(int paramInt1, int paramInt2, T paramT) {
    synchronized (this.zzp) {
      if (this.zzv != paramInt1)
        return false; 
      zza(paramInt2, paramT);
      return true;
    } 
  }
  
  private final boolean zzb() {
    synchronized (this.zzp) {
      if (this.zzv == 3)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  private final boolean zzc() {
    if (this.zzab)
      return false; 
    if (TextUtils.isEmpty(getServiceDescriptor()))
      return false; 
    if (TextUtils.isEmpty(getLocalStartServiceAction()))
      return false; 
    try {
      Class.forName(getServiceDescriptor());
      return true;
    } catch (ClassNotFoundException classNotFoundException) {
      return false;
    } 
  }
  
  public void checkAvailabilityAndConnect() {
    int i = this.zzo.isGooglePlayServicesAvailable(this.zzl, getMinApkVersion());
    if (i != 0) {
      zza(1, (T)null);
      triggerNotAvailable(new LegacyClientCallbackAdapter(this), i, null);
      return;
    } 
    connect(new LegacyClientCallbackAdapter(this));
  }
  
  public final void checkConnected() {
    if (isConnected())
      return; 
    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }
  
  public void connect(ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks) {
    this.zzb = Preconditions.<ConnectionProgressReportCallbacks>checkNotNull(paramConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
    zza(2, (T)null);
  }
  
  protected abstract T createServiceInterface(IBinder paramIBinder);
  
  public void disconnect() {
    this.zzc.incrementAndGet();
    synchronized (this.zzt) {
      int j = this.zzt.size();
      for (int i = 0; i < j; i++)
        ((zzc)this.zzt.get(i)).zze(); 
      this.zzt.clear();
      synchronized (this.zzq) {
        this.zzr = null;
        zza(1, (T)null);
        return;
      } 
    } 
  }
  
  public void disconnect(String paramString) {
    this.zzj = paramString;
    disconnect();
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    synchronized (this.zzp) {
      int i = this.zzv;
      T t = this.zzs;
      synchronized (this.zzq) {
        IGmsServiceBroker iGmsServiceBroker = this.zzr;
        paramPrintWriter.append(paramString).append("mConnectState=");
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 4) {
                if (i != 5) {
                  paramPrintWriter.print("UNKNOWN");
                } else {
                  paramPrintWriter.print("DISCONNECTING");
                } 
              } else {
                paramPrintWriter.print("CONNECTED");
              } 
            } else {
              paramPrintWriter.print("LOCAL_CONNECTING");
            } 
          } else {
            paramPrintWriter.print("REMOTE_CONNECTING");
          } 
        } else {
          paramPrintWriter.print("DISCONNECTED");
        } 
        paramPrintWriter.append(" mService=");
        if (t == null) {
          paramPrintWriter.append("null");
        } else {
          paramPrintWriter.append(getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(t.asBinder())));
        } 
        paramPrintWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
          paramPrintWriter.println("null");
        } else {
          paramPrintWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        } 
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzg > 0L) {
          null = paramPrintWriter.append(paramString).append("lastConnectedTime=");
          long l = this.zzg;
          String str = simpleDateFormat.format(new Date(l));
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 21);
          stringBuilder.append(l);
          stringBuilder.append(" ");
          stringBuilder.append(str);
          null.println(stringBuilder.toString());
        } 
        if (this.zzf > 0L) {
          paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          i = this.zze;
          if (i != 1) {
            if (i != 2) {
              if (i != 3) {
                paramPrintWriter.append(String.valueOf(i));
              } else {
                paramPrintWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
              } 
            } else {
              paramPrintWriter.append("CAUSE_NETWORK_LOST");
            } 
          } else {
            paramPrintWriter.append("CAUSE_SERVICE_DISCONNECTED");
          } 
          null = paramPrintWriter.append(" lastSuspendedTime=");
          long l = this.zzf;
          String str = simpleDateFormat.format(new Date(l));
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 21);
          stringBuilder.append(l);
          stringBuilder.append(" ");
          stringBuilder.append(str);
          null.println(stringBuilder.toString());
        } 
        if (this.zzi > 0L) {
          paramPrintWriter.append(paramString).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzh));
          PrintWriter printWriter = paramPrintWriter.append(" lastFailedTime=");
          long l = this.zzi;
          String str = simpleDateFormat.format(new Date(l));
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 21);
          stringBuilder.append(l);
          stringBuilder.append(" ");
          stringBuilder.append(str);
          printWriter.println(stringBuilder.toString());
        } 
        return;
      } 
    } 
  }
  
  protected boolean enableLocalFallback() {
    return false;
  }
  
  public Account getAccount() {
    return null;
  }
  
  public Feature[] getApiFeatures() {
    return zzd;
  }
  
  public final Feature[] getAvailableFeatures() {
    zzc zzc1 = this.zzac;
    return (zzc1 == null) ? null : zzc1.zzb;
  }
  
  public Bundle getConnectionHint() {
    return null;
  }
  
  public final Context getContext() {
    return this.zzl;
  }
  
  public String getEndpointPackageName() {
    if (isConnected()) {
      zzk zzk1 = this.zzk;
      if (zzk1 != null)
        return zzk1.zzb(); 
    } 
    throw new RuntimeException("Failed to connect when checking package");
  }
  
  protected Bundle getGetServiceRequestExtraArgs() {
    return new Bundle();
  }
  
  public String getLastDisconnectMessage() {
    return this.zzj;
  }
  
  protected String getLocalStartServiceAction() {
    return null;
  }
  
  public final Looper getLooper() {
    return this.zzm;
  }
  
  public int getMinApkVersion() {
    return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  }
  
  public void getRemoteService(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet) {
    Bundle bundle = getGetServiceRequestExtraArgs();
    GetServiceRequest getServiceRequest = new GetServiceRequest(this.zzy);
    getServiceRequest.zza = this.zzl.getPackageName();
    getServiceRequest.zzd = bundle;
    if (paramSet != null)
      getServiceRequest.zzc = paramSet.<Scope>toArray(new Scope[paramSet.size()]); 
    if (requiresSignIn()) {
      Account account;
      if (getAccount() != null) {
        account = getAccount();
      } else {
        account = new Account("<<default account>>", "com.google");
      } 
      getServiceRequest.zze = account;
      if (paramIAccountAccessor != null)
        getServiceRequest.zzb = paramIAccountAccessor.asBinder(); 
    } else if (requiresAccount()) {
      getServiceRequest.zze = getAccount();
    } 
    getServiceRequest.zzf = zzd;
    getServiceRequest.zzg = getApiFeatures();
    try {
      synchronized (this.zzq) {
        if (this.zzr != null) {
          this.zzr.getService(new zze(this, this.zzc.get()), getServiceRequest);
        } else {
          Log.w("GmsClient", "mServiceBroker is null, client disconnected");
        } 
        return;
      } 
    } catch (DeadObjectException deadObjectException) {
      Log.w("GmsClient", "IGmsServiceBroker.getService failed", (Throwable)deadObjectException);
      triggerConnectionSuspended(3);
      return;
    } catch (SecurityException securityException) {
      throw securityException;
    } catch (RemoteException remoteException) {
      Log.w("GmsClient", "IGmsServiceBroker.getService failed", (Throwable)remoteException);
      onPostInitHandler(8, null, null, this.zzc.get());
      return;
    } catch (RuntimeException runtimeException) {
      Log.w("GmsClient", "IGmsServiceBroker.getService failed", runtimeException);
      onPostInitHandler(8, null, null, this.zzc.get());
      return;
    } 
  }
  
  protected Set<Scope> getScopes() {
    return Collections.emptySet();
  }
  
  public final T getService() throws DeadObjectException {
    synchronized (this.zzp) {
      if (this.zzv != 5) {
        checkConnected();
        if (this.zzs != null) {
          boolean bool1 = true;
          Preconditions.checkState(bool1, "Client is connected but service is null");
          return this.zzs;
        } 
      } else {
        throw new DeadObjectException();
      } 
    } 
    boolean bool = false;
    Preconditions.checkState(bool, "Client is connected but service is null");
    T t = this.zzs;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return t;
  }
  
  public IBinder getServiceBrokerBinder() {
    synchronized (this.zzq) {
      if (this.zzr == null)
        return null; 
      return this.zzr.asBinder();
    } 
  }
  
  protected abstract String getServiceDescriptor();
  
  public Intent getSignInIntent() {
    throw new UnsupportedOperationException("Not a sign in API");
  }
  
  protected abstract String getStartServiceAction();
  
  protected String getStartServicePackage() {
    return "com.google.android.gms";
  }
  
  protected boolean getUseDynamicLookup() {
    return false;
  }
  
  public boolean isConnected() {
    synchronized (this.zzp) {
      if (this.zzv == 4)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public boolean isConnecting() {
    synchronized (this.zzp) {
      if (this.zzv == 2 || this.zzv == 3)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  protected void onConnectedLocked(T paramT) {
    this.zzg = System.currentTimeMillis();
  }
  
  protected void onConnectionFailed(ConnectionResult paramConnectionResult) {
    this.zzh = paramConnectionResult.getErrorCode();
    this.zzi = System.currentTimeMillis();
  }
  
  protected void onConnectionSuspended(int paramInt) {
    this.zze = paramInt;
    this.zzf = System.currentTimeMillis();
  }
  
  protected void onPostInitHandler(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2) {
    Handler handler = this.zza;
    handler.sendMessage(handler.obtainMessage(1, paramInt2, -1, new zzf(this, paramInt1, paramIBinder, paramBundle)));
  }
  
  void onSetConnectState(int paramInt, T paramT) {}
  
  public void onUserSignOut(SignOutCallbacks paramSignOutCallbacks) {
    paramSignOutCallbacks.onSignOutComplete();
  }
  
  public boolean providesSignIn() {
    return false;
  }
  
  public boolean requiresAccount() {
    return false;
  }
  
  public boolean requiresGooglePlayServices() {
    return true;
  }
  
  public boolean requiresSignIn() {
    return false;
  }
  
  public void triggerConnectionSuspended(int paramInt) {
    Handler handler = this.zza;
    handler.sendMessage(handler.obtainMessage(6, this.zzc.get(), paramInt));
  }
  
  protected void triggerNotAvailable(ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks, int paramInt, PendingIntent paramPendingIntent) {
    this.zzb = Preconditions.<ConnectionProgressReportCallbacks>checkNotNull(paramConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
    Handler handler = this.zza;
    handler.sendMessage(handler.obtainMessage(3, this.zzc.get(), paramInt, paramPendingIntent));
  }
  
  protected final void zza(int paramInt1, Bundle paramBundle, int paramInt2) {
    Handler handler = this.zza;
    handler.sendMessage(handler.obtainMessage(7, paramInt2, -1, new zzg(this, paramInt1, null)));
  }
  
  public static interface BaseConnectionCallbacks {
    public static final int CAUSE_DEAD_OBJECT_EXCEPTION = 3;
    
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    
    void onConnected(Bundle param1Bundle);
    
    void onConnectionSuspended(int param1Int);
  }
  
  public static interface BaseOnConnectionFailedListener {
    void onConnectionFailed(ConnectionResult param1ConnectionResult);
  }
  
  public static interface ConnectionProgressReportCallbacks {
    void onReportServiceBinding(ConnectionResult param1ConnectionResult);
  }
  
  public class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
    public LegacyClientCallbackAdapter(BaseGmsClient this$0) {}
    
    public void onReportServiceBinding(ConnectionResult param1ConnectionResult) {
      BaseGmsClient baseGmsClient;
      if (param1ConnectionResult.isSuccess()) {
        baseGmsClient = this.zza;
        baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
        return;
      } 
      if (BaseGmsClient.zzg(this.zza) != null)
        BaseGmsClient.zzg(this.zza).onConnectionFailed((ConnectionResult)baseGmsClient); 
    }
  }
  
  public static interface SignOutCallbacks {
    void onSignOutComplete();
  }
  
  abstract class zza extends zzc<Boolean> {
    private final int zza;
    
    private final Bundle zzb;
    
    protected zza(BaseGmsClient this$0, int param1Int, Bundle param1Bundle) {
      super(this$0, Boolean.valueOf(true));
      this.zza = param1Int;
      this.zzb = param1Bundle;
    }
    
    protected abstract void zza(ConnectionResult param1ConnectionResult);
    
    protected abstract boolean zza();
    
    protected final void zzb() {}
  }
  
  final class zzb extends zzi {
    public zzb(BaseGmsClient this$0, Looper param1Looper) {
      super(param1Looper);
    }
    
    private static void zza(Message param1Message) {
      BaseGmsClient.zzc zzc = (BaseGmsClient.zzc)param1Message.obj;
      zzc.zzb();
      zzc.zzd();
    }
    
    private static boolean zzb(Message param1Message) {
      return (param1Message.what != 2 && param1Message.what != 1) ? ((param1Message.what == 7)) : true;
    }
    
    public final void handleMessage(Message param1Message) {
      ConnectionResult connectionResult;
      if (this.zza.zzc.get() != param1Message.arg1) {
        if (zzb(param1Message))
          zza(param1Message); 
        return;
      } 
      if ((param1Message.what == 1 || param1Message.what == 7 || (param1Message.what == 4 && !this.zza.enableLocalFallback()) || param1Message.what == 5) && !this.zza.isConnecting()) {
        zza(param1Message);
        return;
      } 
      int i = param1Message.what;
      PendingIntent pendingIntent = null;
      if (i == 4) {
        BaseGmsClient.zza(this.zza, new ConnectionResult(param1Message.arg2));
        if (BaseGmsClient.zzb(this.zza) && !BaseGmsClient.zzc(this.zza)) {
          BaseGmsClient.zza(this.zza, 3, (IInterface)null);
          return;
        } 
        if (BaseGmsClient.zzd(this.zza) != null) {
          connectionResult = BaseGmsClient.zzd(this.zza);
        } else {
          connectionResult = new ConnectionResult(8);
        } 
        this.zza.zzb.onReportServiceBinding(connectionResult);
        this.zza.onConnectionFailed(connectionResult);
        return;
      } 
      if (((Message)connectionResult).what == 5) {
        if (BaseGmsClient.zzd(this.zza) != null) {
          connectionResult = BaseGmsClient.zzd(this.zza);
        } else {
          connectionResult = new ConnectionResult(8);
        } 
        this.zza.zzb.onReportServiceBinding(connectionResult);
        this.zza.onConnectionFailed(connectionResult);
        return;
      } 
      if (((Message)connectionResult).what == 3) {
        if (((Message)connectionResult).obj instanceof PendingIntent)
          pendingIntent = (PendingIntent)((Message)connectionResult).obj; 
        connectionResult = new ConnectionResult(((Message)connectionResult).arg2, pendingIntent);
        this.zza.zzb.onReportServiceBinding(connectionResult);
        this.zza.onConnectionFailed(connectionResult);
        return;
      } 
      if (((Message)connectionResult).what == 6) {
        BaseGmsClient.zza(this.zza, 5, (IInterface)null);
        if (BaseGmsClient.zze(this.zza) != null)
          BaseGmsClient.zze(this.zza).onConnectionSuspended(((Message)connectionResult).arg2); 
        this.zza.onConnectionSuspended(((Message)connectionResult).arg2);
        BaseGmsClient.zza(this.zza, 5, 1, null);
        return;
      } 
      if (((Message)connectionResult).what == 2 && !this.zza.isConnected()) {
        zza((Message)connectionResult);
        return;
      } 
      if (zzb((Message)connectionResult)) {
        ((BaseGmsClient.zzc)((Message)connectionResult).obj).zzc();
        return;
      } 
      i = ((Message)connectionResult).what;
      StringBuilder stringBuilder = new StringBuilder(45);
      stringBuilder.append("Don't know how to handle message: ");
      stringBuilder.append(i);
      Log.wtf("GmsClient", stringBuilder.toString(), new Exception());
    }
  }
  
  public abstract class zzc<TListener> {
    private TListener zza;
    
    private boolean zzb;
    
    public zzc(BaseGmsClient this$0, TListener param1TListener) {
      this.zza = param1TListener;
      this.zzb = false;
    }
    
    protected abstract void zza(TListener param1TListener);
    
    protected abstract void zzb();
    
    public final void zzc() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield zza : Ljava/lang/Object;
      //   6: astore_1
      //   7: aload_0
      //   8: getfield zzb : Z
      //   11: ifeq -> 67
      //   14: aload_0
      //   15: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
      //   18: astore_2
      //   19: new java/lang/StringBuilder
      //   22: dup
      //   23: aload_2
      //   24: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
      //   27: invokevirtual length : ()I
      //   30: bipush #47
      //   32: iadd
      //   33: invokespecial <init> : (I)V
      //   36: astore_3
      //   37: aload_3
      //   38: ldc 'Callback proxy '
      //   40: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   43: pop
      //   44: aload_3
      //   45: aload_2
      //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   49: pop
      //   50: aload_3
      //   51: ldc ' being reused. This is not safe.'
      //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   56: pop
      //   57: ldc 'GmsClient'
      //   59: aload_3
      //   60: invokevirtual toString : ()Ljava/lang/String;
      //   63: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
      //   66: pop
      //   67: aload_0
      //   68: monitorexit
      //   69: aload_1
      //   70: ifnull -> 88
      //   73: aload_0
      //   74: aload_1
      //   75: invokevirtual zza : (Ljava/lang/Object;)V
      //   78: goto -> 92
      //   81: astore_1
      //   82: aload_0
      //   83: invokevirtual zzb : ()V
      //   86: aload_1
      //   87: athrow
      //   88: aload_0
      //   89: invokevirtual zzb : ()V
      //   92: aload_0
      //   93: monitorenter
      //   94: aload_0
      //   95: iconst_1
      //   96: putfield zzb : Z
      //   99: aload_0
      //   100: monitorexit
      //   101: aload_0
      //   102: invokevirtual zzd : ()V
      //   105: return
      //   106: astore_1
      //   107: aload_0
      //   108: monitorexit
      //   109: aload_1
      //   110: athrow
      //   111: astore_1
      //   112: aload_0
      //   113: monitorexit
      //   114: aload_1
      //   115: athrow
      // Exception table:
      //   from	to	target	type
      //   2	67	111	finally
      //   67	69	111	finally
      //   73	78	81	java/lang/RuntimeException
      //   94	101	106	finally
      //   107	109	106	finally
      //   112	114	111	finally
    }
    
    public final void zzd() {
      zze();
      synchronized (BaseGmsClient.zzf(this.zzc)) {
        BaseGmsClient.zzf(this.zzc).remove(this);
        return;
      } 
    }
    
    public final void zze() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aconst_null
      //   4: putfield zza : Ljava/lang/Object;
      //   7: aload_0
      //   8: monitorexit
      //   9: return
      //   10: astore_1
      //   11: aload_0
      //   12: monitorexit
      //   13: aload_1
      //   14: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	10	finally
      //   11	13	10	finally
    }
  }
  
  public final class zzd implements ServiceConnection {
    private final int zza;
    
    public zzd(BaseGmsClient this$0, int param1Int) {
      this.zza = param1Int;
    }
    
    public final void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
      if (param1IBinder == null) {
        BaseGmsClient.zza(this.zzb, 16);
        return;
      } 
      synchronized (BaseGmsClient.zza(this.zzb)) {
        IInterface iInterface;
        BaseGmsClient baseGmsClient = this.zzb;
        if (param1IBinder == null) {
          param1ComponentName = null;
        } else {
          iInterface = param1IBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
          if (iInterface != null && iInterface instanceof IGmsServiceBroker) {
            iInterface = iInterface;
          } else {
            iInterface = new IGmsServiceBroker.Stub.zza(param1IBinder);
          } 
        } 
        BaseGmsClient.zza(baseGmsClient, (IGmsServiceBroker)iInterface);
        this.zzb.zza(0, (Bundle)null, this.zza);
        return;
      } 
    }
    
    public final void onServiceDisconnected(ComponentName param1ComponentName) {
      synchronized (BaseGmsClient.zza(this.zzb)) {
        BaseGmsClient.zza(this.zzb, (IGmsServiceBroker)null);
        this.zzb.zza.sendMessage(this.zzb.zza.obtainMessage(6, this.zza, 1));
        return;
      } 
    }
  }
  
  public static final class zze extends IGmsCallbacks.zza {
    private BaseGmsClient zza;
    
    private final int zzb;
    
    public zze(BaseGmsClient param1BaseGmsClient, int param1Int) {
      this.zza = param1BaseGmsClient;
      this.zzb = param1Int;
    }
    
    public final void onPostInitComplete(int param1Int, IBinder param1IBinder, Bundle param1Bundle) {
      Preconditions.checkNotNull(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
      this.zza.onPostInitHandler(param1Int, param1IBinder, param1Bundle, this.zzb);
      this.zza = null;
    }
    
    public final void zza(int param1Int, Bundle param1Bundle) {
      Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
    
    public final void zza(int param1Int, IBinder param1IBinder, zzc param1zzc) {
      Preconditions.checkNotNull(this.zza, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
      Preconditions.checkNotNull(param1zzc);
      BaseGmsClient.zza(this.zza, param1zzc);
      onPostInitComplete(param1Int, param1IBinder, param1zzc.zza);
    }
  }
  
  public final class zzf extends zza {
    private final IBinder zza;
    
    public zzf(BaseGmsClient this$0, int param1Int, IBinder param1IBinder, Bundle param1Bundle) {
      super(this$0, param1Int, param1Bundle);
      this.zza = param1IBinder;
    }
    
    protected final void zza(ConnectionResult param1ConnectionResult) {
      if (BaseGmsClient.zzg(this.zzb) != null)
        BaseGmsClient.zzg(this.zzb).onConnectionFailed(param1ConnectionResult); 
      this.zzb.onConnectionFailed(param1ConnectionResult);
    }
    
    protected final boolean zza() {
      try {
        String str = this.zza.getInterfaceDescriptor();
        if (!this.zzb.getServiceDescriptor().equals(str)) {
          String str1 = this.zzb.getServiceDescriptor();
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 34 + String.valueOf(str).length());
          stringBuilder.append("service descriptor mismatch: ");
          stringBuilder.append(str1);
          stringBuilder.append(" vs. ");
          stringBuilder.append(str);
          Log.e("GmsClient", stringBuilder.toString());
          return false;
        } 
        str = this.zzb.createServiceInterface(this.zza);
        if (str != null && (BaseGmsClient.zza(this.zzb, 2, 4, (IInterface)str) || BaseGmsClient.zza(this.zzb, 3, 4, (IInterface)str))) {
          BaseGmsClient.zza(this.zzb, (ConnectionResult)null);
          Bundle bundle = this.zzb.getConnectionHint();
          if (BaseGmsClient.zze(this.zzb) != null)
            BaseGmsClient.zze(this.zzb).onConnected(bundle); 
          return true;
        } 
        return false;
      } catch (RemoteException remoteException) {
        Log.w("GmsClient", "service probably died");
        return false;
      } 
    }
  }
  
  public final class zzg extends zza {
    public zzg(BaseGmsClient this$0, int param1Int, Bundle param1Bundle) {
      super(this$0, param1Int, null);
    }
    
    protected final void zza(ConnectionResult param1ConnectionResult) {
      if (this.zza.enableLocalFallback() && BaseGmsClient.zzb(this.zza)) {
        BaseGmsClient.zza(this.zza, 16);
        return;
      } 
      this.zza.zzb.onReportServiceBinding(param1ConnectionResult);
      this.zza.onConnectionFailed(param1ConnectionResult);
    }
    
    protected final boolean zza() {
      this.zza.zzb.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
      return true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\BaseGmsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */