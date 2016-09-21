package com.example.android.justjava;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*TextView tv = new TextView(this);
        tv.setText("Hi everyone!");
        tv.setTextSize(56);
        tv.setTextColor(Color.GREEN);
        tv.setMaxLines(2 );

        setContentView(tv);*/
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        CheckBox whipped = (CheckBox) findViewById(R.id.whipped_cream);
        boolean hasWhippedCream = whipped.isChecked();

        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_topping);
        boolean hasChocolate = chocolate.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);

        String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
        String subject = "JustJava order for " + name;

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Calculates the price of the order.
     *
     * @param hasWhippedCream if whipped cream is checked
     * @param hasChocolate if chocolate is checked
     * @return the total price
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int price = 5;

        if (hasWhippedCream) {
            price += 1;
        }
        if (hasChocolate) {
            price += 2;
        }

        return quantity * price;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * Creates order summary
     * @param name the name
     * @param price calculated price
     * @param whippedCream if whipped cream was checked
     * @param chocolate if chocolate was checked
     * @return order summary
     */
    private String createOrderSummary(String name, int price, boolean whippedCream, boolean chocolate) {
        return("Name: "
                + name
                + "\nQuantity: "
                + quantity
                + "\nTotal: $"
                + price
                + "\nWhipped cream? "
                + whippedCream
                + "\nChocolate? "
                + chocolate
                + "\n"
                + getString(R.string.thank_you));
    }

    /**
     * Called when the + button is pressed.
     */
    public void increment(View view) {
        if (quantity < 100) {
            quantity = quantity + 1;
            display(quantity);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "You can't order more than 100 coffees!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    /**
     * Called when the - button is pressed.
     */
    public void decrement(View view) {
        if (quantity > 1) {
            quantity = quantity - 1;
            display(quantity);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "You can't order less than one coffee!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
