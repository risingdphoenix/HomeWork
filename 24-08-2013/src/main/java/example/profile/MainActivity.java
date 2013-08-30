package example.profile;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    /************************** optional, declare constant *****************************/
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";
    public static final String USERNAME_EXTRA = "USERNAME";
    /***********************************************************************************/

    /************************** declare fields / variables *****************************/
    private EditText mUsernameInput;
    private EditText mPasswordInput;
    private Button mLoginButton;
    /***********************************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /******************** assign value / mapping objects & UI **********************/
        mUsernameInput = (EditText) findViewById(R.id.username_input);
        mPasswordInput = (EditText) findViewById(R.id.password_input);
        mLoginButton = (Button) findViewById(R.id.login_btn);
        /*******************************************************************************/

        /******************** add event & listeners to objects *************************/
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**************************************************
                 * when user click login button,
                 * check the username & password
                 * if correct, open profile activity
                 **************************************************/
                String username = mUsernameInput.getText().toString();
                String password = mPasswordInput.getText().toString();

                if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                    /* username & password is correct, open profile activity */
                    Intent openProfile = new Intent(MainActivity.this, ProfileActivity.class);
                    /* put username extra to display in profile page */
                    openProfile.putExtra(USERNAME_EXTRA, username);

                    startActivity(openProfile);

                    /* optional, finish this activity, prevent user click back to the first page */
                    finish();
                } else {
                    /* optional, alert username or password is not correct */
                    Toast.makeText(MainActivity.this, "Username or Password is not correct", Toast.LENGTH_SHORT).show();
                }
            }
        });
        /*******************************************************************************/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
