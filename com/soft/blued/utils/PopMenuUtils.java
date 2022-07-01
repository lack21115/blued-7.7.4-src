package com.soft.blued.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.customview.PopMenuFromCenter;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.user.fragment.VIPCenterNewFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;

public class PopMenuUtils {
  private static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener) {
    View view = LayoutInflater.from(paramContext).inflate(2131493549, null);
    PopMenuFromCenter popMenuFromCenter = new PopMenuFromCenter(paramContext, view);
    LinearLayout linearLayout = (LinearLayout)view.findViewById(2131298932);
    TextView textView2 = (TextView)view.findViewById(2131300590);
    ImageView imageView = (ImageView)view.findViewById(2131297489);
    TextView textView1 = (TextView)view.findViewById(2131300663);
    textView2.setText(paramInt3);
    textView1.setText(paramInt2);
    ImageLoader.a(null, paramInt1).a(5.0F).a(imageView);
    linearLayout.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {}
        });
    textView2.setOnClickListener(new View.OnClickListener(paramOnClickListener, popMenuFromCenter) {
          public void onClick(View param1View) {
            this.a.onClick(param1View);
            this.b.d();
          }
        });
    popMenuFromCenter.e();
  }
  
  public static void a(Context paramContext, PopMenuFromCenter.DismissListner paramDismissListner) {
    View view = LayoutInflater.from(paramContext).inflate(2131493622, null);
    PopMenuFromCenter popMenuFromCenter = new PopMenuFromCenter(paramContext, view);
    popMenuFromCenter.a(paramDismissListner);
    LinearLayout linearLayout = (LinearLayout)view.findViewById(2131298932);
    ImageView imageView1 = (ImageView)view.findViewById(2131297457);
    ImageView imageView2 = (ImageView)view.findViewById(2131297561);
    TextView textView1 = (TextView)view.findViewById(2131300590);
    TextView textView2 = (TextView)view.findViewById(2131301356);
    imageView1.setOnClickListener(new View.OnClickListener(popMenuFromCenter) {
          public void onClick(View param1View) {
            this.a.d();
          }
        });
    linearLayout.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {}
        });
    view.setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {}
        });
    imageView2.setImageResource(2131232664);
    textView2.setText(2131758480);
    textView1.setText(2131756603);
    textView1.setOnClickListener(new View.OnClickListener(popMenuFromCenter, paramContext) {
          public void onClick(View param1View) {
            this.a.a(true);
            InstantLog.a("vip_buy_go_setting_click");
            VIPCenterNewFragment.a(this.b, -1, "");
          }
        });
    popMenuFromCenter.e();
  }
  
  public static boolean a() {
    return (UserInfo.a().i().getNeed_auth() == 1);
  }
  
  public static boolean a(Context paramContext) {
    return a(paramContext, (View.OnClickListener)null);
  }
  
  public static boolean a(Context paramContext, View.OnClickListener paramOnClickListener) {
    Activity activity;
    if (!a())
      return false; 
    Context context = null;
    if (paramContext instanceof Activity) {
      context = paramContext;
    } else if (BluedApplicationLike.getForeActivity() != null) {
      activity = BluedApplicationLike.getForeActivity();
    } 
    if (activity != null) {
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_PHONE_BIND_SHOW);
      a((Context)activity, 2131231068, 2131758200, 2131756604, new View.OnClickListener(paramOnClickListener, paramContext) {
            public void onClick(View param1View) {
              EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_PHONE_BIND_CONFIRM_CLICK);
              View.OnClickListener onClickListener = this.a;
              if (onClickListener != null)
                onClickListener.onClick(param1View); 
              String str = UserInfo.a().i().getIs_auth_url();
              if (!StringUtils.e(str))
                WebViewShowInfoFragment.show(this.b, str, -1); 
            }
          });
    } else {
      AppMethods.a(paramContext.getResources().getString(2131758200));
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\PopMenuUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */