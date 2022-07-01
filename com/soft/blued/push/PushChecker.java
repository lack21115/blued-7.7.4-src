package com.soft.blued.push;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.das.message.MessageProtos;
import com.heytap.mcssdk.PushManager;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.msg.customview.TranslationAnimHintView;
import com.soft.blued.ui.setting.fragment.RemindSettingFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;

public class PushChecker {
  public static PushChecker a() {
    return PushCheckerHolder.a;
  }
  
  private String a(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 1) ? ((paramInt != 2) ? "" : AppInfo.d().getString(2131755296)) : AppInfo.d().getString(2131755291)) : AppInfo.d().getString(2131755295);
  }
  
  private void a(Context paramContext) {
    Intent intent = new Intent();
    if (Build.VERSION.SDK_INT >= 26) {
      intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
      intent.putExtra("android.provider.extra.APP_PACKAGE", paramContext.getPackageName());
    } else if (Build.VERSION.SDK_INT >= 21) {
      intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
      intent.putExtra("app_package", paramContext.getPackageName());
      intent.putExtra("app_uid", (paramContext.getApplicationInfo()).uid);
    } else {
      intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
      intent.setData(Uri.fromParts("package", paramContext.getPackageName(), null));
    } 
    intent.setFlags(268435456);
    paramContext.startActivity(intent);
  }
  
  private void b(Context paramContext, int paramInt, MessageProtos.WarnTime paramWarnTime) {
    BluedPreferences.h(System.currentTimeMillis() + ((BluedConfig.b().c()).message_push_box * 86400000));
    EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_SHOW, MessageProtos.WarnType.POP_PUSH, paramWarnTime);
    if (Build.MANUFACTURER.toLowerCase().equals("oppo") && !BluedPreferences.cX()) {
      PushManager.a().j();
      BluedPreferences.cY();
      return;
    } 
    RemindDialog remindDialog = new RemindDialog(this, paramContext, paramInt, paramWarnTime);
    remindDialog.a(new View.OnClickListener(this, remindDialog, paramWarnTime, paramContext) {
          public void onClick(View param1View) {
            this.a.dismiss();
            EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLICK, MessageProtos.WarnType.POP_PUSH, this.b);
            PushChecker.a(this.d, this.c);
          }
        });
    remindDialog.show();
  }
  
  private boolean b() {
    return (System.currentTimeMillis() < BluedPreferences.cJ());
  }
  
  private boolean b(Context paramContext) {
    try {
      return NotificationManagerCompat.from(paramContext).areNotificationsEnabled();
    } catch (Exception exception) {
      exception.printStackTrace();
      return false;
    } 
  }
  
  private boolean c() {
    return (System.currentTimeMillis() < BluedPreferences.cK());
  }
  
  private boolean d() {
    return (System.currentTimeMillis() < BluedPreferences.cL());
  }
  
  private boolean e() {
    return (System.currentTimeMillis() < BluedPreferences.cM());
  }
  
  public void a(Context paramContext, int paramInt, MessageProtos.WarnTime paramWarnTime) {
    if ((BluedConfig.b().c()).message_push_box == 0)
      return; 
    if (b(paramContext))
      return; 
    if (b())
      return; 
    b(paramContext, paramInt, paramWarnTime);
  }
  
  public void a(View paramView, int paramInt, MessageProtos.WarnTime paramWarnTime) {
    if (paramView == null)
      return; 
    if ((BluedConfig.b().c()).message_push_box == 0)
      return; 
    if (paramInt == 2) {
      if (b(paramView.getContext()) || c())
        return; 
    } else if (paramInt == 0) {
      if (BluedPreferences.ai() || e())
        return; 
    } else if (paramInt == 1 && (BluedPreferences.ag() || d())) {
      return;
    } 
    paramView.setVisibility(0);
    ImageView imageView = (ImageView)paramView.findViewById(2131297729);
    ((TextView)paramView.findViewById(2131300890)).setText(a(paramInt));
    paramView.setOnClickListener(new View.OnClickListener(this, paramInt, paramWarnTime, paramView) {
          public void onClick(View param1View) {
            if (this.a == 2) {
              PushChecker.a(this.d, param1View.getContext());
              EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLICK, MessageProtos.WarnType.TOAST_PUSH_PERMANENT, this.b);
              return;
            } 
            InstantLog.b("my_model", 6);
            TerminalActivity.d(this.c.getContext(), RemindSettingFragment.class, null);
            EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLICK, MessageProtos.WarnType.TOAST_PUSH, this.b);
          }
        });
    imageView.setOnClickListener(new View.OnClickListener(this, paramInt, paramWarnTime, paramView) {
          public void onClick(View param1View) {
            if (this.a == 2) {
              BluedPreferences.i(System.currentTimeMillis() + ((BluedConfig.b().c()).message_push_box * 86400000));
              EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLOSE, MessageProtos.WarnType.TOAST_PUSH_PERMANENT, this.b);
            } else {
              EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLOSE, MessageProtos.WarnType.TOAST_PUSH, this.b);
            } 
            int i = this.a;
            if (i == 0) {
              BluedPreferences.k(System.currentTimeMillis() + ((BluedConfig.b().c()).message_push_box * 86400000));
            } else if (i == 1) {
              BluedPreferences.j(System.currentTimeMillis() + ((BluedConfig.b().c()).message_push_box * 86400000));
            } 
            this.c.setVisibility(8);
          }
        });
    if (paramInt == 2) {
      EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_SHOW, MessageProtos.WarnType.TOAST_PUSH_PERMANENT, paramWarnTime);
      return;
    } 
    EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_SHOW, MessageProtos.WarnType.TOAST_PUSH, paramWarnTime);
  }
  
  public void a(TranslationAnimHintView paramTranslationAnimHintView, int paramInt, MessageProtos.WarnTime paramWarnTime) {
    if (paramTranslationAnimHintView == null)
      return; 
    if ((BluedConfig.b().c()).message_push_box == 0)
      return; 
    byte b = 1;
    if (paramInt == 2) {
      if (b(paramTranslationAnimHintView.getContext()) || c())
        return; 
    } else if (paramInt == 0) {
      if (BluedPreferences.ai() || e())
        return; 
    } else if (paramInt == 1 && (BluedPreferences.ag() || d())) {
      return;
    } 
    TranslationAnimHintView.HintInfo hintInfo = new TranslationAnimHintView.HintInfo();
    if (paramInt == 2)
      b = 2; 
    hintInfo.a = b;
    hintInfo.b = a(paramInt);
    hintInfo.d = new View.OnClickListener(this, paramInt, paramWarnTime, paramTranslationAnimHintView) {
        public void onClick(View param1View) {
          if (this.a == 2) {
            PushChecker.a(this.d, param1View.getContext());
            EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLICK, MessageProtos.WarnType.TOAST_PUSH_PERMANENT, this.b);
            return;
          } 
          InstantLog.b("my_model", 6);
          TerminalActivity.d(this.c.getContext(), RemindSettingFragment.class, null);
          EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLICK, MessageProtos.WarnType.TOAST_PUSH, this.b);
        }
      };
    hintInfo.c = new View.OnClickListener(this, paramInt, paramWarnTime, paramTranslationAnimHintView, hintInfo) {
        public void onClick(View param1View) {
          if (this.a == 2) {
            BluedPreferences.i(System.currentTimeMillis() + ((BluedConfig.b().c()).message_push_box * 86400000));
            EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLOSE, MessageProtos.WarnType.TOAST_PUSH_PERMANENT, this.b);
          } else {
            EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLOSE, MessageProtos.WarnType.TOAST_PUSH, this.b);
          } 
          int i = this.a;
          if (i == 0) {
            BluedPreferences.k(System.currentTimeMillis() + ((BluedConfig.b().c()).message_push_box * 86400000));
          } else if (i == 1) {
            BluedPreferences.j(System.currentTimeMillis() + ((BluedConfig.b().c()).message_push_box * 86400000));
          } 
          this.c.a(this.d.a);
        }
      };
    paramTranslationAnimHintView.a(hintInfo);
    if (paramInt == 2) {
      EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_SHOW, MessageProtos.WarnType.TOAST_PUSH_PERMANENT, paramWarnTime);
      return;
    } 
    EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_SHOW, MessageProtos.WarnType.TOAST_PUSH, paramWarnTime);
  }
  
  public static class PushCheckerHolder {
    public static PushChecker a = new PushChecker();
  }
  
  class RemindDialog extends Dialog {
    private Context b;
    
    private int c;
    
    private MessageProtos.WarnTime d;
    
    private View.OnClickListener e;
    
    public RemindDialog(PushChecker this$0, Context param1Context, int param1Int, MessageProtos.WarnTime param1WarnTime) {
      super(param1Context);
      this.b = param1Context;
      this.c = param1Int;
      this.d = param1WarnTime;
    }
    
    private void a(View param1View, int param1Int, MessageProtos.WarnTime param1WarnTime) {
      param1View.findViewById(2131297729).setOnClickListener(new View.OnClickListener(this, param1WarnTime) {
            public void onClick(View param2View) {
              EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLOSE, MessageProtos.WarnType.POP_PUSH, this.a);
              this.b.dismiss();
            }
          });
      TextView textView2 = (TextView)param1View.findViewById(2131300704);
      TextView textView3 = (TextView)param1View.findViewById(2131301409);
      TextView textView1 = (TextView)param1View.findViewById(2131296601);
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int == 2) {
            textView3.setText(this.b.getString(2131755290));
            textView2.setText(this.b.getString(2131755289));
            textView1.setText(this.b.getString(2131755288));
          } 
        } else {
          textView3.setText(this.b.getString(2131755287));
          textView2.setText(this.b.getString(2131755286));
          textView1.setText(this.b.getString(2131755285));
        } 
      } else {
        textView3.setText(this.b.getString(2131755294));
        textView2.setText(this.b.getString(2131755293));
        textView1.setText(this.b.getString(2131755292));
      } 
      View.OnClickListener onClickListener = this.e;
      if (onClickListener != null)
        textView1.setOnClickListener(onClickListener); 
    }
    
    public void a(View.OnClickListener param1OnClickListener) {
      this.e = param1OnClickListener;
    }
    
    protected void onCreate(Bundle param1Bundle) {
      View view = LayoutInflater.from(this.b).inflate(2131493029, null);
      setContentView(view);
      a(view, this.c, this.d);
      Window window = getWindow();
      if (window != null)
        window.setBackgroundDrawableResource(17170445); 
    }
  }
  
  class null implements View.OnClickListener {
    null(PushChecker this$0, MessageProtos.WarnTime param1WarnTime) {}
    
    public void onClick(View param1View) {
      EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLOSE, MessageProtos.WarnType.POP_PUSH, this.a);
      this.b.dismiss();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\push\PushChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */