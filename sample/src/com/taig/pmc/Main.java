package com.taig.pmc;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Main extends Activity
{
	@Override
	public void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.main );

		// Launch popup-menu.
		findViewById( R.id.button ).setOnClickListener( new View.OnClickListener()
		{
			@Override
			public void onClick( View view )
			{
				PopupMenuCompat menu = PopupMenuCompat.newInstance( Main.this, view );
				menu.inflate( R.menu.main );
				menu.setOnMenuItemClickListener( new PopupMenuCompat.OnMenuItemClickListener()
				{
					@Override
					public boolean onMenuItemClick( MenuItem item )
					{
						Toast.makeText( Main.this, item.getTitle(), Toast.LENGTH_SHORT ).show();
						return true;
					}
				} );

				menu.show();
			}
		} );
	}
}