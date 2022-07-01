package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
  public static final Parcelable.Creator CREATOR = new BackStackState$1();
  
  private int mBreadCrumbShortTitleRes;
  
  private CharSequence mBreadCrumbShortTitleText;
  
  private int mBreadCrumbTitleRes;
  
  private CharSequence mBreadCrumbTitleText;
  
  private int mIndex;
  
  private String mName;
  
  private int[] mOps;
  
  private boolean mReorderingAllowed;
  
  private ArrayList mSharedElementSourceNames;
  
  private ArrayList mSharedElementTargetNames;
  
  private int mTransition;
  
  private int mTransitionStyle;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public BackStackState(Parcel paramParcel) {
    boolean bool;
    this.mOps = paramParcel.createIntArray();
    this.mTransition = paramParcel.readInt();
    this.mTransitionStyle = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.mBreadCrumbTitleRes = paramParcel.readInt();
    this.mBreadCrumbTitleText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel);
    this.mBreadCrumbShortTitleRes = paramParcel.readInt();
    this.mBreadCrumbShortTitleText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel);
    this.mSharedElementSourceNames = paramParcel.createStringArrayList();
    this.mSharedElementTargetNames = paramParcel.createStringArrayList();
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.mReorderingAllowed = bool;
  }
  
  public BackStackState(BackStackRecord paramBackStackRecord) {
    int i = paramBackStackRecord.mOps.size();
    this.mOps = new int[i * 6];
    if (paramBackStackRecord.mAddToBackStack) {
      int j = 0;
      for (int k = 0; j < i; k++) {
        BackStackRecord$Op backStackRecord$Op = paramBackStackRecord.mOps.get(j);
        int[] arrayOfInt = this.mOps;
        int m = k + 1;
        arrayOfInt[k] = backStackRecord$Op.cmd;
        arrayOfInt = this.mOps;
        int n = m + 1;
        if (backStackRecord$Op.fragment != null) {
          k = backStackRecord$Op.fragment.mIndex;
        } else {
          k = -1;
        } 
        arrayOfInt[m] = k;
        arrayOfInt = this.mOps;
        k = n + 1;
        arrayOfInt[n] = backStackRecord$Op.enterAnim;
        arrayOfInt = this.mOps;
        m = k + 1;
        arrayOfInt[k] = backStackRecord$Op.exitAnim;
        arrayOfInt = this.mOps;
        k = m + 1;
        arrayOfInt[m] = backStackRecord$Op.popEnterAnim;
        this.mOps[k] = backStackRecord$Op.popExitAnim;
        j++;
      } 
      this.mTransition = paramBackStackRecord.mTransition;
      this.mTransitionStyle = paramBackStackRecord.mTransitionStyle;
      this.mName = paramBackStackRecord.mName;
      this.mIndex = paramBackStackRecord.mIndex;
      this.mBreadCrumbTitleRes = paramBackStackRecord.mBreadCrumbTitleRes;
      this.mBreadCrumbTitleText = paramBackStackRecord.mBreadCrumbTitleText;
      this.mBreadCrumbShortTitleRes = paramBackStackRecord.mBreadCrumbShortTitleRes;
      this.mBreadCrumbShortTitleText = paramBackStackRecord.mBreadCrumbShortTitleText;
      this.mSharedElementSourceNames = paramBackStackRecord.mSharedElementSourceNames;
      this.mSharedElementTargetNames = paramBackStackRecord.mSharedElementTargetNames;
      this.mReorderingAllowed = paramBackStackRecord.mReorderingAllowed;
      return;
    } 
    throw new IllegalStateException("Not on back stack");
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final BackStackRecord instantiate(FragmentManagerImpl paramFragmentManagerImpl) {
    BackStackRecord backStackRecord = new BackStackRecord(paramFragmentManagerImpl);
    int j = 0;
    int i = 0;
    while (j < this.mOps.length) {
      BackStackRecord$Op backStackRecord$Op = new BackStackRecord$Op();
      int[] arrayOfInt = this.mOps;
      int k = j + 1;
      backStackRecord$Op.cmd = arrayOfInt[j];
      if (FragmentManagerImpl.DEBUG) {
        StringBuilder stringBuilder = new StringBuilder("Instantiate ");
        stringBuilder.append(backStackRecord);
        stringBuilder.append(" op #");
        stringBuilder.append(i);
        stringBuilder.append(" base fragment #");
        stringBuilder.append(this.mOps[k]);
      } 
      arrayOfInt = this.mOps;
      j = k + 1;
      k = arrayOfInt[k];
      if (k >= 0) {
        backStackRecord$Op.fragment = (Fragment)paramFragmentManagerImpl.mActive.get(k);
      } else {
        backStackRecord$Op.fragment = null;
      } 
      arrayOfInt = this.mOps;
      k = j + 1;
      backStackRecord$Op.enterAnim = arrayOfInt[j];
      arrayOfInt = this.mOps;
      j = k + 1;
      backStackRecord$Op.exitAnim = arrayOfInt[k];
      arrayOfInt = this.mOps;
      k = j + 1;
      backStackRecord$Op.popEnterAnim = arrayOfInt[j];
      backStackRecord$Op.popExitAnim = this.mOps[k];
      backStackRecord.mEnterAnim = backStackRecord$Op.enterAnim;
      backStackRecord.mExitAnim = backStackRecord$Op.exitAnim;
      backStackRecord.mPopEnterAnim = backStackRecord$Op.popEnterAnim;
      backStackRecord.mPopExitAnim = backStackRecord$Op.popExitAnim;
      backStackRecord.addOp(backStackRecord$Op);
      i++;
      j = k + 1;
    } 
    backStackRecord.mTransition = this.mTransition;
    backStackRecord.mTransitionStyle = this.mTransitionStyle;
    backStackRecord.mName = this.mName;
    backStackRecord.mIndex = this.mIndex;
    backStackRecord.mAddToBackStack = true;
    backStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
    backStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
    backStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
    backStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
    backStackRecord.mSharedElementSourceNames = this.mSharedElementSourceNames;
    backStackRecord.mSharedElementTargetNames = this.mSharedElementTargetNames;
    backStackRecord.mReorderingAllowed = this.mReorderingAllowed;
    backStackRecord.bumpBackStackNesting(1);
    return backStackRecord;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\BackStackState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */