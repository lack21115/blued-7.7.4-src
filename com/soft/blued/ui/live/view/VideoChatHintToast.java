package com.soft.blued.ui.live.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.view.SuperToast.SuperActivityToast;
import com.soft.blued.utils.UserRelationshipUtils;

public class VideoChatHintToast extends SuperActivityToast {
  private Context a;
  
  private View b;
  
  private String c;
  
  private int d;
  
  private String e;
  
  private SuperActivityToast.OnButtonClickListener f;
  
  public VideoChatHintToast(Context paramContext, String paramString1, int paramInt, String paramString2, SuperActivityToast.OnButtonClickListener paramOnButtonClickListener) {
    super(paramContext);
    this.a = paramContext;
    this.c = paramString1;
    this.d = paramInt;
    this.e = paramString2;
    this.f = paramOnButtonClickListener;
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, onHintClickLisnter paramonHintClickLisnter) {
    (new VideoChatHintToast(paramContext, paramString1, paramInt, paramString2, new SuperActivityToast.OnButtonClickListener(paramonHintClickLisnter) {
          public void a() {
            this.a.a();
          }
        })).b(48, 0, 0).a(5000).o();
  }
  
  public static void b(Context paramContext, Bundle paramBundle) {
    SuperActivityToast.a(paramContext, paramBundle);
  }
  
  public static void b(Bundle paramBundle) {
    SuperActivityToast.a(paramBundle);
  }
  
  public View a(Context paramContext, LayoutInflater paramLayoutInflater) {
    this.b = paramLayoutInflater.inflate(2131494072, (ViewGroup)((Activity)paramContext).findViewById(16908290), false);
    (j()).c = 0;
    return this.b;
  }
  
  public void e() {
    ((TextView)this.b.findViewById(2131300663)).setText(this.e);
    LinearLayout linearLayout = (LinearLayout)this.b.findViewById(2131298758);
    ImageView imageView1 = (ImageView)this.b.findViewById(2131297432);
    ImageView imageView2 = (ImageView)this.b.findViewById(2131297575);
    ImageLoader.a(null, this.c).a(2131234356).a(2.0F, this.a.getResources().getColor(2131100980)).a(imageView1);
    UserRelationshipUtils.a(imageView2, this.d, 3);
    linearLayout.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            VideoChatHintToast.a(this.a).a();
            this.a.p();
          }
        });
  }
  
  public static interface onHintClickLisnter {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\view\VideoChatHintToast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */