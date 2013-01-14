package com.taig.pmc.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

class DonutHelper extends PopupMenuCompat
{
	private DialogMenu menu;

	private AlertDialog.Builder builder;

	private AlertDialog dialog;

	private OnMenuItemClickListener menuItemClickListener;

	public DonutHelper( Context context )
	{
		super( context );
		this.menu = new DialogMenu( context );
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
		return new MenuInflater( getContext() );
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
		List<MenuItem> items = menu.getItems();
		CharSequence[] titles = new String[items.size()];

		for( MenuItem item : items )
		{
			titles[item.getOrder()] = item.getTitle();
		}

		builder.setItems( titles, new DialogInterface.OnClickListener()
		{
			@Override
			public void onClick( DialogInterface dialog, int which )
			{
				if( menuItemClickListener != null )
				{
					menuItemClickListener.onMenuItemClick( menu.getItem( which ) );
				}
			}
		} );

		dialog = builder.show();
		dialog.setCanceledOnTouchOutside( true );
	}
}