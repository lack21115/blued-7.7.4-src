package com.soft.blued.ui.circle.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.das.client.feed.FeedProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CenterAlignImageSpan;
import com.soft.blued.db.model.NewFeedModel;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.fragment.ApplyJoinCircleDialogFragment;
import com.soft.blued.ui.circle.fragment.ApplyJoinCircleFragment;
import com.soft.blued.ui.circle.observer.ICircleDataObserver;
import com.soft.blued.ui.feed.manager.ChildPhotoManager;
import com.soft.blued.ui.feed.manager.FeedSendManager;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.Locale;

public class CircleMethods {
  public static SpannableStringBuilder addAuditing(MyCircleTalkModel paramMyCircleTalkModel, CharSequence paramCharSequence) {
    Drawable drawable;
    if (paramMyCircleTalkModel.is_auditing == 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("auditing ");
      stringBuilder.append(paramCharSequence);
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
      drawable = AppInfo.d().getResources().getDrawable(2131231314);
      if ("en".equals(BlueAppLocal.a())) {
        drawable.setBounds(0, 0, AppMethods.a(60), AppMethods.a(16));
      } else {
        drawable.setBounds(0, 0, AppMethods.a(34), AppMethods.a(16));
      } 
      spannableStringBuilder.setSpan(new ImageSpan(drawable, 1), 0, 8, 33);
      return spannableStringBuilder;
    } 
    return new SpannableStringBuilder((CharSequence)drawable);
  }
  
  public static SpannableStringBuilder addTop(BluedIngSelfFeed paramBluedIngSelfFeed, CharSequence paramCharSequence) {
    Drawable drawable;
    if (TextUtils.equals(paramBluedIngSelfFeed.note_from, "top")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("top ");
      stringBuilder.append(paramCharSequence);
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
      drawable = AppInfo.d().getResources().getDrawable(2131231313);
      drawable.setBounds(0, 0, AppMethods.a(32), AppMethods.a(18));
      spannableStringBuilder.setSpan(new CenterAlignImageSpan(drawable), 0, 3, 33);
      return spannableStringBuilder;
    } 
    return new SpannableStringBuilder((CharSequence)drawable);
  }
  
  public static SpannableStringBuilder addVote(BluedIngSelfFeed paramBluedIngSelfFeed, CharSequence paramCharSequence) {
    Drawable drawable;
    if (paramBluedIngSelfFeed.is_posts_vote == 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("  ");
      stringBuilder.append(paramCharSequence);
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
      drawable = AppInfo.d().getResources().getDrawable(2131232829);
      drawable.setBounds(0, 0, DensityUtils.a(AppInfo.d(), 18.0F), DensityUtils.a(AppInfo.d(), 17.0F));
      spannableStringBuilder.setSpan(new CenterAlignImageSpan(drawable), 0, 1, 1);
      return spannableStringBuilder;
    } 
    return new SpannableStringBuilder((CharSequence)drawable);
  }
  
  public static void applyJoinCircle(final JoinViewChangeListener listener, final CircleJoinState model, FragmentManager paramFragmentManager) {
    if (paramFragmentManager != null)
      ApplyJoinCircleDialogFragment.a(paramFragmentManager, model, new ApplyJoinCircleDialogFragment.ApplyJoinCircleListener() {
            public void onApply() {
              CircleJoinState circleJoinState = model;
              circleJoinState.is_applied = 1;
              CircleMethods.JoinViewChangeListener joinViewChangeListener = listener;
              if (joinViewChangeListener != null)
                joinViewChangeListener.joinViewChange(circleJoinState); 
              CircleMethods.joinCircleEvent(model);
              BluedPreferences.a(model.circle_id, true);
              BluedPreferences.b(model.circle_id, true);
            }
          }); 
  }
  
  public static void circleInvitationJoin(IRequestHost paramIRequestHost, String paramString1, String paramString2, final boolean isShowToast) {
    CircleHttpUtils.b(new BluedUIHttpResponse(paramIRequestHost) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            if (isShowToast)
              AppMethods.d(2131755896); 
          }
        }paramString1, paramString2, paramIRequestHost);
  }
  
  protected static void clearData() {
    SelectPhotoManager.a().d();
    ChildPhotoManager.a().d();
  }
  
  public static void exitCircle(MyCircleModel paramMyCircleModel, IRequestHost paramIRequestHost) {
    CircleHttpUtils.b(paramMyCircleModel.circle_id, new BluedUIHttpResponse<BluedEntityA<CircleDetailsModel>>(paramIRequestHost) {
          protected void onUIUpdate(BluedEntityA<CircleDetailsModel> param1BluedEntityA) {
            if (param1BluedEntityA.hasData())
              LiveEventBus.get("refresh_circle_group_enter", Integer.class).post(Integer.valueOf(((CircleDetailsModel)param1BluedEntityA.data.get(0)).show_groups)); 
          }
        }paramIRequestHost);
    paramMyCircleModel.setExitJoin();
    exitCircleEvent(paramMyCircleModel.getJoinState());
  }
  
  public static void exitCircle(BluedIngSelfFeed paramBluedIngSelfFeed, IRequestHost paramIRequestHost) {
    CircleHttpUtils.b(paramBluedIngSelfFeed.circle_id, new BluedUIHttpResponse<BluedEntityA<CircleDetailsModel>>(paramIRequestHost) {
          protected void onUIUpdate(BluedEntityA<CircleDetailsModel> param1BluedEntityA) {}
        },  paramIRequestHost);
    paramBluedIngSelfFeed.setExitJoin();
    exitCircleEvent(paramBluedIngSelfFeed.getJoinState());
  }
  
  public static void exitCircleEvent(CircleJoinState paramCircleJoinState) {
    LiveEventBus.get("circle_join_state").post(paramCircleJoinState);
  }
  
  public static int getAnonymousHeaderNumber(Context paramContext) {
    if (paramContext != null) {
      TypedArray typedArray = paramContext.getResources().obtainTypedArray(2130903052);
      return (int)(Math.random() * (typedArray.length() - 1));
    } 
    return 0;
  }
  
  public static int getAnonymousHeaderRes(Context paramContext, int paramInt) {
    int j = 2131231273;
    int i = j;
    if (paramContext != null) {
      i = j;
      if (paramInt >= 0) {
        TypedArray typedArray = paramContext.getResources().obtainTypedArray(2130903052);
        i = j;
        if (typedArray.length() > paramInt)
          i = typedArray.getResourceId(paramInt, 2131231273); 
      } 
    } 
    return i;
  }
  
  public static boolean isAnonymousMineUid(String paramString) {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool = false;
    if (bool1)
      return false; 
    String str1 = EncryptTool.a(paramString);
    String str2 = UserInfo.a().i().getUid();
    if (paramString.equals(str2) || str1.equals(str2))
      bool = true; 
    return bool;
  }
  
  public static boolean isCircle(NewFeedModel paramNewFeedModel) {
    return (!TextUtils.isEmpty(paramNewFeedModel.circle_id) && Long.valueOf(paramNewFeedModel.circle_id).longValue() > 0L);
  }
  
  public static boolean isCircle(BluedIngSelfFeed paramBluedIngSelfFeed) {
    return (!TextUtils.isEmpty(paramBluedIngSelfFeed.circle_id) && Long.valueOf(paramBluedIngSelfFeed.circle_id).longValue() > 0L);
  }
  
  public static String isEn(String paramString) {
    if (Locale.getDefault().getLanguage().equals("en")) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("");
      stringBuilder1.append(paramString);
      stringBuilder1.append(" ");
      stringBuilder1.append(AppUtils.a(2131757088));
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append("「");
    stringBuilder.append(paramString);
    stringBuilder.append(AppUtils.a(2131757088));
    return stringBuilder.toString();
  }
  
  public static void joinCircle(final Context context, JoinViewChangeListener paramJoinViewChangeListener, final CircleJoinState model, IRequestHost paramIRequestHost, FragmentManager paramFragmentManager, final boolean showDialog, final boolean isSaveSp) {
    if (model.is_applied == 1)
      return; 
    if (model.is_applied == 2) {
      AppMethods.d(2131755860);
      return;
    } 
    if (model.allow_join == 1) {
      model.setJoin();
      if (paramJoinViewChangeListener != null)
        paramJoinViewChangeListener.joinViewChange(model); 
      joinCircleEvent(model);
      CircleHttpUtils.a(model.circle_id, new BluedUIHttpResponse<BluedEntityA<MyCircleModel>>(paramIRequestHost) {
            protected void onUIUpdate(BluedEntityA<MyCircleModel> param1BluedEntityA) {
              if (param1BluedEntityA.hasData())
                LiveEventBus.get("refresh_circle_group_enter", Integer.class).post(Integer.valueOf(((MyCircleModel)param1BluedEntityA.data.get(0)).show_groups)); 
              if (showDialog) {
                EventTrackFeed.a(FeedProtos.Event.CIRCLE_JOIN_FEED_POP_SHOW);
                CommonAlertDialog.a(context, AppUtils.a(2131757089), CircleMethods.isEn(model.title), AppUtils.a(2131757087), new DialogInterface.OnClickListener() {
                      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                        CircleMethods.send(model.title, "", model.circle_id);
                        EventTrackFeed.a(FeedProtos.Event.CIRCLE_JOIN_FEED_POP_CLICK);
                      }
                    }null, 1);
              } else {
                AppMethods.d(2131755920);
              } 
              if (isSaveSp) {
                BluedPreferences.a(model.circle_id, true);
                BluedPreferences.b(model.circle_id, true);
              } 
            }
          }paramIRequestHost);
      return;
    } 
    model.setExitJoin();
    if (paramJoinViewChangeListener != null)
      paramJoinViewChangeListener.joinViewChange(model); 
    joinCircleEvent(model);
    applyJoinCircle(paramJoinViewChangeListener, model, paramFragmentManager);
  }
  
  public static void joinCircle(Context paramContext, final String circleID, String paramString2, String paramString3, boolean paramBoolean1, final boolean isSaveSp) {
    if (!paramBoolean1) {
      joinCircleEvent(new CircleJoinState(circleID, paramString2, paramString3, 0, 0, 0));
      CircleHttpUtils.a(circleID, new BluedUIHttpResponse<BluedEntityA<MyCircleModel>>(null) {
            protected void onUIUpdate(BluedEntityA<MyCircleModel> param1BluedEntityA) {
              AppMethods.d(2131755920);
              if (param1BluedEntityA.hasData())
                LiveEventBus.get("refresh_circle_group_enter", Integer.class).post(Integer.valueOf(((MyCircleModel)param1BluedEntityA.data.get(0)).show_groups)); 
              if (isSaveSp) {
                BluedPreferences.a(circleID, true);
                BluedPreferences.b(circleID, true);
              } 
            }
          }null);
      return;
    } 
    ApplyJoinCircleFragment.a(paramContext, circleID, paramString2, paramString3);
  }
  
  public static void joinCircleEvent(CircleJoinState paramCircleJoinState) {
    LiveEventBus.get("circle_join_state").post(paramCircleJoinState);
  }
  
  public static void registerFeedListObserver(LifecycleOwner paramLifecycleOwner, final ICircleDataObserver adapter) {
    LiveEventBus.get("circle_join_state", CircleJoinState.class).observe(paramLifecycleOwner, new Observer<CircleJoinState>() {
          public void onChanged(CircleJoinState param1CircleJoinState) {
            if (param1CircleJoinState == null)
              return; 
            adapter.a(param1CircleJoinState);
          }
        });
  }
  
  public static void send(String paramString1, String paramString2, String paramString3) {
    NewFeedModel newFeedModel = new NewFeedModel();
    newFeedModel.setLoadName(Long.parseLong(UserInfo.a().i().getUid()));
    newFeedModel.setState(1);
    newFeedModel.setTime(System.currentTimeMillis());
    newFeedModel.setIsJoinCircle(1);
    newFeedModel.setJoinCircleId(Integer.parseInt(paramString3));
    newFeedModel.setJoinCircleTitle(paramString1);
    if (!TextUtils.isEmpty(paramString2))
      newFeedModel.feed_id = paramString2; 
    newFeedModel.is_anonym = 0;
    FeedSendManager.a().d(newFeedModel);
    clearData();
  }
  
  public static SpannableStringBuilder setEssence(BluedIngSelfFeed paramBluedIngSelfFeed, CharSequence paramCharSequence, boolean paramBoolean) {
    Drawable drawable;
    if (paramBluedIngSelfFeed.is_essence == 1) {
      SpannableStringBuilder spannableStringBuilder;
      if (paramBoolean) {
        spannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("精");
        stringBuilder.append(paramCharSequence);
        spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
      } 
      drawable = AppInfo.d().getResources().getDrawable(2131232420);
      drawable.setBounds(0, 0, AppMethods.a(21), AppMethods.a(17));
      spannableStringBuilder.setSpan(new CenterAlignImageSpan(drawable), 0, 1, 33);
      return spannableStringBuilder;
    } 
    return new SpannableStringBuilder((CharSequence)drawable);
  }
  
  public static void setLevelMark(ImageView paramImageView, int paramInt) {
    setLevelMark(paramImageView, paramInt, 0);
  }
  
  public static void setLevelMark(ImageView paramImageView, int paramInt1, int paramInt2) {
    if (paramImageView == null)
      return; 
    if (paramInt1 != 1) {
      if (paramInt1 != 2) {
        if (paramInt2 == 1) {
          paramImageView.setVisibility(0);
          paramImageView.setImageResource(2131231307);
          return;
        } 
        paramImageView.setVisibility(8);
        return;
      } 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2131231308);
      return;
    } 
    paramImageView.setVisibility(0);
    paramImageView.setImageResource(2131231309);
  }
  
  public static interface JoinViewChangeListener {
    void joinViewChange(CircleJoinState param1CircleJoinState);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\model\CircleMethods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */