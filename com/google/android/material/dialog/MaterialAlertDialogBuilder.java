package com.google.android.material.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;

public class MaterialAlertDialogBuilder extends AlertDialog.Builder {
  private static final int a = R.attr.alertDialogStyle;
  
  private static final int b = R.style.MaterialAlertDialog_MaterialComponents;
  
  private static final int c = R.attr.materialAlertDialogTheme;
  
  private Drawable d;
  
  private final Rect e;
  
  public MaterialAlertDialogBuilder a(int paramInt) {
    return (MaterialAlertDialogBuilder)super.setTitle(paramInt);
  }
  
  public MaterialAlertDialogBuilder a(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener) {
    return (MaterialAlertDialogBuilder)super.setSingleChoiceItems(paramInt1, paramInt2, paramOnClickListener);
  }
  
  public MaterialAlertDialogBuilder a(int paramInt, DialogInterface.OnClickListener paramOnClickListener) {
    return (MaterialAlertDialogBuilder)super.setPositiveButton(paramInt, paramOnClickListener);
  }
  
  public MaterialAlertDialogBuilder a(int paramInt, boolean[] paramArrayOfboolean, DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener) {
    return (MaterialAlertDialogBuilder)super.setMultiChoiceItems(paramInt, paramArrayOfboolean, paramOnMultiChoiceClickListener);
  }
  
  public MaterialAlertDialogBuilder a(DialogInterface.OnCancelListener paramOnCancelListener) {
    return (MaterialAlertDialogBuilder)super.setOnCancelListener(paramOnCancelListener);
  }
  
  public MaterialAlertDialogBuilder a(DialogInterface.OnDismissListener paramOnDismissListener) {
    return (MaterialAlertDialogBuilder)super.setOnDismissListener(paramOnDismissListener);
  }
  
  public MaterialAlertDialogBuilder a(DialogInterface.OnKeyListener paramOnKeyListener) {
    return (MaterialAlertDialogBuilder)super.setOnKeyListener(paramOnKeyListener);
  }
  
  public MaterialAlertDialogBuilder a(Cursor paramCursor, int paramInt, String paramString, DialogInterface.OnClickListener paramOnClickListener) {
    return (MaterialAlertDialogBuilder)super.setSingleChoiceItems(paramCursor, paramInt, paramString, paramOnClickListener);
  }
  
  public MaterialAlertDialogBuilder a(Cursor paramCursor, DialogInterface.OnClickListener paramOnClickListener, String paramString) {
    return (MaterialAlertDialogBuilder)super.setCursor(paramCursor, paramOnClickListener, paramString);
  }
  
  public MaterialAlertDialogBuilder a(Cursor paramCursor, String paramString1, String paramString2, DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener) {
    return (MaterialAlertDialogBuilder)super.setMultiChoiceItems(paramCursor, paramString1, paramString2, paramOnMultiChoiceClickListener);
  }
  
  public MaterialAlertDialogBuilder a(Drawable paramDrawable) {
    return (MaterialAlertDialogBuilder)super.setIcon(paramDrawable);
  }
  
  public MaterialAlertDialogBuilder a(View paramView) {
    return (MaterialAlertDialogBuilder)super.setCustomTitle(paramView);
  }
  
  public MaterialAlertDialogBuilder a(AdapterView.OnItemSelectedListener paramOnItemSelectedListener) {
    return (MaterialAlertDialogBuilder)super.setOnItemSelectedListener(paramOnItemSelectedListener);
  }
  
  public MaterialAlertDialogBuilder a(ListAdapter paramListAdapter, int paramInt, DialogInterface.OnClickListener paramOnClickListener) {
    return (MaterialAlertDialogBuilder)super.setSingleChoiceItems(paramListAdapter, paramInt, paramOnClickListener);
  }
  
  public MaterialAlertDialogBuilder a(ListAdapter paramListAdapter, DialogInterface.OnClickListener paramOnClickListener) {
    return (MaterialAlertDialogBuilder)super.setAdapter(paramListAdapter, paramOnClickListener);
  }
  
  public MaterialAlertDialogBuilder a(CharSequence paramCharSequence) {
    return (MaterialAlertDialogBuilder)super.setTitle(paramCharSequence);
  }
  
  public MaterialAlertDialogBuilder a(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener) {
    return (MaterialAlertDialogBuilder)super.setPositiveButton(paramCharSequence, paramOnClickListener);
  }
  
  public MaterialAlertDialogBuilder a(boolean paramBoolean) {
    return (MaterialAlertDialogBuilder)super.setCancelable(paramBoolean);
  }
  
  public MaterialAlertDialogBuilder a(CharSequence[] paramArrayOfCharSequence, int paramInt, DialogInterface.OnClickListener paramOnClickListener) {
    return (MaterialAlertDialogBuilder)super.setSingleChoiceItems(paramArrayOfCharSequence, paramInt, paramOnClickListener);
  }
  
  public MaterialAlertDialogBuilder a(CharSequence[] paramArrayOfCharSequence, DialogInterface.OnClickListener paramOnClickListener) {
    return (MaterialAlertDialogBuilder)super.setItems(paramArrayOfCharSequence, paramOnClickListener);
  }
  
  public MaterialAlertDialogBuilder a(CharSequence[] paramArrayOfCharSequence, boolean[] paramArrayOfboolean, DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener) {
    return (MaterialAlertDialogBuilder)super.setMultiChoiceItems(paramArrayOfCharSequence, paramArrayOfboolean, paramOnMultiChoiceClickListener);
  }
  
  public MaterialAlertDialogBuilder b(int paramInt) {
    return (MaterialAlertDialogBuilder)super.setMessage(paramInt);
  }
  
  public MaterialAlertDialogBuilder b(int paramInt, DialogInterface.OnClickListener paramOnClickListener) {
    return (MaterialAlertDialogBuilder)super.setNegativeButton(paramInt, paramOnClickListener);
  }
  
  public MaterialAlertDialogBuilder b(Drawable paramDrawable) {
    return (MaterialAlertDialogBuilder)super.setPositiveButtonIcon(paramDrawable);
  }
  
  public MaterialAlertDialogBuilder b(View paramView) {
    return (MaterialAlertDialogBuilder)super.setView(paramView);
  }
  
  public MaterialAlertDialogBuilder b(CharSequence paramCharSequence) {
    return (MaterialAlertDialogBuilder)super.setMessage(paramCharSequence);
  }
  
  public MaterialAlertDialogBuilder b(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener) {
    return (MaterialAlertDialogBuilder)super.setNegativeButton(paramCharSequence, paramOnClickListener);
  }
  
  public MaterialAlertDialogBuilder c(int paramInt) {
    return (MaterialAlertDialogBuilder)super.setIcon(paramInt);
  }
  
  public MaterialAlertDialogBuilder c(int paramInt, DialogInterface.OnClickListener paramOnClickListener) {
    return (MaterialAlertDialogBuilder)super.setNeutralButton(paramInt, paramOnClickListener);
  }
  
  public MaterialAlertDialogBuilder c(Drawable paramDrawable) {
    return (MaterialAlertDialogBuilder)super.setNegativeButtonIcon(paramDrawable);
  }
  
  public MaterialAlertDialogBuilder c(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener) {
    return (MaterialAlertDialogBuilder)super.setNeutralButton(paramCharSequence, paramOnClickListener);
  }
  
  public AlertDialog create() {
    AlertDialog alertDialog = super.create();
    Window window = alertDialog.getWindow();
    View view = window.getDecorView();
    Drawable drawable = this.d;
    if (drawable instanceof MaterialShapeDrawable)
      ((MaterialShapeDrawable)drawable).r(ViewCompat.getElevation(view)); 
    window.setBackgroundDrawable((Drawable)MaterialDialogs.a(this.d, this.e));
    view.setOnTouchListener(new InsetDialogOnTouchListener((Dialog)alertDialog, this.e));
    return alertDialog;
  }
  
  public MaterialAlertDialogBuilder d(int paramInt) {
    return (MaterialAlertDialogBuilder)super.setIconAttribute(paramInt);
  }
  
  public MaterialAlertDialogBuilder d(int paramInt, DialogInterface.OnClickListener paramOnClickListener) {
    return (MaterialAlertDialogBuilder)super.setItems(paramInt, paramOnClickListener);
  }
  
  public MaterialAlertDialogBuilder d(Drawable paramDrawable) {
    return (MaterialAlertDialogBuilder)super.setNeutralButtonIcon(paramDrawable);
  }
  
  public MaterialAlertDialogBuilder e(int paramInt) {
    return (MaterialAlertDialogBuilder)super.setView(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\dialog\MaterialAlertDialogBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */