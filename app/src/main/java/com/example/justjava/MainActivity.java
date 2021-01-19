/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/
package com.example.justjava;


import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity= 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_check_box) ;
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        int price = calPrice(hasWhippedCream , hasChocolate );
        EditText enterName = (EditText) findViewById(R.id.name_edit_text_view);
        String nameEntered = enterName.getText().toString();
        String priceMessage = createOrderSummary(price , hasWhippedCream , hasChocolate , nameEntered) ;
        displayMessage(priceMessage);
    }
        private int calPrice(boolean addWhipCream , boolean addChocolate) {
        int basePrice = 5 ;
        if (addWhipCream) {
            basePrice = basePrice + 1 ;
        }
        if (addChocolate) {
            basePrice = basePrice + 2 ;
        }
            int price = quantity * basePrice ;
            return price ;
        }

    public void increment(View view) {
        if (quantity==100) {
            Toast.makeText(this,"You cannot have more than 100 coffees",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1 ;
        display(quantity);

    }
    public void decrement(View view) {
        if(quantity==0){
            Toast.makeText(this,"Not Possible",Toast.LENGTH_SHORT).show();
            return;
        }
        if (quantity == 1) {
            Toast.makeText(this,"You cannot have less than 1 coffee",Toast.LENGTH_SHORT).show();
            return;
        }

            quantity = quantity - 1;
            display(quantity);

    }

    private String createOrderSummary(int price , boolean addWhipCream , boolean addChocolate , String enterName ) {
        String priceMessage = "Name: " + enterName ;
        priceMessage += "\nAdd Whipped Cream ? " + addWhipCream ;
        priceMessage += "\nAdd Chocolate ? " + addChocolate ;
        priceMessage += "\nQuantity:" + quantity ;
        priceMessage += "\nTotal: $" + price ;
        priceMessage += "\nThankyou!" ;
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}