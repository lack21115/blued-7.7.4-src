package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.d.ab;
import com.ss.android.socialbase.downloader.d.af;
import com.ss.android.socialbase.downloader.d.g;
import com.ss.android.socialbase.downloader.d.i;
import com.ss.android.socialbase.downloader.d.y;
import com.ss.android.socialbase.downloader.g.b;
import com.ss.android.socialbase.downloader.g.c;
import java.util.List;

public interface j extends IInterface {
  int a(String paramString1, String paramString2) throws RemoteException;
  
  List<c> a(String paramString) throws RemoteException;
  
  void a() throws RemoteException;
  
  void a(int paramInt) throws RemoteException;
  
  void a(int paramInt1, int paramInt2) throws RemoteException;
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) throws RemoteException;
  
  void a(int paramInt1, int paramInt2, int paramInt3, long paramLong) throws RemoteException;
  
  void a(int paramInt1, int paramInt2, long paramLong) throws RemoteException;
  
  void a(int paramInt1, int paramInt2, i parami, int paramInt3, boolean paramBoolean) throws RemoteException;
  
  void a(int paramInt, Notification paramNotification) throws RemoteException;
  
  void a(int paramInt, y paramy) throws RemoteException;
  
  void a(int paramInt, List<b> paramList) throws RemoteException;
  
  void a(int paramInt, boolean paramBoolean) throws RemoteException;
  
  void a(af paramaf) throws RemoteException;
  
  void a(com.ss.android.socialbase.downloader.g.a parama) throws RemoteException;
  
  void a(b paramb) throws RemoteException;
  
  void a(List<String> paramList) throws RemoteException;
  
  void a(boolean paramBoolean) throws RemoteException;
  
  boolean a(c paramc) throws RemoteException;
  
  c b(String paramString1, String paramString2) throws RemoteException;
  
  List<c> b(String paramString) throws RemoteException;
  
  void b(int paramInt1, int paramInt2, i parami, int paramInt3, boolean paramBoolean) throws RemoteException;
  
  void b(int paramInt, List<b> paramList) throws RemoteException;
  
  void b(int paramInt, boolean paramBoolean) throws RemoteException;
  
  boolean b() throws RemoteException;
  
  boolean b(int paramInt) throws RemoteException;
  
  boolean b(c paramc) throws RemoteException;
  
  List<c> c(String paramString) throws RemoteException;
  
  void c(int paramInt) throws RemoteException;
  
  void c(int paramInt, boolean paramBoolean) throws RemoteException;
  
  boolean c() throws RemoteException;
  
  List<c> d(String paramString) throws RemoteException;
  
  void d() throws RemoteException;
  
  void d(int paramInt) throws RemoteException;
  
  long e(int paramInt) throws RemoteException;
  
  List<c> e(String paramString) throws RemoteException;
  
  boolean e() throws RemoteException;
  
  int f(int paramInt) throws RemoteException;
  
  boolean g(int paramInt) throws RemoteException;
  
  c h(int paramInt) throws RemoteException;
  
  List<b> i(int paramInt) throws RemoteException;
  
  void j(int paramInt) throws RemoteException;
  
  boolean k(int paramInt) throws RemoteException;
  
  void l(int paramInt) throws RemoteException;
  
  int m(int paramInt) throws RemoteException;
  
  boolean n(int paramInt) throws RemoteException;
  
  void o(int paramInt) throws RemoteException;
  
  boolean p(int paramInt) throws RemoteException;
  
  y q(int paramInt) throws RemoteException;
  
  ab r(int paramInt) throws RemoteException;
  
  g s(int paramInt) throws RemoteException;
  
  public static abstract class a extends Binder implements j {
    public a() {
      attachInterface(this, "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
    }
    
    public static j a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
      return (iInterface != null && iInterface instanceof j) ? (j)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    static class a implements j {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public int a(String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          this.a.transact(14, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public List<c> a(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeString(param2String);
          this.a.transact(12, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.createTypedArrayList(c.CREATOR);
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          this.a.transact(7, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(int param2Int1, int param2Int2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          this.a.transact(46, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(int param2Int1, int param2Int2, int param2Int3, int param2Int4) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          parcel1.writeInt(param2Int3);
          parcel1.writeInt(param2Int4);
          this.a.transact(40, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(int param2Int1, int param2Int2, int param2Int3, long param2Long) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          parcel1.writeInt(param2Int3);
          parcel1.writeLong(param2Long);
          this.a.transact(39, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(int param2Int1, int param2Int2, long param2Long) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          parcel1.writeLong(param2Long);
          this.a.transact(38, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(int param2Int1, int param2Int2, i param2i, int param2Int3, boolean param2Boolean) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          if (param2i != null) {
            IBinder iBinder = param2i.asBinder();
          } else {
            param2i = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2i);
          parcel1.writeInt(param2Int3);
          if (param2Boolean) {
            param2Int1 = 1;
          } else {
            param2Int1 = 0;
          } 
          parcel1.writeInt(param2Int1);
          this.a.transact(22, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(int param2Int, Notification param2Notification) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          parcel.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel.writeInt(param2Int);
          if (param2Notification != null) {
            parcel.writeInt(1);
            param2Notification.writeToParcel(parcel, 0);
          } else {
            parcel.writeInt(0);
          } 
          this.a.transact(25, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public void a(int param2Int, y param2y) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          if (param2y != null) {
            IBinder iBinder = param2y.asBinder();
          } else {
            param2y = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2y);
          this.a.transact(49, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(int param2Int, List<b> param2List) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          parcel1.writeTypedList(param2List);
          this.a.transact(43, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(int param2Int, boolean param2Boolean) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          if (param2Boolean) {
            param2Int = 1;
          } else {
            param2Int = 0;
          } 
          parcel1.writeInt(param2Int);
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(af param2af) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          if (param2af != null) {
            IBinder iBinder = param2af.asBinder();
          } else {
            param2af = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2af);
          this.a.transact(45, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(com.ss.android.socialbase.downloader.g.a param2a) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          if (param2a != null) {
            IBinder iBinder = param2a.asBinder();
          } else {
            param2a = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2a);
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(b param2b) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          if (param2b != null) {
            parcel1.writeInt(1);
            param2b.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(34, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(List<String> param2List) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeStringList(param2List);
          this.a.transact(19, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a(boolean param2Boolean) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
          boolean bool;
          parcel.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          if (param2Boolean) {
            bool = true;
          } else {
            bool = false;
          } 
          parcel.writeInt(bool);
          this.a.transact(26, parcel, null, 1);
          return;
        } finally {
          parcel.recycle();
        } 
      }
      
      public boolean a(c param2c) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          boolean bool = true;
          if (param2c != null) {
            parcel1.writeInt(1);
            param2c.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(24, parcel1, parcel2, 0);
          parcel2.readException();
          int i = parcel2.readInt();
          if (i == 0)
            bool = false; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public IBinder asBinder() {
        return this.a;
      }
      
      public c b(String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          this.a.transact(15, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            c c = (c)c.CREATOR.createFromParcel(parcel2);
          } else {
            param2String1 = null;
          } 
          return (c)param2String1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public List<c> b(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeString(param2String);
          this.a.transact(16, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.createTypedArrayList(c.CREATOR);
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void b(int param2Int1, int param2Int2, i param2i, int param2Int3, boolean param2Boolean) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          if (param2i != null) {
            IBinder iBinder = param2i.asBinder();
          } else {
            param2i = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2i);
          parcel1.writeInt(param2Int3);
          if (param2Boolean) {
            param2Int1 = 1;
          } else {
            param2Int1 = 0;
          } 
          parcel1.writeInt(param2Int1);
          this.a.transact(23, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void b(int param2Int, List<b> param2List) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          parcel1.writeTypedList(param2List);
          this.a.transact(44, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void b(int param2Int, boolean param2Boolean) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          if (param2Boolean) {
            param2Int = 1;
          } else {
            param2Int = 0;
          } 
          parcel1.writeInt(param2Int);
          this.a.transact(20, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean b() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(27, parcel1, parcel2, 0);
          parcel2.readException();
          int i = parcel2.readInt();
          if (i != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean b(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int = parcel2.readInt();
          if (param2Int != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean b(c param2c) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          boolean bool = true;
          if (param2c != null) {
            parcel1.writeInt(1);
            param2c.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(35, parcel1, parcel2, 0);
          parcel2.readException();
          int i = parcel2.readInt();
          if (i == 0)
            bool = false; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public List<c> c(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeString(param2String);
          this.a.transact(17, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.createTypedArrayList(c.CREATOR);
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void c(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          this.a.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void c(int param2Int, boolean param2Boolean) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          if (param2Boolean) {
            param2Int = 1;
          } else {
            param2Int = 0;
          } 
          parcel1.writeInt(param2Int);
          this.a.transact(32, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean c() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(31, parcel1, parcel2, 0);
          parcel2.readException();
          int i = parcel2.readInt();
          if (i != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public List<c> d(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeString(param2String);
          this.a.transact(18, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.createTypedArrayList(c.CREATOR);
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void d() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          this.a.transact(42, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void d(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          this.a.transact(6, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public long e(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          this.a.transact(8, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readLong();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public List<c> e(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeString(param2String);
          this.a.transact(28, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.createTypedArrayList(c.CREATOR);
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean e() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(51, parcel1, parcel2, 0);
          parcel2.readException();
          int i = parcel2.readInt();
          if (i != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public int f(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          this.a.transact(9, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int = parcel2.readInt();
          return param2Int;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean g(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(10, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int = parcel2.readInt();
          if (param2Int != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public c h(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          c c;
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          this.a.transact(11, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            c = (c)c.CREATOR.createFromParcel(parcel2);
          } else {
            c = null;
          } 
          return c;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public List<b> i(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          this.a.transact(13, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.createTypedArrayList(b.CREATOR);
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void j(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          this.a.transact(21, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean k(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(29, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int = parcel2.readInt();
          if (param2Int != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void l(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          this.a.transact(30, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public int m(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          this.a.transact(33, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int = parcel2.readInt();
          return param2Int;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean n(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(36, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int = parcel2.readInt();
          if (param2Int != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void o(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          this.a.transact(37, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean p(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(41, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int = parcel2.readInt();
          if (param2Int != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public y q(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          this.a.transact(47, parcel1, parcel2, 0);
          parcel2.readException();
          return y.a.a(parcel2.readStrongBinder());
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public ab r(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          this.a.transact(48, parcel1, parcel2, 0);
          parcel2.readException();
          return ab.a.a(parcel2.readStrongBinder());
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public g s(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
          parcel1.writeInt(param2Int);
          this.a.transact(50, parcel1, parcel2, 0);
          parcel2.readException();
          return g.a.a(parcel2.readStrongBinder());
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  static class a implements j {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public int a(String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        this.a.transact(14, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public List<c> a(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeString(param1String);
        this.a.transact(12, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.createTypedArrayList(c.CREATOR);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        this.a.transact(7, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(int param1Int1, int param1Int2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        this.a.transact(46, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(int param1Int1, int param1Int2, int param1Int3, int param1Int4) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        parcel1.writeInt(param1Int3);
        parcel1.writeInt(param1Int4);
        this.a.transact(40, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(int param1Int1, int param1Int2, int param1Int3, long param1Long) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        parcel1.writeInt(param1Int3);
        parcel1.writeLong(param1Long);
        this.a.transact(39, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(int param1Int1, int param1Int2, long param1Long) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        parcel1.writeLong(param1Long);
        this.a.transact(38, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(int param1Int1, int param1Int2, i param1i, int param1Int3, boolean param1Boolean) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        if (param1i != null) {
          IBinder iBinder = param1i.asBinder();
        } else {
          param1i = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1i);
        parcel1.writeInt(param1Int3);
        if (param1Boolean) {
          param1Int1 = 1;
        } else {
          param1Int1 = 0;
        } 
        parcel1.writeInt(param1Int1);
        this.a.transact(22, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(int param1Int, Notification param1Notification) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        parcel.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel.writeInt(param1Int);
        if (param1Notification != null) {
          parcel.writeInt(1);
          param1Notification.writeToParcel(parcel, 0);
        } else {
          parcel.writeInt(0);
        } 
        this.a.transact(25, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public void a(int param1Int, y param1y) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        if (param1y != null) {
          IBinder iBinder = param1y.asBinder();
        } else {
          param1y = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1y);
        this.a.transact(49, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(int param1Int, List<b> param1List) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        parcel1.writeTypedList(param1List);
        this.a.transact(43, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(int param1Int, boolean param1Boolean) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        if (param1Boolean) {
          param1Int = 1;
        } else {
          param1Int = 0;
        } 
        parcel1.writeInt(param1Int);
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(af param1af) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        if (param1af != null) {
          IBinder iBinder = param1af.asBinder();
        } else {
          param1af = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1af);
        this.a.transact(45, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(com.ss.android.socialbase.downloader.g.a param1a) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        if (param1a != null) {
          IBinder iBinder = param1a.asBinder();
        } else {
          param1a = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1a);
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(b param1b) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        if (param1b != null) {
          parcel1.writeInt(1);
          param1b.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(34, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(List<String> param1List) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeStringList(param1List);
        this.a.transact(19, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a(boolean param1Boolean) throws RemoteException {
      Parcel parcel = Parcel.obtain();
      try {
        boolean bool;
        parcel.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        if (param1Boolean) {
          bool = true;
        } else {
          bool = false;
        } 
        parcel.writeInt(bool);
        this.a.transact(26, parcel, null, 1);
        return;
      } finally {
        parcel.recycle();
      } 
    }
    
    public boolean a(c param1c) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        boolean bool = true;
        if (param1c != null) {
          parcel1.writeInt(1);
          param1c.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(24, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        if (i == 0)
          bool = false; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public IBinder asBinder() {
      return this.a;
    }
    
    public c b(String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        this.a.transact(15, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          c c = (c)c.CREATOR.createFromParcel(parcel2);
        } else {
          param1String1 = null;
        } 
        return (c)param1String1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public List<c> b(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeString(param1String);
        this.a.transact(16, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.createTypedArrayList(c.CREATOR);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void b(int param1Int1, int param1Int2, i param1i, int param1Int3, boolean param1Boolean) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        if (param1i != null) {
          IBinder iBinder = param1i.asBinder();
        } else {
          param1i = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1i);
        parcel1.writeInt(param1Int3);
        if (param1Boolean) {
          param1Int1 = 1;
        } else {
          param1Int1 = 0;
        } 
        parcel1.writeInt(param1Int1);
        this.a.transact(23, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void b(int param1Int, List<b> param1List) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        parcel1.writeTypedList(param1List);
        this.a.transact(44, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void b(int param1Int, boolean param1Boolean) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        if (param1Boolean) {
          param1Int = 1;
        } else {
          param1Int = 0;
        } 
        parcel1.writeInt(param1Int);
        this.a.transact(20, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean b() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(27, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        if (i != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean b(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        if (param1Int != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean b(c param1c) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        boolean bool = true;
        if (param1c != null) {
          parcel1.writeInt(1);
          param1c.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(35, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        if (i == 0)
          bool = false; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public List<c> c(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeString(param1String);
        this.a.transact(17, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.createTypedArrayList(c.CREATOR);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void c(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        this.a.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void c(int param1Int, boolean param1Boolean) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        if (param1Boolean) {
          param1Int = 1;
        } else {
          param1Int = 0;
        } 
        parcel1.writeInt(param1Int);
        this.a.transact(32, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean c() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(31, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        if (i != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public List<c> d(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeString(param1String);
        this.a.transact(18, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.createTypedArrayList(c.CREATOR);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void d() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        this.a.transact(42, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void d(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        this.a.transact(6, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public long e(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        this.a.transact(8, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readLong();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public List<c> e(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeString(param1String);
        this.a.transact(28, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.createTypedArrayList(c.CREATOR);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean e() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(51, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        if (i != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public int f(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        this.a.transact(9, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        return param1Int;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean g(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(10, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        if (param1Int != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public c h(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        c c;
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        this.a.transact(11, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          c = (c)c.CREATOR.createFromParcel(parcel2);
        } else {
          c = null;
        } 
        return c;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public List<b> i(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        this.a.transact(13, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.createTypedArrayList(b.CREATOR);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void j(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        this.a.transact(21, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean k(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(29, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        if (param1Int != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void l(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        this.a.transact(30, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public int m(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        this.a.transact(33, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        return param1Int;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean n(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(36, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        if (param1Int != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void o(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        this.a.transact(37, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean p(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(41, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        if (param1Int != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public y q(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        this.a.transact(47, parcel1, parcel2, 0);
        parcel2.readException();
        return y.a.a(parcel2.readStrongBinder());
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public ab r(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        this.a.transact(48, parcel1, parcel2, 0);
        parcel2.readException();
        return ab.a.a(parcel2.readStrongBinder());
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public g s(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        parcel1.writeInt(param1Int);
        this.a.transact(50, parcel1, parcel2, 0);
        parcel2.readException();
        return g.a.a(parcel2.readStrongBinder());
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\downloader\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */