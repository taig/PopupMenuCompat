package com.taig.pmc;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

class HoneycombHelper extends PopupMenuCompat
{
	private PopupMenu menu;

	public HoneycombHelper( Context context, View view )
	{
		super( context );
		this.menu = new PopupMenu( context, view );
	}

	@Override
	public void dismiss()
	{
		menu.dismiss();
	}

	@Override
	public Menu getMenu()
	{
		return menu.getMenu();
	}

	@Override
	public MenuInflater getMenuInflater()
	{
		return menu.getMenuInflater();
	}

	@Override
	public void inflate( int menuResourceId )
	{
		getMenuInflater().inflate( menuResourceId, getMenu() );
	}

	@Override
	public void setOnMenuItemClickListener( final OnMenuItemClickListener menuItemClickListener )
	{
		menu.setOnMenuItemClickListener( new PopupMenu.OnMenuItemClickListener()
		{
			@Override
			public boolean onMenuItemClick( MenuItem item )
			{
				return menuItemClickListener.onMenuItemClick( item );
			}
		} );
	}

	@Override
	public void show()
	{
		menu.show();
	}
}