package utn_dds.tp3;

import android.R;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


    public class MainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            findViewById(R.id.btnEjecutar).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new getMovimiento().execute();
                }
            });
        }


        private class getMovimiento extends AsyncTask<String, String, List<Movimiento>> {

            @Override
            protected List<Movimiento> doInBackground(String... params) {


                return Rest.makeGetRequest(
                        "http://localhost:8080/LaEvasion/rest/cuenta/1");
            }

            protected void onPostExecute(List<Movimiento> result) {

                findViewById(R.id.btnEjecutar).setVisibility(View.GONE);


                ArrayAdapter<Movimiento> adapter = new ArrayAdapter<Movimiento>(getApplicationContext(), R.layout.activity_listview, result);
                ListView listView = (ListView) findViewById(R.id.mobile_list);
                listView.setAdapter(adapter);

            }
        }
    }
}
