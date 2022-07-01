package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzaq;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public final class zzap {
  private final zzbi<zzal> zza;
  
  private final Context zzb;
  
  private boolean zzc = false;
  
  private final Map<ListenerHolder.ListenerKey<LocationListener>, zzaw> zzd = new HashMap<ListenerHolder.ListenerKey<LocationListener>, zzaw>();
  
  private final Map<ListenerHolder.ListenerKey<Object>, zzat> zze = new HashMap<ListenerHolder.ListenerKey<Object>, zzat>();
  
  private final Map<ListenerHolder.ListenerKey<LocationCallback>, zzas> zzf = new HashMap<ListenerHolder.ListenerKey<LocationCallback>, zzas>();
  
  public zzap(Context paramContext, zzbi<zzal> paramzzbi) {
    this.zzb = paramContext;
    this.zza = paramzzbi;
  }
  
  private final zzaw zza(ListenerHolder<LocationListener> paramListenerHolder) {
    ListenerHolder.ListenerKey<LocationListener> listenerKey = paramListenerHolder.getListenerKey();
    if (listenerKey == null)
      return null; 
    synchronized (this.zzd) {
      zzaw zzaw2 = this.zzd.get(listenerKey);
      zzaw zzaw1 = zzaw2;
      if (zzaw2 == null)
        zzaw1 = new zzaw(paramListenerHolder); 
      this.zzd.put(listenerKey, zzaw1);
      return zzaw1;
    } 
  }
  
  private final zzas zzb(ListenerHolder<LocationCallback> paramListenerHolder) {
    ListenerHolder.ListenerKey<LocationCallback> listenerKey = paramListenerHolder.getListenerKey();
    if (listenerKey == null)
      return null; 
    synchronized (this.zzf) {
      zzas zzas2 = this.zzf.get(listenerKey);
      zzas zzas1 = zzas2;
      if (zzas2 == null)
        zzas1 = new zzas(paramListenerHolder); 
      this.zzf.put(listenerKey, zzas1);
      return zzas1;
    } 
  }
  
  @Deprecated
  public final Location zza() throws RemoteException {
    this.zza.zza();
    return ((zzal)this.zza.zzb()).zza();
  }
  
  public final Location zza(@Nullable String paramString) throws RemoteException {
    this.zza.zza();
    return ((zzal)this.zza.zzb()).zza(paramString);
  }
  
  public final void zza(PendingIntent paramPendingIntent, zzai paramzzai) throws RemoteException {
    this.zza.zza();
    zzal zzal = this.zza.zzb();
    if (paramzzai != null) {
      IBinder iBinder = paramzzai.asBinder();
    } else {
      paramzzai = null;
    } 
    zzal.zza(new zzbe(2, null, null, paramPendingIntent, null, (IBinder)paramzzai));
  }
  
  public final void zza(Location paramLocation) throws RemoteException {
    this.zza.zza();
    ((zzal)this.zza.zzb()).zza(paramLocation);
  }
  
  public final void zza(ListenerHolder.ListenerKey<LocationListener> paramListenerKey, zzai paramzzai) throws RemoteException {
    this.zza.zza();
    Preconditions.checkNotNull(paramListenerKey, "Invalid null listener key");
    synchronized (this.zzd) {
      zzaw zzaw = this.zzd.remove(paramListenerKey);
      if (zzaw != null) {
        zzaw.zza();
        ((zzal)this.zza.zzb()).zza(zzbe.zza((zzaq)zzaw, paramzzai));
      } 
      return;
    } 
  }
  
  public final void zza(zzai paramzzai) throws RemoteException {
    this.zza.zza();
    ((zzal)this.zza.zzb()).zza(paramzzai);
  }
  
  public final void zza(zzbc paramzzbc, PendingIntent paramPendingIntent, zzai paramzzai) throws RemoteException {
    this.zza.zza();
    ((zzal)this.zza.zzb()).zza(zzbe.zza(paramzzbc, paramPendingIntent, paramzzai));
  }
  
  public final void zza(zzbc paramzzbc, ListenerHolder<LocationCallback> paramListenerHolder, zzai paramzzai) throws RemoteException {
    this.zza.zza();
    zzas zzas = zzb(paramListenerHolder);
    if (zzas == null)
      return; 
    zzal zzal = this.zza.zzb();
    IBinder iBinder = zzas.asBinder();
    if (paramzzai != null) {
      IBinder iBinder1 = paramzzai.asBinder();
    } else {
      zzas = null;
    } 
    zzal.zza(new zzbe(1, paramzzbc, null, null, iBinder, (IBinder)zzas));
  }
  
  public final void zza(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent, zzai paramzzai) throws RemoteException {
    this.zza.zza();
    ((zzal)this.zza.zzb()).zza(zzbe.zza(zzbc.zza(null, paramLocationRequest), paramPendingIntent, paramzzai));
  }
  
  public final void zza(LocationRequest paramLocationRequest, ListenerHolder<LocationListener> paramListenerHolder, zzai paramzzai) throws RemoteException {
    IBinder iBinder1;
    this.zza.zza();
    zzaw zzaw = zza(paramListenerHolder);
    if (zzaw == null)
      return; 
    zzal zzal = this.zza.zzb();
    paramListenerHolder = null;
    zzbc zzbc = zzbc.zza(null, paramLocationRequest);
    IBinder iBinder2 = zzaw.asBinder();
    ListenerHolder<LocationListener> listenerHolder = paramListenerHolder;
    if (paramzzai != null)
      iBinder1 = paramzzai.asBinder(); 
    zzal.zza(new zzbe(1, zzbc, iBinder2, null, null, iBinder1));
  }
  
  public final void zza(boolean paramBoolean) throws RemoteException {
    this.zza.zza();
    ((zzal)this.zza.zzb()).zza(paramBoolean);
    this.zzc = paramBoolean;
  }
  
  public final LocationAvailability zzb() throws RemoteException {
    this.zza.zza();
    return ((zzal)this.zza.zzb()).zzb(this.zzb.getPackageName());
  }
  
  public final void zzb(ListenerHolder.ListenerKey<LocationCallback> paramListenerKey, zzai paramzzai) throws RemoteException {
    this.zza.zza();
    Preconditions.checkNotNull(paramListenerKey, "Invalid null listener key");
    synchronized (this.zzf) {
      zzas zzas = this.zzf.remove(paramListenerKey);
      if (zzas != null) {
        zzas.zza();
        ((zzal)this.zza.zzb()).zza(zzbe.zza((com.google.android.gms.location.zzap)zzas, paramzzai));
      } 
      return;
    } 
  }
  
  public final void zzc() throws RemoteException {
    synchronized (this.zzd) {
      for (zzaw zzaw : this.zzd.values()) {
        if (zzaw != null)
          ((zzal)this.zza.zzb()).zza(zzbe.zza((zzaq)zzaw, (zzai)null)); 
      } 
      this.zzd.clear();
      synchronized (this.zzf) {
        for (zzas zzas : this.zzf.values()) {
          if (zzas != null)
            ((zzal)this.zza.zzb()).zza(zzbe.zza((com.google.android.gms.location.zzap)zzas, (zzai)null)); 
        } 
        this.zzf.clear();
        synchronized (this.zze) {
          for (zzat zzat : this.zze.values()) {
            if (zzat != null)
              ((zzal)this.zza.zzb()).zza(new zzl(2, null, zzat.asBinder(), null)); 
          } 
          this.zze.clear();
          return;
        } 
      } 
    } 
  }
  
  public final void zzd() throws RemoteException {
    if (this.zzc)
      zza(false); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\location\zzap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */