package in.balakrishnan.fragmentfactoryexample;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

/**
 * Created by BalaKrishnan
 */
public class SampleFragmentFactory extends FragmentFactory {
    private static final String TAG = "SampleFragmentFactory";
    Fragment fragment = null;

    public SampleFragmentFactory() {
    }


    @NonNull
    @Override
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {
        Class clazz = loadFragmentClass(classLoader, className);
        if (fragment == null)
            if (clazz == FormFragment.class) {
                fragment = new FormFragment("Sample");
            } else {
                return super.instantiate(classLoader, className);
            }

        return fragment;
    }
}
