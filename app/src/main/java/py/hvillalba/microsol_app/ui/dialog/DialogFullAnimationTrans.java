package py.hvillalba.microsol_app.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import py.hvillalba.microsol_app.R;
import py.hvillalba.microsol_app.util.eventbus.Events;
import py.hvillalba.microsol_app.util.eventbus.GlobalBus;

public class DialogFullAnimationTrans extends Dialog {
    public DialogFullAnimationTrans(Context context) {
        super(context, R.style.dialogFull);
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        setContentView(R.layout.dialog_full_animation_trans);
    }

    private void dismissDialog() {
        dismiss();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        GlobalBus.getBus().register(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        GlobalBus.getBus().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onModelChange(Events.showAnimationVale showanimationvale) {
        if (showanimationvale.status != 1 && showanimationvale.status == 2) {
            dismissDialog();
        }
    }
}
