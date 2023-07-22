package lec.baekseokuni.indyholder.credential;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Map;

import kotlin.Pair;
import kr.co.bdgen.indywrapper.data.Credential;
import lec.baekseokuni.indyholder.R;

public class CredentialActivity extends AppCompatActivity {
    public static final String INTENT_EXTRA_ARG_KEY_CRED = "INTENT_EXTRA_ARG_KEY_CRED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credential);
        ActionBar appBar = getSupportActionBar();
        if (appBar != null) {
            appBar.setTitle("증명서 상세");
            appBar.setDisplayHomeAsUpEnabled(true);
        }

        Credential cred = getIntent().getParcelableExtra(INTENT_EXTRA_ARG_KEY_CRED);
        if (cred == null)
            return;

        Map<String, String> attrs = cred.getAttrs();

        ArrayList<Pair<String, String>> attrList = new ArrayList<>();
        attrList.add(new Pair<>("자격증 이름", attrs.get("Certification Name")));
        attrList.add(new Pair<>("자격증 번호", attrs.get("Certificate number")));
        attrList.add(new Pair<>("이름", attrs.get("Name")));
        attrList.add(new Pair<>("생년월일", attrs.get("Birth date")));
        attrList.add(new Pair<>("휴대폰 번호", attrs.get("Phonenumber")));
        attrList.add(new Pair<>("합격일자", attrs.get("Acceptance date")));
        attrList.add(new Pair<>("발행일자", attrs.get("Issue date")));
        attrList.add(new Pair<>("발행기관", attrs.get("Issuer")));


        RecyclerView recyclerView = findViewById(R.id.list_attribute);
        recyclerView.setAdapter(new AttributeRecyclerViewAdapter(attrList));
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}