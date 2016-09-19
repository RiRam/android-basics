package com.example.android.pokescore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * This code counts prizes for a standard match of the Pokemon Trading Card Game.
 * In a standard match, each player starts with 6 prizes, and takes one each time they knock
 * out an opponent's Pokemon. In certain cases (such as knocking out a Pokemon EX), the player may
 * take two prizes.
 */
public class MainActivity extends AppCompatActivity {

    int numPrizes1 = 6;
    int numPrizes2 = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the number of prizes for player 1.
     */
    public void displayPlayer1(int prizes) {
        TextView scoreView = (TextView) findViewById(R.id.player_1_score);
        scoreView.setText(String.valueOf(prizes));
    }

    /**
     * Displays the number of prizes for player 2.
     */
    public void displayPlayer2(int prizes) {
        TextView scoreView = (TextView) findViewById(R.id.player_2_score);
        scoreView.setText(String.valueOf(prizes));
    }

    /**
     * Displays text for when a player wins.
     */
    public void displayWinText(String winner) {
        TextView scoreView = (TextView) findViewById(R.id.win_text);
        scoreView.setText(String.valueOf(winner));
    }

    /**
     * Deducts one prize from Player 1's prizes.
     * Calls method to print win text if Player 1 has 0 prizes left.
     */
    public void takeOnePrizePlayer1(View v) {
        if(numPrizes1 > 1) {
            numPrizes1--;
            displayPlayer1(numPrizes1);
        }
        else {      // condition if player 1 only has 1 prize left, therefore is going to win
            displayPlayer1(0);
            displayWinText("Player 1 wins!");
        }
    }

    /**
     * Deducts one prize from Player 2's prizes.
     * Calls method to print win text if Player 1 has 0 prizes left.
     */
    public void takeOnePrizePlayer2(View v) {
        if(numPrizes2 > 1) {
            numPrizes2--;
            displayPlayer2(numPrizes2);
        }
        else {      // condition if player 2 only has 1 prize left, therefore is going to win
            displayPlayer2(0);
            displayWinText("Player 2 wins!");
        }
    }

    /**
     * Deducts two prizes from Player 1's prizes.
     * Calls method to print win text if Player 1 has 0 prizes left.
     */
    public void takeTwoPrizesPlayer1(View v) {
        if(numPrizes1 > 2) {
            numPrizes1 = numPrizes1 - 2;
            displayPlayer1(numPrizes1);
        }
        else {      // condition if player 1 only has 2 prizes left, therefore is going to win
            displayPlayer1(0);
            displayWinText("Player 1 wins!");
            toggleButtons(false);
        }
    }

    /**
     * Deducts two prizes from Player 2's prizes.
     * Calls method to print win text if Player 2 has 0 prizes left.
     */
    public void takeTwoPrizesPlayer2(View v) {
        if(numPrizes2 > 2) {
            numPrizes2 = numPrizes2 - 2;
            displayPlayer2(numPrizes2);
        }
        else {      // condition if player 1 only has 2 prizes left, therefore is going to win
            displayPlayer2(0);
            displayWinText("Player 2 wins!");
            toggleButtons(false);
        }
    }

    /**
     * Toggles prize buttons when a player wins or resets, so that prize counts cannot be changed
     * after a player has won, and then to reenable the buttons after resetting the values.
     */
    public void toggleButtons(boolean enabled) {
        Button onePrize1 = (Button) findViewById(R.id.take_one_player_1);
        Button twoPrizes1 = (Button) findViewById(R.id.take_two_player_1);
        Button onePrize2 = (Button) findViewById(R.id.take_one_player_2);
        Button twoPrizes2 = (Button) findViewById(R.id.take_two_player_2);

        onePrize1.setEnabled(enabled);
        twoPrizes1.setEnabled(enabled);
        onePrize2.setEnabled(enabled);
        twoPrizes2.setEnabled(enabled);
    }

    /**
     * Resets the number of prizes for each player and the display to the default.
     */
    public void reset(View v) {
        numPrizes1 = 6;
        numPrizes2 = 6;
        displayPlayer1(numPrizes1);
        displayPlayer2(numPrizes2);
        toggleButtons(true);
        displayWinText("");
    }
}
