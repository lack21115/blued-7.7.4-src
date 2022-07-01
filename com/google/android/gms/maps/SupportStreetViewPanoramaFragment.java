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
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzbp;
import com.google.android.gms.maps.internal.zzby;
import com.google.android.gms.maps.internal.zzbz;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class SupportStreetViewPanoramaFragment extends Fragment {
  private final zzb zzci = new zzb(this);
  
  public static SupportStreetViewPanoramaFragment newInstance() {
    return new SupportStreetViewPanoramaFragment();
  }
  
  public static SupportStreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions paramStreetViewPanoramaOptions) {
    SupportStreetViewPanoramaFragment supportStreetViewPanoramaFragment = new SupportStreetViewPanoramaFragment();
    Bundle bundle = new Bundle();
    bundle.putParcelable("StreetViewPanoramaOptions", (Parcelable)paramStreetViewPanoramaOptions);
    supportStreetViewPanoramaFragment.setArguments(bundle);
    return supportStreetViewPanoramaFragment;
  }
  
  public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback) {
    Preconditions.checkMainThread("getStreetViewPanoramaAsync() must be called on the main thread");
    this.zzci.getStreetViewPanoramaAsync(paramOnStreetViewPanoramaReadyCallback);
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    if (paramBundle != null)
      paramBundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader()); 
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
    zzb.zza(this.zzci, paramActivity);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.zzci.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    return this.zzci.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy() {
    this.zzci.onDestroy();
    super.onDestroy();
  }
  
  public void onDestroyView() {
    this.zzci.onDestroyView();
    super.onDestroyView();
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle) {
    StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
    StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder(threadPolicy)).permitAll().build());
    try {
      super.onInflate(paramActivity, paramAttributeSet, paramBundle);
      zzb.zza(this.zzci, paramActivity);
      Bundle bundle = new Bundle();
      this.zzci.onInflate(paramActivity, bundle, paramBundle);
      return;
    } finally {
      StrictMode.setThreadPolicy(threadPolicy);
    } 
  }
  
  public void onLowMemory() {
    this.zzci.onLowMemory();
    super.onLowMemory();
  }
  
  public void onPause() {
    this.zzci.onPause();
    super.onPause();
  }
  
  public void onResume() {
    super.onResume();
    this.zzci.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    if (paramBundle != null)
      paramBundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader()); 
    super.onSaveInstanceState(paramBundle);
    this.zzci.onSaveInstanceState(paramBundle);
  }
  
  public void onStart() {
    super.onStart();
    this.zzci.onStart();
  }
  
  public void onStop() {
    this.zzci.onStop();
    super.onStop();
  }
  
  public void setArguments(Bundle paramBundle) {
    super.setArguments(paramBundle);
  }
  
  static final class zza implements StreetViewLifecycleDelegate {
    private final Fragment fragment;
    
    private final IStreetViewPanoramaFragmentDelegate zzbu;
    
    public zza(Fragment param1Fragment, IStreetViewPanoramaFragmentDelegate param1IStreetViewPanoramaFragmentDelegate) {
      this.zzbu = (IStreetViewPanoramaFragmentDelegate)Preconditions.checkNotNull(param1IStreetViewPanoramaFragmentDelegate);
      this.fragment = (Fragment)Preconditions.checkNotNull(param1Fragment);
    }
    
    public final void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback param1OnStreetViewPanoramaReadyCallback) {
      try {
        this.zzbu.getStreetViewPanoramaAsync((zzbp)new zzal(this, param1OnStreetViewPanoramaReadyCallback));
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
        if (bundle2 != null && bundle2.containsKey("StreetViewPanoramaOptions"))
          zzby.zza(bundle1, "StreetViewPanoramaOptions", bundle2.getParcelable("StreetViewPanoramaOptions")); 
        this.zzbu.onCreate(bundle1);
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
        IObjectWrapper iObjectWrapper = this.zzbu.onCreateView(ObjectWrapper.wrap(param1LayoutInflater), ObjectWrapper.wrap(param1ViewGroup), bundle);
        zzby.zza(bundle, param1Bundle);
        return (View)ObjectWrapper.unwrap(iObjectWrapper);
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onDestroy() {
      try {
        this.zzbu.onDestroy();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onDestroyView() {
      try {
        this.zzbu.onDestroyView();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onInflate(Activity param1Activity, Bundle param1Bundle1, Bundle param1Bundle2) {
      try {
        param1Bundle1 = new Bundle();
        zzby.zza(param1Bundle2, param1Bundle1);
        this.zzbu.onInflate(ObjectWrapper.wrap(param1Activity), null, param1Bundle1);
        zzby.zza(param1Bundle1, param1Bundle2);
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onLowMemory() {
      try {
        this.zzbu.onLowMemory();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onPause() {
      try {
        this.zzbu.onPause();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onResume() {
      try {
        this.zzbu.onResume();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onSaveInstanceState(Bundle param1Bundle) {
      try {
        Bundle bundle = new Bundle();
        zzby.zza(param1Bundle, bundle);
        this.zzbu.onSaveInstanceState(bundle);
        zzby.zza(bundle, param1Bundle);
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onStart() {
      try {
        this.zzbu.onStart();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
    
    public final void onStop() {
      try {
        this.zzbu.onStop();
        return;
      } catch (RemoteException remoteException) {
        throw new RuntimeRemoteException(remoteException);
      } 
    }
  }
  
  static final class zzb extends DeferredLifecycleHelper<zza> {
    private final Fragment fragment;
    
    private OnDelegateCreatedListener<SupportStreetViewPanoramaFragment.zza> zzbd;
    
    private Activity zzbe;
    
    private final List<OnStreetViewPanoramaReadyCallback> zzbw = new ArrayList<OnStreetViewPanoramaReadyCallback>();
    
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
          IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate = zzbz.zza((Context)this.zzbe).zzd(ObjectWrapper.wrap(this.zzbe));
          this.zzbd.onDelegateCreated((LifecycleDelegate)new SupportStreetViewPanoramaFragment.zza(this.fragment, iStreetViewPanoramaFragmentDelegate));
          for (OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback : this.zzbw)
            ((SupportStreetViewPanoramaFragment.zza)getDelegate()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback); 
          this.zzbw.clear();
          return;
        } catch (RemoteException remoteException) {
          throw new RuntimeRemoteException(remoteException);
        } catch (GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException) {
          return;
        }  
    }
    
    public final void createDelegate(OnDelegateCreatedListener<SupportStreetViewPanoramaFragment.zza> param1OnDelegateCreatedListener) {
      this.zzbd = param1OnDelegateCreatedListener;
      zzd();
    }
    
    public final void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback param1OnStreetViewPanoramaReadyCallback) {
      if (getDelegate() != null) {
        ((SupportStreetViewPanoramaFragment.zza)getDelegate()).getStreetViewPanoramaAsync(param1OnStreetViewPanoramaReadyCallback);
        return;
      } 
      this.zzbw.add(param1OnStreetViewPanoramaReadyCallback);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\SupportStreetViewPanoramaFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */