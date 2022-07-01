package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.view.tip.CommonAlertDialog;

public class ReportChatFragment extends BaseFragment {
  public String d;
  
  public String e;
  
  public int f;
  
  public int g;
  
  public Context h;
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putString("KEY_CHAT_CONTENT", paramString1);
    bundle.putString("KEY_TARGET_UID", paramString2);
    bundle.putInt("KEY_REPORT_TYPE", paramInt);
    TransparentActivity.b(paramContext, ReportChatFragment.class, bundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      if (paramInt2 == -1 && paramIntent != null) {
        this.g = paramIntent.getIntExtra("KEY_REPORT_ITEM_ID", -1);
        ChatHttpUtils.a(this.h, new BluedUIHttpResponse(this, (IRequestHost)w_()) {
              boolean a = false;
              
              String b = "";
              
              public boolean onUIFailure(int param1Int, String param1String) {
                this.a = true;
                this.b = param1String;
                return true;
              }
              
              public void onUIFinish() {
                super.onUIFinish();
                if (this.a)
                  CommonAlertDialog.a(this.c.h, null, this.c.h.getResources().getString(2131758589), this.b, "", new DialogInterface.OnClickListener(this) {
                        public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                          this.a.c.getActivity().finish();
                        }
                      },  new DialogInterface.OnCancelListener(this) {
                        public void onCancel(DialogInterface param2DialogInterface) {
                          this.a.c.getActivity().finish();
                        }
                      },  true); 
              }
              
              public void onUIUpdate(BluedEntity param1BluedEntity) {
                AppMethods.d(2131755510);
                this.c.getActivity().finish();
              }
            }this.d, null, this.f, this.e, "", 0L, this.g, (IRequestHost)w_());
        return;
      } 
      getActivity().finish();
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.h = (Context)getActivity();
    if (getArguments() != null) {
      this.d = getArguments().getString("KEY_CHAT_CONTENT");
      this.e = getArguments().getString("KEY_TARGET_UID");
      this.f = getArguments().getInt("KEY_REPORT_TYPE");
    } 
    ChooseReportReasonFragment.a(this, true);
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\ReportChatFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */