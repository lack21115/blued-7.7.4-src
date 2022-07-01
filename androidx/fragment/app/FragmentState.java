package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.lifecycle.Lifecycle;

final class FragmentState implements Parcelable {
  public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() {
      public FragmentState createFromParcel(Parcel param1Parcel) {
        return new FragmentState(param1Parcel);
      }
      
      public FragmentState[] newArray(int param1Int) {
        return new FragmentState[param1Int];
      }
    };
  
  final String a;
  
  final String b;
  
  final boolean c;
  
  final int d;
  
  final int e;
  
  final String f;
  
  final boolean g;
  
  final boolean h;
  
  final boolean i;
  
  final Bundle j;
  
  final boolean k;
  
  final int l;
  
  Bundle m;
  
  Fragment n;
  
  FragmentState(Parcel paramParcel) {
    boolean bool1;
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    int i = paramParcel.readInt();
    boolean bool2 = true;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.c = bool1;
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
    if (paramParcel.readInt() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.g = bool1;
    if (paramParcel.readInt() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.h = bool1;
    if (paramParcel.readInt() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.i = bool1;
    this.j = paramParcel.readBundle();
    if (paramParcel.readInt() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    this.k = bool1;
    this.m = paramParcel.readBundle();
    this.l = paramParcel.readInt();
  }
  
  FragmentState(Fragment paramFragment) {
    this.a = paramFragment.getClass().getName();
    this.b = paramFragment.mWho;
    this.c = paramFragment.mFromLayout;
    this.d = paramFragment.mFragmentId;
    this.e = paramFragment.mContainerId;
    this.f = paramFragment.mTag;
    this.g = paramFragment.mRetainInstance;
    this.h = paramFragment.mRemoving;
    this.i = paramFragment.mDetached;
    this.j = paramFragment.mArguments;
    this.k = paramFragment.mHidden;
    this.l = paramFragment.mMaxState.ordinal();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public Fragment instantiate(ClassLoader paramClassLoader, FragmentFactory paramFragmentFactory) {
    if (this.n == null) {
      Bundle bundle2 = this.j;
      if (bundle2 != null)
        bundle2.setClassLoader(paramClassLoader); 
      this.n = paramFragmentFactory.instantiate(paramClassLoader, this.a);
      this.n.setArguments(this.j);
      Bundle bundle1 = this.m;
      if (bundle1 != null) {
        bundle1.setClassLoader(paramClassLoader);
        this.n.mSavedFragmentState = this.m;
      } else {
        this.n.mSavedFragmentState = new Bundle();
      } 
      Fragment fragment = this.n;
      fragment.mWho = this.b;
      fragment.mFromLayout = this.c;
      fragment.mRestored = true;
      fragment.mFragmentId = this.d;
      fragment.mContainerId = this.e;
      fragment.mTag = this.f;
      fragment.mRetainInstance = this.g;
      fragment.mRemoving = this.h;
      fragment.mDetached = this.i;
      fragment.mHidden = this.k;
      fragment.mMaxState = Lifecycle.State.values()[this.l];
      if (FragmentManagerImpl.b) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Instantiated fragment ");
        stringBuilder.append(this.n);
        Log.v("FragmentManager", stringBuilder.toString());
      } 
    } 
    return this.n;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("FragmentState{");
    stringBuilder.append(this.a);
    stringBuilder.append(" (");
    stringBuilder.append(this.b);
    stringBuilder.append(")}:");
    if (this.c)
      stringBuilder.append(" fromLayout"); 
    if (this.e != 0) {
      stringBuilder.append(" id=0x");
      stringBuilder.append(Integer.toHexString(this.e));
    } 
    String str = this.f;
    if (str != null && !str.isEmpty()) {
      stringBuilder.append(" tag=");
      stringBuilder.append(this.f);
    } 
    if (this.g)
      stringBuilder.append(" retainInstance"); 
    if (this.h)
      stringBuilder.append(" removing"); 
    if (this.i)
      stringBuilder.append(" detached"); 
    if (this.k)
      stringBuilder.append(" hidden"); 
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\FragmentState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */