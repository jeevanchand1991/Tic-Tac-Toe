package com.fiserv.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class PlayerSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);
    }

    /**
     * submit name
     * @param view
     */
    public void submitName(View view) {
        EditText player1NameBox =  findViewById(R.id.player1);
        EditText player2NameBox =  findViewById(R.id.player2);
        EditText numberOfGames =   findViewById(R.id.numberOfG);
        String player1NameText =   player1NameBox.getText().toString();
        String player2NameText =   player2NameBox.getText().toString();
        String number = numberOfGames.getText().toString();

        if(number.length()>3){
            number="999";
            numberOfGames.setText(R.string.default_max_games);
        }
        if(number.equals("") || Integer.parseInt(number)<=0){
            numberOfGames.setText(R.string.default_min_games);
            number="1";
        }

        if(player1NameText.equals("")){
            player1NameText="Player 1";
            player1NameBox.setText(R.string.player_1_default_name);
        }
        if(player2NameText.equals("")){
            player2NameText="Player 2";
            player2NameBox.setText(R.string.player_2_default_name);
        }
        Intent intent = new Intent(this, StartGame.class);
        intent.putExtra("Player 1",player1NameText);
        intent.putExtra("Player 2",player2NameText);
        intent.putExtra("Number",number);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
            finish();
        }
    }
}
