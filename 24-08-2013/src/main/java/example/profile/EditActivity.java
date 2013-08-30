package example.profile;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends Activity {
    /************************** declare fields / variables *****************************/
    private EditText mNameInput;
    private EditText mGenderInput;
    private EditText mAgeInput;
    private EditText mWeightInput;
    private EditText mHeightInput;
    private Button mSaveButton;
    private Button mCancelButton;
    /***********************************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        /******************** assign value / mapping objects & UI **********************/
        mNameInput = (EditText) findViewById(R.id.name_input);
        mGenderInput = (EditText) findViewById(R.id.gender_input);
        mAgeInput = (EditText) findViewById(R.id.age_input);
        mWeightInput = (EditText) findViewById(R.id.weight_input);
        mHeightInput = (EditText) findViewById(R.id.height_input);
        mSaveButton = (Button) findViewById(R.id.save_btn);
        mCancelButton = (Button) findViewById(R.id.cancel_btn);
        /*******************************************************************************/

        /************* get current data from intent, and set to the views **************/
        String name = getIntent().getStringExtra(ProfileActivity.NAME_EXTRA);
        String gender = getIntent().getStringExtra(ProfileActivity.GENDER_EXTRA);
        String age = getIntent().getStringExtra(ProfileActivity.AGE_EXTRA);
        String weight = getIntent().getStringExtra(ProfileActivity.WEIGHT_EXTRA);
        String height = getIntent().getStringExtra(ProfileActivity.HEIGHT_EXTRA);

        mNameInput.setText(name);
        mGenderInput.setText(gender);
        mAgeInput.setText(age);
        mWeightInput.setText(weight);
        mHeightInput.setText(height);
        /*******************************************************************************/

        /******************** add event & listeners to objects *************************/
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* back and put new data as extras, to update the profile */
                Intent updateData = new Intent();
                updateData.putExtra(ProfileActivity.NAME_EXTRA, mNameInput.getText().toString());
                updateData.putExtra(ProfileActivity.GENDER_EXTRA, mGenderInput.getText().toString());
                updateData.putExtra(ProfileActivity.AGE_EXTRA, mAgeInput.getText().toString());
                updateData.putExtra(ProfileActivity.WEIGHT_EXTRA, mWeightInput.getText().toString());
                updateData.putExtra(ProfileActivity.HEIGHT_EXTRA, mHeightInput.getText().toString());
                setResult(RESULT_OK, updateData);
                finish();
            }
        });

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* back to profile and not do anything when click cancel */
                finish();
            }
        });
        /*******************************************************************************/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit, menu);
        return true;
    }
    
}
