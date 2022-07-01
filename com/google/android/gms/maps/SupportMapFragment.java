package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzap;
import com.google.android.gms.maps.internal.zzby;
import com.google.android.gms.maps.internal.zzbz;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class SupportMapFragment extends Fragment {
  private final zzb zzch = new zzb(this);
  
  public static SupportMapFragment newInstance() {
    return new SupportMapFragment();
  }
  
  public static SupportMapFragment newInstance(GoogleMapOptions paramGoogleMapOptions) {
    SupportMapFragment supportMapFragment = new SupportMapFragment();
    Bundle bundle = new Bundle();
    bundle.putParcelable("MapOptions", (Parcelable)paramGoogleMapOptions);
    supportMapFragment.setArguments(bundle);
    return supportMapFragment;
  }
  
  public void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback) {
    Preconditions.checkMainThread("getMapAsync must be called on the main thread.");
    this.zzch.getMapAsync(paramOnMapReadyCallback);
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    if (paramBundle != null)
      paramBundle.setClassLoader(SupportMapFragment.class.getClassLoader()); 
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
    zzb.zza(this.zzch, paramActivity);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.zzch.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.zzch.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    view.setClickable(true);
    return view;
  }
  
  public void onDestroy() {
    this.zzch.onDestroy();
    super.onDestroy();
  }
  
  public void onDestroyView() {
    this.zzch.onDestroyView();
    super.onDestroyView();
  }
  
  public final void onEnterAmbient(Bundle paramBundle) {
    Preconditions.checkMainThread("onEnterAmbient must be called on the main thread.");
    zzb zzb1 = this.zzch;
    if (zzb1.getDelegate() != null)
      ((zza)zzb1.getDelegate()).onEnterAmbient(paramBundle); 
  }
  
  public final void onExitAmbient() {
    Preconditions.checkMainThread("onExitAmbient must be called on the main thread.");
    zzb zzb1 = this.zzch;
    if (zzb1.getDelegate() != null)
      ((zza)zzb1.getDelegate()).onExitAmbient(); 
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle) {
    StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
    StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder(threadPolicy)).permitAll().build());
    try {
      super.onInflate(paramActivity, paramAttributeSet, paramBundle);
      zzb.zza(this.zzch, paramActivity);
      GoogleMapOptions googleMapOptions = GoogleMapOptions.createFromAttributes((Context)paramActivity, paramAttributeSet);
      Bundle bundle = new Bundle();
      bundle.putParcelable("MapOptions", (Parcelable)googleMapOptions);
      this.zzch.onInflate(paramActivity, bundle, paramBundle);
      return;
    } finally {
      StrictMode.setThreadPolicy(threadPolicy);
    } 
  }
  
  public void onLowMemory() {
    this.zzch.onLowMemory();
    super.onLowMemory();
  }
  
  public void onPause() {
    this.zzch.onPause();
    super.onPause();
  }
  
  public void onResume() {
    super.onResume();
    this.zzch.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    if (paramBundle != null)
      paramBundle.setClassLoader(SupportMapFragment.class.getClassLoader()); 
    super.onSaveInstanceState(paramBundle);
    this.zzch.onSaveInstanceState(paramBundle);
  }
  
  public void onStart() {
    super.onStart();
    this.zzch.onStart();
  }
  
  public void onStop() {
    this.zzch.onStop();
    super.onStop();
  }
  
  public void setArguments(Bundle paramBundle) {
    super.setArguments(paramBundle);
  }
  
  static final class zza implements MapLifecycleDelegate {
    private final Fragment fragment;
    
    private final IMapFragmentDelegate zzbb;
    
    public zza(Fragment param1Fragment, IMapFragmentDelegate param1IMapFragmentDelegate) {
      this.zzbb = (IMapFragmentDelegate)Preconditions.checkNotNull(param1IMapFragmentDelegate);
      this.fragment = (Fragment)Preconditions.checkNotNull(param1Fragment);
    }
    
    public final void getMapAsync(OnMapReadyCallback param1OnMapReadyCallback) {
      try {
        this.zzbb.getMapAsync((zzap)new zzak(this, param1OnMapReadyCallback));
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onCreate(Bundle param1Bundle) {
      try {
        Bundle bundle1 = new Bundle();
        zzby.zza(param1Bundle, bundle1);
        Bundle bundle2 = this.fragment.getArguments();
        if (bundle2 != null && bundle2.containsKey("MapOptions"))
          zzby.zza(bundle1, "MapOptions", bundle2.getParcelable("MapOptions")); 
        this.zzbb.onCreate(bundle1);
        zzby.zza(bundle1, param1Bundle);
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final View onCreateView(LayoutInflater param1LayoutInflater, ViewGroup param1ViewGroup, Bundle param1Bundle) {
      try {
        Bundle bundle = new Bundle();
        zzby.zza(param1Bundle, bundle);
        IObjectWrapper iObjectWrapper = this.zzbb.onCreateView(ObjectWrapper.wrap(param1LayoutInflater), ObjectWrapper.wrap(param1ViewGroup), bundle);
        zzby.zza(bundle, param1Bundle);
        return (View)ObjectWrapper.unwrap(iObjectWrapper);
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onDestroy() {
      try {
        this.zzbb.onDestroy();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onDestroyView() {
      try {
        this.zzbb.onDestroyView();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onEnterAmbient(Bundle param1Bundle) {
      try {
        Bundle bundle = new Bundle();
        zzby.zza(param1Bundle, bundle);
        this.zzbb.onEnterAmbient(bundle);
        zzby.zza(bundle, param1Bundle);
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onExitAmbient() {
      try {
        this.zzbb.onExitAmbient();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onInflate(Activity param1Activity, Bundle param1Bundle1, Bundle param1Bundle2) {
      GoogleMapOptions googleMapOptions = (GoogleMapOptions)param1Bundle1.getParcelable("MapOptions");
      try {
        Bundle bundle = new Bundle();
        zzby.zza(param1Bundle2, bundle);
        this.zzbb.onInflate(ObjectWrapper.wrap(param1Activity), googleMapOptions, bundle);
        zzby.zza(bundle, param1Bundle2);
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onLowMemory() {
      try {
        this.zzbb.onLowMemory();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onPause() {
      try {
        this.zzbb.onPause();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onResume() {
      try {
        this.zzbb.onResume();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onSaveInstanceState(Bundle param1Bundle) {
      try {
        Bundle bundle = new Bundle();
        zzby.zza(param1Bundle, bundle);
        this.zzbb.onSaveInstanceState(bundle);
        zzby.zza(bundle, param1Bundle);
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onStart() {
      try {
        this.zzbb.onStart();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onStop() {
      try {
        this.zzbb.onStop();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
  }
  
  static final class zzb extends DeferredLifecycleHelper<zza> {
    private final Fragment fragment;
    
    private OnDelegateCreatedListener<SupportMapFragment.zza> zzbd;
    
    private Activity zzbe;
    
    private final List<OnMapReadyCallback> zzbf = new ArrayList<OnMapReadyCallback>();
    
    zzb(Fragment param1Fragment) {
      this.fragment = param1Fragment;
    }
    
    private final void setActivity(Activity param1Activity) {
      this.zzbe = param1Activity;
      zzd();
    }
    
    private final void zzd() {
      if (this.zzbe != null && this.zzbd != null && getDelegate() == null)
        try {
          MapsInitializer.initialize((Context)this.zzbe);
          IMapFragmentDelegate iMapFragmentDelegate = zzbz.zza((Context)this.zzbe).zzc(ObjectWrapper.wrap(this.zzbe));
          if (iMapFragmentDelegate == null)
            return; 
          this.zzbd.onDelegateCreated((LifecycleDelegate)new SupportMapFragment.zza(this.fragment, iMapFragmentDelegate));
          for (OnMapReadyCallback onMapReadyCallback : this.zzbf)
            ((SupportMapFragment.zza)getDelegate()).getMapAsync(onMapReadyCallback); 
          this.zzbf.clear();
          return;
        } catch (RemoteException remoteException) {
          throw new RuntimeRemoteException(remoteException);
        } catch (GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException) {
          return;
        }  
    }
    
    public final void createDelegate(OnDelegateCreatedListener<SupportMapFragment.zza> param1OnDelegateCreatedListener) {
      this.zzbd = param1OnDelegateCreatedListener;
      zzd();
    }
    
    public final void getMapAsync(OnMapReadyCallback param1OnMapReadyCallback) {
      if (getDelegate() != null) {
        ((SupportMapFragment.zza)getDelegate()).getMapAsync(param1OnMapReadyCallback);
        return;
      } 
      this.zzbf.add(param1OnMapReadyCallback);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\SupportMapFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */