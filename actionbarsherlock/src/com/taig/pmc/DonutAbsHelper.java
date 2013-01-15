package com.taig.pmc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;

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
		CharSequence[] titles = new String[menu.size()];

		for( int i = 0; i < menu.size(); i++ )
		{
			titles[i] = menu.getItem( i ).getTitle();
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