package com.adarsh.epeolatry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.adarsh.epeolatry.R;
import com.adarsh.epeolatry.ui.AccountFragment;
import com.adarsh.epeolatry.ui.CartFragment;
import com.adarsh.epeolatry.ui.ChatsFragment;
import com.adarsh.epeolatry.ui.HomeFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class BottomMain extends AppCompatActivity implements ChipNavigationBar.OnItemSelectedListener {

    private ChipNavigationBar navBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_main);

        setui();

        if(savedInstanceState == null)
        {
            navBar.setItemSelected(R.id.nav_home, true);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main_frame, new HomeFragment()).commit();
        }

        navBar.setOnItemSelectedListener(this);
    }

    private void setui(){
        navBar = (ChipNavigationBar) findViewById(R.id.main_nav);
    }

    @Override
    public void onItemSelected(int i) {
        Fragment fragment = null;
        switch (i){
            case R.id.nav_home:
                fragment = new HomeFragment();
            break;
            case R.id.nav_chat:
                fragment = new ChatsFragment();
            break;
            case R.id.nav_cart:
                fragment = new CartFragment();
                break;
            case R.id.nav_acc:
                fragment = new AccountFragment();
                break;
            default: break;
        }
        if(fragment!=null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main_frame, fragment).commit();
        }
    }
}
