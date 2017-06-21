package com.ecommerce.android.basicinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ecommerce.android.R;
import com.ecommerce.android.basicinfo.presenter.BasicInfoPresenter;
import com.ecommerce.android.basicinfo.view.IBasicInfoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BasicInfoActivity extends AppCompatActivity implements IBasicInfoView {
    public static final String USER_KEY_FULLNAME = "full_name";
    public static final String USER_KEY_CONTACT = "contact_number";
    @BindView(R.id.edt_basic_info_full_name)
    EditText mFullName;
    @BindView(R.id.edt_basic_info_contact_no)
    EditText mContactNo;
    @BindView(R.id.chk_basic_info_terms)
    CheckBox mTerms;
    @BindView(R.id.btn_basic_info_continue)
    Button mContinue;
    @BindView(R.id.rl_progress)
    RelativeLayout rlProgress;

    private BasicInfoPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_info);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mPresenter = new BasicInfoPresenter(this);
        hideProgressView();
    }

    @OnClick(R.id.btn_basic_info_continue)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_basic_info_continue:
                mPresenter.attemptBasicInfoSubmission();
                break;
        }
    }

    @Override
    public void basicInfoFailed(String message) {
        Toast.makeText(BasicInfoActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void basicInfoSuccess(String message) {

    }

    @Override
    public String getFullName() {
        return String.valueOf(mFullName.getText());
    }

    @Override
    public String getContactNo() {
        return String.valueOf(mContactNo.getText());
    }

    @Override
    public boolean getTermsAndConditionCheckStatus() {
        return mTerms.isChecked();
    }

    @Override
    public void hideProgressView() {
        rlProgress.setVisibility(View.GONE);
    }

    @Override
    public void showProgressView() {
        rlProgress.setVisibility(View.VISIBLE);
    }
}
