package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IGmsServiceBroker extends IInterface {
  void getService(IGmsCallbacks paramIGmsCallbacks, GetServiceRequest paramGetServiceRequest) throws RemoteException;
  
  public static abstract class Stub extends Binder implements IGmsServiceBroker {
    public Stub() {
      attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      zzv zzv;
      Bundle bundle;
      IGmsCallbacks iGmsCallbacks;
      if (param1Int1 > 16777215)
        return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); 
      param1Parcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      IBinder iBinder = param1Parcel1.readStrongBinder();
      GetServiceRequest getServiceRequest = null;
      if (iBinder == null) {
        iBinder = null;
      } else {
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
        if (iInterface instanceof IGmsCallbacks) {
          iGmsCallbacks = (IGmsCallbacks)iInterface;
        } else {
          iGmsCallbacks = new zzo((IBinder)iGmsCallbacks);
        } 
      } 
      if (param1Int1 == 46) {
        if (param1Parcel1.readInt() != 0)
          getServiceRequest = (GetServiceRequest)GetServiceRequest.CREATOR.createFromParcel(param1Parcel1); 
        getService(iGmsCallbacks, getServiceRequest);
        param1Parcel2.writeNoException();
        return true;
      } 
      if (param1Int1 == 47) {
        if (param1Parcel1.readInt() != 0)
          zzv = (zzv)zzv.CREATOR.createFromParcel(param1Parcel1); 
        throw new UnsupportedOperationException();
      } 
      zzv.readInt();
      if (param1Int1 != 4)
        zzv.readString(); 
      if (param1Int1 != 1) {
        if (param1Int1 != 2 && param1Int1 != 23 && param1Int1 != 25 && param1Int1 != 27)
          if (param1Int1 != 30) {
            if (param1Int1 != 34) {
              if (param1Int1 != 41 && param1Int1 != 43 && param1Int1 != 37 && param1Int1 != 38)
                switch (param1Int1) {
                  default:
                    throw new UnsupportedOperationException();
                  case 19:
                    zzv.readStrongBinder();
                    if (zzv.readInt() != 0)
                      bundle = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)zzv); 
                  case 10:
                    bundle.readString();
                    bundle.createStringArray();
                  case 9:
                    bundle.readString();
                    bundle.createStringArray();
                    bundle.readString();
                    bundle.readStrongBinder();
                    bundle.readString();
                    if (bundle.readInt() != 0)
                      bundle = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle); 
                  case 20:
                    bundle.createStringArray();
                    bundle.readString();
                    if (bundle.readInt() != 0)
                      bundle = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle); 
                  case 5:
                  case 6:
                  case 7:
                  case 8:
                  case 11:
                  case 12:
                  case 13:
                  case 14:
                  case 15:
                  case 16:
                  case 17:
                  case 18:
                    break;
                }  
            } else {
              bundle.readString();
            } 
          } else {
          
          }  
        if (bundle.readInt() != 0)
          bundle = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle); 
      } 
      bundle.readString();
      bundle.createStringArray();
      bundle.readString();
      if (bundle.readInt() != 0)
        bundle = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle); 
    }
    
    static final class zza implements IGmsServiceBroker {
      private final IBinder zza;
      
      zza(IBinder param2IBinder) {
        this.zza = param2IBinder;
      }
      
      public final IBinder asBinder() {
        return this.zza;
      }
      
      public final void getService(IGmsCallbacks param2IGmsCallbacks, GetServiceRequest param2GetServiceRequest) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
          if (param2IGmsCallbacks != null) {
            IBinder iBinder = param2IGmsCallbacks.asBinder();
          } else {
            param2IGmsCallbacks = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2IGmsCallbacks);
          if (param2GetServiceRequest != null) {
            parcel1.writeInt(1);
            param2GetServiceRequest.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.zza.transact(46, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  static final class zza implements IGmsServiceBroker {
    private final IBinder zza;
    
    zza(IBinder param1IBinder) {
      this.zza = param1IBinder;
    }
    
    public final IBinder asBinder() {
      return this.zza;
    }
    
    public final void getService(IGmsCallbacks param1IGmsCallbacks, GetServiceRequest param1GetServiceRequest) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (param1IGmsCallbacks != null) {
          IBinder iBinder = param1IGmsCallbacks.asBinder();
        } else {
          param1IGmsCallbacks = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1IGmsCallbacks);
        if (param1GetServiceRequest != null) {
          parcel1.writeInt(1);
          param1GetServiceRequest.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.zza.transact(46, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\IGmsServiceBroker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */