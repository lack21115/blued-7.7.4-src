package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
  public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() {
      public BackStackState createFromParcel(Parcel param1Parcel) {
        return new BackStackState(param1Parcel);
      }
      
      public BackStackState[] newArray(int param1Int) {
        return new BackStackState[param1Int];
      }
    };
  
  final int[] a;
  
  final ArrayList<String> b;
  
  final int[] c;
  
  final int[] d;
  
  final int e;
  
  final int f;
  
  final String g;
  
  final int h;
  
  final int i;
  
  final CharSequence j;
  
  final int k;
  
  final CharSequence l;
  
  final ArrayList<String> m;
  
  final ArrayList<String> n;
  
  final boolean o;
  
  public BackStackState(Parcel paramParcel) {
    boolean bool;
    this.a = paramParcel.createIntArray();
    this.b = paramParcel.createStringArrayList();
    this.c = paramParcel.createIntArray();
    this.d = paramParcel.createIntArray();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readString();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.j = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel);
    this.k = paramParcel.readInt();
    this.l = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel);
    this.m = paramParcel.createStringArrayList();
    this.n = paramParcel.createStringArrayList();
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.o = bool;
  }
  
  public BackStackState(BackStackRecord paramBackStackRecord) {
    int i = paramBackStackRecord.d.size();
    this.a = new int[i * 5];
    if (paramBackStackRecord.k) {
      this.b = new ArrayList<String>(i);
      this.c = new int[i];
      this.d = new int[i];
      int j = 0;
      for (int k = 0; j < i; k++) {
        FragmentTransaction.Op op = paramBackStackRecord.d.get(j);
        int[] arrayOfInt = this.a;
        int m = k + 1;
        arrayOfInt[k] = op.a;
        ArrayList<String> arrayList = this.b;
        if (op.b != null) {
          String str = op.b.mWho;
        } else {
          arrayOfInt = null;
        } 
        arrayList.add(arrayOfInt);
        arrayOfInt = this.a;
        k = m + 1;
        arrayOfInt[m] = op.c;
        arrayOfInt = this.a;
        m = k + 1;
        arrayOfInt[k] = op.d;
        arrayOfInt = this.a;
        k = m + 1;
        arrayOfInt[m] = op.e;
        this.a[k] = op.f;
        this.c[j] = op.g.ordinal();
        this.d[j] = op.h.ordinal();
        j++;
      } 
      this.e = paramBackStackRecord.i;
      this.f = paramBackStackRecord.j;
      this.g = paramBackStackRecord.m;
      this.h = paramBackStackRecord.c;
      this.i = paramBackStackRecord.n;
      this.j = paramBackStackRecord.o;
      this.k = paramBackStackRecord.p;
      this.l = paramBackStackRecord.q;
      this.m = paramBackStackRecord.r;
      this.n = paramBackStackRecord.s;
      this.o = paramBackStackRecord.t;
      return;
    } 
    throw new IllegalStateException("Not on back stack");
  }
  
  public int describeContents() {
    return 0;
  }
  
  public BackStackRecord instantiate(FragmentManagerImpl paramFragmentManagerImpl) {
    BackStackRecord backStackRecord = new BackStackRecord(paramFragmentManagerImpl);
    int j = 0;
    int i = 0;
    while (j < this.a.length) {
      FragmentTransaction.Op op = new FragmentTransaction.Op();
      int[] arrayOfInt2 = this.a;
      int k = j + 1;
      op.a = arrayOfInt2[j];
      if (FragmentManagerImpl.b) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Instantiate ");
        stringBuilder.append(backStackRecord);
        stringBuilder.append(" op #");
        stringBuilder.append(i);
        stringBuilder.append(" base fragment #");
        stringBuilder.append(this.a[k]);
        Log.v("FragmentManager", stringBuilder.toString());
      } 
      String str = this.b.get(i);
      if (str != null) {
        op.b = paramFragmentManagerImpl.g.get(str);
      } else {
        op.b = null;
      } 
      op.g = Lifecycle.State.values()[this.c[i]];
      op.h = Lifecycle.State.values()[this.d[i]];
      int[] arrayOfInt1 = this.a;
      j = k + 1;
      op.c = arrayOfInt1[k];
      k = j + 1;
      op.d = arrayOfInt1[j];
      j = k + 1;
      op.e = arrayOfInt1[k];
      op.f = arrayOfInt1[j];
      backStackRecord.e = op.c;
      backStackRecord.f = op.d;
      backStackRecord.g = op.e;
      backStackRecord.h = op.f;
      backStackRecord.a(op);
      i++;
      j++;
    } 
    backStackRecord.i = this.e;
    backStackRecord.j = this.f;
    backStackRecord.m = this.g;
    backStackRecord.c = this.h;
    backStackRecord.k = true;
    backStackRecord.n = this.i;
    backStackRecord.o = this.j;
    backStackRecord.p = this.k;
    backStackRecord.q = this.l;
    backStackRecord.r = this.m;
    backStackRecord.s = this.n;
    backStackRecord.t = this.o;
    backStackRecord.a(1);
    return backStackRecord;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\BackStackState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */