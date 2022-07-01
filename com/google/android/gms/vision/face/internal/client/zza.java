package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.zzdlc;
import com.google.android.gms.internal.zzdld;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import java.nio.ByteBuffer;

public final class zza extends zzdlc {
  private final zzc zzlhi;
  
  public zza(Context paramContext, zzc paramzzc) {
    super(paramContext, "FaceNativeHandle");
    this.zzlhi = paramzzc;
    zzblo();
  }
  
  private static Landmark[] zza(FaceParcel paramFaceParcel) {
    LandmarkParcel[] arrayOfLandmarkParcel = paramFaceParcel.zzlhl;
    int i = 0;
    if (arrayOfLandmarkParcel == null)
      return new Landmark[0]; 
    Landmark[] arrayOfLandmark = new Landmark[arrayOfLandmarkParcel.length];
    while (i < arrayOfLandmarkParcel.length) {
      LandmarkParcel landmarkParcel = arrayOfLandmarkParcel[i];
      arrayOfLandmark[i] = new Landmark(new PointF(landmarkParcel.x, landmarkParcel.y), landmarkParcel.type);
      i++;
    } 
    return arrayOfLandmark;
  }
  
  public final Face[] zzb(ByteBuffer paramByteBuffer, zzdld paramzzdld) {
    boolean bool = isOperational();
    int i = 0;
    if (!bool)
      return new Face[0]; 
    try {
      IObjectWrapper iObjectWrapper = zzn.zzz(paramByteBuffer);
      FaceParcel[] arrayOfFaceParcel = ((zze)zzblo()).zzc(iObjectWrapper, paramzzdld);
      Face[] arrayOfFace = new Face[arrayOfFaceParcel.length];
      while (i < arrayOfFaceParcel.length) {
        FaceParcel faceParcel = arrayOfFaceParcel[i];
        int j = faceParcel.id;
        PointF pointF = new PointF(faceParcel.centerX, faceParcel.centerY);
        float f1 = faceParcel.width;
        float f2 = faceParcel.height;
        float f3 = faceParcel.zzlhj;
        f3 = faceParcel.zzlhk;
        Landmark[] arrayOfLandmark = zza(faceParcel);
        float f4 = faceParcel.zzlhm;
        f4 = faceParcel.zzlhn;
        arrayOfFace[i] = new Face(j, pointF, f1, f2, f3, arrayOfLandmark, faceParcel.zzlho);
        i++;
      } 
      return arrayOfFace;
    } catch (RemoteException remoteException) {
      Log.e("FaceNativeHandle", "Could not call native face detector", (Throwable)remoteException);
      return new Face[0];
    } 
  }
  
  protected final void zzbll() {
    ((zze)zzblo()).zzblm();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\face\internal\client\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */