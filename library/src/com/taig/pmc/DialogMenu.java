package com.taig.pmc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.*;

import java.util.ArrayList;
import java.util.List;

class DialogMenu implements Menu
{
	private Context context;

	private List<MenuItem> items = new ArrayList<MenuItem>();

	public DialogMenu( Context context )
	{
		this.context = context;
	}

	public List<MenuItem> getItems()
	{
		return items;
	}

	@Override
	public MenuItem add( CharSequence title )
	{
		return add( -1, -1, items.size(), title );
	}

	@Override
	public MenuItem add( int titleRes )
	{
		return add( -1, -1, items.size(), context.getString( titleRes ) );
	}

	@Override
	public MenuItem add( int groupId, int itemId, int order, CharSequence title )
	{
		DialogMenuItem item = new DialogMenuItem( itemId, title );

		if( order == NONE )
		{
			order = items.size() + 1;
		}

		items.add( order - 1, item );

		return item;
	}

	@Override
	public MenuItem add( int groupId, int itemId, int order, int titleRes )
	{
		return add( groupId, itemId, order, context.getString( titleRes ) );
	}

	@Override
	public SubMenu addSubMenu( CharSequence title )
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public SubMenu addSubMenu( int titleRes )
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public SubMenu addSubMenu( int groupId, int itemId, int order, CharSequence title )
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public SubMenu addSubMenu( int groupId, int itemId, int order, int titleRes )
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public int addIntentOptions( int groupId, int itemId, int order, ComponentName caller, Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems )
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeItem( int id )
	{
		items.remove( findItem( id ) );
	}

	@Override
	public void removeGroup( int groupId )
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear()
	{
		items.clear();
	}

	@Override
	public void setGroupCheckable( int group, boolean checkable, boolean exclusive )
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public void setGroupVisible( int group, boolean visible )
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public void setGroupEnabled( int group, boolean enabled )
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasVisibleItems()
	{
		for( MenuItem item : items )
		{
			if( item.isVisible() )
			{
				return true;
			}
		}

		return false;
	}

	@Override
	public MenuItem findItem( int id )
	{
		for( MenuItem item : items )
		{
			if( item.getItemId() == id )
			{
				return item;
			}
		}

		return null;
	}

	@Override
	public int size()
	{
		return items.size();
	}

	@Override
	public MenuItem getItem( int index )
	{
		return items.get( index );
	}

	@Override
	public void close()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean performShortcut( int keyCode, KeyEvent event, int flags )
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isShortcutKey( int keyCode, KeyEvent event )
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean performIdentifierAction( int id, int flags )
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public void setQwertyMode( boolean isQwerty )
	{
		throw new UnsupportedOperationException();
	}

	public class DialogMenuItem implements MenuItem
	{
		private int id;

		private CharSequence title;

		private CharSequence titleCondensed;

		private char alphabeticShortcut;

		private char numericShortcut;

		private boolean checkable;

		private boolean checked;

		private boolean visible;

		private boolean enabled;

		OnMenuItemClickListener menuItemClickListener;

		public DialogMenuItem( CharSequence title )
		{
			this( -1, title );
		}

		public DialogMenuItem( int id, CharSequence title )
		{
			this.id = id;
			this.title = title;
		}

		@Override
		public int getItemId()
		{
			return id;
		}

		@Override
		public int getGroupId()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public int getOrder()
		{
			return items.indexOf( this );
		}

		@Override
		public MenuItem setTitle( CharSequence title )
		{
			this.title = title;
			return this;
		}

		@Override
		public MenuItem setTitle( int title )
		{
			context.getString( title );
			return this;
		}

		@Override
		public CharSequence getTitle()
		{
			return title;
		}

		@Override
		public MenuItem setTitleCondensed( CharSequence title )
		{
			this.titleCondensed = title;
			return this;
		}

		@Override
		public CharSequence getTitleCondensed()
		{
			return titleCondensed;
		}

		@Override
		public MenuItem setIcon( Drawable icon )
		{
			return this;
		}

		@Override
		public MenuItem setIcon( int iconRes )
		{
			return this;
		}

		@Override
		public Drawable getIcon()
		{
			return null;
		}

		@Override
		public MenuItem setIntent( Intent intent )
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public Intent getIntent()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public MenuItem setShortcut( char numericChar, char alphaChar )
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public MenuItem setNumericShortcut( char numericChar )
		{
			this.numericShortcut = numericChar;
			return this;
		}

		@Override
		public char getNumericShortcut()
		{
			return numericShortcut;
		}

		@Override
		public MenuItem setAlphabeticShortcut( char alphaChar )
		{
			this.alphabeticShortcut = alphaChar;
			return this;
		}

		@Override
		public char getAlphabeticShortcut()
		{
			return alphabeticShortcut;
		}

		@Override
		public MenuItem setCheckable( boolean checkable )
		{
			this.checkable = checkable;
			return this;
		}

		@Override
		public boolean isCheckable()
		{
			return checkable;
		}

		@Override
		public MenuItem setChecked( boolean checked )
		{
			this.checked = checked;
			return this;
		}

		@Override
		public boolean isChecked()
		{
			return checked;
		}

		@Override
		public MenuItem setVisible( boolean visible )
		{
			this.visible = visible;
			return this;
		}

		@Override
		public boolean isVisible()
		{
			return visible;
		}

		@Override
		public MenuItem setEnabled( boolean enabled )
		{
			this.enabled = enabled;
			return this;
		}

		@Override
		public boolean isEnabled()
		{

			return enabled;
		}

		@Override
		public boolean hasSubMenu()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public SubMenu getSubMenu()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public MenuItem setOnMenuItemClickListener( OnMenuItemClickListener menuItemClickListener )
		{
			this.menuItemClickListener = menuItemClickListener;
			return this;
		}

		@Override
		public ContextMenu.ContextMenuInfo getMenuInfo()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public void setShowAsAction( int actionEnum )
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public MenuItem setShowAsActionFlags( int actionEnum )
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public MenuItem setActionView( View view )
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public MenuItem setActionView( int resId )
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public View getActionView()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public MenuItem setActionProvider( ActionProvider actionProvider )
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public ActionProvider getActionProvider()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean expandActionView()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean collapseActionView()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean isActionViewExpanded()
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public MenuItem setOnActionExpandListener( OnActionExpandListener listener )
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public String toString()
		{
			return title.toString();
		}
	}
}