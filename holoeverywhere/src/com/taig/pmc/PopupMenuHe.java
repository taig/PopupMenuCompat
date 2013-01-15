package com.taig.pmc;

import android.content.Context;
import android.os.Build;
import android.view.View;

public abstract class PopupMenuHe extends PopupMenuAbs
{
	protected PopupMenuHe( Context context )
	{
		super( context );
	}

	public static PopupMenuAbs newInstance( Context context, View view )
	{
		if( Build.VERSION.SDK_INT >= 11 )
		{
			return PopupMenuAbs.newInstance( context, view );
		}
		else
		{
			return new DonutHeHelper( context );
		}
	}
}