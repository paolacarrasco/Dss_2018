package utn_dds.tp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnEjecutar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MiAsyncTask().execute();
            }
        });
    }


private class MiAsyncTask extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... strings) {
        return RESTService.makeGetRequest(
                "https://jsonplaceholder.typicode.com/posts/1");
    }

    @Override
    protected void onPostExecute(String result) {
        Toast notificacion = Toast.makeText(
                getApplicationContext(), result, Toast.LENGTH_LONG);
        notificacion.show();
    }
}

    public static String callREST(String restURL, String method, JSONObject jsonParam){
        String result = "";

        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL( restURL );
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod( method );
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setFixedLengthStreamingMode(
                    jsonParam.toString().getBytes().length);

            urlConnection.setRequestProperty(
                    "Content-Type", "application/json;charset=utf-8");
            urlConnection.setRequestProperty("X-Requested-With", "XMLHttpRequest");

            urlConnection.connect();

            OutputStream os = new BufferedOutputStream(urlConnection.getOutputStream());
            os.write(jsonObject.toString().getBytes());
            os.flush();

            InputStream inputStream = urlConnection.getInputStream();

            BufferedReader bReader = new BufferedReader(
                    new InputStreamReader(inputStream, "utf-8"), 8);
            StringBuilder sBuilder = new StringBuilder();

            String line = null;
            while ((line = bReader.readLine()) != null) {
                sBuilder.append(line + "\n");
            }

            inputStream.close();

            result = sBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return e.getLocalizedMessage();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return result;
    }

    public static String makeGetRequest(String restURL){

        String result = "";
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL( restURL );
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();

            BufferedReader bReader = new BufferedReader(
                    new InputStreamReader(inputStream, "utf-8"), 8);
            StringBuilder sBuilder = new StringBuilder();

            String line = null;
            while ((line = bReader.readLine()) != null) {
                sBuilder.append(line + "\n");
            }
            inputStream.close();

            result = sBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return result;

    }
}