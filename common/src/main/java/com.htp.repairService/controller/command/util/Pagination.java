package com.htp.repairService.controller.command.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Pagination<T> {

    private static final String PAGING_NOWPAGE = "nowPage";
    private static final String START_INDEX = "pageStart";
    private static final String PAGE_LIST_ATTRIBUTE = "pageItems";
    private static final String TOTAL_PAGES = "totalPages";
    private static final String PAGE_NUMBERS_ATTRIBUTE = "pageList";
    private static final String DEFAULT_PAGE_POSITION_CURSOR = "defaultPageCursorPosition";
    private static final int RESULT_PAGE_SIZE = 3;
    private static final int PAGE_GROUP_NUMBER_SIZE = 10;
    private static final int CURSOR_POSITION = 3;

    private Pagination() {}

    public static Pagination getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * Method converts List to the array elements for further calculation of pages and records on
     * a particular page. The session put the current page number, the number of initial element for a particular page
     * pagination, sub-list of all the records, the total number of pages in the list pagination. method calls paginator
     * class to get a list of page numbers pagination.
     *
     * @param request HttpServletRequest
     * @param resultList List of nodes for pagination
     */
    public void paging(HttpServletRequest request, List<T> resultList) {

        HttpSession session = request.getSession();
        if(!session.getAttributeNames().hasMoreElements()){
            return;
        }

        T[] testArray = (T[]) resultList.toArray();
        resultList.toArray(testArray);
        String currentPage =  request.getParameter(PAGING_NOWPAGE);

        int currentNumberPage;
        if(currentPage != null) {
            currentNumberPage = Integer.parseInt(currentPage);
        } else {
            currentNumberPage = 0;
        }

        request.getSession().setAttribute(PAGING_NOWPAGE, currentPage);
        int totalBankObjects = testArray.length;
        int startIndex = currentNumberPage * RESULT_PAGE_SIZE;
        request.getSession().setAttribute(START_INDEX, startIndex + 1);

        int maxResultIndex = Math.min(totalBankObjects, startIndex + RESULT_PAGE_SIZE);
        List<T> pageItems = new ArrayList<>();
        for (int i = currentNumberPage * RESULT_PAGE_SIZE; i < maxResultIndex; i++) {
            pageItems.add(testArray[i]);
        }
        request.getSession().setAttribute(PAGE_LIST_ATTRIBUTE, pageItems);

        int totalPages = totalBankObjects / RESULT_PAGE_SIZE;
        if (totalBankObjects % RESULT_PAGE_SIZE > 0) {
            totalPages++;
        }

        request.getSession().setAttribute(TOTAL_PAGES, totalPages);
        request.getSession().setAttribute(DEFAULT_PAGE_POSITION_CURSOR,
                CURSOR_POSITION);

        List<Integer> pageList = Paginator.getList(totalBankObjects, currentNumberPage, RESULT_PAGE_SIZE, PAGE_GROUP_NUMBER_SIZE, CURSOR_POSITION);
        request.getSession().setAttribute(PAGE_NUMBERS_ATTRIBUTE, pageList);
    }

    private static class Paginator {

        private Paginator() {}

        public static List<Integer> getList(int totalItems, int currentPage,
                                            int resultPageSize, int pageGroupSize, int defaultCursorPosition) {
            List<Integer> pageList = new ArrayList<>();

            int finalPageItemStartIndex = (totalItems - totalItems % resultPageSize);
            if (totalItems % resultPageSize == 0) {
                finalPageItemStartIndex -= resultPageSize;
            }

            int finalPage = 0;
            if (finalPageItemStartIndex > 0) {
                finalPage = 1 + (int) Math.ceil((double) finalPageItemStartIndex
                        / resultPageSize);
            }
            int offset = pageGroupSize;
            if (currentPage > defaultCursorPosition) {
                offset -= defaultCursorPosition;
            } else {
                offset -=  Math.min(pageGroupSize, currentPage);
            }
            int endPage = Math.min(finalPage, currentPage + offset);
            int startPage = 0;
            if (currentPage > defaultCursorPosition && finalPage >= endPage) {
                startPage = Math.max(1, endPage - pageGroupSize + 1);
                pageList.add(0);
            }
            for (int i = startPage; i < endPage; i++) {
                pageList.add(i);
            }
            return pageList;
        }
    }
    private static class SingletonHolder {
        private static final Pagination INSTANCE = new Pagination<>();
    }
}