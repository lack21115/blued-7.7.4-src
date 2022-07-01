package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public final class FragmentWrapper extends IFragmentWrapper.Stub {
  private Fragment zza;
  
  private FragmentWrapper(Fragment paramFragment) {
    this.zza = paramFragment;
  }
  
  public static FragmentWrapper wrap(Fragment paramFragment) {
    return (paramFragment != null) ? new FragmentWrapper(paramFragment) : null;
  }
  
  public final IObjectWrapper zza() {
    return ObjectWrapper.wrap(this.zza.getActivity());
  }
  
  public final void zza(Intent paramIntent) {
    this.zza.startActivity(paramIntent);
  }
  
  public final void zza(Intent paramIntent, int paramInt) {
    this.zza.startActivityForResult(paramIntent, paramInt);
  }
  
  public final void zza(IObjectWrapper paramIObjectWrapper) {
    View view = ObjectWrapper.<View>unwrap(paramIObjectWrapper);
    this.zza.registerForContextMenu(view);
  }
  
  public final void zza(boolean paramBoolean) {
    this.zza.setHasOptionsMenu(paramBoolean);
  }
  
  public final Bundle zzb() {
    return this.zza.getArguments();
  }
  
  public final void zzb(IObjectWrapper paramIObjectWrapper) {
    View view = ObjectWrapper.<View>unwrap(paramIObjectWrapper);
    this.zza.unregisterForContextMenu(view);
  }
  
  public final void zzb(boolean paramBoolean) {
    this.zza.setMenuVisibility(paramBoolean);
  }
  
  public final int zzc() {
    return this.zza.getId();
  }
  
  public final void zzc(boolean paramBoolean) {
    this.zza.setRetainInstance(paramBoolean);
  }
  
  public final IFragmentWrapper zzd() {
    return wrap(this.zza.getParentFragment());
  }
  
  public final void zzd(boolean paramBoolean) {
    this.zza.setUserVisibleHint(paramBoolean);
  }
  
  public final IObjectWrapper zze() {
    return ObjectWrapper.wrap(this.zza.getResources());
  }
  
  public final boolean zzf() {
    return this.zza.getRetainInstance();
  }
  
  public final String zzg() {
    return this.zza.getTag();
  }
  
  public final IFragmentWrapper zzh() {
    return wrap(this.zza.getTargetFragment());
  }
  
  public final int zzi() {
    return this.zza.getTargetRequestCode();
  }
  
  public final boolean zzj() {
    return this.zza.getUserVisibleHint();
  }
  
  public final IObjectWrapper zzk() {
    return ObjectWrapper.wrap(this.zza.getView());
  }
  
  public final boolean zzl() {
    return this.zza.isAdded();
  }
  
  public final boolean zzm() {
    return this.zza.isDetached();
  }
  
  public final boolean zzn() {
    return this.zza.isHidden();
  }
  
  public final boolean zzo() {
    return this.zza.isInLayout();
  }
  
  public final boolean zzp() {
    return this.zza.isRemoving();
  }
  
  public final boolean zzq() {
    return this.zza.isResumed();
  }
  
  public final boolean zzr() {
    return this.zza.isVisible();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\dynamic\FragmentWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */