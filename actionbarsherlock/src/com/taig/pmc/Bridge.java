package com.taig.pmc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.*;

abstract class Bridge
{
	public static abstract class Android
	{
		public static class Menu implements android.view.Menu
		{
			private com.actionbarsherlock.view.Menu menu;

			public Menu( com.actionbarsherlock.view.Menu menu )
			{
				this.menu = menu;
			}

			@Override
			public android.view.MenuItem add( CharSequence title )
			{
				return new MenuItem( menu.add( title ) );
			}

			@Override
			public android.view.MenuItem add( int titleRes )
			{
				return new MenuItem( menu.add( titleRes ) );
			}

			@Override
			public android.view.MenuItem add( int groupId, int itemId, int order, CharSequence title )
			{
				return new MenuItem( menu.add( groupId, itemId, order, title ) );
			}

			@Override
			public android.view.MenuItem add( int groupId, int itemId, int order, int titleRes )
			{
				return new MenuItem( menu.add( groupId, itemId, order, titleRes ) );
			}

			@Override
			public android.view.SubMenu addSubMenu( CharSequence title )
			{
				return null;
			}

			@Override
			public android.view.SubMenu addSubMenu( int titleRes )
			{
				return null;
			}

			@Override
			public android.view.SubMenu addSubMenu( int groupId, int itemId, int order, CharSequence title )
			{
				return null;
			}

			@Override
			public android.view.SubMenu addSubMenu( int groupId, int itemId, int order, int titleRes )
			{
				return null;
			}

			@Override
			public int addIntentOptions( int groupId, int itemId, int order, ComponentName caller, Intent[] specifics, Intent intent, int flags, android.view.MenuItem[] outSpecificItems )
			{
				return 0;
			}

			@Override
			public void removeItem( int id )
			{
				menu.removeItem( id );
			}

			@Override
			public void removeGroup( int groupId )
			{
				menu.removeGroup( groupId );
			}

			@Override
			public void clear()
			{
				menu.clear();
			}

			@Override
			public void setGroupCheckable( int group, boolean checkable, boolean exclusive )
			{
				menu.setGroupCheckable( group, checkable, exclusive );
			}

			@Override
			public void setGroupVisible( int group, boolean visible )
			{
				menu.setGroupVisible( group, visible );
			}

			@Override
			public void setGroupEnabled( int group, boolean enabled )
			{
				menu.setGroupEnabled( group, enabled );
			}

			@Override
			public boolean hasVisibleItems()
			{
				return menu.hasVisibleItems();
			}

			@Override
			public android.view.MenuItem findItem( int id )
			{
				return new MenuItem( menu.findItem( id ) );
			}

			@Override
			public int size()
			{
				return menu.size();
			}

			@Override
			public android.view.MenuItem getItem( int index )
			{
				return new MenuItem( menu.getItem( index ) );
			}

			@Override
			public void close()
			{
				menu.close();
			}

			@Override
			public boolean performShortcut( int keyCode, KeyEvent event, int flags )
			{
				return menu.performShortcut( keyCode, event, flags );
			}

			@Override
			public boolean isShortcutKey( int keyCode, KeyEvent event )
			{
				return menu.isShortcutKey( keyCode, event );
			}

			@Override
			public boolean performIdentifierAction( int id, int flags )
			{
				return menu.performIdentifierAction( id, flags );
			}

			@Override
			public void setQwertyMode( boolean isQwerty )
			{
				menu.setQwertyMode( isQwerty );
			}
		}

		public static class MenuItem implements android.view.MenuItem
		{
			private com.actionbarsherlock.view.MenuItem item;

			public MenuItem( com.actionbarsherlock.view.MenuItem item )
			{
				this.item = item;
			}

			@Override
			public int getItemId()
			{
				return item.getItemId();
			}

			@Override
			public int getGroupId()
			{
				return item.getGroupId();
			}

			@Override
			public int getOrder()
			{
				return item.getOrder();
			}

			@Override
			public MenuItem setTitle( CharSequence title )
			{
				item.setTitle( title );
				return this;
			}

			@Override
			public MenuItem setTitle( int title )
			{
				item.setTitle( title );
				return this;
			}

			@Override
			public CharSequence getTitle()
			{
				return item.getTitle();
			}

			@Override
			public MenuItem setTitleCondensed( CharSequence title )
			{
				item.setTitleCondensed( title );
				return this;
			}

			@Override
			public CharSequence getTitleCondensed()
			{
				return item.getTitleCondensed();
			}

			@Override
			public MenuItem setIcon( Drawable icon )
			{
				item.setIcon( icon );
				return this;
			}

			@Override
			public MenuItem setIcon( int iconRes )
			{
				item.setIcon( iconRes );
				return this;
			}

			@Override
			public Drawable getIcon()
			{
				return item.getIcon();
			}

			@Override
			public MenuItem setIntent( Intent intent )
			{
				item.setIntent( intent );
				return this;
			}

			@Override
			public Intent getIntent()
			{
				return item.getIntent();
			}

			@Override
			public MenuItem setShortcut( char numericChar, char alphaChar )
			{
				item.setShortcut( numericChar, alphaChar );
				return this;
			}

			@Override
			public MenuItem setNumericShortcut( char numericChar )
			{
				item.setNumericShortcut( numericChar );
				return this;
			}

			@Override
			public char getNumericShortcut()
			{
				return item.getNumericShortcut();
			}

			@Override
			public MenuItem setAlphabeticShortcut( char alphaChar )
			{
				item.setAlphabeticShortcut( alphaChar );
				return this;
			}

			@Override
			public char getAlphabeticShortcut()
			{
				return item.getAlphabeticShortcut();
			}

			@Override
			public MenuItem setCheckable( boolean checkable )
			{
				item.setCheckable( checkable );
				return this;
			}

			@Override
			public boolean isCheckable()
			{
				return item.isCheckable();
			}

			@Override
			public MenuItem setChecked( boolean checked )
			{
				item.setChecked( checked );
				return this;
			}

			@Override
			public boolean isChecked()
			{
				return item.isChecked();
			}

			@Override
			public MenuItem setVisible( boolean visible )
			{
				item.setVisible( isVisible() );
				return this;
			}

			@Override
			public boolean isVisible()
			{
				return item.isVisible();
			}

			@Override
			public MenuItem setEnabled( boolean enabled )
			{
				item.setEnabled( enabled );
				return this;
			}

			@Override
			public boolean isEnabled()
			{
				return item.isEnabled();
			}

			@Override
			public boolean hasSubMenu()
			{
				return false;
			}

			@Override
			public SubMenu getSubMenu()
			{
				return null;
			}

			@Override
			public MenuItem setOnMenuItemClickListener( final OnMenuItemClickListener menuItemClickListener )
			{
				item.setOnMenuItemClickListener( new com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener()
				{
					@Override
					public boolean onMenuItemClick( com.actionbarsherlock.view.MenuItem item )
					{
						return menuItemClickListener.onMenuItemClick( new MenuItem( item ) );
					}
				} );

				return this;
			}

			@Override
			public ContextMenu.ContextMenuInfo getMenuInfo()
			{
				return item.getMenuInfo();
			}

			@Override
			public void setShowAsAction( int actionEnum )
			{
				item.setShowAsAction( actionEnum );
			}

			@Override
			public MenuItem setShowAsActionFlags( int actionEnum )
			{
				item.setShowAsActionFlags( actionEnum );
				return this;
			}

			@Override
			public MenuItem setActionView( View view )
			{
				item.setActionView( view );
				return this;
			}

			@Override
			public MenuItem setActionView( int resId )
			{
				item.setActionView( resId );
				return this;
			}

			@Override
			public View getActionView()
			{
				return item.getActionView();
			}

			@Override
			public MenuItem setActionProvider( ActionProvider actionProvider )
			{
				return this;
			}

			@Override
			public ActionProvider getActionProvider()
			{
				return null;
			}

			@Override
			public boolean expandActionView()
			{
				return false;
			}

			@Override
			public boolean collapseActionView()
			{
				return false;
			}

			@Override
			public boolean isActionViewExpanded()
			{
				return false;
			}

			@Override
			public MenuItem setOnActionExpandListener( OnActionExpandListener listener )
			{
				return this;
			}
		}

		public static class MenuInflater extends android.view.MenuInflater
		{
			private com.actionbarsherlock.view.MenuInflater inflater;

			public MenuInflater( Context context, com.actionbarsherlock.view.MenuInflater inflater )
			{
				super( context );
				this.inflater = inflater;
			}

			@Override
			public void inflate( int menuRes, android.view.Menu menu )
			{
				inflater.inflate( menuRes, new ActionBarSherlock.Menu( menu ) );
			}
		}
	}

	public static abstract class ActionBarSherlock
	{
		public static class Menu implements com.actionbarsherlock.view.Menu
		{
			private android.view.Menu menu;

			public Menu( android.view.Menu menu )
			{
				this.menu = menu;
			}

			@Override
			public MenuItem add( CharSequence title )
			{
				return new MenuItem( menu.add( title ) );
			}

			@Override
			public MenuItem add( int titleRes )
			{
				return new MenuItem( menu.add( titleRes ) );
			}

			@Override
			public MenuItem add( int groupId, int itemId, int order, CharSequence title )
			{
				return new MenuItem( menu.add( groupId, itemId, order, title ) );
			}

			@Override
			public MenuItem add( int groupId, int itemId, int order, int titleRes )
			{
				return new MenuItem( menu.add( groupId, itemId, order, titleRes ) );
			}

			@Override
			public com.actionbarsherlock.view.SubMenu addSubMenu( CharSequence title )
			{
				return null;
			}

			@Override
			public com.actionbarsherlock.view.SubMenu addSubMenu( int titleRes )
			{
				return null;
			}

			@Override
			public com.actionbarsherlock.view.SubMenu addSubMenu( int groupId, int itemId, int order, CharSequence title )
			{
				return null;
			}

			@Override
			public com.actionbarsherlock.view.SubMenu addSubMenu( int groupId, int itemId, int order, int titleRes )
			{
				return null;
			}

			@Override
			public int addIntentOptions( int groupId, int itemId, int order, ComponentName caller, Intent[] specifics, Intent intent, int flags, com.actionbarsherlock.view.MenuItem[] outSpecificItems )
			{
				return 0;
			}

			@Override
			public void removeItem( int id )
			{
				menu.removeItem( id );
			}

			@Override
			public void removeGroup( int groupId )
			{
				menu.removeGroup( groupId );
			}

			@Override
			public void clear()
			{
				menu.clear();
			}

			@Override
			public void setGroupCheckable( int group, boolean checkable, boolean exclusive )
			{
				menu.setGroupCheckable( group, checkable, exclusive );
			}

			@Override
			public void setGroupVisible( int group, boolean visible )
			{
				menu.setGroupVisible( group, visible );
			}

			@Override
			public void setGroupEnabled( int group, boolean enabled )
			{
				menu.setGroupEnabled( group, enabled );
			}

			@Override
			public boolean hasVisibleItems()
			{
				return menu.hasVisibleItems();
			}

			@Override
			public MenuItem findItem( int id )
			{
				return new MenuItem( menu.findItem( id ) );
			}

			@Override
			public int size()
			{
				return menu.size();
			}

			@Override
			public MenuItem getItem( int index )
			{
				return new MenuItem( menu.getItem( index ) );
			}

			@Override
			public void close()
			{
				menu.close();
			}

			@Override
			public boolean performShortcut( int keyCode, KeyEvent event, int flags )
			{
				return menu.performShortcut( keyCode, event, flags );
			}

			@Override
			public boolean isShortcutKey( int keyCode, KeyEvent event )
			{
				return menu.isShortcutKey( keyCode, event );
			}

			@Override
			public boolean performIdentifierAction( int id, int flags )
			{
				return menu.performIdentifierAction( id, flags );
			}

			@Override
			public void setQwertyMode( boolean isQwerty )
			{
				menu.setQwertyMode( isQwerty );
			}
		}

		public static class MenuItem implements com.actionbarsherlock.view.MenuItem
		{
			private android.view.MenuItem item;

			public MenuItem( android.view.MenuItem item )
			{
				this.item = item;
			}

			@Override
			public int getItemId()
			{
				return item.getItemId();
			}

			@Override
			public int getGroupId()
			{
				return item.getGroupId();
			}

			@Override
			public int getOrder()
			{
				return item.getOrder();
			}

			@Override
			public MenuItem setTitle( CharSequence title )
			{
				item.setTitle( title );
				return this;
			}

			@Override
			public MenuItem setTitle( int title )
			{
				item.setTitle( title );
				return this;
			}

			@Override
			public CharSequence getTitle()
			{
				return item.getTitle();
			}

			@Override
			public MenuItem setTitleCondensed( CharSequence title )
			{
				item.setTitleCondensed( title );
				return this;
			}

			@Override
			public CharSequence getTitleCondensed()
			{
				return item.getTitleCondensed();
			}

			@Override
			public MenuItem setIcon( Drawable icon )
			{
				item.setIcon( icon );
				return this;
			}

			@Override
			public MenuItem setIcon( int iconRes )
			{
				item.setIcon( iconRes );
				return this;
			}

			@Override
			public Drawable getIcon()
			{
				return item.getIcon();
			}

			@Override
			public MenuItem setIntent( Intent intent )
			{
				item.setIntent( intent );
				return this;
			}

			@Override
			public Intent getIntent()
			{
				return item.getIntent();
			}

			@Override
			public MenuItem setShortcut( char numericChar, char alphaChar )
			{
				item.setShortcut( numericChar, alphaChar );
				return this;
			}

			@Override
			public MenuItem setNumericShortcut( char numericChar )
			{
				item.setNumericShortcut( numericChar );
				return this;
			}

			@Override
			public char getNumericShortcut()
			{
				return item.getNumericShortcut();
			}

			@Override
			public MenuItem setAlphabeticShortcut( char alphaChar )
			{
				item.setAlphabeticShortcut( alphaChar );
				return this;
			}

			@Override
			public char getAlphabeticShortcut()
			{
				return item.getAlphabeticShortcut();
			}

			@Override
			public MenuItem setCheckable( boolean checkable )
			{
				item.setCheckable( checkable );
				return this;
			}

			@Override
			public boolean isCheckable()
			{
				return item.isCheckable();
			}

			@Override
			public MenuItem setChecked( boolean checked )
			{
				item.setChecked( checked );
				return this;
			}

			@Override
			public boolean isChecked()
			{
				return item.isChecked();
			}

			@Override
			public MenuItem setVisible( boolean visible )
			{
				item.setVisible( isVisible() );
				return this;
			}

			@Override
			public boolean isVisible()
			{
				return item.isVisible();
			}

			@Override
			public MenuItem setEnabled( boolean enabled )
			{
				item.setEnabled( enabled );
				return this;
			}

			@Override
			public boolean isEnabled()
			{
				return item.isEnabled();
			}

			@Override
			public boolean hasSubMenu()
			{
				return false;
			}

			@Override
			public com.actionbarsherlock.view.SubMenu getSubMenu()
			{
				return null;
			}

			@Override
			public MenuItem setOnMenuItemClickListener( final OnMenuItemClickListener menuItemClickListener )
			{
				item.setOnMenuItemClickListener( new android.view.MenuItem.OnMenuItemClickListener()
				{
					@Override
					public boolean onMenuItemClick( android.view.MenuItem item )
					{
						return menuItemClickListener.onMenuItemClick( new MenuItem( item ) );
					}
				} );

				return this;
			}

			@Override
			public ContextMenu.ContextMenuInfo getMenuInfo()
			{
				return item.getMenuInfo();
			}

			@Override
			public void setShowAsAction( int actionEnum )
			{
				item.setShowAsAction( actionEnum );
			}

			@Override
			public MenuItem setShowAsActionFlags( int actionEnum )
			{
				item.setShowAsActionFlags( actionEnum );
				return this;
			}

			@Override
			public MenuItem setActionView( View view )
			{
				item.setActionView( view );
				return this;
			}

			@Override
			public MenuItem setActionView( int resId )
			{
				item.setActionView( resId );
				return this;
			}

			@Override
			public View getActionView()
			{
				return item.getActionView();
			}

			@Override
			public MenuItem setActionProvider( com.actionbarsherlock.view.ActionProvider actionProvider )
			{
				return this;
			}

			@Override
			public com.actionbarsherlock.view.ActionProvider getActionProvider()
			{
				return null;
			}

			@Override
			public boolean expandActionView()
			{
				return false;
			}

			@Override
			public boolean collapseActionView()
			{
				return false;
			}

			@Override
			public boolean isActionViewExpanded()
			{
				return false;
			}

			@Override
			public com.actionbarsherlock.view.MenuItem setOnActionExpandListener( OnActionExpandListener listener )
			{
				return null;
			}
		}

		public static class MenuInflater extends com.actionbarsherlock.view.MenuInflater
		{
			private android.view.MenuInflater inflater;

			public MenuInflater( Context context, android.view.MenuInflater inflater )
			{
				super( context );
				this.inflater = inflater;
			}

			@Override
			public void inflate( int menuRes, com.actionbarsherlock.view.Menu menu )
			{
				inflater.inflate( menuRes, new Android.Menu( menu ) );
			}
		}
	}
}
