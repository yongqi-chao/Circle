package chao.yongqi.apps.circle;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Map;

import chao.yongqi.apps.circle.dummy.DummyContent;

public class Home extends AppCompatActivity
                    implements NewsFragment.OnListFragmentInteractionListener{

    private TextView mTextMessage;
    private Bundle savedInstanceState1;
    private String mapTag;

    public void onListFragmentInteraction(DummyContent.DummyItem item){

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_map:
                    if(getSupportFragmentManager().getBackStackEntryCount() <= 0) {
                        createMapFrag();
                    }
                    else{
                        getSupportFragmentManager().popBackStack();
                    }

                    return true;
                case R.id.navigation_news:
                    NewsFragment news = new NewsFragment();

                    // In case this activity was started with special instructions from an Intent,
                    // pass the Intent's extras to the fragment as arguments
                    news.setArguments(getIntent().getExtras());

                    // Add the fragment to the 'fragment_container' FrameLayout
                    getSupportFragmentManager().beginTransaction()
                            //.setCustomAnimations()
                            .replace(R.id.content, news).addToBackStack(null).commit();

                    return true;
                case R.id.navigation_me:
                    //mTextMessage.setText(R.string.title_me);
                    return true;
                case R.id.navigation_chat:
                    //mTextMessage.setText(R.string.title_me);
                    return true;
                case R.id.navigation_more:
                    //mTextMessage.setText(R.string.title_me);
                    return true;

            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mOnNavigationItemSelectedListener.onNavigationItemSelected(navigation.getMenu().getItem(0));
    }


    private void createMapFrag(){
        MapFragment map = new MapFragment();
        // In case this activity was started with special instructions from an Intent,
        // pass the Intent's extras to the fragment as arguments
        map.setArguments(getIntent().getExtras());

        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.content, map).commit();

    }
}
