package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.blued.das.profile.PersonalProfileProtos;
import com.soft.blued.http.Blued_healthUrl;
import com.soft.blued.http.Danlan_loveUrl;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.view.tip.dialog.CommonDialogFragment;

public class HealthDialogFragment extends CommonDialogFragment {
  public static boolean a;
  
  public static void a(Context paramContext) {
    FragmentActivity fragmentActivity = (FragmentActivity)paramContext;
    (new HealthDialogFragment()).show(fragmentActivity.getSupportFragmentManager(), "");
  }
  
  public void a(View paramView) {
    View view1 = paramView.findViewById(2131296942);
    View view2 = paramView.findViewById(2131299429);
    paramView = paramView.findViewById(2131299232);
    view1.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.dismiss();
          }
        });
    view2.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackPersonalProfile.a(PersonalProfileProtos.Event.HEALTH_INFO_PAGE_SUBSCRIBE_CLICK);
            WebViewShowInfoFragment.show((Context)this.a.getActivity(), Danlan_loveUrl.a(0), -1);
          }
        });
    paramView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackPersonalProfile.a(PersonalProfileProtos.Event.HEALTH_INFO_PAGE_MORE_CLICK);
            WebViewShowInfoFragment.show((Context)this.a.getActivity(), Blued_healthUrl.a(0), -1);
          }
        });
  }
  
  public int f() {
    return 2131494071;
  }
  
  public int g() {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    a = true;
  }
  
  public void onDestroy() {
    super.onDestroy();
    a = false;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\HealthDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */