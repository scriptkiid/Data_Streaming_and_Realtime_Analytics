package lathia.accelerometercollector;

import android.content.Context;
import android.hardware.SensorEvent;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataWriter
{
    private File dataFile;
    private BufferedWriter writer;

    public DataWriter(final Context context, final String activity) throws IOException
    {
        try {

            dataFile = createFile(activity);
            FileWriter fw = new FileWriter(dataFile);
            writer = new BufferedWriter(fw);

        }catch (Exception e){
            Log.d("DataWriter", e.toString());
        }

        Log.d("DataWriter", "Writing to: "+dataFile.getAbsolutePath());
    }

    private File createFile(String activity)
    {
        File directory = new File(Environment.getExternalStorageDirectory(), "AccelerometerData");
        if (!directory.exists())
        {
            directory.mkdirs();
        }
        return new File(directory, activity + "_" + System.currentTimeMillis() + ".csv");
    }

    public void append(SensorEvent event) throws IOException
    {
        String row = getCurrentTimeStamp(); // + ":" + System.currentTimeMillis();
        for (int i=0; i<3; i++)
        {
            row += "," + event.values[i];
        }
        writer.write(row + "\n");

        final String finalRow = row;
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    //MainActivity.microgear.publish("Topictest", row);
                    URL url = new URL(MainActivity.URL);
                    HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                    httpCon.setDoOutput(true);
                    httpCon.setRequestMethod("PUT");
                    OutputStreamWriter out = new OutputStreamWriter(
                            httpCon.getOutputStream());
                    out.write(finalRow);
                    out.close();
                    httpCon.getInputStream();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();


        Log.i("DataWriter", row);
    }

    public static String getCurrentTimeStamp(){
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentDateTime = dateFormat.format(new Date()); // Find todays date

            return currentDateTime;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public void finish() throws IOException
    {
        writer.flush();
        writer.close();
    }
}
