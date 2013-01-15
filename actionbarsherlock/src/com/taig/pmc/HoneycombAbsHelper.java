package com.taig.pmc;

import android.content.Context;
import android.view.View;
import android.widget.PopupMenu;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;

class HoneycombAbsHelper extends PopupMenuAbs
{
	private PopupMenu menu;

	public HoneycombAbsHelper( Context context, View view )
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
		return new Bridge.ActionBarSherlock.Menu( menu.getMenu() );
	}

	@Override
	public MenuInflater getMenuInflater()
	{
		return new Bridge.ActionBarSherlock.MenuInflater( getContext(), menu.getMenuInflater() );
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
			public boolean onMenuItemClick( android.view.MenuItem item )
			{
				return menuItemClickListener.onMenuItemClick( new Bridge.ActionBarSherlock.MenuItem( item ) );
			}
		} );
	}

	@Override
	public void show()
	{
		menu.show();
	}
}