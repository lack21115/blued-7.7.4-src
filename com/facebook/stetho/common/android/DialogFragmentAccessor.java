package com.facebook.stetho.common.android;

import android.app.Dialog;

public interface DialogFragmentAccessor<DIALOG_FRAGMENT, FRAGMENT, FRAGMENT_MANAGER> extends FragmentAccessor<FRAGMENT, FRAGMENT_MANAGER> {
  Dialog getDialog(DIALOG_FRAGMENT paramDIALOG_FRAGMENT);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\android\DialogFragmentAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */