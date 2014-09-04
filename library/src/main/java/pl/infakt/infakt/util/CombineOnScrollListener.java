package pl.infakt.infakt.util;

import android.widget.AbsListView;

import java.util.ArrayList;

/**
 * Copyright Infakt Sp. z o.o.
 * Created by Rafal Ciurkot (rafal.ciurkot@infakt.pl) on 04.09.2014
 *
 * @author rciurkot
 */
public class CombineOnScrollListener implements AbsListView.OnScrollListener {
	private ArrayList<AbsListView.OnScrollListener> listeners = new ArrayList<AbsListView.OnScrollListener>();

	public CombineOnScrollListener(AbsListView.OnScrollListener... onScrollListeners) {
		for (AbsListView.OnScrollListener onScrollListener : onScrollListeners) {
			listeners.add(onScrollListener);
		}
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		for (AbsListView.OnScrollListener listener : listeners) {
			listener.onScrollStateChanged(view, scrollState);
		}
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		for (AbsListView.OnScrollListener listener : listeners) {
			listener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
		}
	}
}
