package com.soft.blued.manager;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.utils.UiUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.fragment.CircleDetailsFragment;
import com.soft.blued.ui.circle.fragment.CircleNewFragment;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.discover.view.FeedPromotionDlg;
import com.soft.blued.ui.discover.view.SendFeedGuideDlg;
import com.soft.blued.ui.feed.fragment.AttentionFeedFragment;
import com.soft.blued.ui.feed.fragment.FeedPostFragment;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.fragment.UserinfoFragmentAlbumTab;
import com.soft.blued.ui.user.fragment.UserinfoFragmentFeedTab;
import com.soft.blued.ui.user.fragment.UserinfoFragmentProfileTab;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.List;

public class SendNotificationManager {
  private static volatile SendNotificationManager c;
  
  Handler a = new Handler(Looper.getMainLooper());
  
  public boolean b = false;
  
  private String d;
  
  private WeakReference<Activity> e;
  
  private final SparseArray<ViewState> f = new SparseArray();
  
  private boolean g = false;
  
  private float h;
  
  public static SendNotificationManager a() {
    // Byte code:
    //   0: getstatic com/soft/blued/manager/SendNotificationManager.c : Lcom/soft/blued/manager/SendNotificationManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/manager/SendNotificationManager
    //   8: monitorenter
    //   9: getstatic com/soft/blued/manager/SendNotificationManager.c : Lcom/soft/blued/manager/SendNotificationManager;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/manager/SendNotificationManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/manager/SendNotificationManager.c : Lcom/soft/blued/manager/SendNotificationManager;
    //   25: ldc com/soft/blued/manager/SendNotificationManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/manager/SendNotificationManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/manager/SendNotificationManager.c : Lcom/soft/blued/manager/SendNotificationManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(ViewGroup paramViewGroup, View paramView) {
    if (paramView != null) {
      if (paramViewGroup == null)
        return; 
      try {
        paramViewGroup.removeView(paramView);
        ViewState viewState = (ViewState)this.f.get(paramViewGroup.hashCode());
        if (viewState != null && viewState.b != null) {
          this.a.removeCallbacks(viewState.b);
          LogUtils.c("removeView viewState.runnable");
        } 
        this.f.remove(paramViewGroup.hashCode());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("removeView success, ");
        stringBuilder.append(this.f.size());
        LogUtils.c(stringBuilder.toString());
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
  }
  
  private void a(FrameLayout paramFrameLayout, View paramView) {
    LogUtils.c("showAnim");
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    translateAnimation.setInterpolator((Interpolator)new OvershootInterpolator(1.15F));
    translateAnimation.setDuration(500L);
    translateAnimation.setFillBefore(true);
    translateAnimation.setFillAfter(true);
    translateAnimation.setAnimationListener(new Animation.AnimationListener(this, paramFrameLayout, paramView) {
          public void onAnimationEnd(Animation param1Animation) {
            LogUtils.c("showAnim.onAnimationEnd");
            SendNotificationManager.RemoveRunnable removeRunnable = new SendNotificationManager.RemoveRunnable(this.c, this.a, this.b, null, false);
            SendNotificationManager.ViewState viewState2 = (SendNotificationManager.ViewState)SendNotificationManager.a(this.c).get(this.a.hashCode());
            SendNotificationManager.ViewState viewState1 = viewState2;
            if (viewState2 == null)
              viewState1 = new SendNotificationManager.ViewState(this.b); 
            viewState1.b = removeRunnable;
            this.c.a.postDelayed(removeRunnable, 4000L);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {
            LogUtils.c("showAnim.onAnimationStart");
          }
        });
    paramView.startAnimation((Animation)translateAnimation);
  }
  
  private void a(FrameLayout paramFrameLayout, View paramView, BluedIngSelfFeed paramBluedIngSelfFeed, boolean paramBoolean) {
    if (paramView == null || paramView.getParent() == null) {
      LogUtils.c("dismissAnim: view == null");
      return;
    } 
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    translateAnimation.setInterpolator((Interpolator)new DecelerateInterpolator());
    translateAnimation.setDuration(400L);
    translateAnimation.setAnimationListener(new Animation.AnimationListener(this, paramFrameLayout, paramView, paramBluedIngSelfFeed, paramBoolean) {
          public void onAnimationEnd(Animation param1Animation) {
            LogUtils.c("dismissAnim.onAnimationEnd");
            SendNotificationManager.a(this.e, (ViewGroup)this.a, this.b);
            if (this.c != null)
              this.e.a.postDelayed(new Runnable(this) {
                    public void run() {
                      SendNotificationManager.a(this.a.e, this.a.a, this.a.c, this.a.d);
                    }
                  }50L); 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {
            LogUtils.c("dismissAnim.onAnimationStart");
          }
        });
    paramView.startAnimation((Animation)translateAnimation);
  }
  
  private void a(FrameLayout paramFrameLayout, BluedIngSelfFeed paramBluedIngSelfFeed, boolean paramBoolean) {
    String str2;
    String str1;
    StringBuilder stringBuilder;
    SpannableStringBuilder spannableStringBuilder;
    if (paramBluedIngSelfFeed == null)
      return; 
    LogUtils.c("addRootView");
    View view = LayoutInflater.from(AppInfo.d()).inflate(2131494112, null);
    CardView cardView = (CardView)view.findViewById(2131299891);
    ImageView imageView2 = (ImageView)view.findViewById(2131299892);
    ImageView imageView1 = (ImageView)view.findViewById(2131299893);
    TextView textView2 = (TextView)view.findViewById(2131299895);
    TextView textView1 = (TextView)view.findViewById(2131299894);
    if ("1".equalsIgnoreCase(paramBluedIngSelfFeed.is_videos) && paramBluedIngSelfFeed.feed_videos != null && paramBluedIngSelfFeed.feed_videos.length > 0) {
      str2 = paramBluedIngSelfFeed.feed_videos[0];
    } else if (paramBluedIngSelfFeed.feed_pics.length > 0) {
      str2 = paramBluedIngSelfFeed.feed_pics[0];
    } else {
      str2 = null;
    } 
    if (BluedPreferences.cZ()) {
      textView2.setTextColor(AppInfo.d().getResources().getColor(2131100980));
      textView1.setTextColor(AppInfo.d().getResources().getColor(2131100981));
      cardView.setCardBackgroundColor(AppInfo.d().getResources().getColor(2131100674));
    } else {
      textView2.setTextColor(AppInfo.d().getResources().getColor(2131100668));
      textView1.setTextColor(AppInfo.d().getResources().getColor(2131100696));
      cardView.setCardBackgroundColor(AppInfo.d().getResources().getColor(2131100733));
    } 
    ImageLoader.a(null, str2).a(imageView2);
    Fragment fragment = c(b());
    if (paramBoolean) {
      imageView1.setImageResource(2131233705);
      if (fragment != null && fragment.getClass().getSimpleName().equalsIgnoreCase(AttentionFeedFragment.class.getSimpleName())) {
        textView2.setText(2131758684);
      } else if (fragment != null && fragment.getClass().getSimpleName().equalsIgnoreCase(CircleDetailsFragment.class.getSimpleName())) {
        textView2.setText(2131758691);
      } else if ("1".equals(paramBluedIngSelfFeed.is_videos)) {
        textView2.setText(2131758694);
      } else if (paramBluedIngSelfFeed.dataType <= 1 && CircleMethods.isCircle(paramBluedIngSelfFeed)) {
        textView2.setText(2131758691);
      } else {
        textView2.setText(2131758684);
      } 
      String str3 = AppInfo.d().getResources().getText(2131758998).toString();
      spannableStringBuilder = new SpannableStringBuilder(str3);
      String str4 = AppInfo.d().getResources().getText(2131759000).toString();
      if (fragment != null && fragment.getClass().getSimpleName().equalsIgnoreCase(AttentionFeedFragment.class.getSimpleName())) {
        textView1.setVisibility(8);
      } else if (fragment != null && fragment.getClass().getSimpleName().equalsIgnoreCase(CircleDetailsFragment.class.getSimpleName())) {
        textView1.setVisibility(8);
      } else if (fragment != null && (fragment.getClass().getSimpleName().equalsIgnoreCase(UserinfoFragmentFeedTab.class.getSimpleName()) || fragment.getClass().getSimpleName().equalsIgnoreCase(UserinfoFragmentAlbumTab.class.getSimpleName()) || fragment.getClass().getSimpleName().equalsIgnoreCase(UserinfoFragmentAlbumTab.class.getSimpleName()))) {
        textView1.setVisibility(8);
      } else if (fragment != null && fragment instanceof WebViewShowInfoFragment) {
        str1 = ((WebViewShowInfoFragment)fragment).n();
        stringBuilder = new StringBuilder();
        stringBuilder.append("curFragment.url: ");
        stringBuilder.append(str1);
        LogUtils.c(stringBuilder.toString());
        if (str1.contains("home/fans/feed"))
          textView1.setVisibility(8); 
      } else if (stringBuilder.contains(str4)) {
        int i = stringBuilder.indexOf(str4);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#2069EB")), i, str4.length() + i, 33);
        textView1.setText((CharSequence)spannableStringBuilder, TextView.BufferType.SPANNABLE);
        textView1.setVisibility(0);
      } else {
        textView1.setText(stringBuilder);
        textView1.setVisibility(0);
      } 
    } else {
      stringBuilder.setImageResource(2131233704);
      if (str1 != null && str1.getClass().getSimpleName().equalsIgnoreCase(AttentionFeedFragment.class.getSimpleName())) {
        spannableStringBuilder.setText(2131758683);
      } else if (str1 != null && str1.getClass().getSimpleName().equalsIgnoreCase(CircleDetailsFragment.class.getSimpleName())) {
        spannableStringBuilder.setText(2131758690);
      } else if ("1".equals(paramBluedIngSelfFeed.is_videos)) {
        spannableStringBuilder.setText(2131758693);
      } else if (paramBluedIngSelfFeed.dataType <= 1 && CircleMethods.isCircle(paramBluedIngSelfFeed)) {
        spannableStringBuilder.setText(2131758690);
      } else {
        spannableStringBuilder.setText(2131758683);
      } 
      String str3 = AppInfo.d().getResources().getText(2131758999).toString();
      spannableStringBuilder = new SpannableStringBuilder(str3);
      String str4 = AppInfo.d().getResources().getText(2131759000).toString();
      if (str1 != null && str1.getClass().getSimpleName().equalsIgnoreCase(AttentionFeedFragment.class.getSimpleName())) {
        textView1.setVisibility(8);
      } else if (str3.contains(str4)) {
        int i = str3.indexOf(str4);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#2069EB")), i, str4.length() + i, 33);
        textView1.setText((CharSequence)spannableStringBuilder, TextView.BufferType.SPANNABLE);
        textView1.setVisibility(0);
      } else {
        textView1.setText(str3);
        textView1.setVisibility(0);
      } 
    } 
    view.setOnClickListener(new -$$Lambda$SendNotificationManager$mNNYXc1arUpEEbkQpETmkMWufh4(paramBluedIngSelfFeed));
    view.setOnTouchListener(new -$$Lambda$SendNotificationManager$Z2itgWr9iCTpHYgE6pMG24ijq4Q(this, view));
    view.setTag(paramBluedIngSelfFeed);
    paramFrameLayout.addView(view, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    ViewState viewState = new ViewState(view);
    this.f.put(paramFrameLayout.hashCode(), viewState);
    a(paramFrameLayout, view);
    a(paramBluedIngSelfFeed, paramBoolean);
  }
  
  private void b(BluedIngSelfFeed paramBluedIngSelfFeed, boolean paramBoolean) {
    if (paramBluedIngSelfFeed == null)
      return; 
    Activity activity = b();
    if (!UiUtils.a(activity))
      return; 
    FrameLayout frameLayout1 = (FrameLayout)activity.getWindow().getDecorView();
    FrameLayout frameLayout2 = (FrameLayout)activity.findViewById(16908290);
    ViewState viewState = (ViewState)this.f.get(frameLayout1.hashCode());
    if (viewState != null && viewState.a != null) {
      LogUtils.c("decorView has lastView");
      a(frameLayout1, viewState.a, paramBluedIngSelfFeed, paramBoolean);
    } else {
      a(frameLayout1, paramBluedIngSelfFeed, paramBoolean);
    } 
    EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_STATUS_NOTIFICATION_SHOW, paramBluedIngSelfFeed.feed_id);
  }
  
  private boolean c() {
    Activity activity = b();
    if (activity == null)
      return false; 
    Fragment fragment = c(activity);
    if (fragment != null) {
      String str = fragment.getClass().getSimpleName();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("curFragment: ");
      stringBuilder.append(str);
      LogUtils.c(stringBuilder.toString());
      if (str.equalsIgnoreCase(AttentionFeedFragment.class.getSimpleName()))
        return false; 
      if (str.equalsIgnoreCase(UserInfoFragmentNew.class.getSimpleName()))
        return false; 
      if (str.equalsIgnoreCase(CircleNewFragment.class.getSimpleName()))
        return false; 
      if (str.equalsIgnoreCase(CircleDetailsFragment.class.getSimpleName()))
        return false; 
      if (str.equalsIgnoreCase(FeedPostFragment.class.getSimpleName()))
        return false; 
      if (str.equalsIgnoreCase(UserinfoFragmentAlbumTab.class.getSimpleName()))
        return false; 
      if (str.equalsIgnoreCase(UserinfoFragmentFeedTab.class.getSimpleName()))
        return false; 
      if (str.equalsIgnoreCase(UserinfoFragmentProfileTab.class.getSimpleName()))
        return false; 
    } 
    return true;
  }
  
  private boolean d() {
    Activity activity = b();
    if (activity == null)
      return false; 
    Fragment fragment = c(activity);
    if (fragment != null) {
      String str = fragment.getClass().getSimpleName();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("curFragment: ");
      stringBuilder.append(str);
      LogUtils.c(stringBuilder.toString());
      if (str.equalsIgnoreCase(CircleNewFragment.class.getSimpleName()))
        return false; 
      if (str.equalsIgnoreCase(CircleDetailsFragment.class.getSimpleName()))
        return false; 
    } 
    return true;
  }
  
  public void a(Activity paramActivity) {
    if (paramActivity != null) {
      FrameLayout frameLayout = (FrameLayout)paramActivity.getWindow().getDecorView();
      ViewState viewState = (ViewState)this.f.get(frameLayout.hashCode());
      if (viewState != null && viewState.a != null)
        a((ViewGroup)frameLayout, viewState.a); 
    } 
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    b(paramBluedIngSelfFeed, false);
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed, boolean paramBoolean) {
    if (paramBluedIngSelfFeed != null) {
      if (!paramBoolean)
        return; 
      Activity activity = b();
      if (activity == null)
        return; 
      if (BluedPreferences.eB() && c()) {
        BluedPreferences.eC();
        SendFeedGuideDlg sendFeedGuideDlg = new SendFeedGuideDlg((Context)activity, 2131820784);
        sendFeedGuideDlg.a(paramBluedIngSelfFeed);
        DialogUtils.a((Dialog)sendFeedGuideDlg);
        return;
      } 
      a(paramBluedIngSelfFeed);
    } 
  }
  
  public void a(Object paramObject) {
    if (paramObject != null && paramObject instanceof BluedIngSelfFeed) {
      BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed)paramObject;
      if (bluedIngSelfFeed.circle_active_posting > 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("发布成功，基分+");
        stringBuilder.append(bluedIngSelfFeed.circle_active_posting);
        AppMethods.a(stringBuilder.toString());
      } else if (bluedIngSelfFeed.circle_active_shared_posting > 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("分享成功，基分+");
        stringBuilder.append(bluedIngSelfFeed.circle_active_shared_posting);
        AppMethods.a(stringBuilder.toString());
      } 
    } 
    if (paramObject != null) {
      if (!d())
        return; 
      if (paramObject instanceof BluedIngSelfFeed) {
        BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed)paramObject;
        if (bluedIngSelfFeed.is_join_circle == 0) {
          paramObject = b();
          if (paramObject == null)
            return; 
          String str = bluedIngSelfFeed.promotion_url;
          if (this.b) {
            EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_SUCCESS_POP_SHOW);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("&detail=feed_success_go_hot");
            str = stringBuilder.toString();
            CommonAlertDialog.a((Context)paramObject, paramObject.getString(2131758474), paramObject.getString(2131758473), paramObject.getString(2131756415), new -$$Lambda$SendNotificationManager$p0zxCoqLBQfN2y5KD9gRKdc-IiM((Activity)paramObject, str), paramObject.getString(2131756187), null, null);
          } else {
            if (this.g)
              return; 
            AppConfigModel.FeedPromotion feedPromotion = BluedConfig.b().n();
            if (feedPromotion != null && feedPromotion.open == 1) {
              long l1 = feedPromotion.duration;
              long l2 = (new Date()).getTime();
              if (l2 - BluedPreferences.bQ() > l1 * 60L * 60L * 1000L) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("&detail=after_publish_guide_window");
                str = stringBuilder.toString();
                BluedPreferences.g(l2);
                paramObject = new FeedPromotionDlg((Context)paramObject, 2131820784, feedPromotion);
                paramObject.a(str);
                DialogUtils.a((Dialog)paramObject);
                this.g = true;
                paramObject.setOnDismissListener(new DialogInterface.OnDismissListener(this) {
                      public void onDismiss(DialogInterface param1DialogInterface) {
                        SendNotificationManager.a(this.a, false);
                      }
                    });
              } 
            } 
          } 
        } 
      } 
      this.b = false;
    } 
  }
  
  public Activity b() {
    WeakReference<Activity> weakReference = this.e;
    return (weakReference != null) ? weakReference.get() : null;
  }
  
  public void b(Activity paramActivity) {
    String str;
    if (paramActivity == null)
      return; 
    if (paramActivity instanceof com.soft.blued.ui.live.activity.SendFeedDialogActivity)
      return; 
    this.e = new WeakReference<Activity>(paramActivity);
    this.d = paramActivity.getClass().getSimpleName();
    Activity activity = null;
    Fragment fragment = c(paramActivity);
    paramActivity = activity;
    if (fragment != null)
      str = fragment.getClass().getSimpleName(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("curActivityName: ");
    stringBuilder.append(this.d);
    stringBuilder.append(", curFragmentName:");
    stringBuilder.append(str);
    LogUtils.c(stringBuilder.toString());
  }
  
  public void b(BluedIngSelfFeed paramBluedIngSelfFeed) {
    b(paramBluedIngSelfFeed, true);
  }
  
  public Fragment c(Activity paramActivity) {
    Fragment fragment2 = null;
    List<Fragment> list = null;
    if (paramActivity == null)
      return null; 
    Fragment fragment1 = fragment2;
    if (paramActivity instanceof FragmentActivity) {
      List<Fragment> list1 = ((FragmentActivity)paramActivity).getSupportFragmentManager().getFragments();
      fragment1 = fragment2;
      if (list1.size() > 0) {
        int i = list1.size() - 1;
        while (true) {
          fragment1 = fragment2;
          if (i >= 0) {
            if (list1.get(i) instanceof com.blued.android.core.ui.BaseFragment) {
              Fragment fragment;
              fragment2 = list1.get(i);
              list1 = list;
              if (fragment2.isAdded()) {
                list1 = list;
                if (!fragment2.isHidden()) {
                  list1 = list;
                  if (!fragment2.isDetached()) {
                    List<Fragment> list2 = fragment2.getChildFragmentManager().getFragments();
                    list1 = list;
                    if (list2.size() > 0) {
                      i = list2.size() - 1;
                      while (true) {
                        list1 = list;
                        if (i >= 0) {
                          if (list2.get(i) instanceof com.blued.android.core.ui.BaseFragment && ((Fragment)list2.get(i)).getUserVisibleHint()) {
                            fragment = list2.get(i);
                            break;
                          } 
                          i--;
                          continue;
                        } 
                        break;
                      } 
                    } 
                  } 
                } 
              } 
              fragment1 = fragment;
              if (fragment == null)
                return fragment2; 
              break;
            } 
            i--;
            continue;
          } 
          break;
        } 
      } 
    } 
    return fragment1;
  }
  
  class RemoveRunnable implements Runnable {
    private FrameLayout b;
    
    private View c;
    
    private BluedIngSelfFeed d;
    
    private boolean e;
    
    public RemoveRunnable(SendNotificationManager this$0, FrameLayout param1FrameLayout, View param1View, BluedIngSelfFeed param1BluedIngSelfFeed, boolean param1Boolean) {
      this.b = param1FrameLayout;
      this.c = param1View;
      this.d = param1BluedIngSelfFeed;
      this.e = param1Boolean;
    }
    
    public void run() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RemoveRunnable.run: ");
      stringBuilder.append(this.b.hashCode());
      LogUtils.c(stringBuilder.toString());
      View view = this.c;
      if (view != null && view.getParent() != null) {
        SendNotificationManager.a(this.a, this.b, this.c, null, false);
        return;
      } 
      LogUtils.c("view has removed");
    }
  }
  
  static class ViewState {
    View a;
    
    SendNotificationManager.RemoveRunnable b;
    
    public ViewState(View param1View) {
      this.a = param1View;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\manager\SendNotificationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */