package br.com.fabriciocurvello.app01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etPedido;
    TextView tvSaida;
    Button btEfetuarPedido;


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

        // "Linkando" objetos Java com componentes de tela (Views)
        etPedido = findViewById(R.id.et_pedido);
        tvSaida = findViewById(R.id.tv_saida);
        btEfetuarPedido = findViewById(R.id.bt_efetuar_pedido);

        // Listener para o botão
        btEfetuarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Capturar o dado inserido pelo usuário
                String pedido = etPedido.getText().toString();

                // Setar na caixa de texto o valor da variável pedido
                tvSaida.setText("Seu pedido: " + pedido);
            }
        });

    }
}