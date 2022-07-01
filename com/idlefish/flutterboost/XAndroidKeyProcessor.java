package com.idlefish.flutterboost;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;

public class XAndroidKeyProcessor {
  private final KeyEventChannel a;
  
  private final XTextInputPlugin b;
  
  private int c;
  
  public XAndroidKeyProcessor(KeyEventChannel paramKeyEventChannel, XTextInputPlugin paramXTextInputPlugin) {
    this.a = paramKeyEventChannel;
    this.b = paramXTextInputPlugin;
  }
  
  private Character a(int paramInt) {
    if (paramInt == 0)
      return null; 
    Character character1 = Character.valueOf((char)paramInt);
    if ((Integer.MIN_VALUE & paramInt) != 0) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      paramInt &= Integer.MAX_VALUE;
      i = this.c;
      if (i != 0) {
        this.c = KeyCharacterMap.getDeadChar(i, paramInt);
        return character1;
      } 
      this.c = paramInt;
      return character1;
    } 
    int i = this.c;
    Character character2 = character1;
    if (i != 0) {
      paramInt = KeyCharacterMap.getDeadChar(i, paramInt);
      if (paramInt > 0)
        character1 = Character.valueOf((char)paramInt); 
      this.c = 0;
      character2 = character1;
    } 
    return character2;
  }
  
  public void a(KeyEvent paramKeyEvent) {
    Character character = a(paramKeyEvent.getUnicodeChar());
    this.a.keyUp(new KeyEventChannel.FlutterKeyEvent(paramKeyEvent, character));
  }
  
  public void b(KeyEvent paramKeyEvent) {
    if (this.b.c() != null && this.b.a().isAcceptingText())
      this.b.c().sendKeyEvent(paramKeyEvent); 
    Character character = a(paramKeyEvent.getUnicodeChar());
    this.a.keyDown(new KeyEventChannel.FlutterKeyEvent(paramKeyEvent, character));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\idlefish\flutterboost\XAndroidKeyProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */