package com.zsf.zpermission;


import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zsf.zpermission_util.PermissionHelper;
import com.zsf.zpermission_util.PermissionInterface;


public class MainActivity extends AppCompatActivity implements PermissionInterface {

    private PermissionHelper permissionHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        permissionHelper = new PermissionHelper(this,this);
        permissionHelper.requestPermissions();
    }

    @Override
    public String[] getPermissions() {
        return new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION
        };
    }

    @Override
    public void requestPermissionsSuccess() {
        Toast.makeText(this, "requestPermissionsSuccess", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void requestPermissionsFail() {
        Toast.makeText(this, "requestPermissionsFail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (permissionHelper.requestPermissionsResult(requestCode,permissions,grantResults)){
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}
