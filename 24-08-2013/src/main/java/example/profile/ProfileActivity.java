package example.profile;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends Activity {
    /************************** optional, declare constant *****************************/
    private static final int EDIT_PROFILE_REQUEST_CODE = 1111;
    public static final String NAME_EXTRA = "NAME";
    public static final String GENDER_EXTRA = "GENDER";
    public static final String AGE_EXTRA = "AGE";
    public static final String WEIGHT_EXTRA = "WEIGHT";
    public static final String HEIGHT_EXTRA = "HEIGHT";
    /***********************************************************************************/

    /************************** declare fields / variables *****************************/
    private TextView mUsernameTxt;
    private TextView mNameTxt;
    private TextView mGenderTxt;
    private TextView mAgeTxt;
    private TextView mWeightTxt;
    private TextView mHeightTxt;
    private Button mEditButton;
    /***********************************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        /******************** assign value / mapping objects & UI **********************/
        mUsernameTxt = (TextView) findViewById(R.id.username_txt);
        mNameTxt = (TextView) findViewById(R.id.name_txt);
        mGenderTxt = (TextView) findViewById(R.id.gender_txt);
        mAgeTxt = (TextView) findViewById(R.id.age_txt);
        mWeightTxt = (TextView) findViewById(R.id.weight_txt);
        mHeightTxt = (TextView) findViewById(R.id.height_txt);
        mEditButton = (Button) findViewById(R.id.edit_btn);
        /*******************************************************************************/

        /*********** get username from the intent and set it to text view **************/
        String usernameTxt = getIntent().getStringExtra(MainActivity.USERNAME_EXTRA);
        mUsernameTxt.setText(usernameTxt);
        /*******************************************************************************/

        /******************** add event & listeners to objects *************************/
        mEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* open edit activity and put the current info as extras */
                Intent editProfile = new Intent(ProfileActivity.this, EditActivity.class);
                editProfile.putExtra(NAME_EXTRA, mNameTxt.getText());
                editProfile.putExtra(GENDER_EXTRA, mGenderTxt.getText());
                editProfile.putExtra(AGE_EXTRA, mAgeTxt.getText());
                editProfile.putExtra(WEIGHT_EXTRA, mWeightTxt.getText());
                editProfile.putExtra(HEIGHT_EXTRA, mHeightTxt.getText());

                /* start edit activity and waiting for the result */
                startActivityForResult(editProfile, EDIT_PROFILE_REQUEST_CODE);
            }
        });
        /*******************************************************************************/
    }

    /*********** when edit activity finish, this method will be called ***************/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /* optional, check the request code & result code is correct */
        if (requestCode == EDIT_PROFILE_REQUEST_CODE && resultCode == RESULT_OK) {
            /* update new data to the profile */
            String name = data.getStringExtra(NAME_EXTRA);
            String gender = data.getStringExtra(GENDER_EXTRA);
            String age = data.getStringExtra(AGE_EXTRA);
            String weight = data.getStringExtra(WEIGHT_EXTRA);
            String height = data.getStringExtra(HEIGHT_EXTRA);

            mNameTxt.setText(name);
            mGenderTxt.setText(gender);
            mAgeTxt.setText(age);
            mWeightTxt.setText(weight);
            mHeightTxt.setText(height);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile, menu);
        return true;
    }
    
}
