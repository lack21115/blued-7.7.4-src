package com.soft.blued.ui.circle.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TransparentActivity;
import com.soft.blued.ui.circle.model.CircleJoinState;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.utils.BluedPreferences;

public class ApplyJoinCircleFragment extends BaseFragment {
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return; 
      Bundle bundle = new Bundle();
      bundle.putString("circle_id", paramString1);
      bundle.putString("circle_name", paramString2);
      bundle.putString("circle_header", paramString3);
      TransparentActivity.a(bundle);
      TransparentActivity.b(paramContext, ApplyJoinCircleFragment.class, bundle);
    } 
  }
  
  public void onResume() {
    super.onResume();
    if (getArguments() != null) {
      String str1 = getArguments().getString("circle_id");
      String str2 = getArguments().getString("circle_name");
      String str3 = getArguments().getString("circle_header");
      ApplyJoinCircleDialogFragment.a(getFragmentManager(), str1, str2, str3, new ApplyJoinCircleDialogFragment.ApplyJoinCircleListener(this, str1, str2, str3) {
            public void onApply() {
              CircleMethods.joinCircleEvent(new CircleJoinState(this.a, this.b, this.c, 3, 1, 1));
              BluedPreferences.a(this.a, true);
              BluedPreferences.b(this.a, true);
            }
          }).a(new DialogInterface.OnDismissListener(this) {
            public void onDismiss(DialogInterface param1DialogInterface) {
              this.a.getActivity().finish();
            }
          });
      return;
    } 
    getActivity().finish();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\ApplyJoinCircleFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */