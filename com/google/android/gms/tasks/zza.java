package com.google.android.gms.tasks;

final class zza extends CancellationToken {
  private final zzu<Void> zza = new zzu<Void>();
  
  public final boolean isCancellationRequested() {
    return this.zza.isComplete();
  }
  
  public final CancellationToken onCanceledRequested(OnTokenCanceledListener paramOnTokenCanceledListener) {
    this.zza.addOnSuccessListener(new zzb(this, paramOnTokenCanceledListener));
    return this;
  }
  
  public final void zza() {
    this.zza.zzb((Void)null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */