package in.balakrishnan.fragmentfactoryexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SampleFragmentFactory mFragmentFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentFactory = new SampleFragmentFactory();
        getSupportFragmentManager().setFragmentFactory(mFragmentFactory);

        // Usual method to replace fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameHolder, mFragmentFactory.instantiate(getClassLoader(), FormFragment.class.getName()))
                .addToBackStack(null).commit();
    }
}
