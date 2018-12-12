package com.phimy.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.phimy.R;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {
    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private Button mFacebookBtn;
    private TextView textView;
    private ImageView imageView;
    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        AccessToken accessToken= AccessToken.getCurrentAccessToken();
        boolean isLogged = accessToken!=null && !accessToken.isExpired();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (isLogged && currentUser != null){
            cargarPerfil(currentUser);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        imageView=findViewById(R.id.imageView);
        textView=findViewById(R.id.textview);
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.login_buttonNF);
        loginButton.setVisibility(View.GONE);

        mFacebookBtn=(Button) findViewById(R.id.login_button);
        mFacebookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFacebookBtn.setEnabled(false);
                LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("email","public_profile"));
                LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        handleFacebookAccessToken(loginResult.getAccessToken());
                        //Toast.makeText(MainActivity.this, "exito", Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onCancel() {
                        Toast.makeText(LoginActivity.this, "cancel", Toast.LENGTH_LONG).show();
                        // App code
                    }
                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(LoginActivity.this, "error", Toast.LENGTH_LONG).show();
                        // App code
                    }
                });
            }
        });
        loginButton.setReadPermissions("email","public_profile" );
    }

    public void cargarPerfil(FirebaseUser user) {
        if (user != null) {
            Toast.makeText(LoginActivity.this, "cargando perfil", Toast.LENGTH_SHORT).show();
            Profile profile = Profile.getCurrentProfile();
            String firstName = profile.getFirstName();
            String lastName =  profile.getLastName();

            String email = user.getEmail();
            Uri photoUrl = profile.getProfilePictureUri(100,100);

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();

            user.getProviderData();

            Intent mainActivity = new Intent(LoginActivity.this, InicioActivity.class);
            startActivity(mainActivity);
            finish();

        }
    }


    private void handleFacebookAccessToken(AccessToken token) {

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(LoginActivity.this, "exito", Toast.LENGTH_LONG).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            mFacebookBtn.setEnabled(true);
                            cargarPerfil(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            mFacebookBtn.setEnabled(true);
                            cargarPerfil(null);
                        }

                    }
                });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
