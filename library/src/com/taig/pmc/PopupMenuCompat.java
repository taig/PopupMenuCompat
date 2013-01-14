package com.taig.pmc;

import android.content.Context;
import android.os.Build;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class PopupMenuCompat
{
	/**
	 * Interface responsible for receiving menu item click events if the items themselves do not have individual item click listeners.
	 */
	public interface OnMenuItemClickListener
	{
		/**
		 * This method will be invoked when a menu item is clicked if the item itself did not already handle the event.
		 *
		 * @param item {@link MenuItem} that was clicked.
		 * @return <code>true</code> if the event was handled, <code>false</code> otherwise.
		 */
		public boolean onMenuItemClick( MenuItem item );
	}

	private Context context;

	protected PopupMenuCompat( Context context )
	{
		this.context = context;
	}

	/**
	 * Construct a new PopupMenu.
	 *
	 * @param context Context for the PopupMenu.
	 * @param view    Anchor view for this popup. The popup will appear below the anchor if there is room, or above it if there is not.
	 */
	public static PopupMenuCompat newInstance( Context context, View view )
	{
		if( Build.VERSION.SDK_INT >= 11 )
		{
			return new HoneycombHelper( context, view );
		}
		else
		{
			return new DonutHelper( context );
		}
	}

	public Context getContext()
	{
		return context;
	}

	/**
	 * Dismiss the menu popup.
	 *
	 * @see #show()
	 */
	public abstract void dismiss();

	/**
	 * @return The {@link Menu} associated with this popup. Populate the returned Menu with items before calling {@link #show()}.
	 * @see #show()
	 * @see #getMenuInflater()
	 */
	public abstract Menu getMenu();

	/**
	 * @return A {@link MenuInflater} that can be used to inflate menu items from XML into the menu returned by {@link #getMenu()}.
	 * @see #getMenu()
	 */
	public abstract MenuInflater getMenuInflater();

	/**
	 * Inflate a menu resource into this PopupMenu. This is equivalent to calling popupMenu.getMenuInflater().inflate(menuRes,
	 * popupMenu.getMenu()).
	 *
	 * @param menuResourceId The menu resource to inflate.
	 */
	public abstract void inflate( int menuResourceId );

	/**
	 * Set a listener that will be notified when the user selects an item from the menu.
	 *
	 * @param menuItemClickListener The listener to notify.
	 */
	public abstract void setOnMenuItemClickListener( final OnMenuItemClickListener menuItemClickListener );

	/**
	 * Show the menu popup anchored to the view specified during construction.
	 *
	 * @see #dismiss()
	 */
	public abstract void show();
}