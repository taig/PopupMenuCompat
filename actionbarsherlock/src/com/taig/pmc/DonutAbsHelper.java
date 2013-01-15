package com.taig.pmc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;

import java.util.ArrayList;
import java.util.List;

class DonutAbsHelper extends PopupMenuAbs
{
	private MenuBuilder menu;

	private AlertDialog.Builder builder;

	private AlertDialog dialog;

	private OnMenuItemClickListener menuItemClickListener;

	public DonutAbsHelper( Context context )
	{
		super( context );
		this.menu = new MenuBuilder( context );
		this.builder = new AlertDialog.Builder( context );
	}

	@Override
	public void dismiss()
	{
		if( dialog != null )
		{
			dialog.dismiss();
			dialog = null;
		}
	}

	@Override
	public Menu getMenu()
	{
		return menu;
	}

	@Override
	public MenuInflater getMenuInflater()
	{
		return new MenuInflater( getContext(), menu );
	}

	@Override
	public void inflate( int menuResourceId )
	{
		getMenuInflater().inflate( menuResourceId, getMenu() );
	}

	@Override
	public void setOnMenuItemClickListener( final OnMenuItemClickListener menuItemClickListener )
	{
		this.menuItemClickListener = menuItemClickListener;
	}

	@Override
	public void show()
	{
		List<CharSequence> titles = new ArrayList<CharSequence>();

		for( int i = 0; i < menu.size(); i++ )
		{
			com.actionbarsherlock.view.MenuItem item = menu.getItem( i );

			if( item.isEnabled() && item.isVisible() )
			{
				titles.add( item.getTitle() );
			}
		}

		builder.setItems( titles.toArray( new CharSequence[titles.size()] ), new DialogInterface.OnClickListener()
		{
			@Override
			public void onClick( DialogInterface dialog, int which )
			{
				MenuItemImpl item = (MenuItemImpl) menu.getItem( which );

				if( menuItemClickListener == null )
				{
					item.invoke();
				}
				else
				{
					menuItemClickListener.onMenuItemClick( item );
				}
			}
		} );

		dialog = builder.show();
		dialog.setCanceledOnTouchOutside( true );

		ListView view = dialog.getListView();
	}
}