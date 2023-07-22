package lec.baekseokuni.indyholder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import lec.baekseokuni.indyholder.credential.CredentialListActivity;

public class MainActivity extends AppCompatActivity {
    View.OnClickListener onStartDeeplink = v -> {
        SharedPreferences pref = getSharedPreferences("NAME_PREFERENCE", MODE_PRIVATE);
        String name = pref.getString("NAME","");
        if("Kang byung jin".equals(name) ){
            String testDeeplink = "indy://holder?secret=zDkeYhrs8W";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(testDeeplink));
            startActivity(intent);
            finish();
        } else if ("Lee jun seok".equals(name)) {
            String testDeeplink = "indy://holder?secret=xpiIgPvxfN";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(testDeeplink));
            startActivity(intent);
            finish();
        } else if ("Kim jae seong".equals(name)) {
            String testDeeplink = "indy://holder?secret=i6JTc8oX4d";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(testDeeplink));
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener onNavToCredList = v -> {
        Intent intent = new Intent(getApplicationContext(), CredentialListActivity.class);
        startActivity(intent);
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnIssueTest = findViewById(R.id.btn_issue_test_cred);
        Button btnNavToCredList = findViewById(R.id.btn_nav_to_cred_list);
        btnIssueTest.setOnClickListener(onStartDeeplink);
        btnNavToCredList.setOnClickListener(onNavToCredList);
    }
}
