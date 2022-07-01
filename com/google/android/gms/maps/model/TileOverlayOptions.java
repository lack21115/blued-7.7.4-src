package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.maps.zzaf;
import com.google.android.gms.internal.maps.zzag;

public final class TileOverlayOptions extends AbstractSafeParcelable {
  public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new zzu();
  
  private float zzcs;
  
  private boolean zzct;
  
  private float zzda;
  
  private zzaf zzei;
  
  private TileProvider zzej;
  
  private boolean zzek;
  
  public TileOverlayOptions() {
    this.zzct = true;
    this.zzek = true;
    this.zzda = 0.0F;
  }
  
  TileOverlayOptions(IBinder paramIBinder, boolean paramBoolean1, float paramFloat1, boolean paramBoolean2, float paramFloat2) {
    zzs zzs;
    this.zzct = true;
    this.zzek = true;
    this.zzda = 0.0F;
    this.zzei = zzag.zzk(paramIBinder);
    if (this.zzei == null) {
      paramIBinder = null;
    } else {
      zzs = new zzs(this);
    } 
    this.zzej = zzs;
    this.zzct = paramBoolean1;
    this.zzcs = paramFloat1;
    this.zzek = paramBoolean2;
    this.zzda = paramFloat2;
  }
  
  public final TileOverlayOptions fadeIn(boolean paramBoolean) {
    this.zzek = paramBoolean;
    return this;
  }
  
  public final boolean getFadeIn() {
    return this.zzek;
  }
  
  public final TileProvider getTileProvider() {
    return this.zzej;
  }
  
  public final float getTransparency() {
    return this.zzda;
  }
  
  public final float getZIndex() {
    return this.zzcs;
  }
  
  public final boolean isVisible() {
    return this.zzct;
  }
  
  public final TileOverlayOptions tileProvider(TileProvider paramTileProvider) {
    zzt zzt;
    this.zzej = paramTileProvider;
    if (this.zzej == null) {
      paramTileProvider = null;
    } else {
      zzt = new zzt(this, paramTileProvider);
    } 
    this.zzei = (zzaf)zzt;
    return this;
  }
  
  public final TileOverlayOptions transparency(float paramFloat) {
    boolean bool;
    if (paramFloat >= 0.0F && paramFloat <= 1.0F) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Transparency must be in the range [0..1]");
    this.zzda = paramFloat;
    return this;
  }
  
  public final TileOverlayOptions visible(boolean paramBoolean) {
    this.zzct = paramBoolean;
    return this;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeIBinder(paramParcel, 2, this.zzei.asBinder(), false);
    SafeParcelWriter.writeBoolean(paramParcel, 3, isVisible());
    SafeParcelWriter.writeFloat(paramParcel, 4, getZIndex());
    SafeParcelWriter.writeBoolean(paramParcel, 5, getFadeIn());
    SafeParcelWriter.writeFloat(paramParcel, 6, getTransparency());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final TileOverlayOptions zIndex(float paramFloat) {
    this.zzcs = paramFloat;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\TileOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */