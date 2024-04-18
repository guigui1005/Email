package vieira.guilherme.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnviar = (Button) findViewById(R.id.btnEnviar); // Ação do botão
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etEmail = (EditText) findViewById(R.id.etEmail); //Campo EditText de id etEmail
                String email = etEmail.getText().toString(); //Valor digitado pelo usuário

                EditText etAssunto = (EditText) findViewById(R.id.etAssunto); // Campo EditText de id etAssunto
                String assunto = etAssunto.getText().toString(); //Valor digitado pelo usuário

                EditText etTexto = (EditText) findViewById(R.id.etTexto); //Campo EditText de id etTexto
                String texto = etTexto.getText().toString(); //Valor digitado pelo usuário

                Intent i = new Intent(Intent.ACTION_SENDTO); //Intent de enviar
                i.setData(Uri.parse("mailto:")); // URI para e-mail

                String[] emails = new String[]{email};
                i.putExtra(Intent.EXTRA_EMAIL, emails); // Campo de email
                i.putExtra(Intent.EXTRA_SUBJECT, assunto); //Campo do assunto
                i.putExtra(Intent.EXTRA_TEXT, texto); //campo de texto

                try { //Executa o Intent chamado dentro do try
                    startActivity(Intent.createChooser(i, "Escolha o APP")); //Escolha do APP

                }

                catch (ActivityNotFoundException e) {Toast.makeText(MainActivity.this, //Quando não tem app para email
                        "Não há nenhum app que posso realizar essa operação", Toast.LENGTH_LONG).show(); //Mensagem de aviso
                }






            }
        });
    }
}