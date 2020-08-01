package com.example.mastro.registration_verification;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.mastro.R;
import com.example.mastro.home.date.DHome;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.muddzdev.styleabletoast.StyleableToast;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class MiddlePhase extends AppCompatActivity {

    EditText otp1, otp2, otp3, otp4, otp5, otp6;
    String enteredOTP;
    Button verify;
    ImageButton edit;
    TextView mobile;
    TextView invalidotp;
    CardView verifyCard;

    FirebaseAuth firebaseAuth;
    private String Fullname, Email, PhoneNumber, DOB, Password, VerificationID;
    PhoneAuthProvider.ForceResendingToken token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_matro_selector);

        firebaseAuth = FirebaseAuth.getInstance();
        if (getIntent().getExtras() != null) {
            Fullname = getIntent().getExtras().getString("fullname");
            Email = getIntent().getExtras().getString("email");
            PhoneNumber = getIntent().getExtras().getString("number");
            DOB = getIntent().getExtras().getString("dob");
            Password = getIntent().getExtras().getString("password");
        }
    }

    private void init() {
        mobile = findViewById(R.id.otp_mobile);
        otp1 = findViewById(R.id.otp_pin_1);
        otp2 = findViewById(R.id.otp_pin_2);
        otp3 = findViewById(R.id.otp_pin_3);
        otp4 = findViewById(R.id.otp_pin_4);
        otp5 = findViewById(R.id.otp_pin_5);
        otp6 = findViewById(R.id.otp_pin_6);
        edit = findViewById(R.id.editNumber);
        invalidotp = findViewById(R.id.invalid_otp);
        verifyCard = findViewById(R.id.verify_card);
        verify = findViewById(R.id.verify);
        mobile.setText(PhoneNumber);
        otp1.addTextChangedListener(new EditTextWatcher(otp1));
        otp2.addTextChangedListener(new EditTextWatcher(otp2));
        otp3.addTextChangedListener(new EditTextWatcher(otp3));
        otp4.addTextChangedListener(new EditTextWatcher(otp4));
        otp5.addTextChangedListener(new EditTextWatcher(otp5));
        otp6.addTextChangedListener(new EditTextWatcher(otp6));
    }

    public void date(View view) {
        sendVerificationCodeOnNumber();
    }

    private void sendVerificationCodeOnNumber() {

        final ProgressDialog pd = new ProgressDialog(MiddlePhase.this);
        pd.setMessage("Sending OTP");
        pd.show();
        setContentView(R.layout.verification);
        init();

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                PhoneNumber,
                60L,
                TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);

                        VerificationID = s;
                        token = forceResendingToken;
                        pd.dismiss();
                        Toast.makeText(MiddlePhase.this,
                                "Code is sent to your Mobile Number",
                                Toast.LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void onCodeAutoRetrievalTimeOut(@NonNull String s) {
                        super.onCodeAutoRetrievalTimeOut(s);
                        pd.dismiss();
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        pd.dismiss();
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        pd.dismiss();
                        StyleableToast.makeText(MiddlePhase.this,
                                e.getMessage(),
                                R.style.errorToast)
                                .show();
                    }
                }
        );
    }

    public void matrimony(View view) {
    }

    public class EditTextWatcher implements TextWatcher {

        View view;

        public EditTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            invalidotp.setVisibility(View.GONE);

            String text = editable.toString();
            switch (view.getId()) {
                case R.id.otp_pin_1:
                    if (text.length() == 1) {
                        otp2.requestFocus();
                    }
                    break;
                case R.id.otp_pin_2:
                    if (text.length() == 1) {
                        otp3.requestFocus();
                    } else {
                        otp1.requestFocus();
                    }
                    break;
                case R.id.otp_pin_3:
                    if (text.length() == 1) {
                        otp4.requestFocus();
                    } else {
                        otp2.requestFocus();
                    }
                    break;
                case R.id.otp_pin_4:
                    if (text.length() == 1) {
                        otp5.requestFocus();
                    } else {
                        otp3.requestFocus();
                    }
                    break;
                case R.id.otp_pin_5:
                    if (text.length() == 1) {
                        otp6.requestFocus();
                    } else {
                        otp4.requestFocus();
                    }
                    break;
                case R.id.otp_pin_6:
                    if (text.length() != 1) {
                        otp5.requestFocus();
                    }
                    break;
                default:
                    break;
            }

            if (getOTP() != null && getOTP().length() == 6) {
                verify.setEnabled(true);
                verifyCard.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
            } else {
                verify.setEnabled(false);
                verifyCard.setCardBackgroundColor(getResources().getColor(R.color.grey));
            }
        }
    }

    public String getOTP() {
        enteredOTP = otp1.getText().toString() + otp2.getText().toString() + otp3.getText().toString() + otp4.getText().toString() + otp5.getText().toString() + otp6.getText().toString();
        return enteredOTP;
    }

    public void verifyAccount(View view) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(VerificationID, enteredOTP);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {

        final ProgressDialog pd = new ProgressDialog(MiddlePhase.this);
        pd.setMessage("Checking code");
        pd.show();

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            pd.setMessage("Creating account");
                            FirebaseUser me = firebaseAuth.getCurrentUser();
                            assert me != null;
                            final String myID = me.getUid();
                            me.updatePassword(Password)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            DatabaseReference storedata = FirebaseDatabase.getInstance().getReference("All_Users").child(myID);

                                            HashMap<String, String> hashMap = new HashMap<>();
                                            hashMap.put("Fullname", Fullname);
                                            hashMap.put("Email", Email);
                                            hashMap.put("Phone_Number", PhoneNumber);
                                            hashMap.put("DOB", DOB);

                                            storedata.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    pd.dismiss();
                                                    startActivity(new Intent(MiddlePhase.this, DHome.class));
                                                }
                                            });
                                        }
                                    });
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                pd.dismiss();
                                Toast.makeText(MiddlePhase.this,
                                        "Incorrect Code",
                                        Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }
                    }
                });
    }

    public void resendCode(View view) {
    }

    public void editNumber(View view) {
    }


}
