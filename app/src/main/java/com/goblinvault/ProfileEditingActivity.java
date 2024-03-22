package com.goblinvault;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.goblinvault.Fragments.MeFragment;

public class ProfileEditingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_edit_profile);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView BtnUpdateProfile = view.findViewById(R.id.BtnUpdateProfile);
        BtnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent it = new Intent(ProfileEditingActivity.this, MeFragment.class);
                startActivity(it);
                finish();
            }
        });
    }
}
