package com.taig.pmc;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

abstract class AbstractPopupMenu<M, MI>
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
		public <MI> boolean onMenuItemClick( MI item );
	}

	private Context context;

	protected AbstractPopupMenu( Context context )
	{
		this.context = context;
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
	public abstract M getMenu();

	/**
	 * @return A {@link MenuInflater} that can be used to inflate menu items from XML into the menu returned by {@link #getMenu()}.
	 * @see #getMenu()
	 */
	public abstract MI getMenuInflater();

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
