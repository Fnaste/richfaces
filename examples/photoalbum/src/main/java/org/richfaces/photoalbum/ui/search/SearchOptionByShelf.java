/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.richfaces.photoalbum.ui.search;

import java.util.ArrayList;
import java.util.List;

import org.richfaces.photoalbum.model.Shelf;
import org.richfaces.photoalbum.search.ISearchAction;
import org.richfaces.photoalbum.util.PhotoAlbumException;

/**
 * Class, that encapsulate functionality related to search by shelf entity.
 *
 * @author Andrey Markavtsov
 *
 */
public class SearchOptionByShelf extends ISearchOption {

    private static final String TEMPLATE = "/includes/search/result/shelfResult.xhtml";
    private static final String SHELF_SEARCH_RESULT = "Album Group search result";
    private static final String SHELVES = "Album Groups";

    /*
     * (non-Javadoc)
     *
     * @see org.richfaces.photoalbum.search.ISearchOption#getName()
     */
    @Override
    public String getName() {
        return SHELVES;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.richfaces.photoalbum.search.ISearchOption#getSearchResultName()
     */
    @Override
    public String getSearchResultName() {
        return SHELF_SEARCH_RESULT;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.richfaces.photoalbum.search.ISearchOption#getSearchResultTemplate()
     */
    @Override
    public String getSearchResultTemplate() {
        return TEMPLATE;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.richfaces.photoalbum.search.ISearchOption#search(org.richfaces.photoalbum.service.ISearchAction,
     * java.lang.String, boolean, boolean)
     */
    @Override
    public void search(ISearchAction action, String searchQuery, boolean searchInMyAlbums, boolean searchInShared)
        throws PhotoAlbumException {
        List<Shelf> list = action.searchByShelves(searchQuery, searchInMyAlbums, searchInShared);
        if (list != null) {
            setSearchResult(list);
        } else {
            setSearchResult(new ArrayList<Shelf>());
        }
    }
}