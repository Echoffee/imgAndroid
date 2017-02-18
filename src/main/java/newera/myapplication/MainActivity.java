package newera.myapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import newera.myapplication.ui.system.SystemActionHandler;
import newera.myapplication.ui.system.PictureFileManager;
import newera.myapplication.ui.view.CImageView;
import newera.myapplication.ui.view.CircleMenu;
import newera.myapplication.ui.view.StartupView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //OnCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SystemActionHandler.setActivity(this);
        //PictureFileManager.CreatePictureFileFromCamera();
        //PictureFileManager.LoadPictureFromGallery();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CImageView civ = (CImageView) findViewById(R.id.cImageView);
                civ.setImage(PictureFileManager.RetrieveSavedPictureFromIntent());

            }
        });

        CircleMenu menu = (CircleMenu) findViewById(R.id.circleMenu);
        menu.setView((CImageView) findViewById(R.id.cImageView));
        menu.setActivity(this);
        menu.initialize();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        SystemActionHandler.handleActivityResult(requestCode, resultCode, data);
    }
}