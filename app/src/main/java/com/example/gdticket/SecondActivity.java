package com.example.gdticket;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    //содание полей для вывода на экран нужных значений
    private Ticket ticket; //поле сущности билета
    private TextView textView; // поле вывода информации по заказу
    private Button button1;// поле кнопки

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.textView);
        // привязка id к полю (кнопки)
        button1 = findViewById(R.id.button1);
        // считывание данных из главной активиити
        Bundle bundleIntent = getIntent().getExtras();
        if (bundleIntent !=null){ // если в даном контейнере что-то есть, то
            // инициализируем поле сущности билета
            ticket =(Ticket) bundleIntent.getSerializable(Ticket.class.getSimpleName());
        }
        // вывод на экран
        textView.setText("ФИО:  "+ticket.getNameUser()+"\n"+"Пунк1:  "+ticket.getDeparturePoint()+"  Отправление:  "+ticket.getDepartureDate()+"\n"
        +"Пункт2:  "+ticket.getArrivalPoint()+"  Прибытие:  "+ticket.getArrivalDate());

        //обработка нажтия
        button1.setOnClickListener(listener);
    }
    // создание слушателя
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // переключение на другой экран
            Intent intent = new Intent(getApplicationContext(),MainActivity.class); // создание намерения переключения
            startActivity(intent);//запуск активити
        }
        // считывание данных с экрана

    };
}