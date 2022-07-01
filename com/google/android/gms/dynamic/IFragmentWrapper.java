package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

public interface IFragmentWrapper extends IInterface {
  IObjectWrapper zza() throws RemoteException;
  
  void zza(Intent paramIntent) throws RemoteException;
  
  void zza(Intent paramIntent, int paramInt) throws RemoteException;
  
  void zza(IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  void zza(boolean paramBoolean) throws RemoteException;
  
  Bundle zzb() throws RemoteException;
  
  void zzb(IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  void zzb(boolean paramBoolean) throws RemoteException;
  
  int zzc() throws RemoteException;
  
  void zzc(boolean paramBoolean) throws RemoteException;
  
  IFragmentWrapper zzd() throws RemoteException;
  
  void zzd(boolean paramBoolean) throws RemoteException;
  
  IObjectWrapper zze() throws RemoteException;
  
  boolean zzf() throws RemoteException;
  
  String zzg() throws RemoteException;
  
  IFragmentWrapper zzh() throws RemoteException;
  
  int zzi() throws RemoteException;
  
  boolean zzj() throws RemoteException;
  
  IObjectWrapper zzk() throws RemoteException;
  
  boolean zzl() throws RemoteException;
  
  boolean zzm() throws RemoteException;
  
  boolean zzn() throws RemoteException;
  
  boolean zzo() throws RemoteException;
  
  boolean zzp() throws RemoteException;
  
  boolean zzq() throws RemoteException;
  
  boolean zzr() throws RemoteException;
  
  public static abstract class Stub extends com.google.android.gms.internal.common.zza implements IFragmentWrapper {
    public Stub() {
      super("com.google.android.gms.dynamic.IFragmentWrapper");
    }
    
    public static IFragmentWrapper asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      return (iInterface instanceof IFragmentWrapper) ? (IFragmentWrapper)iInterface : new zza(param1IBinder);
    }
    
    public final boolean zza(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      IObjectWrapper iObjectWrapper3;
      IFragmentWrapper iFragmentWrapper2;
      String str;
      IObjectWrapper iObjectWrapper2;
      IFragmentWrapper iFragmentWrapper1;
      Bundle bundle;
      boolean bool;
      switch (param1Int1) {
        default:
          return false;
        case 27:
          zzb(IObjectWrapper.Stub.asInterface(param1Parcel1.readStrongBinder()));
          param1Parcel2.writeNoException();
          return true;
        case 26:
          zza((Intent)zzd.zza(param1Parcel1, Intent.CREATOR), param1Parcel1.readInt());
          param1Parcel2.writeNoException();
          return true;
        case 25:
          zza((Intent)zzd.zza(param1Parcel1, Intent.CREATOR));
          param1Parcel2.writeNoException();
          return true;
        case 24:
          zzd(zzd.zza(param1Parcel1));
          param1Parcel2.writeNoException();
          return true;
        case 23:
          zzc(zzd.zza(param1Parcel1));
          param1Parcel2.writeNoException();
          return true;
        case 22:
          zzb(zzd.zza(param1Parcel1));
          param1Parcel2.writeNoException();
          return true;
        case 21:
          zza(zzd.zza(param1Parcel1));
          param1Parcel2.writeNoException();
          return true;
        case 20:
          zza(IObjectWrapper.Stub.asInterface(param1Parcel1.readStrongBinder()));
          param1Parcel2.writeNoException();
          return true;
        case 19:
          bool = zzr();
          param1Parcel2.writeNoException();
          zzd.zza(param1Parcel2, bool);
          return true;
        case 18:
          bool = zzq();
          param1Parcel2.writeNoException();
          zzd.zza(param1Parcel2, bool);
          return true;
        case 17:
          bool = zzp();
          param1Parcel2.writeNoException();
          zzd.zza(param1Parcel2, bool);
          return true;
        case 16:
          bool = zzo();
          param1Parcel2.writeNoException();
          zzd.zza(param1Parcel2, bool);
          return true;
        case 15:
          bool = zzn();
          param1Parcel2.writeNoException();
          zzd.zza(param1Parcel2, bool);
          return true;
        case 14:
          bool = zzm();
          param1Parcel2.writeNoException();
          zzd.zza(param1Parcel2, bool);
          return true;
        case 13:
          bool = zzl();
          param1Parcel2.writeNoException();
          zzd.zza(param1Parcel2, bool);
          return true;
        case 12:
          iObjectWrapper3 = zzk();
          param1Parcel2.writeNoException();
          zzd.zza(param1Parcel2, iObjectWrapper3);
          return true;
        case 11:
          bool = zzj();
          param1Parcel2.writeNoException();
          zzd.zza(param1Parcel2, bool);
          return true;
        case 10:
          param1Int1 = zzi();
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 9:
          iFragmentWrapper2 = zzh();
          param1Parcel2.writeNoException();
          zzd.zza(param1Parcel2, iFragmentWrapper2);
          return true;
        case 8:
          str = zzg();
          param1Parcel2.writeNoException();
          param1Parcel2.writeString(str);
          return true;
        case 7:
          bool = zzf();
          param1Parcel2.writeNoException();
          zzd.zza(param1Parcel2, bool);
          return true;
        case 6:
          iObjectWrapper2 = zze();
          param1Parcel2.writeNoException();
          zzd.zza(param1Parcel2, iObjectWrapper2);
          return true;
        case 5:
          iFragmentWrapper1 = zzd();
          param1Parcel2.writeNoException();
          zzd.zza(param1Parcel2, iFragmentWrapper1);
          return true;
        case 4:
          param1Int1 = zzc();
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 3:
          bundle = zzb();
          param1Parcel2.writeNoException();
          zzd.zzb(param1Parcel2, (Parcelable)bundle);
          return true;
        case 2:
          break;
      } 
      IObjectWrapper iObjectWrapper1 = zza();
      param1Parcel2.writeNoException();
      zzd.zza(param1Parcel2, iObjectWrapper1);
      return true;
    }
    
    public static final class zza extends zzb implements IFragmentWrapper {
      zza(IBinder param2IBinder) {
        super(param2IBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
      }
      
      public final IObjectWrapper zza() throws RemoteException {
        Parcel parcel = zza(2, a_());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
      }
      
      public final void zza(Intent param2Intent) throws RemoteException {
        Parcel parcel = a_();
        zzd.zza(parcel, (Parcelable)param2Intent);
        zzb(25, parcel);
      }
      
      public final void zza(Intent param2Intent, int param2Int) throws RemoteException {
        Parcel parcel = a_();
        zzd.zza(parcel, (Parcelable)param2Intent);
        parcel.writeInt(param2Int);
        zzb(26, parcel);
      }
      
      public final void zza(IObjectWrapper param2IObjectWrapper) throws RemoteException {
        Parcel parcel = a_();
        zzd.zza(parcel, param2IObjectWrapper);
        zzb(20, parcel);
      }
      
      public final void zza(boolean param2Boolean) throws RemoteException {
        Parcel parcel = a_();
        zzd.zza(parcel, param2Boolean);
        zzb(21, parcel);
      }
      
      public final Bundle zzb() throws RemoteException {
        Parcel parcel = zza(3, a_());
        Bundle bundle = (Bundle)zzd.zza(parcel, Bundle.CREATOR);
        parcel.recycle();
        return bundle;
      }
      
      public final void zzb(IObjectWrapper param2IObjectWrapper) throws RemoteException {
        Parcel parcel = a_();
        zzd.zza(parcel, param2IObjectWrapper);
        zzb(27, parcel);
      }
      
      public final void zzb(boolean param2Boolean) throws RemoteException {
        Parcel parcel = a_();
        zzd.zza(parcel, param2Boolean);
        zzb(22, parcel);
      }
      
      public final int zzc() throws RemoteException {
        Parcel parcel = zza(4, a_());
        int i = parcel.readInt();
        parcel.recycle();
        return i;
      }
      
      public final void zzc(boolean param2Boolean) throws RemoteException {
        Parcel parcel = a_();
        zzd.zza(parcel, param2Boolean);
        zzb(23, parcel);
      }
      
      public final IFragmentWrapper zzd() throws RemoteException {
        Parcel parcel = zza(5, a_());
        IFragmentWrapper iFragmentWrapper = IFragmentWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iFragmentWrapper;
      }
      
      public final void zzd(boolean param2Boolean) throws RemoteException {
        Parcel parcel = a_();
        zzd.zza(parcel, param2Boolean);
        zzb(24, parcel);
      }
      
      public final IObjectWrapper zze() throws RemoteException {
        Parcel parcel = zza(6, a_());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
      }
      
      public final boolean zzf() throws RemoteException {
        Parcel parcel = zza(7, a_());
        boolean bool = zzd.zza(parcel);
        parcel.recycle();
        return bool;
      }
      
      public final String zzg() throws RemoteException {
        Parcel parcel = zza(8, a_());
        String str = parcel.readString();
        parcel.recycle();
        return str;
      }
      
      public final IFragmentWrapper zzh() throws RemoteException {
        Parcel parcel = zza(9, a_());
        IFragmentWrapper iFragmentWrapper = IFragmentWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iFragmentWrapper;
      }
      
      public final int zzi() throws RemoteException {
        Parcel parcel = zza(10, a_());
        int i = parcel.readInt();
        parcel.recycle();
        return i;
      }
      
      public final boolean zzj() throws RemoteException {
        Parcel parcel = zza(11, a_());
        boolean bool = zzd.zza(parcel);
        parcel.recycle();
        return bool;
      }
      
      public final IObjectWrapper zzk() throws RemoteException {
        Parcel parcel = zza(12, a_());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
      }
      
      public final boolean zzl() throws RemoteException {
        Parcel parcel = zza(13, a_());
        boolean bool = zzd.zza(parcel);
        parcel.recycle();
        return bool;
      }
      
      public final boolean zzm() throws RemoteException {
        Parcel parcel = zza(14, a_());
        boolean bool = zzd.zza(parcel);
        parcel.recycle();
        return bool;
      }
      
      public final boolean zzn() throws RemoteException {
        Parcel parcel = zza(15, a_());
        boolean bool = zzd.zza(parcel);
        parcel.recycle();
        return bool;
      }
      
      public final boolean zzo() throws RemoteException {
        Parcel parcel = zza(16, a_());
        boolean bool = zzd.zza(parcel);
        parcel.recycle();
        return bool;
      }
      
      public final boolean zzp() throws RemoteException {
        Parcel parcel = zza(17, a_());
        boolean bool = zzd.zza(parcel);
        parcel.recycle();
        return bool;
      }
      
      public final boolean zzq() throws RemoteException {
        Parcel parcel = zza(18, a_());
        boolean bool = zzd.zza(parcel);
        parcel.recycle();
        return bool;
      }
      
      public final boolean zzr() throws RemoteException {
        Parcel parcel = zza(19, a_());
        boolean bool = zzd.zza(parcel);
        parcel.recycle();
        return bool;
      }
    }
  }
  
  public static final class zza extends zzb implements IFragmentWrapper {
    zza(IBinder param1IBinder) {
      super(param1IBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
    }
    
    public final IObjectWrapper zza() throws RemoteException {
      Parcel parcel = zza(2, a_());
      IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
      parcel.recycle();
      return iObjectWrapper;
    }
    
    public final void zza(Intent param1Intent) throws RemoteException {
      Parcel parcel = a_();
      zzd.zza(parcel, (Parcelable)param1Intent);
      zzb(25, parcel);
    }
    
    public final void zza(Intent param1Intent, int param1Int) throws RemoteException {
      Parcel parcel = a_();
      zzd.zza(parcel, (Parcelable)param1Intent);
      parcel.writeInt(param1Int);
      zzb(26, parcel);
    }
    
    public final void zza(IObjectWrapper param1IObjectWrapper) throws RemoteException {
      Parcel parcel = a_();
      zzd.zza(parcel, param1IObjectWrapper);
      zzb(20, parcel);
    }
    
    public final void zza(boolean param1Boolean) throws RemoteException {
      Parcel parcel = a_();
      zzd.zza(parcel, param1Boolean);
      zzb(21, parcel);
    }
    
    public final Bundle zzb() throws RemoteException {
      Parcel parcel = zza(3, a_());
      Bundle bundle = (Bundle)zzd.zza(parcel, Bundle.CREATOR);
      parcel.recycle();
      return bundle;
    }
    
    public final void zzb(IObjectWrapper param1IObjectWrapper) throws RemoteException {
      Parcel parcel = a_();
      zzd.zza(parcel, param1IObjectWrapper);
      zzb(27, parcel);
    }
    
    public final void zzb(boolean param1Boolean) throws RemoteException {
      Parcel parcel = a_();
      zzd.zza(parcel, param1Boolean);
      zzb(22, parcel);
    }
    
    public final int zzc() throws RemoteException {
      Parcel parcel = zza(4, a_());
      int i = parcel.readInt();
      parcel.recycle();
      return i;
    }
    
    public final void zzc(boolean param1Boolean) throws RemoteException {
      Parcel parcel = a_();
      zzd.zza(parcel, param1Boolean);
      zzb(23, parcel);
    }
    
    public final IFragmentWrapper zzd() throws RemoteException {
      Parcel parcel = zza(5, a_());
      IFragmentWrapper iFragmentWrapper = IFragmentWrapper.Stub.asInterface(parcel.readStrongBinder());
      parcel.recycle();
      return iFragmentWrapper;
    }
    
    public final void zzd(boolean param1Boolean) throws RemoteException {
      Parcel parcel = a_();
      zzd.zza(parcel, param1Boolean);
      zzb(24, parcel);
    }
    
    public final IObjectWrapper zze() throws RemoteException {
      Parcel parcel = zza(6, a_());
      IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
      parcel.recycle();
      return iObjectWrapper;
    }
    
    public final boolean zzf() throws RemoteException {
      Parcel parcel = zza(7, a_());
      boolean bool = zzd.zza(parcel);
      parcel.recycle();
      return bool;
    }
    
    public final String zzg() throws RemoteException {
      Parcel parcel = zza(8, a_());
      String str = parcel.readString();
      parcel.recycle();
      return str;
    }
    
    public final IFragmentWrapper zzh() throws RemoteException {
      Parcel parcel = zza(9, a_());
      IFragmentWrapper iFragmentWrapper = IFragmentWrapper.Stub.asInterface(parcel.readStrongBinder());
      parcel.recycle();
      return iFragmentWrapper;
    }
    
    public final int zzi() throws RemoteException {
      Parcel parcel = zza(10, a_());
      int i = parcel.readInt();
      parcel.recycle();
      return i;
    }
    
    public final boolean zzj() throws RemoteException {
      Parcel parcel = zza(11, a_());
      boolean bool = zzd.zza(parcel);
      parcel.recycle();
      return bool;
    }
    
    public final IObjectWrapper zzk() throws RemoteException {
      Parcel parcel = zza(12, a_());
      IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
      parcel.recycle();
      return iObjectWrapper;
    }
    
    public final boolean zzl() throws RemoteException {
      Parcel parcel = zza(13, a_());
      boolean bool = zzd.zza(parcel);
      parcel.recycle();
      return bool;
    }
    
    public final boolean zzm() throws RemoteException {
      Parcel parcel = zza(14, a_());
      boolean bool = zzd.zza(parcel);
      parcel.recycle();
      return bool;
    }
    
    public final boolean zzn() throws RemoteException {
      Parcel parcel = zza(15, a_());
      boolean bool = zzd.zza(parcel);
      parcel.recycle();
      return bool;
    }
    
    public final boolean zzo() throws RemoteException {
      Parcel parcel = zza(16, a_());
      boolean bool = zzd.zza(parcel);
      parcel.recycle();
      return bool;
    }
    
    public final boolean zzp() throws RemoteException {
      Parcel parcel = zza(17, a_());
      boolean bool = zzd.zza(parcel);
      parcel.recycle();
      return bool;
    }
    
    public final boolean zzq() throws RemoteException {
      Parcel parcel = zza(18, a_());
      boolean bool = zzd.zza(parcel);
      parcel.recycle();
      return bool;
    }
    
    public final boolean zzr() throws RemoteException {
      Parcel parcel = zza(19, a_());
      boolean bool = zzd.zza(parcel);
      parcel.recycle();
      return bool;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\dynamic\IFragmentWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */