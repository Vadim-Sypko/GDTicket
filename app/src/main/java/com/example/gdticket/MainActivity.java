package com.example.gdticket;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText nameUserIn; // поле User
    private EditText departurePointIn;
    private EditText departureDateIn;
    private EditText arrivalPointIn;
    private EditText arrivalDateIn;
    private Button button;
    private String nameUser;
    private String departurePoint;
    private String departureDate;
    private String arrivalPoint;
    private String arrivalDate;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {//создание жизненого цикла октивности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//присваивание жизненому циклу активити представление активити мэйн

        //присваивание переменным активити элемент представление activity_main
        button = findViewById(R.id.button);
        nameUserIn = findViewById(R.id.nameUserIn);
        departurePointIn = findViewById(R.id.departurePointIn);
        departureDateIn = findViewById(R.id.departureDateIn);
        arrivalPointIn = findViewById(R.id.arrivalPointIn);
        arrivalDateIn = findViewById(R.id.arrivalDateIn);

        // обработка нажатия кнопки
        button.setOnClickListener(listener);

    }
    // создание слушателя
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // переключение на другой экран

            // считывание данных с экрана
            nameUser = nameUserIn.getText().toString();
            departurePoint = departurePointIn.getText().toString();
            departureDate =departureDateIn.getText().toString();
            arrivalPoint = arrivalPointIn.getText().toString();
            arrivalDate = arrivalDateIn.getText().toString();

            //создаем объект сущности  билета
            Ticket ticket = new Ticket (nameUser,departurePoint,departureDate,arrivalPoint,arrivalDate,900);

            //создаем намерение переключение экрана и запакуем в него объект нашей сущности
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

            // запаковка данных в контейнер намерения
            intent.putExtra(Ticket.class.getSimpleName(), ticket);

            startActivity(intent); // запуск следующей активити через намерение
        }

    };
}