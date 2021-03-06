package pub.devrel.easypermissions;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;



import pub.devrel.easypermissions.easyPermission.SupportEasyPermission;

/**
 * author: baiiu
 * date: on 16/12/20 16:31
 * description:
 */

public abstract class BaseSuppoprtPermissionFragment extends Fragment implements SupportEasyPermission.PermissionCallback {
    protected Context mContext;
    private int mRequestCode;
    private String[] mPermissions;
    private PermissionCallBackM mPermissionCallBack;

    //rationale: 申请授权理由
    protected void requestPermission(int requestCode, String[] permissions, String rationale,
            PermissionCallBackM permissionCallback) {
        this.mRequestCode = requestCode;
        this.mPermissionCallBack = permissionCallback;
        this.mPermissions = permissions;

        SupportEasyPermission.with(this)
                .addRequestCode(requestCode)
                .permissions(permissions)
                //.nagativeButtonText(android.R.string.ok)
                //.positveButtonText(android.R.string.cancel)
                .rationale(rationale)
                .request();
    }

    @Override public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
            @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        SupportEasyPermission.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @Override public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*
            从Settings界面跳转回来，标准代码，就这么写
        */
        if (requestCode == SupportEasyPermission.SETTINGS_REQ_CODE) {
            if (SupportEasyPermission.hasPermissions(mContext, mPermissions)) {
                //已授权，处理业务逻辑
                onEasyPermissionGranted(mRequestCode, mPermissions);
            } else {
                onEasyPermissionDenied(mRequestCode, mPermissions);
            }
        }
    }

    @Override public void onEasyPermissionGranted(int requestCode, String... perms) {
        if (mPermissionCallBack != null) {
            mPermissionCallBack.onPermissionGrantedM(requestCode, perms);
        }
    }

    @Override public void onEasyPermissionDenied(final int requestCode, final String... perms) {
        //rationale: Never Ask Again后的提示信息
        if (SupportEasyPermission.checkDeniedPermissionsNeverAskAgain(this, "授权啊,不授权没法用啊," + "去设置里授权大哥", android.R.string.ok,
                                                               android.R.string.cancel,
                                                               new DialogInterface.OnClickListener() {
                                                                   @Override public void onClick(DialogInterface dialog,
                                                                           int which) {
                                                                       if (mPermissionCallBack != null) {
                                                                           mPermissionCallBack.onPermissionDeniedM(
                                                                                   requestCode, perms);
                                                                       }
                                                                   }
                                                               }, perms)) {
            return;
        }

        if (mPermissionCallBack != null) {
            mPermissionCallBack.onPermissionDeniedM(requestCode, perms);
        }
    }
}
