package com.htp.repairService.service;

/**
 * Created by user on 17.01.2019.
 */



import com.htp.repairService.domain.to.Faults;

import java.util.List;

/**
 * Created by user on 17.01.2019.
 */
/* Basic Service interface with template parameters.
        * @param <TO> generic type of objects passed to methods and can be returned
        * @param <VO> generic type of objects which will serve as a view object.
        * Provides create and viewAll operations with {@link TO} and {@link VO} objects.
        */


public interface GenericServiceInterface<T, V> {
    /** Method adding object in database and creates the appropriate entry there
     *
    * @param entity object necessary to adding in database
     * @return {@link T} object, that method can create
     * @throws ServiceException
     */
    Faults create(T entity) throws ServiceException;

    /** Method provides viewing all information and package this information in view object
     *
     * @return {@link T} object necessary for view all objects
     * @throws ServiceException
     */
    List<T> loadAll() throws ServiceException;





}