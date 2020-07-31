/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity--;
        displayQuantity(quantity);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* This method is called when the order button is clicked.
            */
    public void submitOrder(View view) {
        int price = calculatePrice(quantity);
        String priceMassage = createOrderSummery(price);
        displayMassage(priceMassage);
        CheckBox cream = findViewById(R.id.checkBoxCream);
        if(cream.isChecked())
            displayCream("true");
        else displayCream("false");
        CheckBox chocolate = findViewById(R.id.checkBoxChocolate);
        if(chocolate.isChecked())
            displayChocolate("true");
        else displayChocolate("false");


    }

    public String createOrderSummery(int prise){
        return "Name: Kaptain Kunal" + "\nQuantity: 3" + "\nTotal: $" + prise + "\nThank you!";

    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity) {
        int price = quantity * 5;
        return price;
    }
    public void displayMassage (String message){
        TextView orderSummeryTextView = (TextView) findViewById(R.id.order_summery_text_view);
        orderSummeryTextView.setText(message);
    }
    /* This method displays the given quantity value on the screen.
            */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayCream(String s) {
        TextView textCteam = (TextView) findViewById(R.id.cream_text_view);
        textCteam.setText("Add whipped cream? " + s);
    }

    private void displayChocolate(String s) {
        TextView textCteam = (TextView) findViewById(R.id.chocolate_text_view);
        textCteam.setText("Add chocolate? " + s);
    }

}