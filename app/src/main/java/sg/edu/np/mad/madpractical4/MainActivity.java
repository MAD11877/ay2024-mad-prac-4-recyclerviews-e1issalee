package sg.edu.np.mad.madpractical4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;



public class MainActivity extends AppCompatActivity {

    // Define the TAG variable at the class level
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Retrieve user data from the intent
        Intent receivingIntent = getIntent();
        String name = receivingIntent.getStringExtra("name");
        String description = receivingIntent.getStringExtra("description");

        // Initialize the User object with the passed data
        User user = new User(name, description, 1, false);

        // Get the TextViews and buttons from the layout
        TextView tvName = findViewById(R.id.textView); // Update to match the ID in your layout
        TextView tvDescription = findViewById(R.id.textView1); // Update to match the ID in your layout
        Button btnFollow = findViewById(R.id.button1);
        Button btnMessage = findViewById(R.id.button2);

        // Set the TextViews with the user's name, description and default button message
        tvName.setText(user.getName());
        tvDescription.setText(user.getDescription());
        btnFollow.setText("FOLLOW");

        // Set the click listener for the button
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check the current text of the button
                String buttonText = btnFollow.getText().toString();

                // Toggle between "Follow" and "Unfollow"
                if (buttonText.equals("Follow") || buttonText.equals("FOLLOW")) {
                    btnFollow.setText("Unfollow");
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                } else {
                    btnFollow.setText("Follow");
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the MessageGroup activity
                Intent intent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(intent);
            }
        });*/
    }
    private String generateRandomNumber() {
        Random generator = new Random();
        // Generate a random integer between 0 and 999998
        int randomNumber = generator.nextInt(999999);
        return String.valueOf(randomNumber);
    }

}