package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.fragment.CommonWriteTextFragment;
import com.soft.blued.http.FeedHttpUtils;

public class FeedbackFragment extends CommonWriteTextFragment {
  private Dialog n;
  
  public static void a(Context paramContext) {
    Bundle bundle = new Bundle();
    bundle.putString("max_count", "256");
    bundle.putString("string_edit_hint", paramContext.getResources().getString(2131759360));
    bundle.putString("string_edit", "");
    bundle.putString("string_center", paramContext.getResources().getString(2131756392));
    TerminalActivity.d(paramContext, FeedbackFragment.class, bundle);
  }
  
  public boolean a(int paramInt, String paramString) {
    if (paramInt == -1 && !TextUtils.isEmpty(paramString) && w_() != null && w_().isActive()) {
      if (this.n == null)
        this.n = DialogUtils.a((Context)getActivity()); 
      DialogUtils.a(this.n);
      FeedHttpUtils.a((Context)getActivity(), new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
            public void a(BluedEntityA<Object> param1BluedEntityA) {
              AppMethods.d(2131758528);
              this.a.getActivity().finish();
            }
            
            public void onUIFinish() {
              DialogUtils.b(FeedbackFragment.a(this.a));
            }
          },  paramString, (IRequestHost)w_());
      return false;
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\fragment\FeedbackFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */