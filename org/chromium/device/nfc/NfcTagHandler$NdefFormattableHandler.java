package org.chromium.device.nfc;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.tech.NdefFormatable;

final class NfcTagHandler$NdefFormattableHandler implements NfcTagHandler$TagTechnologyHandler {
  private final NdefFormatable mNdefFormattable;
  
  NfcTagHandler$NdefFormattableHandler(NdefFormatable paramNdefFormatable) {
    this.mNdefFormattable = paramNdefFormatable;
  }
  
  public final NdefMessage read() {
    return new NdefMessage(new NdefRecord((short)0, null, null, null), new NdefRecord[0]);
  }
  
  public final void write(NdefMessage paramNdefMessage) {
    this.mNdefFormattable.format(paramNdefMessage);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\nfc\NfcTagHandler$NdefFormattableHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */