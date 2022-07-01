package com.ss.android.socialbase.downloader.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.g.b;
import java.util.List;

public interface c extends IInterface {
  com.ss.android.socialbase.downloader.g.c a(int paramInt1, int paramInt2) throws RemoteException;
  
  com.ss.android.socialbase.downloader.g.c a(int paramInt, long paramLong) throws RemoteException;
  
  com.ss.android.socialbase.downloader.g.c a(int paramInt, long paramLong, String paramString1, String paramString2) throws RemoteException;
  
  List<com.ss.android.socialbase.downloader.g.c> a(String paramString) throws RemoteException;
  
  void a() throws RemoteException;
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) throws RemoteException;
  
  void a(int paramInt1, int paramInt2, int paramInt3, long paramLong) throws RemoteException;
  
  void a(int paramInt1, int paramInt2, long paramLong) throws RemoteException;
  
  void a(int paramInt, List<b> paramList) throws RemoteException;
  
  void a(b paramb) throws RemoteException;
  
  void a(b paramb) throws RemoteException;
  
  boolean a(int paramInt) throws RemoteException;
  
  boolean a(com.ss.android.socialbase.downloader.g.c paramc) throws RemoteException;
  
  com.ss.android.socialbase.downloader.g.c b(int paramInt) throws RemoteException;
  
  com.ss.android.socialbase.downloader.g.c b(int paramInt, long paramLong) throws RemoteException;
  
  List<com.ss.android.socialbase.downloader.g.c> b(String paramString) throws RemoteException;
  
  void b() throws RemoteException;
  
  void b(int paramInt, List<b> paramList) throws RemoteException;
  
  void b(b paramb) throws RemoteException;
  
  void b(com.ss.android.socialbase.downloader.g.c paramc) throws RemoteException;
  
  com.ss.android.socialbase.downloader.g.c c(int paramInt, long paramLong) throws RemoteException;
  
  List<b> c(int paramInt) throws RemoteException;
  
  List<com.ss.android.socialbase.downloader.g.c> c(String paramString) throws RemoteException;
  
  boolean c() throws RemoteException;
  
  com.ss.android.socialbase.downloader.g.c d(int paramInt, long paramLong) throws RemoteException;
  
  List<com.ss.android.socialbase.downloader.g.c> d(String paramString) throws RemoteException;
  
  void d(int paramInt) throws RemoteException;
  
  boolean d() throws RemoteException;
  
  com.ss.android.socialbase.downloader.g.c e(int paramInt, long paramLong) throws RemoteException;
  
  boolean e(int paramInt) throws RemoteException;
  
  boolean f(int paramInt) throws RemoteException;
  
  com.ss.android.socialbase.downloader.g.c g(int paramInt) throws RemoteException;
  
  com.ss.android.socialbase.downloader.g.c h(int paramInt) throws RemoteException;
  
  com.ss.android.socialbase.downloader.g.c i(int paramInt) throws RemoteException;
  
  com.ss.android.socialbase.downloader.g.c j(int paramInt) throws RemoteException;
  
  public static abstract class a extends Binder implements c {
    public a() {
      attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
    }
    
    public static c a(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
      return (iInterface != null && iInterface instanceof c) ? (c)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    static class a implements c {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public com.ss.android.socialbase.downloader.g.c a(int param2Int1, int param2Int2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          com.ss.android.socialbase.downloader.g.c c1;
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          this.a.transact(15, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
          } else {
            c1 = null;
          } 
          return c1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public com.ss.android.socialbase.downloader.g.c a(int param2Int, long param2Long) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          com.ss.android.socialbase.downloader.g.c c1;
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          parcel1.writeLong(param2Long);
          this.a.transact(22, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
          } else {
            c1 = null;
          } 
          return c1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public com.ss.android.socialbase.downloader.g.c a(int param2Int, long param2Long, String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          parcel1.writeLong(param2Long);
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          this.a.transact(21, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            com.ss.android.socialbase.downloader.g.c c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
          } else {
            param2String1 = null;
          } 
          return (com.ss.android.socialbase.downloader.g.c)param2String1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public List<com.ss.android.socialbase.downloader.g.c> a(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeString(param2String);
          this.a.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.createTypedArrayList(com.ss.android.socialbase.downloader.g.c.CREATOR);
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void a() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          this.a.transact(1, parcel1, parcel2, 0);
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
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          parcel1.writeInt(param2Int3);
          parcel1.writeInt(param2Int4);
          this.a.transact(14, parcel1, parcel2, 0);
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
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          parcel1.writeInt(param2Int3);
          parcel1.writeLong(param2Long);
          this.a.transact(13, parcel1, parcel2, 0);
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
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          parcel1.writeLong(param2Long);
          this.a.transact(12, parcel1, parcel2, 0);
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
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          parcel1.writeTypedList(param2List);
          this.a.transact(33, parcel1, parcel2, 0);
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
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          if (param2b != null) {
            IBinder iBinder = param2b.asBinder();
          } else {
            param2b = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2b);
          this.a.transact(35, parcel1, parcel2, 0);
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
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          if (param2b != null) {
            parcel1.writeInt(1);
            param2b.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(10, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean a(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(2, parcel1, parcel2, 0);
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
      
      public boolean a(com.ss.android.socialbase.downloader.g.c param2c) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          boolean bool = true;
          if (param2c != null) {
            parcel1.writeInt(1);
            param2c.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(16, parcel1, parcel2, 0);
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
      
      public com.ss.android.socialbase.downloader.g.c b(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          com.ss.android.socialbase.downloader.g.c c1;
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
          } else {
            c1 = null;
          } 
          return c1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public com.ss.android.socialbase.downloader.g.c b(int param2Int, long param2Long) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          com.ss.android.socialbase.downloader.g.c c1;
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          parcel1.writeLong(param2Long);
          this.a.transact(23, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
          } else {
            c1 = null;
          } 
          return c1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public List<com.ss.android.socialbase.downloader.g.c> b(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeString(param2String);
          this.a.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.createTypedArrayList(com.ss.android.socialbase.downloader.g.c.CREATOR);
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void b() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          this.a.transact(19, parcel1, parcel2, 0);
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
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          parcel1.writeTypedList(param2List);
          this.a.transact(34, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void b(b param2b) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          if (param2b != null) {
            parcel1.writeInt(1);
            param2b.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(11, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void b(com.ss.android.socialbase.downloader.g.c param2c) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          if (param2c != null) {
            parcel1.writeInt(1);
            param2c.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(32, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public com.ss.android.socialbase.downloader.g.c c(int param2Int, long param2Long) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          com.ss.android.socialbase.downloader.g.c c1;
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          parcel1.writeLong(param2Long);
          this.a.transact(25, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
          } else {
            c1 = null;
          } 
          return c1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public List<b> c(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          this.a.transact(8, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.createTypedArrayList(b.CREATOR);
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public List<com.ss.android.socialbase.downloader.g.c> c(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeString(param2String);
          this.a.transact(6, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.createTypedArrayList(com.ss.android.socialbase.downloader.g.c.CREATOR);
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean c() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(30, parcel1, parcel2, 0);
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
      
      public com.ss.android.socialbase.downloader.g.c d(int param2Int, long param2Long) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          com.ss.android.socialbase.downloader.g.c c1;
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          parcel1.writeLong(param2Long);
          this.a.transact(26, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
          } else {
            c1 = null;
          } 
          return c1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public List<com.ss.android.socialbase.downloader.g.c> d(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeString(param2String);
          this.a.transact(7, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.createTypedArrayList(com.ss.android.socialbase.downloader.g.c.CREATOR);
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void d(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          this.a.transact(9, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean d() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
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
      
      public com.ss.android.socialbase.downloader.g.c e(int param2Int, long param2Long) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          com.ss.android.socialbase.downloader.g.c c1;
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          parcel1.writeLong(param2Long);
          this.a.transact(27, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
          } else {
            c1 = null;
          } 
          return c1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean e(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(17, parcel1, parcel2, 0);
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
      
      public boolean f(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(18, parcel1, parcel2, 0);
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
      
      public com.ss.android.socialbase.downloader.g.c g(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          com.ss.android.socialbase.downloader.g.c c1;
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          this.a.transact(20, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
          } else {
            c1 = null;
          } 
          return c1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public com.ss.android.socialbase.downloader.g.c h(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          com.ss.android.socialbase.downloader.g.c c1;
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          this.a.transact(24, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
          } else {
            c1 = null;
          } 
          return c1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public com.ss.android.socialbase.downloader.g.c i(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          com.ss.android.socialbase.downloader.g.c c1;
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          this.a.transact(28, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
          } else {
            c1 = null;
          } 
          return c1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public com.ss.android.socialbase.downloader.g.c j(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          com.ss.android.socialbase.downloader.g.c c1;
          parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
          parcel1.writeInt(param2Int);
          this.a.transact(29, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
          } else {
            c1 = null;
          } 
          return c1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  static class a implements c {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public com.ss.android.socialbase.downloader.g.c a(int param1Int1, int param1Int2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        com.ss.android.socialbase.downloader.g.c c1;
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        this.a.transact(15, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
        } else {
          c1 = null;
        } 
        return c1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public com.ss.android.socialbase.downloader.g.c a(int param1Int, long param1Long) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        com.ss.android.socialbase.downloader.g.c c1;
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        parcel1.writeLong(param1Long);
        this.a.transact(22, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
        } else {
          c1 = null;
        } 
        return c1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public com.ss.android.socialbase.downloader.g.c a(int param1Int, long param1Long, String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        parcel1.writeLong(param1Long);
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        this.a.transact(21, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          com.ss.android.socialbase.downloader.g.c c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
        } else {
          param1String1 = null;
        } 
        return (com.ss.android.socialbase.downloader.g.c)param1String1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public List<com.ss.android.socialbase.downloader.g.c> a(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeString(param1String);
        this.a.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.createTypedArrayList(com.ss.android.socialbase.downloader.g.c.CREATOR);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void a() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        this.a.transact(1, parcel1, parcel2, 0);
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
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        parcel1.writeInt(param1Int3);
        parcel1.writeInt(param1Int4);
        this.a.transact(14, parcel1, parcel2, 0);
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
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        parcel1.writeInt(param1Int3);
        parcel1.writeLong(param1Long);
        this.a.transact(13, parcel1, parcel2, 0);
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
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        parcel1.writeLong(param1Long);
        this.a.transact(12, parcel1, parcel2, 0);
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
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        parcel1.writeTypedList(param1List);
        this.a.transact(33, parcel1, parcel2, 0);
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
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        if (param1b != null) {
          IBinder iBinder = param1b.asBinder();
        } else {
          param1b = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1b);
        this.a.transact(35, parcel1, parcel2, 0);
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
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        if (param1b != null) {
          parcel1.writeInt(1);
          param1b.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(10, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean a(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(2, parcel1, parcel2, 0);
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
    
    public boolean a(com.ss.android.socialbase.downloader.g.c param1c) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        boolean bool = true;
        if (param1c != null) {
          parcel1.writeInt(1);
          param1c.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(16, parcel1, parcel2, 0);
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
    
    public com.ss.android.socialbase.downloader.g.c b(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        com.ss.android.socialbase.downloader.g.c c1;
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
        } else {
          c1 = null;
        } 
        return c1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public com.ss.android.socialbase.downloader.g.c b(int param1Int, long param1Long) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        com.ss.android.socialbase.downloader.g.c c1;
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        parcel1.writeLong(param1Long);
        this.a.transact(23, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
        } else {
          c1 = null;
        } 
        return c1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public List<com.ss.android.socialbase.downloader.g.c> b(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeString(param1String);
        this.a.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.createTypedArrayList(com.ss.android.socialbase.downloader.g.c.CREATOR);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void b() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        this.a.transact(19, parcel1, parcel2, 0);
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
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        parcel1.writeTypedList(param1List);
        this.a.transact(34, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void b(b param1b) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        if (param1b != null) {
          parcel1.writeInt(1);
          param1b.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(11, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void b(com.ss.android.socialbase.downloader.g.c param1c) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        if (param1c != null) {
          parcel1.writeInt(1);
          param1c.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(32, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public com.ss.android.socialbase.downloader.g.c c(int param1Int, long param1Long) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        com.ss.android.socialbase.downloader.g.c c1;
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        parcel1.writeLong(param1Long);
        this.a.transact(25, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
        } else {
          c1 = null;
        } 
        return c1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public List<b> c(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        this.a.transact(8, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.createTypedArrayList(b.CREATOR);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public List<com.ss.android.socialbase.downloader.g.c> c(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeString(param1String);
        this.a.transact(6, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.createTypedArrayList(com.ss.android.socialbase.downloader.g.c.CREATOR);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean c() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(30, parcel1, parcel2, 0);
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
    
    public com.ss.android.socialbase.downloader.g.c d(int param1Int, long param1Long) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        com.ss.android.socialbase.downloader.g.c c1;
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        parcel1.writeLong(param1Long);
        this.a.transact(26, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
        } else {
          c1 = null;
        } 
        return c1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public List<com.ss.android.socialbase.downloader.g.c> d(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeString(param1String);
        this.a.transact(7, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.createTypedArrayList(com.ss.android.socialbase.downloader.g.c.CREATOR);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void d(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        this.a.transact(9, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean d() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
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
    
    public com.ss.android.socialbase.downloader.g.c e(int param1Int, long param1Long) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        com.ss.android.socialbase.downloader.g.c c1;
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        parcel1.writeLong(param1Long);
        this.a.transact(27, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
        } else {
          c1 = null;
        } 
        return c1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean e(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(17, parcel1, parcel2, 0);
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
    
    public boolean f(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(18, parcel1, parcel2, 0);
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
    
    public com.ss.android.socialbase.downloader.g.c g(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        com.ss.android.socialbase.downloader.g.c c1;
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        this.a.transact(20, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
        } else {
          c1 = null;
        } 
        return c1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public com.ss.android.socialbase.downloader.g.c h(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        com.ss.android.socialbase.downloader.g.c c1;
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        this.a.transact(24, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
        } else {
          c1 = null;
        } 
        return c1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public com.ss.android.socialbase.downloader.g.c i(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        com.ss.android.socialbase.downloader.g.c c1;
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        this.a.transact(28, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
        } else {
          c1 = null;
        } 
        return c1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public com.ss.android.socialbase.downloader.g.c j(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        com.ss.android.socialbase.downloader.g.c c1;
        parcel1.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        parcel1.writeInt(param1Int);
        this.a.transact(29, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          c1 = (com.ss.android.socialbase.downloader.g.c)com.ss.android.socialbase.downloader.g.c.CREATOR.createFromParcel(parcel2);
        } else {
          c1 = null;
        } 
        return c1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */