package com.alibaba.mtl.appmonitor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.Map;

public interface IMonitor extends IInterface {
  boolean alarm_checkSampled(String paramString1, String paramString2) throws RemoteException;
  
  void alarm_commitFail1(String paramString1, String paramString2, String paramString3, String paramString4) throws RemoteException;
  
  void alarm_commitFail2(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) throws RemoteException;
  
  void alarm_commitSuccess1(String paramString1, String paramString2) throws RemoteException;
  
  void alarm_commitSuccess2(String paramString1, String paramString2, String paramString3) throws RemoteException;
  
  void alarm_setSampling(int paramInt) throws RemoteException;
  
  void alarm_setStatisticsInterval(int paramInt) throws RemoteException;
  
  boolean counter_checkSampled(String paramString1, String paramString2) throws RemoteException;
  
  void counter_commit1(String paramString1, String paramString2, double paramDouble) throws RemoteException;
  
  void counter_commit2(String paramString1, String paramString2, String paramString3, double paramDouble) throws RemoteException;
  
  void counter_setSampling(int paramInt) throws RemoteException;
  
  void counter_setStatisticsInterval(int paramInt) throws RemoteException;
  
  void destroy() throws RemoteException;
  
  void enableLog(boolean paramBoolean) throws RemoteException;
  
  void init() throws RemoteException;
  
  boolean offlinecounter_checkSampled(String paramString1, String paramString2) throws RemoteException;
  
  void offlinecounter_commit(String paramString1, String paramString2, double paramDouble) throws RemoteException;
  
  void offlinecounter_setSampling(int paramInt) throws RemoteException;
  
  void offlinecounter_setStatisticsInterval(int paramInt) throws RemoteException;
  
  void register1(String paramString1, String paramString2, MeasureSet paramMeasureSet) throws RemoteException;
  
  void register2(String paramString1, String paramString2, MeasureSet paramMeasureSet, boolean paramBoolean) throws RemoteException;
  
  void register3(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet) throws RemoteException;
  
  void register4(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet, boolean paramBoolean) throws RemoteException;
  
  void setChannel(String paramString) throws RemoteException;
  
  void setRequestAuthInfo(boolean paramBoolean, String paramString1, String paramString2, String paramString3) throws RemoteException;
  
  void setSampling(int paramInt) throws RemoteException;
  
  void setStatisticsInterval1(int paramInt) throws RemoteException;
  
  void setStatisticsInterval2(int paramInt1, int paramInt2) throws RemoteException;
  
  void stat_begin(String paramString1, String paramString2, String paramString3) throws RemoteException;
  
  boolean stat_checkSampled(String paramString1, String paramString2) throws RemoteException;
  
  void stat_commit1(String paramString1, String paramString2, double paramDouble) throws RemoteException;
  
  void stat_commit2(String paramString1, String paramString2, DimensionValueSet paramDimensionValueSet, double paramDouble) throws RemoteException;
  
  void stat_commit3(String paramString1, String paramString2, DimensionValueSet paramDimensionValueSet, MeasureValueSet paramMeasureValueSet) throws RemoteException;
  
  void stat_end(String paramString1, String paramString2, String paramString3) throws RemoteException;
  
  void stat_setSampling(int paramInt) throws RemoteException;
  
  void stat_setStatisticsInterval(int paramInt) throws RemoteException;
  
  void transaction_begin(Transaction paramTransaction, String paramString) throws RemoteException;
  
  void transaction_end(Transaction paramTransaction, String paramString) throws RemoteException;
  
  void triggerUpload() throws RemoteException;
  
  void turnOffRealTimeDebug() throws RemoteException;
  
  void turnOnRealTimeDebug(Map paramMap) throws RemoteException;
  
  void updateMeasure(String paramString1, String paramString2, String paramString3, double paramDouble1, double paramDouble2, double paramDouble3) throws RemoteException;
  
  public static abstract class Stub extends Binder implements IMonitor {
    public Stub() {
      attachInterface(this, "com.alibaba.mtl.appmonitor.IMonitor");
    }
    
    public static IMonitor asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.alibaba.mtl.appmonitor.IMonitor");
      return (iInterface != null && iInterface instanceof IMonitor) ? (IMonitor)iInterface : new a(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    static class a implements IMonitor {
      private IBinder a;
      
      a(IBinder param2IBinder) {
        this.a = param2IBinder;
      }
      
      public boolean alarm_checkSampled(String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
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
      
      public void alarm_commitFail1(String param2String1, String param2String2, String param2String3, String param2String4) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeString(param2String3);
          parcel1.writeString(param2String4);
          this.a.transact(30, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void alarm_commitFail2(String param2String1, String param2String2, String param2String3, String param2String4, String param2String5) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeString(param2String3);
          parcel1.writeString(param2String4);
          parcel1.writeString(param2String5);
          this.a.transact(31, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void alarm_commitSuccess1(String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          this.a.transact(28, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void alarm_commitSuccess2(String param2String1, String param2String2, String param2String3) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeString(param2String3);
          this.a.transact(29, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void alarm_setSampling(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeInt(param2Int);
          this.a.transact(26, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void alarm_setStatisticsInterval(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeInt(param2Int);
          this.a.transact(25, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public IBinder asBinder() {
        return this.a;
      }
      
      public boolean counter_checkSampled(String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(18, parcel1, parcel2, 0);
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
      
      public void counter_commit1(String param2String1, String param2String2, double param2Double) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeDouble(param2Double);
          this.a.transact(19, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void counter_commit2(String param2String1, String param2String2, String param2String3, double param2Double) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeString(param2String3);
          parcel1.writeDouble(param2Double);
          this.a.transact(20, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void counter_setSampling(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeInt(param2Int);
          this.a.transact(17, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void counter_setStatisticsInterval(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeInt(param2Int);
          this.a.transact(16, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void destroy() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          this.a.transact(15, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void enableLog(boolean param2Boolean) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          boolean bool;
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          if (param2Boolean) {
            bool = true;
          } else {
            bool = false;
          } 
          parcel1.writeInt(bool);
          this.a.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void init() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          this.a.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean offlinecounter_checkSampled(String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(23, parcel1, parcel2, 0);
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
      
      public void offlinecounter_commit(String param2String1, String param2String2, double param2Double) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeDouble(param2Double);
          this.a.transact(24, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void offlinecounter_setSampling(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeInt(param2Int);
          this.a.transact(22, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void offlinecounter_setStatisticsInterval(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeInt(param2Int);
          this.a.transact(21, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void register1(String param2String1, String param2String2, MeasureSet param2MeasureSet) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          if (param2MeasureSet != null) {
            parcel1.writeInt(1);
            param2MeasureSet.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(9, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void register2(String param2String1, String param2String2, MeasureSet param2MeasureSet, boolean param2Boolean) throws RemoteException {
        boolean bool;
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        if (!param2Boolean)
          bool = false; 
        parcel1.writeInt(bool);
        this.a.transact(10, parcel1, parcel2, 0);
        parcel2.readException();
        parcel2.recycle();
        parcel1.recycle();
      }
      
      public void register3(String param2String1, String param2String2, MeasureSet param2MeasureSet, DimensionSet param2DimensionSet) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          if (param2MeasureSet != null) {
            parcel1.writeInt(1);
            param2MeasureSet.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2DimensionSet != null) {
            parcel1.writeInt(1);
            param2DimensionSet.writeToParcel(parcel1, 0);
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
      
      public void register4(String param2String1, String param2String2, MeasureSet param2MeasureSet, DimensionSet param2DimensionSet, boolean param2Boolean) throws RemoteException {
        boolean bool;
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          bool = true;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
        if (!param2Boolean)
          bool = false; 
        parcel1.writeInt(bool);
        this.a.transact(12, parcel1, parcel2, 0);
        parcel2.readException();
        parcel2.recycle();
        parcel1.recycle();
      }
      
      public void setChannel(String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String);
          this.a.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void setRequestAuthInfo(boolean param2Boolean, String param2String1, String param2String2, String param2String3) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          boolean bool;
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          if (param2Boolean) {
            bool = true;
          } else {
            bool = false;
          } 
          parcel1.writeInt(bool);
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeString(param2String3);
          this.a.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void setSampling(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeInt(param2Int);
          this.a.transact(6, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void setStatisticsInterval1(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeInt(param2Int);
          this.a.transact(7, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void setStatisticsInterval2(int param2Int1, int param2Int2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          this.a.transact(8, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void stat_begin(String param2String1, String param2String2, String param2String3) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeString(param2String3);
          this.a.transact(32, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean stat_checkSampled(String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          IBinder iBinder = this.a;
          boolean bool = false;
          iBinder.transact(36, parcel1, parcel2, 0);
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
      
      public void stat_commit1(String param2String1, String param2String2, double param2Double) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeDouble(param2Double);
          this.a.transact(37, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void stat_commit2(String param2String1, String param2String2, DimensionValueSet param2DimensionValueSet, double param2Double) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          if (param2DimensionValueSet != null) {
            parcel1.writeInt(1);
            param2DimensionValueSet.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          parcel1.writeDouble(param2Double);
          this.a.transact(38, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void stat_commit3(String param2String1, String param2String2, DimensionValueSet param2DimensionValueSet, MeasureValueSet param2MeasureValueSet) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          if (param2DimensionValueSet != null) {
            parcel1.writeInt(1);
            param2DimensionValueSet.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2MeasureValueSet != null) {
            parcel1.writeInt(1);
            param2MeasureValueSet.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.a.transact(39, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void stat_end(String param2String1, String param2String2, String param2String3) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeString(param2String3);
          this.a.transact(33, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void stat_setSampling(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeInt(param2Int);
          this.a.transact(35, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void stat_setStatisticsInterval(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeInt(param2Int);
          this.a.transact(34, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void transaction_begin(Transaction param2Transaction, String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          if (param2Transaction != null) {
            parcel1.writeInt(1);
            param2Transaction.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          parcel1.writeString(param2String);
          this.a.transact(40, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void transaction_end(Transaction param2Transaction, String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          if (param2Transaction != null) {
            parcel1.writeInt(1);
            param2Transaction.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          parcel1.writeString(param2String);
          this.a.transact(41, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void triggerUpload() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          this.a.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void turnOffRealTimeDebug() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          this.a.transact(14, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void turnOnRealTimeDebug(Map param2Map) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
          parcel1.writeMap(param2Map);
          this.a.transact(13, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void updateMeasure(String param2String1, String param2String2, String param2String3, double param2Double1, double param2Double2, double param2Double3) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeString(param2String3);
          parcel1.writeDouble(param2Double1);
          parcel1.writeDouble(param2Double2);
          parcel1.writeDouble(param2Double3);
          this.a.transact(42, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  static class a implements IMonitor {
    private IBinder a;
    
    a(IBinder param1IBinder) {
      this.a = param1IBinder;
    }
    
    public boolean alarm_checkSampled(String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
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
    
    public void alarm_commitFail1(String param1String1, String param1String2, String param1String3, String param1String4) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeString(param1String3);
        parcel1.writeString(param1String4);
        this.a.transact(30, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void alarm_commitFail2(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeString(param1String3);
        parcel1.writeString(param1String4);
        parcel1.writeString(param1String5);
        this.a.transact(31, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void alarm_commitSuccess1(String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        this.a.transact(28, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void alarm_commitSuccess2(String param1String1, String param1String2, String param1String3) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeString(param1String3);
        this.a.transact(29, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void alarm_setSampling(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeInt(param1Int);
        this.a.transact(26, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void alarm_setStatisticsInterval(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeInt(param1Int);
        this.a.transact(25, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public IBinder asBinder() {
      return this.a;
    }
    
    public boolean counter_checkSampled(String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(18, parcel1, parcel2, 0);
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
    
    public void counter_commit1(String param1String1, String param1String2, double param1Double) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeDouble(param1Double);
        this.a.transact(19, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void counter_commit2(String param1String1, String param1String2, String param1String3, double param1Double) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeString(param1String3);
        parcel1.writeDouble(param1Double);
        this.a.transact(20, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void counter_setSampling(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeInt(param1Int);
        this.a.transact(17, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void counter_setStatisticsInterval(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeInt(param1Int);
        this.a.transact(16, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void destroy() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        this.a.transact(15, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void enableLog(boolean param1Boolean) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        boolean bool;
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        if (param1Boolean) {
          bool = true;
        } else {
          bool = false;
        } 
        parcel1.writeInt(bool);
        this.a.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void init() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        this.a.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean offlinecounter_checkSampled(String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(23, parcel1, parcel2, 0);
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
    
    public void offlinecounter_commit(String param1String1, String param1String2, double param1Double) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeDouble(param1Double);
        this.a.transact(24, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void offlinecounter_setSampling(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeInt(param1Int);
        this.a.transact(22, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void offlinecounter_setStatisticsInterval(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeInt(param1Int);
        this.a.transact(21, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void register1(String param1String1, String param1String2, MeasureSet param1MeasureSet) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        if (param1MeasureSet != null) {
          parcel1.writeInt(1);
          param1MeasureSet.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(9, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void register2(String param1String1, String param1String2, MeasureSet param1MeasureSet, boolean param1Boolean) throws RemoteException {
      boolean bool;
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      if (!param1Boolean)
        bool = false; 
      parcel1.writeInt(bool);
      this.a.transact(10, parcel1, parcel2, 0);
      parcel2.readException();
      parcel2.recycle();
      parcel1.recycle();
    }
    
    public void register3(String param1String1, String param1String2, MeasureSet param1MeasureSet, DimensionSet param1DimensionSet) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        if (param1MeasureSet != null) {
          parcel1.writeInt(1);
          param1MeasureSet.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1DimensionSet != null) {
          parcel1.writeInt(1);
          param1DimensionSet.writeToParcel(parcel1, 0);
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
    
    public void register4(String param1String1, String param1String2, MeasureSet param1MeasureSet, DimensionSet param1DimensionSet, boolean param1Boolean) throws RemoteException {
      boolean bool;
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        bool = true;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
      if (!param1Boolean)
        bool = false; 
      parcel1.writeInt(bool);
      this.a.transact(12, parcel1, parcel2, 0);
      parcel2.readException();
      parcel2.recycle();
      parcel1.recycle();
    }
    
    public void setChannel(String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String);
        this.a.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void setRequestAuthInfo(boolean param1Boolean, String param1String1, String param1String2, String param1String3) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        boolean bool;
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        if (param1Boolean) {
          bool = true;
        } else {
          bool = false;
        } 
        parcel1.writeInt(bool);
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeString(param1String3);
        this.a.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void setSampling(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeInt(param1Int);
        this.a.transact(6, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void setStatisticsInterval1(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeInt(param1Int);
        this.a.transact(7, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void setStatisticsInterval2(int param1Int1, int param1Int2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        this.a.transact(8, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void stat_begin(String param1String1, String param1String2, String param1String3) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeString(param1String3);
        this.a.transact(32, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean stat_checkSampled(String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        IBinder iBinder = this.a;
        boolean bool = false;
        iBinder.transact(36, parcel1, parcel2, 0);
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
    
    public void stat_commit1(String param1String1, String param1String2, double param1Double) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeDouble(param1Double);
        this.a.transact(37, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void stat_commit2(String param1String1, String param1String2, DimensionValueSet param1DimensionValueSet, double param1Double) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        if (param1DimensionValueSet != null) {
          parcel1.writeInt(1);
          param1DimensionValueSet.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        parcel1.writeDouble(param1Double);
        this.a.transact(38, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void stat_commit3(String param1String1, String param1String2, DimensionValueSet param1DimensionValueSet, MeasureValueSet param1MeasureValueSet) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        if (param1DimensionValueSet != null) {
          parcel1.writeInt(1);
          param1DimensionValueSet.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1MeasureValueSet != null) {
          parcel1.writeInt(1);
          param1MeasureValueSet.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.a.transact(39, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void stat_end(String param1String1, String param1String2, String param1String3) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeString(param1String3);
        this.a.transact(33, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void stat_setSampling(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeInt(param1Int);
        this.a.transact(35, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void stat_setStatisticsInterval(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeInt(param1Int);
        this.a.transact(34, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void transaction_begin(Transaction param1Transaction, String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        if (param1Transaction != null) {
          parcel1.writeInt(1);
          param1Transaction.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        parcel1.writeString(param1String);
        this.a.transact(40, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void transaction_end(Transaction param1Transaction, String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        if (param1Transaction != null) {
          parcel1.writeInt(1);
          param1Transaction.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        parcel1.writeString(param1String);
        this.a.transact(41, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void triggerUpload() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        this.a.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void turnOffRealTimeDebug() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        this.a.transact(14, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void turnOnRealTimeDebug(Map param1Map) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
        parcel1.writeMap(param1Map);
        this.a.transact(13, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void updateMeasure(String param1String1, String param1String2, String param1String3, double param1Double1, double param1Double2, double param1Double3) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeString(param1String3);
        parcel1.writeDouble(param1Double1);
        parcel1.writeDouble(param1Double2);
        parcel1.writeDouble(param1Double3);
        this.a.transact(42, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\IMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */