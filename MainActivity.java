package com.wordpress.keepup395.pro_chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    private static int SIGN_IN_REQUEST_CODE=1;
    private FirebaseListAdapter<chatmessage> adapter;
    RelativeLayout activity_main;
    FloatingActionButton fab;
    Intent intent = new Intent(this,Main2Activity.class);

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()== R.id.menu_sign_out)
        {
            AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Snackbar.make(activity_main,"you have been signed out",Snackbar.LENGTH_SHORT).show();
                finish();

                }
            });
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==SIGN_IN_REQUEST_CODE)
        {
            if (resultCode==RESULT_OK)
            {
                Snackbar.make(activity_main,"Successfully signed out",Snackbar.LENGTH_SHORT).show();
                startActivity(intent);
               // displayChatMessage();
            }
            else
            {
                Snackbar.make(activity_main,"we could not sign in your aaccount",Snackbar.LENGTH_SHORT).show();
                        finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity_main= (RelativeLayout)findViewById(R.id.activity_main);

        //fab=(FloatingActionButton)findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = (EditText)findViewById(R.id.input);
                FirebaseDatabase.getInstance().getReference().push().setValue(new chatmessage(input.getText().toString(),
                        FirebaseAuth.getInstance().getCurrentUser().getEmail()));
                input.setText("");
            }
        });*/

        if(FirebaseAuth.getInstance().getCurrentUser()==null)
        {
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(),SIGN_IN_REQUEST_CODE);


        }
        else
        {
            Snackbar.make(activity_main,"wellcome"+FirebaseAuth.getInstance().getCurrentUser().getEmail(),Snackbar.LENGTH_SHORT).show();

            startActivity(intent);
            //displayChatMessage();
        }
        //displayChatMessage();
    }
   /* private void displayChatMessage(){
        ListView listOfMessages = (ListView)findViewById(R.id.list_message);
        adapter = new FirebaseListAdapter<chatmessage>(this,chatmessage.class,R.layout.list_items,FirebaseDatabase.getInstance().getReference()) {
            @Override
            protected void populateView(View v, chatmessage model, int position) {
                TextView messageuser,messagetext,messagetime;
                messagetext = (TextView)v.findViewById(R.id.message_text);
                messageuser = (TextView)v.findViewById(R.id.message_user);
                messagetime = (TextView)v.findViewById(R.id.message_time);

                messagetext.setText(model.getMessagetext());
                messageuser.setText(model.getMessagetext());
                messagetime.setText(DateFormat.format("dd-mm-yyyy (HH:mm:ss)",model.getMessagetime()));

            }
        };*/

//listOfMessages.setAdapter(adapter);
    }
