package com.blued.android.module.live.base.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.res_china.R;

public class LiveUserRelationshipUtils {
  public static void a(Context paramContext, String paramString, TextView paramTextView, ImageView paramImageView) {
    a(paramContext, paramString, paramTextView, paramImageView, true);
  }
  
  public static void a(Context paramContext, String paramString, TextView paramTextView, ImageView paramImageView, boolean paramBoolean) {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramTextView != null) {
        if (paramBoolean)
          paramTextView.setTextColor(BluedSkinUtils.a(paramContext, R.color.syc_dark_79818D)); 
        if ("0".equals(paramString)) {
          paramTextView.setText(R.string.attention);
          if (paramBoolean)
            paramTextView.setTextColor(BluedSkinUtils.a(paramContext, R.color.syc_a)); 
        } else if ("1".equals(paramString)) {
          paramTextView.setText(R.string.followed);
        } else if ("2".equals(paramString)) {
          paramTextView.setText(R.string.being_followed);
          if (paramBoolean)
            paramTextView.setTextColor(BluedSkinUtils.a(paramContext, R.color.syc_a)); 
        } else if ("3".equals(paramString)) {
          paramTextView.setText(R.string.follow_eachother);
        } else {
          paramTextView.setText(R.string.attention);
        } 
      } 
      if (paramImageView != null) {
        if ("0".equals(paramString)) {
          paramImageView.setImageResource(R.drawable.icon_usercard_add_attention);
          return;
        } 
        if ("1".equals(paramString)) {
          paramImageView.setImageResource(R.drawable.icon_usercard_followed);
          return;
        } 
        if ("2".equals(paramString)) {
          paramImageView.setImageResource(R.drawable.icon_usercard_add_attention);
          return;
        } 
        if ("3".equals(paramString)) {
          paramImageView.setImageResource(R.drawable.icon_userlist_follow_each);
          return;
        } 
        paramImageView.setImageResource(R.drawable.icon_usercard_add_attention);
      } 
    } 
  }
  
  public static void b(Context paramContext, String paramString, TextView paramTextView, ImageView paramImageView) {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramTextView != null) {
        paramTextView.setTextColor(paramContext.getResources().getColor(R.color.syc_b));
        if ("0".equals(paramString)) {
          paramTextView.setText(R.string.attention);
        } else if ("1".equals(paramString)) {
          paramTextView.setText(R.string.followed);
        } else if ("2".equals(paramString)) {
          paramTextView.setText(R.string.being_followed);
        } else if ("3".equals(paramString)) {
          paramTextView.setText(R.string.follow_eachother);
        } else {
          paramTextView.setText(R.string.attention);
        } 
      } 
      if (paramImageView != null) {
        if ("0".equals(paramString)) {
          paramImageView.setImageResource(R.drawable.icon_usercard_add_attention_white);
          return;
        } 
        if ("1".equals(paramString)) {
          paramImageView.setImageResource(R.drawable.icon_usercard_followed_white);
          return;
        } 
        if ("2".equals(paramString)) {
          paramImageView.setImageResource(R.drawable.icon_usercard_add_attention_white);
          return;
        } 
        if ("3".equals(paramString)) {
          paramImageView.setImageResource(R.drawable.icon_userlist_follow_each_white);
          return;
        } 
        paramImageView.setImageResource(R.drawable.icon_usercard_add_attention_white);
      } 
    } 
  }
  
  public static interface IAddOrRemoveAttentionDone {
    void R_();
    
    void a(String param1String);
    
    void b(String param1String);
    
    void d();
    
    void e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\bas\\utils\LiveUserRelationshipUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */