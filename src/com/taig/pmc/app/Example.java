package com.taig.pmc.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.taig.pmc.R;
import com.taig.pmc.widget.PopupMenuCompat;

public class Example extends Activity
{
	@Override
	public void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.example );

		// Launch popup-menu.
		findViewById( R.id.button ).setOnClickListener( new View.OnClickListener()
		{
			@Override
			public void onClick( View view )
			{
				PopupMenuCompat menu = PopupMenuCompat.newInstance( Example.this, view );
				menu.inflate( R.menu.example );
				menu.setOnMenuItemClickListener( new PopupMenuCompat.OnMenuItemClickListener()
				{
					@Override
					public boolean onMenuItemClick( MenuItem item )
					{
						Toast.makeText( Example.this, item.getTitle(), Toast.LENGTH_SHORT ).show();
						return true;
					}
				} );

				menu.show();
			}
		} );
	}
}