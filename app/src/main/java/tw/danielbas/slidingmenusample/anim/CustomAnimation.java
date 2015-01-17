package tw.danielbas.slidingmenusample.anim;

import android.os.Bundle;
import android.view.Menu;

import tw.danielbas.slidingmenusample.BaseActivity;
import tw.danielbas.slidingmenusample.R;
import tw.danielbas.slidingmenusample.SampleListFragment;
import tw.danielbas.slidingmenusample.R.id;
import tw.danielbas.slidingmenusample.R.layout;
import tw.danielbas.slidingmenusample.R.menu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.CanvasTransformer;

public abstract class CustomAnimation extends BaseActivity {
	
	private CanvasTransformer mTransformer;
	
	public CustomAnimation(int titleRes, CanvasTransformer transformer) {
		super(titleRes);
		mTransformer = transformer;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// set the Above View
		setContentView(R.layout.content_frame);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.content_frame, new SampleListFragment())
		.commit();
		
		SlidingMenu sm = getSlidingMenu();
		setSlidingActionBarEnabled(true);
		sm.setBehindScrollScale(0.0f);
		sm.setBehindCanvasTransformer(mTransformer);
	}

}
