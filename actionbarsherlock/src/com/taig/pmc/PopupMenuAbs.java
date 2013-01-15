package com.taig.pmc;

import android.content.Context;
import android.os.Build;
import android.view.View;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;

public abstract class PopupMenuAbs extends AbstractPopupMenu<Menu, MenuInflater>
{
	protected PopupMenuAbs( Context context )
	{
		super( context );
	}

	public static PopupMenuAbs newInstance( Context context, View view )
	{
		if( Build.VERSION.SDK_INT >= 11 )
		{
			return new HoneycombAbsHelper( context, view );
		}
		else
		{
			return new DonutAbsHelper( context );
		}
	}
}