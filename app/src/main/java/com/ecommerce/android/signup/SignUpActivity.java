package com.ecommerce.android.signup;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ecommerce.android.R;
import com.ecommerce.android.signup.presenter.SignUpPresenter;
import com.ecommerce.android.signup.view.ISignUpView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity implements ISignUpView {


    @BindView(R.id.edt_full_name)
    EditText mFullName;
    @BindView(R.id.edt_last_name)
    EditText mLastName;
    @BindView(R.id.edt_signup_email)
    EditText mEmail;
    @BindView(R.id.edt_signup_password)
    EditText mPassword;
    @BindView(R.id.edt_signup_referral)
    EditText mReferralCode;
    @BindView(R.id.edt_signup_contact)
    EditText mContact;
    @BindView(R.id.chk_sign_up_terms)
    CheckBox mCheckTermsAndCondition;
    @BindView(R.id.rb_signup_male)
    RadioButton mMale;
    @BindView(R.id.rb_signup_female)
    RadioButton mFemale;
    @BindView(R.id.rg_signup_gender)
    RadioGroup mGenderGroup;
    @BindView(R.id.img_back)
    ImageView mBack;
    @BindView(R.id.rl_progress)
    RelativeLayout mProgress;
    @BindView(R.id.btn_sign_up)
    Button mSignUp;

    private Calendar mCalendar;
    private SignUpPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        hideProgressView();
        mPresenter = new SignUpPresenter(this);
        mCalendar = Calendar.getInstance();
    }

    @OnClick({R.id.img_back,R.id.btn_sign_up})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                break;
            case R.id.btn_sign_up:
                mPresenter.attemptSignUpFormSubmission();
                break;
        }
    }


    //region Calendar related stuff here
    private void showDatePicker() {
        new DatePickerDialog(SignUpActivity.this, dobSetListener, mCalendar
                .get(Calendar.YEAR), mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        //TODO:Uncomment below line to display date on textview
        //  mDob.setText(sdf.format(mCalendar.getTime()));
    }

    private DatePickerDialog.OnDateSetListener dobSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mCalendar.set(Calendar.YEAR, year);
            mCalendar.set(Calendar.MONTH, month);
            mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };


    //endregion


    //region implementation of ISignUpView
    @Override
    public void signUpFailed(String message) {
        Toast.makeText(SignUpActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void SignUpSuccess(String message) {

    }

    @Override
    public String getFullName() {
        return String.valueOf(mFullName.getText());
    }

    @Override
    public String getEmail() {
        return String.valueOf(mEmail.getText());
    }

    @Override
    public String getPassword() {
        return String.valueOf(mPassword.getText());
    }

    @Override
    public String getContactNo() {
        return String.valueOf(mContact.getText());
    }

    @Override
    public String getGender() {
        int selectedId = mGenderGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            return "";
        }
        RadioButton btn = (RadioButton) findViewById(selectedId);
        return String.valueOf(btn.getText());
    }

    @Override
    public String getReferralCode() {
        return String.valueOf(mReferralCode.getText());
    }

    @Override
    public boolean getTermsAndConditionCheckStatus() {
        return mCheckTermsAndCondition.isChecked();
    }

    @Override
    public void hideProgressView() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void showProgressView() {
        mProgress.setVisibility(View.VISIBLE);
    }
    //endregion
}
