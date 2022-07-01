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
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzbp;
import com.google.android.gms.maps.internal.zzby;
import com.google.android.gms.maps.internal.zzbz;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaView extends FrameLayout {
  private final zzb zzcd;
  
  public StreetViewPanoramaView(Context paramContext) {
    super(paramContext);
    this.zzcd = new zzb((ViewGroup)this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.zzcd = new zzb((ViewGroup)this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.zzcd = new zzb((ViewGroup)this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions) {
    super(paramContext);
    this.zzcd = new zzb((ViewGroup)this, paramContext, paramStreetViewPanoramaOptions);
  }
  
  public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback) {
    Preconditions.checkMainThread("getStreetViewPanoramaAsync() must be called on the main thread");
    this.zzcd.getStreetViewPanoramaAsync(paramOnStreetViewPanoramaReadyCallback);
  }
  
  public final void onCreate(Bundle paramBundle) {
    StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
    StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder(threadPolicy)).permitAll().build());
    try {
      this.zzcd.onCreate(paramBundle);
      if (this.zzcd.getDelegate() == null)
        DeferredLifecycleHelper.showGooglePlayUnavailableMessage(this); 
      return;
    } finally {
      StrictMode.setThreadPolicy(threadPolicy);
    } 
  }
  
  public void onDestroy() {
    this.zzcd.onDestroy();
  }
  
  public final void onLowMemory() {
    this.zzcd.onLowMemory();
  }
  
  public final void onPause() {
    this.zzcd.onPause();
  }
  
  public void onResume() {
    this.zzcd.onResume();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {
    this.zzcd.onSaveInstanceState(paramBundle);
  }
  
  public void onStart() {
    this.zzcd.onStart();
  }
  
  public void onStop() {
    this.zzcd.onStop();
  }
  
  static final class zza implements StreetViewLifecycleDelegate {
    private final ViewGroup parent;
    
    private final IStreetViewPanoramaViewDelegate zzce;
    
    private View zzcf;
    
    public zza(ViewGroup param1ViewGroup, IStreetViewPanoramaViewDelegate param1IStreetViewPanoramaViewDelegate) {
      this.zzce = (IStreetViewPanoramaViewDelegate)Preconditions.checkNotNull(param1IStreetViewPanoramaViewDelegate);
      this.parent = (ViewGroup)Preconditions.checkNotNull(param1ViewGroup);
    }
    
    public final void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback param1OnStreetViewPanoramaReadyCallback) {
      try {
        this.zzce.getStreetViewPanoramaAsync((zzbp)new zzaj(this, param1OnStreetViewPanoramaReadyCallback));
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onCreate(Bundle param1Bundle) {
      try {
        Bundle bundle = new Bundle();
        zzby.zza(param1Bundle, bundle);
        this.zzce.onCreate(bundle);
        zzby.zza(bundle, param1Bundle);
        this.zzcf = (View)ObjectWrapper.unwrap(this.zzce.getView());
        this.parent.removeAllViews();
        this.parent.addView(this.zzcf);
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final View onCreateView(LayoutInflater param1LayoutInflater, ViewGroup param1ViewGroup, Bundle param1Bundle) {
      throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public final void onDestroy() {
      try {
        this.zzce.onDestroy();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onDestroyView() {
      throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public final void onInflate(Activity param1Activity, Bundle param1Bundle1, Bundle param1Bundle2) {
      throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public final void onLowMemory() {
      try {
        this.zzce.onLowMemory();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onPause() {
      try {
        this.zzce.onPause();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onResume() {
      try {
        this.zzce.onResume();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onSaveInstanceState(Bundle param1Bundle) {
      try {
        Bundle bundle = new Bundle();
        zzby.zza(param1Bundle, bundle);
        this.zzce.onSaveInstanceState(bundle);
        zzby.zza(bundle, param1Bundle);
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onStart() {
      try {
        this.zzce.onStart();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onStop() {
      try {
        this.zzce.onStop();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
  }
  
  static final class zzb extends DeferredLifecycleHelper<zza> {
    private OnDelegateCreatedListener<StreetViewPanoramaView.zza> zzbd;
    
    private final ViewGroup zzbj;
    
    private final Context zzbk;
    
    private final List<OnStreetViewPanoramaReadyCallback> zzbw = new ArrayList<OnStreetViewPanoramaReadyCallback>();
    
    private final StreetViewPanoramaOptions zzcg;
    
    zzb(ViewGroup param1ViewGroup, Context param1Context, StreetViewPanoramaOptions param1StreetViewPanoramaOptions) {
      this.zzbj = param1ViewGroup;
      this.zzbk = param1Context;
      this.zzcg = param1StreetViewPanoramaOptions;
    }
    
    public final void createDelegate(OnDelegateCreatedListener<StreetViewPanoramaView.zza> param1OnDelegateCreatedListener) {
      this.zzbd = param1OnDelegateCreatedListener;
      if (this.zzbd != null && getDelegate() == null)
        try {
          MapsInitializer.initialize(this.zzbk);
          IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate = zzbz.zza(this.zzbk).zza(ObjectWrapper.wrap(this.zzbk), this.zzcg);
          this.zzbd.onDelegateCreated((LifecycleDelegate)new StreetViewPanoramaView.zza(this.zzbj, iStreetViewPanoramaViewDelegate));
          for (OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback : this.zzbw)
            ((StreetViewPanoramaView.zza)getDelegate()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback); 
          this.zzbw.clear();
          return;
        } catch (RemoteException remoteException) {
          throw new RuntimeRemoteException(remoteException);
        } catch (GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException) {
          return;
        }  
    }
    
    public final void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback param1OnStreetViewPanoramaReadyCallback) {
      if (getDelegate() != null) {
        ((StreetViewPanoramaView.zza)getDelegate()).getStreetViewPanoramaAsync(param1OnStreetViewPanoramaReadyCallback);
        return;
      } 
      this.zzbw.add(param1OnStreetViewPanoramaReadyCallback);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\StreetViewPanoramaView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */