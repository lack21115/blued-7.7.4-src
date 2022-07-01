package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzap;
import com.google.android.gms.maps.internal.zzby;
import com.google.android.gms.maps.internal.zzbz;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapView extends FrameLayout {
  private final zzb zzbg;
  
  public MapView(Context paramContext) {
    super(paramContext);
    this.zzbg = new zzb((ViewGroup)this, paramContext, null);
    setClickable(true);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.zzbg = new zzb((ViewGroup)this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
    setClickable(true);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.zzbg = new zzb((ViewGroup)this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
    setClickable(true);
  }
  
  public MapView(Context paramContext, GoogleMapOptions paramGoogleMapOptions) {
    super(paramContext);
    this.zzbg = new zzb((ViewGroup)this, paramContext, paramGoogleMapOptions);
    setClickable(true);
  }
  
  public void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback) {
    Preconditions.checkMainThread("getMapAsync() must be called on the main thread");
    this.zzbg.getMapAsync(paramOnMapReadyCallback);
  }
  
  public final void onCreate(Bundle paramBundle) {
    StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
    StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder(threadPolicy)).permitAll().build());
    try {
      this.zzbg.onCreate(paramBundle);
      if (this.zzbg.getDelegate() == null)
        DeferredLifecycleHelper.showGooglePlayUnavailableMessage(this); 
      return;
    } finally {
      StrictMode.setThreadPolicy(threadPolicy);
    } 
  }
  
  public final void onDestroy() {
    this.zzbg.onDestroy();
  }
  
  public final void onEnterAmbient(Bundle paramBundle) {
    Preconditions.checkMainThread("onEnterAmbient() must be called on the main thread");
    zzb zzb1 = this.zzbg;
    if (zzb1.getDelegate() != null)
      ((zza)zzb1.getDelegate()).onEnterAmbient(paramBundle); 
  }
  
  public final void onExitAmbient() {
    Preconditions.checkMainThread("onExitAmbient() must be called on the main thread");
    zzb zzb1 = this.zzbg;
    if (zzb1.getDelegate() != null)
      ((zza)zzb1.getDelegate()).onExitAmbient(); 
  }
  
  public final void onLowMemory() {
    this.zzbg.onLowMemory();
  }
  
  public final void onPause() {
    this.zzbg.onPause();
  }
  
  public final void onResume() {
    this.zzbg.onResume();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {
    this.zzbg.onSaveInstanceState(paramBundle);
  }
  
  public final void onStart() {
    this.zzbg.onStart();
  }
  
  public final void onStop() {
    this.zzbg.onStop();
  }
  
  static final class zza implements MapLifecycleDelegate {
    private final ViewGroup parent;
    
    private final IMapViewDelegate zzbh;
    
    private View zzbi;
    
    public zza(ViewGroup param1ViewGroup, IMapViewDelegate param1IMapViewDelegate) {
      this.zzbh = (IMapViewDelegate)Preconditions.checkNotNull(param1IMapViewDelegate);
      this.parent = (ViewGroup)Preconditions.checkNotNull(param1ViewGroup);
    }
    
    public final void getMapAsync(OnMapReadyCallback param1OnMapReadyCallback) {
      try {
        this.zzbh.getMapAsync((zzap)new zzac(this, param1OnMapReadyCallback));
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onCreate(Bundle param1Bundle) {
      try {
        Bundle bundle = new Bundle();
        zzby.zza(param1Bundle, bundle);
        this.zzbh.onCreate(bundle);
        zzby.zza(bundle, param1Bundle);
        this.zzbi = (View)ObjectWrapper.unwrap(this.zzbh.getView());
        this.parent.removeAllViews();
        this.parent.addView(this.zzbi);
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final View onCreateView(LayoutInflater param1LayoutInflater, ViewGroup param1ViewGroup, Bundle param1Bundle) {
      throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
    }
    
    public final void onDestroy() {
      try {
        this.zzbh.onDestroy();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onDestroyView() {
      throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
    }
    
    public final void onEnterAmbient(Bundle param1Bundle) {
      try {
        Bundle bundle = new Bundle();
        zzby.zza(param1Bundle, bundle);
        this.zzbh.onEnterAmbient(bundle);
        zzby.zza(bundle, param1Bundle);
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onExitAmbient() {
      try {
        this.zzbh.onExitAmbient();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onInflate(Activity param1Activity, Bundle param1Bundle1, Bundle param1Bundle2) {
      throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
    }
    
    public final void onLowMemory() {
      try {
        this.zzbh.onLowMemory();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onPause() {
      try {
        this.zzbh.onPause();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onResume() {
      try {
        this.zzbh.onResume();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onSaveInstanceState(Bundle param1Bundle) {
      try {
        Bundle bundle = new Bundle();
        zzby.zza(param1Bundle, bundle);
        this.zzbh.onSaveInstanceState(bundle);
        zzby.zza(bundle, param1Bundle);
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onStart() {
      try {
        this.zzbh.onStart();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onStop() {
      try {
        this.zzbh.onStop();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
  }
  
  static final class zzb extends DeferredLifecycleHelper<zza> {
    private OnDelegateCreatedListener<MapView.zza> zzbd;
    
    private final List<OnMapReadyCallback> zzbf = new ArrayList<OnMapReadyCallback>();
    
    private final ViewGroup zzbj;
    
    private final Context zzbk;
    
    private final GoogleMapOptions zzbl;
    
    zzb(ViewGroup param1ViewGroup, Context param1Context, GoogleMapOptions param1GoogleMapOptions) {
      this.zzbj = param1ViewGroup;
      this.zzbk = param1Context;
      this.zzbl = param1GoogleMapOptions;
    }
    
    public final void createDelegate(OnDelegateCreatedListener<MapView.zza> param1OnDelegateCreatedListener) {
      this.zzbd = param1OnDelegateCreatedListener;
      if (this.zzbd != null && getDelegate() == null)
        try {
          MapsInitializer.initialize(this.zzbk);
          IMapViewDelegate iMapViewDelegate = zzbz.zza(this.zzbk).zza(ObjectWrapper.wrap(this.zzbk), this.zzbl);
          if (iMapViewDelegate == null)
            return; 
          this.zzbd.onDelegateCreated((LifecycleDelegate)new MapView.zza(this.zzbj, iMapViewDelegate));
          for (OnMapReadyCallback onMapReadyCallback : this.zzbf)
            ((MapView.zza)getDelegate()).getMapAsync(onMapReadyCallback); 
          this.zzbf.clear();
          return;
        } catch (RemoteException remoteException) {
          throw new RuntimeRemoteException(remoteException);
        } catch (GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException) {
          return;
        }  
    }
    
    public final void getMapAsync(OnMapReadyCallback param1OnMapReadyCallback) {
      if (getDelegate() != null) {
        ((MapView.zza)getDelegate()).getMapAsync(param1OnMapReadyCallback);
        return;
      } 
      this.zzbf.add(param1OnMapReadyCallback);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\MapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */