package com.soft.blued.view.tip.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.login_register.model.UpdateTerms;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.AppUtils;

public class PrivacyClauseDialog extends AlertDialog {
  private Context a;
  
  private TextView b;
  
  private TextView c;
  
  private TextView d;
  
  private TextView e;
  
  private TextView f;
  
  private UpdateTerms g;
  
  public PrivacyClauseDialog(Context paramContext, UpdateTerms paramUpdateTerms) {
    super(paramContext);
    this.a = paramContext;
    this.g = paramUpdateTerms;
  }
  
  private void a() {
    this.b = (TextView)findViewById(2131300663);
    this.c = (TextView)findViewById(2131300964);
    this.d = (TextView)findViewById(2131300965);
    this.e = (TextView)findViewById(2131301131);
    this.f = (TextView)findViewById(2131301455);
    UpdateTerms updateTerms = this.g;
    if (updateTerms == null)
      return; 
    this.b.setText(updateTerms.description);
    if (this.g.jump_links.size() > 0) {
      this.c.setVisibility(0);
      this.c.setText(((UpdateTerms.Link)this.g.jump_links.get(0)).text);
      this.c.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (PrivacyClauseDialog.a(this.a) != null)
                WebViewShowInfoFragment.show(PrivacyClauseDialog.b(this.a), ((UpdateTerms.Link)(PrivacyClauseDialog.a(this.a)).jump_links.get(0)).link, 0); 
            }
          });
    } else {
      this.c.setVisibility(8);
    } 
    if (this.g.jump_links.size() > 1) {
      this.d.setVisibility(0);
      this.d.setText(((UpdateTerms.Link)this.g.jump_links.get(1)).text);
      this.d.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (PrivacyClauseDialog.a(this.a) != null)
                WebViewShowInfoFragment.show(PrivacyClauseDialog.b(this.a), ((UpdateTerms.Link)(PrivacyClauseDialog.a(this.a)).jump_links.get(1)).link, 0); 
            }
          });
    } else {
      this.d.setVisibility(8);
    } 
    if (this.g.button.size() > 0) {
      this.e.setVisibility(0);
      this.e.setText(((UpdateTerms.Button)this.g.button.get(0)).text);
      this.e.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              FindHttpUtils.a(((UpdateTerms.Button)(PrivacyClauseDialog.a(this.a)).button.get(0)).click_url);
              PrivacyClauseDialog privacyClauseDialog = this.a;
              PrivacyClauseDialog.a(privacyClauseDialog, ((UpdateTerms.Button)(PrivacyClauseDialog.a(privacyClauseDialog)).button.get(0)).click_type);
            }
          });
    } else {
      this.e.setVisibility(8);
    } 
    if (this.g.button.size() > 1) {
      this.f.setVisibility(0);
      this.f.setText(((UpdateTerms.Button)this.g.button.get(1)).text);
      this.f.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              FindHttpUtils.a(((UpdateTerms.Button)(PrivacyClauseDialog.a(this.a)).button.get(1)).click_url);
              PrivacyClauseDialog privacyClauseDialog = this.a;
              PrivacyClauseDialog.a(privacyClauseDialog, ((UpdateTerms.Button)(PrivacyClauseDialog.a(privacyClauseDialog)).button.get(1)).click_type);
            }
          });
      return;
    } 
    this.f.setVisibility(8);
  }
  
  private void a(int paramInt) {
    if (paramInt == 0) {
      dismiss();
      return;
    } 
    AppUtils.a(this.a);
  }
  
  public static void a(Context paramContext, IRequestHost paramIRequestHost) {
    b(paramContext, paramIRequestHost);
  }
  
  private static void b(Context paramContext, IRequestHost paramIRequestHost) {
    AppHttpUtils.a(paramContext, new BluedUIHttpResponse<BluedEntityA<UpdateTerms>>(paramIRequestHost, paramContext) {
          protected void a(BluedEntityA<UpdateTerms> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              UpdateTerms updateTerms = (UpdateTerms)param1BluedEntityA.getSingleData();
              if (PrivacyClauseDialog.a(updateTerms))
                (new PrivacyClauseDialog(this.a, updateTerms)).show(); 
            } 
          }
        }paramIRequestHost);
  }
  
  private static boolean b(UpdateTerms paramUpdateTerms) {
    return (paramUpdateTerms != null && paramUpdateTerms.is_open == 1 && !TextUtils.isEmpty(paramUpdateTerms.description) && paramUpdateTerms.jump_links != null && paramUpdateTerms.jump_links.size() > 0 && paramUpdateTerms.button != null && paramUpdateTerms.button.size() > 0);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131493027);
    a();
    Window window = getWindow();
    if (window != null)
      window.setBackgroundDrawableResource(17170445); 
    setCanceledOnTouchOutside(false);
    setCancelable(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\view\tip\dialog\PrivacyClauseDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */