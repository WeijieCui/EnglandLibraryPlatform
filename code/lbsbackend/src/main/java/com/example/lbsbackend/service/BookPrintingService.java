package com.example.lbsbackend.service;

import com.example.lbsbackend.entity.BookPrinting;
import com.example.lbsbackend.enumable.BookPrintingStatus;
import com.example.lbsbackend.util.page.PageRequest;
import com.example.lbsbackend.util.page.PageResult;

import java.util.List;

/**
 * BookPrintingService
 *
 * @description: book printing service
 */
public interface BookPrintingService {
    /**
     * query book printings
     *
     * @description: query book printings
     * @param: Long libraryId, Long bookId, PageRequest pageRequest
     * @return: PageResult
     */
    PageResult queryBookPrintings(Long libraryId, Long bookId, PageRequest pageRequest);
    /**
     * queryBookPrintingDetail
     *
     * @description: queryBookPrintingDetail
     * @param: Long id
     * @return: BookPrinting
     */
    BookPrinting queryBookPrintingDetail(Long id);

    /**
     * query book printings by ids
     *
     * @description: query book printings by ids
     * @param: List<Long> ids, PageRequest pageRequest
     * @return: List<BookPrinting>
     */
    List<BookPrinting> queryBookPrintingByIds(List<Long> ids);

    /**
     * batch add book printings
     *
     * @description: batch add book printings
     * @param: List<BookPrinting> bookPrintings
     * @return: success
     */
    Boolean addBookPrintings(List<BookPrinting> bookPrintings);

    /**
     * batch delete book printings
     *
     * @description: batch delete book printings
     * @param: List<Long> ids
     * @return: success
     */
    Boolean deleteBookPrintings(List<Long> ids);

    /**
     * updateStatusByIds
     *
     * @description: updateStatusByIds
     * @param: List<Long> filteredPrintingIds, BookPrintingStatus status
     * @return: success
     */
    void updateStatusByIds(List<Long> filteredPrintingIds, BookPrintingStatus status);
}
